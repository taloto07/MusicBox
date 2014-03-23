package me.musicbox.hosting.service;

import com.google.inject.Inject;
import com.google.inject.persist.PersistService;

public class MusicPersistenceInitializer {
	@Inject
	MusicPersistenceInitializer(PersistService service){
		service.start();
//		System.out.println("*****************************");
//		System.out.println("MusicPersistenceInitializer started.");
//		System.out.println("*****************************");
	}
}
