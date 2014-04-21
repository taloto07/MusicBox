package me.musicbox.hosting.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;

/**
 * Servlet implementation class DispatchTest
 */
@MultipartConfig
public class UploadServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestProccess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
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
		
		String fileName = null;
		//Get all the parts from request and write it to the file on server
		for (Part part: request.getParts()){
			String contentDisp = part.getHeader("content-disposition");
			String[] tokens = contentDisp.split(";");
			out.println("contentDisp = " + contentDisp);
		}
		
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
