# Project Guusto

Languages:
Angular, Spring Boot, Postgres, Docker

Structure:

/                              -- Root 

/docker/volume_postgres        -- Volume for Postgres

/fontes/AppGuusto              -- Spring Boot Api

/fontes/guusto-client-angular  -- Angular Client


Steps to start application

1. In the root directory ( / ), start the container: docker-compose up --build --force-recreate
2. In the Angular Client directory ( /fontes/guusto-client-angular ), start project: ng serve

Test unblocked endpoint: http://localhost:8080/app/

The message "ok" will appear on the screen

Open browser in http://localhost:4200

username: admin

password: admin123

You can search for name and/or country
