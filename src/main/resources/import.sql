INSERT INTO tb_address (uf, city, borhood, street, zip_code, number, complement) VALUES ('SP', 'Votuporanga', 'Vila Paes', 'Rua John Kennedy', '15500-111', '123', 'Apt 101');
INSERT INTO tb_address (uf, city, borhood, street, zip_code, number, complement) VALUES ('GO', 'Goiânia', 'Residencial Recanto dos Buritis', 'Rua Isabel Moraes Fernandes', '74888-035', '265', 'casa rosa');
INSERT INTO tb_address (uf, city, borhood, street, zip_code, number, complement) VALUES ('AC', 'Rio Branco', 'Geraldo Fleming', 'Rua Manaus', '69918-862', '857', 'casa');
INSERT INTO tb_address (uf, city, borhood, street, zip_code, number, complement) VALUES ('SP', 'São Paulo', 'Bela Vista', 'Rua Teste', '12345-678', '123', 'Apt 101');
INSERT INTO tb_address (uf, city, borhood, street, zip_code, number, complement) VALUES ('SP', 'Sorocaba', 'Itinga', 'Rodovia João Leme', '12345-644', '123', 'Ufscar');

INSERT INTO tb_client (cpf, name, email, phone, birth_date, address_id_fk) VALUES ('114.861.012-08', 'Josefa Vera Assis', 'josefa.assis@fosjc.unesp.br', '(68)98905-5171', '1991-06-19', 1);

INSERT INTO tb_role (name) VALUES ('Desenvolvedor front-end');
INSERT INTO tb_role (name) VALUES ('Cientista de dados');
INSERT INTO tb_role (name) VALUES ('Engenheiro de software');
INSERT INTO tb_role (name) VALUES ('Python Developer');

INSERT INTO tb_employee (cpf, name, email, phone, birth_date, address_id_fk, hire_date, role_id_fk) VALUES ('114.861.112-88', 'Paula de Oliveira', 'paula@fosjc.unesp.br', '(18)98905-5171', '1996-06-29', 2, '2005-09-10', 1);
INSERT INTO tb_employee (cpf, name, email, phone, birth_date, address_id_fk, hire_date, role_id_fk) VALUES ('114.861.111-88', 'Pietro Nunes', 'pietro@fosjc.unesp.br', '(18)98905-5171', '1996-06-29', 3, '2005-09-10', 2);
INSERT INTO tb_employee (cpf, name, email, phone, birth_date, address_id_fk, hire_date, role_id_fk) VALUES ('115.861.111-88', 'Pedro Nunes', 'pedro@fosjc.unesp.br', '(18)98905-5171', '1996-06-29', 4, '2005-09-10', 3);
INSERT INTO tb_employee (cpf, name, email, phone, birth_date, address_id_fk, hire_date, role_id_fk) VALUES ('115.861.116-88', 'Paola Nunes', 'paola@fosjc.unesp.br', '(11)98905-5171', '1996-06-29', 5, '2010-09-10', 4);

