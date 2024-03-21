-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 28-04-2023 a las 18:27:44
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `dao_citas`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `citas`
--

CREATE TABLE `citas` (
  `id_citas` int(11) NOT NULL,
  `nombres_paciente` varchar(30) NOT NULL,
  `apellidos_paciente` varchar(30) NOT NULL,
  `genero` char(1) NOT NULL,
  `edad` int(11) NOT NULL,
  `fecha_cita` date NOT NULL,
  `hora_cita` varchar(10) NOT NULL,
  `id_clinica` int(11) DEFAULT NULL,
  `id_medico` int(11) DEFAULT NULL,
  `nombre_medico` varchar(60) DEFAULT NULL,
  `especialidad` varchar(60) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `citas`
--

INSERT INTO `citas` (`id_citas`, `nombres_paciente`, `apellidos_paciente`, `genero`, `edad`, `fecha_cita`, `hora_cita`, `id_clinica`, `id_medico`, `nombre_medico`, `especialidad`) VALUES
(10, 'JUANITO', 'PEREZ', 'M', 21, '2023-04-28', '8:00', 2, NULL, 'Bernardo Lopez', 'Medico General'),
(11, 'Pepito ', 'Lozano', 'F', 12, '2023-02-28', '9:00', 1, NULL, 'Carlos Cetino', 'Encologia'),
(12, 'Florentina', 'Castaño', 'F', 34, '2022-10-28', '10:30', 1, NULL, 'Eggar Culajay', 'Urologia'),
(13, 'Lucas', 'Paqueta', 'M', 54, '2022-09-21', '10:30', 2, NULL, 'Octaviano Camei', 'Neumologia'),
(14, 'Antonella', 'Canencio', 'M', 56, '2023-05-03', '10:00', 2, NULL, 'Bernardo Lopez', 'Ginecologia'),
(15, 'Andrea', 'Moño', 'F', 32, '2023-05-28', '14:00', 3, NULL, 'Carlos Cetino', 'Optometria'),
(16, 'Tatis', 'Solis', 'F', 43, '2023-03-28', '9:30', 3, NULL, 'Carlos Cetino', 'Odontologia'),
(17, 'Oscar', 'Carado', 'F', 20, '2023-05-28', '8:00', 3, NULL, 'Carlos Cetino', 'Radiologia'),
(18, 'Leonardo', 'Batalo', 'M', 31, '2023-08-28', '11:00', 4, NULL, 'Mario Villatoro', 'Encologia'),
(19, 'Valeria', 'Paez', 'F', 28, '2023-08-28', '11:00', 4, NULL, 'Mario Villatoro', 'Optometria'),
(20, 'Locancia', 'Ronca', 'F', 24, '2023-06-28', '8:00', 5, NULL, 'Bernardo Lopez', 'Radiologia'),
(21, 'Juan', 'Rivera', 'M', 55, '2023-06-28', '10:30', 6, NULL, 'Luis Diaz', 'Odontologia'),
(22, 'Anita', 'Moncallo', 'M', 56, '2023-06-28', '9:30', 7, NULL, 'Octaviano Camei', 'Urologia'),
(23, 'Rosa', 'Melano', 'M', 65, '2023-09-28', '14:00', 8, NULL, 'Mario Villatoro', 'Ginecologia'),
(24, 'Venito', 'Camelo', 'M', 56, '2023-09-28', '14:00', 9, NULL, 'Mario Villatoro', 'Ginecologia'),
(25, 'Salvajismo', 'Asesino', 'M', 45, '2024-04-28', '11:30', 10, NULL, 'Octaviano Camei', 'Odontologia'),
(26, 'Felipe', 'Melo', 'M', 31, '2024-04-28', '14:30', 9, NULL, 'Harry Kane', 'Oncologia'),
(27, 'Felipe', 'Melo', 'M', 31, '2024-04-28', '14:30', 8, NULL, 'Harry Kane', 'Oncologia'),
(28, 'Lina', 'Mira', 'M', 37, '2023-06-28', '15:00', 5, NULL, 'Octaviano Camei', 'Odontologia');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clinicas`
--

CREATE TABLE `clinicas` (
  `id_clinica` int(11) NOT NULL,
  `nombre_clinica` varchar(30) NOT NULL,
  `empleados` int(11) NOT NULL,
  `encargado` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `clinicas`
--

INSERT INTO `clinicas` (`id_clinica`, `nombre_clinica`, `empleados`, `encargado`) VALUES
(1, 'Susana Lopez', 8, 'Humberto Gonzalez'),
(2, 'La Estancia', 5, 'Marta Gonzalez'),
(3, 'San Jose', 3, 'Julissa Flores'),
(4, 'Santa Gracia', 9, 'Mario Quintanilla'),
(5, 'Reina Victoria', 10, 'Engolo Canteee'),
(6, 'Santa Desgracia 2', 12, 'Julito maraña'),
(7, 'Nueva Eps', 23, 'Loma Grande'),
(8, 'Compensar', 34, 'Riardo Richarlison'),
(9, 'CafeSalud', 16, 'Goku Roto'),
(10, 'HumanaVivir', 14, 'Rudencindo Cristancho'),
(11, 'AsmetSalud', 15, 'Poeta Villano');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `especialidad`
--

CREATE TABLE `especialidad` (
  `id_especialidad` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `especialidad`
--

INSERT INTO `especialidad` (`id_especialidad`, `nombre`) VALUES
(1, 'Ginecologia'),
(2, 'Optometria'),
(3, 'Odontologia'),
(4, 'Urologia'),
(5, 'Dermatologia'),
(6, 'Cardiologia'),
(7, 'Neumologia'),
(8, 'Endoclinologia'),
(9, 'Oncologia'),
(10, 'Radiologia');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `medico`
--

CREATE TABLE `medico` (
  `id_medico` int(11) NOT NULL,
  `nombre_medico` varchar(40) NOT NULL,
  `id_clinica` int(11) DEFAULT NULL,
  `id_especialidad` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `medico`
--

INSERT INTO `medico` (`id_medico`, `nombre_medico`, `id_clinica`, `id_especialidad`) VALUES
(1, 'Juan', 1, 1),
(2, 'Humberto', 2, 2),
(3, 'Mario', 3, 3),
(4, 'Krillin', 4, 4),
(5, 'Herlind', 5, 5),
(6, 'Cristiano', 1, 6),
(7, 'Oscar', 2, 8),
(8, 'Dagoberto', 3, 9),
(9, 'Elsa', 4, 10),
(10, 'Armando', 5, 7);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `citas`
--
ALTER TABLE `citas`
  ADD PRIMARY KEY (`id_citas`),
  ADD KEY `fk_id_clinicaCitas` (`id_clinica`),
  ADD KEY `fk_id_medicoCitas` (`id_medico`);

--
-- Indices de la tabla `clinicas`
--
ALTER TABLE `clinicas`
  ADD PRIMARY KEY (`id_clinica`);

--
-- Indices de la tabla `especialidad`
--
ALTER TABLE `especialidad`
  ADD PRIMARY KEY (`id_especialidad`);

--
-- Indices de la tabla `medico`
--
ALTER TABLE `medico`
  ADD PRIMARY KEY (`id_medico`),
  ADD KEY `kf_id_especialidadMedico` (`id_especialidad`),
  ADD KEY `fk_id_clinicaMedico` (`id_clinica`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `citas`
--
ALTER TABLE `citas`
  MODIFY `id_citas` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT de la tabla `clinicas`
--
ALTER TABLE `clinicas`
  MODIFY `id_clinica` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de la tabla `especialidad`
--
ALTER TABLE `especialidad`
  MODIFY `id_especialidad` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `medico`
--
ALTER TABLE `medico`
  MODIFY `id_medico` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `citas`
--
ALTER TABLE `citas`
  ADD CONSTRAINT `fk_id_clinicaCitas` FOREIGN KEY (`id_clinica`) REFERENCES `clinicas` (`id_clinica`),
  ADD CONSTRAINT `fk_id_medicoCitas` FOREIGN KEY (`id_medico`) REFERENCES `medico` (`id_medico`);

--
-- Filtros para la tabla `medico`
--
ALTER TABLE `medico`
  ADD CONSTRAINT `fk_id_clinicaMedico` FOREIGN KEY (`id_clinica`) REFERENCES `clinicas` (`id_clinica`),
  ADD CONSTRAINT `kf_id_especialidadMedico` FOREIGN KEY (`id_especialidad`) REFERENCES `especialidad` (`id_especialidad`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
