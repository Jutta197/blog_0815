package blog.com.ex.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import blog.com.ex.models.entity.AccountEntity;



public interface AccountDao extends JpaRepository<AccountEntity, Long> {
		AccountEntity save(AccountEntity accountEntity);
		
		
		AccountEntity findByAccountName(String accountName);
		
		//select*from Account where Account_email=? AND Account_password=?
		AccountEntity findByAccountEmailAndPassword(String email, String password);
		//select*from Account where Account_name=? AND Account_password=?
		AccountEntity findByAccountNameAndPassword(String name, String password);
		
		
	}
