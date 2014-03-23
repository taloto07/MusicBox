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
//		bind(DispatchScott.class).in(Singleton.class);
//		//bind(DispatchAnything.class).in(Singleton.class);
//		
//		serve("/scott").with(DispatchScott.class);
		serve("/test").with(DispatchTest.class);
		//serve("/*").with(DispatchAnything.class);
		
	}
}
