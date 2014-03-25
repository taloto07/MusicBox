package test;

import me.musicbox.hosting.dao.Artist;

public class TestAddArtist {

	public static void main(String[] args) {
		
		DatabaseService service = new DatabaseService();
		
//		Artist artist = new Artist();
//		artist.setFirstName("cham");
//		artist.setLastName("Lim");
//		artist.setGender("M");
//		
//		service.addArtist(artist);
		
//		Artist artist = service.getArtist(7);
//		int id = artist.getId();
//		String firstName = artist.getFirstName();
//		String lastName = artist.getLastName();
//		String gender = artist.getGender();
//		System.out.println(id + " " + firstName + " " + lastName + " " + gender);
		
		service.updateArtistFirstName(7, "Senghuot");
	}

}
