package com.shineon.coder.tool.sysbuild;

import com.shineon.coder.kernel.common.generator.GeneratorSql;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;

import java.io.IOException;
import java.sql.SQLException;

public class PojoBuildTool {
    public static void main(String[] args) throws InterruptedException, SQLException, InvalidConfigurationException, XMLParserException, IOException {
        GeneratorSql sql = new GeneratorSql();
//        sql.build();


//        全部重新生成
        sql.overrideBuild();
    }

}
