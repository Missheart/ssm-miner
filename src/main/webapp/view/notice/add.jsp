<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/6/13
  Time: 14:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加热门资讯</title>
</head>
<body>
<form id="addNotice" action="<%=application.getContextPath()%>/notice/add" onsubmit="return false;">
    <input type="text" name="title" placeholder="标题">
    <input type="text" name="content" placeholder="内容">
    <input type="text" name="postDate" placeholder="发布时间">
    <input type="text" name="contentStateValue" placeholder="状态">
    <input type="submit" value="提交" class="addNotice">
</form>
</body>
</html>
<script src="<%=application.getContextPath()%>/mg/js/jquery.js"></script>
<script>
    $(".addNotice").click(function () {
        $sub = $("#addNotice");
        var url = $sub.attr("action");
        $.post(url, $sub.serialize(), function (res) {
            if (res.code == 0){
                alert("成功");
                location.href="<%=application.getContextPath()%>/notice/index";
            }else{
                alert("失败");
            }
        });
    })
</script>
