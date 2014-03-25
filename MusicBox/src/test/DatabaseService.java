package test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import me.musicbox.hosting.dao.Artist;
import me.musicbox.hosting.dao.People;
import me.musicbox.hosting.dao.Song;

public class DatabaseService {
	private EntityManager em;
	
	public DatabaseService(){
		em = Persistence.createEntityManagerFactory("musicboxJPA").createEntityManager();
	}
	
	public List<Song> getAllSongs(){
		return em.createNamedQuery("Song.findAll", Song.class).getResultList();
	}
	
	public List<Artist> getAllArtists(){
		return em.createNamedQuery("Artist.findAll", Artist.class).getResultList();
	}
	
	public Artist getArtist(int id){
		return em.createNamedQuery("Artist.findArtistById", Artist.class).setParameter("id", id).getSingleResult();
	}
	
	public void updateArtistFirstName(int id, String firstName){
		Artist artist = getArtist(id);
		em.getTransaction().begin();
		artist.setFirstName(firstName);
		em.getTransaction().commit();
	}
	
	public List<People> getAllPeople(){
		return em.createNamedQuery("People.findAll", People.class).getResultList();
	}
	
	public void addArtist(Artist artist){
		EntityTransaction artistTransaction = em.getTransaction();
		artistTransaction.begin();
		em.persist(artist);
		artistTransaction.commit();
	}
}
