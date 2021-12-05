# SpringMVCFilmCRUD

## Overview
* This application is designed to implement search query of users input from web forms.
* These submitted forms directed to a film controller that determine what methods needed to be use for the incoming data, and redirect to web page with the modified data. 
* The data was only accessed through our DAO implementation that use prepared statements with a bind.
* This information gather from the DAO would be placed into their respective entity(ies).
* Allowing for us to then modify or send to the display pages as needed.

## Technogies Used

* Spring boot

* DAO(DAY OH) Data base Access Object

* Package management   
* Java Classes  
	 Classes for entities   
	 Class for Controller   
	 Class for DAO(DAY OH)   
* Gradle 

```java

plugins { 
		id 'org.springframework.boot' version '2.6.1'
		id 'io.spring.dependency-management' version '1.0.11.RELEASE'
		id 'java'
}
group = 'com.example'
version = '0.0.1-SNAPSHOT'
sourceCompatibility = '1.8'
repositories {
	mavenCentral()
}
dependencies {
    implementation 'javax.servlet:jstl:1.2'
    implementation 'org.apache.tomcat.embed:tomcat-embed-jasper'implementation '
    org.springframework.boot:spring-boot-starter-web'
	runtimeOnly 'mysql:mysql-connector-java'
	testImplementation 'org.springframework.boot:spring-boot-starter-test' 
test {
	useJUnitPlatform()
}
```
* HTML/CSS
	* Attributes used: min, max, required, name, class
	* types used: hidden, number, text, submit.
	* 
* MySQL
	* CRUD; Functions for reading films from data base, creating films, deleting films, and updating films already in data base.
*

## Lessons Learned
* First and foremost
	* Code is read more often then written.
	* Typos that do affect the code without effect of being caught before compile, cost a lot more time. Time is money for the company.
* Second  
	 Communication is key!  
	 This was success!


## Project Owner's
	==Ryan Majors and Jordon Paynter==