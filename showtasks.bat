call runcrud.bat
if "%ERRORLEVEL%" == "0" goto rungettaskspage
echo.
echo runcrud has errors – breaking work
goto fail

:rungettaskspage
start msedge.exe http://localhost:8080/crud/v1/task/getTasks
if "%ERRORLEVEL%" == "0" goto end
echo.
echo running getTasks command has errors – breaking work
goto fail

:fail
echo.
echo There were errors

:end
echo.
echo Work is finished.