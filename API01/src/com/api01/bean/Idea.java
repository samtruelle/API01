package com.api01.bean;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Idea {
	
   private enum myEnum{proposal, discussion, redaction, evaluation, fund};
   
   @Id @GeneratedValue
   @Column(name = "id")
   private int id;
   
   @Column(name = "description")
   private String description;
   
   @Column(name = "application")
   private String application;
   
   @Column(name = "targeted_market")
   private String targeted_market;
   
   @Column(name = "fund")
   private double fund;
   
   @Column(name = "state")
   private myEnum state;
   
   @Column(name = "longer_summary")
   private String longer_summary;

	public int getId() {
		return id;
	}
	
	public Idea() {}
	
	public Idea(int id, String description, String application, String targeted_market, double fund, myEnum state,
			String longer_summary) {
		super();
		this.id = id;
		this.description = description;
		this.application = application;
		this.targeted_market = targeted_market;
		this.fund = fund;
		this.state = state;
		this.longer_summary = longer_summary;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getApplication() {
		return application;
	}
	
	public void setApplication(String application) {
		this.application = application;
	}
	
	public String getTargeted_market() {
		return targeted_market;
	}
	
	public void setTargeted_market(String targeted_market) {
		this.targeted_market = targeted_market;
	}
	
	public double getFund() {
		return fund;
	}
	
	public void setFund(double fund) {
		this.fund = fund;
	}
	
	public myEnum getState() {
		return state;
	}
	
	public void setState(myEnum state) {
		this.state = state;
	}
	
	public String getLonger_summary() {
		return longer_summary;
	}
	
	public void setLonger_summary(String longer_summary) {
		this.longer_summary = longer_summary;
	}
}
