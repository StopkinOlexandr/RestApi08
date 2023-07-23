package de.ait.timepad.controllers;

import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import de.ait.timepad.models.Event;
import de.ait.timepad.models.Event.State;
import de.ait.timepad.repositories.EventsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class EventsControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private EventsRepository eventsRepository;

  @BeforeEach
  public void setUp() {
    eventsRepository.clear();
  }
  @Test
  void addEvent() throws Exception {
    mockMvc.perform(post("/api/events")
        .header("Content-Type", "application/json")
        .content("{\n"
            + "  \"name\": \"fest\",\n"
            + "  \"address\": \"Berlin\",\n"
            + "  \"description\": \"Beer party\"\n"
            + "}"))
        .andDo(print())
        .andExpect(status().isCreated())
        .andExpect(jsonPath("$.id", is(1)))
        .andExpect(jsonPath("$.name", is("fest")))
        .andExpect(jsonPath("$.address", is("Berlin")))
        .andExpect(jsonPath("$.description", is("Beer party")));
  }

  @Test
  void getAllEvents() throws Exception {
    eventsRepository.save(Event.builder().id(7L).state(State.PLANNED).build());
    eventsRepository.save(Event.builder().id(8L).state(State.PLANNED).build());


    mockMvc.perform(get("/api/events")).andDo(print())
        .andExpect(jsonPath("$.count", is(2)));

  }
}