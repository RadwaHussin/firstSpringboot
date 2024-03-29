package com.abolkog.springboot.tut.todos;


import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;


@Entity //specifies that the class is an entity and is mapped to a database table
@Table(name = "Todoo")

//There are also Hibernate @Entity, @Table, @Id, and @GeneratedValue annotations in the example.


public class Todo implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name ="Id")

    private  long id;

    @Column(name ="Name")
    @NotNull(message = "Name is required")
    @NotEmpty(message = "Name must not be empty")
    @Size(min = 3 ,message = "name must be at east 3 charachter")

    private  String name;

    @Column(name ="Department")
    @NotNull(message = "Department is required")
    @NotEmpty(message = "Department must not be empty")

    private  String department;

//    @GeneratedValue(strategy = GenerationType.AUTO) // marie comment
//    private long userId;


    public Todo()  {}

    public Todo (long id , String  name ,String department)
    {
            this.id= id;
            this.name=name;
            this.department=department;
    }

    //lombok

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

//    public long getUserId() {
//        return userId;
//    }
//
//    public void setUserId(long userId) {
//        this.userId = userId;
//    }
}
