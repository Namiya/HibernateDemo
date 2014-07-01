package org.namiya.dto;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UserDetails {

/*	
	@EmbeddedID
	private LoginName userID;
	
*/	
	@Id @GeneratedValue 
	private int userId;
	private String userName;
	private Date joinedDate;
	
	
/*
 *  Example for Embedded Objects 
 * 	@AttributeOverrides({
	@AttributeOverride(name="street", column=@Column(name="Home_STREET_NAME")),
	@AttributeOverride(name="city", column=@Column(name="Home_CITY_NAME")),
	@AttributeOverride(name="state", column=@Column(name="Home_STATE_NAME")),
	@AttributeOverride(name="pincode", column=@Column(name="Home_PINCODE_NAME"))
	})
	private Address homeAddress;

	private Address officeAddress;
*/	
	@ElementCollection
	private Set<Address> ListOfAddresses = new HashSet();
	
	public Date getJoinedDate() {
		return joinedDate;
	}
	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	private String description;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Set<Address> getListOfAddresses() {
		return ListOfAddresses;
	}
	public void setListOfAddresses(Set<Address> listOfAddresses) {
		ListOfAddresses = listOfAddresses;
	}
}
