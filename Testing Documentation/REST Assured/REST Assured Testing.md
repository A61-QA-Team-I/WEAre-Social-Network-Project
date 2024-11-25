# WEAre Social Network REST API Report

## **Overview**

The WEAre Social Network application offers a comprehensive REST API that powers essential social networking functionalities, including user management, post creation, commenting, and friend requests. This API enables seamless interactions between users and supports a dynamic social environment with public and private sharing options. Built with scalability and extensibility in mind, the API serves as the backbone for all user activities and content generation within the platform. This document outlines the primary API endpoints, the testing framework, and the data management approach implemented to ensure robust testing, reliability, and accuracy across all functional areas. With a focus on automation and test coverage, this documentation also highlights the tools and strategies used to validate and maintain high-quality performance for the WEAre Social Network API.

**Contributors**:

- *Ivan Velchev*
- *Armine Stoykova*
- *Gabriel Georgiev*

**Application**: **WEAre Social Network**

**Hosting**: The application is hosted locally at [http://localhost:8081](http://localhost:8081/)

---

### **Technologies Used**

The project utilizes a range of tools and libraries to create a robust testing and automation framework:

- **Java**: The main programming language used for test automation.
- **TestNG**: A testing framework used to organize and run test cases with extensive annotation support for test management.
- **REST Assured**: A library for REST API testing, used to send HTTP requests and verify responses.
- **Allure**: A reporting tool for generating detailed and visual test reports, with integration for linking tests to Jira tasks for traceability.
- **Jsoup**: An HTML parsing library used to extract specific elements from HTML responses.
- **Hamcrest**: A flexible library for assertions, allowing readable and maintainable validation of response data.
- **Jira Integration**: Integration with Jira for traceable test documentation and issue management.
- **Java Faker**: A library for generating random and unique test data, supporting data independence and reducing test conflicts.
- **Docker Desktop**: Used for containerized environments to simulate production-like instances.
- **Maven**: Build automation tool that manages dependencies and project configurations.
- **MariaDB**: Database management system used for data persistence.
- **Swagger**: Used for API documentation to provide a clear and interactive API overview.

---

### **Key Project Modules**

### **1. Base Setup**

- *BaseSetup*: A foundational class that configures common test settings and provides helper methods for API actions. This includes methods for user creation, login, updating personal information, and managing posts and comments.

### **2. Test Data Management**

- **TestData Class**: Centralized data storage for test sessions, including usernames, session IDs, and identifiers (user IDs, post IDs, comment IDs). This class ensures each test has unique data to avoid conflicts.
- **UniqueNameGenerator**: Utilizes `Java Faker` to generate unique names for each test session. The generator tracks used names to prevent duplicates, which ensures data independence and allows tests to run concurrently without conflicts.

### **3. Test Classes**

- *CreateComment*: Tests related to comment creation on posts.
- *CreatePost*: Tests for creating posts, supporting file uploads for images.
- *CreateUsers*: Tests for user creation functionality.
- *FriendRequest*: Tests managing friend requests, including sending and approving them.
- *LikePost*: Tests the functionality of liking posts.

### **4. Resources**

- *main-suite.xml*: TestNG suite configuration file, specifying the tests to run and managing their execution order.
- A link to the GitHub repository for the REST API.

## **Test Reporting with Allure**

Allure is used to produce detailed test reports, providing insights into test results with features such as:

- **Jira Issue Links**: Each test is linked to its corresponding Jira task, enhancing traceability and documentation within the reporting.
- **Severity and Feature Annotations**: Tests are annotated with `@Severity(SeverityLevel.CRITICAL)` and `@Feature("User Management")` for better categorization and to highlight critical test cases in the reports.

---

## **Assertions and Validation**

The project leverages **Hamcrest** for flexible and readable assertions, ensuring that the REST API responses meet expected outcomes at every level. Key assertions in the testing framework include:

- **Status Code Verification**: Validates that each API call responds with the correct HTTP status code, such as `200 OK` for successful operations or `404 Not Found` for invalid requests. This ensures that the API behaves as expected in various scenarios.
- **Content Validation**: Confirms that the response body contains essential data, such as specific usernames, post titles, or other expected strings. This type of validation helps verify that critical data is correctly returned from the server and matches the test requirements.
- **Data Type Verification**: Ensures that JSON response fields contain the correct data types (e.g., integers for IDs, strings for usernames). This level of validation checks data consistency across the API, helping to maintain data integrity and reliability in responses.

These assertions collectively help ensure that the API consistently delivers the correct data with the expected structure and behavior, providing confidence in the application's reliability and robustness. The use of **Hamcrest** allows for readable assertions that make the test outcomes clear and understandable, contributing to efficient debugging and reporting.

---

## **Post-Execution Test Report and Assessment**

This document captures the comprehensive testing structure, tools, and strategies utilized for validating the WEAre Social Network REST API. By leveraging **TestNG**, **REST Assured**, and **Allure**, our framework achieves a robust, independent, and traceable testing process. Through unique data generation, detailed reporting, and integrated issue tracking, this framework has proven effective for exhaustive REST API testing and automation.

**Team Assessment:**

Following the execution of all test cases, we are pleased to report that **all 31 test cases passed successfully**, both in **HTML** and **JSON** formats. Our framework captures and stores all selected dependencies and unique identifiers for entities like user IDs, post IDs, and comment IDs, ensuring traceability throughout the testing process.

The database integration performed as expected:

- **Data Consistency**: All keys and dependencies, including IDs for posts, comments, and users, were correctly stored and retrieved.
- **Reliability**: The database operated efficiently, with accurate response times and no failures, ensuring data integrity.
- **Key Validation**: Database keys match the expected structure, ensuring that the data integrity and referential integrity constraints are properly upheld.

 ## **Conclusion**: 
The team assessment for the WEAre Social Network REST API testing highlights the successful execution of all 31 test cases, including accurate database integration and reliable response times. The testing framework, utilizing TestNG, REST Assured, and Allure, provided comprehensive coverage, traceability of tests, and validated performance. However, the team notes that some functional issues remain unresolved, and additional work is required to correct the documentation and improve user authentication before the application can be considered ready for real-world use.


