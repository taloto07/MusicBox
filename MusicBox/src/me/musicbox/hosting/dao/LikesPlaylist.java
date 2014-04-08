package me.musicbox.hosting.dao;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the likes_playlists database table.
 * 
 */
@Entity
@Table(name="likes_playlists")
@NamedQuery(name="LikesPlaylist.findAll", query="SELECT l FROM LikesPlaylist l")
public class LikesPlaylist implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	//bi-directional many-to-one association to Playlist
	@ManyToOne
	private Playlist playlist;

	//bi-directional many-to-one association to User
	@ManyToOne
	private User user;

	public LikesPlaylist() {
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

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}