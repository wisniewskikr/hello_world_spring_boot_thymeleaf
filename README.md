Spring Boot + Thymeleaf + Spring Security + MySql + Reset password

Example application displays how reset password for Spring Security works.
This functionality starts from login page. User types his email
and gets email with confirmation link. After click on this link
he is redirected to change password page where he types new
password. After all confirmation page is displayed.

Differences vs basic:
- add UserService;
- add TokenService;
- add classes ResetEmailController and ResetChangeController;
- add class ConfirmationController;