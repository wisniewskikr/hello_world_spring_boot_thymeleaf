Spring Boot + Thymeleaf + Spring Security + MySql

Example application displays how Spring Security works. Users are stored in MySql database.
All tables are created automatically. Only database schema has to be created manually by user.

Differences vs basic:
- add SpringSecurityConfig;
- add LoginController;
- add security/login.html template;
- add logout section to all secured pages;
- add styles for security elements;
- add database dependencies in pom;
- add datasource properties in application.properties;
- create MySql schema in database.