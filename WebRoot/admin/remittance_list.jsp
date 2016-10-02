<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<base href="<%=basePath%>">
<title>网上图书超市后台管理-汇款管理</title>
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
        <td height="30" align="center" bgcolor="#eeeeee">≡≡≡ <span class="word_grey">汇款管理</span> ≡≡≡</td>
      </tr>
    </table>
	<table width="100%" height="396"  border="0" cellpadding="0" cellspacing="0" class="tableBorder_LBR">
        <tr>
          <td width="26%" height="395" valign="top"><table width="100%"  border="0" cellspacing="-2" cellpadding="-2">
            <tr>
              <td width="55%" height="82" align="center" class="word_grey">&nbsp;<img src="Images/reg.gif" width="84" height="54"></td>
              <td width="45%" align="left" class="word_grey">汇款管理</td>
            </tr>
            <tr>
              <td height="112" colspan="2" valign="top" class="word_grey"><ul>
                <li>查看汇款信息：点击“订单号”超链接可以查询订单及汇款的详细信息。</li>
                <li>修改汇款信息：点击每条订单后面的“修改”按钮可以修改订单及汇款的详细信息。</li>
                <li>取消汇款信息：点击每条订单信息后面的“取消”按钮可以取消该笔交易。</li>
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
                <td width="8%" height="27" align="center" class="tableBorder_B1">订单号</td>
                <td width="15%" align="center" class="tableBorder_B1">订单状态</td>
                <td width="13%" align="center" class="tableBorder_B1">用户名</td>
                <td width="9%" align="center" class="tableBorder_B1">付款方式</td>
                <td width="18%" align="center" class="tableBorder_B1">付款日期</td>
                <td width="5%" align="center" class="tableBorder_B1">修改</td>
                <td width="5%" align="center" class="tableBorder_B1">取消</td>
              </tr>

			<s:iterator value="orders" var="order">
              <tr style="padding:5px;">
                <td height="24" align="center">
                  <a href="admin/remittance_detail?order.id=<s:property value="#order.id"/>">
                    <s:property value="#order.id"/>
                  </a>
                </td>
                <td align="center">
                  <s:if test="#order.state==0">交易取消</s:if>
                  <s:elseif test="#order.state==1">等待买家付款</s:elseif>
                  <s:elseif test="#order.state==2">等待卖家发货</s:elseif>
                  <s:elseif test="#order.state==3">等待确认收货</s:elseif>
                  <s:elseif test="#order.state==4">交易完成</s:elseif>
                </td>
                <td align="center"><s:property value="#order.username"/></td>
                <td align="center"><s:property value="#order.payType"/></td>
                <td align="center">
                  <s:property value="#order.sale.date"/>
                </td>
                <td align="center"><a href="admin/remittance_updateInput?order.id=<s:property value="#order.id"/>"><img src="Images/modify.gif" width="15" height="15"></a></td>
                <td align="center"><a href="admin/remittance_cancel?order.id=<s:property value="#order.id"/>"><img src="Images/del.gif" width="16" height="16"></a></td>
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
