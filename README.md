# agkika
![Build Status](https://travis-ci.org/arunavnayak/agkika.svg?branch=master)](https://travis-ci.org/arunavnayak/agkika)

## What is it? 
Agkika is an enterprise grade inventory and billing manager written in Java using Spring. 
This application allows organisation to record purchase orders and when these are fulfilled, record customers orders and when these are dispatched as well as to carry out periodic stock checks to update inventory levels.
* manages inventory
* tracks costs
* supports updates to GST rates
* bill generation

## Technologies used
* Java 8
* Spring Boot, Data, Cache, MVC, Security
* Thymeleaf
* Bootstrap
* Cloud Foundry
* Database: H2(inmemory), DB2, PostgreSQL

## Installing and using it
To help getting started with Agkika, a simple project is available with maven build set-up.

Prerequisite: install maven, Java 8
#### Git
```
git clone https://github.com/arunavnayak/agkika.git
```
#### Maven
```
cd agkika
mvn clean package
```
#### Run application
```
java -jar -Dspring.profiles.active=PROD target/agkika.jar
```
It can run on following profiles: DEV|TEST|PROD



