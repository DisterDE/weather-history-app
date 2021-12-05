package pro.sky.java.weatherrequestshistoryservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import pro.sky.java.weatherrequestshistoryservice.domain.HistoryRecord;

@Repository
public interface HistoryRepository extends PagingAndSortingRepository<HistoryRecord, Integer> {
}
