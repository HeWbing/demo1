<%@ page language="java"  import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.hwb.servlet.CounterServlet" %>
<%
    CounterServlet CountFileHandler=new CounterServlet();//创建对象
    int count=0;
    if(application.getAttribute("count")==null){
        count=CountFileHandler.readFile(System.getProperty("user.dir")+"count.txt");//读取文件获取数据赋给count
        application.setAttribute("count",new Integer(count));
    }
    count=(Integer)application.getAttribute("count");
    if(session.isNew()) ++count;
    application.setAttribute("count",count);
    CountFileHandler.writeFile(request.getRealPath("/")+"count.txt",
            count);//更新文件记录
%>
<html>
<body>
<h2>Hello World!</h2>
<h2>你是第 <%=count%> 位访问</h2>
</body>
</html>
