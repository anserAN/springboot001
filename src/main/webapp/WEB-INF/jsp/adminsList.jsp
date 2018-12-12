<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	  <script type="text/javascript" src="${pageContext.request.contextPath}/static/easyui/jquery.min.js"></script>
	  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/easyui/themes/gray/easyui.css">
	  <link rel="stylesheet"  type="text/css" href="${pageContext.request.contextPath}/static/easyui/themes/icon.css">

	  <script type="text/javascript" src="${pageContext.request.contextPath}/static/easyui/jquery.easyui.min.js"></script>
	  <script type="text/javascript" src="${pageContext.request.contextPath}/static/easyui/locale/easyui-lang-zh_CN.js"></script>
  </head>
  
  <body>
  <table id="dg"></table>
  <form id="ff" method="post">
	  <div>
		  <input id="myname" class="easyui-validatebox" type="text" name="adminName" />
	  </div>
	  <a href="javascript:void(0);" class="easyui-linkbutton" onclick="query();">过滤</a>
  </form>


  <script >
     var datagrid= $('#dg').datagrid({
          url:'${pageContext.request.contextPath}/admins/dataGrid',
          columns:[[
              {field:'adminid',title:'用户id',width:100,sortable:true},
              {field:'adminName',title:'姓名',width:100},
              {field:'adminStatus',title:'状态',width:100,align:'right'}
          ]],
          pagination:true,
          sortName:"adminid",
          sortOrder:"asc",
          pageSize:15,
          pageList:[5,10,15,20]
      });

      function query(){
          datagrid.datagrid('load', {adminName:$("#myname").val()});
	  }



  </script>
  </body>

</html>
