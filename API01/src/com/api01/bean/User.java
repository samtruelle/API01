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
	   public int getId() {
	      return id;
	   }
	   public void setId( int id ) {
	      this.id = id;
	   }
	   public String getFirstName() {
	      return firstName;
	   }
	   public void setFirstName( String first_name ) {
	      this.firstName = first_name;
	   }
	   public String getLastName() {
	      return lastName;
	   }
	   public void setLastName( String last_name ) {
	      this.lastName = last_name;
	   }
	   public int getSalary() {
	      return salary;
	   }
	   public void setSalary( int salary ) {
	      this.salary = salary;
	   }
	}
}
