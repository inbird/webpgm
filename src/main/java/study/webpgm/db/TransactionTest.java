package study.webpgm.db;

import org.springframework.jdbc.support.JdbcUtils;

import java.sql.*;

public class TransactionTest {

    static String jdbcUrl = "jdbc:mysql://localhost:3306/study";
    static String dbId = "root";
    static String dbPass = "1234qwer";

    public static void main(String[] args) throws SQLException {

        Connection con = null;
        con = DriverManager.getConnection(jdbcUrl,dbId ,dbPass );

        try{

            deleteInsertMember100(con);
            updateMember100(con);

            con.close();

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(con != null)
                try{
                    con.close();
                }catch(Exception e){}
        }
    }

    public static void deleteInsertMember100(Connection con) throws SQLException {

        PreparedStatement pstmt = null;

        String sql1 = "DELETE FROM member WHERE id= 'id100' ";
        String sql2 = "INSERT INTO member VALUES('id100', 'name100', 100);";

        pstmt=con.prepareStatement(sql1);
        pstmt.executeUpdate();

        pstmt=con.prepareStatement(sql2);
        pstmt.executeUpdate();

        }

    public static void updateMember100(Connection con) throws SQLException {

        PreparedStatement pstmt = null;

        String sql = "UPDATE member SET age=999 WHERE id= 'id100';";

        pstmt=con.prepareStatement(sql);
        pstmt.executeUpdate();

    }

}
