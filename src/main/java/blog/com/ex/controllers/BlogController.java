package blog.com.ex.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BlogController {

    @GetMapping("/home")
    public String blogPage() {
        return "admin_blog"; 
    }
}
