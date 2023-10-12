package api.eventapp.infraestructure.configuration;

import api.eventapp.domain.api.IEventServicePort;
import api.eventapp.domain.spi.IEventPersistencePort;
import api.eventapp.domain.usecase.EventUseCase;
import api.eventapp.infraestructure.out.jpa.adapter.EventJpaAdapter;
import api.eventapp.infraestructure.out.jpa.mapper.IEventEntityMapper;
import api.eventapp.infraestructure.out.jpa.repository.IEventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class EventBeanConfiguration {

    private final IEventRepository eventRepository;
    private final IEventEntityMapper eventEntityMapper;

    @Bean
    public IEventPersistencePort eventPersistencePort() {
        return new EventJpaAdapter(eventRepository, eventEntityMapper);
    }

    @Bean
    public IEventServicePort eventServicePort() {
        return new EventUseCase(eventPersistencePort());
    }
}
