package me.musicbox.hosting.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.NoResultException;
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
public class DispatchTest extends BaseServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DispatchTest() {
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
		response.setCharacterEncoding("UTF-8");
		
		// Get PrintWriter to write back to client
		PrintWriter out = response.getWriter();
		
		// Get contextPath for any external files such as css, js path
		String contextPath = getContextPath(); 
		
		//service.refresh();
		
		String url = request.getRequestURI();
		int beginIndex = url.lastIndexOf('/') + 1;
		String id = url.substring(beginIndex, url.length());
		

		
		// Get a list of all songs
		List<User> users = service.getAllUsers();
		
		User senghuot = null;
		for (User u: users){
			if (u.getUsername().equalsIgnoreCase(id)){
				senghuot = u;
				break;
			}
		}
		
		STGroup templates = getSTGroup();
		ST page = templates.getInstanceOf("template");
		
		if (senghuot == null){
			ST body = templates.getInstanceOf("userNotFound");
			body.add("username", id);
			
			page.add("body", body.render());
		}else{
		
			List<Follow> followers = senghuot.getFollows2();
			List<Follow> followings = senghuot.getFollows1();
			
			ST body = templates.getInstanceOf("body");
			
			body.add("user", senghuot.getUsername());
			body.add("followers", followers);
			body.add("following", followings);
			body.add("url", id);
			
			page.add("body", body.render());
		}
		
		page.add("contextPath", contextPath);
		page.add("title", "test page");
		
		
		//Write back to client
		out.print(page.render());
		out.flush();
	}

}
