Spring Boot + Thymeleaf + Spring Security + CSRF

Example application displays how Spring Security works using against CSRF attack. CSRF (or XSRF - Cross-site request forgery) is an attack method when hacker uses logged in user to
get access to server. Hacker try to force up user to send some prepared request. To prevent it some token should be generated and checked against the same in cookie. 

Differences vs basic:
- in Spring Security csrf if enabled by default;
- to remove it developer hast to use csrf().disable();
- in html following element is automatically generated: <input type="hidden" name="_csrf" value="2cbcbfc0-64b1-431d-aef5-b6e37f57d077">
- to test it please run "test.html". Request without csrf is sent and should be prevented.