# Java/Selenium Example Project
Test site content with DB data comparing + test API response example

## Prerequisites
* **JDK >= 1.8.0_131**;
* **Apache Maven >= 3.3.9**

## Installation
Install dependencies: 
```
mvn install
```

## Run 
Run script for test execution:
```
mvn test
```

## Structure
* /src/main/java/database - DB utils
* /src/main/java/model - models for describing DB tables
* /src/main/java/pages - described pages according to page-object pattern

* /src/test/java - test classes itself, respectively **UITest.java**, **APITest.java**