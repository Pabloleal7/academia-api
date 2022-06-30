INSERT INTO role (authority) VALUES ('ROLE_ADMIN');
INSERT INTO role (authority) VALUES ('ROLE_OPERATOR');




INSERT INTO user_entity (nome,email,password) VALUES ('pablo','pabloleal7@hotmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO user_entity_roles (user_entity_id,roles_id) VALUES (1,1);

INSERT INTO exercicio_entity (nome) VALUES ('Supino Reto');

INSERT INTO exercicio_info_entity (series,repeticoes, descricao,exercicio_entity_id) VALUES (15,4,'com pouca carga',1);


INSERT INTO ficha_entity (dia,ordem) VALUES (1,1);

INSERT INTO ficha_entity_exercicios (ficha_entity_id,exercicios_id) VALUES (1,1);

