Spring Boot + Thymeleaf + Spring Security + Error 403

Example application displays how Spring Security works. Users are stored in memory.

Differences vs basic:
- add SpringSecurityConfig;
- add SpringSecurityController;
- add security/login.html template;
- add logout section to all secured pages;
- add styles for security elements;
- add MyAccessDeniedHandler class;
- add error403 template.