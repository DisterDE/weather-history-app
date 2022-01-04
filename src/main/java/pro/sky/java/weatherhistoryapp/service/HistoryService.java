package pro.sky.java.weatherhistoryapp.service;

import pro.sky.java.weatherhistoryapp.domain.HistoryRecord;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface HistoryService {

    Mono<HistoryRecord> save(HistoryRecord record);

    Flux<HistoryRecord> find(int amount);

    Flux<HistoryRecord> findAll();

    Mono<Void> deleteAll();
}
