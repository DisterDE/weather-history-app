package pro.sky.java.weatherrequestshistoryservice.service;

import pro.sky.java.weatherrequestshistoryservice.domain.HistoryRecord;

import java.util.List;

public interface HistoryService {

    HistoryRecord save(HistoryRecord record);

    List<HistoryRecord> find(int amount);

    Iterable<HistoryRecord> findAll();

    Iterable<HistoryRecord> deleteAll();
}
