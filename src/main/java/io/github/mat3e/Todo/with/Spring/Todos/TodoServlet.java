package io.github.mat3e.Todo.with.Spring.Todos;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/todos")
 class TodoServlet extends HttpServlet {

    private final Logger todoServLogger = LoggerFactory.getLogger(TodoServlet.class);
    private TodoRepository todoRepository;

    TodoServlet(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }
    @GetMapping
     ResponseEntity<List<Todos>> findAllTodos(){
        todoServLogger.info("got request");
        return ResponseEntity.ok(todoRepository.findAll());
    }

    @PutMapping("/{id}")
    ResponseEntity<Todos> toggleTodo(@PathVariable Integer id) {
            Optional<Todos> todo = todoRepository.findById(id);
            todo.ifPresent(t -> {
                t.setDone(!t.getDone());
                todoRepository.save(t);
            });
            return todo.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    ResponseEntity <Todos> saveTodo (@RequestBody Todos todo){
        return ResponseEntity.ok(todoRepository.save(todo));
    }
}