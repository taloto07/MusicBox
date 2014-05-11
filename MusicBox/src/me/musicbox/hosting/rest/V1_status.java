package me.musicbox.hosting.rest;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import me.musicbox.hosting.dao.User;
import me.musicbox.hosting.guice.InjectorGuice;
import me.musicbox.hosting.service.MusicService;

import com.sun.jersey.spi.resource.Singleton;

//@Singleton
@Path("/v1/status")
public class V1_status {
	
	MusicService service;
	
	
	public V1_status(){
		service = InjectorGuice.injector.getInstance(MusicService.class);
	}

	@GET
	@Produces(MediaType.TEXT_HTML)
	public String returnTitle(){
		return "<p>Demo of Jersey Restful Web Service</p>";
	}
	
	@GET
	@Path("/getuser/{username}")
	@Produces(MediaType.TEXT_HTML)
	public String getUserByUsername(@PathParam("username") String username){
		try {
			username = URLDecoder.decode(username, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("khmer username: " + username);
		User user = service.getUserByUsername(username);
		String returnString = "<p>Demo of Jersey Restful Web Service with param and query from database: ";
		if (user == null){
			returnString += "Can't find user</p>";
		}else{
			returnString += "<p>User Name: " + user.getUsername() + "</p>";
			returnString += "<p>First name: " + user.getFirstName() + "</p>";
			returnString += "<p>Last name: " + user.getLastName() + "</p>";
			returnString += "<p>Gender: " + user.getGender() + "</p>";
			returnString += "<p>Date of birth: " + user.getDob() + "</p>";
			returnString += "<p>Email: " + user.getEmail() + "</p>";
		}		
		
		return returnString;
	}
	
	@GET
	@Path("/getusers")
	@Produces(MediaType.TEXT_HTML)
	public String getAllUsers(){
		List<User> users = service.getAllUsers();
		String output = "";
		for (User user : users){
			output += "<p>" + user.getUsername() + "</p>";
		}
		
		return output;
	}
	
}
