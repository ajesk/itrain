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

**Dynamic binding is being utilized in this project in some cases for Guice for ease of use as well as to enforce certain rules to properly utilize the framework as it was intended. Please refer to specific Module classes in each instance to identify the individual rules.**

**Please note that not all of the functionality has been added to the user controller this will be added shortly.**

## Usage
```
git clone https://github.com/ajesk/spark-starter.git
cd spark-starter
gradle run
```

The default port that Spark runs on is 4567 so you can use Postman to send API calls to localhost:4567/* using this tool.

## Structure
This project contains a number of individual modules which encapsulates differing functionality of the spark-starter. They were constructed with testing in mind. This way it is possible to logically implement your required test cases on each level of the application. The varying nodes are as follows:

#### Server
This piece is the crux of the application. All of the functionality of Spark itself is handled within this part. There are technically two sub-functions that occur within this package.

* Routes - these are where the API calls are passed to through spark. These should only be handling parsing the body of any request (when applicable) and building out the response to be returned to the front end application. This should be treated just as a pass through to the controllers that handle the actual function of the call. NO BUSINESS LOGIC SHOULD OCCUR HERE.

**Guice Note:** Dynamic binding is being used for the routes package so there is no need to worry about binding additional Route extended classes that you make.
* Handlers - these classes are the objectified representation of the API for your restful services. You can easily build another API call by adding just one line to the HandlerProvider class which can call a method from the Routes package (You will also have to create the injection if you use another Route class).

#### Control
This is where all of your business logic should go. You can create additional controllers here by modeling you classes in the same fashion as the user implementation (UserControl interface and UserControlImpl actual functionality). All calls to classes here should come from the routes package from within the Server module.

**Guice Note:** Dynamic binding is being used here. There is a strict rule in this instance. The binder method is specifically looking for the characters "Impl" in the name of your controller.

#### Models/Util/DB
These three modules are specifically based upon the application being built. Currently the db package contains nothing, the model package has only the User model, and io.acode.spark_starter.util package has just a Json parser (which uses Gson). Whatever else is put in these packages is entirely up to the developer or project constraints. **Guice Note:** Dynamic binding is being used for the Util module. This is entirely for ease of use, but if a continual problem occurs regarding this it is possible that this can and will be changed. Also note that there is no Guice Module defined within db. You will have to build this yourself to implement it.
