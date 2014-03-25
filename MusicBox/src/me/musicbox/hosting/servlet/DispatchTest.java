package me.musicbox.hosting.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.musicbox.hosting.dao.Song;

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
		response.setCharacterEncoding("UTF-8");
		
		// Get PrintWriter to write back to client
		PrintWriter out = response.getWriter();
		
		// Get contextPath for any external files such as css, js path
		String contextPath = getContextPath(); 
		
		// Get a list of all songs
		List<Song> songs = service.getAllSongs();
		
		STGroup templates = getSTGroup();
		ST page = templates.getInstanceOf("template");
		ST body = templates.getInstanceOf("body");
		body.add("object", songs);
		page.add("contextPath", contextPath);
		page.add("title", "test page");
		page.add("body", body.render());
		
		//Write back to client
		out.print(page.render());
		out.flush();
	}

}
