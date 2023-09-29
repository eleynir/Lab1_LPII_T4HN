CREATE DATABASE Lab1_LPII;

USE Lab1_LPII;

CREATE TABLE EMPLEADO (
    IdEmpleado INT PRIMARY KEY AUTO_INCREMENT,
    Apellidos VARCHAR(255),
    Nombres VARCHAR(255),
    Edad INT,
    Sexo CHAR(1),
    Salario DECIMAL(10, 2)
);

INSERT INTO EMPLEADO (IdEmpleado, Apellidos, Nombres, Edad, Sexo, Salario)
VALUES
(1, 'Gonzalez', 'Juan', 30, 'M', 2500.00),
(2, 'Martinez', 'Ana', 28, 'F', 3000.00),
(3, 'Perez', 'Carlos', 35, 'M', 3200.50),
(4, 'Rodriguez', 'Isabel', 40, 'F', 2800.75),
(5, 'Gomez', 'Diego', 22, 'M', 2100.25);


