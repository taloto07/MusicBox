package me.musicbox.hosting.dao;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the likes_songs database table.
 * 
 */
@Entity
@Table(name="likes_songs")
@NamedQuery(name="LikesSong.findAll", query="SELECT l FROM LikesSong l")
public class LikesSong implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	//bi-directional many-to-one association to Song
	@ManyToOne
	private Song song;

	//bi-directional many-to-one association to User
	@ManyToOne
	private User user;

	public LikesSong() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Song getSong() {
		return this.song;
	}

	public void setSong(Song song) {
		this.song = song;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}