package de.neuefische.backend.repository;

import de.neuefische.backend.model.ToDo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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


    public Optional<ToDo> findById(String id){
       for(ToDo todo : toDoList){
           if(todo.getId().equals(id)){
               return Optional.of(todo);
           }
       }
        return Optional.empty();
    }

    public Optional<ToDo> deleteToDo(String id) {
        Optional<ToDo> optionalToDo = findById(id);
        if(findById(id).isPresent()){
            toDoList.remove(optionalToDo.get());
            return optionalToDo;
        }
        return Optional.empty();
    }
}
