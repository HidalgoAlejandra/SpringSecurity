DELETE FROM accidente;
DELETE FROM capacitacion;
DELETE FROM cobro;
DELETE FROM estado;
DELETE FROM tarea;
DELETE FROM usuario;
DELETE FROM visita;
DELETE FROM actividad_de_mejora;
DELETE FROM asesoria;
DELETE FROM checklist;
DELETE FROM cliente;
DELETE FROM profesional;

--------------------------------------------------------
-- Archivo creado  - mi�rcoles-agosto-05-2020   
--------------------------------------------------------

Insert into CLIENTE (ID_CLIENTE,RAZON_SOCIAL,RUT_EMPRESA,GIRO,DIRECCION,FONO_CONTACTO,REPRESENTANTE_LEGAL,CONTACTO,EMAIL_CONTACTO) values ('2','Esteban','17046521','Servicios','Gabriela Mistral, Losa','765749812','Esteban Salas','Dani','dani@gmail.net');
Insert into CLIENTE (ID_CLIENTE,RAZON_SOCIAL,RUT_EMPRESA,GIRO,DIRECCION,FONO_CONTACTO,REPRESENTANTE_LEGAL,CONTACTO,EMAIL_CONTACTO) values ('1','Mario','15186064','servicios','san peter','2235235','Mario Larenas','Esteban fido Dido','ban@dido.cl');
Insert into CLIENTE (ID_CLIENTE,RAZON_SOCIAL,RUT_EMPRESA,GIRO,DIRECCION,FONO_CONTACTO,REPRESENTANTE_LEGAL,CONTACTO,EMAIL_CONTACTO) values ('3','Pamela Machine','19814572','Machine','concep','683679729','Pamela M','Mariol','mario@pamela.machine');

Insert into PROFESIONAL (ID_PROFESIONAL,NOMBRE_PROFESIONAL,RUT_PROFESIONAL,TELEFONO_CORP,EMAIL_CORP) values ('1','Jaime Profesional','17870316','92837689','Jaime@elpro.recoders');
Insert into PROFESIONAL (ID_PROFESIONAL,NOMBRE_PROFESIONAL,RUT_PROFESIONAL,TELEFONO_CORP,EMAIL_CORP) values ('2','Claudio T','18404190','5555','claudio@dios.jaime');
Insert into PROFESIONAL (ID_PROFESIONAL,NOMBRE_PROFESIONAL,RUT_PROFESIONAL,TELEFONO_CORP,EMAIL_CORP) values ('3','Daniela','18402902','77367887','dani@blabla.cl');

Insert into ASESORIA (ID_ASESORIA,ID_CLIENTE,ID_PROFESIONAL,FECHA_SOLICITUD,ESTADO_ASESORIA,DETALLE_SOLICITUD) values ('1','1','1',to_date('05/03/20','DD/MM/RR'),'1','Asesor�a sobre seguridad en transporte');
Insert into ASESORIA (ID_ASESORIA,ID_CLIENTE,ID_PROFESIONAL,FECHA_SOLICITUD,ESTADO_ASESORIA,DETALLE_SOLICITUD) values ('2','2','2',to_date('03/04/20','DD/MM/RR'),'1','Asesor�a sobre seguridad en operaci�n de maquinaria');
Insert into ASESORIA (ID_ASESORIA,ID_CLIENTE,ID_PROFESIONAL,FECHA_SOLICITUD,ESTADO_ASESORIA,DETALLE_SOLICITUD) values ('3','3','3',to_date('05/08/20','DD/MM/RR'),'0','Asesor�a sobre seguridad en la oficina ');
Insert into ASESORIA (ID_ASESORIA,ID_CLIENTE,ID_PROFESIONAL,FECHA_SOLICITUD,ESTADO_ASESORIA,DETALLE_SOLICITUD) values ('4','1','2',to_date('04/02/20','DD/MM/RR'),'1','Asesor�a sobre tr�nsito en casino');
Insert into ASESORIA (ID_ASESORIA,ID_CLIENTE,ID_PROFESIONAL,FECHA_SOLICITUD,ESTADO_ASESORIA,DETALLE_SOLICITUD) values ('5','2','1',to_date('21/04/20','DD/MM/RR'),'1','Asesor�a sobre uso de extintores');
Insert into ASESORIA (ID_ASESORIA,ID_CLIENTE,ID_PROFESIONAL,FECHA_SOLICITUD,ESTADO_ASESORIA,DETALLE_SOLICITUD) values ('6','3','3',to_date('09/02/20','DD/MM/RR'),'1','Asesor�a sobre uso de computadores y postura');

