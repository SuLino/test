package org.example;



import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.apache.ibatis.session.SqlSession;
import org.example.dao.studentdao;
import org.example.entity.student;
import org.example.util.MyBatisUtil;
import org.junit.Test;

import java.io.File;
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
        SqlSession session = MyBatisUtil.getSession();
        studentdao mapper = session.getMapper(studentdao.class);
        //List<student> list = mapper.list1(3);
        List<student> list1 = mapper.list1(0,10);
        //Gson gson=new Gson();
        //System.out.println(gson.toJson(list));
        //ObjectMapper mapper1=new ObjectMapper();
        //mapper1.writeValue(new File("/a.txt"),list);
        //String s = mapper1.writeValueAsString(list);
        //System.out.println(s);
        list1.forEach(System.out::println);
        //session.close();

      }
    }
