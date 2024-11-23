@echo off
:: Define paths
set JMETER_PATH="C:\Users\Gabriel\Desktop\Jmeter\apache-jmeter-5.6.3\bin"
set JMETER_TEST_FILE="C:\Users\Gabriel\Desktop\FinalProject\LocalRepo\WEAre-Social-Network-Project\Jmeter_PerformanceTests\TestScenarios\Navigation.jmx"
set REPORT_DIR="C:\Users\Gabriel\Desktop\FinalProject\LocalRepo\WEAre-Social-Network-Project\Jmeter_PerformanceTests\TestResults"
set RESULTS_FILE="C:\Users\Gabriel\Desktop\FinalProject\LocalRepo\WEAre-Social-Network-Project\Jmeter_PerformanceTests\TestResults\results.jtl"
set DOCKER_SETUP="C:\Users\Gabriel\Desktop\FinalProject\WEare\setup docker\docker-compose.yml"

:: Default parameters
set NUM_THREADS=10
set RAMP_TIME=5
set LOOP_COUNT=1
set DURATION=60

:: Override defaults with input arguments
if not "%1"=="" set THREADS=%1
if not "%2"=="" set RAMP=%2
if not "%3"=="" set LOOPS=%3
if not "%4"=="" set DURATION=%4

:: Start Docker containers
echo Starting Docker containers...
docker-compose -f %DOCKER_SETUP% up -d
if %ERRORLEVEL% neq 0 (
    echo Failed to start Docker containers. Exiting...
    exit /b 1
)

:: Run JMeter test
echo Running JMeter test with the following parameters:
echo Number of Threads: Threads=%THREADS%
echo Ramp-Up Time: Ramp=%RAMP%
echo Loop Count: Loops=%LOOPS%
echo Duration: Duration=%DURATION%
call %JMETER_PATH%\jmeter -n -t %JMETER_TEST_FILE% -l %RESULTS_FILE% -e -o %REPORT_DIR% ^
    -Jthreads=%THREADS% ^
    -Jramp=%RAMP% ^
    -Jloops=%LOOPS% ^
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
echo HTML report available at %REPORT_DIR%.
pause
