package api.eventapp.domain.spi;

import api.eventapp.domain.model.EventModel;

import java.util.List;

public interface IEventPersistencePort {

    EventModel saveEvent(EventModel eventModel);

    List<EventModel> getAllEvents();

    EventModel getEventById(Long id);

    void deleteEventById(Long id);

    void updateEventById(Long id, EventModel eventModel);
}
