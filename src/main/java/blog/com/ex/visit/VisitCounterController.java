package blog.com.ex.visit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.transaction.annotation.Transactional;

@RestController
public class VisitCounterController {
    private final VisitCounterRepository visitCounterRepository;

    @Autowired
    public VisitCounterController(VisitCounterRepository visitCounterRepository) {
        this.visitCounterRepository = visitCounterRepository;
    }

    @GetMapping("/admin_blog.html")
    @Transactional
    public String adminBlog(Model model) {
        VisitCounter visitCounter = visitCounterRepository.findById(1L).orElse(null);

        if (visitCounter == null) {
            visitCounter = new VisitCounter();
            visitCounter.setVisits(1);
        } else {
            visitCounter.setVisits(visitCounter.getVisits() + 1);
        }

        visitCounterRepository.save(visitCounter);

        model.addAttribute("visitCount", visitCounter.getVisits());

        return "admin_blog";
    }
}
