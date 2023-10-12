package api.eventapp.application.mapper.response;

import api.eventapp.application.dto.response.EventResponseDto;
import api.eventapp.domain.model.EventModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IEventResponseMapper {

    EventResponseDto eventModelToEventResponse(EventModel eventModel);

    List<EventResponseDto> eventModelListToResponseList(List<EventModel> eventModelList);
}
