package pro.sky.java.weatherrequestshistoryservice.controller;

import org.springframework.web.bind.annotation.*;
import pro.sky.java.weatherrequestshistoryservice.domain.HistoryRecord;
import pro.sky.java.weatherrequestshistoryservice.service.HistoryService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/records")
public class HistoryController {

    private final HistoryService historyService;

    public HistoryController(HistoryService historyService) {
        this.historyService = historyService;
    }

    @GetMapping
    public Flux<HistoryRecord> getRecords(Integer amount) {
        if (amount != null) {
            return historyService.find(amount);
        }
        return historyService.findAll();
    }

    @PostMapping
    public Mono<HistoryRecord> saveRecord(@RequestBody HistoryRecord record) {
        return historyService.save(record);
    }

    @DeleteMapping
    public Flux<HistoryRecord> delete() {
        return historyService.deleteAll();
    }
}
