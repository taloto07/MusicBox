package me.musicbox.hosting.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.musicbox.hosting.dao.Follow;
import me.musicbox.hosting.dao.User;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;

import com.google.gson.Gson;

/**
 * Servlet implementation class DispatchTest
 */
//@WebServlet("/DispatchTest")
public class DispatchAjax extends BaseServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DispatchAjax() {
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
		// Set unicode to utf-8
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		// Get PrintWriter to write back to client
		PrintWriter out = response.getWriter();
		
		// Get contextPath for any external files such as css, js path
		String contextPath = getContextPath(); 
		
		String username = request.getParameter("txtUsername");
		String searchBtn = request.getParameter("btnSearch");
		System.out.println("txtUsername: " + username);
		System.out.println("btnSearch: " + searchBtn);
		
		boolean isValid = false;
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		
		
		if (username != null && !username.equalsIgnoreCase("")){
			User user = service.getUserByUsername(username);
			if (user != null){
				isValid = true;
				map.put("firstName", user.getFirstName());
				map.put("lastName", user.getLastName());
				map.put("email", user.getEmail());
			}else{
				
			}
		}
		map.put("isValid", isValid);
		out.write(new Gson().toJson(map));
		out.flush();
	}

}
