Spring Boot + Thymeleaf + KEYCLOAK + SAML

Link:
https://localhost:8444

One thing does not work here:
- logout

Differences vs basic:
- add SpringSecurityConfig;
- add in POM:
<dependency>
		    <groupId>org.springframework.security.extensions</groupId>
		    <artifactId>spring-security-saml-dsl</artifactId>
		    <version>1.0.0.M3</version>
		</dependency>
		
Keycloak:
- client id has to be the same as URL;
- keys pair has to be the same in keycloak and in application. Download them from keycloak.			