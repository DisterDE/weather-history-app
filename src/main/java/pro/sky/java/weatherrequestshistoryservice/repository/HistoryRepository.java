package pro.sky.java.weatherrequestshistoryservice.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import pro.sky.java.weatherrequestshistoryservice.domain.HistoryRecord;

@Repository
public interface HistoryRepository extends ReactiveCrudRepository<HistoryRecord, Integer> {
}
