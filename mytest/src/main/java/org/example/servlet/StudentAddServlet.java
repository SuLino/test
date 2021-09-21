package org.example.servlet;


import org.apache.ibatis.session.SqlSession;
import org.example.dao.studentdao;
import org.example.entity.student;
import org.example.util.MyBatisUtil;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.Random;

/**
 * @author admin
 * @version 1.0 <br/>
 * <p style="font-family:SimSun;font-weight:bold">时间:<br/>2021/9/19 10:12</p>
 * @description
 */
public class StudentAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");
        SqlSession session = MyBatisUtil.getSession();
        studentdao mapper= session.getMapper(studentdao.class);
        int count=mapper.count();
        Random random = new Random();
        for(int i=1;i<=10;i++){
            int i1 = random.nextInt(i+10);
            student s=new student(count+i,"学生"+(i1+1),new Date(70+i1%10+i, i, 10+i),i%4+1);
            mapper.add(s);
            session.commit();
        }

        if(count%10>0)
            count=count/10+2;
        else count=count/10+1;
        System.out.println(count);
        MyBatisUtil.closeSession(session);
        resp.getWriter().print(count);
    }
}
