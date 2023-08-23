package blog.com.ex.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import blog.com.ex.services.AccountService;


@Controller
public class LoginController {
	@Autowired
	private AccountService accountService;
	
	//ログイン画面を表示させる
	@GetMapping("/login")
	public String loginPage() {
		return "account_login";
	}
	
	//閲覧者
	@GetMapping("/blog")
	public String lookPage() {
		return "blog";
	}
	
	
	//ログイン処理
	@PostMapping("/login/process")
	public String login(@RequestParam String accountEmail,
			@RequestParam String accountPassword,
			Model model) {
		if(accountService.loginCheck(accountEmail, accountPassword)) {
			model.addAttribute("email",accountEmail);
			model.addAttribute("password",accountPassword);
			return "account_blog";
		}else {
			return "account_login";
		}
	}
}
