create table todos (
  id int unsigned PRIMARY KEY auto_increment,
  todoText varchar(100) not null,
  done boolean not null
);