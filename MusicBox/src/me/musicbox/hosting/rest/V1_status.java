package me.musicbox.hosting.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import me.musicbox.hosting.dao.User;
import me.musicbox.hosting.guice.MainModule;
import me.musicbox.hosting.service.MusicService;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.sun.jersey.spi.resource.Singleton;



@Singleton
@Path("/v1/status")
public class V1_status {
	
	Injector injector = Guice.createInjector(new MainModule());
	MusicService service;
	
	
	public V1_status(){
		service = injector.getInstance(MusicService.class);
	}

	@GET
	@Produces(MediaType.TEXT_HTML)
	public String returnTitle(){
		return "<p>Demo of Jersey Restful Web Service</p>";
	}
	
	@GET
	@Path("{username}")
	@Produces(MediaType.TEXT_HTML)
	public String returnTitle(@PathParam("username") String username){
		User user = service.getUserByUsername(username);
		String returnString = "<p>Demo of Jersey Restful Web Service with param and query from database: ";
		if (user == null){
			returnString += "Can't find user";
		}else{
			returnString += user.getEmail();
		}
		
		returnString += "</p>";
		return returnString;
	}
	
}
