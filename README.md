Spring Boot + Thymeleaf + KEYCLOAK + SAML

Two thinks does not work here:
- logout
- user name format

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