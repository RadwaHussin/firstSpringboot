package com.abolkog.springboot.tut.todos; //DAO


import com.abolkog.springboot.tut.todos.Todo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface TodoRepository extends JpaRepository<Todo,Long> {  // de mn 5lalha bn2dr n3ml access lel data

    // da no3 el api jpa

    Todo getTodoById (long id);
}
