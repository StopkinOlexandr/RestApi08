package de.ait.timepad.dto;

import de.ait.timepad.models.Event;
import java.util.List;
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

  public static EventDto from(Event event) {
    return EventDto.builder()
        .id(event.getId())
        .name(event.getName())
        .address(event.getAddress())
        .state(event.getState().name())
        .description(event.getDescription())
        .build();
  }

  public static List<EventDto> from (List<Event> events) {
return   events.stream()
        .map(EventDto::from)
        .toList();
  }
}
