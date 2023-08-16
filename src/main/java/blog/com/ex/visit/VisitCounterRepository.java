package blog.com.ex.visit;

import org.springframework.data.jpa.repository.JpaRepository;

// 用于访问数据库中的访问次数数据
public interface VisitCounterRepository extends JpaRepository<VisitCounter, Long> {
}
