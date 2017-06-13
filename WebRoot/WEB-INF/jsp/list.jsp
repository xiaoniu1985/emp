<%@ page language="java" contentType="text/html; charset=UTF-8"
   import="cn.itcast.domain.*"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
 <%@taglib prefix="f"   uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
  a{
 text-decoration: none;
 }
 
</style>
 <link rel="StyleSheet"  href="${pageContext.request.contextPath}/jstree/dtree.css"   type="text/css" /> 
 <script type="text/javascript" src="${pageContext.request.contextPath}/jstree/dtree.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/layer/layer.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/ckeditor/ckeditor.js"></script>

<script type="text/javascript">
$(document).ready(function(){

	
	
	  CKEDITOR.replace( 'editor01' );
///////////////////////////////////////
/* 	$("button:eq(0)").click(function(){
		$("form").submit();
	})  */
	
///////////////////////////////////////
 	$("#bd").click(function(){
	  $("#a").css("display","none");
		})  
		
///////////////////////////////////////	



$("#b3").click(function(){
	layer.open({
		  type: 2,
		  title:  ['文本', 'font-size:18px;'],
		  move: false,
	      area: ['380px'],
		  content: 'abc.action', //iframe的url
		  btn: ['重要','奇葩'], //按钮
		  skin: 'layui-layer-rim', 
	btn1: function(index, layero){
	
		var body = layer.getChildFrame('body', index);
		console.log(body.find("div").text())
	  },
	btn2: function(index, layero){
		 layer.close(index);
	  }
	  });
})
}) 
/////////////////////
</script>

</head>
<body>
张青 工
<div align="center">
<div>
<form action="${pageContext.request.contextPath}/findemp.action" method="post">
<table>
<tr><td>姓名：</td><td><input type="text" name="name"  value="${eo.name}"></td>&nbsp&nbsp&nbsp
<td>姓别：</td><td>
<input type="radio" name="Ssex" value="0"  <c:if test="${eo.sex==0}" >checked</c:if>    >男
<input type="radio" name="Ssex" value="1"  <c:if test="${eo.sex==1}" >checked</c:if>>女
<input type="radio" name="Ssex" value="-1"  <c:if test="${eo.sex==-1}" >checked</c:if>>无</td>
<td>工号：</td><td><input type="text" name="workcode"  value="${eo.workcode}"></td></tr>
<tr><td>最高工资 ：</td><td><input type="text" name="SHsalary"  value="${eo.SHsalary }"></td><td>最低工资 ：</td><td><input type="text" name="SLsalary"  value="${eo.SLsalary}"></td></tr>
</table>

</form>
<button id="bd">提交12</button>
<buttn>清空</button>
<button id="b3" >layer点击</button>
</div>
<% Employee emp2=new Employee();
//emp2=null;
request.setAttribute("xxy", emp2);

%>

<c:if test="${empty xxy }">xx</c:if>
<table width="600px" border="1px"  cellpadding="0"  cellspacing="0">
<tr><td>工号</td><td>姓名</td><td>姓别</td><td>入职日期</td><td>工资</td></tr>
<c:forEach items="${pe.beanList}"  var="emp">
<tr><td>${emp.workcode}</td><td>${emp.name}</td><td>${emp.sex==0?'男':'女'}</td><td title="摘要: maven-compiler-plugin 编译Java源码，
一般只需设置编译的jdk版本 或者在properties设置jdk版本 maven-dependency-plugin 用于复制依赖的jar包到指定的文件夹里 maven-jar-plugin 打成jar时，设定manifest的参数，比阅读全文摘要: maven-compiler-plugin 编译Java源码，
一般只需设置编译的jdk版本 或者在properties设置jdk版本 maven-dependency-plugin 
用于复制依赖的jar包到指定的文件夹里 maven-jar-plugin 打成jar时，设定manifest的参数，比阅读全文摘要: maven-compiler-plugin 编译Java源码，一般只需设置编译的jdk版本 或者在properties设置jdk版本 maven-dependency-plugin 
用于复制依赖的jar包到指定的文件夹里 maven-jar-plugin 打成jar时，设定manifest的参数，比阅读全文摘要: maven-compiler-plugin 编译Java源码，一般只
需设置编译的jdk版本 或者在properties设置jdk版本 maven-dependency-plugin 用于复制依赖的jar包到指定的文件夹里 maven-jar-plugin 打成jar时，
设定manifest的参数，比阅读全文" >
<f:formatDate value="${emp.hirdate}" pattern="yyyy-MM-dd"/>
</td><td>${emp.salary}</td></tr>
</c:forEach>
</table>
<div align="center">
<a href="<c:url value='/findemp?pc=1${pe.url}'></c:url>">首页</a>
<a href="<c:url value='/findemp?pc=${pe.pc-1>1?pe.pc-1:1}${pe.url}'></c:url>">上一页</a>
<c:forEach  var="i"  begin="${pe.begin}" end="${pe.end}" >
<a href="<c:url value='/findemp?pc=${i}${pe.url}'></c:url>">
<c:choose>
<c:when test="${i==pe.pc}">
<font color='red'>${i}</font>
</c:when>
<c:otherwise>${i}</c:otherwise>
</c:choose>
</a>
</c:forEach>
<a href="<c:url value='/findemp?pc=${pe.pc+1>pe.tp? pe.tp:pe.pc+1}${pe.url}'></c:url>">下一页</a>
<a href="<c:url value='/findemp?pc=${pe.tp}${pe.url}'></c:url>">尾页</a>
</div>
</div>

<form d="f2" action="${pageContext.request.contextPath}/abcd.action"  method="post">
<div ><textarea  name="editor01" rows="10" cols="50"></textarea></div>
<input type="submit" value="提交23" >
</form> 


<div><script type="text/javascript">
 

        d = new dTree('d');

       d.add(0,-1,'My example tree','','','','jstree/img/imgfolder.gif');
       d.add(1,0,'Node 1','');
       d.add(2,0,'Node 2','');
       d.add(3,1,'Node 1.1','');
       d.add(4,0,'Node 3','');      
       d.add(5,3,'Node 1.1.1','');      
       d.add(6,5,'Node 1.1.1.1','');
        d.add(7,0,'Node 4','example01.html');
        d.add(8,1,'Node 1.2','example01.html');
        d.add(13,8,'Node 1.2xx','example01.html');
         d.add(9,0,'My Pictures','example01.html','Pictures I\'ve taken over the years','','','jstree/img/imgfolder.gif');
        d.add(10,9,'The trip to Iceland','example01.html','Pictures of Gullfoss and Geysir');
         d.add(11,9,'Mom\'s birthday','example01.html');
        d.add(12,0,'Recycle Bin','example01.html','','','jstree/img/trash.gif');
        document.write(d);
 
  
    </script></div>


</body>
</html>
