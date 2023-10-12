package api.eventapp.domain.api;

import api.eventapp.domain.model.EventModel;

import java.util.List;

public interface IEventServicePort {

    void saveEvent(EventModel eventModel);

    List<EventModel> getAllEvents();

    EventModel getEventById(Long id);

    void deleteEventById(Long id);

    void updateEventById(Long id, EventModel eventModel);
}
