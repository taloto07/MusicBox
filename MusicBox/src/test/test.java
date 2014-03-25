package test;

import java.util.List;

import me.musicbox.hosting.dao.Artist;
import me.musicbox.hosting.dao.Device;
import me.musicbox.hosting.dao.People;
import me.musicbox.hosting.dao.PeopleDevice;
import me.musicbox.hosting.dao.Song;

public class test {

	public static void main(String[] args) {
		DatabaseService service = new DatabaseService();
		List<Song> songs = service.getAllSongs();
		
		System.out.println("Sample test from song table from music database:");
		for (Song s: songs){
			System.out.println(s.getTitle() + " " + s.getArtist().getFirstName());
		}
		
		System.out.println();
		
		System.out.println("Sample test from song table from music database:");
		List<Artist> artists = service.getAllArtists();
		for (Artist a: artists){
			System.out.println(a.getFirstName());
			List<Song> s = a.getSongs();
			for(Song song: s){
				System.out.println("\t" + song.getTitle());
			}
		}
		
		System.out.println();
		
		System.out.println("Sample test from people table from music database:");
		List<People> people = service.getAllPeople();
		for (People p: people){
			System.out.println(p.getName());
			List<PeopleDevice> peopleDevices = p.getPeopleDevices();
			for(PeopleDevice pd: peopleDevices){
				System.out.println("\t" + pd.getDevice().getName());
			}
		}
	}

}
