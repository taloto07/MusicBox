package me.musicbox.hosting.dao;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the songs_tags database table.
 * 
 */
@Entity
@Table(name="songs_tags")
@NamedQuery(name="SongsTag.findAll", query="SELECT s FROM SongsTag s")
public class SongsTag implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	//bi-directional many-to-one association to Song
	@ManyToOne
	private Song song;

	//bi-directional many-to-one association to Tag
	@ManyToOne
	private Tag tag;

	public SongsTag() {
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

	public Tag getTag() {
		return this.tag;
	}

	public void setTag(Tag tag) {
		this.tag = tag;
	}

}