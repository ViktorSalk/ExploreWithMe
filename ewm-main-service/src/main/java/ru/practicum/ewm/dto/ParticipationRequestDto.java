package ru.practicum.ewm.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.practicum.ewm.constants.DateTimeConstants;
import ru.practicum.ewm.model.constants.RequestStatus;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ParticipationRequestDto {
    private Long id;
    private Long event;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateTimeConstants.DATE_TIME_PATTERN)
    private LocalDateTime created;
    private Long requester;
    private RequestStatus status;
}