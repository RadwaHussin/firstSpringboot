package com.abolkog.springboot.tut.todos;

import com.abolkog.springboot.tut.error.ConflictException;
import com.abolkog.springboot.tut.error.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public List<Todo> findAll ()

    { return todoRepository.findAll(); }

    public  Todo getTodoById (long id)
      {  try {
                return todoRepository.findById(id).get();
             }catch (NoSuchElementException ex) {
               throw new NotFoundException(String.format("No record with the id (%s) was found in our database",id)); // hna ba7ot el mssg bs ha3mlha format 3shan tzhar bshakl mo5talf
      }
    }

    public Todo save(Todo todo)
    {

        if(todoRepository.findByName(todo.getName())!= null){
            throw new ConflictException("This name already exists in the database");
        }
        return todoRepository.save(todo);
    }

    public void  delete(long id)
    {

        todoRepository.deleteById(id);
    }
}
