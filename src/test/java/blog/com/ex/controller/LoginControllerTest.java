package blog.com.ex.controller;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

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
public class LoginControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AccountService accountService;

    // Prepare mock data
    @BeforeEach
    public void setUp() {
    	when(accountService.loginCheck(any(), any())).thenReturn(false);
        when(accountService.loginCheck(eq("juu@juu.com"), eq("juu1234"))).thenReturn(true);
        
    }

    // 画面の表示テスト

    @Test
    public void testLoginView() throws Exception {
        RequestBuilder request = get("/login");
        mockMvc.perform(request)
                .andExpect(view().name("account_login"));
    }

    // ログインページが正しく所得出来た場合のテスト
    @Test
    public void testLoginSuccess() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders
                .post("/login/process")
                .param("accountEmail", "juu@juu.com")
                .param("accountPassword", "juu1234");

        mockMvc.perform(request).andExpect(view().name("account_blog"));
    }


    // Test login 失败 email,password错误
    @Test
    public void testLoginFailure_Both() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders
                .post("/login/process")
                .param("accountEmail", "1234@juu.com")
                .param("accountPassword", "1234567");

        mockMvc.perform(request)
                .andExpect(view().name("account_login"));
       
}
 // Test login 失败 email错误 password正确
    @Test
    public void testLoginFailure_Email() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders
                .post("/login/process")
                .param("accountEmail", "1234@juu.com")
                .param("accountPassword", "juu1234");

        mockMvc.perform(request)
                .andExpect(view().name("account_login"));
       
}
 // Test login 失败 email正确 password错误
    @Test
    public void testLoginFailure_Password() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders
                .post("/login/process")
                .param("accountEmail", "juu@juu.com")
                .param("accountPassword", "1234567");

        mockMvc.perform(request)
                .andExpect(view().name("account_login"));
       
}
 // Test login emailとパスワードが空白の状態でログインボタン押下
    @Test
    public void testLoginFailure_Both_Blank() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders
                .post("/login/process")
                .param("accountEmail", "")
                .param("accountPassword", "");

        mockMvc.perform(request)
                .andExpect(view().name("account_login"));
       
}
    
}
