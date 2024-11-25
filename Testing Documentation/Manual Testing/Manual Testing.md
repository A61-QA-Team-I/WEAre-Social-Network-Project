# Manual Testing Documentation

## Project Overview

The **WEare social network** platform was thoroughly tested manually at [http://localhost:8081](http://localhost:8081). The primary objective was to ensure the platform's core functionalities operate seamlessly, identify any bugs or usability issues, and uncover missing or incomplete features. This comprehensive assessment aimed to verify compliance with the specified requirements, enhance the platform’s overall quality, and ensure a smooth user experience. Additionally, the testing process provided valuable insights into areas requiring further improvement, paving the way for future development and optimization.

### Team Members
- **Armine Stoykova**
- **Ivan Velchev**
- **Gabriel Georgiev**

---

## Scope

The manual testing process was designed to validate the following aspects of the platform:

- **Core Functional Requirements:** Ensuring seamless operation of public, private, and administrative features.
- **Key User Interactions:** Verifying critical workflows such as user registration, login, post creation, and profile management for accuracy and usability.
- **Bug Detection and Feature Gaps:** Identifying issues and missing functionalities that could impact user experience, system performance, or compliance with requirements.

### Tool Used

- **Jira:** A powerful platform utilized for planning, organizing, and managing manual testing activities. Jira streamlined the process of tracking test cases, logging and prioritizing bugs, and monitoring overall testing progress. Its collaborative features enabled seamless coordination among team members, ensuring efficient communication and systematic validation of requirements throughout the testing lifecycle.
- **Testing Period:** October 22, 2024 – October 30, 2024

### Initial Approach and Challenges

The manual testing phase was structured within a Jira sprint, allowing for efficient task management and progress tracking. Initial efforts focused on validating user registration, authentication, and post management functionalities. However, the absence of comprehensive documentation on certain workflows, such as user interaction validation, caused delays in the testing process.

To overcome this challenge, we conducted exploratory testing and collaborated to define key workflows. This approach enabled us to simulate user actions effectively and identify potential issues, ensuring comprehensive validation of the platform’s functionalities.

### Functionalities Tested

#### 1. Functionalities Covered
- **Registration and Login**
    - Validated field constraints, including username uniqueness, password strength, and email format.
    - Tested anonymous user registration and login processes.
    - Verified login functionality for both authorized and anonymous users.
- **User Profile Management**
    - Verified updates to name, profile picture, visibility settings, and optional fields like age and nationality.
    - Tested profile management capabilities for authorized users.
- **Post Creation and Management**
    - Tested creating posts with public and connection-only visibility.
    - Ensured proper handling of post creation errors and validations.
- **Connections**
    - Validated connection requests, approvals, and disconnections.
    - Verified system behavior for unauthorized connection requests.
- **Public Feed**
    - Ensured that public posts were displayed chronologically.
    - Verified profile search functionality using name and email.
    - Tested visibility of posts for anonymous users.
- **Verification**
    - Tested field validations during registration and login, including password rules and email formats.
    - Ensured proper error handling for invalid inputs.
- **Anonymous Users**
    - Verified that anonymous users could view public posts and access limited functionalities without logging in.
- **Search Function**
    - Tested search functionality for retrieving profiles using names and email addresses.
    - Verified accurate results for both authorized and anonymous users.
- **Administrative Privileges**
    - Tested editing and deleting users, posts, and comments by admin users.
    - Verified admin controls for managing user connections and privacy settings.
- **Interactions with Other Users**
    - Validated functionalities for liking, commenting, and interacting with posts.
    - Ensured proper handling of unauthorized interactions by anonymous users.

---

## Findings

### 1. Bugs Identified

- **Registration**
    - **IAG-64:** Registration allowed with an already registered email.
    - **IAG-66:** Registration allowed with a password shorter than 8 characters.
    - **IAG-67:** Registration allowed with a password missing uppercase letters or special characters.
- **Profile Search**
    - **IAG-63:** Profile search by email failed to display registered users.
    - **IAG-69:** Profile search by UserID failed to display existing profiles.
- **Posts**
    - **IAG-68:** Post title disappeared after changing visibility to "public."
    - **IAG-70:** Private posts of non-connected users were visible to others.
- **Login**
    - **IAG-79:** Email verification bypass allowed login without confirmation.
- **General Issues**
    - **IAG-74:** System failed to retrieve profiles in search due to database errors.
    - **IAG-76:** Missing functionality for changing the password in the account settings.
    - **IAG-78:** Missing identity verification functionality for users.
    - **IAG-104:** All user profiles displayed when anonymous users accessed the search.

### Statistics Summary
- **[Manual] Post Creation:** 7
- **[Manual] Verification:** 2
- **[Manual] Login Form:** 3
- **[Manual] User Registration:** 7
- **[Manual] Authorized Users:** 8
- **[Manual] Search Function:** 5
- **[Manual] Anonymous Users:** 7
- **[Manual] Profile Management for Authorized Users:** 5
- **[Manual] Interactions with Other Users:** 6
- **[Manual] Administrator Rights:** 4
- **[BUG Report]:** 15

---

## Testing Outcome

All tests were conducted manually, focusing on validating the platform’s core functionalities across different user roles and scenarios. The tests included workflows such as post creation, login verification, user registration, and profile management. Despite minor challenges due to incomplete documentation, the team ensured thorough coverage by adapting to dynamic test scenarios and identifying critical issues.

---

## Conclusion

### Findings Summary
1. **Bugs:** A total of 12 critical and functional bugs were identified, significantly impacting core workflows such as registration, login, and profile search functionality.
2. **Missing Features:** Key functionalities, including email verification and post interaction capabilities, are absent, limiting the platform's usability.
3. **Requirements Compliance:** While the platform meets some of the basic functional requirements, it falls short of fully addressing all specified criteria.

### Recommendation
- **Fixing Critical Bugs**
    - Address high-priority issues in registration, login, and profile visibility workflows.
- **Implementing Missing Features**
    - Add essential functionalities like email verification and identity checks.
- **Enhancing Functionality and Documentation**
    - Improve post management features and develop comprehensive system documentation.

---

**Links to Documentation and Jira Collection Files:**  
[Jra Link](https://a61-qa-team-1.atlassian.net/jira/software/c/projects/IAG/list?selectedIssue=IAG-129)