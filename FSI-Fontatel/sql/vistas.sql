CREATE VIEW menu AS
SELECT nombre, descripcion, precio, foto, categoria
FROM alimentos
WHERE estado = 'disponible'
ORDER BY categoria, nombre;

CREATE VIEW comandas AS
SELECT folio, fecha_hora, observaciones, estadoo,
       alimentos_idalimentos, nombre, descripcion
FROM ordenes
JOIN alimentos ON idalimentos = alimentos_idalimentos
WHERE estadoo = 'ordenado' AND DATE(fecha_hora) = CURDATE()
ORDER BY fecha_hora;

CREATE VIEW tickets AS
SELECT folio, fecha_hora, silla, mesas_numero, clientes_codigoc,
       nombrec, empleados_codigo_mesero, nombree,
       alimentos_idalimentos, nombre, precio
FROM ordenes
JOIN mesas ON numero = mesas_numero
JOIN clientes ON codigoc = clientes_codigoc
JOIN empleados ON codigo = empleados_codigo_mesero
JOIN alimentos ON idalimentos = alimentos_idalimentos
WHERE estadoo = 'pagado';

CREATE VIEW pedidos AS
SELECT folio, fecha_hora, silla, mesas_numero, clientes_codigoc,
       nombrec, empleados_codigo_mesero, nombree,
       alimentos_idalimentos, nombre, precio, observaciones, estadoo
FROM ordenes
JOIN mesas ON numero = mesas_numero
JOIN clientes ON codigoc = clientes_codigoc
JOIN empleados ON codigo = empleados_codigo_mesero
JOIN alimentos ON idalimentos = alimentos_idalimentos;

CREATE VIEW ventas AS
SELECT folio, fecha_hora, clientes_codigoc, nombrec,
       mesas_numero, empleados_codigo_mesero, nombree,
       alimentos_idalimentos, nombre, categoria, precio, estadoo
FROM ordenes
JOIN clientes ON codigoc = clientes_codigoc
JOIN empleados ON codigo = empleados_codigo_mesero
JOIN alimentos ON idalimentos = alimentos_idalimentos
WHERE estadoo = 'pagado'
ORDER BY fecha_hora;
