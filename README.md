SPRING-BOOT + THYMELEAF + LOMBOK

Lombok is an library which automatically implements getters, setters, constructors, toString etc.


Differences vs basic:
- add Lombok dependency in pom.xml
<!-- Lombok dependency -->
		<dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>1.16.10</version>
        </dependency>
        
- remove all getters and setters and add annotation @Data
For instance in classes InputController and OutputController 

- to connect Lombok with Eclipse IDE:
click on "lombok.jar" and select Eclipse IDE location.       