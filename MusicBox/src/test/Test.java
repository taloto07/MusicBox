package test;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import me.musicbox.hosting.dao.Follow;
import me.musicbox.hosting.dao.Role;
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
		
		User seng = null;
		for (User u: users){
			if (u.getUsername().equalsIgnoreCase("7seng7")){
				seng = u;
				break;
			}
		}
		
		User huy = null;
		for (User u: users){
			if (u.getUsername().equalsIgnoreCase("huy")){
				huy = u;
				break;
			}
		}
		
//		Follow follow = new Follow();
//		follow.setUser1(seng);
//		follow.setUser2(huy);
//		em.getTransaction().begin();
//		em.persist(follow);
//		em.getTransaction().commit();
		
		User newUser = new User();
		newUser.setUsername("newuser");
		newUser.setFirstName("New");
		newUser.setLastName("User");
		newUser.setEmail("newUser@example.com");
		newUser.setGender("F");
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 1994);
		cal.set(Calendar.MONTH, 5);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		newUser.setDob(cal.getTime());
		
		newUser.setCreateDate(new Date());
		
		newUser.setPass("mypassword");
		
		List<Role> roles = em.createNamedQuery("Role.findAll", Role.class).getResultList();
		Role normal = null;
		for(Role r: roles){
			if (r.getType().equalsIgnoreCase("normal")){
				normal = r;
				break;
			}
		}
		
		newUser.setRole(normal);
		em.getTransaction().begin();
//		newUser = em.merge(newUser);
//		em.find(User.class, newUser.getUsername());
		em.persist(newUser);
		em.getTransaction().commit();
		
		
//		Role r = new Role();
//		r.setType("user");
//		em.getTransaction().begin();
//		em.persist(r);
//		em.getTransaction().commit();
	}

}
