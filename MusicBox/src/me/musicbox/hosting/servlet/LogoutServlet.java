package me.musicbox.hosting.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;

import me.musicbox.hosting.dao.User;

import com.google.gson.Gson;

public class LogoutServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
    
    public LogoutServlet() {
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
		if (request.getHeader("referer") != null){
		
			// Set unicode to utf-8
			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			
			// Get PrintWriter to write back to client
			PrintWriter out = response.getWriter();
			
			// Session
			int count = getNumberUserOnline(request);
			
			// Get contextPath for any external files such as css, js path
			String contextPath = getContextPath();
			
			STGroup templates = getSTGroup();
			ST page = templates.getInstanceOf("temp");
			ST body = templates.getInstanceOf("logout");
			body.add("username", request.getRemoteUser());
			page.add("contextPath", contextPath);
			page.add("title", "Log Out");
			page.add("onlineUsers", count);
			page.add("loginOrOut", "login");
			page.add("loginOrOutLabel", "Log In");
			page.add("body", body.render());
			out.println(page.render());
			
			request.logout();
			
			out.flush();
		}else{
			response.sendRedirect("home.html");
		}
	}

}
