title start service

set current=%~dp0


for /f %%m in (serviceName.txt) do (
cd /d %current%

cd %%m
start cmd /k "start-service.cmd"

rem wait
ping 127.1 -n 5 >nul
)

pause;
