package test;

import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

//@WebService
public class DatabaseService {
	private EntityManager em;
	
	public DatabaseService(){
		em = Persistence.createEntityManagerFactory("musicbox").createEntityManager();
	}
	
	public String getThisString(){
		return "Here is your string.";
	}
	
}
