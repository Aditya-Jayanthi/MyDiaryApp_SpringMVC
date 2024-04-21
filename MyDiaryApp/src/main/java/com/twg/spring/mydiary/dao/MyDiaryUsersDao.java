package com.twg.spring.mydiary.dao;

import java.util.List;

import com.twg.spring.mydiary.entities.MyDiaryUsers;

public interface MyDiaryUsersDao {
	public void saveUserDetails(MyDiaryUsers mydiaryuser);

	public void updateUserDetails(MyDiaryUsers mydiaryuser);

	public void deleteUserDetails(MyDiaryUsers mydiaryuser);

	public List<MyDiaryUsers> getAllUsers();

	public MyDiaryUsers getUserDetails(int userId);
	
	public List<MyDiaryUsers> getUserDetailsByName(String myDiaryUserName);
}
