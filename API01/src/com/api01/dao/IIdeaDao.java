/**
 * 
 */
package com.api01.dao;

import com.api01.bean.Idea;
import com.api01.bean.User;

import java.util.List;

import javax.transaction.Transactional;

/**
 * @author samuel
 *
 */
public interface IIdeaDao {

	@Transactional
	int addIdea(Idea i);
	
	@Transactional
	int updateIdea(Idea i);
	
	@Transactional
	void removerIdea(Idea u);
	
	@Transactional 
	Idea getIdeaById(Integer id);
	
	@Transactional
	List<Idea> getIdeaByUser(User u);
	
	@Transactional
	List<Idea> getIdeas();

}
