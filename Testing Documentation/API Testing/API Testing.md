# WEAre Social Network API Testing Documentation

## Project Overview
This document details the API testing conducted for the **WEAre Social Network** application, hosted locally at `http://localhost:8081`. The tests were performed by three contributors: Ivan Velchev, Armine Stoykova, and Gabriel Georgiev. Our primary goal was to ensure that the API endpoints functioned as expected, meeting all defined functional and non-functional requirements. Through rigorous test cases and collaborative efforts, we aimed to detect potential issues and validate the platform’s readiness for real-world use.

## Scope of API Testing
The testing focused on core functionalities such as:
- **User Management**
- **Authentication**
- **Post Management**
- **User Interactions** (e.g., like/unlike, commenting)

**Tool Used:** Postman  
**Collection File:** "WeAre"  
**Global Environments and Cookies:** Employed to simplify testing and validate sessions.

**Testing Period:** November 6, 2024 – November 10, 2024

## Initial Approach and Challenges
The testing phase was organized within a Jira sprint, facilitating task management and tracking progress. Initial tests included user creation, authentication, and post management. However, due to the lack of existing documentation on session validation, we faced a delay of three days. To resolve this, we implemented a solution using login logs and cookies, enabling us to extract cookies per user session and apply them in API requests, thereby validating user-specific actions effectively.

## Platforms and Tools Used
- **Jira:** For sprint planning and tracking
- **Postman Version:** 11.18.2
- **Desktop Platform Version:** 11.18.0 (11.18.0)

## Statistics Summary
- **Total API Tests Conducted:** 17
- **User Management Requests:** 4
- **Authentication Requests:** 2
- **Post Management Requests:** 3
- **Request Handling Requests:** 3
- **Comment Management Requests:** 1
- **Interaction (Like/Unlike) Requests:** 2
- **Deletion Requests:** 2

## Alignment with REST API Specifications
We ensured that the API testing aligned with the following requirements:
- **Users:** CRUD operations, friend requests, and news feed access.
- **Posts:** CRUD operations, comment handling, and interaction features like likes/unlikes.

## Summary of API Tests Conducted

### 1. **User Operations**
- **Total Requests:** 4
    - `[POST] Create User 1 (IAG-84)` - Validated standard user creation parameters.
    - `[POST] Create User 2 (IAG-83)` - Tested alternative data for broader validation.
    - `[GET] All Users (IAG-82)` - Checked retrieval of complete user data.
    - `[PUT] Edit User 1 (IAG-81)` - Confirmed successful update of user data.

### 2. **Login**
- **Total Requests:** 2
    - `[POST] Login User 1 (IAG-87)` - Verified login for first user.
    - `[POST] Login User 2 (IAG-86)` - Validated login for a different user.

### 3. **Post Management**
- **Total Requests:** 3
    - `[POST] Create Private Post for User 1 (IAG-89)` - Validated private post creation.
    - `[GET] All Posts (IAG-95)` - Confirmed successful retrieval of all posts.
    - `[POST] Create Public Post for User 1 (IAG-90)` - Tested creation of public posts.

### 4. **Requests**
- **Total Requests:** 3
    - `[POST] Send Request (IAG-93)` - Verified sending of connection requests.
    - `[POST] Approve Request (IAG-92)` - Tested request approval.
    - `[GET] All Requests (IAG-94)` - Confirmed retrieval of all requests.

### 5. **Comment Management**
- **Total Requests:** 1
    - `[POST] Create Comment (IAG-97)` - Tested comment creation on various posts.

### 6. **Like/Unlike Interactions**
- **Total Requests:** 2
    - `[POST] Like Post (IAG-100)` - Verified liking posts functionality.
    - `[POST] Like Comments (IAG-99)` - Tested liking comments.

### 7. **Deletion of Posts/Comments**
- **Total Requests:** 2
    - `[DELETE] Delete Comment (IAG-102)` - Validated deletion of comments.
    - `[DELETE] Delete Post (IAG-103)` - Verified post deletion.

## Testing Outcome
All tests were executed in Postman, with user sessions authenticated through cookies, ensuring accurate validation of user-specific actions. Despite minor server delays due to local hosting, repeated requests helped to ensure precision.

### Team Contribution Analysis
- **Armine Stoykova:** 40%
- **Ivan Velchev:** 40%
- **Gabriel Georgiev:** 20%

### Notable Observations
Utilizing global environments and cookie-based session validation ensured all essential API functionalities worked as intended. This robust testing phase reinforced system stability and verified adherence to project specifications.

## Conclusion
The API testing for the WEAre Social Network application successfully validated critical functions, including user management, authentication, post handling, and user interactions. Despite difficulties in finding the correct API documentation and the lack of properly defined endpoints, the team expanded their approach and found a solution for sending correct requests to the application's database. After 17 test requests, the team confirmed that the API is functioning properly but believes there is still work to be done to address the issues. Despite the successful testing, the team emphasizes that further improvements are needed, such as enhancing the documentation and ensuring proper user authentication, which will require additional work before the application is ready for real-world use

**Testing Period:** November 6, 2024 – November 10, 2024

**Links to Documentation and Postman Collection Files:** *https://github.com/A61-QA-Team-I/Social-Network-Project/tree/main/Demo-Social-Network-Project-main-3/%5BAPI%5DPOSTMAN*