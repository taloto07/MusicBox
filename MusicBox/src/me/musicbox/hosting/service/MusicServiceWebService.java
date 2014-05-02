//***************************
// This doesn't work
//***************************
package me.musicbox.hosting.service;

import java.util.List;

import javax.jws.WebService;

import me.musicbox.hosting.dao.User;
import me.musicbox.hosting.guice.MainModule;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

@WebService
public class MusicServiceWebService {
	@Inject
	MusicService service;

	public String getThisString(){
		User user = service.getUserByUsername("7seng7");
		return user.getFirstName();
	}
	
	public String normalString(){
		return "normal string";
	}
}
