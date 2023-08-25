package blog.com.ex.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import blog.com.ex.models.entity.AccountEntity;
import blog.com.ex.services.AccountService;
import jakarta.servlet.http.HttpSession;

@SpringBootTest
@AutoConfigureMockMvc
public class AccountControllerTest {
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private AccountService accountService;
//	@MockBean
//	private HttpSession session;
	
	//データを作成
//	@BeforeEach
//	public void prepareData() {
//		AccountEntity accountEntity = new AccountEntity(1L,"Jutta","juu@test.com","1234abcd",LocalDateTime.now());
//		when(accountService.loginAccount(eq("juu@test.com"), eq("1234abcd"))).thenReturn(accountEntity);
//		when(accountService.loginAccount(eq("juu@test.com"), eq("12345678"))).thenReturn(null);
//		
//	}

	
	//ログインページが正しく所得出来た場合
	@Test
	public void testGetAccountLoginPage_Succeed() throws Exception{
		RequestBuilder request = MockMvcRequestBuilders
				.get("/account/login");
		
		mockMvc.perform(request)
		.andExpect(view().name("login.html"));

}
	// 登录成功
	@Test
	public void testLoginPage_Succeed() throws Exception{
		RequestBuilder request = MockMvcRequestBuilders
				.post("/account/login/process") // 还是要注意post和get
				.param("email", "juu@test.com")
				.param("password", "1234abcd");		
		
		MvcResult result = mockMvc.perform(request)
		.andExpect(redirectedUrl("/account/blog/list")).andReturn();
		//session
		HttpSession session = result.getRequest().getSession();
		
		//
		AccountEntity accountList = (AccountEntity)session.getAttribute("account");
		assertNotNull(accountList);
		assertEquals("Jutta",accountList.getAccountName());
		assertEquals("juu@test.com",accountList.getAccountEmail());
		assertEquals("1234abcd",accountList.getPassword());	
	}
	
	// 登录 失败
	@Test
	public void testLoginPage_Faile() throws Exception{
		RequestBuilder request = MockMvcRequestBuilders
				.post("/account/login/process") 
				.param("email", "juu@test.com")
				.param("password", "12345678");		
		
		MvcResult result = mockMvc.perform(request)
		.andExpect(redirectedUrl("/account/login")).andReturn();
		//session
		HttpSession session = result.getRequest().getSession();
		
		//
		AccountEntity accountList = (AccountEntity)session.getAttribute("account");
		assertNull(accountList);
		
	}
	

}

