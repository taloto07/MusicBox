package me.musicbox.hosting.dao;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the devices database table.
 * 
 */
@Entity
@Table(name="devices")
@NamedQuery(name="Device.findAll", query="SELECT d FROM Device d")
public class Device implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String name;

	//bi-directional many-to-one association to PeopleDevice
	@OneToMany(mappedBy="device")
	private List<PeopleDevice> peopleDevices;

	public Device() {
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
		peopleDevice.setDevice(this);

		return peopleDevice;
	}

	public PeopleDevice removePeopleDevice(PeopleDevice peopleDevice) {
		getPeopleDevices().remove(peopleDevice);
		peopleDevice.setDevice(null);

		return peopleDevice;
	}

}