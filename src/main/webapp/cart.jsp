<%@ page import="com.example.lab03_assignment.CartBean" %>
<%@ page import="com.example.lab03_assignment.Item" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.example.lab03_assignment.Database" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Cart</title>
</head>
<body>
<h1>Cart</h1>
<form action="CartServlet" method="get">
  <%
    CartBean cartBean = (CartBean) session.getAttribute("cart");
    for (Map.Entry<Integer, Integer> entry: cartBean.items.entrySet()) {
      Item item = Database.getItem(entry.getKey());
      int count = entry.getValue();
  %>
    <img src="<%=request.getContextPath()%><%=item.image%>" width="50" />
    <button type="submit" value="<%=item.id%>" name="-">-</button>
     <%=count%>
    <button type="submit" value="<%=item.id%>" name="+">+</button>
     <%=item.name%>
  <br>
  <%
    }
  %>
</form>
<form style="display: inline-block" action="LogoutServlet" method="post">
  <input type="submit" value="Logout" name="logout"/>
</form>
<form style="display: inline-block" action="homepage.jsp" method="post">
  <input type="submit" value="Homepage" name="homepage"/>
</form>
</body>
</html>
