package com.backendapps.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//TODO - Add swagger, Add Loggers (AOP), Check and log Hikari Pool properties
//TODO - Check start up logs for LiveReloadServer and see if ORM runs DDL each time server starts
//TODO - Dockerize this app and use sqlite3 instead of H2. Containerize sqlite3 db too.

//Other Questions
/*  - How does the local server create and interact with in mem H2 db?
	- what are spring dev-tools?
*/


@SpringBootApplication
public class StudentManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementApplication.class, args);
	}

}
