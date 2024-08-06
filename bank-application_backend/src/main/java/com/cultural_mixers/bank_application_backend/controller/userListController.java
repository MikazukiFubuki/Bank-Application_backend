package main.java.com.cultural_mixers.bank_application_backend.controller;

@RestController
public class UserListController {
    @RequestMapping(path="/user_list/{userId}", method=RequestMethod.GET)
	public String index(@RequestParam String userId, Model model) {
		return "hello";
	}
}