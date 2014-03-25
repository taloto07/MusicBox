package test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import me.musicbox.hosting.dao.Song;

public class DatabaseService {
	private EntityManager em;
	
	public DatabaseService(){
		em = Persistence.createEntityManagerFactory("musicboxJPA").createEntityManager();
	}
	
	public List<Song> getAllSongs(){
		return em.createNamedQuery("Song.findAll", Song.class).getResultList();
	}

}
