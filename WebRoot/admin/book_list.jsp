<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<base href="<%=basePath%>">
<title>网上图书超市后台管理-图书管理</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache, must-revalidate">
	<meta http-equiv="expires" content="0">
	<link rel="stylesheet" type="text/css" href="CSS/style.css" />
	<script src="JS/check.jsp"></script>
</head>

<body>
<table width="100%"  border="0" cellspacing="0" cellpadding="0" background="Images/bg.gif">
  <tr>
    <td>
<table width="777" height="609"  border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
  <tr>
    <td valign="top">
	<jsp:include page="head.jsp"/>
	<table width="100%"  border="0" cellspacing="0" cellpadding="0" class="tableBorder_LTR">
      <tr>
        <td height="30" align="center" bgcolor="#eeeeee">≡≡≡ <span class="word_grey"><img alt="" src="Images/plus1.gif" width="18" height="18"><a href="admin/book_addInput.jsp">添加图书信息</a></img></span> ≡≡≡</td>
      </tr>
    </table>
	<table width="100%" height="396"  border="0" cellpadding="0" cellspacing="0" class="tableBorder_LBR">
        <tr>
          <td width="26%" height="395" valign="top"><table width="100%"  border="0" cellspacing="-2" cellpadding="-2">
            <tr>
              <td width="55%" height="82" align="center" class="word_grey">&nbsp;<img src="Images/reg.gif" width="84" height="54"></td>
              <td width="45%" align="left" class="word_grey">图书管理</td>
            </tr>
            <tr>
              <td height="112" colspan="2" valign="top" class="word_grey"><ul>
                <li> 添加图书信息：点击“添加图书信息”超链接可以进行图书信息的添加。</li>
                <li>修改图书信息：点击每条图书信息后面的“修改”按钮可以修改图书信息。</li>
                <li>删除图书信息：点击每条图书信息后面的“删除”按钮可以删除图书信息。</li>
                <li>推荐图书：如果想推荐图书，可以点击指定图书后的“修改”按钮。</li>
                <li>是否新书：如果想将图书信息发布到新书上架中，可以点击指定图书后的“修改”按钮。</li>
              </ul></td>
            </tr>
            <tr align="center">
              <td colspan="2" valign="middle" class="word_grey"></td>
            </tr>
          </table></td>
          <td width="5" valign="top" background="Images/Cen_separate.gif"></td>
          <td width="73%" valign="top"><table width="100%" height="14"  border="0" cellpadding="0" cellspacing="0">
            <tr>
              <td height="13" align="center">&nbsp;</td>
            </tr>
          </table>
            <table width="100%" height="48"  border="1" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bordercolordark="#CCCCCC" bordercolorlight="#FFFFFF">
              <hr>
              <tr>
                <td width="18%" height="27" align="center" class="tableBorder_B1">书号</td>
                <td width="36%" align="center" class="tableBorder_B1">名称</td>
                <td width="20%" align="center" class="tableBorder_B1">出版社</td>
                <td width="8%" align="center" class="tableBorder_B1">新书否</td>
                <td width="8%" align="center" class="tableBorder_B1">推荐否</td>
                <td width="5%" align="center" class="tableBorder_B1">修改</td>
                <td width="5%" align="center" class="tableBorder_B1">删除</td>
              </tr>

			<s:iterator value="books" var="book">
              <tr style="padding:5px;">
                <td height="24" align="center"><s:property value="#book.ISBN"/></td>
                <td align="center"><a href="admin/book_detail?book.id=<s:property value="#book.id"/>"><s:property value="#book.name"/></a></td>
                <td align="center"><s:property value="#book.publisher"/></td>
                <td align="center">
                  <s:if test="#book.newFlag==1">是</s:if>
                  <s:else>否</s:else>
                </td>
                <td align="center">
                  <s:if test="#book.commend==1">是</s:if>
                  <s:else>否</s:else>
                </td>
                <td align="center"><a href="admin/book_updateInput?book.id=<s:property value="#book.id"/>"><img src="Images/modify.gif" width="15" height="15"></a></td>
                <td align="center"><a href="admin/book_delete?book.id=<s:property value="#book.id"/>"><img src="Images/del.gif" width="16" height="16"></a></td>
              </tr>
             </s:iterator>

            </table>
<table width="100%"  border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td align="right">当前页数：[<%--Page--%>/<%--maxPage--%>]&nbsp;
	<%--if(Page>1){--%>
	<a href="index.jsp?Page=1">第一页</a>　<a href="index.jsp?Page=<%--Page-1--%>">上一页</a>
	<%--
	}
	if(Page<maxPage){
	--%>
	　<a href="index.jsp?Page=<%--Page+1--%>">下一页</a>　<a href="index.jsp?Page=<%--maxPage--%>">最后一页&nbsp;</a>
	<%--}
	--%>
	</td>
  </tr>
</table>			</td>
        </tr>
      </table>
      <jsp:include page="tail.jsp"/>
    </td>
  </tr>
</table>
</td>
  </tr>
</table>
<s:debug></s:debug>
</body>
</html>
