package de.ait.timepad.dto;

import lombok.Data;

@Data
public class NewEventDto {
  private String name;
  private String address;
  private String description;
}
