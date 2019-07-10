package com.abolkog.springboot.tut.todos;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("Api/v1/todos")
public class TodoController
{


    @Autowired
    TodoRepository todoRepository;

    @Autowired
    private TodoService todoService; // autowired

    @GetMapping(value = {"/",""})
    public ResponseEntity<List<Todo>> getAllTodos () {
        List<Todo> result = todoRepository.findAll();   // hna 3amlt list<Todo> 3shan de el 7aga el btrga3 lakn ta7t 3amlt Todo
        return new ResponseEntity<List<Todo>>(result,HttpStatus.OK);
    }

//    @GetMapping(value = {"/",""})
//    public List<Todo> getAllTodos () {
//        return todoRepository.findAll();
//    }

    @GetMapping(value = "/getBy/{id}")
    public ResponseEntity<Todo> getTodoById ( @PathVariable long id) {
         Todo result  =  todoService.getTodoById(id);
         return new ResponseEntity<Todo>(result,HttpStatus.OK);

    }

//    @GetMapping(value = "/getBy/{id}")
//    public Todo getTodoById ( @PathVariable long id) {
//        return  todoRepository.getTodoById(id);
//    }

    @PostMapping(value = {"/create"}) // with respose code
    public ResponseEntity<Todo> presist(@Valid @RequestBody final Todo todo){
        Todo result =   todoService.save(new Todo(todo.getId(), todo.getName(), todo.getDepartment())); //hnaaaa
        return  new ResponseEntity<Todo>(result, HttpStatus.CREATED);
    }

//    @PostMapping(value = {"/create"})  //without response code
//    public List<Todo> presist(@Valid @RequestBody final Todo todo){
//        todoRepository.save(new Todo(todo.getId(), todo.getName(), todo.getDepartment()));
//        return  todoRepository.findAll();
//    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable long id) {
        todoRepository.deleteById(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT); //3shan lw 7ab ymsa7 7aga msh mwgoda
    }

//    @DeleteMapping("/delete/{id}")
//    public void deleteTodo(@PathVariable long id) {
//        todoRepository.deleteById(id);
//    }

}

