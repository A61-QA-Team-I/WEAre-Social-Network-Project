# Documentation for Automation Testing WEAre Selenium WebDriver

### **Overview**

The **WEAre social network platform**, hosted at [**http://localhost:8081**](http://localhost:8081/), underwent extensive automation testing to ensure its core functionalities operate as expected and meet defined requirements. The automation process was conducted from **November 13, 2024, to November 23, 2024**, focusing on validating critical workflows, identifying areas for improvement, and ensuring a robust testing foundation for future enhancements.

Our team implemented a **custom Selenium WebDriver framework** that follows the **Page Object Model (POM)** design pattern. This approach enabled modularity, reusability, and ease of maintenance for automated tests. With the use of **TestNG** for test execution and reporting, and **Maven** for dependency management, we ensured the testing process was efficient and well-structured.

The automation covered a wide range of scenarios, including requirements-based tests and failure-to-meet-requirements tests. These tests were meticulously selected based on equivalence partitioning and platform requirements to simulate real-world use cases and edge cases. While the automated tests validate a significant portion of the platform's functionality, several failures were observed due to validation issues in the application, highlighting areas that require immediate attention.

Despite the identified challenges, the automation framework demonstrates a high degree of flexibility and scalability. Once the current issues are resolved, it will be straightforward to extend the test suite for future features and enhancements.

---

### **Team Members**

- **Armine Stoykova**
- **Ivan Velchev**
- **Gabriel Georgiev**

---

### **Scope**

The automation testing of the **WEAre social network platform** focused on the following areas:

- **Validation of Functional Requirements:** Ensuring core features such as user registration, login, post creation, and account management operate as expected.
- **Failure Scenarios Testing:** Identifying gaps in input validation for passwords, usernames, and email duplication.
- **Scenarios Coverage:** Testing critical workflows and edge cases selected based on platform requirements and equivalence partitioning.
- **Reusability of Page Classes:** Developing modular and reusable page classes to streamline testing for current and future scenarios.

The scope aimed to achieve 100% coverage of selected scenarios, ensuring the platform's readiness for real-world usage while identifying areas for improvement.

---

### **Initial Approach and Challenges**

### **Initial Approach:**

The testing process was structured to maximize efficiency and provide clear traceability. We started by:

1. Designing the test scenarios based on platform requirements and equivalence partitioning techniques.
2. Implementing reusable page classes using the Page Object Model (POM) for modularity.
3. Structuring the tests into two categories:
    - **Requirements-Based Tests:** Validating expected functionality.
    - **Failure-to-Meet-Requirements Tests:** Highlighting gaps in validation and input handling.

### **Challenges:**

- **Validation Gaps:** The platform lacked proper validation for passwords, usernames, and duplicate emails, leading to test failures in equivalence partitioning scenarios.
- **Edge Cases:** Handling of string lengths and unsupported characters in inputs was incomplete, causing tests to fail.
- **Localhost Stability:** The localhost environment occasionally exhibited slow responses, which required retries to ensure consistent test results.
- **Scenario Failures:** Tests related to edge cases (e.g., long usernames, invalid passwords) failed due to platform-level issues.

---

### **Technologies and Approach**

1. **Framework:**
    - We developed a custom **test automation framework** based on **Page Object Model (POM)** to ensure separation of concerns and reusability of components.
2. **Tools and Dependencies:**
    - **Selenium WebDriver:** For browser automation.
    - **Maven:** For dependency management and build lifecycle.
    - **TestNG:** For test execution and generating detailed reports.
3. **Testing Methodology:**
    - The scenarios were designed using **equivalence partitioning** and **requirements-based testing** to ensure comprehensive coverage of functionality.
    - Additional tests were created to validate **failure scenarios**, focusing on edge cases such as invalid input handling.

---

### **Tests Automated**

### **1. Requirements-Based Tests (12 Tests):**

These tests ensure the core functionality of the platform operates as expected:

1. **WEAreAdminDeletePostTest**
2. **WEAreAdminDisableAccountTest**
3. **WEAreAnonymousLikePostTest**
4. **WEAreApproveRequestTest**
5. **WEAreCreateCommentTest**
6. **WEAreCreatePostTest**
7. **WEAreCreateUserTest**
8. **WEAreEditUserTest**
9. **WEAreHomePageTest**
10. **WEAreLikePostTest**
11. **WEAreLoginTest**
12. **WEAreSendRequestTest**

### **2. Failure-to-Meet-Requirements Tests (2 Tests):**

These tests verify that the platform appropriately handles scenarios where input does not meet requirements. They also highlight areas of improvement for validation handling:

1. `WEAreCreateUserTest`
2. `WEAreSearchingUserTest`

---

### **Pages Created**

The following **9 page classes** were developed and reused across tests to ensure modularity:

1. `LoginWEArePage`
2. `RegisterWEArePage`
3. `CreatePostPage`
4. `EditUserWEArePage`
5. `DeletePostPage`
6. `LikePostWEArePage`
7. `HomeWEArePage`
8. `AdministrationPage`
9. `RequestWEArePage`

---

### **Statistics**

### **Automated Tests:**

- **Total Tests:** **14**
    - Requirements-Based Tests: **12**
    - Failure-to-Meet-Requirements Tests: 2

### **Pages Created:**

- **Total Pages:** **9**

### **Coverage:**

- **100% Automation Coverage** for selected scenarios.

---

### **Challenges**

1. **Validation Issues:**
    - Password validation issues caused failures in scenarios with invalid input (e.g., short passwords, unsupported characters).
    - Equivalence partitioning tests fail due to improper handling of string lengths and validation rules.
2. **Scenario Failures:**
    - Failure-to-meet-requirements tests fail due to platform limitations (e.g., duplicate email not flagged, long usernames allowed).
3. **Platform Readiness:**
    - The platform is not production-ready as these failures indicate that critical functionality is incomplete.

---

### **Assessment and Recommendations**

1. **Current State:**
    - The system has significant validation gaps. Until these are addressed, the application is **not ready for production deployment**.
2. **Future Steps:**
    - Resolve issues with password validation, email duplication, and input string length validation.
    - Retest all failing scenarios after fixes are implemented.
3. **Scenarios Selection:**
    - Scenarios were carefully selected based on the platform's requirements and critical workflows.

---

### **Conclusion**

The automation process effectively validated the majority of the platform's functionalities through a structured approach combining **requirements-based testing** and **failure-to-meet-requirements testing**. Our custom-built framework, designed with **Page Object Model (POM)** principles, proved to be robust, scalable, and reusable, allowing seamless execution of diverse test scenarios.

However, during the process, several **critical gaps** were identified in the platform's validation mechanisms, particularly around password rules, duplicate email handling, and input constraints. These issues caused certain equivalence partitioning tests to fail, highlighting the need for immediate attention to improve input validation and error handling.

As a team, we made significant strides by:

- Automating 100% of the selected scenarios.
- Covering both **positive and negative** workflows to simulate real-world use cases.
- Identifying critical edge cases that are currently not handled by the platform.

While the test scenarios and the automation framework are well-structured and comprehensive, our assessment is that the **WEAre social network platform is not yet production-ready**. For the platform to move closer to readiness, the following steps are crucial:

1. Resolve the identified issues with password validation, duplicate email detection, and input length constraints.
2. Revisit and improve error messaging and feedback mechanisms for invalid inputs to ensure a seamless user experience.
3. Perform a **retest of all failed scenarios** once fixes are implemented.

As a team, we firmly believe that the platform has the potential to meet production standards after addressing these challenges. With our automation framework in place, any future updates or fixes can be validated efficiently and with minimal effort. This framework also lays a strong foundation for scaling test coverage as the platform evolves with additional features.

In conclusion, while the platform currently requires additional development effort, our automation efforts have established a clear roadmap for achieving a stable, production-ready system. The insights gained during this testing phase will serve as a valuable guide for future development and quality assurance.