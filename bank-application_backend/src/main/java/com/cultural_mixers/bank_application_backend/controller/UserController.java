package com.cultural_mixers.bank_application_backend.controller;

import com.cultural_mixers.bank_application_backend.controller.utils.R;
import com.cultural_mixers.bank_application_backend.domain.User;
import com.cultural_mixers.bank_application_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/user/{userId}")
	public R selectByUser_id(@PathVariable Integer userId){
		return new R(true, userService.selectByUser_id(userId));
	}

	@GetMapping("/user_list/{userId}")
	public R selectUserList(@PathVariable Integer userId){
		return new R(true, userService.selectUserList(userId));
	}

	@GetMapping("/selectBalance/{user_id}")
	public R selectBalance(@PathVariable Integer user_id){
		return new R(true, userService.selectBalance(user_id));
	}
}