package study.webpgm.db;

import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.support.JdbcUtils;

import java.sql.*;

@Slf4j
public class ConnectTest {

    static String jdbcUrl = "jdbc:mysql://localhost:3306/study";
    static String dbId = "root";
    static String dbPass = "1234qwer";

    public static void main(String[] args) throws SQLException {

        driveManagerSqlTest();
        makeConnectionWithDriveManager();
        makeConnectionWithDriveManagerDataSource();
        makeConnectionPoolWithHikariDataSource();

    }

    public static void makeConnectionWithDriveManager() throws SQLException {
        Connection con1 = DriverManager.getConnection(jdbcUrl,dbId ,dbPass );
        log.info("DriverManager conn={}, class={}", con1, con1.getClass());
        JdbcUtils.closeConnection(con1);

        Connection con2 = DriverManager.getConnection(jdbcUrl,dbId ,dbPass );
        log.info("DriverManager conn={}, class={}", con2, con2.getClass());
        JdbcUtils.closeConnection(con2);
    }

    public static void makeConnectionWithDriveManagerDataSource() throws SQLException {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource(jdbcUrl, dbId, dbPass);

        driverManagerDataSource.getConnection();

        Connection con1 = driverManagerDataSource.getConnection();
        log.info("DriverManagerDataSource conn={}, class={}", con1, con1.getClass());
        JdbcUtils.closeConnection(con1);

        Connection con2 = driverManagerDataSource.getConnection();
        log.info("DriverManagerDataSource conn={}, class={}", con2, con2.getClass());
        JdbcUtils.closeConnection(con2);
    }

    public static void makeConnectionPoolWithHikariDataSource() throws SQLException {

        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(jdbcUrl);
        dataSource.setUsername(dbId);
        dataSource.setPassword(dbPass);

        dataSource.setMaximumPoolSize(2);
        dataSource.setPoolName("MyPool");

        Connection con1 = null;
        Connection con2 = null;

        for( int i = 0; i < 5; i++) {
            con1 = dataSource.getConnection();
            con2 = dataSource.getConnection();

            log.info("HikariDataSource conn={}, class={}", con1, con1.getClass());
            log.info("HikariDataSource conn={}, class={}", con2, con2.getClass());

            JdbcUtils.closeConnection(con1);
            JdbcUtils.closeConnection(con2);

        }
    }

    public static void driveManagerSqlTest() throws SQLException {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "SELECT id, name, age FROM member";

        con = DriverManager.getConnection(jdbcUrl,dbId ,dbPass );
        pstmt=con.prepareStatement(sql);
        rs = pstmt.executeQuery();

        int cnt = 0;

        while(rs.next()){
            log.info( "resutl cnt={}, id={}, name={}, age={}"
                    , cnt , rs.getString(1), rs.getString(2) , rs.getString(3)  );
            cnt++;
        }
        JdbcUtils.closeResultSet(rs);
        JdbcUtils.closeStatement(pstmt);
        JdbcUtils.closeConnection(con);
    }

}
