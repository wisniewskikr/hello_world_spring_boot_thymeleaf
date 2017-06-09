Spring Boot + Thymeleaf + Spring Security + MySql

Example application displays how Spring Security works. Users are stored in MySql database.

Differences vs branch "spring-security-mysql":
- add in SpringSecurityConfig ".headers().frameOptions().disable();";
- improve in SpringSecurityConfig ".antMatchers("/", "/console/**").permitAll()";
- add class DbConfig;
- run queries.sql in http://localhost:8080/console

