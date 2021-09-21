<%@ page import="org.example.entity.student" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2021/9/19
  Time: 10:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
<style type="text/css">
    table{
        border-collapse:collapse;
    }
    table,td{
        border:1px solid black;
    }
    td{
        width: 500px;
        height: 10px;
        text-align: center;
    }
    .span{
        float: right;
    }
    #btn1{
        float: right;
    }

</style>
    <script type="text/javascript" src="jquery.js"></script>
    <script type="text/javascript">


    $(function(){
            $.get("http://localhost:8080/sls",{pageNo: "1"}, function (data) {showForm(data)},"json")
        $.get("http://localhost:8080/sls",{pageTotal: "pagetotal"}, function (data) {createButton(data)})
        })
    function a(i) {
        // $("#"+i).css("background-color","#056bd9");
        $.get("http://localhost:8080/sls",{pageNo: i}, function (data) {showForm(data)},"json")
    }
    function createButton(data) {
        for (let i=1; i<=data; i++){
            let btn='<button id="'+i+'" onclick="a('+i+')">'+i+'</button>'
            $(".span").append(btn)
        }
        // let btn='<button id="2" onclick="a(2)">'+i+'</button>'
    }
        function showForm(data){
        $("#tableS tr:not(:first)").empty();
            for (let i=0; i<data.length; i++) {
                    let tr = '<td>' + data[i].id + '</td>' + '<td>' + data[i].name + '</td>'
                        + '<td>' + data[i].birth + '</td>' + '<td>' + data[i].Cname + '</td>';
                    $("#tableS").append('<tr>' + tr + '</tr>')
                }
            }
    function submits() {
        $.get("http://localhost:8080/sdt",function (data) {
            if (data==="非法操作"){
                alert("非法操作")
            }else {
                let btn = '<button id="' + data + '" onclick="a(' + data + ')">' + data + '</button>'
                $(".span").append(btn)
            }
        })

    }
    function ck() {
        let val = $("#txt").val();
        $.get("http://localhost:8080/sls",{studentName: val}, function (data) {showForm(data)},"json")
    }
    </script>
</head>
<body>
<span>
    <label>
        <input id="txt" type="text" name="studentName" placeholder="按姓名查询..."/>
    </label>

    <button id="btn2" onclick="ck()">查询</button>
    <button id="btn1" type="button" onclick="submits()">新增10个学生</button>
</span>
    <br/><br/>

    <table id="tableS">
        <tr>
            <td>id</td>
            <td>姓名</td>
            <td>生日</td>
            <td>班级</td>
        </tr>

    </table>
<br/>
<span class="span">
</span>
</body>
</html>

