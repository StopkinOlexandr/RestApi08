package de.ait.timepad.services;

import de.ait.timepad.dto.EventDto;
import de.ait.timepad.models.Event;

public interface EventsService {
   EventDto addEvent(Event event);
}
