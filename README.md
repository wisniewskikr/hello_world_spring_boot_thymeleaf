Spring Boot + Thymeleaf + Automated Tests Selenium

Example application displays how work automated tests Selenium. To run them 
following Maven console should be used:
mvn clean install

Application is stared automatically.

Prerequisites:
- FF in verson 46 installed in location: C:\\java\\FF\\firefox.exe
- it can be downloaded from: https://ftp.mozilla.org/pub/firefox/releases/46.0/win64/en-GB/

Differences vs basic:
- selenium dependency in POM
- class InputControllerTest