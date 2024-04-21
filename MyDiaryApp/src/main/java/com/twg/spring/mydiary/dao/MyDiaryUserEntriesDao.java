package com.twg.spring.mydiary.dao;

import java.util.List;

import com.twg.spring.mydiary.entities.MyDiaryUserEntries;

public interface MyDiaryUserEntriesDao {
	public void saveUserEntry(MyDiaryUserEntries mydiaryUserEntry);

	public void updateUserEntry(MyDiaryUserEntries myDiaryUserEntry);

	public void deleteUserEntry(MyDiaryUserEntries mydiaryUserEntry);

	public List<MyDiaryUserEntries> getAllUserEntries();

	public MyDiaryUserEntries getUserEntry(int entryId);
	
	public List<MyDiaryUserEntries> getUserEntries(String myDiaryUserName);
}
