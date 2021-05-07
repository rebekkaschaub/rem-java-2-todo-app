package de.neuefische.backend.service;

import de.neuefische.backend.model.ToDo;
import de.neuefische.backend.repository.ToDoRepository;
import de.neuefische.backend.utils.UtilId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.Optional;

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

    public ToDo deleteToDo(String id) {
        Optional<ToDo> optionalToDO = toDoRepository.deleteToDo(id);
        if(optionalToDO.isPresent()){
            return optionalToDO.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Todo does not exist.");
    }

    public ToDo advanceToDoStatus(String id) {
        Optional<ToDo> advancedToDo = toDoRepository.findById(id);
        if(advancedToDo.isPresent()){
            return updateStatus(advancedToDo.get());
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Todo does not exist.");
    }

    private ToDo updateStatus(ToDo advancedToDo) {
        String statusOfToDo = advancedToDo.getStatus();
        switch (statusOfToDo){
            case "OPEN":
                advancedToDo.setStatus("IN_PROGRESS");
                break;
            case "IN_PROGRESS":
                advancedToDo.setStatus("DONE");
                break;
            default : break;

        }
        return advancedToDo;
    }

}
