package com.twg.spring.mydiary.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.twg.spring.mydiary.entities.MyDiaryUsers;

@Component("myDiaryUsersDao")
public class MyDiaryUsersDaoImpl implements MyDiaryUsersDao {

	@Autowired
	HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	@Transactional(readOnly = false)
	public void saveUserDetails(MyDiaryUsers mydiaryuser) {
		hibernateTemplate.save(mydiaryuser);
	}

	@Override
	@Transactional(readOnly = false)
	public void updateUserDetails(MyDiaryUsers mydiaryuser) {
		hibernateTemplate.update(mydiaryuser);
	}

	@Override
	@Transactional(readOnly = false)
	public void deleteUserDetails(MyDiaryUsers mydiaryuser) {
		hibernateTemplate.delete(mydiaryuser);
	}

	@Override
	public List<MyDiaryUsers> getAllUsers() {
		List<MyDiaryUsers> lisUsers = hibernateTemplate.loadAll(MyDiaryUsers.class);
		return lisUsers;
	}

	@Override
	public MyDiaryUsers getUserDetails(int userId) {
		MyDiaryUsers mydiaryUser = hibernateTemplate.get(MyDiaryUsers.class, userId);
		return mydiaryUser;
	}

	@Override
	public List<MyDiaryUsers> getUserDetailsByName(String myDiaryUserName) {
		DetachedCriteria criteria = DetachedCriteria.forClass(MyDiaryUsers.class);
		criteria.add(Restrictions.eq("userName", myDiaryUserName));
		List<MyDiaryUsers> lisUsers = (List<MyDiaryUsers>) hibernateTemplate.findByCriteria(criteria);
		return lisUsers;
	}

}
