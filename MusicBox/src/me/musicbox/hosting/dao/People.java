package me.musicbox.hosting.dao;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the people database table.
 * 
 */
@Entity
@NamedQuery(name="People.findAll", query="SELECT p FROM People p")
public class People implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String name;

	//bi-directional many-to-one association to PeopleDevice
	@OneToMany(mappedBy="people")
	private List<PeopleDevice> peopleDevices;

	public People() {
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

	public List<PeopleDevice> getPeopleDevices() {
		return this.peopleDevices;
	}

	public void setPeopleDevices(List<PeopleDevice> peopleDevices) {
		this.peopleDevices = peopleDevices;
	}

	public PeopleDevice addPeopleDevice(PeopleDevice peopleDevice) {
		getPeopleDevices().add(peopleDevice);
		peopleDevice.setPeople(this);

		return peopleDevice;
	}

	public PeopleDevice removePeopleDevice(PeopleDevice peopleDevice) {
		getPeopleDevices().remove(peopleDevice);
		peopleDevice.setPeople(null);

		return peopleDevice;
	}

}