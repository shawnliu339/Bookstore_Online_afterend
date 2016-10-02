<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<base href="<%=basePath%>">
<title>网上图书超市后台管理-留言簿管理</title>
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
        <td height="30" align="center" bgcolor="#eeeeee">≡≡≡ <span class="word_grey">留言簿管理</span> ≡≡≡</td>
      </tr>
    </table>
	<table width="100%" height="396"  border="0" cellpadding="0" cellspacing="0" class="tableBorder_LBR">
        <tr>
          <td width="26%" height="395" valign="top"><table width="100%"  border="0" cellspacing="-2" cellpadding="-2">
            <tr>
              <td width="55%" height="82" align="center" class="word_grey">&nbsp;<img src="Images/reg.gif" width="84" height="54"></td>
              <td width="45%" align="left" class="word_grey">留言簿管理</td>
            </tr>
            <tr>
              <td height="112" colspan="2" valign="top" class="word_grey"><ul>
                <li>查看留言簿信息：点击“留言簿主题”超链接可以进行留言簿信息的查看。</li>
                <li>回复留言簿信息：点击每条留言簿信息后面的“回复”按钮可以回复用户的留言。</li>
                <li>删除留言簿信息：点击每条留言簿信息后面的“删除”按钮可以删除留言簿信息。</li>
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
                <td width="18%" height="27" align="center" class="tableBorder_B1">留言日期</td>
                <td width="18%" align="center" class="tableBorder_B1">主题</td>
                <td width="38%" align="center" class="tableBorder_B1">内容</td>
                <td width="8%" align="center" class="tableBorder_B1">用户名</td>
                <td width="8%" align="center" class="tableBorder_B1">回复否</td>
                <td width="5%" align="center" class="tableBorder_B1">回复</td>
                <td width="5%" align="center" class="tableBorder_B1">删除</td>
              </tr>

			<s:iterator value="guestbooks" var="guestbook">
              <tr style="padding:5px;">
                <td height="24" align="center"><s:property value="#guestbook.date"/></td>
                <td align="center"><a href="admin/guestbook_detail?guestbook.id=<s:property value="#guestbook.id"/>"><s:property value="#guestbook.title"/></a></td>
                <td align="center"><s:property value="#guestbook.content"/></td>
                <td align="center"><s:property value="#guestbook.user.username"/></td>
                <td align="center">
                  <s:if test="#guestbook.replyFlag==1">是</s:if>
                  <s:else>否</s:else>
                </td>
                <td align="center"><a href="admin/guestbook_replyInput?guestbook.id=<s:property value="#guestbook.id"/>"><img src="Images/modify.gif" width="15" height="15"></a></td>
                <td align="center"><a href="admin/guestbook_delete?guestbook.id=<s:property value="#guestbook.id"/>"><img src="Images/del.gif" width="16" height="16"></a></td>
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
