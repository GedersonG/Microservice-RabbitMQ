package api.eventapp.infraestructure.input.rest;

import api.eventapp.application.dto.request.EventRequestDto;
import api.eventapp.application.dto.request.EventUpdateRequestDto;
import api.eventapp.application.dto.response.EventResponseDto;
import api.eventapp.application.handler.IEventHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/event")
@RequiredArgsConstructor
public class EventRestController {

    private final IEventHandler eventHandler;

    @Operation(summary = "Add a new event")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Event create", content = @Content),
            @ApiResponse(responseCode = "400", description = "Data error", content = @Content),
            @ApiResponse(responseCode = "409", description = "Event already exists", content = @Content)
    })
    @PostMapping()
    public ResponseEntity<Void> saveEvent(@Valid @RequestBody EventRequestDto eventRequestDto) {
        this.eventHandler.saveEvent(eventRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(summary = "Get all events")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All events returned",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = EventResponseDto.class)))),
            @ApiResponse(responseCode = "404", description = "Data not found", content = @Content)
    })
    @GetMapping()
    public ResponseEntity<List<EventResponseDto>> getAllEvents() {
        return ResponseEntity.ok(this.eventHandler.getAllEvents());
    }

    @Operation(summary = "Get event by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Event returned",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = EventResponseDto.class))),
            @ApiResponse(responseCode = "404", description = "Data not found", content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<EventResponseDto> getEventById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.eventHandler.getEventById(id));
    }

    @Operation(summary = "Remove a event")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Event removed", content = @Content),
            @ApiResponse(responseCode = "404", description = "Event does not exists", content = @Content)
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeEventById(@PathVariable("id") Long id) {
        this.eventHandler.deleteEventById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Operation(summary = "Update a event")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Event updated", content = @Content),
            @ApiResponse(responseCode = "404", description = "Event does not exists", content = @Content)
    })
    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateEventById(
            @PathVariable("id") Long id,
            @Valid @RequestBody EventUpdateRequestDto eventUpdateRequestDto
    ) {
        this.eventHandler.updateEventById(id, eventUpdateRequestDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
