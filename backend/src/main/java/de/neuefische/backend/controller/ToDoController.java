package de.neuefische.backend.controller;

import de.neuefische.backend.model.ToDo;
import de.neuefische.backend.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/todo")
public class ToDoController {

    private final ToDoService toDoService;

    @Autowired
    public ToDoController(ToDoService toDoService){
        this.toDoService = toDoService;
    }

    @PostMapping
    public ToDo addToDo(@RequestBody ToDo newToDo){
       return toDoService.addToDo(newToDo);
    }
}
