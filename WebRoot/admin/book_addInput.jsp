<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>网上图书超市后台管理-图书管理-添加图书信息</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<link href="CSS/style.css" rel="stylesheet">
	<script src="JS/check.jsp"></script>

  </head>
  <script language="javascript">
function mycheck(){
	if (document.getElementById("bookISBN").value==""){
		alert("请输入书号！");document.getElementById("bookISBN").focus();return;
	}
	if (document.getElementById("bookName").value==""){
		alert("请输入图书名称！");document.getElementById("bookName").focus();return;
	}
	if (document.getElementById("bookAuthor").value==""){
		alert("请输入作者！");document.getElementById("bookAuthor").focus();return;
	}
	if (document.getElementById("bookType").value==""){
		alert("请输入类别！");document.getElementById("bookType").focus();return;
	}	
	if (document.getElementById("bookPublisher").value==""){
		alert("请输入出版社！");document.getElementById("bookPublisher").focus();return;
	}	
	if (document.getElementById("bookPrice").value==""){
		alert("请输入定价！");document.getElementById("bookPrice").focus();return;
	}	
	if (isNaN(document.getElementById("bookPrice").value)){
		alert("您输入的定价错误，请重新输入！");document.getElementById("bookPrice").value="";document.getElementById("bookPrice").focus();return;
	}		
	form1.submit();
}
</script>
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
        <td height="30" align="center" bgcolor="#eeeeee">≡≡≡ <a href="admin/book_list">图书管理</a> ≡≡≡</td>
      </tr>
    </table>
	<table width="100%" height="396"  border="0" cellpadding="0" cellspacing="0" class="tableBorder_LBR">
        <tr>
          <td width="26%" height="395" valign="top"><table width="100%"  border="0" cellspacing="-2" cellpadding="-2">
            <tr>
              <td width="55%" height="82" align="center" class="word_grey">&nbsp;<img src="Images/reg.gif" width="84" height="54"></td>
              <td width="45%" align="left" class="word_grey">添加图书信息</td>
            </tr>
            <tr>
              <td height="112" colspan="2" valign="top" class="word_grey"><ul>
                  <li> 书号：图书的ISBN，请务必输入正确，此项不能修改。</li>
                  <li>发行日期：请输入该书首次发行的日期，如2005年10月。</li>
                  <li>封面文件：请先将图书的封面文件保存到站点的manage\cover文件夹下，再输入文件名即可，包括扩展名，如：JSPxxxtkfaljx.jpg。</li>
                  <li>是否推荐：选择“是”该图书信息将显示在网站的首页中。</li>
                  <li>是否新书：选择“是”该图书信息将显示在“新书上架”中。</li>
                  </ul></td>
            </tr>
            <tr align="center">
              <td colspan="2" valign="middle" class="word_grey"></td>
            </tr>
          </table></td>
          <td width="5" valign="top" background="Images/Cen_separate.gif"></td>
          <td width="73%" valign="top"><table width="100%" height="56"  border="0" cellpadding="0" cellspacing="0">
            <tr>
              <td align="center">&nbsp;</td>
            </tr>
            <tr>
              <td align="center">
			  <form action="admin/book_add" method="post" name="form1">
			    <table width="100%"  border="0" align="center" cellpadding="-2" cellspacing="-2" bordercolordark="#FFFFFF">
                  <tr>
                    <td width="14%" height="27">&nbsp;书　　号：</td>
                    <td height="27">&nbsp;
                      <input name="book.ISBN" type="text" class="Sytle_text" id="bookISBN">
</td>
                    <td height="27">&nbsp;书　　名：</td>
                    <td height="27">&nbsp;
                          <input name="book.name" type="text" class="Style_upload" id="bookName">
                    </td>
                  </tr>
                  <tr>
                    <td height="27">&nbsp;作　　者：</td>
                    <td width="25%" height="27">&nbsp;
                          <input name="book.author" type="text" class="Style_upload" id="bookAuthor">
                    </td>
                    <td width="15%" height="27"> &nbsp;类别名称：</td>
                    <td width="46%" height="27">&nbsp;
                          <input name="book.bookType" type="text" class="Sytle_text" id="bookType">
                    </td>
                  </tr>
                  <tr>
                    <td height="27">&nbsp;出&nbsp;版&nbsp;社：</td>
                    <td height="27">&nbsp;
                          <input name="book.publisher" type="text" class="Style_upload" id="bookPublisher">
                    </td>
                    <td height="27">&nbsp;发行日期：</td>
                    <td height="27">&nbsp;
                          <input name="book.date" type="text" class="Sytle_text" id="bookDate">
                   </td>
                  </tr>
                  <tr>
                    <td height="41">&nbsp;封面文件：</td>
                    <td height="41">&nbsp;
                          <input name="book.img" type="text" class="Style_upload" id="bookImg">
                    </td>
                    <td height="41">&nbsp;价　　格：</td>
                    <td height="41">&nbsp;
                          <input name="book.price" type="text" class="Sytle_text" id="bookPrice">
      (元)</td>
                  </tr>
                  <tr>
                    <td height="45">&nbsp;是否推荐：</td>
                    <td>&nbsp; <input name="book.commend" type="radio" class="noborder" value="1" checked>
是
  <input name="book.commend" type="radio" class="noborder" value="0">
否</td>
                    <td>&nbsp;是否新书：</td>
                    <td><input name="book.newFlag" type="radio" class="noborder" value="1" checked>
是
  <input name="book.newFlag" type="radio" class="noborder" value="0">
否</td>
                  </tr>
                  <tr>
                    <td height="103">&nbsp;图书简介：</td>
                    <td colspan="3"><span class="style5">&nbsp; </span>
                        <textarea name="book.introduction" cols="60" rows="5" class="textarea" id="introduce"></textarea></td>
                  </tr>
                  <tr>
                    <td height="38" colspan="4" align="center">
                        <input name="Button" type="button" class="btn_grey" value="保存" onClick="mycheck()">
&nbsp;                        
<input name="Submit2" type="reset" class="btn_grey" value="重置">
                        &nbsp;
                        <input name="Submit3" type="button" class="btn_grey" value="返回" onClick="JScript:history.back()">
                    </td>
                  </tr>
                </table>
			  </form>
			  </td>
            </tr>
          </table></td>
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
