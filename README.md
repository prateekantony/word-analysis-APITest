# Word Count API Program

## Prerequisites:

- Java 8 +
- Postman API Client or Google Chrome
- Maven
- IntelliJ or IDE of choice

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

- Once the Spring Boot application has start up, open Postman API Client
- Create a new collection
- Create a new `GET` request
- Insert following URL in address bar: [http://localhost:8080/api/link](http://localhost:8080/api/link)
- Add Query Params:
    - Key: `url`
    - Value: e.g. `https://prateekantony.github.io/test-file-dump/files/sample1.txt`
- Alternatively, enter following URL to address bar or in the browser directly : [http://localhost:8080/api/link?url=https://prateekantony.github.io/test-file-dump/files/sample1.txt](http://localhost:8080/api/link?url=https://prateekantony.github.io/test-file-dump/files/sample1.txt)
- You can change the url value to any valid `.TXT` url
- To get file from local machine, enter path of file as the url value:
    -  e.g. http://localhost:8080/api/link?url=file:///C:/path/to/txt/file.txt

### Note:
- **The browser may display the API without formatting on a signle line. Postman will display this line by line.**
- **To test different .TXT files, a sample file dump location was created containing a selecting of test .TXT files:**
    - **[https://prateekantony.github.io/test-file-dump/](https://prateekantony.github.io/test-file-dump/)**

## Application Specification

**Defining a Word**

This application takes simple rules to define words:
- A word is seperated by spaces
- Punction such as fullstop, comma, question mark, explamation mark are also considered as a delimiter to split words with. e.g:
    - `Hello.World` is 2 words
    - `Hello World` is 2 words
    - `\t Hello  World` is 2 words
    - `Hello \n World` is 2 words
    - `Hello\nWorld` is 2 words
    - `Hello-World` is 1 word
- Punctions and/or punctions-combinations are not counted as words.
- Symbols or symbol-combinations are accepted as words.
    - `************` is valid
    - `............` is invalid

## Unit Testing

All unit tests Java files can be found at: `src/test/java/com/restproject/service/`
- `.../analyser/WordAnalyserTest.java` - Unit tests for the individual methods like word count, url content, average word length count
- `.../controller/ControllerTest.java` - Tests the API Response

## Author

Prateek Antony