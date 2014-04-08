package me.musicbox.hosting.dao;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the playlists database table.
 * 
 */
@Entity
@Table(name="playlists")
@NamedQuery(name="Playlist.findAll", query="SELECT p FROM Playlist p")
public class Playlist implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String name;

	//bi-directional many-to-one association to LikesPlaylist
	@OneToMany(mappedBy="playlist")
	private List<LikesPlaylist> likesPlaylists;

	//bi-directional many-to-one association to User
	@ManyToOne
	private User user;

	//bi-directional many-to-one association to PlaylistsSong
	@OneToMany(mappedBy="playlist")
	private List<PlaylistsSong> playlistsSongs;

	public Playlist() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<LikesPlaylist> getLikesPlaylists() {
		return this.likesPlaylists;
	}

	public void setLikesPlaylists(List<LikesPlaylist> likesPlaylists) {
		this.likesPlaylists = likesPlaylists;
	}

	public LikesPlaylist addLikesPlaylist(LikesPlaylist likesPlaylist) {
		getLikesPlaylists().add(likesPlaylist);
		likesPlaylist.setPlaylist(this);

		return likesPlaylist;
	}

	public LikesPlaylist removeLikesPlaylist(LikesPlaylist likesPlaylist) {
		getLikesPlaylists().remove(likesPlaylist);
		likesPlaylist.setPlaylist(null);

		return likesPlaylist;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<PlaylistsSong> getPlaylistsSongs() {
		return this.playlistsSongs;
	}

	public void setPlaylistsSongs(List<PlaylistsSong> playlistsSongs) {
		this.playlistsSongs = playlistsSongs;
	}

	public PlaylistsSong addPlaylistsSong(PlaylistsSong playlistsSong) {
		getPlaylistsSongs().add(playlistsSong);
		playlistsSong.setPlaylist(this);

		return playlistsSong;
	}

	public PlaylistsSong removePlaylistsSong(PlaylistsSong playlistsSong) {
		getPlaylistsSongs().remove(playlistsSong);
		playlistsSong.setPlaylist(null);

		return playlistsSong;
	}

}