@echo off
:: Define paths
set JMETER_PATH="C:\Users\Gabriel\Desktop\Jmeter\apache-jmeter-5.6.3\bin"
set DOCKER_SETUP="C:\Users\Gabriel\Desktop\FinalProject\WEare\setup docker\docker-compose.yml"

:: Dynamically set the base directory based on the current batch file location
set BASE_DIR=%~dp0

:: Define dynamic paths for results and logs
set REPORT_DIR=%BASE_DIR%TestResults
set RESULTS_FILE=%BASE_DIR%Logs\results.jtl

:: Check if a test name is provided
if "%1"=="" (
    echo Usage: run_tests.bat [TEST_NAME] [THREADS] [RAMP] [LOOPS] [DURATION]
    echo Example: run_tests.bat Navigation 10 5 1 60
    exit /b 1
)

:: Dynamically set the JMETER_TEST_FILE based on the test name provided
set TEST_NAME=%1
set JMETER_TEST_FILE="%BASE_DIR%TestScenarios\%TEST_NAME%.jmx"

:: Check if the test file exists
if not exist %JMETER_TEST_FILE% (
    echo Test file not found: %JMETER_TEST_FILE%
    exit /b 1
)

:: Default parameters
set NUM_THREADS=10
set RAMP_TIME=5
set LOOP_COUNT=1
set DURATION=60

:: Override defaults with input arguments
if not "%1"=="" set NUM_THREADS=%2
if not "%2"=="" set RAMP_TIME=%3
if not "%3"=="" set LOOP_COUNT=%4
if not "%4"=="" set DURATION=%5

:: Clear Logs and TestResults directories
echo Cleaning up Logs and TestResults directories...
if exist "%REPORT_DIR%\*" (
    echo Deleting TestResults contents...
    rmdir /s /q "%REPORT_DIR%"
    mkdir "%REPORT_DIR%"
)
if exist "%BASE_DIR%Logs\*" (
    echo Deleting Logs contents...
    rmdir /s /q "%BASE_DIR%Logs"
    mkdir "%BASE_DIR%Logs"
)

:: Start Docker containers
echo Starting Docker containers...
docker-compose -f %DOCKER_SETUP% up -d
if %ERRORLEVEL% neq 0 (
    echo Failed to start Docker containers. Exiting...
    exit /b 1
)

:: Run JMeter test
echo Running JMeter test: %TEST_NAME%
echo Number of Threads: %NUM_THREADS%
echo Ramp-Up Time: %RAMP_TIME%
echo Loop Count: %LOOP_COUNT%
echo Duration: %DURATION%
call %JMETER_PATH%\jmeter -n -t %JMETER_TEST_FILE% -l %RESULTS_FILE% -e -o %REPORT_DIR%\%TEST_NAME%-Report ^
    -Jthreads=%NUM_THREADS% ^
    -Jramp=%RAMP_TIME% ^
    -Jloops=%LOOP_COUNT% ^
    -Jduration=%DURATION%
	
	if %ERRORLEVEL% neq 0 (
    echo JMeter test failed. Exiting...
    call docker-compose -f %DOCKER_SETUP% down
    exit /b 1
)

:: Stop Docker containers
echo Stopping Docker containers...
call docker-compose -f %DOCKER_SETUP% down
if %ERRORLEVEL% neq 0 (
    echo Failed to stop Docker containers. Exiting...
    exit /b 1
)
echo Docker containers stopped successfully.

:: Display results
echo Test completed. Results saved in %RESULTS_FILE%.
echo HTML report available at %REPORT_DIR%\%TEST_NAME%-Report.
pause
