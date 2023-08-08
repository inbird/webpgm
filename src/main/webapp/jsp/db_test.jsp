<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>

<h2>JDBC 직접 연결드라이버 테스트 </h2>

<%
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;


    try{
        //localhost:port/mysql database명칭
        String jdbcUrl = "jdbc:mysql://localhost:3306/study";
        //mysql user 및 password
        String dbId = "root";
        String dbPass = "1234qwer";

        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection(jdbcUrl,dbId ,dbPass );

        String sql= "SELECT id, name, age FROM member;";

        pstmt=conn.prepareStatement(sql);

        rs = pstmt.executeQuery();

        while(rs.next()){
            out.println( rs.getString("id") + "/");
            out.println( rs.getString("name") + "/");
            out.println( rs.getInt("age") + "<br><br>");
        }

        rs.close();
        pstmt.close();
        conn.close();

    }catch(Exception e){
        e.printStackTrace();
    }finally{
        if(pstmt != null)
            try{
                pstmt.close();
            }catch(Exception e){}
        if(conn != null)
            try{
                conn.close();
            }catch(Exception e){}
    }
%>