<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<base href="<%=basePath%>">
<title>网上图书超市</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache, must-revalidate">
	<meta http-equiv="expires" content="0">
	<link rel="stylesheet" type="text/css" href="CSS/style.css" />
<script src="JS/check.jsp"></script>
</head>

<body>
<table width="100%"  border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="6" colspan="2" bgcolor="#81CF00"></td>
      </tr>
      <tr>
        <td width="28%" height="70"><img src="Images/index_ht.gif" width="221" height="58"></td>
        <td width="72%" valign="top"><table width="100%" height="35"  border="0" cellpadding="0" cellspacing="0">
          <tr align="center">
            <td rowspan="2" valign="bottom">&nbsp;</td>
            <td height="22" valign="bottom"><a href="admin/book_list">图书管理</a></td>
            <td width="1" rowspan="2" valign="top"><img src="Images/Nav_separate.gif" width="1" height="36"></td>
            <td valign="bottom"><a href="admin/remittance_list">汇款管理</a></td>
            <td width="1" rowspan="2" valign="top"><img src="Images/Nav_separate.gif" width="1" height="36"></td>
            <td valign="bottom"><a href="admin/stock_list">库存管理</a></td>
            <td width="1" rowspan="2" valign="top"><img src="Images/Nav_separate.gif" width="1" height="36"></td>
            <td valign="bottom"><a href="admin/guestbook_list">留言簿管理</a></td>
            <td width="1" rowspan="2" valign="top"><img src="Images/Nav_separate.gif" width="1" height="36"></td>
            <td valign="bottom"><a href="pollManage.jsp">销量排行</a></td>
            <td width="1" rowspan="2" valign="top"><img src="Images/Nav_separate.gif" width="1" height="36"></td>
            <td valign="bottom">&nbsp;<a href="admin/login!logout">退出</a>&nbsp;</td>
          </tr>
          <tr align="center">
            <td height="13"><a href="admin/book_list">Books Manage</a></td>
            <td><a href="admin/remittance_list">Remittance Manage</a></td>
            <td><a href="orderManage.jsp">Stock Manage</a></td>
            <td><a href="admin/guestbook_list">Guestbook Manage </a></td>
            <td><a href="pollManage.jsp">Sales Ranking </a></td>
            <td>&nbsp;<a href="adminLogout.action">Quit</a>&nbsp;</td>
          </tr>
        </table></td>
      </tr>
    </table>
</body>
</html>