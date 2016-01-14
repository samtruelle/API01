/**
 * 
 */
package com.api01.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import javax.persistence.GeneratedValue;

/**
 * @author samuel
 *
 */
@Entity
@Table
public class UpVote {
	@Id
	@GeneratedValue
	@Column(name="up_id",nullable=false)
	private Integer up_id;
	@Column(name="value",nullable=false)
	private Integer value;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	@Column(name="user",nullable=false)
	private Integer user;
	
	@ManyToOne
	@JoinColumn(name="idea_id")
	@Column(name="idea",nullable=false)
	private Integer idea;
	
	public UpVote() {
		// TODO Auto-generated constructor stub
	}

	public UpVote(Integer value, Integer user, Integer idea) {
		super();
		this.value= value;
		this.user = user;
		this.idea = idea;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return up_id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.up_id = id;
	}

	/**
	 * @return the value
	 */
	public Integer getvalue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setvalue(Integer value) {
		this.value = value;
	}

	/**
	 * @return the user
	 */
	public Integer getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setuser(Integer user) {
		this.user = user;
	}


	/**
	 * @return the user
	 */
	public Integer getIdea() {
		return idea;
	}
	
	
	/**
	 * @param impact the impact to set
	 */
	public void setIdea(Integer idea) {
		this.idea = idea;
	}
}
