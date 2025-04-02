FROM openjdk:17

WORKDIR /usrapp/bin

ENV PORT=8080

COPY /target/classes /usrapp/bin/classes
COPY /target/dependency /usrapp/bin/dependency
COPY .env /usrapp/bin/.env


CMD ["java","-cp","./classes:./dependency/*","escuelaing.edu.co.juntate.JuntateApplication"]
