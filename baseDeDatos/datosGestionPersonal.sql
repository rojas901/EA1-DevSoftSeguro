insert into tipoidentificacion(nombre) values 
('Cedula ciudadania'), 
('Tarjeta de identidad'), 
('Registro Civil'),
('Cedula extranjeria'),
('Pasaporte');

insert into estadocivil(nombre) values 
('Soltero'), 
('Casado'), 
('Divorciado'),
('Union libre'),
('Viudo');

insert into sexo(nombre) values 
('Masculino'), 
('Femenino'), 
('LGTBIQ+');

insert into rol(nombre) values 
('Padres'), 
('Hermanos'), 
('Hijos'),
('Abuelos'),
('Tios'),
('Primos'), 
('Pareja');

insert into universidad(nombre) values 
('IU Digital de Antioquia'), 
('Universidad de Antioquia'), 
('Universidad de Caldas'),
('Universidad de Santander'), 
('Universidad Nacional de Colombia'), 
('SENA');

insert into nivelestudio(nombre) values 
('Tecnico'), 
('Tecnologo'), 
('Pregrado'),
('Posgrado');

insert into tituloestudio(nombre) values 
('Ingeniero'), 
('Doctor'), 
('Especialista'),
('Magister'), 
('Administrador'), 
('Agronomo'),
('Administrador'),
('Abogado'), 
('Trabajador social'), 
('Psicologo'),
('Medico'),
('Enfermero'), 
('Publicista'), 
('Economista');

insert into funcionario(fktipoidentificacion, fkestadocivil, fksexo, 
nombre, apellido, numeroidentificacion, direccion, fechanacimiento,
telefono) values
(1, 1, 1, 'Carlos', 'Rojas', '1054990', 'Cra 3 # 4 - 16', '1990/01/27', '3145552222'),
(1, 2, 2, 'Luisa', 'Rojas', '1053990', 'Cra 2 # 3 - 16', '1995/05/18', '3144442222'),
(1, 2, 1, 'Camilo', 'Gomez', '1053991', 'Cra 2 # 8 - 16', '1990/05/18', '3144442223'),
(1, 1, 2, 'Mariana', 'Diaz', '1053992', 'Cra 5 # 3 - 16', '1992/03/22', '3144442224'),
(1, 1, 1, 'Jose', 'Gonzales', '1053993', 'Cra 10 # 4 - 16', '1997/04/16', '3144442228');

insert into familiar(fktipoidentificacion, fkestadocivil, fksexo, fkrol, fkfuncionario,
nombre, apellido, numeroidentificacion, direccion, fechanacimiento,
telefono) values 
(2, 1, 2, 3, 1, 'Sofia', 'Rojas', '1010221', 'Cra 2 # 3 - 16', '2010/08/18', '3144442228'),
(1, 2, 2, 1, 2, 'Maria', 'Arboleda', '1033991', 'Cra 5 # 8 - 16', '1980/05/18', '3144442255'),
(1, 1, 1, 6, 3, 'Jhon', 'Jimenez', '1053988', 'Cra 22 # 3 - 16', '1988/10/22', '3144442333'),
(2, 1, 1, 2, 4, 'Leo', 'Diaz', '10539456', 'Cra 33 # 4 - 22', '2005/07/17', '3144442888');

insert into infoacademica(fkfuncionario, fkuniversidad, 
fknivelestudio, fktituloestudio) values
(1, 1, 2, 1),
(2, 3, 4, 3),
(3, 5, 3, 1),
(4, 3, 3, 13),
(5, 2, 4, 7);