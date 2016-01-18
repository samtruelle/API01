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

import com.api01.bean.Comment;
import com.api01.bean.Idea;
import com.api01.bean.User;

/**
 * @author samuel
 *
 */
public class CommentDaoImpl implements ICommentDao {

	@Autowired
	SessionFactory sessionFactory;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.api01.dao.IComment#addComment(com.api01.bean.Comment)
	 */
	@Override
	public Integer addComment(Comment comm) {
		Serializable id;
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		try {
			session.saveOrUpdate(comm);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			tx.commit();
			id = session.getIdentifier(comm);
			comm.setComment_id((Integer) id);
			session.close();
		}

		return (Integer) id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.api01.dao.IComment#updateComment(com.api01.bean.Comment)
	 */
	@Override
	public Integer updateComment(Comment comm) {
		Serializable id;
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		try {
			session.saveOrUpdate(comm);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			tx.commit();
			id = session.getIdentifier(comm);
			session.close();
		}

		return (Integer) id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.api01.dao.IComment#removeComment(com.api01.bean.Comment)
	 */
	@Override
	public void removeComment(Comment comm) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		try {
			session.delete(comm);
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
	 * @see com.api01.dao.IComment#getCommentByComment__ID(java.lang.Integer)
	 */
	@Override
	public Comment getCommentByComment__ID(Integer id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Comment comment = null;
		try {
			comment = (Comment) session.get(Comment.class, id);
			Hibernate.initialize(comment);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				tx.commit();
				session.close();
			}
		}
		return comment;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.api01.dao.IComment#getCommentByIdea(com.api01.bean.Idea)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Comment> getCommentByIdea(Idea i) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		Criteria criteria = null;
		List<Comment> comments = null;
		try {
			criteria = session.createCriteria(Comment.class);
			comments = (List<Comment>) criteria.add(Restrictions.eq("idea", i)).list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				tx.commit();
				session.close();
			}
		}
		return comments;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.api01.dao.IComment#getCommentByUser(com.api01.bean.User)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Comment> getCommentByUser(User u) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		Criteria criteria = null;
		List<Comment> comments = null;
		try {
			criteria = session.createCriteria(Comment.class);
			comments = (List<Comment>) criteria.add(Restrictions.eq("user", u)).list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				tx.commit();
				session.close();
			}
		}
		return comments;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.api01.dao.IComment#getCommentByUserByIdea(com.api01.bean.User,
	 * com.api01.bean.Idea)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Comment> getCommentByUserByIdea(User u, Idea i) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		Criteria criteria = null;
		List<Comment> comments = null;
		try {
			criteria = session.createCriteria(Comment.class);
			comments = (List<Comment>) criteria.add(Restrictions.eq("user", u)).add(Restrictions.eq("idea", i)).list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				tx.commit();
				session.close();
			}
		}
		return comments;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.api01.dao.IComment#getComments()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Comment> getComments() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		List<Comment> comments = null;
		Criteria criteria = null;

		try {
			criteria = session.createCriteria(Comment.class);
			comments = (List<Comment>) criteria.addOrder(org.hibernate.criterion.Order.desc("date")).list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				tx.commit();
				session.close();
			}
		}
		return comments;
	}

}
