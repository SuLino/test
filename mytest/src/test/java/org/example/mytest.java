package org.example;



import com.google.gson.Gson;
import org.apache.ibatis.session.SqlSession;
import org.example.entity.student;
import org.example.util.MyBatisUtil;
import org.junit.Test;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author admin
 * @version 1.0 <br/>
 * <p style="font-family:SimSun;font-weight:bold">时间:<br/>2021/9/18 16:44</p>
 * @description
 */
public class mytest {
    @Test
    public void testMybatis() throws IOException, ParseException {
        int pagetotal=1;
        Integer count = 0;
        SqlSession session = MyBatisUtil.getSession();
        List<student> list=new ArrayList<>();
        List<student> list2=new ArrayList<>();
        if (session != null) {
            count = session.selectOne("org.example.dao.studentdao.count");
            list=session.selectList("org.example.dao.studentdao.list2");
            MyBatisUtil.closeSession(session);
        }
        //int pageNo=1;
        /*for(int i = 0; i<10; i++) {
            if (i <list.size())
                list2.add(list.get(i));
        }*/
        list.forEach(System.out::println);
        //String s = new Gson().toJson(list2);
        //System.out.println(s);
        //        for(int i=0;i< list2.size();i++)
        //{
        //    System.out.print(list2.get(i).getId());
        //    System.out.println(list2.get(i).getName());
        //}
        if(count%10!=0)
            pagetotal=count/10+1;
        else pagetotal=count/10;
        System.out.println(pagetotal);
        }
    }
