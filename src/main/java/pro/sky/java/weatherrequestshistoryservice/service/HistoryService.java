package pro.sky.java.weatherrequestshistoryservice.service;

import pro.sky.java.weatherrequestshistoryservice.domain.HistoryRecord;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface HistoryService {

    Mono<HistoryRecord> save(HistoryRecord record);

    Flux<HistoryRecord> find(int amount);

    Flux<HistoryRecord> findAll();

    Flux<HistoryRecord> deleteAll();
}
