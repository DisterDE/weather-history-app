package pro.sky.java.weatherrequestshistoryservice.controller;

import org.springframework.web.bind.annotation.*;
import pro.sky.java.weatherrequestshistoryservice.domain.HistoryRecord;
import pro.sky.java.weatherrequestshistoryservice.service.HistoryService;

@RestController
@RequestMapping("/record")
public class HistoryController {

    private final HistoryService historyService;

    public HistoryController(HistoryService historyService) {
        this.historyService = historyService;
    }

    @GetMapping
    public Iterable<HistoryRecord> getRecords(Integer amount) {
        if (amount != null) {
            return historyService.find(amount);
        }
        return historyService.findAll();
    }

    @PostMapping
    public HistoryRecord saveRecord(@RequestBody HistoryRecord record) {
        return historyService.save(record);
    }

    @DeleteMapping
    public Iterable<HistoryRecord> delete() {
        return historyService.deleteAll();
    }
}
