package blog.com.ex.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import blog.com.ex.models.dao.AccountDao;
import blog.com.ex.models.entity.AccountEntity;


@Service
public class AccountService {
	@Autowired
	private AccountDao accountDao;
	
	//登録処理のメソッド
	public boolean createAccount(String email, 
			String name, 
			String password) {
		if(accountDao.findByAccountName(name)==null) {
			accountDao.save(new AccountEntity(email,name,password));
			return true;
		}else {
			return false;
		}
	}
	//ログインチェック用のメソッド
	//trueはログインできる
	//falseの場合はログイン出来ない
	public boolean loginCheck(String email, String password) {
		if(accountDao.findByAccountEmailAndPassword(email, password)==null) {
			return false;
		}else {
			return true;
		}
		
	}
}
