package me.music.hosting.session;

import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionListenter implements ServletContextListener,
		HttpSessionListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext servletContext = sce.getServletContext();
		servletContext.setAttribute("userCounter", new AtomicInteger());
	}

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		HttpSession session = se.getSession();
		ServletContext servletContext = session.getServletContext();
		AtomicInteger userCounter = (AtomicInteger) servletContext.getAttribute("userCounter");
		int count = userCounter.incrementAndGet();
		System.out.println(count);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		HttpSession session = se.getSession();
		ServletContext servletContext = session.getServletContext();
		AtomicInteger userCounter = (AtomicInteger) servletContext.getAttribute("userCounter");
		int count = userCounter.decrementAndGet();
		System.out.println(count);
	}

	

}
