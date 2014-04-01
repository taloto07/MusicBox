package me.musicbox.hosting.dao;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the follows database table.
 * 
 */
@Entity
@Table(name="follows")
@NamedQuery(name="Follow.findAll", query="SELECT f FROM Follow f")
public class Follow implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="following")
	private User user1;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="follower")
	private User user2;

	public Follow() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser1() {
		return this.user1;
	}

	public void setUser1(User user1) {
		this.user1 = user1;
	}

	public User getUser2() {
		return this.user2;
	}

	public void setUser2(User user2) {
		this.user2 = user2;
	}

}