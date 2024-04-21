package com.twg.spring.mydiary.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.twg.spring.mydiary.business.MyDiaryUserEntriesBusiness;
import com.twg.spring.mydiary.business.MyDiaryUsersBusiness;
import com.twg.spring.mydiary.entities.MyDiaryUserEntries;
import com.twg.spring.mydiary.entities.MyDiaryUsers;

@Controller
public class PageNavigationController {

	@Autowired
	@Qualifier("myDiaryUsersBusiness")
	MyDiaryUsersBusiness myDiaryUsersBusiness;

	@Autowired
	@Qualifier("myDiaryUserEntriesBusiness")
	MyDiaryUserEntriesBusiness myDiaryUserEntriesBusiness;

	@Autowired
	HttpSession session;

	@RequestMapping(value = "/loginPage")
	public ModelAndView loginPage() {
		ModelAndView modelView = new ModelAndView();
		modelView.setViewName("LoginPage");
		return modelView;
	}

	@RequestMapping(value = "/registerPage")
	public ModelAndView registerPage() {
		ModelAndView modelView = new ModelAndView();
		modelView.setViewName("RegisterPage");
		return modelView;
	}

	@RequestMapping(value = "/addEntryToDiary")
	public ModelAndView addEntryPage() {
		ModelAndView modelView = new ModelAndView();
		// reading userObject from session.
		MyDiaryUsers myDiaryUser = (MyDiaryUsers) session.getAttribute("userDetails");
		if (myDiaryUser == null) {
			System.out.println("User trying to access the page without actually logging in!!");
			modelView.setViewName("LoginPage");
			modelView.addObject("LoginStatus","UserNotLoggedIn");
			return modelView;
		}
		modelView.setViewName("AddEntryPage");
		return modelView;
	}

	@RequestMapping(value = "/userHomePage")
	public ModelAndView userHomePage() {
		ModelAndView modelView = new ModelAndView("HomePage");
		// reading userObject from session.
		MyDiaryUsers myDiaryUser = (MyDiaryUsers) session.getAttribute("userDetails");
		if (myDiaryUser == null) {
			System.out.println("User trying to access the page without actually logging in!!");
			modelView.addObject("LoginStatus","UserNotLoggedIn");
			modelView.setViewName("LoginPage");
			return modelView;
		}
		// Getting the Diary Entries of the logged in user.
		List<MyDiaryUserEntries> lisUserEntriesFromDB = (List<MyDiaryUserEntries>) myDiaryUserEntriesBusiness
				.getUserEntries(myDiaryUser.getUserName());
		modelView.addObject("listUserEntries", lisUserEntriesFromDB);
		return modelView;
	}
}
