package ru.practicum.ewm.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import ru.practicum.ewm.constants.DateTimeConstants;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NewEventDto {
    @NotBlank
    @Length(max = 2000, min = 20)
    private String annotation;
    @NotNull
    @Positive
    private Long category;
    @NotBlank
    @Length(max = 7000, min = 20)
    private String description;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateTimeConstants.DATE_TIME_PATTERN)
    private LocalDateTime eventDate;
    @NotNull
    @Valid
    private LocationDto location;
    private boolean paid;
    @PositiveOrZero
    private int participantLimit;
    private boolean requestModeration = true;
    @NotNull
    @Length(min = 3, max = 120)
    private String title;
}