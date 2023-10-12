package api.eventapp.application.handler;

import api.eventapp.application.dto.request.EventRequestDto;
import api.eventapp.application.dto.request.EventUpdateRequestDto;
import api.eventapp.application.dto.response.EventResponseDto;

import java.util.List;

public interface IEventHandler {

    void saveEvent(EventRequestDto eventRequestDto);

    List<EventResponseDto> getAllEvents();

    void deleteEventById(Long id);

    EventResponseDto getEventById(Long id);

    void updateEventById(Long id, EventUpdateRequestDto eventUpdateRequestDto);
}
