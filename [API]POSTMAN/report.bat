@echo off
setlocal

:: Check if a JSON file location is provided
if "%1"=="" (
    echo Error: No JSON log location provided.
    echo Usage: report.bat json_log_location
    exit /b 1
)

:: Assign the input JSON file location to a variable
set JSON_LOG=%1

:: Check if the file exists
if not exist "%JSON_LOG%" (
    echo Error: The specified file does not exist.
    exit /b 1
)

:: Run the Python script with the provided JSON log
python convert_to_html.py "%JSON_LOG%"

exit /b 0