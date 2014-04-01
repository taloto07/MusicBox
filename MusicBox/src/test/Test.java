package test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import me.musicbox.hosting.dao.Follow;
import me.musicbox.hosting.dao.User;

public class Test {

	public static void main(String[] args) {
		EntityManager em = Persistence.createEntityManagerFactory("musicboxJPA").createEntityManager();

		List<User> users = em.createNamedQuery("User.findAll", User.class).getResultList();
		
		for (User u: users){
			System.out.println("User: " + u.getUsername());
			System.out.println("follower: ");
			List<Follow> followers = u.getFollows2();
			for (Follow f: followers){
				System.out.println("\t" + f.getUser1().getUsername());
			}
			
			System.out.println("following: ");
			List<Follow> following = u.getFollows1();
			for (Follow f: following){
				System.out.println("\t" + f.getUser2().getUsername());
			}	
			System.out.println();
		}
		
		
	}

}
