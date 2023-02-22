package io.github.changebooks.mybatis.provider.sample;

import io.github.changebooks.mybatis.provider.ResultMapUtils;
import org.apache.ibatis.datasource.unpooled.UnpooledDataSource;
import org.apache.ibatis.logging.stdout.StdOutImpl;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import javax.sql.DataSource;

/**
 * @author changebooks@qq.com
 */
public final class DataSourceConstants {

    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/test?characterEncoding=utf-8&useInformationSchema=true";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "123456";

    public static final DataSource INSTANCE = new UnpooledDataSource(DRIVER, URL, USERNAME, PASSWORD);

    public static final TransactionFactory TRANSACTION_FACTORY = new JdbcTransactionFactory();

    public static final Environment ENVIRONMENT = new Environment.Builder("").
            dataSource(INSTANCE).
            transactionFactory(TRANSACTION_FACTORY).
            build();

    public static final Configuration CONFIGURATION = new Configuration(ENVIRONMENT);

    public static final SqlSessionFactory SESSION_FACTORY = new SqlSessionFactoryBuilder().build(CONFIGURATION);

    static {
        CONFIGURATION.setLogImpl(StdOutImpl.class);
        CONFIGURATION.addMapper(CityMapper.class);

        ResultMapUtils.addResultMaps(CONFIGURATION);
    }

}
