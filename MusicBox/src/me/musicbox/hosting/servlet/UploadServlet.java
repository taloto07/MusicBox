package me.musicbox.hosting.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;

public class UploadServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
    
    public UploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestProccess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestProccess(request, response);
	}
	
	private void requestProccess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("UTF-8");
		
		// Get PrintWriter to write back to client
		PrintWriter out = response.getWriter();
		
		// Get contextPath for any external files such as css, js path
		String contextPath = getContextPath(); 
		
		// gets absolute path of the web application
		String applicationPath = this.getServletContext().getRealPath("");
		
		// constructs path of the directory to save uploaded file
		String uploadFilePath = applicationPath + File.separator + "upload";
		
		// creates the save directory if it does not exists
		File fileSaveDir = new File(uploadFilePath);
		if (!fileSaveDir.exists()){
			fileSaveDir.mkdir();
		}
		
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if (isMultipart){
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setRepository(fileSaveDir);
			ServletFileUpload upload = new ServletFileUpload(factory);
			try {
				List<FileItem> fileItems = upload.parseRequest(request);
				Iterator<FileItem> iterator = fileItems.iterator();
				while (iterator.hasNext()){
					FileItem item = iterator.next();
					if (item.isFormField()){
						String fieldName = item.getFieldName();
						String name = item.getName();
						String contentType = item.getContentType();
						String str = item.getString();
						
						out.println("<fieldName>: " + fieldName  + " <name>: " + name + " <contentType>: " + contentType + " <str>: " + str);
					}else{
						String fieldName = item.getFieldName();
						String name = item.getName();
						String contentType = item.getContentType();
						out.println("<fieldName>: " + fieldName  + " <name>: " + name + " <contentType>: " + contentType);
						
					}
				}
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			out.println("Not multipart content");
		}
		
		String fileName = null;
		//Get all the parts from request and write it to the file on serve
		
//		STGroup templates = getSTGroup();
//		ST page = templates.getInstanceOf("template");
//		ST body = templates.getInstanceOf("form");
//		
//		page.add("contextPath", contextPath);
//		page.add("title", "Home");
//		page.add("body", body.render());
		
		//Write back to client
//		out.print(page.render());
		out.flush();
	}

}
