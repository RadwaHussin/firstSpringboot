//package com.abolkog.springboot.tut;
//
//import com.abolkog.springboot.tut.error.NotFoundException;
//import com.abolkog.springboot.tut.todos.Todo;
//import com.abolkog.springboot.tut.todos.TodoRepository;
//import com.abolkog.springboot.tut.todos.TodoService;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.TestConfiguration;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.Optional;
//
//import static org.mockito.BDDMockito.*;
//import static org.assertj.core.api.Assertions.*;
//
//
//@RunWith(SpringRunner.class)
//
//public class TodoServiceTest {
//
//    @MockBean  //bec we will not use DB we will it as silmulation
//    private TodoRepository todoRepository;
//
//
//    @Autowired
//    private TodoService todoService; // bec we will test our service
//
//
//    @TestConfiguration
//    static class TodoServiceContextConfiguration {
//        @Bean
//        public TodoService todoService() {
//            return new TodoService();
//        }
//    }
//
//    @Test
//    public void whenCallFindAll_ReturnTodoList(){
//
//        Todo todo1 = new Todo(1,"Todo1" ,"Todo1" );
//        Todo todo2 = new Todo(2,"Todo2" ,"Todo2" );
//        List<Todo> data= Arrays.asList(todo1, todo2); // add this data in list todo
//
//        given(todoRepository.findAll()).willReturn(data); //when call findAll return the data
//
//        //make sure when call findAll it return 2 element todo1 and todo2
//        assertThat(todoService.findAll())
//                .hasSize(2)
//                .contains(todo1,todo2);
//
//    }
//
//
//    @Test
//    public void whenCallGetById_ReturnTodo() {
//
//        Todo todo = new Todo(1, "todo", "Todo1");
//
//        given(todoRepository.findById(anyLong())).willReturn(Optional.ofNullable(todo)); //
//
//        Todo result = todoService.getTodoById(1);
//
//        assertThat(result.getName()).containsIgnoringCase("todo"); // make sure the return data contain todo 3shan e7na 7aten constrain en el name mbytkarrsh lw 7agen khkaled hyrag3 error
//        //howa kan mtwak3 el data yrga3 feha khaled bs la2a todo
//        //ignorCase upper w lower case
//
//    }
//    @Test (expected = NotFoundException.class) // to handle the exception No record with the id (1) was found in our database
//        public void whenInvalidId_TodoShouldNotBeFound(){
//
//         given (todoRepository.findById(anyLong())).willReturn(Optional.empty());
//         todoService.getTodoById(1);
//        }
//
//
//
//}
