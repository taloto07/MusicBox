package me.musicbox.hosting.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.musicbox.hosting.dao.Follow;
import me.musicbox.hosting.dao.User;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;

/**
 * Servlet implementation class DispatchTest
 */
//@WebServlet("/DispatchTest")
//@WebService
public class Testing extends BaseServlet {
	private static final long serialVersionUID = 1L;
    
	public String getUserByName(String username){
		User user = service.getUserByUsername(username);
		return user.getFirstName();
	}
    
    public Testing() {
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
		// Set unicode to utf-8
//		response.setCharacterEncoding("UTF-8");
//		
//		// Get PrintWriter to write back to client
//		PrintWriter out = response.getWriter();
//		
//		// Get contextPath for any external files such as css, js path
//		String contextPath = getContextPath(); 
//		
//		
//		STGroup templates = getSTGroup();
//		ST page = templates.getInstanceOf("test");
//		
//		page.add("contextPath", contextPath);
//		
//		//Write back to client
//		out.print(contextPath);
//		out.flush();
	}

}
