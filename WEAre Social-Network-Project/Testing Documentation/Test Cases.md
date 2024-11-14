# WEAre Social Network Test Cases - Detailed Test Plan



## Manual Testing Scenarios
## 1. User Registration

- **Positive test**: Enter a unique username between 2 and 20 characters, a valid password, and a unique email. Ensure the user is successfully created.  
- **Negative test**: Enter a username with fewer than 2 characters or more than 20 characters – expect an error message.
- **Negative test**: Enter a password with fewer than 8 characters – expect an error message. 
- **Negative test**: Enter a password that doesn't contain an uppercase letter, a digit, or a special character – expect an error message.  
- **Negative test**: Enter an invalid email syntax (e.g., missing “@” or domain) – expect an error message.

## 2. User Login

- **Positive test**: Log in with valid credentials (email and password) – expect a successful login.  
- **Negative test**: Log in with a valid email and invalid password – expect an error message.  
- **Negative test**: Log in with a valid password and invalid email – expect an error message.

## 3. Post Creation

- **Positive test**: Create a post with valid text, photo, and ensure it appears in the news feed. Check the ability to comment and like.  
- **Negative test**: Create a post with invalid text input (e.g., empty or incorrect format) – expect an error message.  
- **Negative test**: Create a post without a photo but with valid text – verify whether the post will be accepted without a photo.  
- **Positive test**: Verify if the user can set the post to be public (visible to everyone) or only visible to connections.  
- **Positive test**: Verify if the user can change the visibility of an existing post.
- **Positive test**: Create a post with text, picture, and location simultaneously. Verify that all elements are displayed correctly in the post.
- **Negative test**: Try to upload a media file (picture, song, video) that exceeds the allowed file size limit. Expect an error message indicating the size restriction.

## 4. Anonymous Users

- **Positive test**: Verify if anonymous users can see the main menu(а public feed of posts should be available to browse.).  
- **Negative test**: Attempt to like a photo as an anonymous user – expect a restriction or redirection to the login page.  
- **Positive test**: Check if anonymous users can like comments and whether they are visible.  
- **Positive test**: Verify if anonymous users can like posts.  
- **Positive test**: Verify if anonymous users can register and log in.  
- **Positive test**: Verify if anonymous users can search for profiles and view the public feed.
- **P/N**: Anonymous users must be able to register and login??

## 5. Authorized Users

- **Positive test**: Check the main menu visibility for authorized users.  
- **Positive test**: Verify if they can like photos, comments, and posts.  
- **Positive test**: Verify if authorized users can search profiles and view the public feed.  
- **Positive test**: Verify if authorized users can view other users’ public information (name, profile picture).  
- **Positive test**: Verify if they can browse the public posts of a selected user in chronological order.  
- **Negative test**: Verify if the personalized news feed is correctly generated, based on either chronological order or interactions (likes, comments).
- **P/N**: Verify that the system only loads the latest N comments initially and does not slow down.
- **P/N**: Expand the comments in batches, ensuring the system maintains performance while loading older comments incrementally.

## 6. Search Function

- **Positive test**: Try searching for a profile by name.  
- **Positive test**: Try searching for a profile by email.  
- **Positive test**: Check what unauthorized users can see in the search results.  
- **Positive test**: Check what authorized users can see in the search results.  
- **Positive test**: Verify if search results are sorted chronologically or by another criterion.

## 7. Profile Management for Authorized Users

- **Positive test**: Verify if users can log in and log out successfully.  
- **Positive test**: Verify if users can update personal information (name, profile picture, visibility settings).  
- **Positive test**: Verify if users can change the visibility status of their photos (public or only visible to connections).  
- **Positive test**: Verify if users can change their password, email, and additional details (age, nationality).

## 8. Interactions with Other Users

- **Positive test**: Verify if users can send connection requests to others.  
- **Positive test**: Verify if users can remove a connection.  
- **Positive test**: Verify that connection requests are not automatically accepted upon sending.  
- **Positive test**: Verify that disconnections happen automatically without requiring approval from the other user.

