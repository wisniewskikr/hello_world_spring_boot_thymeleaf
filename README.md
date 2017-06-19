Spring Boot + Thymeleaf + Upload csv file

Example application displays how upload text file works

Differences vs basic:
- add in template enctype="multipart/form-data";
- add in command MultipartFile;
- add dependency "opencsv" in POM file;
- add CsvService class.