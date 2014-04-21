package test;

import static org.junit.Assert.*;
import me.musicbox.hosting.dao.User;
import me.musicbox.hosting.guice.MainModule;
import me.musicbox.hosting.service.MusicPersistenceInitializer;
import me.musicbox.hosting.service.MusicService;

import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class GeneralTest {
	Injector injector = Guice.createInjector(new MainModule());
	
	
	@Test
	public void test() {
		injector.getInstance(MusicPersistenceInitializer.class);
		MusicService service = injector.getInstance(MusicService.class);
		
		User seng7 = service.getUserByUsername("7seng7");
		assertNotNull(seng7);
		assertEquals(seng7.getUsername(), "7seng7");
		assertEquals(seng7.getFirstName(), "senghuot");
	}

}
