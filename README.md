Spring Boot + Thymeleaf + Spring Security + Password Encoder

Example application displays how Spring Security works with password encoder. Example user: admin/admin.

Differences vs spring security:
- create bean with password encoder in class WebConfig;
- use password encoder in SpringSecurityConfig;
- change password for encoded.