# **Selenium IDE Test Documentation for WEAre Social Network**

## **Project Overview**

This document outlines the Selenium IDE testing conducted for the **WEAre Social Network** application, hosted locally at `http://localhost:8081`. The testing was conducted by **Ivan Velchev, Armine Stoykova**, and **Gabriel Georgiev**, focusing on validating the application's core functionalities and user interactions. The goal was to ensure adherence to functional requirements, identify UI inconsistencies, and evaluate the platform’s stability and usability under real-world scenarios.

---

## **Scope of Selenium IDE Testing**

The testing targeted critical functionalities, including:

- **Login and Authentication**
- **Post Management (Create, Edit, Delete)**
- **User Interactions (Like, Comment)**
- **Administrative Actions (Delete Post/User)**
- **UI Navigation**

---

## **Tools Used**

- **Selenium IDE**: A browser-based tool for automating web interactions and creating reusable test scripts.
- **Chrome Browser**: The environment for executing test cases.

**Test Suite File**: `WEAre_Social_Network.side`

**Testing Period**: November 24, 2024

---

## **Testing Approach and Challenges**

The team focused on validating essential workflows such as login, post creation, and comment handling. Some challenges encountered included:

- **Dynamic Element Handling**: Certain elements loaded dynamically, requiring tailored commands to ensure reliable interactions.
- **Session Management**: Testing with different user roles (e.g., admins and regular users) required precise login and logout flows.

The challenges were effectively managed to ensure seamless test execution.

---

## **Summary of Tests Conducted**

A total of **8 tests** were designed and executed to validate the core functionalities of the application:

1. **Admin Delete Post**
    - Verified admin privileges to delete posts.
2. **Anonymous Like Post**
    - Tested liking public posts as an anonymous user.
3. **Create Comment**
    - Ensured comments could be successfully added to posts.
4. **Create Post**
    - Validated the creation of both public and private posts.
5. **Edit User**
    - Confirmed user profiles could be edited successfully.
6. **Home Page**
    - Checked homepage navigation and visibility of essential elements.
7. **Like Post**
    - Verified post-liking functionality for logged-in users.
8. **Login Page**
    - Tested login, logout, and re-login functionality with multiple accounts.

---

## **Key Observations**

### **Validated Features**

- Login and authentication workflows functioned seamlessly across various user roles.
- Post management operations, such as creation, editing, and deletion, worked as intended.
- Comment addition and deletion reflected accurately in the UI.
- Admin actions, including deleting posts, were verified successfully.
- Navigation tests confirmed intuitive user experience and UI consistency.

### **Identified Issues**

- **Dynamic Element Handling**: A single instance required additional `wait` logic, which was implemented to improve reliability.
- **Error Feedback**: Certain invalid actions lacked descriptive error messages, potentially confusing users.

---

## **Testing Outcome**

The Selenium IDE tests successfully validated the application's core functionalities, ensuring compliance with the requirements. Most features worked as expected, with only minor improvements recommended.

---

## **Conclusion**

The Selenium IDE tests for the **WEAre Social Network** application successfully validated key functionalities and user interactions, ensuring the platform’s readiness for end-user operations. While the majority of features were stable and met the requirements, a few minor issues (e.g., dynamic element delays, insufficient error feedback) were identified and logged for future improvement.

---

**Testing Period:** November 24, 2024

**Links to Documentation and Postman Collection Files:** [Jira Link](https://a61-qa-team-1.atlassian.net/jira/software/c/projects/IAG/list?selectedIssue=IAG-132)