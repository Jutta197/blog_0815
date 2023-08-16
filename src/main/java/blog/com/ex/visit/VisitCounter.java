package blog.com.ex.visit;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class VisitCounter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int visits;

    // Getter and Setter methods

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getVisits() {
        return visits;
    }

    public void setVisits(int visits) {
        this.visits = visits;
    }
}
