package cn.lyw.jdbc;

import cn.lyw.domain.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCDemo08 {
  public static void main(String[] args) {
    List<Student> list = new JDBCDemo08().findAll();
    System.out.println(list);
    System.out.println(list.size());
    for (Student stu : list) {
      System.out.println(stu.getName());
    }
  }

  /**
   * 查询所有Student对象
   *
   * @return
   */
  public List<Student> findAll() {
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    List<Student> list = null;
    try {
      // 注册驱动
      Class.forName("com.mysql.jdbc.Driver");
      // 获取连接
      conn = DriverManager.getConnection("jdbc:mysql:///test", "root", "mysqlLYW0903");
      // 定义sql
      String sql = "SELECT * FROM student";
      // 创建sql执行对象
      stmt = conn.createStatement();
      // 执行sql
      rs = stmt.executeQuery(sql);
      // 处理结果
      Student student = null;
      list = new ArrayList<Student>();
      while (rs.next()) {
        // 获取数据
        int id = rs.getInt("id");
        String name = rs.getString("name");
        int age = rs.getInt("age");
        // 创建Student对象
        student = new Student();
        student.setId(id);
        student.setName(name);
        student.setAge(age);
        // 装载集合
        list.add(student);
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

      if (rs != null) {
        try {
          rs.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
    }
    return list;
  }
}
