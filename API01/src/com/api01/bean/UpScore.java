package com.api01.bean;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import com.api01.bean.User;

public class UpScore {
	
	@Id @GeneratedValue
	@Column(name = "id")
	private int id;
	
	@ManyToOne
    @JoinColumn(name = "id")
	private User user;
	
	private enum myEnum{up, down};	
	@Column(name = "value")
	private myEnum value;
	
	public UpScore() {}
	
	public UpScore(int id, myEnum value) {
		super();
		this.id = id;
		this.value = value;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public myEnum getValue() {
		return value;
	}

	public void setValue(myEnum value) {
		this.value = value;
	}
	
}
