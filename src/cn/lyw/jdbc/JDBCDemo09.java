package cn.lyw.jdbc;

import cn.lyw.util.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * 通过键盘输入账号密码
 * 判断是否登录成功
 */

public class JDBCDemo09 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("请输入用户名:");
    String name = sc.nextLine();
    System.out.println("请输入密码:");
    String password = sc.nextLine();
    boolean flag = new JDBCDemo09().login(name, password);
    if (flag) {
      System.out.println("登录成功");
    } else {
      System.out.println("登录失败");
    }
  }

  public boolean login(String name, String password) {
    if (name == null || password == null) return false;
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    try {
      // 获取连接
      conn = JDBCUtils.getConnection();
      // 定义sql
      String sql = "SELECT * FROM user WHERE username = '" + name + "' and password = '" + password + "'";
      // 获取sql执行对象
      stmt = conn.createStatement();
      // 执行sql语句
      rs = stmt.executeQuery(sql);
      // 判断是否存在
      return rs.next();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      JDBCUtils.close(rs, stmt, conn);
    }
    return false;
  }
}
