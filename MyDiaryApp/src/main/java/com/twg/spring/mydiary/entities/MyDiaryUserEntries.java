package com.twg.spring.mydiary.entities;

import java.util.Date; //must import from java.util.Date, java.sql.Date is failing

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "mydiary_user_entries")
public class MyDiaryUserEntries {

	@Id
	@Column(name = "entry_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int entryId;

	@Column(name = "user_name")
	private String userName;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "entry_date")
	private Date entryDate;

	@Column(name = "entry_text")
	private String entryText;

	public MyDiaryUserEntries(int entryId, String userName, Date entryDate, String entryText) {
		super();
		this.entryId = entryId;
		this.userName = userName;
		this.entryDate = entryDate;
		this.entryText = entryText;
	}

	public MyDiaryUserEntries() {

	}

	public int getEntryId() {
		return entryId;
	}

	public void setEntryId(int entryId) {
		this.entryId = entryId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	public String getEntryText() {
		return entryText;
	}

	public void setEntryText(String entryText) {
		this.entryText = entryText;
	}

	@Override
	public String toString() {
		return "MyDiaryUserEntries [entryId=" + entryId + ", userName=" + userName + ", entryDate=" + entryDate
				+ ", entryText=" + entryText + "]";
	}

}
