package me.musicbox.hosting.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupDir;

import com.google.inject.Inject;

import me.musicbox.hosting.service.MusicService;

/**
 * Servlet implementation class BaseServlet
 */

public class BaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Inject
	MusicService service;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BaseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	protected STGroup getSTGroup(){
		String path = getServletContext().getRealPath("/WEB-INF/templates/");
		return new STGroupDir(path, '$', '$');
	}
	
	protected String getContextPath(){
		String contextPath = getServletContext().getContextPath();
		if (!contextPath.endsWith("/")) 
			contextPath = contextPath.concat("/");
		return contextPath;
	}

}
