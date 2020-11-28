package cn.lyw.jdbc;

/*
 * student表 删除一条记录
 * */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo04 {
  public static void main(String[] args) {
    Connection conn = null;
    Statement stmt = null;
    try {
      // 注册驱动
      Class.forName("com.mysql.jdbc.Driver");
      // 连接数据库
      conn = DriverManager.getConnection("jdbc:mysql:///test", "root", "mysqlLYW0903");
      // 定义sql
      String sql = "DELETE FROM student WHERE name = '梁文文'";
      // 获取sql执行对象
      stmt = conn.createStatement();
      // 执行sql执行对象
      int count = stmt.executeUpdate(sql);
      // 处理报错
      System.out.println(count);
      if (count > 0) {
        System.out.println("删除成功！");
      } else {
        System.out.println("删除失败！");
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
