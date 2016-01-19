/**
 * 
 */
package com.api01.dao;

import com.api01.bean.Idea;
import com.api01.bean.Idea.EnumState;
import com.api01.bean.UpVote;
import com.api01.bean.User;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

/**
 * @author samuel
 *
 */
public interface IIdeaDao {

	@Transactional
	Integer addIdea(Idea i);
	
	@Transactional
	Integer updateIdea(Idea i);
	
	@Transactional
	void removerIdea(Idea u);
	
	@Transactional 
	Idea getIdeaById(Integer id);
	
	@Transactional
	List<Idea> getIdeaByUser(User u);
	
	@Transactional
	List<UpVote> getLikes(Idea i);
	
	@Transactional
	List<UpVote> getDislikes(Idea i);
	
	@Transactional
	List<Idea> getIdeas();
	
	@Transactional
	ArrayList<Idea> getIdeaTitle(String title);
	
	@Transactional
	List<Idea> getIdeasByState(EnumState i);

}
