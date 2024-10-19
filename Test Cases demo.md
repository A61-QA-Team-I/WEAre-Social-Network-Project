# Social Network Test Cases - Detailed Test Plan

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

- **API test**: Verify if a GET request to the API returns all users.  
- **API test**: Verify if an unauthenticated request can be made to the server.
