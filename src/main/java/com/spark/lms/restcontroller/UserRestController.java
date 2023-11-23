package com.spark.lms.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spark.lms.service.UserService;

@RestController
@RequestMapping(value = "/rest/user")
public class UserRestController {
    @Autowired
	private UserService userService;

    @GetMapping(value = "/{id}/user")
	public Long getMemberByBranch(@PathVariable(name = "id") Integer id) {
		return userService.countByBranchId(id);
	}
}
