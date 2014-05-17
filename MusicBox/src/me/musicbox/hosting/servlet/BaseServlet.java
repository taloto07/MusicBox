package me.musicbox.hosting.servlet;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupDir;

import com.google.inject.Inject;
import com.googlecode.htmlcompressor.compressor.HtmlCompressor;

import me.musicbox.hosting.service.MusicService;

public class BaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Inject
	MusicService service;
   
    public BaseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

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

	protected String compressHTML(String content){
		HtmlCompressor compressor = new HtmlCompressor();
		return compressor.compress(content);
	}
	
	// retrieve number of user currently online
	protected int getNumberUserOnline(HttpServletRequest request){
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(2);
		ServletContext servletContext = session.getServletContext();
		AtomicInteger userCounter = (AtomicInteger) servletContext.getAttribute("userCounter");
		return userCounter.get();
	}
}
