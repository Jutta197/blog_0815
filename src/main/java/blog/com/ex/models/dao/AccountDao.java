package blog.com.ex.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import blog.com.ex.models.entity.AccountEntity;



public interface AccountDao extends JpaRepository<AccountEntity, Long> {
	//データを保存するinsert文に該当するメソッドを書く
	//AccountEntityを引数として受け取ってAccountEntityの内容を保存して保存した結果を返す
		AccountEntity save(AccountEntity accountEntity);
		
		//AccountNameの内容を受け取ってAccountEntityを返すメソッド
		// where Account_name = ?
		AccountEntity findByAccountName(String accountName);
		
		//select*from Account where Account_email=? AND Account_password=?
		AccountEntity findByAccountEmailAndPassword(String email, String password);
		//select*from Account where Account_name=? AND Account_password=?
		AccountEntity findByAccountNameAndPassword(String name, String password);
		
		//一覧取
		List<AccountEntity> findAll();
		
	}
