package me.musicbox.hosting.guice;

import me.musicbox.hosting.servlet.DispatchServlet;
import me.musicbox.hosting.servlet.DispatchTest;

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
		
		serve("/").with(DispatchServlet.class);
		serve("/test").with(DispatchTest.class);
		serve("*.php").with(DispatchServlet.class);
		serve("*.asp").with(DispatchServlet.class);
		serve("*.html").with(DispatchServlet.class);
		serve("*.htm").with(DispatchServlet.class);
		serve("*.xhtml").with(DispatchServlet.class);
	}
}
