package com.cultural_mixers.bank_application_backend.controller;

import com.cultural_mixers.bank_application_backend.controller.utils.R;
import com.cultural_mixers.bank_application_backend.domain.User;
import com.cultural_mixers.bank_application_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/selectALL")
    public R selectALL(User user){
		return new R(true, userService.selectALL(user));
	}
}