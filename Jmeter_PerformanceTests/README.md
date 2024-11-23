==========
== WIP! ==
==========

1. To run the desired performance tests navigate to the Jmeter_PerformanceTests

2. In the run_tests.bat file:
- Edit the path to your JMeter folder by changing JMETER_PATH 
- Edit the path to the JMeter .jmx test file you will be running by changing JMETER_TEST_FILE
- Edit the directory where the report will be stored by changing REPORT_DIR
- Edit the docker setup path by changing DOCKER_SETUP

3. Default parameters indicate how tests will be run if no values are passed to run_tests

4. To execute the JMeter tests run the following command:

run_tests.bat <THREADS> <RAMP> <LOOPS> <DURATION>

- Replace each value with the desired one for the test or leave blank for default parameters to be ran

5. After successful execution test reports are saved in the TestResults folder the specified directory, view the HTML file inside the folder for a more graphical display of test data

6. Once the results are reviewed you will need to delete the TestResults folder before executing a new test command, use the following command to delete the folder (to be executed inside Jmeter_PerformanceTests), or delete the folder manually:

delete_resulsts.bat

==========
== WIP! ==
==========