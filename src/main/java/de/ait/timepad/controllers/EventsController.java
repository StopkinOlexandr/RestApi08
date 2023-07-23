package de.ait.timepad.controllers;


import de.ait.timepad.models.Event;
import de.ait.timepad.services.EventsService;
import de.ait.timepad.services.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@RequiredArgsConstructor
@Controller
public class EventsController {

  private final EventsService eventsService;


  @PostMapping("/api/events")
  @ResponseStatus(HttpStatus.CREATED)
  @ResponseBody
  public Event addEvent(@RequestBody Event event) {
    return eventsService.addEvent(event);
  }
}