Insert into CHECKLIST (ID_CHECKLIST,ID_CLIENTE,FECHA_CREACION,FECHA_CAMBIO) values ('1','1',to_date('04/06/20','DD/MM/RR'),null);
Insert into CHECKLIST (ID_CHECKLIST,ID_CLIENTE,FECHA_CREACION,FECHA_CAMBIO) values ('2','2',to_date('10/06/20','DD/MM/RR'),null);
Insert into CHECKLIST (ID_CHECKLIST,ID_CLIENTE,FECHA_CREACION,FECHA_CAMBIO) values ('3','3',to_date('03/05/20','DD/MM/RR'),to_date('14/06/20','DD/MM/RR'));

Insert into ACCIDENTE (ID_ACCIDENTE,ID_CLIENTE,FECHA_ACCIDENTE,INVOLUCRADO,LUGAR,ACTIVIDAD,DESCRIPCION) values ('7','1',to_date('01/08/20','DD/MM/RR'),'Mario Larenas','Obra','Cargando materiales','Ca�da y en consecuencia fractura del brazo.');
Insert into ACCIDENTE (ID_ACCIDENTE,ID_CLIENTE,FECHA_ACCIDENTE,INVOLUCRADO,LUGAR,ACTIVIDAD,DESCRIPCION) values ('8','2',to_date('30/07/20','DD/MM/RR'),'Juan Gonzales','Trayecto','Viaje hacia el trabajo','Accidente automovilistico.');
Insert into ACCIDENTE (ID_ACCIDENTE,ID_CLIENTE,FECHA_ACCIDENTE,INVOLUCRADO,LUGAR,ACTIVIDAD,DESCRIPCION) values ('9','3',to_date('03/08/20','DD/MM/RR'),'Cristobal Acu�a','Casino','Almuerzo','Quemadura segundo grado por ca�da de la sopa.');
Insert into ACCIDENTE (ID_ACCIDENTE,ID_CLIENTE,FECHA_ACCIDENTE,INVOLUCRADO,LUGAR,ACTIVIDAD,DESCRIPCION) values ('10','2',to_date('18/07/20','DD/MM/RR'),'Javier Mu�oz','Obra','Manejaba retroexcavadora','Volcamiento de la retroexcabadora.El sujeto sale casi ileso.');

Insert into ACTIVIDAD_DE_MEJORA (ID_ACTIVIDAD,ID_ASESORIA,REALIZADO,DETALLE_ACTIVIDAD) values ('2','2','1','Autoevaluaci�n de riesgos cr�ticos');
Insert into ACTIVIDAD_DE_MEJORA (ID_ACTIVIDAD,ID_ASESORIA,REALIZADO,DETALLE_ACTIVIDAD) values ('1','1','1','Charla de seguridad');
Insert into ACTIVIDAD_DE_MEJORA (ID_ACTIVIDAD,ID_ASESORIA,REALIZADO,DETALLE_ACTIVIDAD) values ('3','3','0','Evaluaci�n del cumplimiento de los requisitos legales en materia de seguridad');
Insert into ACTIVIDAD_DE_MEJORA (ID_ACTIVIDAD,ID_ASESORIA,REALIZADO,DETALLE_ACTIVIDAD) values ('4','4','1','Charla de seguridad');
Insert into ACTIVIDAD_DE_MEJORA (ID_ACTIVIDAD,ID_ASESORIA,REALIZADO,DETALLE_ACTIVIDAD) values ('5','5','0','Autoevaluaci�n de riesgos cr�ticos');
Insert into ACTIVIDAD_DE_MEJORA (ID_ACTIVIDAD,ID_ASESORIA,REALIZADO,DETALLE_ACTIVIDAD) values ('6','6','0','Charla de seguridad');

