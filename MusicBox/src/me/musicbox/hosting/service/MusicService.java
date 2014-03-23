package me.musicbox.hosting.service;

import java.util.List;

import javax.persistence.EntityManager;

import com.google.inject.Inject;
import com.google.inject.Provider;
import me.musicbox.hosting.dao.Song;

public class MusicService {
	@Inject
	private Provider<EntityManager> entityManager;
	
	public List<Song> getAllSongs(){
		return entityManager.get().createNamedQuery("Song.findAll", Song.class).getResultList();
	}

}
