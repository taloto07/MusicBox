package me.musicbox.hosting.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import com.google.inject.Inject;
import com.google.inject.Provider;

import me.musicbox.hosting.dao.Song;

public class MusicService {
	@Inject
	private Provider<EntityManager> entityManager;
	
	public List<Song> getAllSongs(){
		return entityManager.get().createNamedQuery("Song.findAll", Song.class).getResultList();
	}
	
	public Song getSongById(int id){
		try{
			return entityManager.get().createNamedQuery("Song.findById", Song.class).setParameter("id", id).getSingleResult();
		}catch (NoResultException e){
			return null;
		}
	}
	
	public boolean deleteSongById(int id){
		Song song = getSongById(id);
		if (song != null){
			entityManager.get().getTransaction().begin();
			entityManager.get().remove(song);
			entityManager.get().getTransaction().commit();
			return true;
		}
		return false;
	}
	
	public void refresh(){
		List<Song> songs = getAllSongs();
		Song song = songs.get(0);
		entityManager.get().getTransaction().begin();
		song.setPath(song.getPath());
		entityManager.get().getTransaction().commit();
	}

}
