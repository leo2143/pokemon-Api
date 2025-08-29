INSERT INTO movements (id, `name`, strenght, `precision_mov`, description, pp, type_id, priority) VALUES
(1, 'Placaje', 40, 100, 'Causa daño', 35, 9, 0),
(2, 'Danza espada', 0, 100, 'Aumenta en dos niveles el ataque del usuario', 30, 9, 0),
(3, 'Burbuja', 20, 100, 'Causa daño y tiene una probabilidad del 10% de bajar la velocidad', 30, 1, 0),
(4, 'Cascada', 80, 100, 'Causa daño', 15, 1, 0),
(5, 'Hidrobomba', 120, 80, 'Causa daño', 5, 1, 0),
(6, 'Martillazo', 90, 85, 'Causa daño con probabilidad de dar golpe critico (12,5%)', 10, 1, 0),
(7, 'Pistola de agua', 40, 100, 'Causa daño', 25, 1, 0),
(8, 'Rayo burbuja', 65, 100, 'Causa daño y tiene una probabilidad del 10% de bajar la velocidad', 20, 1, 0),
(9, 'Refugio', 0, 100, 'Aumenta la defensa en un nivel', 40, 1, 0),
(10, 'Surf', 95, 100, 'Causa daño', 15, 1, 0),
(11, 'Tenaza', 35, 75, 'Causa daño durante 2-5 turnos. Imposibilidad de atacar al objetivo', 15, 1, 0),
(12, 'Chupa vidas', 20, 100, 'Causa daño y recupera el 50% PS quitados', 15, 2, 0),
(13, 'Disparo demora', 0, 95, 'Baja la velocidad del objetivo', 40, 2, 0),
(14, 'Doble ataque', 25, 100, 'Causa daño golpeando dos veces. Cada golpe tiene un 20% de probabilidad de envenenar.', 20, 2, 0),
(15, 'Pin misil', 14, 85, 'Causa daño al objetivo de 2 a 5 veces', 20, 2, 0),
(16, 'Furia dragón', 0, 100, 'Quita siempre 40 PS al objetivo', 10, 3, 0),
(17, 'Impactrueno', 40, 100, 'Causa daño y tiene una probabilidad del 10% de paralizar el objetivo.', 30, 4, 0),
(18, 'Onda trueno', 0, 100, 'Paraliza el objetivo', 20, 4, 0),
(19, 'Puño trueno', 75, 100, 'Causa daño y tiene un 10% de paralizar el objetivo', 35, 4, 0),
(20, 'Rayo', 95, 100, 'Causa daño y tiene un 10% de paralizar el objetivo', 15, 4, 0),
(21, 'Trueno', 120, 70, 'Causa daño y tiene un 10% de paralizar el objetivo', 10, 4, 0),
(23, 'Lenguetazo', 20, 100, 'Causa daño y tiene un 30% de paralizar el objetivo', 30, 5, 0),
(24, 'Rayo confuso', 0, 100, 'Confunde al objetivo', 10, 5, 0),
(25, 'Tinieblas', 0, 100, 'Resta la cantidad de PS equivalentes al nivel de usuario', 15, 5, 0),
(26, 'Ascuas', 40, 100, 'Causa daño y tiene una probabilidad del 10% de quemar al objetivo', 25, 6, 0),
(27, 'Giro fuego', 15, 100, 'Causa dañó de 2 a 5 turnos. Imposibilidad de atacar al objetivo', 15, 6, 0),
(28, 'Lanzallamas', 95, 100, 'Causa daño y tiene una probabilidad del 10% de quemar al objetivo', 15, 6, 0),
(29, 'Llamarada', 120, 85, 'Causa daño y tiene una probabilidad del 30% de quemar al objetivo', 5, 6, 0),
(30, 'Puño fuego', 75, 100, 'Causa daño y tiene una probabilidad del 10% de quemar al objetivo', 15, 4, 0),
(31, 'Neblina', 0, 0, 'Neblina evita durante 5 turnos que otros Pokémon puedan reducir las estadísticas del equipo aliado', 30, 7, 0),
(32, 'Niebla', 0, 0, 'Restaura todos los cambios, tantos positivos como negativos, en las estadísticas de todos los Pokémon.', 30, 7, 0),
(33, 'Puño hielo', 75, 100, 'Causa daño y tiene una probabilidad del 10% de congelar al objetivo', 15, 7, 0),
(34, 'Rayo aurora', 65, 100, 'Causa daño y tiene una probabilidad del 10% de bajar un nivel el ataque del objetivo', 20, 7, 0),
(35, 'Rayo hielo', 95, 100, 'Causa daño y tiene una probabilidad del 10% de congelar al objetivo', 10, 7, 0),
(36, 'Ventisca', 120, 90, 'Causa daño y tiene una probabilidad del 10% de congelar al objetivo', 5, 7, 0),
(37, 'Contraataque', 0, 100, 'Devuelve el doble daño recibido si es un físico', 20, 8, -5),
(38, 'Doble patada', 30, 100, 'Causa daño, golpeando 2 veces en un mismo turno', 30, 8, 0),
(39, 'Movimiento sísmico', 0, 100, 'Resta la cantidad de PS equivalentes al nivel de usuario', 20, 8, 0),
(40, 'Patada baja', 50, 90, 'Causa daño y tiene del 30% de retroceder al objetivo', 20, 8, 0),
(41, 'Patada giro', 60, 85, 'Causa daño y tiene del 30% de retroceder al objetivo', 15, 8, 0),
(42, 'Patada salto', 70, 100, 'Causa daño. Si falla, el usuario se golpea a sí mismo restándole 1 PS.', 25, 8, 0),
(43, 'Patada salto alta', 85, 90, 'Causa daño. Si falla, el usuario se golpea a sí mismo restándole 1 PS.', 20, 8, 0),
(44, 'Sumisión', 80, 80, 'Causa daño. Causa daño de retroceso al usuario de 1/4 del daño causado.', 20, 8, 0),
(45, 'Afilar', 0, 100, 'Sube el ataque del usuario en un nivel', 30, 9, 0),
(46, 'Agarre', 55, 100, 'Causa daño.', 30, 9, 0),
(47, 'Amortiguador', 0, 0, 'Restaura la mitad de los PS máximos del usuario', 10, 9, 0),
(48, 'Anulación', 0, 55, 'Anula un movimiento del objetivo', 20, 9, 0),
(49, 'Arañazo', 40, 100, 'Causa daño.', 35, 9, 0),
(50, 'Atadura', 15, 75, 'Causa daño de 2 a 5 turnos. Imposibilidad de atacar al objetivo', 20, 9, 0),
(51, 'Ataque arena', 0, 100, 'Baja la precisión en un nivel.', 15, 9, 0);
INSERT INTO movements (`id`, `name`, `strenght`, `precision_mov`, `description`, `pp`, `type_id`, `priority`) VALUES
(52, 'Ataque furia', 15, 85, 'Causa daño de 2 a 5 turnos.', 20, 9, 0),
(53, 'Ataque rápido', 40, 100, 'Causa daño.', 30, 9, 1),
(54, 'Autodestrucción', 130, 100, 'Causa daño y debilita al usuario.', 5, 9, 0),
(55, 'Beso amoroso', 0, 75, 'Duerme al obejtivo', 10, 9, 0),
(56, 'Bomba huevo', 100, 75, 'Causa daño', 10, 9, 0),
(57, 'Bomba sónica', 0, 90, 'siempre quita 20 PS', 20, 9, 0),
(58, 'Cabezazo', 100, 100, 'Se prepara durante el primer turno y ataca en el segundo', 15, 9, 0),
(59, 'Canto', 0, 55, 'Duerme al objetivo.', 15, 9, 0),
(60, 'Chirrido', 0, 85, 'Baja en dos niveles la defensa del objetivo.', 40, 9, 0),
(61, 'Clavo cañón', 20, 100, 'Causa daño de 2 a 5 turnos.', 15, 9, 0),
(62, 'Conversión', 0, 0, 'Cambia el tipo del usuario del oponente', 30, 9, 0),
(63, 'Cornada', 65, 100, 'Causa daño.', 25, 9, 0),
(64, 'Corte', 50, 100, 'Causa daño.', 30, 9, 0),
(65, 'Cuchillada', 70, 100, 'Causa daño y tiene una alta probabilidad de causar un golpe crítico (12,5%).', 20, 9, 0),
(66, 'Derribo', 90, 85, 'Causa daño. Causa daño de retroceso al usuario de 1/4 del daño causado ', 20, 9, 0),
(67, 'Desarrollo', 0, 0, 'Aumenta en un nivel el especial del usuario.', 40, 9, 0),
(68, 'Deslumbrar', 0, 100, 'Provoca paralisis al objetivo.', 30, 9, 0),
(69, 'Destello', 0, 100, 'Baja un nivel la precisición del oponente.', 20, 9, 0),
(70, 'Destructor', 40, 100, 'Causa daño.', 35, 9, 0),
(71, 'Día de pago', 40, 100, 'Causa daño. Se esparcen monedas que se recogen al final del combate', 20, 9, 0),
(72, 'Doble equipo', 0, 0, 'Aumenta en un nivel la evasión del usuario.', 15, 9, 0),
(73, 'Doble filo', 100, 100, 'Causa daño. Causa daño de retroceso al usuario de 1/4 del daño causado.', 15, 9, 0),
(74, 'Doblebofetón', 15, 85, 'Causa daño de 2 a 5 turnos.', 10, 9, 0),
(75, 'Explosión', 170, 100, 'Causa daño y debilita al usuario.', 5, 9, 0),
(76, 'Foco energía', 0, 0, 'Aumenta la probabilidad asestar golpes criticos.', 40, 9, 0),
(77, 'Fortaleza', 0, 0, 'Aumenta en un nivel la defensa del usuario.', 30, 9, 0),
(78, 'Fuerza', 80, 100, 'Causa daño.', 15, 9, 0),
(79, 'Furia', 20, 100, 'Causa daño. No puede cambiar de movements.', 20, 9, 0),
(80, 'Golpe', 90, 100, 'Causa daño entre 3 o 4 turnos seguidos. El usuario termina confundido.', 20, 9, 0),
(81, 'Golpe cabeza', 70, 100, 'Causa daño y tiene una probabilidad del 30% de hacer retroceder.', 15, 9, 0),
(82, 'Golpe cuerpo', 85, 100, 'Causa daño y tiene una probabilidad del 30% de paralizar el objetivo.', 15, 9, 0),
(83, 'Golpe kárate', 50, 100, 'Causa daño y tiene un alto índice de golpe crítico.', 25, 9, 0),
(84, 'Golpes furia', 50, 100, 'Causa daño de 2 a 5 turnos.', 15, 9, 0),
(85, 'Gruñido', 0, 100, 'Baja un nivel el ataque del objetivo.', 40, 9, 0),
(86, 'Guillotina', 0, 30, 'Si acierta, provoca KO en un turno.', 5, 9, 0),
(87, 'Hipercolmillo', 80, 90, 'Causa daño y tiene un una probabilidad del 10% de hacer retroceder al objetivo.', 15, 9, 0),
(88, 'Hiperrayo', 150, 90, 'Causa daño. No podra moverse en el segundo turno.', 5, 9, 0),
(89, 'Látigo', 0, 100, 'Baja en un nivel la defensa del oponente.', 30, 9, 0),
(90, 'Malicioso', 0, 100, 'Baja en un nivel la defensa del oponente.', 30, 9, 0);
(91, 'Megapatada', 120, 75, 'Causa daño.', 5, 9, 0);
(92, 'MegaPuño', 80, 85, 'Causa daño.', 20, 9, 0);
(93, 'Metrónomo', 0, 0, 'Utiliza un movements (id,name,strenght,precision_mov,description,pp,type_id,priority) al azar.', 15, 9, 0);
(94, 'Mimético', 0, 0, 'Permite al usuario elegir uno de los movimientos del objetivo y copiarlo.', 25, 9, 0);
(95, 'Mordisco', 60, 100, 'Causa daño y tiene una probabilidad del 10% de hacer retroceder.', 25, 9, 0);
(96, 'Pantalla de humo', 0, 100, 'Baja en un nivel la precisión del oponente.', 20, 9, 0);
(97, 'Perforador',0, 30, 'Si acierta, provoca KO en un turno.', 5, 9, 0);
(98, 'Pisotón', 65, 100, 'Causa daño y tiene una probabilidad del 30% de hacer retroceder.', 20, 9, 0);
(100, 'Atizar', 80, 75, 'Causa daño.', 20, 9, 0);
(101, 'Presa', 50, 100, 'Causa daño de 2 a 5 turnos.', 20, 9, 0);
(102, 'Puño cometa', 18, 85, 'Causa daño de 2 a 5 turnos.', 15, 9, 0);
(103, 'Rapidez', 60, 0, 'Causa daño. No falla.', 20, 9, 0);
(104, 'Recuperación', 0, 0, 'Restaura la mitad de los PS máximos del usuario', 20, 9, 0);
(105, 'Reducción', 0, 0, 'Aumenta la evasión del usuario en un nivel.', 10, 9, 0);
(106, 'Remolino', 0, 85, 'Ahuyenta a los pokemon salvajes.', 20, 9, 0);
(107, 'Constricción', 15, 85, 'Causa daño de 2 a 5 turnos. Imposibilidad de atacar al objetivo', 20, 9, 0);
(109, 'Rizo de defensa', 0, 100, 'Aumenta en un nivel la defensa del usuario.', 40, 9, 0);
(110, 'Rugido', 0, 0, 'Ahuyenta a los pokemon salvajes.', 20, 9, -6);
(111, 'Salpicadura', 0, 0, 'No tiene ningún efecto.', 40, 9, 0);
(112, 'Superdiente', 0, 90, 'Quita al objetivo la mitad de sus PS actuales.', 10, 9, 0);
(113, 'Supersónico', 0, 55, 'Confunde al objetivo.', 20, 9, 0);
(114, 'Sustituto', 0, 0, 'Crea un sustituo con el 25% de los PS maximos del usuario para que reciba el daño de los movimientos', 10, 9, 0);
(115, 'Tornado', 40, 100, 'Causa daño.', 35, 9, 0);
(116, 'Transformación', 0, 0, 'Convierte al usuario en el Pokémon objetivo, copiando su tipo, sus movimientos, habilidad, su ratio de captura, sus estadísticas y cambios en las mismas.', 10, 9, 0);
(117, 'Triataque', 80, 100, 'Causa daño. Tiene un 20% de provocar quemaduras, paralisis o congelación', 10, 9, 0);
(118, 'Venganza', 0, 0, ' Hace que el usuario se mantenga inmóvil durante 2-3 turnos seguidos, sin poder realizar ninguna acción, para después devolver el doble del daño recibido. El movements (id,name,strenght,precision_mov,description,pp,type_id,priority) falla si el usuario no resulta dañado por el enemigo.', 10, 9, 0);
(119, 'Viento cortante', 80, 75, 'carga en el primer turno que es efectuado, creando un remolino. En el segundo turno, causa daño.', 10, 9, 0);
(120, 'Absorber', 20, 100, 'Causa daño y el usuario recupera el 50% de los PS quitados por el movements (id,name,strenght,precision_mov,description,pp,type_id,priority) al objetivo', 20, 10, 0);
(121, 'Danza pétalo', 70, 100, 'Causa daño entre 3 o 4 turnos seguidos. El usuario termina confundido.', 20, 10, 0);
(122, 'Drenadoras', 0, 90, 'Planta tres semillas en el oponente, las cuales le roban 1/16 de sus PS máximos al final de cada turno. El usuario recupera esa misma cantidad de PS. Si el usuario es cambiado, el Pokémon que pase a ocupar su lugar recibirá esos puntos de salud. El efecto se pasa al cambiar el Pokémon infectado por drenadoras. Drenadoras no afecta a Pokémon de tipo planta.', 10, 10, 0);
(123, 'Espora', 0, 100, 'Duerme al objetivo.', 15, 10, 0);
(124, 'Hoja afilada', 55, 95, 'Causa daño y tiene una alta probabilidad de dar un golpe crítico (12,5%).', 25, 10, 0);
(125, 'Látigo cepa', 35, 100, 'Causa daño.', 25, 10, 0);
(126, 'Megaagotar', 45, 100, 'Causa daño y el usuario recupera el 50% de los PS quitados por el movements (id,name,strenght,precision_mov,description,pp,type_id,priority) al objetivo', 15, 10, 0);
(127, 'Paralizador', 0, 75, 'Paraliza al objetivo', 30, 10, 0);
(128, 'Rayo solar', 120, 100, 'utiliza este movements (id,name,strenght,precision_mov,description,pp,type_id,priority) concentra la energía solar un turno, para liberar un rayo que causa daño en el siguiente turno.', 10, 10, 0);
(129, 'Somnífero', 0, 75, 'Duerme al objetivo', 15, 10, 0);
(130, 'Agilidad', 0, 0, 'Sube en dos niveles la velocidad del usuario.', 30, 11, 0);
(131, 'Amnesia', 0, 0, 'Aumenta en dos niveles el especial del usuario', 20, 11, 0);
(132, 'Barrera', 0, 0, 'Aumneta en dos niveles la defensa del usuario.', 30, 11, 0);
(133, 'Comesueños', 100, 100, 'Causa daño a un objetivo dormido y el usuario recupera el 50% de los PS quitados por movements (id,name,strenght,precision_mov,description,pp,type_id,priority) al objetivo.', 15, 11, 0);
(134, 'Confusión', 50, 100, 'Causa daño y tiene una probabilidad del 10% de confundir al objetivo.', 25, 11, 0);
(135, 'Descanso', 0, 0, 'hace que el usuario se duerma y recupere la totalidad de los PS, curando en el proceso cualquier problema de estado. El usuario después permanece dormido durante 2 turnos.', 10, 11, 0);
(136, 'Hipnosis', 0, 60, 'Duerme al objetivo.', 20, 11, 0);
(137, 'Kinético', 0, 80, 'Baja la precisión del objetivo en un nivel.', 15, 11, 0);
(138, 'Meditación', 0, 0, 'aumenta un nivel el ataque del usuario.', 40, 11, 0);
(139, 'Pantalla de luz', 0, 0, 'Dobla la defensa especial del usuario.', 30, 11, 0);
(140, 'Psicoonda', 0, 80, 'Causa un daño variable al oponente, elegido al azar de un número entre 0,5 y 1,5 veces el nivel del usuario.', 15, 11, 0);
(141, 'Psicorrayo', 65, 60, 'Causa daño y tiene una probabilidad del 10% de confundir al objetivo.', 20,  11, 0);
(142, 'Psíquico', 90, 100, 'Causa daño y tiene una probabilidad del 30% de bajar en un nivel el especial del objetivo.', 20,  11, 0);
(143, 'Reflejo', 0, 0, 'Dobla la defensa física del usuario.', 20, 11, 0);
(144, 'Teletransporte', 0, 0, 'Permite huir de combates individuales.', 20, 11, 0);
(145, 'Avalancha', 75, 90, 'Causa daño.', 10, 12, 0);
(146, 'Lanzarocas', 50, 65, 'Causa daño.', 15, 12, 0);
(147, 'Excavar', 100, 100, 'Cava en el primer turno y el segundo turno ataca.', 10, 13, 0);
(148, 'Fisura', 0, 30, 'Si acierta, provoca un golpe fulminante.', 5, 13, 0);
(149, 'Hueso palo', 65, 85, 'Causa daño y tiene una probabilidad del 10% de hacer retroceder al objetivo.', 20, 13, 0);
(150, 'Huesomerang', 50, 90, 'Causa daño, golpeando al objetivo en un mismo turno.', 10, 13, 0);
(151, 'Terremoto', 100, 100, 'Causa daño.', 10, 13, 0);
(152, 'Ácido', 40, 100, 'Causa daño y tiene una probabilidad deñ 10% de bajar un nivel la defensa del objetivo.', 30, 14, 0);
(153, 'Armadura ácida', 0, 0, 'Sube en dos niveles la defensa del usuario.', 20, 14, 0);
(154, 'Gas venenoso', 0, 55, 'Envenena al objetivo', 40, 14, 0);
(155, 'Picotazo venenoso', 15, 100, 'Causa daño y tiene una probabilidad del 30% de envenenar al oponente.', 35, 14, 0);
(156, 'Polución', 20, 70, 'Causa daño y tiene una probabilidad del 40% de envenar al objetivo.', 20,  14, 0);
(157, 'Polvo veneno', 0, 75, 'Envenena al objetivo', 35, 14, 0);
(158, 'Residuos', 65, 100, 'Causa daño y tiene una probabilidad del 30% de envenenar al objetivo.', 20, 14, 0);
(159, 'Tóxico', 0, 85, 'provoca un grave envenenamiento que se agrava con el paso de los turnos.', 10, 14, 0);
(160, 'Ataque aéreo', 140, 90, 'Se prepara durante el primer turno. En el segundo turno causa daño al objetivo.', 5, 15, 0);
(161, 'Ataque ala', 35, 100, 'Causa daño.', 35, 15, 0);
(162, 'Movimiento espejo', 0, 0, 'Utiliza el último ataque usado que haya tenido al usuario por objetivo. ', 20, 15, 0);
(164, 'Pico taladro', 80, 100, 'Causa daño.', 20, 15, 0);
(165, 'Picotazo', 35, 100, 'Causa daño.', 35, 15, 0);
(166, 'Vuelo', 70, 100, ' emplea dos turnos: en el primero, el Pokémon vuela muy alto, tanto que estará fuera del alcance de la mayoría de los movimientos. En el segundo turno ocurre la caída del vuelo, en la cual el Pokémon golpea al oponente, pero puede ser interrumpida de muchas maneras.', 15, 15, 0);
(167, 'Restricción', 10, 100, 'Restricción causa daño y tiene una probabilidad del 10% de bajar un nivel la velocidad del oponente.', 35, 9, 0);
(168, 'Puño mareo', 70, 100, 'Causa daño y tiene una probabilidad del 20% de confundir al objetivo.', 10, 9, 0);
