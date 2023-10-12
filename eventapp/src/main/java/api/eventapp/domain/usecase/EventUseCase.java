package api.eventapp.domain.usecase;

import api.eventapp.domain.api.IEventServicePort;
import api.eventapp.domain.model.EventModel;
import api.eventapp.domain.spi.IEventPersistencePort;

import java.util.List;

public class EventUseCase implements IEventServicePort {

    private final IEventPersistencePort eventPersistencePort;

    public EventUseCase(IEventPersistencePort eventPersistencePort) {
        this.eventPersistencePort = eventPersistencePort;
    }

    @Override
    public void saveEvent(EventModel eventModel) {
        this.eventPersistencePort.saveEvent(eventModel);
    }

    @Override
    public List<EventModel> getAllEvents() {
        return this.eventPersistencePort.getAllEvents();
    }

    @Override
    public EventModel getEventById(Long id) {
        return this.eventPersistencePort.getEventById(id);
    }

    @Override
    public void deleteEventById(Long id) {
        this.eventPersistencePort.deleteEventById(id);
    }

    @Override
    public void updateEventById(Long id, EventModel eventModel) {
        this.eventPersistencePort.updateEventById(id, eventModel);
    }
}
