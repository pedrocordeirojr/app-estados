# app-estados

Informações:
Spring Boot - Java 8

Requer acesso ao MySQL
Antes de inializar a aplicação executar o script abaixo?
create database appEstados;

Verifique a configuração de acesso ao banco no properties do projeto, após inicialização executar o script abaixo:

INSERT INTO appEstados.configuracao
(corte, custo_operacional, desconto)
VALUES(50000 , 123.45, 12.3);
 

INSERT INTO appEstados.estados
(bandeira, combo_default, exclusao, nome)
VALUES('santa-catarina.jpg', 1, 1, 'Santa Catarina'),
('rio-grande-do-sul.jpg', 0, 0, 'Rio Grande do Sul'),
('parana.jpg', 0, 1, 'Paraná');


INSERT INTO appEstados.cidades
(estado, nome, populacao)
VALUES( 1, 'Chapecó', 198002),(1, 'Florianópolis', 598232),( 2, 'Porto Alegre', 1453432),
(2, 'Campo bom', 60456),(3, 'Curitiba', 1754234),( 3, 'Londrina', 485822);
