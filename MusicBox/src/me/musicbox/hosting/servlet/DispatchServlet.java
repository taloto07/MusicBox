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

public class DispatchServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
    
    public DispatchServlet() {
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
		
		// Map actual page's name to page's title
		Map<String, String> pages = new HashMap<String, String>();
		pages.put("login", "Log In");
		pages.put("home", "HOME");
		pages.put("page404", "Page 404");
		pages.put("form", "Test Form");
		pages.put("test", "This Is Test Page.");
		pages.put("socketclient", "Socket Demo");
		pages.put("sse", "SSE Demo");
		pages.put("ajax", "AJAX Demo");
		
		String URI = request.getRequestURI();
		String myPage = getPageName(URI, pages);
		
		// Get contextPath for any external files such as css, js path
		String contextPath = getContextPath(); 
		
		STGroup templates = getSTGroup();
		ST page = templates.getInstanceOf("temp");
		ST body = templates.getInstanceOf(myPage);
		
		body.add("contextPath", contextPath);
		page.add("contextPath", contextPath);
		page.add("title", pages.get(myPage));
		page.add("body", body.render());
		page.add("onlineUsers", count);
		
		//Write back to client
		out.print(page.render());
		out.flush();
	}

	private String getPageName(String url, Map<String, String> map){
		int beginIndex = url.lastIndexOf('/') + 1;
		int endIndex = url.lastIndexOf('.');
		endIndex = endIndex < 0 ? url.length() : endIndex;
		String page = url.substring(beginIndex,endIndex);
		
		if (page.equalsIgnoreCase("")){
			return "home";
		}
		
		if (map.containsKey(page)){
			return page;
		}

		return "page404";
	}
}
