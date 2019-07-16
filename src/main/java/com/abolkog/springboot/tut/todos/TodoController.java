package com.abolkog.springboot.tut.todos;


import com.abolkog.springboot.tut.security.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController //marks the class as web controller, capable of handling the requests.
@RequestMapping("Api/v1/todos") //maps HTTP request with a path to a controller method

public class TodoController // decides what to do with the input and how to output the response.
{
//    public class TodoController extends BaseController


//    @Autowired
//    TodoRepository todoRepository;

    @Autowired
    private TodoService todoService; // autowired

    @GetMapping(value = {"/",""})
    public ResponseEntity<List<Todo>> getAllTodos () {
        List<Todo> result = todoService.findAll();   // hna 3amlt list<Todo> 3shan de el 7aga el btrga3 lakn ta7t 3amlt Todo
        return new ResponseEntity<List<Todo>>(result,HttpStatus.OK);
    }

    // --V10
//    @GetMapping(value = {"/",""})
//    public ResponseEntity<List<Todo>> getAllTodos () {
//        System.out.println("getuserByIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIId");
//        List<Todo> result = todoService.findByUser(getCurrentUser().getId());  // hna 3amlt list<Todo> 3shan de el 7aga el btrga3 lakn ta7t 3amlt Todo
//        return new ResponseEntity<List<Todo>>(result,HttpStatus.OK);
//    }


    @GetMapping(value = "/getBy/{id}")
    public ResponseEntity<Todo> getTodoById ( @PathVariable long id) {
         Todo result  =  todoService.getTodoById(id);
         return new ResponseEntity<Todo>(result,HttpStatus.OK);
    }

    @PostMapping(value = {"/create"}) // with respose code
    public ResponseEntity<Todo> presist(@Valid @RequestBody final Todo todo){
        System.out.println("createuserByIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIId");
//        todo.setUserId(getCurrentUser().getId());
        Todo result =   todoService.save(new Todo(todo.getId(), todo.getName(), todo.getDepartment())); //hnaaaa
        return  new ResponseEntity<Todo>(result, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable long id) {
         todoService.delete(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT); //3shan lw 7ab ymsa7 7aga msh mwgoda
    }

}

