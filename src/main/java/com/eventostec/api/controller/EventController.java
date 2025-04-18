package com.eventostec.api.controller;

import com.eventostec.api.domain.event.Event;
import com.eventostec.api.domain.event.EventRequestDTO;
import com.eventostec.api.domain.event.EventResponseDto;
import com.eventostec.api.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/event")
public class EventController {
    @Autowired
    private EventService eventService;
    @PostMapping(consumes = "multipart/form-data") //todo: precisa ajustar no postman, não será via json;
    public ResponseEntity<Event> create(@RequestParam("title") String title,
                                        @RequestParam(value = "description", required = false) String description,
                                        @RequestParam("date") Long date,
                                        @RequestParam("city") String city,
                                        @RequestParam("state") String state,
                                        @RequestParam("remote") Boolean remote,
                                        @RequestParam("eventUrl") String eventUrl,
                                        @RequestParam(value = "image", required = false) MultipartFile image
                                        ) {
        EventRequestDTO eventRequestDTO = new EventRequestDTO(title,description, date, city, state, remote, eventUrl, image);
        Event newEvent = this.eventService.createEvent(eventRequestDTO);
        return ResponseEntity.ok(newEvent);
    }
    //eventos que irão acontecer
    @GetMapping
    public ResponseEntity<List<EventResponseDto>> UpComingEvents(@RequestParam (defaultValue = "") int page, @RequestParam(defaultValue = "10") int size) {
        List<EventResponseDto> allEvents = this.eventService.getUpComingEvents(page, size);
        return ResponseEntity.ok(allEvents);
    }

    @GetMapping("/all")
    public ResponseEntity<List<EventResponseDto>> getEventsAll(@RequestParam (defaultValue = "") int page, @RequestParam(defaultValue = "10") int size) {
        List<EventResponseDto> allEvents = this.eventService.getEventsAll(page, size);
        return ResponseEntity.ok(allEvents);
    }
}
