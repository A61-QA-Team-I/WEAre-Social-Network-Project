# Test Plan for Social Network Application


## Overview

This test plan is created to test the social network application, with three main objectives:

1. **Manual testing** of core functionalities such as user registration, login, post creation, comments, and user interactions.
2. **API testing** using **Postman** to validate the backend services.
3. **Automated testing** using **Selenium WebDriver and Java** to streamline repeatable tests of the user interface.

---

## Scope of Testing

The tests will cover the following key functionalities:

- **Manual Testing**: User registration, login, post creation, likes, comments, profile management, and user interactions.
- **API Testing**: CRUD operations (create, read, update, delete) for users and posts using **Postman**.
- **Automation**: Core scenarios such as registration, login, and post creation using **Selenium WebDriver and Java**.
- **Cross-browser Testing**: Testing on **Google Chrome**, **Mozilla Firefox**, and **Safari**.
- **Cross-platform Testing**: Testing on **macOS** and **Windows**.
- **Performance Testing**: Load testing to ensure system performance under high traffic.


What will NOT be tested:

- **Third-party integrations**: The plan will not cover performance testing of external APIs or services integrated with the application.
- **Detailed UI/UX design validation**: Pixel-perfect UI comparisons or deep aesthetic checks for design consistency will not be performed.
- **Performance on unsupported browsers or devices**: The application will not be tested on browsers or devices outside of Chrome, Firefox, Safari, macOS, and Windows.

---

## Objectives of Testing

1. Ensure stability and proper functionality of the application across all supported browsers and operating systems.
2. Validate that **APIs** and the user interface work correctly and return expected results.
3. **Automation** will help to speed up and enhance the efficiency of testing core functionalities.
4. **Manual Testing** will cover detailed checks of functionalities that are difficult to automate.

---

## Testing Strategy

1. **Manual Testing** of key functionalities: user registration, login, post creation, comments, likes, and user interactions.
2. **API Testing with Postman** to validate backend requests and responses.
3. **Automation with Selenium WebDriver** to test key scenarios such as registration, login, and post creation.
4. **Cross-browser Testing** to ensure compatibility across all supported browsers.
5. **Performance Testing** to verify system stability under heavy load.

---

## Entry Criteria

- All test environments should be fully set up and accessible.
- All test data for the different test scenarios should be available and validated.
- All necessary tools (Postman, Selenium, browsers, etc.) should be installed and configured.
- Test cases should be reviewed and approved by the team.

---

## Exit Criteria

- All planned test cases have been executed.
- All critical and high-severity defects have been resolved and verified.
- No open critical defects exist.
- Test coverage has reached at least 90% for all core functionalities.
- Automation scripts should pass without major failures.
- Performance tests should demonstrate stable behavior under the expected load.

---

## Roles and Responsibilities

The testing team consists of **Ivan Velchev**, **Armine Stoykova** and **Gabriel Georgiev**. All three testers will have equal responsibilities and will share the tasks equally. The division of work will be as follows:

- **Manual Testing**: All three testers will divide manual testing tasks equally, ensuring all core functionalities are covered, including registration, login, post creation, comments, and profile management.
- **API Testing**: Each tester will take a portion of the API testing using **Postman** and ensure all CRUD operations for users and posts are covered.
- **Automation**: The automation work will be divided among the three testers, where each tester will automate different parts of the test scenarios (e.g., registration, login, post creation) using **Selenium WebDriver and Java**.
- **Cross-browser Testing**: Each tester will test across different browsers to ensure coverage on **Google Chrome**, **Mozilla Firefox**, and **Safari**.
- **Test Management**: All testers will be responsible for reporting bugs and updating the progress in **Jira/Trello**.

---

## Test Scenarios

### 1. User Registration (Manual Testing)

-  Enter a unique username between 2 and 20 characters, a valid password, and a unique email. Ensure the user is successfully created.
-  Enter a username with fewer than 2 characters or more than 20 characters – expect an error message.
-  Enter a password with fewer than 8 characters – expect an error message.
-  Enter a password that doesn't contain an uppercase letter, a digit, or a special character – expect an error message.
-  Enter an invalid email – expect an error message.

### 2. User Login (Manual Testing)

-  Log in with valid credentials (email and password) – expect a successful login.
-  Log in with a valid email and invalid password – expect an error message.
-  Log in with a valid password and invalid email – expect an error message.

### 3. Post Creation (Manual Testing)

-  Create a post with valid text and photo, and ensure it appears in the news feed. Check the ability to comment and like.
-  Create a post with invalid text input (e.g., empty or incorrect format) – expect an error message.
-  Create a post without a photo but with valid text – verify whether the post will be accepted without a photo.
-  Verify if the user can set the post to be public (visible to everyone) or only visible to connections.
-  Verify if the user can change the visibility of an existing post.
-  Create a post with text, picture, and location simultaneously. Verify that all elements are displayed correctly in the post.
-  Try to upload a media file (picture, song, video) that exceeds the allowed file size limit. Expect an error message indicating the size restriction.

