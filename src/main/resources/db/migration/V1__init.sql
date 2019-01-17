create table student
(
  id    bigint auto_increment
    primary key,
  email varchar(255) not null,
  name  varchar(255) not null
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO student VALUES (1,'john@email.com','John');
INSERT INTO student VALUES (2,'jane@email.com','Jane');
INSERT INTO student VALUES (3,'billy@email.com','Billy');
INSERT INTO student VALUES (4,'miranda@email.com','Miranda');

create table user
(
  id       bigint auto_increment
    primary key,
  admin    bit          not null,
  name     varchar(255) not null,
  password varchar(255) not null,
  username varchar(255) not null,
  constraint UK_sb8bbouer5wak8vyiiy4pf2bx
    unique (username)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO user VALUES (1,1,'admin','$2a$10$VmLuwadDdAaiVawGjqSJyuzYFLg115DQ5QyOJFcfZWZBGFBepJQja','admin');

