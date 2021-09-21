package org.example.entity;


import java.sql.Date;

/**
 * @author admin
 * @version 1.0 <br/>
 * <p style="font-family:SimSun;font-weight:bold">时间:<br/>2021/9/18 15:39</p>
 * @description 学生实体类
 */
public class student {
    private Integer id;
    private String name;
    private java.sql.Date birth;
    private  Integer clazzId;
    private String Cname;


    public student() {
    }

    public student(Integer clazzId) {
        this.clazzId = clazzId;
    }

    public student(Integer id, String name, Date birth, Integer clazzId, String cname) {
        this.id = id;
        this.name = name;
        this.birth = birth;
        this.clazzId = clazzId;
        this.Cname = cname;
    }

    public student(Integer id, String name, Date birth, Integer clazzId) {
        this.id = id;
        this.name = name;
        this.birth = birth;
        this.clazzId = clazzId;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Integer getClazzId() {
        return clazzId;
    }

    public void setClazzId(Integer clazzId) {
        this.clazzId = clazzId;
    }

    public String getCname() {
        return Cname;
    }

    public void setCname(String cname) {
        this.Cname = cname;
    }

    @Override
    public String toString() {
        return "student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birth=" + birth +
                ", clazzId=" + clazzId +
                ", Cname='" + Cname +
                '}';
    }
}
