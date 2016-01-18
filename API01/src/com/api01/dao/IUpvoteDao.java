/**
 * 
 */
package com.api01.dao;

import java.util.List;

import javax.transaction.Transactional;

import com.api01.bean.Idea;
import com.api01.bean.UpVote;
import com.api01.bean.User;

/**
 * @author samuel
 *
 */
public interface IUpvoteDao {
	@Transactional
	Integer addUpVote(UpVote uv);

	@Transactional
	Integer updateUpVote(UpVote uv);

	@Transactional
	void removeUpVote(UpVote uv);

	@Transactional
	UpVote getUpVoteById(Integer id);

	@Transactional
	List<UpVote> getUpVotesByIdea(Idea i);

	@Transactional
	List<UpVote> getUpVotesByUser(User u);

	@Transactional
	List<UpVote> getUpVotesByUserByIdea(User u, Idea i);

	@Transactional
	List<UpVote> getUpVotes();
}
