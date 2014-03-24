package me.musicbox.hosting.guice;

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
		
		serve("/").with(DispatchTest.class);
		serve("/test").with(DispatchTest.class);
		serve("*.php").with(DispatchTest.class);
		serve("*.asp").with(DispatchTest.class);
		serve("home.asp").with(DispatchTest.class);
		serve("*.html").with(DispatchTest.class);
		serve("*.htm").with(DispatchTest.class);
		serve("*.xhtml").with(DispatchTest.class);
	}
}
