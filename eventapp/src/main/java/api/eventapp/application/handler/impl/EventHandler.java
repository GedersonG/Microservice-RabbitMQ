package api.eventapp.application.handler.impl;

import api.eventapp.application.dto.request.EventRequestDto;
import api.eventapp.application.dto.request.EventUpdateRequestDto;
import api.eventapp.application.dto.response.EventResponseDto;
import api.eventapp.application.handler.IEventHandler;
import api.eventapp.application.mapper.request.IEventRequestMapper;
import api.eventapp.application.mapper.response.IEventResponseMapper;
import api.eventapp.domain.api.IEventServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class EventHandler implements IEventHandler {

    private final IEventServicePort eventServicePort;
    private final IEventRequestMapper eventRequestMapper;
    private final IEventResponseMapper eventResponseMapper;

    @Override
    public void saveEvent(EventRequestDto eventRequestDto) {
        this.eventServicePort.
                saveEvent(this.eventRequestMapper.eventRequestToEventModel(eventRequestDto));
    }

    @Override
    public List<EventResponseDto> getAllEvents() {
        return this.eventResponseMapper.
                eventModelListToResponseList(this.eventServicePort.getAllEvents());
    }

    @Override
    public void deleteEventById(Long id) {
        this.eventServicePort.deleteEventById(id);
    }

    @Override
    public EventResponseDto getEventById(Long id) {
        return this.eventResponseMapper.
                eventModelToEventResponse(this.eventServicePort.getEventById(id));
    }

    @Override
    public void updateEventById(Long id, EventUpdateRequestDto eventUpdateRequestDto) {
        this.eventServicePort.updateEventById(
                id,
                this.eventRequestMapper.eventUpdateRequestToEventModel(eventUpdateRequestDto)
        );
    }
}