### 4. Anonymous Users (Manual Testing)

-  Verify if anonymous users can see the main menu (a public feed of posts should be available to browse).
-  Attempt to like a photo as an anonymous user – expect a restriction or redirection to the login page.
-  Check if anonymous users can like comments and whether they are visible.
-  Verify if anonymous users can like posts.
-  Verify if anonymous users can register and log in.
-  Verify if anonymous users can search for profiles and view the public feed.
-  Verify if anonymous users must be able to register and log in.

### 5. Authorized Users (Manual Testing)

-  Check the main menu visibility for authorized users.
-  Verify if they can like photos, comments, and posts.
-  Verify if authorized users can search profiles and view the public feed.
-  Verify if authorized users can view other users’ public information (name, profile picture).
-  Verify if they can browse the public posts of a selected user in chronological order.
-  Verify if the personalized news feed is correctly generated, based on either chronological order or interactions (likes, comments).
-  Verify that the system only loads the latest N comments initially and does not slow down.
-  Expand the comments in batches, ensuring the system maintains performance while loading older comments incrementally.

### 6. Search Function (Manual Testing)

-  Try searching for a profile by name.
-  Try searching for a profile by email.
-  Check what unauthorized users can see in the search results.
-  Check what authorized users can see in the search results.
-  Verify if search results are sorted chronologically or by another criterion.

### 7. Profile Management for Authorized Users (Manual Testing)

-  Verify if users can log in and log out successfully.
-  Verify if users can update personal information (name, profile picture, visibility settings).
-  Verify if users can change the visibility status of their photos (public or only visible to connections).
-  Verify if users can change their password, email, and additional details (age, nationality).

### 8. Interactions with Other Users (Manual Testing)

-  Verify if users can send connection requests to others.
-  Verify if users can remove a connection.
-  Verify that connection requests are not automatically accepted upon sending.
-  Verify that disconnections happen automatically without requiring approval from the other user.

### 9. Administrator Rights (Manual Testing)

-  Verify if administrators can edit and delete posts.
-  Verify if administrators can edit and delete comments.
-  Verify if administrators can modify users' personal information.

### 10. Optional Features (Manual Testing)

-  Verify if a user can log in without verifying their email after registration – expect a restriction.
-  Verify if the user can upload an ID card photo and a selfie for verification, and if the platform can be used while awaiting admin approval.

---

## REST API Functionality Overview

## 1. Users

### · CRUD Operations 
- **Create**, **Retrieve**, **Update**, and **Delete** operations for managing users.
- Example endpoints:
  - `POST`: Register a new user.!!
  - `GET`: Retrieve a user's informatio.!!
  - `PUT`: Update user information!!
  - `DELETE}`: Delete a user from the system.!!

### · Add/Approve Friend 
- Functionality to **send a friend request** and **approve friend requests**.
- Example endpoints:
  - `POST `: Send a friend request to another user.!!
  - `PUT `: Approve a pending friend request.!!

### · Get News Feed 
- Fetch a user's personalized news feed, containing posts from their connections.!!
- Example endpoint:
  - `GET`: Retrieve the latest posts from the user's connections, ordered chronologically.!!

---

## 2. Posts

### · CRUD Operations  
- **Create**, **Retrieve**, **Update**, and **Delete** operations for posts.
- Example endpoints:
  - `POST`: Create a new post.!!
  - `GET`: Retrieve a specific post.!!
  - `PUT`: Update an existing post.!!
  - `DELETE`: Delete a post.!!

### · Comment Posts 
- Functionality to **add comments** to posts and **retrieve** existing comments.
- Example endpoints:
  - `POST`: Add a comment to a specific post.
  - `GET `: Retrieve all comments on a post.

### · Like/Unlike Posts/Comments 
- Functionality to **like/unlike** both posts and comments.
- Example endpoints:
  - `POST`: Like a post.!!
  - `POST`: Unlike a post.!!
  - `POST`: Like a comment.!!
  - `POST`: Unlike a comment.!!

---

## Test Schedule

| Task                     | Start Date      | End Date        | Responsible       |
|--------------------------|-----------------|-----------------|-------------------|
| Environment Setup        | October 18      | October 25      | All Testers       |
| Manual Testing (Postman) | October 18      | October 27      | All Testers       |
| Automation (Selenium)    | October 28      | November 15     | All Testers       |

---

## Tools and Technologies

- **Postman**: For API testing.
- **Selenium WebDriver with Java**: For automating user interface tests.
- **JMeter**: For performance and load testing.
- **Jira/Trello**: For bug tracking and task management.

---

## Success Criteria

1. All key functionalities must pass tests on all supported browsers and platforms.
2. No critical bugs or issues should impede the main functionality of the application.
3. **API tests** must validate correct responses and status codes (200, 201, 400, 401, etc.).
4. **Automated tests** must execute without errors and cover key scenarios (registration, login, post creation).
5. The system should perform stably under heavy load.
