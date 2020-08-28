package io.github.mat3e.Todo.with.Spring.Hello;

import io.github.mat3e.Todo.with.Spring.Lang.Lang;
import io.github.mat3e.Todo.with.Spring.Lang.LangRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
class HelloService {

   static final String FALLBACK_NAME = "world";
   static final Lang FALLBACK_LANG = new Lang(1, "Hello ", "en");
   private LangRepository repository;

   HelloService(LangRepository langRepository) {
       this.repository = langRepository;
    }
    String prepareGreeting(String name) {
      return prepareGreeting(name,null);
   }
    String prepareGreeting (String name, Integer id) {
       id = Optional.ofNullable(id).orElse(FALLBACK_LANG.getId());
       String welcomeMSG = repository.findById(id).orElse(FALLBACK_LANG).getWelcomeMSG();
       String nameToPrint = Optional.ofNullable(name).orElse(FALLBACK_NAME);

       return welcomeMSG + " " + nameToPrint + "!";
   }
}
