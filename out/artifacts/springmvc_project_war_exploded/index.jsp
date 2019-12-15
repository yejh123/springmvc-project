<%--
  Created by IntelliJ IDEA.
  User: yejh
  Date: 2019/11/21
  Time: 20:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <a href="hello">helloWorld</a>
  <hr/>
  <h1>RequestMapping测试</h1>
  <a href="user/admin">PathVariable</a>
  <hr/>
  <h1>REST测试</h1>
  <form action="book/1" method="get">
    <input type="submit" value="查询1号图书"/>
  </form>
  <form action="book" method="post">
    <input type="submit" value="添加1号图书"/>
  </form>
  <form action="book/1" method="post">
    <input name="_method" value="delete">
    <input type="submit" value="删除1号图书"/>
  </form>
  <form action="book/1" method="post">
    <input name="_method" value="put">
    <input type="submit" value="更新1号图书"/>
  </form>
  <hr/>
  <h1>传入参数测试</h1>
  <a href="params">RequestParamsTest</a><br/>
  <form action="book" method="post">
    书名<input type="text" name="bookName"><br/>
    作者<input type="text" name="author"><br/>
    价格<input type="text" name="price"><br/>
    出版社名称<input type="text" name="publisher.publisherName"><br/>
    出版社地址<input type="text" name="publisher.address"><br/>
    <input type="submit" value="添加图书">
  </form>
  <hr/>
  <h1>output测试</h1>
  <ul>
    <li><a href="output/map">map</a></li>
    <li><a href="output/model">model</a></li>
    <li><a href="output/modelMap">modelMap</a></li>
  </ul>

  </body>
</html>
