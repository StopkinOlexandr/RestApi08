package de.ait.timepad.controllers;


import de.ait.timepad.dto.EventDto;
import de.ait.timepad.dto.EventsDto;
import de.ait.timepad.dto.NewEventDto;
import de.ait.timepad.models.Event;
import de.ait.timepad.services.EventsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/events")
@RequiredArgsConstructor
@RestController
public class EventsController {

  private final EventsService eventsService;
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)

  public EventDto addEvent(@RequestBody NewEventDto newEvent) {
    return eventsService.addEvent(newEvent);
  }

  @GetMapping
  @ResponseBody
  public EventsDto getAllEvents() {
    return eventsService.getAllEvents();
  }
}