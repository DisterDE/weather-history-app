package pro.sky.java.weatherhistoryapp.service;

import org.springframework.stereotype.Service;
import pro.sky.java.weatherhistoryapp.domain.HistoryRecord;
import pro.sky.java.weatherhistoryapp.repository.HistoryRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class HistoryServiceImpl implements HistoryService {

    private final HistoryRepository repository;

    public HistoryServiceImpl(HistoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public Mono<HistoryRecord> save(HistoryRecord record) {
        return repository.save(record);
    }

    @Override
    public Flux<HistoryRecord> find(int amount) {
        return repository.findAll().take(amount);
    }

    @Override
    public Flux<HistoryRecord> findAll() {
        return repository.findAll();
    }

    @Override
    public Mono<Void> deleteAll() {
        return repository.deleteAll();
    }
}
