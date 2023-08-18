//package blog.com.ex.controllers;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//
//
//@Controller
//public class RegisterController {
//	@Autowired
////	private AccountDao AccountDao;
//	private AccountService AccountService;
//	
//	//登録画面表示
//	@GetMapping("/register")
//	public String getRegisterPage() {
//		return "register.html";
//	}
//	//登録処理をする
//	@PostMapping("/register/process")
//	public String register(@RequestParam String accountName, 
//			@RequestParam String accountEmail, 
//			@RequestParam String password) {
//		//もし、Accountテーブル内に登録した名前が存在しなかった場合、テーブルに保存処理をする
//
//		//		if(AccountDao.findByAccountName(accountName)==null) {
////			//保存処理内容を書く
////			AccountDao.save(new AccountEntity(accountEmail,accountName,accountPassword));
////			return "login.html";
////		}else {
////			return "register.html";
////		}
//		if(AccountService.createAccount(accountEmail, accountName, password)) {
//			return "login.html";
//		}else {
//			return "register.html";
//		}
//		
//		//そうでない場合、登録処理を行わない
//		
//	}
//}
