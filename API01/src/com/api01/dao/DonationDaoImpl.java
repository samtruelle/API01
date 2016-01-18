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

import com.api01.bean.Donation;
import com.api01.bean.Idea;
import com.api01.bean.User;

/**
 * @author samuel
 *
 */
public class DonationDaoImpl implements IDonationDao {

	@Autowired
	SessionFactory sessionFactory;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.api01.dao.IDonation#addDonation(com.api01.bean.Donation)
	 */
	@Override
	public Integer addDonation(Donation d) {
		Serializable id;
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		try {
			session.saveOrUpdate(d);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			tx.commit();
			id = session.getIdentifier(d);
			d.setDonation_id((Integer) id);
			session.close();
		}

		return (Integer) id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.api01.dao.IDonation#upDateDonation(com.api01.bean.Donation)
	 */
	@Override
	public Integer upDateDonation(Donation d) {
		Serializable id;
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		try {
			session.saveOrUpdate(d);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			tx.commit();
			id = session.getIdentifier(d);
			session.close();
		}

		return (Integer) id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.api01.dao.IDonation#removeDonation(com.api01.bean.Donation)
	 */
	@Override
	public void removeDonation(Donation d) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		try {
			session.delete(d);
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
	 * @see com.api01.dao.IDonation#getDonationByDonation__ID(java.lang.Integer)
	 */
	@Override
	public Donation getDonationByDonation__ID(Integer id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Donation donation = null;
		try {
			donation = (Donation) session.get(Donation.class, id);
			Hibernate.initialize(donation);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				tx.commit();
				session.close();
			}
		}
		return donation;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.api01.dao.IDonation#getDonationByIdea(com.api01.bean.Idea)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Donation> getDonationByIdea(Idea i) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		Criteria criteria = null;
		List<Donation> donation = null;
		try {
			criteria = session.createCriteria(Donation.class);
			donation = (List<Donation>) criteria.add(Restrictions.eq("idea", i)).list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				tx.commit();
				session.close();
			}
		}
		return donation;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.api01.dao.IDonation#getDonationByUser(com.api01.bean.User)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Donation> getDonationByUser(User u) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		Criteria criteria = null;
		List<Donation> donation = null;
		try {
			criteria = session.createCriteria(Donation.class);
			donation = (List<Donation>) criteria.add(Restrictions.eq("user", u)).list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				tx.commit();
				session.close();
			}
		}
		return donation;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.api01.dao.IDonation#getDonations()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Donation> getDonations() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		List<Donation> donations = null;
		Criteria criteria = null;

		try {
			criteria = session.createCriteria(Donation.class);
			donations = (List<Donation>) criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				tx.commit();
				session.close();
			}
		}
		return donations;
	}

}
