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
	@Column(name = "user_id")
	private Integer user_id;
	
	@Column(name="password",nullable=false)
	private String password;
	
	@Column(name="email",unique=true,nullable=false)
	private String email;
	
	@Column(name="first_name",nullable=false)
	private String firstName;
	
	@Column(name="last_name",nullable=false)
	private String lastName;
	
	@Column(name="adresse")
	private String adresse;
	
	@Column(name="telephone")
	private int telephone;
	
	@Column(name="creation_date")
	private Date creationDate;
	
	@Column(name="account_blocked")
	private int account_blocked;
	
	@Column(name="admin")
	private int admin;   	
	
	public User(){};
	
	public User(String password, String email, String firstName, String lastName, String adresse, int telephone,
			Date creationDate, int admin, int account_blocked) {
		super();
		this.password = password;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.adresse = adresse;
		this.telephone = telephone;
		this.creationDate = creationDate;
		this.admin = admin;
		this.account_blocked = account_blocked;
	}
	
	public int isAccount() {
		return account_blocked;
	}

	public void setAccount(int account) {
		this.account_blocked = account;
	}

	public Integer getId() {
		return user_id;
	}
	public int isAdmin() {
		return admin;
	}
	public void setAdmin(int admin) {
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
	public String getadresse() {
		return adresse;
	}
	public void setadresse(String adresse) {
		this.adresse = adresse;
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
		this.user_id = id;
	}

}

