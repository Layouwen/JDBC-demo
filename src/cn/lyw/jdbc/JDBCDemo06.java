package cn.lyw.jdbc;

/*
 * 执行查询语句
 * */

import java.sql.*;

public class JDBCDemo06 {
  public static void main(String[] args) {
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    try {
      // 注册驱动
      Class.forName("com.mysql.jdbc.Driver");
      // 连接数据库
      conn = DriverManager.getConnection("jdbc:mysql:///test", "root", "mysqlLYW0903");
      // 定义SQL
      String sql = "SELECT * FROM student";
      // 获取SQL执行对象
      stmt = conn.createStatement();
      // 执行SQL语句
      rs = stmt.executeQuery(sql);
      // 处理结果
      // 1.向下移动一行
      rs.next();
      // 2.获取数据
      String name = rs.getString("name");
      int age = rs.getInt("age");
      System.out.println(name + "----" + age);
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

      if (rs != null) {
        try {
          rs.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
