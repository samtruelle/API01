package com.api01.bean;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "USER")
public class User {	
	
   @Id @GeneratedValue
   @Column(name = "id")
   private int id;

   @Column(name = "last_name")
   private String lastName;
   
   @Column(name = "first_name")
   private String firstName;
   
   @Column(name = "email")
   private String email;

   @Column(name = "password")
   private String password;
   
   @Column(name = "adresse")
   private String adresse;
   
   @Column(name = "telephone")
   private String telephone;
   
   @Column(name = "creation_date")
   private Date creationDate;  

   @Column(name = "account")
   private String account;
   
   public User() {}
   
   public User(int id, String lastName, String firstName, String email, String password, String adresse, String telephone,
		Date creationDate, String account) {
		super();
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
		this.password = password;
		this.adresse = adresse;
		this.telephone = telephone;
		this.creationDate = creationDate;
		this.account = account;
   }

   public int getId() {
		return id;
   }

	public void setId(int id) {
		this.id = id;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getAdresse() {
		return adresse;
	}
	
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	public String getTelephone() {
		return telephone;
	}
	
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public Date getCreationDate() {
		return creationDate;
	}
	
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	public String getAccount() {
		return account;
	}
	
	public void setAccount(String account) {
		this.account = account;
	}
}
