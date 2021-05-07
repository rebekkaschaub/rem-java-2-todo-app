package de.neuefische.backend.repository;

import de.neuefische.backend.model.ToDo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ToDoRepository {

    private List<ToDo> toDoList = new ArrayList<>();

    public ToDo addToDo(ToDo newToDo){
        toDoList.add(newToDo);
        return newToDo;
    }

    public List<ToDo> listToDos() {
        return toDoList;
    }
}
