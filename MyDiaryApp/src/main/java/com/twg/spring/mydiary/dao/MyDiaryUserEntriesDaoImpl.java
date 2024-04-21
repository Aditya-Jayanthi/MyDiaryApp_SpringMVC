package com.twg.spring.mydiary.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.twg.spring.mydiary.entities.MyDiaryUserEntries;

@Component("myDiaryUserEntriesDao")
public class MyDiaryUserEntriesDaoImpl implements MyDiaryUserEntriesDao {

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
	public void saveUserEntry(MyDiaryUserEntries mydiaryUserEntry) {
		hibernateTemplate.save(mydiaryUserEntry);
	}

	@Override
	@Transactional(readOnly = false)
	public void updateUserEntry(MyDiaryUserEntries myDiaryUserEntry) {
		hibernateTemplate.update(myDiaryUserEntry);
	}

	@Override
	@Transactional(readOnly = false)
	public void deleteUserEntry(MyDiaryUserEntries mydiaryUserEntry) {
		hibernateTemplate.delete(mydiaryUserEntry);
	}

	@Override
	public List<MyDiaryUserEntries> getAllUserEntries() {
		List<MyDiaryUserEntries> lisUserEntries = hibernateTemplate.loadAll(MyDiaryUserEntries.class);
		return lisUserEntries;
	}

	@Override
	public MyDiaryUserEntries getUserEntry(int entryId) {
		MyDiaryUserEntries userEntry = hibernateTemplate.get(MyDiaryUserEntries.class, entryId);
		return userEntry;
	}

	@Override
	public List<MyDiaryUserEntries> getUserEntries(String myDiaryUserName) {
		DetachedCriteria criteria = DetachedCriteria.forClass(MyDiaryUserEntries.class);
		criteria.add(Restrictions.eq("userName", myDiaryUserName));
		List<MyDiaryUserEntries> lisEntries = (List<MyDiaryUserEntries>) hibernateTemplate.findByCriteria(criteria);
		return lisEntries;
	}

}
