================= INSTRUCTIONS! =================
=

1. Navigate to the `Jmeter_PerformanceTests` directory to run the desired performance tests.

2. Before running the `run_tests.bat` file:
   - **Edit the path to your JMeter folder**:
     Update the `JMETER_PATH` variable in the batch file with the path to your JMeter installation (e.g., `C:\path\to\jmeter\bin`).
   - **Edit the path to your Docker setup**:
     Update the `DOCKER_SETUP` variable with the path to your `docker-compose.yml` file (e.g., `C:\path\to\docker-compose.yml`).

3. **Default Parameters**:
   - If no values are passed to `run_tests.bat`, the following default test parameters will be used:
     - Number of Threads: `10`
     - Ramp-Up Time: `5 seconds`
     - Loop Count: `1`
     - Test Duration: `60 seconds`

4. **Dynamic Test Selection**:
   - Specify the name of the test to run as the first argument when executing `run_tests.bat`. The batch file dynamically locates the corresponding `.jmx` file in the `TestScenarios` folder.

5. **To Execute a Test**:
   Run the following command inside the `Jmeter_PerformanceTests` directory:

run_tests.bat [TEST_NAME] [THREADS] [RAMP] [LOOPS] [DURATION]

- Replace `[TEST_NAME]` with the name of the `.jmx` file (without the extension) you want to execute (e.g., `Navigation`).
- Replace `[THREADS]`, `[RAMP]`, `[LOOPS]`, and `[DURATION]` with desired values or leave them blank to use default parameters.

**Example**:

run_tests.bat Navigation 20 10 5 120

6. **Test Results**:
- After execution, test results and logs are automatically saved in the `TestResults` and `Logs` folders inside the `Jmeter_PerformanceTests` directory.
- Open the HTML file in the `TestResults\<TEST_NAME>-Report` folder to view the graphical test report.

7. **Cleaning Up Before a New Test**:
- To avoid conflicts, the `run_tests.bat` script automatically clears the contents of the `TestResults` and `Logs` folders before running a new test.
- Alternatively, you can clean these folders manually if needed.

================= INSTRUCTIONS! =================
=
