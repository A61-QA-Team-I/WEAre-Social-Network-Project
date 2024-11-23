@echo off
:: Define the path to the test results folder
set RESULTS_DIR="C:\Users\Gabriel\Desktop\FinalProject\LocalRepo\WEAre-Social-Network-Project\Jmeter_PerformanceTests\TestResults"

:: Check if the folder exists
if exist %RESULTS_DIR% (
    echo Deleting test results folder: %RESULTS_DIR%
    rmdir /s /q %RESULTS_DIR%
    if %ERRORLEVEL% neq 0 (
        echo Failed to delete the folder. Please check permissions or if it's in use.
        exit /b 1
    )
    echo Test results folder deleted successfully.
) else (
    echo Test results folder does not exist: %RESULTS_DIR%
)

pause
