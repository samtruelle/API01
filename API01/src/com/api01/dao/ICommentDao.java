/**
 * 
 */
package com.api01.dao;

import java.util.List;

import javax.transaction.Transactional;

import com.api01.bean.Comment;
import com.api01.bean.Idea;
import com.api01.bean.Idea.EnumState;
import com.api01.bean.User;

/**
 * @author samuel
 *
 */
public interface ICommentDao {
	@Transactional
	Integer addComment(Comment comm);

	@Transactional
	Integer updateComment(Comment comm);

	@Transactional
	void removeComment(Comment comm);

	@Transactional
	Comment getCommentByComment__ID(Integer id);

	@Transactional
	List<Comment> getCommentByIdea(Idea i);

	@Transactional
	List<Comment> getCommentByUser(User u);

	@Transactional
	List<Comment> getCommentByUserByIdea(User u, Idea i);

	@Transactional
	List<Comment> getCommentByUserByIdea_state(User u, EnumState i);
	
	@Transactional
	List<Comment> getCommentByIdea_state(EnumState en);

	@Transactional
	List<Comment> getComments();
}
