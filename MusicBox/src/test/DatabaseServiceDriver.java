package test;

import me.musicbox.hosting.guice.MainModule;
import me.musicbox.hosting.service.MusicPersistenceInitializer;
import me.musicbox.hosting.service.MusicService;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class DatabaseServiceDriver {
	Injector injector = Guice.createInjector(new MainModule());
	
	public static void main(String[] args) {
		
	}

}
