package main.java.com.cultural_mixers.bank_application_backend.controller;

@RestController
public class SendController {
    private SendService sendService;

    @RequestMapping(path="/send", method=RequestMethod.PUT)
	public String index() {
        sendService.updateMoney();
		return "hello";
	}
}