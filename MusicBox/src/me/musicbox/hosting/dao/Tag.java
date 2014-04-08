package me.musicbox.hosting.dao;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tags database table.
 * 
 */
@Entity
@Table(name="tags")
@NamedQuery(name="Tag.findAll", query="SELECT t FROM Tag t")
public class Tag implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String name;

	//bi-directional many-to-one association to SongsTag
	@OneToMany(mappedBy="tag")
	private List<SongsTag> songsTags;

	public Tag() {
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

	public List<SongsTag> getSongsTags() {
		return this.songsTags;
	}

	public void setSongsTags(List<SongsTag> songsTags) {
		this.songsTags = songsTags;
	}

	public SongsTag addSongsTag(SongsTag songsTag) {
		getSongsTags().add(songsTag);
		songsTag.setTag(this);

		return songsTag;
	}

	public SongsTag removeSongsTag(SongsTag songsTag) {
		getSongsTags().remove(songsTag);
		songsTag.setTag(null);

		return songsTag;
	}

}