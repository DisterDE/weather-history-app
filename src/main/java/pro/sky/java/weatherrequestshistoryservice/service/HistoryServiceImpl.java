package pro.sky.java.weatherrequestshistoryservice.service;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pro.sky.java.weatherrequestshistoryservice.domain.HistoryRecord;
import pro.sky.java.weatherrequestshistoryservice.repository.HistoryRepository;

import java.util.List;

@Service
public class HistoryServiceImpl implements HistoryService {

    private final HistoryRepository repository;

    public HistoryServiceImpl(HistoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public HistoryRecord save(HistoryRecord record) {
        return repository.save(record);
    }

    @Override
    public List<HistoryRecord> find(int amount) {
        return repository.findAll(Pageable.ofSize(amount)).toList();
    }

    @Override
    public Iterable<HistoryRecord> findAll() {
        return repository.findAll();
    }

    @Override
    public Iterable<HistoryRecord> deleteAll() {
        Iterable<HistoryRecord> deletedEntities = repository.findAll();
        repository.deleteAll();
        return deletedEntities;
    }
}
