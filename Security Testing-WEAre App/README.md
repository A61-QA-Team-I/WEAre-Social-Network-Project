================= INSTRUCTIONS! =================
=

1. **Purpose**:  
   This script runs automated security tests, manages Docker containers, and generates Allure reports dynamically.

2. **Prerequisites**:  
   Ensure the following are installed and configured:  
   - **Docker**: To manage containers.  
   - **Maven**: For running REST Assured tests.  
   - **Allure Command-Line Tool**: To generate and view reports.

3. **Dynamic Path Handling**:  
   The script dynamically adjusts paths based on the location of the `.bat` file. Place `security_tests.bat` in the project root for proper functionality.

4. **Usage**:  
   Open a terminal in the directory containing `security_tests.bat` and run:  
   ```bash
   security_tests.bat

5. **Key Actions**:  
   - Starts Docker containers using `docker-compose up`.  
   - Cleans old Allure results from `target/allure-results`.  
   - Runs security tests using Maven.  
   - Generates and serves the Allure report in a browser.  
   - Stops Docker containers using `docker-compose down`.

6. **Error Handling**:  
   - Provides detailed error messages if any step fails.  
   - Skips Allure report generation if `allure-results` is missing.  

7. **Output**:  
   - Test results are saved in `target/allure-results`.  
   - The Allure report is served dynamically in a browser.

================= INSTRUCTIONS! =================
=
