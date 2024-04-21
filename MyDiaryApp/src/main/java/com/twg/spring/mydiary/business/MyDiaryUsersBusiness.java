package com.twg.spring.mydiary.business;

import java.util.List;

import com.twg.spring.mydiary.entities.MyDiaryUsers;

public interface MyDiaryUsersBusiness {
	public void saveUserDetails(MyDiaryUsers mydiaryuser);

	public void updateUserDetails(MyDiaryUsers mydiaryuser);

	public void deleteUserDetails(MyDiaryUsers mydiaryuser);

	public List<MyDiaryUsers> getAllUsers();

	public MyDiaryUsers getUserDetails(int userId);
	
	public MyDiaryUsers getUserDetailsByName(String myDiaryUserName);
}
