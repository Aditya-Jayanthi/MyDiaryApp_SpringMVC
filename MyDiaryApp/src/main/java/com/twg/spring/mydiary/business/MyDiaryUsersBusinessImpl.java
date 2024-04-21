package com.twg.spring.mydiary.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.twg.spring.mydiary.dao.MyDiaryUsersDao;
import com.twg.spring.mydiary.entities.MyDiaryUsers;

@Component("myDiaryUsersBusiness")
public class MyDiaryUsersBusinessImpl implements MyDiaryUsersBusiness {

	@Autowired
	@Qualifier("myDiaryUsersDao")
	MyDiaryUsersDao myDiaryUsersDao;

	@Override
	public void saveUserDetails(MyDiaryUsers mydiaryuser) {
		myDiaryUsersDao.saveUserDetails(mydiaryuser);
	}

	@Override
	public void updateUserDetails(MyDiaryUsers mydiaryuser) {
		myDiaryUsersDao.updateUserDetails(mydiaryuser);
	}

	@Override
	public void deleteUserDetails(MyDiaryUsers mydiaryuser) {
		myDiaryUsersDao.deleteUserDetails(mydiaryuser);
	}

	@Override
	public List<MyDiaryUsers> getAllUsers() {
		return myDiaryUsersDao.getAllUsers();
	}

	@Override
	public MyDiaryUsers getUserDetails(int userId) {
		return myDiaryUsersDao.getUserDetails(userId);
	}

	@Override
	public MyDiaryUsers getUserDetailsByName(String myDiaryUserName) {
		List<MyDiaryUsers> lisUsers = myDiaryUsersDao.getUserDetailsByName(myDiaryUserName);
		if(lisUsers.isEmpty()) {
			return null;
		}
		return lisUsers.get(0);
	}

}
