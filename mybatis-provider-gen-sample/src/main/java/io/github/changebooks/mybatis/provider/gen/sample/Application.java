package io.github.changebooks.mybatis.provider.gen.sample;

import io.github.changebooks.mybatis.provider.gen.CodeGenerator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author changebooks@qq.com
 */
public class Application {

    public static void main(String[] args) throws SQLException {
        String author = "changebooks@qq.com";
        CodeGenerator generator = new CodeGenerator.Builder().setAuthor(author).build();

        Connection conn = DriverManager.
                getConnection(DataSourceConstants.URL, DataSourceConstants.USERNAME, DataSourceConstants.PASSWORD);

        String code = generator.genCode(conn, "city");
        System.out.println(code);
    }

}
