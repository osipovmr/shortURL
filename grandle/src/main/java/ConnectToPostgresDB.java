import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectToPostgresDB implements Constants {
    private static final Logger log = LogManager.getLogger(ConnectToPostgresDB.class);
    private static HikariConfig config = new HikariConfig();
    private static HikariDataSource dataSource;

    static {
        config.setJdbcUrl(POSTGRES_URL);
        config.setUsername(POSTGRES_USERNAME);
        config.setPassword(POSTGRES_PASSWORD);
        config.addDataSourceProperty( "cachePrepStmts" , "true" );
        config.addDataSourceProperty( "prepStmtCacheSize" , "250" );
        config.addDataSourceProperty( "prepStmtCacheSqlLimit" , "2048" );
        config.setDriverClassName("org.postgresql.Driver");
        config.setMaximumPoolSize(5);
        dataSource = new HikariDataSource( config );
    }

    public static Connection getConnection() {
        try {
            Connection connection = dataSource.getConnection();
            log.info("Connection successful.");
            return connection;
        }catch (SQLException e) {
            log.error("Connection error.");
            e.printStackTrace();
            return null;
        }
    }
}
