package com.abolkog.springboot.tut.todos;


import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import java.io.Serializable;


@Entity //To tell spring that Todoo.java is an entry
@Table(name = "Todoo")


public class Todo implements Serializable {
//public class Todo {


    @Id   //to tell Spring that “id” is a primary key
    @GeneratedValue(strategy = GenerationType.AUTO)

//tells Spring that the field is auto-generated

    @Column(name ="Id")
    private  long id;
    @Column(name ="Name")
    private  String name;
    @Column(name ="Department")
    private  String department;
    private long timestamp;

   public Todo()  {}

    public Todo (long id , String  name ,String department)
    {
            this.id= id;
            this.name=name;
            this.department=department;
            this.timestamp = System.currentTimeMillis();
    }

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

    public long getTimestamp(){ return timestamp; }

    public void setTimestamp(long timestamp) {this.timestamp= timestamp ;}
}
