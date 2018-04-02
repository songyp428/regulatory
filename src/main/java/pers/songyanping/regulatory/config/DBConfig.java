//package pers.songyanping.regulatory.config;
//
//import com.alibaba.druid.pool.DruidDataSource;
//import org.apache.ibatis.annotations.Mapper;
//import org.apache.ibatis.plugin.Interceptor;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//
//import javax.sql.DataSource;
//import java.sql.SQLException;
//import java.util.Properties;
//
//public class DBConfig  extends AbstractDBConfiguration {
//
//
//    public static final String SQL_SESSION_FACTORY_NAME_P = "payment_sql_session_factory";
//
//    @Value("${spring.datasource.schema}")
//    private String database;
//
//    @Value("${spring.datasource.host}")
//    private String host;
//
//    @Override
//    protected String getDatabase() {
//        return database;
//    }
//
//    @Override
//    protected String getHost() {
//        return host;
//    }
//
//    @Primary
//    @Override
//    @Bean("paymentDataSource")
//    public DataSource dataSource() throws SQLException {
//        return super.dataSource();
//    }
//
//    protected void buildDataSource(DruidDataSource dataSource) {
//        //dataSource.setMaxActive(maxPayActive);
//    }
//
//    @Primary
//    @Override
//    @Bean(SQL_SESSION_FACTORY_NAME_P)
//    public SqlSessionFactory sqlSessionFactory() throws Exception {
//        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
//        bean.setDataSource(this.dataSource());
//        //分页插件
//        PageHelper pageHelper = new PageHelper();
//        Properties props = new Properties();
//        props.setProperty("reasonable", "true");
//        props.setProperty("supportMethodsArguments", "true");
//        props.setProperty("returnPageInfo", "check");
//        props.setProperty("params", "count=countSql");
//        pageHelper.setProperties(props);
//        bean.setPlugins(new Interceptor[]{pageHelper});
//        return bean.getObject();
//    }
//
//    @Primary
//    @Override
//    @Bean("paymentDataSourceTransactionManager")
//    public DataSourceTransactionManager transactionManager() throws SQLException {
//        return super.transactionManager();
//    }
//}
