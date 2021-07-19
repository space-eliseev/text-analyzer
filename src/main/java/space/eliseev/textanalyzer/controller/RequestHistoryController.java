package space.eliseev.textanalyzer.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import space.eliseev.textanalyzer.entity.RequestHistory;
import space.eliseev.textanalyzer.repository.RequestHistoryRepository;

import java.util.List;

/**
 * История запросов
 */
@RestController
@RequiredArgsConstructor
public class RequestHistoryController {

    private final RequestHistoryRepository repository;

    @GetMapping("/history")
    public ResponseEntity<List<RequestHistory>> history() {
        return ResponseEntity.ok(repository.findAll());
    }
}
