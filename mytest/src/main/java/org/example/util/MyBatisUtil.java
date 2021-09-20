package org.example.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.awt.image.Raster;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author admin
 * @version 1.0 <br/>
 * <p style="font-family:SimSun;font-weight:bold">时间:<br/>2021/9/19 12:30</p>
 * @description
 */
public class MyBatisUtil {
    private static SqlSessionFactory Factory=null;

    static {
        String resource="mybatis-config.xml";
        try {
            InputStream ras = Resources.getResourceAsStream(resource);
            Factory=new SqlSessionFactoryBuilder().build(ras);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static SqlSession getSession() {
        SqlSession session=null;
        if(Factory!=null)
            session=Factory.openSession();
        return session;
    } // 得到 SqlSession 对象
    public static void closeSession(SqlSession session) {
        session.close();
    } // 释放 SqlSession 对象
}
