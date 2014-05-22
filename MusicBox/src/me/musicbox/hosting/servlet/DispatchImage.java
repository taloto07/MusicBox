package me.musicbox.hosting.servlet;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/DispatchTest")
public class DispatchImage extends BaseServlet {
	private static final long serialVersionUID = 1L;
    
    public DispatchImage() {
        super();
        // TODO Auto-generated constructor stub
    }

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
		
		String referer = request.getHeader("referer");
		
		if (referer != null){ 
			
			String imageId = "photo.jpg";
			
			String imageDirectory = getServletContext().getRealPath("/WEB-INF/images");
			File file = new File(imageDirectory, imageId);
			
			if (file.exists()){
				response.setContentType("image/jpg");
				byte[] buffer = new byte[1024];
				FileInputStream fis = null;
				BufferedInputStream bis = null;
				
				try{
					fis = new FileInputStream(file);
					bis = new BufferedInputStream(fis);
					OutputStream os = response.getOutputStream();
					int i = bis.read(buffer);
					while(i != -1){
						os.write(buffer, 0, i);
						i = bis.read(buffer);
					}
				} catch(IOException E){
					System.out.println(E.toString());
				} finally{
					if (fis != null)
						fis.close();
					
					if (bis != null)
						bis.close();
				}
			}
		}else{
			response.sendRedirect("page404.html");
//			response.setContentType("text/html");
//			
//			// Get PrintWriter to write back to client
//			PrintWriter out = response.getWriter();
//			
//			out.println("Path is not found!");
//			out.flush();
		}
	}

}
