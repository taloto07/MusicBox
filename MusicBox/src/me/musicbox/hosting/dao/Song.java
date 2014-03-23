package me.musicbox.hosting.dao;

import java.io.Serializable;

import javax.persistence.*;



/**
 * The persistent class for the songs database table.
 * 
 */
@Entity
@Table(name="songs")
@NamedQuery(name="Song.findAll", query="SELECT s FROM Song s")
public class Song implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="artist_id")
	private int artistId;

	private String path;

	private String title;

	public Song() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getArtistId() {
		return this.artistId;
	}

	public void setArtistId(int artistId) {
		this.artistId = artistId;
	}

	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
