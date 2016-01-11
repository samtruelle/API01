package com.api01.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;

@Entity
@Table(name="user")
public class User {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;
	
	@Column(name="password")
	private String password;
	
	@Column(name="email")
	private String email;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="adress")
	private String adress;
	
	@Column(name="telephone")
	private int telephone;
	
	@Column(name="creation_date")
	private Date creationDate;
	
	@Column(name="account")
	private boolean account;
	
	@Column(name="admin")
	private boolean admin;
	
	public User(){};
	
	public User(String password, String email, String firstName, String lastName, String adress, int telephone,
			Date creationDate, boolean account, boolean admin) {
		super();
		this.password = password;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.adress = adress;
		this.telephone = telephone;
		this.creationDate = creationDate;
		this.account = account;
		this.admin = admin;
	}
	
	public Integer getId() {
		return id;
	}
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}	
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public int getTelephone() {
		return telephone;
	}
	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean isAccount() {
		return account;
	}
	public void setAccount(boolean account) {
		this.account = account;
	}
}

