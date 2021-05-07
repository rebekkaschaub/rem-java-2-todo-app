package de.neuefische.backend.controller;

import de.neuefische.backend.model.ToDo;
import de.neuefische.backend.repository.ToDoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

class ToDoControllerTest {
    @LocalServerPort
    public int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private ToDoRepository testToDoRepository;


    @Test
    void listToDos() {
        //GIVEN
        testToDoRepository.addToDo(new ToDo("1","Kekse backen","Open"));
        testToDoRepository.addToDo(new ToDo("2", "Controllertest schreiben", "Closed"));

        String host = "http://localhost:" + port + "/api/todo";
        //WHEN
        ResponseEntity<ToDo[]> response = testRestTemplate.getForEntity(host, ToDo[].class);

        //THEN
        assertThat(response.getStatusCode(),is(HttpStatus.OK));
        assertThat(response.getBody(), arrayContainingInAnyOrder(
                new ToDo("1","Kekse backen","Open"),
                new ToDo("2", "Controllertest schreiben", "Closed")
        ));

    }

    @Test
    void addToDo() {

    }
}