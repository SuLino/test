package org.example.servlet;





import com.google.gson.Gson;
import org.apache.ibatis.session.*;
import org.example.dao.studentdao;
import org.example.entity.student;
import org.example.util.MyBatisUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * @author admin
 * @version 1.0 <br/>
 * <p style="font-family:SimSun;font-weight:bold">时间:<br/>2021/9/19 10:25</p>
 * @description
 */
public class StudentListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        String pageTotal="page";
        SqlSession session = MyBatisUtil.getSession();
        String studentName = req.getParameter("studentName");
        String pageno = req.getParameter("pageNo");
        pageTotal= req.getParameter("pageTotal");
        if (pageno!=null) {
            int pageNo = Integer.parseInt(pageno);
            show(resp, session, pageNo);
        }
        if(studentName!=null&&!studentName.equals(""))
        search(resp,session,studentName);
        if(pageTotal!=null&&pageTotal.equals("pagetotal"))
            getPage(resp,session);
        MyBatisUtil.closeSession(session);
    }

    void getPage(HttpServletResponse resp,SqlSession session) throws IOException {
        studentdao mapper = session.getMapper(studentdao.class);
        int count = mapper.count();
        if(count%10>0)
            count=count/10+1;
        else count/=10;
        resp.getWriter().print(count);
    }
    void search(HttpServletResponse resp,SqlSession session,String studentName) throws IOException {
        studentdao mapper= session.getMapper(studentdao.class);
        List<student> list=mapper.list2(studentName);
        Gson gson = new Gson();
        String s = gson.toJson(list);
        resp.getWriter().write(s);
        resp.getWriter().flush();
    }

    void show(HttpServletResponse resp,SqlSession session,Integer pageNo) throws IOException {
        studentdao mapper = session.getMapper(studentdao.class);
        pageNo=(pageNo-1)*10;
        List<student> list = mapper.list1(pageNo, 10);
        Gson gson = new Gson();
        String s = gson.toJson(list);
        resp.getWriter().write(s);
    }
}
