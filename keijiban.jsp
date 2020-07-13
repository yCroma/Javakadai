<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%
List<String> chatarray = (List<String>)session.getAttribute("chatarray");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>１人番</title>
</head>
<body>
<h1>孤独の掲示板</h1>
<form action="/s1832057/Keijiban" method="POST">
	<input type="text" name="chat" size="40" value="">
	<input type="submit" name="action" value="送信">
</form>
<hr>
<form action="/s1832057/Keijiban" method="POST">
	<input type="submit" name="action" value="リセット">
</form>
<% if (chatarray != null) { %>

<table>
<% for (int i = 0; i < chatarray.size(); i++) { %>
<tr>
	<td><%= i+1 %></td>
	<td><%=	chatarray.get(i) %></td>
</tr>
<% } %>
</table>

<% } %>
<p>
以下の機能を追加しました。<br>
・リセット機能<br>
・表示時に何番目の投稿かわかるようになる機能<br>
・無記入投稿が追加されない機能<br>
</p>
</body>
</html>