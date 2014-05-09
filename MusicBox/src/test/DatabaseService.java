package test;

import java.util.List;

import javax.jws.WebService;

import com.google.inject.Guice;
import com.google.inject.Injector;

import me.musicbox.hosting.dao.User;
import me.musicbox.hosting.guice.MainModule;
import me.musicbox.hosting.service.MusicPersistenceInitializer;
import me.musicbox.hosting.service.MusicService;

@WebService
public class DatabaseService {
	Injector injector = Guice.createInjector(new MainModule());
	MusicService service;
	
	public DatabaseService(){
		injector.getInstance(MusicPersistenceInitializer.class);
		service = injector.getInstance(MusicService.class);
	}
	
	public String getUserByUsername(String username){
		User user = service.getUserByUsername(username);
		return "Here is your string " + user.getFirstName() + " " + user.getLastName() + " " + user.getEmail();
	}
	
}
