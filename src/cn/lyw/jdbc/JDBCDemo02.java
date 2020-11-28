package cn.lyw.jdbc;

/*
 * student 添加一条记录 insert 语句
 * */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo02 {
  public static void main(String[] args) {
    Statement stmt = null;
    Connection conn = null;
    try {
      // 注册驱动
      Class.forName("com.mysql.jdbc.Driver");
      // 定义sql
      String sql = "INSERT INTO student VALUES(null, '梁文文', 300)";
      // 获取 Connection对象
      conn = DriverManager.getConnection("jdbc:mysql:///test", "root", "mysqlLYW0903");
      // 获取sql执行对象
      stmt = conn.createStatement();
      // 执行sql
      int count = stmt.executeUpdate(sql);
      // 处理结果
      System.out.println(count);
      if (count > 0) {
        System.out.println("添加成功!");
      } else {
        System.out.println("添加失败!");
      }
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      // 释放资源
      // 避免空指针异常
      if (stmt != null) {
        try {
          stmt.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }

      if (conn != null) {
        try {
          conn.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
