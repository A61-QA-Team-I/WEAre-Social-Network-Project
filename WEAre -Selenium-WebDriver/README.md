=============== SELENIUM TEST SUITE ===============
=

1. **Navigate to the Repository**:
   This repository contains the Selenium WebDriver framework and test cases for the WEAre Social Network Project.

2. **Test Setup**:
   - **Dockerized Environment**:
     Tests require Docker containers to be running. Ensure `docker-compose` is available on your machine.
   - **Test Independence**:
     All tests are designed to be independent but can also run as part of a suite.

3. **Test Execution**:

   **To Run All Tests in a Suite using CMD or Terminal**:
   - Use the following Maven command:
     ```
     mvn clean test
     ```

   **To Run a Specific Test Class**:
   - Use the `-Dtest` option to specify the test class name:
     ```
     mvn clean test -Dtest=NameOfTestClass
     ```

     Example:
     ```
     mvn clean test -Dtest=WEAreApproveRequestTest
     ```

   **To Run a Specific Test Method**:
   - Append `#methodName` to the class name:
     ```
     mvn clean test -Dtest=NameOfTestClass#methodName
     ```

     Example:
     ```
     mvn clean test -Dtest=WEAreCreateCommentTest#createComment
     ```

4. **Test Reports**:
   - **Allure Reports** are generated automatically after each test run.
   - Open the generated reports locally using:
     ```
     allure serve target/allure-results
     ```

============= JENKINS SETUP GUIDE ================
=

1. **Jenkins Instance**:
   - Hosted via **ngrok**:
     ```
     https://jenkinssetup.ngrok.app
     ```

2. **Configured Jenkins Jobs**:

   **On-Demand Test Execution**:
   - Triggered manually to run the test suite on demand.

   **Nightly Test Execution**:
   - Scheduled to execute tests every night at midnight.
   - Cron expression: `H 0 * * *`.

3. **Batch Command Workflow Summary**:
   - The batch script used in both Jenkins jobs performs the following steps:
     1. Navigates to the Docker setup directory and starts the required containers.
     2. Waits for 5 seconds to ensure containers are running.
     3. Navigates to the Maven project directory to clean up previous Allure results.
     4. Executes the test suite using Maven.
     5. Generates and serves the Allure report locally for detailed test results.
     6. Returns to the Docker setup directory to shut down the containers.

4. **Jenkins Features**:
   - Both jobs bring up Docker containers, run the test suite, generate Allure reports, and shut down the containers after execution.
   - The **Allure Report** is served locally after test execution and can be easily accessed through the **Allure Report** inside the executed job

================= END OF README ================
=

