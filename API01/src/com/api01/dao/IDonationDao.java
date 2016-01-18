/**
 * 
 */
package com.api01.dao;

import java.util.List;

import javax.transaction.Transactional;

import com.api01.bean.Donation;
import com.api01.bean.Idea;
import com.api01.bean.User;

/**
 * @author samuel
 *
 */
public interface IDonationDao {
	
	@Transactional
	Integer addDonation(Donation d);
	
	@Transactional
	Integer upDateDonation(Donation d);
	
	@Transactional
	void removeDonation(Donation d);
	
	@Transactional
	Donation getDonationByDonation__ID(Integer id);
	
	@Transactional
	List<Donation> getDonationByIdea(Idea i);

	@Transactional
	List<Donation> getDonationByUser(User u);

	@Transactional
	List<Donation> getDonations();

}
