FROM node:alpine

WORKDIR /usr/src/app

COPY . /usr/src/app

RUN npm install -g @angular/cli@13

RUN npm install

CMD ["ng", "serve", "--open --host", "0.0.0.0"]
