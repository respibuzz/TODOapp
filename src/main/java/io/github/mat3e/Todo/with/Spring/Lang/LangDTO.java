package io.github.mat3e.Todo.with.Spring.Lang;

  class LangDTO {

      private Integer id;
      private String langCode;

      public LangDTO(Lang lang){
        id = lang.getId();
        langCode = lang.getLangCode();
      }

     public void setId(Integer idDTO) {
         this.id = idDTO;
     }
     public void setLangCode(String codeDTO) {
         this.langCode = codeDTO;
     }
     public Integer getId() {
         return id;
     }
     public String getlangCode() {
         return langCode;
     }
}
