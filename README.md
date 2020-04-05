# EmployeeService

A sample employee CRUD application using Dropwizard, MySQL and JBDI. Demonstrates using Dropwizard for

- Database migrations
- CRUD
- Packaging with Docker
- Healthchecking MySQL database
- Metrics and monitoring
- Logging
- Authentication filters

## Run the applicatoin

1. Run `mvn clean install` to build your application
1. Start application with `java -jar target/employee-service-1.0-SNAPSHOT.jar server config.yml`
1. To check that your application is running enter url `http://localhost:8080`

## Create the database

```sql
CREATE USER 'admin'@'localhost' IDENTIFIED BY 'password';
CREATE DATABASE employees;
GRANT ALL PRIVILEGES ON employees.* TO 'admin'@'localhost';
```

## Migrate the database

```
java -jar target/employee-service-1.0-SNAPSHOT.jar db migrate config.yml
```

## Healthcheck

To see your applications health enter url `http://localhost:8081/healthcheck`

