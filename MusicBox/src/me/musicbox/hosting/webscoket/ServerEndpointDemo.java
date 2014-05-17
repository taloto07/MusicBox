package me.musicbox.hosting.webscoket;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/serverendpointdemo/{page}")
public class ServerEndpointDemo {
	static Set<Session> chatroomUsers = Collections.synchronizedSet(new HashSet<Session>());
	
	@OnOpen
	public void handdleOpen(Session session, @PathParam("page") String clientPage){
		chatroomUsers.add(session);
		System.out.println("Client is now connected in page: " + clientPage);
	}
	
	@OnMessage
	public void handdleMessage(String message, Session userSession) throws IOException{
		System.out.println("Receive message: " + message);
		String username = (String) userSession.getUserProperties().get("username");
		if (username ==  null){
			userSession.getUserProperties().put("username", message);
			userSession.getBasicRemote().sendText("Server: you are now connected as " + message);
		}else{
			Iterator<Session> iterator = chatroomUsers.iterator();
			while (iterator.hasNext()){
				Session currentSession = iterator.next();
		
				if (currentSession.equals(userSession)){
					currentSession.getBasicRemote().sendText("You: " + message);
				}else{
					System.out.println("Send to other client.");
					currentSession.getBasicRemote().sendText(username + ": " + message);
				}	
				
			}
		}
	}
	
	@OnClose
	public void handdleClose(Session userSession){
		String userName = (String)userSession.getUserProperties().get("username");
		userName = userName == null ? "No name" : userName;
		System.out.println(userName + " is disconnected...");
		chatroomUsers.remove(userSession);
	}
	
	@OnError
	public void handdleError(Throwable t){
		t.printStackTrace();
	}
}
