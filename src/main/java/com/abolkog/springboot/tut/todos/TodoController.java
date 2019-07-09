package com.abolkog.springboot.tut.todos;

import com.abolkog.springboot.tut.todos.Todo;

import com.abolkog.springboot.tut.todos.TodoController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.abolkog.springboot.tut.todos.TodoRepository;




import java.util.List;


@RestController
@RequestMapping("Api/v1/todos")
public class TodoController {


    @Autowired

    TodoRepository todoRepository;

    private TodoService todoService; // bydwr 3ala kol elservice

    //Used to fetch all the users from DB
    @GetMapping(value = {"/",""})
    public List<Todo> getAllTodos () {   // equvilant SELECT * FROM blog

        return todoRepository.findAll();
    }

    //Used to find and return a user by id
    @GetMapping(value = "/getBy/{id}")
    public Todo getTodoById ( @PathVariable long id) { // SELECT * FROM blog WHERE id=param LIMIT 1 requestparam:

                System.out.println("ooooooooooooooooooooooooo");

        return  todoRepository.getTodoById(id); // lazm 23mlha el method f el repository
    }

    @PostMapping(value = {"/create"})     // 3shan ha3ml ha3ml post ha7ot
    public List<Todo> presist(@RequestBody final Todo todo){
        System.out.println(todo.getId());
        System.out.println(todo.getName());
        System.out.println(todo.getDepartment());
        System.out.println("HHHHHHHHHHHHHHHHHHHHHHh");
        todoRepository.save(new Todo(todo.getId(), todo.getName(), todo.getDepartment()));
        return  todoRepository.findAll();

    }



    @DeleteMapping("/delete/{id}")
    public void deleteTodo(@PathVariable long id) {

        System.out.println("ooooooooooooooooooooooooo");

        todoRepository.deleteById(id);  //DELETE FROM blog WHERE id=param

    }



}

