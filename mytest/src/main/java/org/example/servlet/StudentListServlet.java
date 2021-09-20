package org.example.servlet;





import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.ibatis.session.*;
import org.example.entity.student;
import org.example.util.MyBatisUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
        SqlSession session = MyBatisUtil.getSession();
        String studentName = req.getParameter("studentName");
        String pageno = req.getParameter("pageNo");
        if (pageno!=null) {
            int pageNo = Integer.parseInt(pageno);
            show(req, resp, session, pageNo);
        }
        if(studentName!=null&&!studentName.equals(""))
        search(req, resp,session,studentName);
        MyBatisUtil.closeSession(session);
    }

    void search(HttpServletRequest req, HttpServletResponse resp,SqlSession session,String studentName) throws IOException {
        List<student> list;
        List<student> list2=new ArrayList<>();
        System.out.println(studentName);
        list=session.selectList("org.example.dao.studentdao.list1");
        for(int i=0;i<list.size();i++)
            if (list.get(i).getName().equals(studentName))
                list2.add(list.get(i));
        Gson gson = new Gson();
        String s = gson.toJson(list2);
        System.out.println(s);
        resp.getWriter().write(s);
    }

    void show(HttpServletRequest req, HttpServletResponse resp,SqlSession session,Integer pageNo) throws IOException {
        List<student> list;
        List<student> list2=new ArrayList<>();
        list=session.selectList("org.example.dao.studentdao.list1");
        for(int i=(pageNo-1)*10;i<pageNo*10;i++)
            if (i <list.size())
                list2.add(list.get(i));
        Gson gson = new Gson();
        String s = gson.toJson(list2);
        System.out.println(s);
        resp.getWriter().write(s);
    }
}
