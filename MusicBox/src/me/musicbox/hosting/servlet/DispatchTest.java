package me.musicbox.hosting.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.musicbox.hosting.dao.Song;
import me.musicbox.hosting.service.MusicService;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupDir;

import com.google.inject.Inject;

/**
 * Servlet implementation class DispatchTest
 */
//@WebServlet("/DispatchTest")
public class DispatchTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Inject
	MusicService service;
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
		// Get PrintWriter to write back to client
		PrintWriter out = response.getWriter();
		
		// Get contextPath for any external file such as css, js path
		String contextPath = getServletContext().getContextPath();
		contextPath = contextPath.endsWith("/") ? contextPath : contextPath.concat("/"); 
		
		// Get real path for any template files *.st
		String path = getServletContext().getRealPath("WEB-INF/templates/");
		
		// Get a list of all songs
		List<Song> songs = service.getAllSongs();
		
		STGroup templates = new STGroupDir(path, '$', '$');
		ST page = templates.getInstanceOf("template");
		page.add("contextPath", contextPath);
		page.add("title", "test page");
		page.add("body", songs);
		
		//Write back to client
		out.print(page.render());
		out.flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
