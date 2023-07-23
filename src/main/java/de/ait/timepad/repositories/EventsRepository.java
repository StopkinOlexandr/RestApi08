package de.ait.timepad.repositories;

import de.ait.timepad.models.Event;
import java.util.List;

public interface EventsRepository {
  void save(Event event);
  List<Event> findAll();


  public void clear();
}
