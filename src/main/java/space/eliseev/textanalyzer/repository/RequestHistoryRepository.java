package space.eliseev.textanalyzer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import space.eliseev.textanalyzer.entity.RequestHistory;

public interface RequestHistoryRepository extends JpaRepository<RequestHistory, Long> {
}
