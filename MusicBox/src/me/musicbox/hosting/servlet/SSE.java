package me.musicbox.hosting.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/DispatchTest")
public class SSE extends BaseServlet {
	private static final long serialVersionUID = 1L;
   
    public SSE() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestProccess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestProccess(request, response);
	}
	
	@SuppressWarnings({ "deprecation", "static-access" })
	private void requestProccess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Set unicode to utf-8
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/event-stream;charset=UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Connection", "keep-alive");
		
		// Get PrintWriter to write back to client
		PrintWriter out = response.getWriter(); 
		
		while(true){
			out.print("id: " + "ServerTime" + "\n");
			out.print("data: " + new Date().toLocaleString() + "\n\n");
			out.flush();
			
			try {
				Thread.currentThread().sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

}
