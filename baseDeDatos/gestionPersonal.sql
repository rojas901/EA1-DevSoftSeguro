--Tipo de identificacion
create table TipoIdentificacion(
	idTipoIdentificacion serial not null primary key,
	nombre varchar(50) not null
);

select * from tipoidentificacion;

--Estado civil
create table EstadoCivil(
	idEstadoCivil serial not null primary key,
	nombre varchar(50) not null
);

select * from estadocivil;

--Sexo
create table Sexo(
	idSexo serial not null primary key,
	nombre varchar(50) not null
);

select * from sexo;

--Estado Rol
create table Rol(
	idRol serial not null primary key,
	nombre varchar(50) not null
);

select * from rol;

--Universidad
create table Universidad(
	idUniversidad serial not null primary key,
	nombre varchar(50) not null
);

select * from universidad;

--Nivel de estudio
create table NivelEstudio(
	idNivelEstudio serial not null primary key,
	nombre varchar(50) not null
);

select * from nivelestudio;

--Titulo de estudio
create table TituloEstudio(
	idTituloEstudio serial not null primary key,
	nombre varchar(50) not null
);

select * from tituloestudio;

--Funcionario
create table Funcionario(
	idFuncionario serial not null primary key,
	fkTipoIdentificacion int not null,
	fkEstadoCivil int not null,
	fkSexo int not null,
	nombre varchar(50) not null,
	apellido varchar(50) not null,
	numeroIdentificacion varchar(50) not null,
	direccion varchar(120) not null,
	fechaNacimiento date not null,
	telefono varchar(50) not null,
	foreign key(fkTipoIdentificacion) references tipoidentificacion(idtipoidentificacion),
	foreign key(fkEstadoCivil) references estadocivil(idestadocivil),
	foreign key(fkSexo) references sexo(idsexo)
);

select f.idfuncionario, t.nombre as tipoIdentificacion, 
e.nombre as estadoCivil, s.nombre as sexo, f.nombre, f.apellido,
f.numeroidentificacion, f.direccion, f.fechanacimiento,
f.telefono from funcionario f
inner join tipoidentificacion t 
on t.idtipoidentificacion = f.fktipoidentificacion
inner join estadocivil e
on e.idestadocivil = f.fkestadocivil 
inner join sexo s 
on s.idsexo = f.fksexo;

select * from funcionario;

--Familiar
create table Familiar(
	idFamiliar serial not null primary key,
	fkTipoIdentificacion int not null,
	fkEstadoCivil int not null,
	fkSexo int not null,
	fkRol int not null,
	fkFuncionario int not null,
	nombre varchar(50) not null,
	apellido varchar(50) not null,
	numeroIdentificacion varchar(50) not null,
	direccion varchar(120) not null,
	fechaNacimiento date not null,
	telefono varchar(50) not null,
	foreign key(fkTipoIdentificacion) references tipoidentificacion(idtipoidentificacion),
	foreign key(fkEstadoCivil) references estadocivil(idestadocivil),
	foreign key(fkSexo) references sexo(idsexo),
	foreign key(fkRol) references rol(idrol),
	foreign key(fkFuncionario) references funcionario(idfuncionario)
);

select * from familiar;

--Informacion academica
create table InfoAcademica(
	idInfoAcademica serial not null primary key,
	fkFuncionario int not null,
	fkUniversidad int not null,
	fkNivelEstudio int not null,
	fkTituloEstudio int not null,
	foreign key(fkFuncionario) references funcionario(idfuncionario),
	foreign key(fkUniversidad) references universidad(iduniversidad),
	foreign key(fkNivelEstudio) references nivelestudio(idnivelestudio),
	foreign key(fkTituloEstudio) references tituloestudio(idtituloestudio)	
);


select * from infoacademica;