## 9. Administrator Rights

- **Positive test**: Verify if administrators can edit and delete posts.  
- **Positive test**: Verify if administrators can edit and delete comments.  
- **Positive test/Negative**: Verify if administrators can modify users' personal information.

## 10. Optional Features

- **Negative test**: Verify if a user can log in without verifying their email after registration – expect a restriction.  
- **Positive test**: Verify if the user can upload an ID card photo and a selfie for verification, and if the platform can be used while awaiting admin approval.

---

## REST API Functionality Overview

### 1. Users

####  CRUD Operations
- **Create**, **Retrieve**, **Update**, and **Delete** operations for managing users.
- Example endpoints:
  - `POST /api/users`: Register a new user.
  - `GET /api/users/{id}`: Retrieve a user's information.
  - `PUT /api/users/{id}`: Update user information.
  - `DELETE /api/users/{id}`: Delete a user from the system.

####  Add/Approve Friend 
- Functionality to **send a friend request** and **approve friend requests**.
- Example endpoints:
  - `POST /api/users/{id}/friends`: Send a friend request to another user.
  - `PUT /api/users/{id}/friends/{friendId}/approve`: Approve a pending friend request.

####  Get News Feed 
- Fetch a user's personalized news feed, containing posts from their connections.
- Example endpoint:
  - `GET /api/users/{id}/feed`: Retrieve the latest posts from the user's connections, ordered chronologically.

---

### 2. Posts

####  CRUD Operations 
- **Create**, **Retrieve**, **Update**, and **Delete** operations for posts.
- Example endpoints:
  - `POST /api/posts`: Create a new post.
  - `GET /api/posts/{id}`: Retrieve a specific post.
  - `PUT /api/posts/{id}`: Update an existing post.
  - `DELETE /api/posts/{id}`: Delete a post.

####  Comment Posts 
- Functionality to **add comments** to posts and **retrieve** existing comments.
- Example endpoints:
  - `POST /api/posts/{id}/comments`: Add a comment to a specific post.
  - `GET /api/posts/{id}/comments`: Retrieve all comments on a post.

####  Like/Unlike Posts/Comments 
- Functionality to **like/unlike** both posts and comments.
- Example endpoints:
  - `POST /api/posts/{id}/like`: Like a post.
  - `POST /api/posts/{id}/unlike`: Unlike a post.
  - `POST /api/comments/{id}/like`: Like a comment.
  - `POST /api/comments/{id}/unlike`: Unlike a comment.

---

## Exception Handling and Propagation

To ensure that the API handles errors correctly, it is crucial to verify that exceptions are properly caught, logged, and meaningful error messages are returned to the client. This section outlines the test cases to validate exception handling and propagation across the API.

---

#### Validation Errors

- **Positive Test**:
  - Send a `POST` request to `/api/users` with missing or invalid fields (e.g., missing email or invalid password format).
  - **Expected Result**: 
    - `400 Bad Request` is returned with a detailed error message specifying which fields are invalid.
    - The response should include a message such as: 
      ```json
      {
        "error": "Invalid request",
        "details": {
          "email": "Email is required",
          "password": "Password must contain at least 8 characters"
        }
      }
      ```

---

#### Resource Not Found

- **Positive Test**:
  - Send a `GET` request to `/api/users/{id}` or `/api/posts/{id}` with a non-existent ID.
  - **Expected Result**:
    - `404 Not Found` is returned with a meaningful message such as:
      ```json
      {
        "error": "User not found"
      }
      ```

---

#### Unauthorized Access

- **Positive Test**:
  - Send a request to a protected endpoint (e.g., `/api/users/{id}`) without authentication or with invalid credentials.
  - **Expected Result**:
    - `401 Unauthorized` is returned if the user is not authenticated, with a message like:
      ```json
      {
        "error": "Authentication required"
      }
      ```

