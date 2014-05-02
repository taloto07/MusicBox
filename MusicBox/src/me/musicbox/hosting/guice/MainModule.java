package me.musicbox.hosting.guice;



import me.musicbox.hosting.servlet.DispatchAjax;
import me.musicbox.hosting.servlet.DispatchServlet;
import me.musicbox.hosting.servlet.DispatchTest;
import me.musicbox.hosting.servlet.SSE;
import me.musicbox.hosting.servlet.Testing;
import me.musicbox.hosting.servlet.UploadServlet;

import com.google.inject.Singleton;
import com.google.inject.persist.PersistFilter;
import com.google.inject.persist.jpa.JpaPersistModule;
import com.google.inject.servlet.ServletModule;

public class MainModule extends ServletModule {
	@Override
	protected void configureServlets(){
		install(new JpaPersistModule("musicboxJPA"));
		filter("/*").through(PersistFilter.class);
		
		bind(DispatchTest.class).in(Singleton.class);
		bind(DispatchServlet.class).in(Singleton.class);
		bind(Testing.class).in(Singleton.class);
		bind(UploadServlet.class).in(Singleton.class);
		bind(SSE.class).in(Singleton.class);
		bind(DispatchAjax.class).in(Singleton.class);
		
		serve("/").with(DispatchServlet.class);
		serve("*.html").with(DispatchServlet.class);
		serve("*.htm").with(DispatchServlet.class);
		serve("*.asp").with(DispatchServlet.class);
		serve("*.php").with(DispatchServlet.class);
		serve("/test/*").with(DispatchTest.class);
		serve("/testing/*").with(Testing.class);
		serve("/UploadFile").with(UploadServlet.class);
		serve("/sse").with(SSE.class);
		serve("/ajaxrequest").with(DispatchAjax.class);
	}
}
