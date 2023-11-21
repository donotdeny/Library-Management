package com.spark.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spark.lms.service.HomeService;

@Controller
public class HomeController {

	@Autowired
	HomeService homeService;
	
	@RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
	public String homePage(Model model) {
		model.addAttribute("topTiles", homeService.getTopTilesMap());
		Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
		boolean isAdmin  = loggedInUser.getAuthorities().stream()
        .anyMatch(authority -> "Admin".equals(authority.getAuthority()));
		model.addAttribute("isAdmin", isAdmin);
		return "home";
	}	
	
}
