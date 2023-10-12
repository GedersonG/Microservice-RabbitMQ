package api.eventapp.application.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class EventResponseDto {

    private String title;

    private String description;

    private int maxPeoplePerEvent;
}
