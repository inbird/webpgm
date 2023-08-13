package study.webpgm.db;

import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionManagerTest {

    static String jdbcUrl = "jdbc:mysql://localhost:3306/study";
    static String dbId = "root";
    static String dbPass = "1234qwer";

    public static void main(String[] args) {

        DriverManagerDataSource dataSource = new DriverManagerDataSource(jdbcUrl, dbId, dbPass);
        PlatformTransactionManager transactionManager = new DataSourceTransactionManager(dataSource);

        TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionDefinition());

        try {
            deleteInsertMember100(dataSource);
            System.out.println(100/0);
            updateMember100(dataSource);
            transactionManager.commit(status); //성공시 커밋
        } catch (Exception e) {
            transactionManager.rollback(status); //실패시 롤백
            e.printStackTrace();
        }
    }

    public static void deleteInsertMember100(DriverManagerDataSource dataSource) throws SQLException {

        //트랜잭션 동기화를 위해 DataSourceUtils 이용
        Connection con = DataSourceUtils.getConnection(dataSource);
        PreparedStatement pstmt = null;

        String sql1 = "DELETE FROM member WHERE id= 'id100' ";
        String sql2 = "INSERT INTO member VALUES('id100', 'name100', 100);";

        pstmt=con.prepareStatement(sql1);
        pstmt.executeUpdate();

        pstmt=con.prepareStatement(sql2);
        pstmt.executeUpdate();

        pstmt.close();
        //트랜잭션 동기화를 위해 DataSourceUtils 이용
        DataSourceUtils.releaseConnection(con, dataSource);
    }

    public static void updateMember100(DriverManagerDataSource dataSource) throws SQLException {

        //트랜잭션 동기화를 위해 DataSourceUtils 이용
        Connection con = DataSourceUtils.getConnection(dataSource);
        PreparedStatement pstmt = null;

        String sql = "UPDATE member SET age=999 WHERE id= 'id100';";

        pstmt=con.prepareStatement(sql);
        pstmt.executeUpdate();
        //트랜잭션 동기화를 위해 DataSourceUtils 이용
        DataSourceUtils.releaseConnection(con, dataSource);
    }

}
