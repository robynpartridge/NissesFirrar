create table products (
  `id` int(10) unsigned not null AUTO_INCREMENT,
  serial_nbr varchar(50),
  dop date,
  status bit
);

create table person (
  `id` int(10) unsigned not null AUTO_INCREMENT,
  name varchar(50)
);