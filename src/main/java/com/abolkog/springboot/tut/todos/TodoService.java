package com.abolkog.springboot.tut.todos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TodoService {

    @Autowired//so we can use todoRepository anywhere within the controller without having to instantiate it.


    private TodoRepository todoRepository;

    public List<Todo> findAll ()
    {

        return todoRepository.findAll();
    }

    public  Todo getTodoById (long Id)
    {
       return todoRepository.findById(Id).get();

    }

    public Todo save(Todo todo){

        return todoRepository.save(todo);
    }

    public void  delete(long id) {

        todoRepository.deleteById(id);
    }
}
