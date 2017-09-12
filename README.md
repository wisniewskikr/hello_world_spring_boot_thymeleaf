Spring Boot + Thymeleaf + Spring Security + Keycloak

This example shows how Spring Boot + Thymeleaf + Spring Security + Keycloak work. 
Keycloak server has to run and be configured. How to do it shows images from
folder "keycloak-images". Because Keycloak server user port 8080 so
this example uses port 8090.



Difference to base:
- pom file:


<dependencyManagement>
		<dependencies>
			<dependency>
				<groupId>org.keycloak.bom</groupId>
				<artifactId>keycloak-adapter-bom</artifactId>
				<version>${keycloak.version}</version>
				<type>pom</type>
				<scope>import</scope>
			</dependency>
		</dependencies>
	</dependencyManagement>

<!-- Keycloak dependencies -->
		<dependency>
		    <groupId>org.keycloak</groupId>
		    <artifactId>keycloak-spring-security-adapter</artifactId>
		</dependency>
		<dependency>
			<groupId>org.keycloak</groupId>
			<artifactId>keycloak-spring-boot-starter</artifactId>
		</dependency>
		
- application.properties:
server.port=8090

keycloak.auth-server-url=http://localhost:8080/auth
keycloak.realm=demo-realm
keycloak.resource=demo-client
keycloak.public-client=true
keycloak.ssl-required = external

- class SecurityConfig;
- class SecurityController;
- input and output controllers and templates - connected with username from Keycloak.		