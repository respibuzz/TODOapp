package io.github.mat3e.Todo.with.Spring.Lang;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table( name = "languages" )
 public class Lang {
    @Id
    @GeneratedValue(generator="inc")
    @GenericGenerator(name="inc", strategy = "increment")
     private Integer id;
    @Column(name = "welcomemsg")
     private String welcomeMSG;
    @Column(name = "langcode")
     private String langCode;

     @SuppressWarnings("Hibernate")
     Lang(){
     }
     public Lang(Integer id, String welcomeMSG, String langCode){
         this.id = id;
         this.welcomeMSG = welcomeMSG;
         this.langCode = langCode;
     }
     public Integer getId() {
         return id;
     }
     public String getWelcomeMSG() {
         return welcomeMSG;
     }
     public void setWelcomeMSG(String welcomeMSG) {
         this.welcomeMSG = welcomeMSG;
     }
     public String getLangCode() {
         return langCode;
     }
     public void setLangCode(String langCode) {
         this.langCode = langCode;
     }


}
