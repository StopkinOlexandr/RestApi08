package de.ait.timepad.models;

import java.util.List;

/**
 * 7/21/2023 REST API
 *
 * @author Marsel Sidikov (AIT TR)
 */
public class Event {

  public enum State {
    PLANNED,
    CONFIRMED,
    CANCELED,
    FINISHED
  }

  private Long id;
  private String name;
  private String address;
  private String description;
  private Event.State state;


}
