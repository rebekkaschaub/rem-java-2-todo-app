package de.neuefische.backend.service;

import de.neuefische.backend.model.ToDo;
import de.neuefische.backend.repository.ToDoRepository;
import de.neuefische.backend.utils.UtilId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoService {
    private final ToDoRepository toDoRepository;

    @Autowired
    public ToDoService(ToDoRepository toDoRepository){
        this.toDoRepository = toDoRepository;
    }

    public ToDo addToDo(ToDo newToDo){
        newToDo.setId(new UtilId().generateId());

        return toDoRepository.addToDo(newToDo);
    }

    public List<ToDo> listToDos() {
        return toDoRepository.listToDos();
    }
}
