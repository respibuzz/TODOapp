package io.github.mat3e.Todo.with.Spring.Lang;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RequestMapping("/api")
@RestController
 class LangServlet {

    private final Logger JServLogger = LoggerFactory.getLogger(LangServlet.class);
    private LangService service;

    LangServlet(LangService service) {
        this.service = service;
    }
    @GetMapping("/langs")
    ResponseEntity<List<LangDTO>> findAllLangs(){
        JServLogger.info("got request!");
        return ResponseEntity.ok(service.findAll());
    }
}