package cn.lyw.jdbc;

/*
 * 执行DDL语句
 * */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo05 {
  public static void main(String[] args) {
    Connection conn = null;
    Statement stmt = null;
    try {
      // 注册驱动
      Class.forName("com.mysql.jdbc.Driver");
      // 连接数据库
      conn = DriverManager.getConnection("jdbc:mysql:///test", "root", "mysqlLYW0903");
      // 定义SQL
      String sql = "CREATE TABLE user (id INT, user VARCHAR(20), pass VARCHAR(20))";
      // 获取SQL执行对象
      stmt = conn.createStatement();
      // 执行SQL语句
      int count = stmt.executeUpdate(sql);
      // 处理结果
      System.out.println(count);
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      // 处理报错
      if (conn != null) {
        try {
          conn.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }

      if (stmt != null) {
        try {
          stmt.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
