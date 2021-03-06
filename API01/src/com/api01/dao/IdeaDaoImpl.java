package com.api01.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.api01.bean.Idea;
import com.api01.bean.Idea.EnumState;
import com.api01.bean.UpVote;
import com.api01.bean.User;

/**
 * @author samuel
 *
 */
public class IdeaDaoImpl implements IIdeaDao {

	@Autowired
	SessionFactory sessionFactory;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.api01.dao.IIdeaDao#addIdea(com.api01.bean.Idea)
	 */
	@Transactional
	@Override
	public Integer addIdea(Idea i) {
		Serializable id;
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		try {
			session.saveOrUpdate(i);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			tx.commit();
			id = session.getIdentifier(i);
			i.setIdea_id((Integer) id);
			session.close();
		}

		return (Integer) id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.api01.dao.IIdeaDao#updateIdea(com.api01.bean.Idea)
	 */
	@Transactional
	@Override
	public Integer updateIdea(Idea i) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		Serializable id = 0;

		try {
			session.saveOrUpdate(i);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			tx.commit();
			id = session.getIdentifier(i);
			session.close();
		}

		return (Integer) id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.api01.dao.IIdeaDao#removerIdea(com.api01.bean.Idea)
	 */
	@Transactional
	@Override
	public void removerIdea(Idea i) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		try {
			session.delete(i);
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
	 * @see com.api01.dao.IIdeaDao#getIdeaById(java.lang.Integer)
	 */
	@Transactional
	@Override
	public Idea getIdeaById(Integer id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Idea idea = null;
		try {
			idea = (Idea) session.get(Idea.class, id);
			Hibernate.initialize(idea);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				tx.commit();
				session.close();
			}
		}
		return idea;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.api01.dao.IIdeaDao#getIdeas()
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public List<Idea> getIdeas() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		List<Idea> ideas = null;
		Criteria criteria = null;

		try {
			criteria = session.createCriteria(Idea.class);
			ideas = (List<Idea>) criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				tx.commit();
				session.close();
			}
		}
		return ideas;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Idea> getIdeaByUser(User u) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		Criteria criteria = null;
		List<Idea> idea = null;
		try {
			criteria = session.createCriteria(Idea.class);
			idea = (List<Idea>) criteria.add(Restrictions.eq("user", u)).list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				tx.commit();
				session.close();
			}
		}
		return idea;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UpVote> getLikes(Idea i) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		Criteria criteria = null;
		List<UpVote> likes= null;
		try {
			criteria = session.createCriteria(UpVote.class);
			likes = (List<UpVote>) criteria.add(Restrictions.eq("idea", i)).list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				tx.commit();
				session.close();
			}
		}
		return likes;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UpVote> getDislikes(Idea i) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		Criteria criteria = null;
		List<UpVote> dislikes= null;
		try {
			criteria = session.createCriteria(UpVote.class);
			dislikes = (List<UpVote>) criteria.add(Restrictions.eq("idea", i)).list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				tx.commit();
				session.close();
			}
		}
		return dislikes;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Idea> getIdeaTitle(String title) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		Criteria criteria = null;
		ArrayList<Idea> ideas= null;
		try {
			criteria = session.createCriteria(Idea.class);
			ideas = (ArrayList<Idea>) criteria.add(Restrictions.like("title", title + "%")).list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				tx.commit();
				session.close();
			}
		}
		return ideas;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Idea> getIdeasByState(EnumState i) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		Criteria criteria = null;
		List<Idea> ideas = null;
		try {
			criteria = session.createCriteria(Idea.class);
			ideas = (List<Idea>) criteria.add(Restrictions.eq("state", i)).list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				tx.commit();
				session.close();
			}
		}
		return ideas;
	}

}
