package com.twg.spring.mydiary.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.twg.spring.mydiary.dao.MyDiaryUserEntriesDao;
import com.twg.spring.mydiary.entities.MyDiaryUserEntries;

@Component("myDiaryUserEntriesBusiness")
public class MyDiaryUserEntriesBusinessImpl implements MyDiaryUserEntriesBusiness {

	@Autowired
	@Qualifier("myDiaryUserEntriesDao")
	MyDiaryUserEntriesDao myDiaryUserEntriesDao;

	public MyDiaryUserEntriesDao getMyDiaryUsersDao() {
		return myDiaryUserEntriesDao;
	}

	public void setMyDiaryUsersDao(MyDiaryUserEntriesDao myDiaryUserEntriesDao) {
		this.myDiaryUserEntriesDao = myDiaryUserEntriesDao;
	}

	@Override
	public void saveUserEntry(MyDiaryUserEntries mydiaryUserEntry) {
		myDiaryUserEntriesDao.saveUserEntry(mydiaryUserEntry);
	}

	@Override
	public void updateUserEntry(MyDiaryUserEntries myDiaryUserEntry) {
		myDiaryUserEntriesDao.updateUserEntry(myDiaryUserEntry);
	}

	@Override
	public void deleteUserEntry(MyDiaryUserEntries mydiaryUserEntry) {
		myDiaryUserEntriesDao.deleteUserEntry(mydiaryUserEntry);
	}

	@Override
	public List<MyDiaryUserEntries> getAllUserEntries() {
		return myDiaryUserEntriesDao.getAllUserEntries();
	}

	@Override
	public MyDiaryUserEntries getUserEntry(int entryId) {
		return myDiaryUserEntriesDao.getUserEntry(entryId);
	}

	@Override
	public List<MyDiaryUserEntries> getUserEntries(String myDiaryUserName) {
		return myDiaryUserEntriesDao.getUserEntries(myDiaryUserName);
	}

}
