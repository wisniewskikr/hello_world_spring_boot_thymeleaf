SPRING-BOOT + THYMELEAF + SSL

This example shows how to secure localhost by SSL. How to change from "http" to "https".
It contains also redirection from http://localhost:8080 to https://localhost:8443.



Differences to basic:

- add SSL properties to file "application.properties"
server.port=8443
server.ssl.key-store=src/main/resources/secured/test.jks
server.ssl.key-store-password=Test1234

- add KeyStore to folder src/main/resources/secured

- add class SecurityConfig.java 