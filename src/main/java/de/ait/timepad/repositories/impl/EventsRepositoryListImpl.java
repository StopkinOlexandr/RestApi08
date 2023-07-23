package de.ait.timepad.repositories.impl;

import de.ait.timepad.models.Event;
import de.ait.timepad.repositories.EventsRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class EventsRepositoryListImpl implements EventsRepository {
  private static List<Event> events = new ArrayList<>();

  @Override
  public void save(Event event) {
    event.setId((long) events.size() + 1);
    events.add(event);
  }
}
