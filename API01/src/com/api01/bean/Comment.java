/**
 * 
 */
package com.api01.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.api01.bean.Idea.EnumState;

import javax.persistence.GeneratedValue;

/**
 * @author samuel
 *
 */

@Entity
@Table(name = "comment")
public class Comment {
	@Id
	@GeneratedValue
	@Column(name = "comment_id")
	private Integer Comment_id;

	@Column(name = "comment_text", nullable = false)
	private String text;

	@ManyToOne
	@Cascade(CascadeType.DELETE)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	@ManyToOne
	@Cascade(CascadeType.DELETE)
	@JoinColumn(name = "idea_id", nullable = false)
	private Idea idea;

	@Column(name = "date_creat", nullable = false)
	private Date date;

	@Column(name = "idea_state", nullable = false)
	private EnumState idea_state;

	public Comment() {
		// TODO Auto-generated constructor stub
	}

	public Comment(String text, User user, Idea idea) {
		super();
		this.text = text;
		this.user = user;
		this.idea = idea;
		this.date = new Date();
		this.idea_state = idea.getState();
	}

	/**
	 * @return the comment_id
	 */
	public Integer getComment_id() {
		return Comment_id;
	}

	/**
	 * @param comment_id
	 *            the comment_id to set
	 */
	public void setComment_id(Integer comment_id) {
		Comment_id = comment_id;
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text
	 *            the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user
	 *            the user to set
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
	 * @param idea
	 *            the idea to set
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
	 * @param date
	 *            the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the idea_state
	 */
	public EnumState getIdea_state() {
		return idea_state;
	}

	/**
	 * @param idea_state
	 *            the idea_state to set
	 */
	public void setIdea_state(EnumState idea_state) {
		this.idea_state = idea_state;
	}

}