package com.shineon.coder;


public class BuildTools {


    public void build()
    {
        String cmd ="\"C:\\Program Files\\Java\\jdk1.8.0_60\\bin\\java.exe\" -Dmaven.multiModuleProjectDirectory=E:\\IdeaProjects\\shineon\\core\\shineon_db_create \"-Dmaven.home=E:\\tool\\idea\\IntelliJ IDEA 2018.3.4\\plugins\\maven\\lib\\maven3\" \"-Dclassworlds.conf=E:\\tool\\idea\\IntelliJ IDEA 2018.3.4\\plugins\\maven\\lib\\maven3\\bin\\m2.conf\" \"-javaagent:E:\\tool\\idea\\IntelliJ IDEA 2018.3.4\\lib\\idea_rt.jar=64154:E:\\tool\\idea\\IntelliJ IDEA 2018.3.4\\bin\" -Dfile.encoding=UTF-8 -classpath \"E:\\tool\\idea\\IntelliJ IDEA 2018.3.4\\plugins\\maven\\lib\\maven3\\boot\\plexus-classworlds-2.5.2.jar\" org.codehaus.classworlds.Launcher -Didea.version=2018.3.4 org.mybatis.generator:mybatis-generator-maven-plugin:1.3.2:generate\n";


    }

}
