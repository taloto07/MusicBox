package test;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class DatabaseService {
	private EntityManager em;
	
	public DatabaseService(){
		em = Persistence.createEntityManagerFactory("musicbox").createEntityManager();
	}
	
	
	
}
