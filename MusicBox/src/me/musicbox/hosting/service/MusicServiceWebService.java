//***************************
// This doesn't work
//***************************
package me.musicbox.hosting.service;

import java.util.List;

import javax.jws.WebService;

import me.musicbox.hosting.dao.User;
import me.musicbox.hosting.guice.MainModule;

import com.google.inject.Guice;
import com.google.inject.Injector;

@WebService
public class MusicServiceWebService {
	Injector injector = Guice.createInjector(new MainModule());
	
	public List<User> getAllUsers(){
		injector.getInstance(MusicPersistenceInitializer.class);
		MusicService service = injector.getInstance(MusicService.class);
		return service.getAllUsers();
	}
}
