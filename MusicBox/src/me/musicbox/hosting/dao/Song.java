package me.musicbox.hosting.dao;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.DATE)
	@Column(name="date_upload")
	private Date dateUpload;

	private byte length;

	@Column(name="play_count")
	private int playCount;

	private String synopsis;

	private String title;

	//bi-directional many-to-one association to Comment
	@OneToMany(mappedBy="song")
	private List<Comment> comments;

	//bi-directional many-to-one association to LikesSong
	@OneToMany(mappedBy="song")
	private List<LikesSong> likesSongs;

	//bi-directional many-to-one association to PlaylistsSong
	@OneToMany(mappedBy="song")
	private List<PlaylistsSong> playlistsSongs;

	//bi-directional many-to-one association to User
	@ManyToOne
	private User user;

	//bi-directional many-to-one association to SongsTag
	@OneToMany(mappedBy="song")
	private List<SongsTag> songsTags;

	public Song() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateUpload() {
		return this.dateUpload;
	}

	public void setDateUpload(Date dateUpload) {
		this.dateUpload = dateUpload;
	}

	public byte getLength() {
		return this.length;
	}

	public void setLength(byte length) {
		this.length = length;
	}

	public int getPlayCount() {
		return this.playCount;
	}

	public void setPlayCount(int playCount) {
		this.playCount = playCount;
	}

	public String getSynopsis() {
		return this.synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Comment> getComments() {
		return this.comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Comment addComment(Comment comment) {
		getComments().add(comment);
		comment.setSong(this);

		return comment;
	}

	public Comment removeComment(Comment comment) {
		getComments().remove(comment);
		comment.setSong(null);

		return comment;
	}

	public List<LikesSong> getLikesSongs() {
		return this.likesSongs;
	}

	public void setLikesSongs(List<LikesSong> likesSongs) {
		this.likesSongs = likesSongs;
	}

	public LikesSong addLikesSong(LikesSong likesSong) {
		getLikesSongs().add(likesSong);
		likesSong.setSong(this);

		return likesSong;
	}

	public LikesSong removeLikesSong(LikesSong likesSong) {
		getLikesSongs().remove(likesSong);
		likesSong.setSong(null);

		return likesSong;
	}

	public List<PlaylistsSong> getPlaylistsSongs() {
		return this.playlistsSongs;
	}

	public void setPlaylistsSongs(List<PlaylistsSong> playlistsSongs) {
		this.playlistsSongs = playlistsSongs;
	}

	public PlaylistsSong addPlaylistsSong(PlaylistsSong playlistsSong) {
		getPlaylistsSongs().add(playlistsSong);
		playlistsSong.setSong(this);

		return playlistsSong;
	}

	public PlaylistsSong removePlaylistsSong(PlaylistsSong playlistsSong) {
		getPlaylistsSongs().remove(playlistsSong);
		playlistsSong.setSong(null);

		return playlistsSong;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<SongsTag> getSongsTags() {
		return this.songsTags;
	}

	public void setSongsTags(List<SongsTag> songsTags) {
		this.songsTags = songsTags;
	}

	public SongsTag addSongsTag(SongsTag songsTag) {
		getSongsTags().add(songsTag);
		songsTag.setSong(this);

		return songsTag;
	}

	public SongsTag removeSongsTag(SongsTag songsTag) {
		getSongsTags().remove(songsTag);
		songsTag.setSong(null);

		return songsTag;
	}

}