package io.github.mat3e.Todo.with.Spring.Hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
class JavaServlet{

    private final Logger JServLogger = LoggerFactory.getLogger(JavaServlet.class);

    public HelloService service;

    public JavaServlet(HelloService service) {
       this.service = service;
    }
    @GetMapping(value = "/api")
    String greeting(){
        JServLogger.info("got request without params");
        return service.prepareGreeting(null,null);
    }
    @GetMapping(value = "/api", params = "name")
    String greeting(@RequestParam String name){
        JServLogger.info("got request with NAME param");
        return service.prepareGreeting(name,null);
        }

    @GetMapping(value = "/api", params = {"name","lang"})
    String greeting(@RequestParam String name, @RequestParam ("lang") Integer langId){
        JServLogger.info("got request with NAME & LANG params");
        return service.prepareGreeting(name, langId);
    }
}