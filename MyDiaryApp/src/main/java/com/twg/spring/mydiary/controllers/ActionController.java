package com.twg.spring.mydiary.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.twg.spring.mydiary.business.MyDiaryUserEntriesBusiness;
import com.twg.spring.mydiary.business.MyDiaryUsersBusiness;
import com.twg.spring.mydiary.entities.MyDiaryUserEntries;
import com.twg.spring.mydiary.entities.MyDiaryUsers;

@Controller
public class ActionController {

	@Autowired
	@Qualifier("myDiaryUsersBusiness")
	MyDiaryUsersBusiness myDiaryUsersBusiness;

	@Autowired
	@Qualifier("myDiaryUserEntriesBusiness")
	MyDiaryUserEntriesBusiness myDiaryUserEntriesBusiness;

	@Autowired
	HttpSession session;

	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	public ModelAndView registerUser(@ModelAttribute("myDiaryUsers") MyDiaryUsers inMyDiaryuser) {
		ModelAndView modelView = new ModelAndView();
		String enteredUserName = inMyDiaryuser.getUserName();
		MyDiaryUsers existingUser = myDiaryUsersBusiness.getUserDetailsByName(enteredUserName);
		if (existingUser != null) {
			System.out.println("User already present in table!!");
			modelView.addObject("RegsitrationStatus", "UserExists");
		} else {
			System.out.println("New User!!");
			myDiaryUsersBusiness.saveUserDetails(inMyDiaryuser);
			modelView.addObject("RegsitrationStatus", "UserRegistered");
		}
		modelView.setViewName("RegsitrationStatusPage");
		return modelView;
	}

	@RequestMapping(value = "/authenticateUser", method = RequestMethod.POST)
	public ModelAndView authenticateUser(@ModelAttribute("myDiaryUsers") MyDiaryUsers inMyDiaryuser) {
		ModelAndView modelView = new ModelAndView();
		// reading entered data in login form
		String enteredUserName = inMyDiaryuser.getUserName();
		String enteredPassword = inMyDiaryuser.getUserPassword();
		System.out.println("Entered UserName: " + enteredUserName);
		System.out.println("Entered Password: " + enteredPassword);

		// retrieving the data for that user from DB
		MyDiaryUsers existingUserDataInDB = (MyDiaryUsers) myDiaryUsersBusiness.getUserDetailsByName(enteredUserName);

		if (existingUserDataInDB == null) {
			System.out.println("Username doesnot exists in DB!!");
			modelView.addObject("LoginStatus", "UserNotExits");
			modelView.setViewName("LoginPage");
		} else {
			System.out.println("Username exists in DB!!");
			String existingPasswordInDB = existingUserDataInDB.getUserPassword();
			if (enteredPassword.equalsIgnoreCase(existingPasswordInDB) == false) {
				System.out.println("Wrong Password!!");
				modelView.addObject("LoginStatus", "WrongPassword");
				modelView.setViewName("LoginPage");
			} else {
				System.out.println("Login Successful");
				modelView.setViewName("HomePage");
				modelView.addObject("userDetails", existingUserDataInDB);
				session.setAttribute("userDetails", existingUserDataInDB);
				// Getting the Diary Entries of the user.
				List<MyDiaryUserEntries> lisUserEntriesFromDB = (List<MyDiaryUserEntries>) myDiaryUserEntriesBusiness
						.getUserEntries(existingUserDataInDB.getUserName());
				modelView.addObject("listUserEntries", lisUserEntriesFromDB);
			}
		}
		return modelView;
	}

	@RequestMapping(value = "/saveDiaryEntry", method = RequestMethod.POST)
	public ModelAndView saveDiaryEntry(@ModelAttribute("myDiaryUserEntries") MyDiaryUserEntries userEntry) {
		ModelAndView modelView = new ModelAndView("HomePage");
		// Security to page: reading userObject from session.
		MyDiaryUsers loggedInMyDiaryUser = (MyDiaryUsers) session.getAttribute("userDetails");
		if (loggedInMyDiaryUser == null) {
			System.out.println("User trying to access the page without actually logging in!!");
			modelView.setViewName("LoginPage");
			modelView.addObject("LoginStatus", "UserNotLoggedIn");
			return modelView;
		}
		myDiaryUserEntriesBusiness.saveUserEntry(userEntry);
		// Getting the Diary Entries of the user.
		List<MyDiaryUserEntries> lisUserEntriesFromDB = (List<MyDiaryUserEntries>) myDiaryUserEntriesBusiness
				.getUserEntries(userEntry.getUserName());
		modelView.addObject("listUserEntries", lisUserEntriesFromDB);
		return modelView;
	}

