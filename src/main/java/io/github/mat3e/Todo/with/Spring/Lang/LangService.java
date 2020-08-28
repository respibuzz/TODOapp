package io.github.mat3e.Todo.with.Spring.Lang;

import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;
@Service
class LangService {

   private LangRepository repository;

   LangService(LangRepository langRepository) {
       this.repository = langRepository;
   }
   List<LangDTO>findAll(){
       return repository
               .findAll()
               .stream()
               .map(LangDTO::new)
               .collect(toList());
   }
}

