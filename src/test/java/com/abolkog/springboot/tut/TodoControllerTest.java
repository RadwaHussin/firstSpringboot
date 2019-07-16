//package com.abolkog.springboot.tut;
//
//import com.abolkog.springboot.tut.todos.Todo;
//import com.abolkog.springboot.tut.todos.TodoService;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//
//import static org.hamcrest.Matchers.*;
//
//import static org.mockito.BDDMockito.*;
//import static org.assertj.core.api.Assertions.*;
//
//import java.util.Arrays;
//import java.util.List;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*; //mockMvc.perform(get("Api/v1/todos"))
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*; //andExpect(status().isOk())
//
//@RunWith(SpringRunner.class)
//@SpringBootTest (webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) // bec in controller we need mvc (we need to handle http request
//// to give me a random port
//@AutoConfigureMockMvc // bec we will use moc mvc(which allow us to make http request)
//public class TodoControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private TodoService todoService ;    //bec contlooer mrbot with srevice
//
//
//    @Test    // simple test to make sure if the endpoint is working
//    public void testGetAllTodos() throws Exception{ // we expected there will be exceptions
//        mockMvc.perform(get("/Api/v1/todos")).andExpect(status().isOk()) ;// perform act as assert in todoServiceTest
//        //perform = request while   excpect =result ok 200
//
//    }
//
//    public void whenGetAllTodos_ReturnjasonArray() throws Exception{
//
//        Todo todo1 = new Todo(1,"Todo1" ,"Todo1" );
//        Todo todo2 = new Todo(2,"Todo2" ,"Todo2" );
//        List<Todo> data= Arrays.asList(todo1, todo2); // add this data in list todoo
//
//        given(todoService.findAll()).willReturn(data);
//
//        mockMvc.perform(get("/api/v1/todos").contentType(MediaType.APPLICATION_JSON))
//
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$", hasSize(2)))
//                .andExpect(jsonPath("$[0].name ", equalTo(todo1.getName())));  // to be sure todoo will contain name "Todo1"  ... [0] element of zero and the return value is array
//
//
//    }
//
//    //test how to save todoo all previous we test how to retreive data
//    @Test
//    public void whenPostTodo_thenCreateTodo() throws Exception{
////        Todo todo1 = new Todo(1,"Todo1" ,"Todo1" ); // this isthe todoo we will save it
//
//        Todo todo1 = new Todo();
//        todo1.setName("name of todo");
//        todo1.setDepartment(" name department");
//
//        given(todoService.save(Mockito.any(Todo.class))).willReturn(todo1); //when you send any from todoC   lass it will return
//
//        ObjectMapper mapper = new ObjectMapper(); // to (send) data as jason like what we do in postman
//        mapper.writeValueAsString(todo1); //
//
//        mockMvc.perform(post("/api/v1/todos/")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(mapper.writeValueAsString(todo1))
//        )
//                .andExpect(status().isCreated())
//                .andExpect(jsonPath("$.name" ,is(todo1.getName()))); // the returned value is element so $.element
//
//
//
//
//    }
//
//}
