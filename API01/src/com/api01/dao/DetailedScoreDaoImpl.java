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

import com.api01.bean.DetailedScore;
import com.api01.bean.Idea;
import com.api01.bean.User;

/**
 * @author samuel
 *
 */
public class DetailedScoreDaoImpl implements IDetailedScoreDao {

	@Autowired
	SessionFactory sessionFactory;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.api01.dao.IDetailedScore#addDetailedScore(com.api01.bean.
	 * DetailedScore)
	 */
	@Override
	public int addDetailedScore(DetailedScore ds) {
		Serializable id;
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		try {
			session.saveOrUpdate(ds);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			tx.commit();
			id = session.getIdentifier(ds);
			ds.setId((Integer) id);
			session.close();
		}

		return (Integer) id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.api01.dao.IDetailedScore#updateDetailedScore(com.api01.bean.
	 * DetailedScore)
	 */
	@Override
	public int updateDetailedScore(DetailedScore ds) {
		Serializable id;
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		try {
			session.saveOrUpdate(ds);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			tx.commit();
			id = session.getIdentifier(ds);
			ds.setId((Integer) id);
			session.close();
		}

		return (Integer) id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.api01.dao.IDetailedScore#removeDetailedScore(java.lang.Integer)
	 */
	@Override
	public void removeDetailedScore(DetailedScore ds) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		try {
			session.delete(ds);
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
	 * @see com.api01.dao.IDetailedScore#getDetailedScoreById(java.lang.Integer)
	 */
	@Override
	public DetailedScore getDetailedScoreById(Integer id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		DetailedScore detailedScore = null;
		try {
			detailedScore = (DetailedScore) session.get(DetailedScore.class, id);
			Hibernate.initialize(detailedScore);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				tx.commit();
				session.close();
			}
		}
		return detailedScore;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.api01.dao.IDetailedScore#getDetailedScoreByIdea(com.api01.bean.Idea)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<DetailedScore> getDetailedScoreByIdea(Idea i) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		List<DetailedScore> detailedScore = null;
		Criteria criteria = null;
		try {
			criteria = session.createCriteria(DetailedScore.class);
			detailedScore = (List<DetailedScore>) criteria.add(Restrictions.eq("idea", i)).list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				tx.commit();
				session.close();
			}
		}
		return detailedScore;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.api01.dao.IDetailedScore#getDetailedScores()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<DetailedScore> getDetailedScores() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		List<DetailedScore> detailedScores = null;
		Criteria criteria = null;

		try {
			criteria = session.createCriteria(DetailedScore.class);
			detailedScores = (List<DetailedScore>) criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				tx.commit();
				session.close();
			}
		}
		return detailedScores;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DetailedScore> getDetailedScoreByUser(User u) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		List<DetailedScore> detailedScore = null;
		Criteria criteria = null;
		try {
			criteria = session.createCriteria(DetailedScore.class);
			detailedScore = (List<DetailedScore>) criteria.add(Restrictions.eq("user", u)).list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				tx.commit();
				session.close();
			}
		}
		return detailedScore;
	}

}
