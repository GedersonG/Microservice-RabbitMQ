package api.eventapp.infraestructure.out.jpa.adapter;

import api.eventapp.domain.model.EventModel;
import api.eventapp.domain.spi.IEventPersistencePort;
import api.eventapp.infraestructure.exception.AlreadyExistsException;
import api.eventapp.infraestructure.exception.NoDataFoundException;
import api.eventapp.infraestructure.out.jpa.entity.EventEntity;
import api.eventapp.infraestructure.out.jpa.mapper.IEventEntityMapper;
import api.eventapp.infraestructure.out.jpa.repository.IEventRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RequiredArgsConstructor
public class EventJpaAdapter implements IEventPersistencePort {

    private static final Logger LOGGER = LoggerFactory.getLogger(EventJpaAdapter.class);
    private final IEventRepository eventRepository;
    private final IEventEntityMapper eventEntityMapper;

    @Override
    public EventModel saveEvent(EventModel eventModel) {
        eventExistsByTitle(eventModel.getTitle());

        EventEntity eventEntity =
                eventRepository.save(eventEntityMapper.eventModelToEventEntity(eventModel));
        EventModel eventSaved = eventEntityMapper.eventEntityToEventModel(eventEntity);

        LOGGER.info("Event saved -> {}", eventSaved.toString());
        return eventSaved;
    }

    @Override
    public List<EventModel> getAllEvents() {
        List<EventEntity> eventEntityList = eventRepository.findAll();
        if (eventEntityList.isEmpty()) {
            LOGGER.error("No events found.");
            throw new NoDataFoundException();
        }
        return eventEntityMapper.eventEntityListToEventModelList(eventEntityList);
    }

    @Override
    public EventModel getEventById(Long id) {
        EventEntity eventEntity =
                eventRepository.findById(id).orElseThrow(NoDataFoundException::new);
        return eventEntityMapper.eventEntityToEventModel(eventEntity);
    }

    @Override
    public void deleteEventById(Long id) {
        eventExistsById(id);

        LOGGER.warn("Removing event with id {}...", id);
        eventRepository.deleteById(id);
    }

    @Override
    public void updateEventById(Long id, EventModel eventModel) {
        eventExistsById(id);

        LOGGER.info("Updating event with id {}...", id);

        eventRepository.updateEvent(
                id,
                eventModel.getTitle(),
                eventModel.getDescription(),
                eventModel.getMaxPeoplePerEvent()
        );
    }

    private void eventExistsByTitle(String title) {
        if (eventRepository.existsByTitle(title)) {
            LOGGER.error("The event with the title {} already exists.", title);
            throw new AlreadyExistsException();
        }
    }

    private void eventExistsById(Long eventId) {
        if (!eventRepository.existsById(eventId)) {
            LOGGER.error("The event with the id {} does not exists.", eventId);
            throw new NoDataFoundException();
        }
    }
}
