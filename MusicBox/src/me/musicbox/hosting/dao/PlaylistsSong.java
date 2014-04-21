package me.musicbox.hosting.dao;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the playlists_songs database table.
 * 
 */
@Entity
@Table(name="playlists_songs")
@NamedQuery(name="PlaylistsSong.findAll", query="SELECT p FROM PlaylistsSong p")
public class PlaylistsSong implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	//bi-directional many-to-one association to Playlist
	@ManyToOne
	private Playlist playlist;

	//bi-directional many-to-one association to Song
	@ManyToOne
	private Song song;

	public PlaylistsSong() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Playlist getPlaylist() {
		return this.playlist;
	}

	public void setPlaylist(Playlist playlist) {
		this.playlist = playlist;
	}

	public Song getSong() {
		return this.song;
	}

	public void setSong(Song song) {
		this.song = song;
	}

}