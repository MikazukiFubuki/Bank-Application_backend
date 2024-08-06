package com.cultural_mixers.bank_application_backend.controller;

import com.cultural_mixers.bank_application_backend.controller.utils.R;
import com.cultural_mixers.bank_application_backend.domain.Pay;
import com.cultural_mixers.bank_application_backend.domain.Send;
import com.cultural_mixers.bank_application_backend.service.PayService;
import com.cultural_mixers.bank_application_backend.service.SendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@CrossOrigin
@RestController
@RequestMapping("/pay")
public class PayController {

	@Autowired
	private PayService payService;


	@PostMapping("/")
	public R payment(@RequestBody Pay pay) throws IOException {
		boolean flag = payService.payment(pay);
		return new R(flag);
	}


}

