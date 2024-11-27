@echo off

:: Get the directory of the current script
set SCRIPT_DIR=%~dp0

:: Navigate to Docker setup directory
echo "Navigating to Docker setup directory..."
cd "%SCRIPT_DIR%..\WEare\setup docker"

:: Bring up Docker containers
echo "Bringing up Docker containers..."
call docker-compose up -d

:: Navigate to Maven project directory
echo "Navigating to Maven project directory..."
cd "%SCRIPT_DIR%"

:: Clean previous Allure results
echo "Cleaning previous Allure results..."
if exist target\allure-results rmdir /s /q target\allure-results

:: Run Maven tests
echo "Running Maven tests..."
call mvn clean test -Dsurefire.suiteXmlFiles="%SCRIPT_DIR%\src\test\resources\main-suite.xml"

:: Serve Allure report
echo "Serving Allure report..."
if exist target\allure-results (
    call allure serve target/allure-results
) else (
    echo "Allure results directory not found. Skipping report serving."
)

:: Navigate back to Docker setup directory to shut down containers
echo "Navigating back to Docker setup directory to shut down containers..."
cd "%SCRIPT_DIR%..\WEare\setup docker"

:: Shut down Docker containers
echo "Shutting down Docker containers..."
call docker-compose down

:: Build complete
echo "Build complete!"

