package com.cgling.tms;

import com.cgling.mybatis.generator.api.XGenerator;
import com.cgling.mybatis.generator.config.*;
import org.junit.Test;

import java.util.List;

/**
 * @author houguangqiang
 * @date 2017-11-27
 * @since 1.0
 */
public class GenTest {

    @Test
    public void run(){
        new XGenerator(){
            @Override
            protected void configureJdbcConnection(XJdbcConnection jdbcConnection) {
                jdbcConnection.setDriverClass("com.mysql.jdbc.Driver");
                jdbcConnection.setConnectionURL("jdbc:mysql://114.215.68.26:3306/tms_dev?characterEncoding=utf8");
                jdbcConnection.setUserId("root");
                jdbcConnection.setPassword("haoren123A!");
            }

            @Override
            protected void configureSqlMapGenerator(XSqlMapGenerator sqlMapGenerator) {
                sqlMapGenerator.setTargetProject("src/main/resources");
                sqlMapGenerator.setTargetPackage("mapper.user");
            }

            @Override
            protected void configureJavaClientGenerator(XJavaClientGenerator javaClientGenerator) {
                javaClientGenerator.setTargetProject("src/main/java");
                javaClientGenerator.setTargetPackage("com.cgling.tms.user.mapper");
            }

            @Override
            protected void configureJavaModelGenerator(XJavaModelGenerator javaModelGenerator) {
                javaModelGenerator.setTargetProject("src/main/java");
                javaModelGenerator.setTargetPackage("com.cgling.tms.user.model");
            }

            @Override
            protected void configureTables(List<XTable> tables) {
                tables.add(new XTable.Builder(){
                    @Override
                    protected void configureTable(XTable table) {
                        table.setTableName("user_info");
                        table.setDomainObjectNameSuffix("Model");
                    }

                    @Override
                    protected XGeneratedKey configureGeneratedKey(XGeneratedKey generatedKey) {
                        generatedKey.setColumn("user_id");
                        generatedKey.setIdentity(true);
                        return generatedKey;
                    }
                }.build());
            }
        }.run(true);
    }
}

