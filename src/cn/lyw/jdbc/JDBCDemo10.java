package cn.lyw.jdbc;

import cn.lyw.util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCDemo10 {
  public static void main(String[] args) {
    Connection conn = null;
    PreparedStatement pstmt1 = null;
    PreparedStatement pstmt2 = null;
    try {
      // 连接数据库
      conn = JDBCUtils.getConnection();
      // 开启事务
      conn.setAutoCommit(false);
      // 定义sql
      String sql1 = "UPDATE student SET age = age - ? WHERE id = ?";
      String sql2 = "UPDATE student SET age = age + ? WHERE id = ?";
      // 获取sql执行对象
      pstmt1 = conn.prepareStatement(sql1);
      pstmt2 = conn.prepareStatement(sql2);
      pstmt1.setInt(1, 50);
      pstmt1.setInt(2, 1);

      pstmt2.setInt(1, 50);
      pstmt2.setInt(2, 2);
      // 执行sql对象
      pstmt1.executeUpdate();
      pstmt2.executeUpdate();
      // 提交事务
      conn.commit();
    } catch (Exception e) {
      // 回滚事务
      try {
        if (conn != null) conn.rollback();
      } catch (SQLException e1) {
        e1.printStackTrace();
      }
      e.printStackTrace();
    } finally {
      JDBCUtils.close(pstmt1, conn);
      JDBCUtils.close(pstmt2, null);
    }
  }
}
