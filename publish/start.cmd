title start service

set current=%~dp0

cd /d %current%
cd shineon.eurake 

start cmd /k "start-service.cmd"

ping 127.1 -n 11 >nul

cd /d %current%
cd shineon.api.uauth

start cmd /k "start-service.cmd"
ping 127.1 -n 11 >nul


cd /d %current%
cd shineon.base.user 

start cmd /k "start-service.cmd"

ping 127.1 -n 11 >nul

cd /d %current%
cd shineon.db.user 

start cmd /k "start-service.cmd"

ping 127.1 -n 11 >nul

cd /d %current%
cd shineon.service.uauth

start cmd /k " start-service.cmd"
ping 127.1 -n 11 >nul

cd /d %current%
cd shineon.web

start cmd /k " start-service.cmd"
ping 127.1 -n 11 >nul

cd /d %current%
cd shineon.zuul

start cmd /k " start-service.cmd"
ping 127.1 -n 11 >nul

pause;
