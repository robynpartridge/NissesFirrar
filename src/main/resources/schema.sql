create table person (
  `id` int(10) unsigned not null AUTO_INCREMENT,
  name varchar(50),
  constraint pk_person primary key(id)
);

create table company (
  `id` int(10) unsigned not null AUTO_INCREMENT,
  org_nbr int(10),
  name varchar(50),
  constraint pk_company primary key(id),
);

create table products (
  `id` int(10) unsigned not null AUTO_INCREMENT,
  serial_nbr varchar(50),
  dop date,
  status bit,
  person_id int,
  constraint pk_products primary key(id),
  constraint fk_products foreign key(person_id) references person(id),
);

create table products_company (
  company_id int(10) not null,
  products_id int(10) not null,
  constraint products_company_pk primary key (`company_id`, `products_id`),
  constraint products_company_company_id_fk foreign key (`company_id`) references company(id) on delete cascade,
  constraint products_company_products_id_fk foreign key (`products_id`) references products(id) on delete cascade
);