	@RequestMapping(value = "/viewEntryPage")
	public ModelAndView viewEntryPage(@RequestParam("entryId") int entryId) {
		ModelAndView modelView = new ModelAndView();
		MyDiaryUserEntries userEntryFromDB = (MyDiaryUserEntries) myDiaryUserEntriesBusiness.getUserEntry(entryId);
		modelView.setViewName("ViewEntryPage");
		modelView.addObject("userEntryById", userEntryFromDB);
		return modelView;
	}

	@RequestMapping(value = "/updateEntryPage")
	public ModelAndView updateEntryPage(@RequestParam("entryId") int entryId) {
		ModelAndView modelView = new ModelAndView();
		// Security to page: reading userObject from session.
		MyDiaryUsers loggedInMyDiaryUser = (MyDiaryUsers) session.getAttribute("userDetails");
		if (loggedInMyDiaryUser == null) {
			System.out.println("User trying to access the page without actually logging in!!");
			modelView.setViewName("LoginPage");
			modelView.addObject("LoginStatus", "UserNotLoggedIn");
			return modelView;
		}
		MyDiaryUserEntries userEntryFromDB = (MyDiaryUserEntries) myDiaryUserEntriesBusiness.getUserEntry(entryId);
		modelView.setViewName("UpdateEntryPage");
		modelView.addObject("userEntryById", userEntryFromDB);
		return modelView;
	}

	@RequestMapping(value = "/deleteEntryPage")
	public ModelAndView deleteEntryPage(@RequestParam("entryId") int entryId) {
		ModelAndView modelView = new ModelAndView();
		// Security to page: reading userObject from session.
		MyDiaryUsers loggedInMyDiaryUser = (MyDiaryUsers) session.getAttribute("userDetails");
		if (loggedInMyDiaryUser == null) {
			System.out.println("User trying to access the page without actually logging in!!");
			modelView.setViewName("LoginPage");
			modelView.addObject("LoginStatus", "UserNotLoggedIn");
			return modelView;
		}
		// For the respective entry getting the row from DB
		MyDiaryUserEntries userEntryFromDB = (MyDiaryUserEntries) myDiaryUserEntriesBusiness.getUserEntry(entryId);
		// Deleting the row from the DB
		myDiaryUserEntriesBusiness.deleteUserEntry(userEntryFromDB);
		// Getting the Diary Entries of the user.
		List<MyDiaryUserEntries> lisUserEntriesFromDB = (List<MyDiaryUserEntries>) myDiaryUserEntriesBusiness
				.getUserEntries(loggedInMyDiaryUser.getUserName());
		modelView.addObject("listUserEntries", lisUserEntriesFromDB);
		modelView.setViewName("HomePage");
		return modelView;
	}

	@RequestMapping(value = "/updateDiaryEntry", method = RequestMethod.POST)
	public ModelAndView updateDiaryEntry(@ModelAttribute("myDiaryUserEntries") MyDiaryUserEntries updatedDiaryEntry) {
		ModelAndView modelView = new ModelAndView();
		// Security to page: reading userObject from session.
		MyDiaryUsers loggedInMyDiaryUser = (MyDiaryUsers) session.getAttribute("userDetails");
		if (loggedInMyDiaryUser == null) {
			System.out.println("User trying to access the page without actually logging in!!");
			modelView.setViewName("LoginPage");
			modelView.addObject("LoginStatus", "UserNotLoggedIn");
			return modelView;
		}
		myDiaryUserEntriesBusiness.updateUserEntry(updatedDiaryEntry);
		modelView.setViewName("HomePage");
		// Getting the Diary Entries of the user.
		List<MyDiaryUserEntries> lisUserEntriesFromDB = (List<MyDiaryUserEntries>) myDiaryUserEntriesBusiness
				.getUserEntries(updatedDiaryEntry.getUserName());
		modelView.addObject("listUserEntries", lisUserEntriesFromDB);
		return modelView;
	}

	@RequestMapping("/useSignOut")
	public ModelAndView userSignOut() {
		session.invalidate();
		return (new ModelAndView("LoginPage"));
	}
}
