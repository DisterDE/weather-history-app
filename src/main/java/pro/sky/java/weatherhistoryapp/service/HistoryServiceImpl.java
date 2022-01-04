package pro.sky.java.weatherhistoryapp.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pro.sky.java.weatherhistoryapp.domain.HistoryRecord;
import pro.sky.java.weatherhistoryapp.repository.HistoryRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class HistoryServiceImpl implements HistoryService {

    private final HistoryRepository repository;

    @Override
    public Mono<HistoryRecord> save(HistoryRecord record) {
        log.info("Trying to save history record: {}", record);
        return repository.save(record)
                .doOnError(e -> log.warn("History record is not saved: {}", record, e))
                .doOnSuccess(result -> log.info("History record is saved: {}", result));
    }

    @Override
    public Flux<HistoryRecord> find(int amount) {
        return repository.findAll()
                .take(amount)
                .doOnNext(e -> log.debug("History record received: {}", e))
                .doOnError(t -> log.warn("Can't find history records", t))
                .doOnComplete(() -> log.info("Received {} history records from db", amount));
    }

    @Override
    public Flux<HistoryRecord> findAll() {
        return repository.findAll()
                .doOnNext(e -> log.debug("History record received: {}", e))
                .doOnError(t -> log.warn("Can't find history records", t))
                .doOnComplete(() -> log.info("Received all history records from db"));
    }

    @Override
    public Mono<Void> deleteAll() {
        return repository.deleteAll()
                .doOnError(t -> log.warn("Can't delete history records", t))
                .doOnSuccess(e -> log.info("All history records deleted"));
    }
}
