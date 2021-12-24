package pro.sky.java.weatherrequestshistoryservice.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.weatherrequestshistoryservice.domain.HistoryRecord;
import pro.sky.java.weatherrequestshistoryservice.repository.HistoryRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class HistoryServiceImplTest {

    @Mock
    private HistoryRepository repository;

    @InjectMocks
    private HistoryServiceImpl sut;

    @Test
    void findAll() {
        HistoryRecord record1 = new HistoryRecord();
        HistoryRecord record2 = new HistoryRecord();
        HistoryRecord record3 = new HistoryRecord();
        List<HistoryRecord> recordList = List.of(record1, record2, record3);

        when(repository.findAll()).thenReturn(recordList);
        assertEquals(recordList, sut.findAll());
        System.out.println(sut.findAll());
    }
}