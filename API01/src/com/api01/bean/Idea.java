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
@Table(name = "idea")
public class Idea {

	public enum EnumState {
		proposal, discussion, redaction, evaluation, fund;
	}

	@Id
	@GeneratedValue
	@Column(name = "idea_id")
	private Integer idea_id;

	@Column(name = "title", nullable=false)
	private String title;

	@Column(name = "description",nullable=false)
	private String description;

	@Column(name = "application",nullable=false)
	private String application;

	@Column(name = "targeted_market",nullable=false)
	private String targeted_market;

	@Column(name = "fund")
	private double fund;

	@Column(name = "state")
	private EnumState state;

	@Column(name = "long_summary")
	private String long_summary;
	
	@ManyToOne
	@JoinColumn(name="user",nullable=false)
	private User user;

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

	public Idea() {
	};

	public Idea(String title, String description, String application, String targeted_market, 
			Double fund, EnumState state, String long_summary, User u) {
		super();
		this.title = title;
		this.description = description;
		this.application = application;
		this.targeted_market = targeted_market;
		this.fund = fund;
		this.state = state;
		this.long_summary = long_summary;
		this.user = u;
	}

	/**
	 * @return the idea_id
	 */
	public Integer getIdea_id() {
		return idea_id;
	}

	/**
	 * @param idea_id the idea_id to set
	 */
	public void setIdea_id(Integer idea_id) {
		this.idea_id = idea_id;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the application
	 */
	public String getApplication() {
		return application;
	}

	/**
	 * @param application the application to set
	 */
	public void setApplication(String application) {
		this.application = application;
	}

	/**
	 * @return the targeted_market
	 */
	public String getTargeted_market() {
		return targeted_market;
	}

	/**
	 * @param targeted_market the targeted_market to set
	 */
	public void setTargeted_market(String targeted_market) {
		this.targeted_market = targeted_market;
	}

	/**
	 * @return the fund
	 */
	public double getFund() {
		return fund;
	}

	/**
	 * @param fund the fund to set
	 */
	public void setFund(double fund) {
		this.fund = fund;
	}

	/**
	 * @return the state
	 */
	public EnumState getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(EnumState state) {
		this.state = state;
	}

	/**
	 * @return the long_summary
	 */
	public String getLong_summary() {
		return long_summary;
	}

	/**
	 * @param long_summary the long_summary to set
	 */
	public void setLong_summary(String long_summary) {
		this.long_summary = long_summary;
	}


	}
