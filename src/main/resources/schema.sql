create table products (
  `id` int(10) unsigned not null AUTO_INCREMENT primary key,
  serial_nbr varchar(50),
  dop date,
  status bit,
  person_id int,
  foreign key (person_id) references person(id)
);

create table person (
  `id` int(10) unsigned not null AUTO_INCREMENT primary key,
  name varchar(50),
  product_id int,
  foreign key (product_id) references products(id)
);