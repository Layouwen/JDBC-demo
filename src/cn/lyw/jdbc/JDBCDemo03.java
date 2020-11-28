package cn.lyw.jdbc;

/*
 * student表 修改记录
 * */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo03 {
  public static void main(String[] args) {
    Connection conn = null;
    Statement stmt = null;
    try {
      // 注册驱动
      Class.forName("com.mysql.jdbc.Driver");
      // 获取数据库连接对象
      conn = DriverManager.getConnection("jdbc:mysql:///test", "root", "mysqlLYW0903");
      // 定义sql语句
      String sql = "UPDATE student SET age = 25 WHERE name = '梁文文'";
      // 获取sql执行对象
      stmt = conn.createStatement();
      // 执行sql
      int count = stmt.executeUpdate(sql);
      // 处理结果
      System.out.println(count);
      if (count > 0) {
        System.out.println("修改成功！");
      } else {
        System.out.println("修改失败！");
      }
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      // 释放资源
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
