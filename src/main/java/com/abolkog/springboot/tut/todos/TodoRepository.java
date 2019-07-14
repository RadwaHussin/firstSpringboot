package com.abolkog.springboot.tut.todos; //DAO



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // indicates that an annotated class is a repository, which is an abstraction of data access and storage.

public interface TodoRepository extends JpaRepository<Todo,Long> {

    Todo getTodoById (long id);
    Todo findByName (String name );
}
