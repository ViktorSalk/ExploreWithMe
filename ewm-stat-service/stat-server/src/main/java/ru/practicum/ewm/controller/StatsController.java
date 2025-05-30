package ru.practicum.ewm.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.practicum.ewm.EndpointHit;
import ru.practicum.ewm.ViewStats;
import ru.practicum.ewm.ViewsStatsRequest;
import ru.practicum.ewm.service.StatsService;

import java.security.InvalidParameterException;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class StatsController {
    private static final String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    private final StatsService service;

    @PostMapping("/hit")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void hit(@RequestBody EndpointHit hit) {
        log.info("POST request to save information.");
        service.saveHit(hit);
    }

    @GetMapping("/stats")
    public List<ViewStats> getStats(@RequestParam @DateTimeFormat(pattern = DATE_TIME_PATTERN) LocalDateTime start,
                                    @RequestParam @DateTimeFormat(pattern = DATE_TIME_PATTERN) LocalDateTime end,
                                    @RequestParam(defaultValue = "") List<String> uris,
                                    @RequestParam(defaultValue = "false") boolean unique) {
        log.info("GET request to get all statistic.");
        if (end.isBefore(start)) {
            log.info("Uncorrected format of dates start {} и end {}", start, end);
            throw new InvalidParameterException("Uncorrected format of dates");
        }
        return service.getViewStatsList(
                ViewsStatsRequest.builder()
                        .start(start)
                        .end(end)
                        .uris(uris)
                        .unique(unique)
                        .build()
        );
    }
}