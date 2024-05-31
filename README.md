# Athenas Back-end e Front-end

Languages:
Angular, Spring Boot, Mysql, Docker

Structure:

/                              -- Raiz

/docker/volume_mysql       -- Volume do Mysql

/fontes/AppBack              -- Spring Boot Api

/fontes/AppFront             -- Cliente construido em Angular


Passos para iniciar

1. No Docker Composer, comente as imagens deixando apenas ao do mysql
2. No diretorio raiz( / ), inicie o container: docker-compose up --build --force-recreate
3. Rode o maven para gerar o target no diretorio fontes/AppBack
4. Volte do Docker-Composer e Remova os comentarios de todas imagens
5. Inicie novamente o conteiner (Passo 2)

Abra no navegador o endereço: http://localhost:4200
