title start service

set current=%~dp0


for /f %%m in (serviceName.txt) do (
cd /d %current%

cd %%m
start cmd /k "..\JDK\bin\java -jar %%m-1.0.jar"

rem wait
ping 127.1 -n 10>nul
)

pause;
