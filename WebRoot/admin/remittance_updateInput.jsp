<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
	<base href="<%=basePath%>
	">
	<title>网上图书超市后台管理-汇款管理-订单汇款详细信息</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache, must-revalidate">
	<meta http-equiv="expires" content="0">
	<link rel="stylesheet" type="text/css" href="CSS/style.css" />
	<script src="JS/check.jsp"></script>
</head>

<body>
	<table width="100%" border="0" cellspacing="0" cellpadding="0"
		background="Images/bg.gif">
		<tr>
			<td>
				<table width="777" height="609" border="0" align="center"
					cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
					<tr>
						<td valign="top">
							<jsp:include page="head.jsp" />
							<table width="100%" border="0" cellspacing="0" cellpadding="0"
								class="tableBorder_LTR">
								<tr>
									<td height="30" align="center" bgcolor="#eeeeee">
										≡≡≡
										<a href="admin/remittance_list">汇款管理</a>
										≡≡≡
									</td>
								</tr>
							</table>
							<table width="100%" height="396" border="0" cellpadding="0"
								cellspacing="0" class="tableBorder_LBR">
								<tr>
									<td width="26%" height="395" valign="top">
										<table
											width="100%" border="0" cellspacing="-2" cellpadding="-2">
											<tr>
												<td width="55%" height="82" align="center" class="word_grey">
													&nbsp;
													<img src="Images/reg.gif" width="84" height="54"></td>
												<td width="45%" align="left" class="word_grey">汇款详细信息</td>
											</tr>
											<tr>
												<td height="112" colspan="2" valign="top" class="word_grey">
													<ul>
														<li>查看汇款信息：点击“订单号”超链接可以查询订单及汇款的详细信息。</li><br>
														<li>修改汇款信息：点击每条订单后面的“修改”按钮可以修改订单及汇款的详细信息。</li><br>
														<li>取消汇款信息：点击每条订单信息后面的“取消”按钮可以取消该笔交易。</li><br>
														<li>汇款日期：汇款日期为管理员收到汇款的日期，如果日期尚未填写，则默认为当前时间。填写格式应为：年-月-日(空格)时:分:秒。</li><br>
														<li>汇款金额：汇款金额如果尚未填写，则默认为该笔交易的实际金额，管理员可根据实际情况修改汇款金额。</li><br>
													</ul>
												</td>
											</tr>
											<tr align="center">
												<td colspan="2" valign="middle" class="word_grey"></td>
											</tr>
										</table>
									</td>
									<td width="5" valign="top"
										background="Images/Cen_separate.gif"></td>
									<td width="73%" valign="top">
										<table width="100%"
											height="56" border="0" cellpadding="0" cellspacing="0">
											<tr>
												<td align="center">&nbsp;</td>
											</tr>
											<tr>
												<td align="center">
													<form action="admin/remittance_update" method="post" name="form1">
													<table width="100%" height="350"  border="0" cellpadding="0" cellspacing="0" class="tableBorder_B1">
														<tr>
															<td width="16%">订 单 号：&nbsp;${requestScope.order.id }</td>
															<td><input name="order.id" type="text" hidden="hidden" value="<s:property value="order.id"/>"></td>
														</tr>
														<tr>
															<td>真实姓名：&nbsp;${requestScope.order.truename }</td>
														</tr>
														<tr>
															<td>
																地&nbsp;&nbsp;&nbsp;&nbsp;址：&nbsp;${requestScope.order.address }
															</td>
														</tr>
														<tr>
															<td>邮政编码：&nbsp;${requestScope.order.ZIP }</td>
														</tr>
														<tr>
															<td>电&nbsp;&nbsp;&nbsp;&nbsp;话：&nbsp;${requestScope.order.tel }</td>
														</tr>
														<tr>
															<td>Email&nbsp;&nbsp;&nbsp;：&nbsp;${requestScope.order.email }</td>
														</tr>
														<tr>
															<td>付款方式：&nbsp;${requestScope.order.payType }</td>
														</tr>
														<tr>
															<td>运送方式：&nbsp;${requestScope.order.delivery }</td>
														</tr>
														<tr>
															<td>订单日期：&nbsp;${requestScope.order.date }</td>
														</tr>
														<tr>
															<td>备&nbsp;&nbsp;&nbsp;&nbsp;注：&nbsp;${requestScope.order.memo }</td>
														</tr>
														<tr>
															<td>
																汇款日期：<input name="order.sale.date" type="text" value="<s:property value="order.sale.date"/>">
															</td>
														</tr>
														<tr>
															<td>
																汇款金额：<input name="order.sale.money" type="text" value="<s:property value="order.sale.money"/>">(元)
															</td>
														</tr>
														<tr>
															<td>
																订单状态：<select name="order.state" class="textarea">
																	<option value="0" <s:if test="order.state==0">selected="selected"</s:if>>交易取消</option>
																	<option value="1" <s:if test="order.state==1">selected="selected"</s:if>>等待买家付款</option>
																	<option value="2" <s:if test="order.state==2">selected="selected"</s:if>>等待卖家发货</option>
																	<option value="3" <s:if test="order.state==3">selected="selected"</s:if>>等待确认收货</option>
																	<option value="4" <s:if test="order.state==4">selected="selected"</s:if>>交易完成</option>
																</select>
															</td>
														</tr>
													</table>
												</form>
												<table width="100%"  border="0" cellpadding="0" cellspacing="0" class="tableBorder_B1">
													<tr align="center" bgcolor="#eeeeee">
														<td width="16%" height="27">图书ISBN号</td>
														<td width="39%">图书名称</td>
														<td width="20%">出版社</td>
														<td width="9%">单价</td>
														<td width="7%">数量</td>
														<td width="9%">金额</td>
													</tr>
													<s:iterator value="order.odrDtls" var="orderDetail">
														<tr align="center">
															<td height="27">
																<s:property value="#orderDetail.book.ISBN"/>
															</td>
															<td>
																<s:property value="#orderDetail.book.name"/>
															</td>
															<td>
																<s:property value="#orderDetail.book.publisher"/>
															</td>
															<td><s:property value="#orderDetail.book.price"/>(元)</td>
															<td>
																<s:property value="#orderDetail.amount"/>
															</td>
															<td><s:property value="#orderDetail.money"/>(元)</td>
														</tr>
													</s:iterator>
													<tr>
														<td height="38" colspan="4" align="center">
															<input name="Button" type="button" class="btn_grey" value="修改" onClick="form1.submit()">
															&nbsp;
															<input name="Submit2" type="reset" class="btn_grey" value="重置">
															&nbsp;
															<input name="Submit3" type="button" class="btn_grey" value="返回" onClick="JScript:history.back()"></td>
													</tr>
												</table>
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
						<jsp:include page="tail.jsp" />
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
<s:debug></s:debug>
</body>
</html>