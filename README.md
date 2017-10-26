# pet

Simple scenarios to test some basic functionalities in Pet Clinic. Written in Java, Selenium and Cucumber. 

### Prerequisites

Tests can be run on Windows/Linux (I was running tests on Windows 10 and Linux Mint 18) and Chrome browser (preferably latest version of Chrome). 
Maven and Java 8 Development Kit should be installed in your system. 

### Installing/Running the tests

Current version is prepared for Windows.
To run tests on Windows go to place where pom.xml file is located and run maven command:

```
mvn clean install
```

To run tests on Linux (as root) go to /src/chromedriver_linux and make chromedriver executable:

```
chmod +x chromedriver
```

Uncomment this line from /src/test/java/steps/DriverFactory.java

```
options.addArguments("--no-sandbox");
```

and change destination of chromedriver to /src/chromedriver_linux/:

```
System.setProperty("webdriver.chrome.driver", "/src/chromedriver_linux/chromedriver");
```

Next go to folder where pom.xml file is located and write in terminal command to run tests (also as root):

```
mvn clean install
```

### Reports
To find simple cucumber generated report go to target/cucumber and open index.html in your browser.

### A word of warning
Because of the fact that tests are written for a thymeleaf-enabled version of the Spring PetClinic official sample application by SpringSource remember to restart server after each smoke run to reset app to initial state.
If you want to open project in IntelliJ remember to install Cucumber for Java plugin.

## Contact
bartekgruchacz@interia.pl
