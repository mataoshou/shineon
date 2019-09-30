
echo 开始生成


rem 删除文件，创建新的路径
cd shineon_db_create

rd /s/q src\main\java

md src\main\java


jre8\bin\java.exe -Dmaven.multiModuleProjectDirectory=shineon_db_create "-Dmaven.home=maven3" "-Dclassworlds.conf=m2.conf" "-javaagent:idea_rt.jar=62340:bin" -Dfile.encoding=UTF-8 -classpath "plexus-classworlds-2.5.2.jar" org.codehaus.classworlds.Launcher -Didea.version=2018.3.4 org.mybatis.generator:mybatis-generator-maven-plugin:1.3.2:generate


cd ..

rd /s/q db

md db


xcopy shineon_db_create\src\main\java\com\shineon\coder\db db /s

echo 生成成功
pause;