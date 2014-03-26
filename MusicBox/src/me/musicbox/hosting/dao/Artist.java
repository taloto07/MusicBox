package me.musicbox.hosting.dao;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the artists database table.
 * 
 */
@Entity
@Table(name="artists")
@NamedQueries({
	@NamedQuery(name="Artist.findAll", query="SELECT a FROM Artist a"),
	@NamedQuery(name="Artist.findArtistById", query="SELECT a FROM Artist a WHERE a.id= :id")
})
public class Artist implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="first_name")
	private String firstName;

	private String gender;

	@Column(name="last_name")
	private String lastName;

	//bi-directional many-to-one association to Song
	@OneToMany(mappedBy="artist")
	private List<Song> songs;

	public Artist() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<Song> getSongs() {
		return this.songs;
	}

	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}

	public Song addSong(Song song) {
		getSongs().add(song);

		return song;
	}

	public Song removeSong(Song song) {
		getSongs().remove(song);

		return song;
	}

}