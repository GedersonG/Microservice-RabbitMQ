package api.eventapp.application.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class EventUpdateRequestDto {

    private String description;

    @Min(value = 1, message = "Should have almost one person")
    @Max(value = 200, message = "The maximum number of people per event is 200")
    private int maxPeoplePerEvent;
}
