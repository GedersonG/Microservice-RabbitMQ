package api.eventapp.application.mapper.request;

import api.eventapp.application.dto.request.EventRequestDto;
import api.eventapp.application.dto.request.EventUpdateRequestDto;
import api.eventapp.domain.model.EventModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IEventRequestMapper {

    EventModel eventRequestToEventModel(EventRequestDto eventRequestDto);

    EventModel eventUpdateRequestToEventModel(EventUpdateRequestDto eventUpdateRequestDto);
}
