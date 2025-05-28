package ru.practicum.ewm.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.practicum.ewm.constants.DateTimeConstants;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SearchEventParamsAdmin {
    private List<Long> users;
    private List<String> states;
    private List<Long> categories;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateTimeConstants.DATE_TIME_PATTERN)
    private LocalDateTime rangeStart;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateTimeConstants.DATE_TIME_PATTERN)
    private LocalDateTime rangeEnd;
    @PositiveOrZero
    private Integer from = 0;
    @Positive
    private Integer size = 10;
}