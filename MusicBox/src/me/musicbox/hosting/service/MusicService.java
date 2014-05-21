package me.musicbox.hosting.service;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import me.musicbox.hosting.dao.Role;
import me.musicbox.hosting.dao.User;

import com.google.inject.Inject;
import com.google.inject.Provider;

public class MusicService {
	@Inject
	private Provider<EntityManager> entityManager;
	
	public List<User> getAllUsers(){
		return entityManager.get().createNamedQuery("User.findAll", User.class).getResultList();
	}
	
	//@Transactional
	public User getUserByUsername(String username){
		try{
			return entityManager.get().createNamedQuery("User.findByUsername", User.class)
					.setParameter("username", username).getSingleResult();
		}catch (NoResultException e){
			return null;
		}
	}
	
	public List<User> getUserByLike(String username){
		try{
			return entityManager.get().createNamedQuery("User.findByLike", User.class).getResultList();
		}catch(NoResultException e){
			return null;
		}
	}
	
	public boolean addUser(User user){
		entityManager.get().getTransaction().begin();
		entityManager.get().persist(user);
		entityManager.get().getTransaction().commit();
		return true;
	}
	
	public boolean removeUserByUsername(String username){
		User deletedUser = getUserByUsername(username);
		entityManager.get().getTransaction().begin();
		entityManager.get().remove(deletedUser);
		entityManager.get().getTransaction().commit();
		return true;
	}
	
	public List<Role> getAllRoles(){
		return entityManager.get().createNamedQuery("Role.findAll", Role.class).getResultList();
	}
	
	public Role getRoleByType(String type){
		try{
			return entityManager.get().createNamedQuery("Role.findByType", Role.class).setParameter("type", type)
			.getSingleResult();
		}catch (NoResultException e){
			return null;
		}
	}
	
//	public List<Song> getAllSongs(){
//		return entityManager.get().createNamedQuery("Song.findAll", Song.class).getResultList();
//	}
	
//	public Song getSongById(int id){
//		try{
//			return entityManager.get().createNamedQuery("Song.findById", Song.class).setParameter("id", id).getSingleResult();
//		}catch (NoResultException e){
//			return null;
//		}
//	}
//	
//	public boolean deleteSongById(int id){
//		Song song = getSongById(id);
//		if (song != null){
//			entityManager.get().getTransaction().begin();
//			entityManager.get().remove(song);
//			entityManager.get().getTransaction().commit();
//			return true;
//		}
//		return false;
//	}
	
//	public void refresh(){
//		List<Song> songs = getAllSongs();
//		Song song = songs.get(0);
//		entityManager.get().getTransaction().begin();
//		song.setPath(song.getPath());
//		entityManager.get().getTransaction().commit();
//	}

}
