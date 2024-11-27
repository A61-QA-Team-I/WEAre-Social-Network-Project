@echo off
echo "Navigating to Docker setup directory"
cd "..\WEare\setup docker"

echo "Bringing up Docker containers"
call docker-compose up -d

echo "Navigating to Maven project directory"
cd "..\..\Security Testing-WEAre App"

echo "Cleaning previous Allure results"
if exist target\allure-results rmdir /s /q target\allure-results

echo "Running Maven tests"
call mvn clean test

echo "Serving Allure report"
if exist target\allure-results (
    call allure serve target/allure-results
) else (
    echo "Allure results directory not found. Skipping report serving."
)

echo "Navigating back to Docker setup directory to shut down containers"
cd "..\WEare\setup docker"

echo "Shutting down Docker containers"
call docker-compose down

echo "Build complete"
