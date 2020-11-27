package cn.lyw.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Start {
  public static void main(String[] args) throws ClassNotFoundException, SQLException {
    // 导入驱动jar包
    // 注册驱动
    Class.forName("com.mysql.jdbc.Driver");
    // 获取数据库连接对象
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "mysqlLYW0903");
    // 定义sql语句
    String sql = "UPDATE student SET age = 200 WHERE id = 1";
    // 获取sql执行对象
    Statement stmt = conn.createStatement();
    // 执行sql
    int count = stmt.executeUpdate(sql);
    // 处理结果
    System.out.println(count);
    // 释放资源
    stmt.close();
    conn.close();
  }
}
