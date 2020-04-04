# EmployeeService

How to start the EmployeeService application
---

1. Run `mvn clean install` to build your application
1. Start application with `java -jar target/employee-service-1.0-SNAPSHOT.jar server config.yml`
1. To check that your application is running enter url `http://localhost:8080`

Health Check
---

## Create the database

```
mysql -u root

CREATE USER 'admin'@'localhost' IDENTIFIED BY 'password';
CREATE DATABASE employees;
GRANT ALL PRIVILEGES ON employees.* TO 'admin'@'localhost';
```


## Schema

- firstName
- lastName
- email
- title
- phone

To see your applications health enter url `http://localhost:8081/healthcheck`

Create the database

