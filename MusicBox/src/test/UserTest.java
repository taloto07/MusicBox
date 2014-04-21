package test;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import me.musicbox.hosting.dao.Role;
import me.musicbox.hosting.dao.User;
import me.musicbox.hosting.guice.MainModule;
import me.musicbox.hosting.service.MusicPersistenceInitializer;
import me.musicbox.hosting.service.MusicService;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class UserTest {

	public static void main(String[] args) {
		Injector injector = Guice.createInjector(new MainModule());
		injector.getInstance(MusicPersistenceInitializer.class);
		MusicService service = injector.getInstance(MusicService.class);
		
		List<User> users = service.getAllUsers();
		
		for (User u: users){
			System.out.println(u.getUsername());
		}
		
		System.out.println("\nGet user by id: 7seng7 \n");
		String username = "7seng7";
		User seng = service.getUserByUsername(username);
		if (seng == null)
		{
			System.out.println("Can't find " + username);
		}else{
			System.out.println(seng.getUsername() + " " + seng.getFirstName() + " " + seng.getLastName() + " " + seng.getCreateDate());
		}
		
//		User newUser = new User();
//		newUser.setUsername("newuser");
//		newUser.setFirstName("New");
//		newUser.setLastName("User");
//		newUser.setEmail("newUser@example.com");
//		newUser.setGender("F");
//		
//		Calendar cal = Calendar.getInstance();
//		cal.set(Calendar.YEAR, 1994);
//		cal.set(Calendar.MONTH, 5);
//		cal.set(Calendar.DAY_OF_MONTH, 1);
//		newUser.setDob(cal.getTime());
//		
//		newUser.setCreateDate(new Date());
//		
//		newUser.setPass("mypassword");
//		
//		newUser.setRole(service.getRoleByType("admin"));
//		
//		service.addUser(newUser);

		// remove user "newuser"
		//service.removeUserByUsername("newuser");
	}

}
