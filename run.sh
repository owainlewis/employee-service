#!/bin/bash

mvn clean install

java -jar target/employee-service-1.0-SNAPSHOT.jar server config.yml