---

#### Forbidden Action

- **Positive Test**:
  - Try to perform an action (e.g., delete a user or post) without sufficient permissions.
  - **Expected Result**:
    - `403 Forbidden` is returned, indicating the user does not have the rights to perform the action:
      ```json
      {
        "error": "You do not have permission to perform this action"
      }
      ```

---

#### Internal Server Errors

- **Positive Test**:
  - Simulate an unexpected error (e.g., database connection failure) and send a request to any endpoint.
  - **Expected Result**:
    - `500 Internal Server Error` is returned, with a message explaining that an unexpected error occurred:
      ```json
      {
        "error": "An unexpected error occurred. Please try again later."
      }
      ```

---

#### Exception Logging

- **Positive Test**:
  - Cause an error in the system (e.g., invalid data or unauthorized access).
  - **Expected Result**:
    - Verify that the exception is logged in the system's error logs with the correct level of detail (stack trace, request data, and timestamp).

---

# REST Assured Testing Overview

## Users

### 1. Create User
- **Methods**: `createUser()` and `createUser2()`
- **Description**: Creates a new user with unique usernames.
- **Details**: Sends requests to predefined endpoints with JSON bodies containing user details.

### 2. Log In
- **Methods**: `logIn()` and `logInUser2()`
- **Description**: Authenticates two users by sending credentials in `application/x-www-form-urlencoded` format.
- **Details**: On success, stores session cookies (`JSESSIONID`) for maintaining user sessions.

### 3. Update User Info
- **Method**: `updateUserPersonalInfo()`
- **Description**: Updates the personal information of the user.
- **Details**: Uses the session cookie for authentication and modifies fields like `firstName`, `lastName`, `sex`, and `birthYear`.

### 4. Retrieve All Users
- **Method**: `getAllUsers()`
- **Description**: Retrieves a list of users with pagination.
- **Details**: Allows specifying pagination parameters (index and size) to control the response size.

### 5. Send Friend Request
- **Method**: `sendRequest()`
- **Description**: Sends a friend request to another user.
- **Details**: Requires the recipient's user ID.

### 6. Approve Friend Request
- **Method**: `approveRequest()`
- **Description**: Approves a pending friend request.
- **Details**: Requires the request ID.

## Posts

### 1. Create Post
- **Method**: `createPost()`
- **Description**: Uploads a public post, including an image file.
- **Details**: Uses `multipart/form-data` format and extracts the `postId` for reference in other operations.

### 2. Delete Post
- **Method**: `deletePost()`
- **Description**: Deletes an existing post by its post ID.

### 3. Comment on Post
- **Method**: `createCommentPost()`
- **Description**: Adds a comment to a specified post.
- **Details**: Uses the post ID and user ID in the JSON request body and validates fields like `commentId`.

### 4. Like a Post
- **Method**: `likePost()`
- **Description**: Allows a user to like a post.
- **Details**: Updates the post's `liked` status and confirms the like in the response.

## Comments and Likes

- **Add Comments**: Users can add comments to posts using `createCommentPost()`, verifying `commentId` and other fields for successful creation.
- **Like/Unlike**: `likePost()` toggles the like status for posts, updating the `liked` attribute and confirming the action.

## Key Assertions

Each method includes assertions to check:
- **Status Code Verification**: Ensures `200` status codes for successful operations.
- **Field Validation**: Confirms that fields like `id`, `username`, and `content` are present in the response.

## Integration with Jira Tasks

- **Jira Task Linking**: Each method starts by linking to a specific Jira task via `addIssueAndLink()`.
- **Description**: Keeps test functions aligned with corresponding Jira tickets for effective tracking.

## Summary

This setup covers:
- Basic CRUD operations
- User authentication
- Friend requests
- Post management

Each feature is aligned with a Jira task ID, and assertions ensure expected outcomes are met for each operation.
