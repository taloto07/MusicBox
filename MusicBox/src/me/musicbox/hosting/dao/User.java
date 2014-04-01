package me.musicbox.hosting.dao;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name="users")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String username;

	@Temporal(TemporalType.DATE)
	@Column(name="create_date")
	private Date createDate;

	@Temporal(TemporalType.DATE)
	private Date dob;

	private String email;

	@Column(name="first_name")
	private String firstName;

	private String gender;

	@Column(name="last_name")
	private String lastName;

	private String pass;

	//bi-directional many-to-one association to Follow
	@OneToMany(mappedBy="user1")
	private List<Follow> follows1;

	//bi-directional many-to-one association to Follow
	@OneToMany(mappedBy="user2")
	private List<Follow> follows2;

	//bi-directional many-to-one association to Role
	@ManyToOne
	private Role role;

	public User() {
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getDob() {
		return this.dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getPass() {
		return this.pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public List<Follow> getFollows1() {
		return this.follows1;
	}

	public void setFollows1(List<Follow> follows1) {
		this.follows1 = follows1;
	}

	public Follow addFollows1(Follow follows1) {
		getFollows1().add(follows1);
		follows1.setUser1(this);

		return follows1;
	}

	public Follow removeFollows1(Follow follows1) {
		getFollows1().remove(follows1);
		follows1.setUser1(null);

		return follows1;
	}

	public List<Follow> getFollows2() {
		return this.follows2;
	}

	public void setFollows2(List<Follow> follows2) {
		this.follows2 = follows2;
	}

	public Follow addFollows2(Follow follows2) {
		getFollows2().add(follows2);
		follows2.setUser2(this);

		return follows2;
	}

	public Follow removeFollows2(Follow follows2) {
		getFollows2().remove(follows2);
		follows2.setUser2(null);

		return follows2;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}