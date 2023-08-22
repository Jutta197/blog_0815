package blog.com.ex.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import blog.com.ex.services.AccountService;

@Controller
public class RegisterController {
	@Autowired
	private AccountService accountService;
	
	//登録画面表示
	@GetMapping("/register")
	public String registerPage() {
		
		return "admin_register";
	}
	//登録処理をする
	@PostMapping("/register/process")
	public String register(@RequestParam String accountName, 
			@RequestParam String accountEmail, 
			@RequestParam String password) {
		//
		System.out.println("Register method called.");
		
		if(accountService.createAccount(accountEmail, accountName, password)) {
			return "admin_login";
		}else {
			return "admin_register";
		}
		
		
	}
}
