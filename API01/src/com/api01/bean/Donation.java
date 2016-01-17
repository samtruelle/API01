package com.api01.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;

@Entity
@Table(name = "Donation")
public class Donation {
	@Id
	@GeneratedValue
	@Column(name = "Donation_id")
	private Integer Donation_id;

	@Column(name = "amount", nullable = false)
	private Double amount;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	@ManyToOne
	@JoinColumn(name = "idea_id", nullable = false)
	private Idea idea;
	
	@Column(name="date",nullable=false)
	private Date date;
	
	public Donation() {
		// TODO Auto-generated constructor stub
	}

	public Donation(Double amount, User user, Idea idea) {
		super();
		this.amount= amount;
		this.user = user;
		this.idea = idea;
		this.date = new Date();
	}

	/**
	 * @return the donation_id
	 */
	public Integer getDonation_id() {
		return Donation_id;
	}

	/**
	 * @param donation_id the donation_id to set
	 */
	public void setDonation_id(Integer donation_id) {
		Donation_id = donation_id;
	}

	/**
	 * @return the amount
	 */
	public Double getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(Double amount) {
		this.amount = amount;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the idea
	 */
	public Idea getIdea() {
		return idea;
	}

	/**
	 * @param idea the idea to set
	 */
	public void setIdea(Idea idea) {
		this.idea = idea;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

}