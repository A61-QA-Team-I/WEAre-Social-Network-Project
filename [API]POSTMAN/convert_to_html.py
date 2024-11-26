import json
import sys
import os

if len(sys.argv) < 2:
    print("Error: No JSON file provided.")
    sys.exit(1)

input_file = sys.argv[1]

if not os.path.exists(input_file):
    print("Error: File does not exist.")
    sys.exit(1)

output_file = input_file.replace('.json', '_report.html')

try:
    with open(input_file, 'r') as f:
        data = json.load(f)
except Exception as e:
    print("Error reading JSON file:", e)
    sys.exit(1)

html_content = f"""
<html>
<head>
    <title>Postman Test Suite Report - WEAre REST API</title>
    <style>
        body {{ font-family: Arial, sans-serif; background-color: #121212; color: white; margin: 0; padding: 0; }}
        h1 {{ text-align: center; margin: 20px 0; }}
        .summary {{ display: flex; justify-content: space-around; margin: 20px 0; }}
        .summary div {{ width: 30%; padding: 15px; text-align: center; border-radius: 5px; }}
        .green {{ background-color: #4CAF50; color: white; font-weight: bold; }}
        .red {{ background-color: #f44336; color: white; font-weight: bold; }}
        .blue {{ background-color: #2196F3; color: white; font-weight: bold; }}
        table {{ border-collapse: collapse; width: 100%; margin-top: 20px; }}
        th, td {{ border: 1px solid #333; padding: 8px; text-align: left; }}
        th {{ background-color: #222; color: white; }}
        .log {{ background-color: #554400; color: white; }}
        .test {{ background-color: #004d00; color: white; }}
    </style>
</head>
<body>
    <h1>Postman Test Suite Report - WEAre REST API</h1>
    <div class="summary">
        <div class="green">Total Pass: {data.get('totalPass', 0)}</div>
        <div class="red">Total Fail: {data.get('totalFail', 0)}</div>
        <div class="blue">Total Time: {data.get('totalTime', 0)} ms</div>
    </div>
    <table>
        <thead>
            <tr>
                <th>Test Name</th>
                <th>URL</th>
                <th>Status</th>
                <th>Time (ms)</th>
                <th>Response Code</th>
            </tr>
        </thead>
        <tbody>
"""

for result in data.get('results', []):
    if result.get('name', '') == "Log":
        row_class = "log"
    else:
        row_class = "test"

    html_content += f"""
        <tr class="{row_class}">
            <td>{result.get('name', 'N/A')}</td>
            <td>{result.get('url', 'N/A')}</td>
            <td>{'Pass' if result['responseCode']['code'] == 200 else 'Fail'}</td>
            <td>{result.get('time', 'N/A')}</td>
            <td>{result['responseCode']['code']} - {result['responseCode']['name']}</td>
        </tr>
    """

html_content += """
        </tbody>
    </table>
</body>
</html>
"""

try:
    with open(output_file, 'w') as f:
        f.write(html_content)
    print(f"HTML report generated: {output_file}")
except Exception as e:
    print("Error writing HTML file:", e)
    sys.exit(1)