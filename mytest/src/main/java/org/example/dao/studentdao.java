package org.example.dao;

import org.example.entity.student;

import java.util.List;

/**
 * @author admin
 * @version 1.0 <br/>
 * <p style="font-family:SimSun;font-weight:bold">时间:<br/>2021/9/18 15:45</p>
 * @description
 */
public interface studentdao {
    //查询一个学生
     void add(student s);
    // name 为要模糊查找的学生姓名，pageNo 为页号，pageSize 为每页行数
     List<student> list1(String name, int pageNo, int pageSize);
    List<student> list2(int pageNo,int pageSize);
    int count();
}
