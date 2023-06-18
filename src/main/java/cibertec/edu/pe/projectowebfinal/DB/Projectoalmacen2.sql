
create database projectoalmacen2;
use projectoalmacen2;
Create table tb_productos(
idprod int not null auto_increment,
descripcion varchar(100),
estado int ,
idtipo int,
precio double,
stock int,
fecha_ingreso DATE,
idprov int,
foreign key (idprov) references tb_proveedores(idprov),
foreign key (idtipo) references tb_categorias(idtipo),
constraint pk_tb_productos primary key(idprod) 
);
select * from tb_proveedores;
Create table tb_categorias(
idtipo int not null auto_increment,
nombrecategoria varchar(100),
constraint pk_tb_categorias primary key(idtipo) 
);

create table tb_proveedores(
idprov int not null auto_increment,
nombre varchar(255),
direccion varchar(255),
telefono char(9),
ruc char(11),
razonsocial varchar(255),
pais varchar(255),
ciudad varchar(255),

constraint pk_tb_proveedores primary key (idprov));

CREATE TABLE `user` (
  `id` BIGINT AUTO_INCREMENT PRIMARY KEY,
  `first_name` VARCHAR(255) NOT NULL,
  `last_name` VARCHAR(255) NOT NULL,
  `email` VARCHAR(255) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  CONSTRAINT `unique_email` UNIQUE (`email`)
);

CREATE TABLE `role` (
  `id` BIGINT AUTO_INCREMENT PRIMARY KEY,
  `name` VARCHAR(255) NOT NULL
);

CREATE TABLE `users_roles` (
  `user_id` BIGINT NOT NULL,
  `role_id` BIGINT NOT NULL,
 CONSTRAINT `fk_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_role_id` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE CASCADE,
  PRIMARY KEY (`user_id`, `role_id`)
);

CREATE TABLE tb_ordenes_de_compra (
    idorden INT NOT NULL AUTO_INCREMENT,
    descripcion VARCHAR(255),
    fecha DATE,
    total DECIMAL,
    idprov INT,
    idusu BIGINT,
    CONSTRAINT fk_user_oc FOREIGN KEY (idusu) REFERENCES `user` (id) ON DELETE CASCADE,
    CONSTRAINT fk_proveedor_oc FOREIGN KEY (idprov) REFERENCES tb_proveedores (idprov) ON DELETE CASCADE,
    CONSTRAINT pk_tb_ordenes_de_compra PRIMARY KEY (idorden)
);