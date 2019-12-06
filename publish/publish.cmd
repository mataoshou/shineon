title publish service

set current=%~dp0

cd /d %current%

set serviceRoot=%current%..\core

set ideaPath=E:\MG.SOFT\soft\idea\IDEA\


for /f %%m in (serviceName.txt) do (
cd %serviceRoot%
cd %%m
"%ideaPath%JDK\bin\java.exe" -Dmaven.multiModuleProjectDirectory=%%m "-Dmaven.home=%ideaPath%\plugins\maven\lib\maven3" "-Dclassworlds.conf=%ideaPath%\plugins\maven\lib\maven3\bin\m2.conf" "-javaagent:%ideaPath%\lib\idea_rt.jar=27493:%ideaPath%\bin" -Dfile.encoding=UTF-8 -classpath "%ideaPath%\plugins\maven\lib\maven3\boot\plexus-classworlds-2.5.2.jar" org.codehaus.classworlds.Launcher -Didea.version=2018.3.4 install

del /q %current%%%m\%%m-1.0.jar 
echo f|XCOPY target\%%m-1.0.jar %current%%%m\%%m-1.0.jar /q
)

cd /d %current%

cd ..


RD /S /Q publish\shineon.web\web\
echo f|xcopy /E /Q /Y "E:\shineon.frame\shineon\core\shineon.web\web" "E:\shineon.frame\shineon\publish\shineon.web\web\"

pause;