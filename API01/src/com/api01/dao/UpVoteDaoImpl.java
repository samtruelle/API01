/**
 * 
 */
package com.api01.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.api01.bean.Idea;
import com.api01.bean.UpVote;
import com.api01.bean.User;

/**
 * @author samuel
 *
 */
public class UpVoteDaoImpl implements IUpvoteDao {

	@Autowired
	SessionFactory sessionFactory;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.api01.dao.IUpvote#addUpVote(com.api01.bean.UpVote)
	 */
	@Override
	public Integer addUpVote(UpVote uv) {
		Serializable id;
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		try {
			session.saveOrUpdate(uv);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			tx.commit();
			id = session.getIdentifier(uv);
			uv.setId((Integer) id);
			session.close();
		}

		return (Integer) id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.api01.dao.IUpvote#updateUpVote(com.api01.bean.UpVote)
	 */
	@Override
	public Integer updateUpVote(UpVote uv) {
		Serializable id;
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		try {
			session.saveOrUpdate(uv);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			tx.commit();
			id = session.getIdentifier(uv);
			session.close();
		}

		return (Integer) id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.api01.dao.IUpvote#removeUpVote(com.api01.bean.UpVote)
	 */
	@Override
	public void removeUpVote(UpVote uv) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		try {
			session.delete(uv);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			tx.commit();
			session.close();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.api01.dao.IUpvote#getUpVoteById(java.lang.Integer)
	 */
	@Override
	public UpVote getUpVoteById(Integer id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		UpVote upVote = null;
		try {
			upVote = (UpVote) session.get(UpVote.class, id);
			Hibernate.initialize(upVote);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				tx.commit();
				session.close();
			}
		}
		return upVote;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.api01.dao.IUpvote#getUpVotesByIdea(com.api01.bean.Idea)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<UpVote> getUpVotesByIdea(Idea i) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		Criteria criteria = null;
		List<UpVote> upVote = null;
		try {
			criteria = session.createCriteria(UpVote.class);
			upVote = (List<UpVote>) criteria.add(Restrictions.eq("idea", i)).list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				tx.commit();
				session.close();
			}
		}
		return upVote;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.api01.dao.IUpvote#getUpVotesByUser(com.api01.bean.User)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<UpVote> getUpVotesByUser(User u) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		Criteria criteria = null;
		List<UpVote> upVote = null;
		try {
			criteria = session.createCriteria(UpVote.class);
			upVote = (List<UpVote>) criteria.add(Restrictions.eq("user", u)).list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				tx.commit();
				session.close();
			}
		}
		return upVote;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.api01.dao.IUpvote#getUpVotes()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<UpVote> getUpVotes() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		List<UpVote> upVotes = null;
		Criteria criteria = null;

		try {
			criteria = session.createCriteria(Idea.class);
			upVotes = (List<UpVote>) criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				tx.commit();
				session.close();
			}
		}
		return upVotes;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UpVote> getUpVotesByUserByIdea(User u, Idea i) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		Criteria criteria = null;
		List<UpVote> upVote = null;
		try {
			criteria = session.createCriteria(UpVote.class);
			upVote = (List<UpVote>) criteria.add(Restrictions.eq("user", u)).add(Restrictions.eq("idea", i)).list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				tx.commit();
				session.close();
			}
		}
		return upVote;
	}

}
