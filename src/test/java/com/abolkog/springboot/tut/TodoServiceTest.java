package com.abolkog.springboot.tut;

import com.abolkog.springboot.tut.todos.Todo;
import com.abolkog.springboot.tut.todos.TodoRepository;
import com.abolkog.springboot.tut.todos.TodoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.*;
import static org.assertj.core.api.Assertions.*;


@RunWith(SpringRunner.class)

public class TodoServiceTest {

    @MockBean  //bec we will not use DB we will it as silmulation
    private TodoRepository todoRepository;


    @Autowired
    private TodoService todoService; // bec we will test our service


    @TestConfiguration
    static class TodoServiceContextConfiguration {
        @Bean
        public TodoService todoService() {
            return new TodoService();
        }
    }

    @Test
    public void whenCallFindAll_ReturnTodoList(){

        Todo todo1 = new Todo(1,"Todo1" ,"Todo1" );
        Todo todo2 = new Todo(2,"Todo2" ,"Todo2" );
        List<Todo> data= Arrays.asList(todo1, todo2); // add this data in list todo

        given(todoRepository.findAll()).willReturn(data); //when call findAll return the data

        //make sure when call findAll it return 2 element todo1 and todo2
        assertThat(todoService.findAll())
                .hasSize(2)
                .contains(todo1,todo2);

    }

    @Test
    public void whenCallFindAll_ReturnTodoList2(){

        Todo todo1 = new Todo(1,"Todo1" ,"Todo1" );
        Todo todo2 = new Todo(2,"Todo2" ,"Todo2" );
        Todo todo3 = new Todo(2,"Todo2" ,"Todo2" );
        List<Todo> data= Arrays.asList(todo1, todo2, todo3); // add this data in list todo

        given(todoRepository.findAll()).willReturn(data); //when call findAll return the data

        //make sure when call findAll it return 2 element todo1 and todo2
        assertThat(todoService.findAll())
                .hasSize(2)
                .contains(todo1,todo2);

    }
}
