package test;

import java.util.List;

import me.musicbox.hosting.dao.Song;

public class test {

	public static void main(String[] args) {
		DatabaseService service = new DatabaseService();
		List<Song> songs = service.getAllSongs();
		
		System.out.println("Sample test from song table from music database:");
		for (Song s: songs){
			System.out.println("Title: " + s.getTitle());
		}
	}

}