Insert into CAPACITACION (ID_CAPACITACION,ID_ACTIVIDAD,PARTICIPANTES,TEMA,FECHA_CAPACITACION) values ('3','3','34','Manejo seguro de maquinarias',to_date('10/06/20','DD/MM/RR'));
Insert into CAPACITACION (ID_CAPACITACION,ID_ACTIVIDAD,PARTICIPANTES,TEMA,FECHA_CAPACITACION) values ('1','1','36','Seguridad el�ctrica',to_date('06/06/20','DD/MM/RR'));
Insert into CAPACITACION (ID_CAPACITACION,ID_ACTIVIDAD,PARTICIPANTES,TEMA,FECHA_CAPACITACION) values ('2','2','28','Primeros auxilios',to_date('12/05/20','DD/MM/RR'));
Insert into CAPACITACION (ID_CAPACITACION,ID_ACTIVIDAD,PARTICIPANTES,TEMA,FECHA_CAPACITACION) values ('4','4','22','Seguridad en trabajos en altura',to_date('05/05/20','DD/MM/RR'));
Insert into CAPACITACION (ID_CAPACITACION,ID_ACTIVIDAD,PARTICIPANTES,TEMA,FECHA_CAPACITACION) values ('5','5','18','Prevenci�n y control de incendios',to_date('12/07/20','DD/MM/RR'));
Insert into CAPACITACION (ID_CAPACITACION,ID_ACTIVIDAD,PARTICIPANTES,TEMA,FECHA_CAPACITACION) values ('6','6','26','Seguridad en el manejo de maquinaria',to_date('22/06/20','DD/MM/RR'));

Insert into COBRO (ID_PAGO,ID_CLIENTE,N_FACTURA,FECHA_LIMITE,FECHA_DE_PAGO) values ('1','1','136423190',to_date('22/06/20','DD/MM/RR'),to_date('21/06/20','DD/MM/RR'));
Insert into COBRO (ID_PAGO,ID_CLIENTE,N_FACTURA,FECHA_LIMITE,FECHA_DE_PAGO) values ('2','2','256918572',to_date('22/07/20','DD/MM/RR'),to_date('25/07/20','DD/MM/RR'));
Insert into COBRO (ID_PAGO,ID_CLIENTE,N_FACTURA,FECHA_LIMITE,FECHA_DE_PAGO) values ('3','3','146582847',to_date('22/05/20','DD/MM/RR'),to_date('21/05/20','DD/MM/RR'));
Insert into COBRO (ID_PAGO,ID_CLIENTE,N_FACTURA,FECHA_LIMITE,FECHA_DE_PAGO) values ('4','1','156783455',to_date('16/07/20','DD/MM/RR'),null);
Insert into COBRO (ID_PAGO,ID_CLIENTE,N_FACTURA,FECHA_LIMITE,FECHA_DE_PAGO) values ('5','2','243458873',to_date('18/07/20','DD/MM/RR'),to_date('03/07/20','DD/MM/RR'));
Insert into COBRO (ID_PAGO,ID_CLIENTE,N_FACTURA,FECHA_LIMITE,FECHA_DE_PAGO) values ('6','3','255784964',to_date('06/07/20','DD/MM/RR'),to_date('12/07/20','DD/MM/RR'));
Insert into COBRO (ID_PAGO,ID_CLIENTE,N_FACTURA,FECHA_LIMITE,FECHA_DE_PAGO) values ('7','1','134487663',to_date('12/07/20','DD/MM/RR'),to_date('20/07/20','DD/MM/RR'));

