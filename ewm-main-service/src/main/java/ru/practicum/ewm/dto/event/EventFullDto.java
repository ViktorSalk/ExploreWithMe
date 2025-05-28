package ru.practicum.ewm.dto.event;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.practicum.ewm.constants.DateTimeConstants;
import ru.practicum.ewm.dto.CategoryDto;
import ru.practicum.ewm.dto.LocationDto;
import ru.practicum.ewm.dto.UserShortDto;
import ru.practicum.ewm.model.constants.EventStatus;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EventFullDto {
    private Long id;
    private String annotation;
    private CategoryDto category;
    private Integer confirmedRequests;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateTimeConstants.DATE_TIME_PATTERN)
    private LocalDateTime createdOn;
    private String description;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateTimeConstants.DATE_TIME_PATTERN)
    private LocalDateTime eventDate;
    private UserShortDto initiator;
    private LocationDto location;
    private Boolean paid;
    private Integer participantLimit;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateTimeConstants.DATE_TIME_PATTERN)
    private LocalDateTime publishedOn;
    private Boolean requestModeration;
    private EventStatus state;
    private String title;
    private Long views;
}