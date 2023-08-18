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
	private AccountService adminService;
	
	//ログイン画面を表示させる
	@GetMapping("/login")
	public String getLoginPage() {
		return "admin_login.html";
	}
	
	//ログイン処理
	@PostMapping("/login/process")
	public String login(@RequestParam String accountEmail,
			@RequestParam String accountPassword,
			Model model) {
		if(adminService.loginCheck(accountEmail, accountPassword)) {
			model.addAttribute("email",accountEmail);
			model.addAttribute("password",accountPassword);
			return "admin_blog.html";
		}else {
			return "admin_login.html";
		}
	}
}
