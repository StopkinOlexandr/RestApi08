package de.ait.timepad.services.impl;

import de.ait.timepad.dto.EventDto;
import de.ait.timepad.models.Event;
import de.ait.timepad.models.Event.State;
import de.ait.timepad.repositories.EventsRepository;
import de.ait.timepad.services.EventsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class EventsServiceImpl implements EventsService {

  private final EventsRepository eventsRepository;
  @Override
  public EventDto addEvent(Event event){
    event.setState(State.PLANNED);
    eventsRepository.save(event);
    return EventDto.builder()
        .id(event.getId())
        .name(event.getName())
        .address(event.getAddress())
        .state(event.getState().name())
        .description(event.getDescription())
        .build();
  }
}
