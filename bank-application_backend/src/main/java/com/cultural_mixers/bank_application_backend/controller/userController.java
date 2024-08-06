package main.java.com.cultural_mixers.bank_application_backend.controller;

@RestController
public class UserController {
    @RequestMapping(path="/user/{userId}", method=RequestMethod.GET)
	public String index() {
		return "hello";
	}
}