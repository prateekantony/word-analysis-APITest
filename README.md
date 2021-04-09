# Word Count API Program

## Prerequisites:

- Java 8 +
- Postman API Client
- Maven

## Instructions to Download Code:

**Download, Import & Setup**

1. Download the code by clicking [Here](https://github.com/prateekantony/word-analysis-APITest/archive/refs/heads/master.zip).
2. Extract the `.ZIP` file to desired location
3. Open new projet in IDE and locate the `pom.xml` file to import the Maven project.
4. Wait for Maven project to load and indexes to be created.

## Running the Code

* Go to `src/main/java/com/restproject/service/`
* Run `WordApplicationRunner.java`
* This will start up the Spring Boot application on `localhost:8080`

## File Path to API

- Once the Spring Boot application has start up, open to Postman API Client
- Create a new collection
- Create a new `GET` request
- Insert following URL in address bar: [http://localhost:8080/api/link](http://localhost:8080/api/link)
- Add Query Params:
    - Key: `url`
    - Value: e.g. `https://prateekantony.github.io/test-file-dump/files/sample1.txt`
- Alternatively, simply enter following URL to address bar: [http://localhost:8080/api/link?url=https://prateekantony.github.io/test-file-dump/files/sample1.txt](http://localhost:8080/api/link?url=https://prateekantony.github.io/test-file-dump/files/sample1.txt)


## Application Specification

**Defining a Word**

This application takes simple rules to define words:
- A word is seperated by spaces
- Punction such as fullstop, comma, question mark, explamation mark are also considered as a delimiter to split words with. e.g:
    - `Hello.World` is 2 words
    - `Hello World` is 2 words
    - `\t Hello  World` is 2 words
    - `Hello \n World` is 2 words
    - `Hello-World` is 1 word
- Punctions and/or punctions-combinations are not counted as words.
- Symbols or symbol-combinations are accepted as words.
    - `************` is valid
    - `............` is invalid

## Author

[Prateek Antony](https://github.com/prateekantony)
