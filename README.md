# spark-starter

## Requirements
* Gradle
* Java 1.8
* Postman (Optional)(Will implement swagger eventually)

## Notable Dependencies
* Spark
* Guice
* Lombok
* Slf4j

## Purpose
This application was created to be a jumping off point for small scale API. It was made using spark and a simple Guice structure to construct a simple implementation of a CRUD application. Currently it has only one Control and Model class for users which is stored in memory for the time being, but it is simple to alter the application to add database support to the db package contained within.

** Please note that not all of the functionality has been added to the user controller this will be added shortly **

## Usage
```
git clone https://github.com/ajesk/spark-starter.git
cd spark-starter
gradle run
```

The default port that Spark runs on is 4567 so you can use Postman to send API calls to localhost:4567/* using this tool.
