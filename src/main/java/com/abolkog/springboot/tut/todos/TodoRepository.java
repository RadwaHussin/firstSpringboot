package com.abolkog.springboot.tut.todos; //DAO



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // we can call data from database indicates that an annotated class is a repository, which is an abstraction of data access and storage.

public interface TodoRepository extends JpaRepository<Todo,Long> { //the layer that accesses the database

    Todo getTodoById (long id);
    Todo findByName (String name );
}
