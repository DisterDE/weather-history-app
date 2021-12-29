package pro.sky.java.weatherhistoryapp.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import pro.sky.java.weatherhistoryapp.domain.HistoryRecord;

@Repository
public interface HistoryRepository extends ReactiveCrudRepository<HistoryRecord, Integer> {
}
