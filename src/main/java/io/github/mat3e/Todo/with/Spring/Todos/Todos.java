package io.github.mat3e.Todo.with.Spring.Todos;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table( name = "todos" )
public class Todos {
    @Id
    @GeneratedValue(generator="inc")
    @GenericGenerator(name="inc", strategy = "increment")

    private Integer id;
    @Column(name = "todotext")
    private String todoText;
    private boolean done;

    Todos(){};

    public Todos(Integer id, String todoText, boolean done){
        this.id = id;
        this.todoText = todoText;
        this.done = done;
    }
    public Integer getId() { return id; }
    public String getTodoText() { return todoText; }
    public void setTodoText(String todoText){ this.todoText = todoText; }
    public boolean getDone(){ return done; }
    public void setDone(boolean done){ this.done = done; }

}
