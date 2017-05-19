Example application with usage Spring Boot and Thymeleaf with properties file.

Steps:
- add properties file: \src\main\resources\props\input.properties and \src\main\resources\props\output.properties
- create configuration class WebConfig and define then messageSource
- in templates use properties from files. For instance: #{input.text}