Insert into TAREA (ID_TAREA,NOMBRE,DETALLE_TAREA) values ('1','Rellenar extintores',null);
Insert into TAREA (ID_TAREA,NOMBRE,DETALLE_TAREA) values ('2','Revisar instalaciones el�ctricas',null);
Insert into TAREA (ID_TAREA,NOMBRE,DETALLE_TAREA) values ('3','Evaluar estado de la maquinaria',null);
Insert into TAREA (ID_TAREA,NOMBRE,DETALLE_TAREA) values ('4','Evaluar el plan de evacuaci�n',null);
Insert into TAREA (ID_TAREA,NOMBRE,DETALLE_TAREA) values ('5','Implementaci�n de equipos de protecci�n',null);

Insert into USUARIO (ID_USUARIO,TIPO,USUARIO,PASSWORD) values ('1','administrador','17214085','$2a$10$zM6Sc5V98yjjUBxyfzPPVeBpgWmLNv/VUMKbYudNYFW5EinxoOgau');
Insert into USUARIO (ID_USUARIO,TIPO,USUARIO,PASSWORD) values ('2','profesional','17870316','$2a$10$QJ.rePFDgdjOXKxdMTy08Ogk4BSlLS1fu68.bJ9hViIsSRKOQwpY.');
Insert into USUARIO (ID_USUARIO,TIPO,USUARIO,PASSWORD) values ('3','profesional','18404190','$2a$10$IcrP.WHOnf4Z75QCjHnCT.7YWiiMRICTQKHGI3xmeFgZdsYviBkFe');
Insert into USUARIO (ID_USUARIO,TIPO,USUARIO,PASSWORD) values ('4','profesional','18402902','$2a$10$XAW81.t0gRC0rHYJCsuhE.ePzLOto1TVAD/Js3f58l8QHZPrXxXO6');
Insert into USUARIO (ID_USUARIO,TIPO,USUARIO,PASSWORD) values ('5','cliente','15186064','$2a$10$CQpakclrGTuELZzZnTJic.WiLXn.dfXA3XRgXvOy/98TNT5ahjOBq');
Insert into USUARIO (ID_USUARIO,TIPO,USUARIO,PASSWORD) values ('6','cliente','19814572','$2a$10$AuX9nCmvMAcCPcWH0WK5D.XSL6dgB7RupNA.9Y0A0Iyy/XOF.3nqa');
Insert into USUARIO (ID_USUARIO,TIPO,USUARIO,PASSWORD) values ('7','cliente','17046521','$2a$10$nF.snzpZNKK1/SH5sgiz/uFDu/DflsOIlywKJeKIatI9hGBq2fRN6');

Insert into VISITA (ID_VISITA,ID_ASESORIA,FECHA_VISITA,ESTADO) values ('1','1',to_date('10/03/20','DD/MM/RR'),'1');
Insert into VISITA (ID_VISITA,ID_ASESORIA,FECHA_VISITA,ESTADO) values ('2','2',to_date('20/04/20','DD/MM/RR'),'1');
Insert into VISITA (ID_VISITA,ID_ASESORIA,FECHA_VISITA,ESTADO) values ('3','3',to_date('10/06/20','DD/MM/RR'),'1');
Insert into VISITA (ID_VISITA,ID_ASESORIA,FECHA_VISITA,ESTADO) values ('4','4',to_date('22/09/20','DD/MM/RR'),'0');
Insert into VISITA (ID_VISITA,ID_ASESORIA,FECHA_VISITA,ESTADO) values ('5','5',to_date('10/10/20','DD/MM/RR'),'0');
Insert into VISITA (ID_VISITA,ID_ASESORIA,FECHA_VISITA,ESTADO) values ('6','6',to_date('05/06/20','DD/MM/RR'),'1');

Insert into ESTADO (ID_CHECKLIST,ID_TAREA,COMPLETADO) values ('1','1','1');
Insert into ESTADO (ID_CHECKLIST,ID_TAREA,COMPLETADO) values ('2','2','1');
Insert into ESTADO (ID_CHECKLIST,ID_TAREA,COMPLETADO) values ('3','5','0');
Insert into ESTADO (ID_CHECKLIST,ID_TAREA,COMPLETADO) values ('1','3','0');
Insert into ESTADO (ID_CHECKLIST,ID_TAREA,COMPLETADO) values ('2','4','1');
