package entity;

import java.io.Serializable;
import java.util.Map;

public class Teacher implements Serializable{
	private static final long serialVersionUID = 8969357742306461220L;
    
	private int id;
	private String name;
	private String type;
	private String email;
	private String address;
	private String position;
	private String firstname;
	
	public Teacher() {
		super();
	}

	public Teacher(int id, String name, String type, String email,
			String address, String position,String firstname) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.email = email;
		this.address = address;
		this.position = position;
		this.firstname = firstname;
	}
	
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String toString() {
		return "Teacher [id=" + id + ", name=" + name + ", type=" + type
				+ ", email=" + email + ", address=" + address + ", position="
				+ position + ", firstname=" + firstname + "]";
	}
	
}

