package de.ait.timepad.dto;

import de.ait.timepad.models.Event;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EventDto {

  private Long id;
  private String name;
  private String address;
  private String description;
  private String state;
}
