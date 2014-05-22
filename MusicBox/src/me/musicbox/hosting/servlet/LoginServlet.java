package me.musicbox.hosting.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;

public class LoginServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
    
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestProccess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestProccess(request, response);
	}
	
	private void requestProccess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Get PrintWriter to write back to client
		PrintWriter out = response.getWriter();
		
		// Session
		int count = getNumberUserOnline(request);
		
		
		// Get contextPath for any external files such as css, js path
		String contextPath = getContextPath(); 
		
		Enumeration<String> header = request.getHeaderNames();
		while(header.hasMoreElements()){
			String key = header.nextElement();
			System.out.println("Header: " + key + ": " + request.getHeader(key));
		}
		
		STGroup templates = getSTGroup();
		ST page = templates.getInstanceOf("temp");
		ST body = templates.getInstanceOf("loginjdbc");
		
//		Enumeration<String> p = request.getParameterNames();
//		while (p.hasMoreElements()){
//			String key = p.nextElement();
//			String value = request.getParameter(key);
//			System.out.println("Parameter: " + key + ": " + value);
//		}
		
		if (request.getParameter("j_username") != null){
			body.add("errorMessage", "Username or Password is incorrect!");
		}
		
		String login = "login";
		String loginLabel = "Log In";
		String username = request.getRemoteUser();
		if (username != null){
			login = "logout";
			loginLabel = "Log Out";
		}
		
		page.add("loginOrOut", login);
		page.add("loginOrOutLabel", loginLabel);
		page.add("username", username);
		
		body.add("contextPath", contextPath);
		page.add("contextPath", contextPath);
		page.add("title", "Log In");
		page.add("body", body.render());
		page.add("onlineUsers", count);
		
		//Write back to client
		out.print(page.render());
		out.flush();
	}
}
