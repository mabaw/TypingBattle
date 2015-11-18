package jp.co.fitec.traning.project.typing.entity;

import java.io.Serializable;

public class UserAccount implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String photo;
	private Location location;
	private String password;
	
	
	
	public UserAccount() {
		
	}
	public UserAccount(String name, String photo, Location location,
			String password) {
		this.name = name;
		this.photo = photo;
		this.location = new Location(location.getCode(),location.getName());
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
