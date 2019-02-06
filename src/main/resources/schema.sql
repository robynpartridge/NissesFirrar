create table person (
  `id` int(10) unsigned not null AUTO_INCREMENT,
  name varchar(50),
  product_id int,
  constraint pk_person primary key(id)
);

create table products (
  `id` int(10) unsigned not null AUTO_INCREMENT,
  serial_nbr varchar(50),
  dop date,
  status bit,
  person_id int,
  constraint pk_products primary key(id),
  constraint fk_products foreign key(person_id) references person(id)
);