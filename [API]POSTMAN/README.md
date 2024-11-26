========== Postman Automation Testing Suite ===========
=

### Introduction:

This script generates a detailed, dark-themed HTML report from Postman API test results stored in a `.json` log file. The report provides insights into test outcomes, highlights test-specific details, and includes a summary of total pass, fail, and execution time.

The report is based on tests executed using the following files:
- **WEAre ENV.postman_environment.json**: Contains environment variables.
- **WEAre.postman_collection.json**: Stores the test collection.
- **workspace.postman_globals.json**: Provides necessary global variables.

### How to Use These Files:

1. Import the environment, collection, and globals into Postman.
2. Configure the environment to ensure all variables are correctly set.
3. Execute the entire collection as a suite to run all tests at once.

**Special Notes**:
- Tests named `Log` are used for cookie generation and session setup. They are included in the collection but are **excluded** from the final reporting as they are not part of the pass/fail statistics.

============== Postman Report Generator ==============
=

1. **Navigate to the Directory**:
   Ensure the `report.bat` and `convert_to_html.py` files are in the same directory.

2. **Before Running the Script**:
   - **Verify Python Installation**:
     Ensure Python 3.x is installed and accessible via the `python` command.
     If not, download Python from [python.org](https://www.python.org/downloads/), and ensure you check the box to "Add Python to PATH" during installation.
     Test your installation with:
     python --version

3. **Input File Requirements**:
   - Provide the path to your Postman-generated `.json` log file as an argument when running the script.
   - Example JSON file: `log.json`.

4. **To Execute the Script**:
   Run the following command inside the directory where `report.bat` is located:

   **Example**:
   report.bat [JSON_LOG_PATH]

   Replace `[JSON_LOG_PATH]` with the full path to the `.json` file you want to convert into a report.

   **Example**:
   report.bat C:\Users\Gabriel\Desktop\FinalProject\LocalRepo\WEAre-Social-Network-Project\[API]POSTMAN\log.json

5. **Generated Report**:
   - After execution, an HTML report is created in the same directory as the `.json` file.
   - The generated file will have `_report.html` appended to the original name.
     **Example**: `log_report.html`.

6. **Script Features**:
   - **Dark Theme**:  
     The report features a visually appealing dark theme for easier readability.
   - **Row Highlighting**:  
     - Tests with the name `Log` are highlighted in yellow.
     - All other rows are highlighted in green for passing tests or red for failed tests.
   - **Summary Section**:  
     Displays total passes, total failures, and total execution time in a bold and color-coded format.

7. **Test Results**:
   - Tests are parsed from the `.json` log file and presented in a table.
   - Each row includes:
     - Test Name
     - URL
     - Status (Pass/Fail)
     - Execution Time
     - Response Code and Message
   - Special handling is applied to tests named `Log`, which are marked in yellow for clarity.

8. **Errors and Troubleshooting**:
   - **Missing Python**:
     If Python is not installed or recognized, download and install Python, and ensure it is added to your PATH environment variables.
   - **Invalid JSON File**:
     If the `.json` file path is incorrect or the file is not in the expected format, the script will notify you with an error message.

9. **Modifying the Script**:
   - To customize the output format, styles, or handling of specific tests, you can edit the `convert_to_html.py` script directly.

========== END OF README ===========
=
