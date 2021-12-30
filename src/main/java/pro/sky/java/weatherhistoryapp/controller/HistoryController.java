package pro.sky.java.weatherhistoryapp.controller;

import org.springframework.web.bind.annotation.*;
import pro.sky.java.weatherhistoryapp.domain.HistoryRecord;
import pro.sky.java.weatherhistoryapp.service.HistoryService;
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
    public Flux<HistoryRecord> get() {
        return historyService.findAll();
    }

    @GetMapping(params = {"amount"})
    public Flux<HistoryRecord> get(@RequestParam int amount) {
        return historyService.find(amount);
    }

    @PostMapping
    public Mono<HistoryRecord> saveRecord(@RequestBody HistoryRecord record) {
        return historyService.save(record);
    }

    @DeleteMapping
    public Mono<Void> delete() {
        return historyService.deleteAll();
    }
}
