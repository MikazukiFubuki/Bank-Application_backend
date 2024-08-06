package com.cultural_mixers.bank_application_backend.controller;

import com.cultural_mixers.bank_application_backend.controller.utils.R;
import com.cultural_mixers.bank_application_backend.domain.Send;
import com.cultural_mixers.bank_application_backend.service.SendService;
import com.cultural_mixers.bank_application_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@CrossOrigin
@RestController
@RequestMapping("/send")
public class SendController {

	@Autowired
	private SendService sendService;


	@PutMapping("/")
	public R sendMoney(@RequestBody Send send) throws IOException {
		boolean flag = sendService.sendMoney(send);
		return new R(flag);
	}
}

