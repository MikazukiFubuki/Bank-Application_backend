package com.cultural_mixers.bank_application_backend.controller;

import com.cultural_mixers.bank_application_backend.controller.utils.R;
import com.cultural_mixers.bank_application_backend.domain.Request;
import com.cultural_mixers.bank_application_backend.domain.Send;
import com.cultural_mixers.bank_application_backend.service.RequestService;
import com.cultural_mixers.bank_application_backend.service.SendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@CrossOrigin
@RestController
@RequestMapping("/reqMoney")
public class RequestController {

	@Autowired
	private RequestService requestService;


	@PostMapping("/")
	public R reqMoney(@RequestBody Request request) throws IOException {
		boolean flag = requestService.requestMoney(request);
		return new R(flag, requestService.requestMoneySelect(request));
	}

	@GetMapping("/{request_id}")
	public R selectRequest(@PathVariable Integer request_id){
		return new R(true, requestService.selectRequest(request_id));
	}

	@GetMapping("/history/{req_user_id}")
	public R selectHistory(@PathVariable Integer req_user_id){
		return new R(true, requestService.selectHistory(req_user_id));
	}
}

