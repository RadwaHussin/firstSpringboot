package com.abolkog.springboot.tut.todos; //DAO



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface TodoRepository extends JpaRepository<Todo,Long> {

    Todo getTodoById (long id);
    Todo findByName (String name );
}
