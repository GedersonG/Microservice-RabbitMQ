package api.eventapp.application.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class EventRequestDto {

    @NotEmpty(message = "The title is required")
    @Size(min = 2, max = 50, message = "The title should have between 2 and 50 characters")
    private String title;

    private String description;

    @Min(value = 1, message = "Should have almost one person")
    @Max(value = 200, message = "The maximum number of people per event is 200")
    private int maxPeoplePerEvent;
}
