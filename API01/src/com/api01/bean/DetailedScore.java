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
public class DetailedScore {
	@Id
	@GeneratedValue
	@Column(name="detailed_score")
	private Integer id;

	@Column(name="feasability")
	private Integer feasability;
	
	@Column(name="market_interest")
	private Integer market_interest;
	
	@Column(name="impact")
	private Integer impact;
	
	@ManyToOne
	@JoinColumn(name="idea_id")
	private Integer idea;
	
	public DetailedScore() {
		// TODO Auto-generated constructor stub
	}

	public DetailedScore(Integer feasability, Integer market_interest, Integer impact, Integer idea) {
		super();
		this.feasability= feasability;
		this.market_interest = market_interest;
		this.impact = impact;
		this.idea = idea;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the feasability
	 */
	public Integer getFeasability() {
		return feasability;
	}

	/**
	 * @param feasability the feasability to set
	 */
	public void setFeasability(Integer feasability) {
		this.feasability = feasability;
	}

	/**
	 * @return the market_interest
	 */
	public Integer getMarket_interest() {
		return market_interest;
	}

	/**
	 * @param market_interest the market_interest to set
	 */
	public void setMarket_interest(Integer market_interest) {
		this.market_interest = market_interest;
	}

	/**
	 * @return the impact
	 */
	public Integer getImpact() {
		return impact;
	}

	/**
	 * @param impact the impact to set
	 */
	public void setImpact(Integer impact) {
		this.impact = impact;
	}
}
