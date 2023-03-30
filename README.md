# Small World Assessment

--

## Tools and Libraries
This project using 2 main tools, Selenium and Cucumber.
On the other hand, I using some of the tools that support this great framework.
The complete list of tools, you can see in the `pom.xml` file.

## Requirements
* Java Development Kit (Java Version 11.0.15.1)
* Maven (Version 3.8.6)
* WebDriver

## Running Tests
* Clone the repository
* Open the project using any Java IDE
* Run the tests with the script below
* 
```shell
$ mvn clean install
```
* For Running All Tests
```shell
$ mvn clean install -Dcucumber.filter.tags="@Regression"
```
* For Running Login Tests
```shell
$ mvn clean install -Dcucumber.filter.tags="@Login"
```

* For Running Logout Tests
```shell
$ mvn clean install -Dcucumber.filter.tags="@Logout"
```

* For Running Cart & Checout Tests
```shell
$ mvn clean install -Dcucumber.filter.tags="@Cart&Checkout"
```

## Test Results
* Test report automatically generated on `target` folder after finished the test execution
* Open overview-features.html file on your browser from target/cucumber-reports/advanced-reports/cucumber-html-reports folder
* You can also share your Cucumber Report with another person at https://reports.cucumber.io, just go to `cucumber.properties` file in `src/test/resources` folder then change the value to be `true`

```properties file
* To set browser name, url and timeout, set values into the /config/configuration.properties
```

