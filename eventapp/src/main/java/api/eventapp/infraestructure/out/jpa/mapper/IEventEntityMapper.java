package api.eventapp.infraestructure.out.jpa.mapper;

import api.eventapp.domain.model.EventModel;
import api.eventapp.infraestructure.out.jpa.entity.EventEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IEventEntityMapper {

    EventEntity eventModelToEventEntity(EventModel eventModel);

    EventModel eventEntityToEventModel(EventEntity eventEntity);

    List<EventModel> eventEntityListToEventModelList(List<EventEntity> eventEntityList);
}
