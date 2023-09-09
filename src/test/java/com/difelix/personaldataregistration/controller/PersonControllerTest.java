package com.difelix.personaldataregistration.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.amazonaws.services.dynamodbv2.local.main.ServerRunner;
import com.amazonaws.services.dynamodbv2.local.server.DynamoDBProxyServer;
import com.difelix.personaldataregistration.entity.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.URL;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@SpringBootTest
public class PersonControllerTest {

  private static DynamoDBProxyServer server;
  private final ObjectMapper objectMapper = new ObjectMapper();

  @Autowired
  private MockMvc mockMvc;

  private final String baseUrl = "/v1/person";

  @BeforeAll
  public static void setup() throws Exception {
    System.setProperty("sqlite4java.library.path", "native-libs");
    String port = "8000";
    server = ServerRunner.createServerFromCommandLineArgs(
        new String[]{"-inMemory", "-port", port});
    server.start();
  }

  @Test
  void shouldSavePersonWithSuccess() throws Exception {
    final Person person = objectMapper
        .readValue(new URL("file:src/test/resources/payloads/save_person_success.json"), Person.class);

    this.mockMvc.perform(post(baseUrl)
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsBytes(person))
    ).andDo(print())
        .andExpect(status().is2xxSuccessful());
  }

  @Test
  void shouldThrowsErrorWhenEmailIsInvalid() throws Exception {
    final Person person = objectMapper
        .readValue(new URL("file:src/test/resources/payloads/save_person_invalid_email.json"), Person.class);

    this.mockMvc.perform(post(baseUrl)
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsBytes(person))
        ).andDo(print())
        .andExpect(status().isBadRequest());
  }

  @AfterAll
  public static void tearDown() throws Exception {
    server.stop();
  }
}
