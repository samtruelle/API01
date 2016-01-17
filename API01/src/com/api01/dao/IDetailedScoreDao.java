/**
 * 
 */
package com.api01.dao;

import java.util.List;

import javax.transaction.Transactional;

import com.api01.bean.DetailedScore;
import com.api01.bean.Idea;
import com.api01.bean.User;

/**
 * @author samuel
 *
 */
public interface IDetailedScoreDao {

	@Transactional
	int addDetailedScore(DetailedScore ds);

	@Transactional
	int updateDetailedScore(DetailedScore ds);

	@Transactional
	void removeDetailedScore(DetailedScore ds);

	@Transactional
	DetailedScore getDetailedScoreById(Integer id);

	@Transactional
	List<DetailedScore> getDetailedScoreByIdea(Idea i);
	
	@Transactional
	List<DetailedScore> getDetailedScoreByUser(User u);

	@Transactional
	List<DetailedScore> getDetailedScores();

}
