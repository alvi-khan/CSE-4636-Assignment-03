<%@ page import="com.example.lab03_assignment.CartBean" %>
<%@ page import="com.example.lab03_assignment.Item" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Homepage</title>
</head>
<body>
<h1>Homepage</h1>
<form action="CartServlet" method="get">
    <%
        CartBean cartBean = (CartBean) session.getAttribute("cart");
        List<Item> items = (List<Item>) request.getAttribute("items");
    %>
    Items in cart: <%=cartBean.getTotal()%>
    <br>
    <%
        for(int i = 0; i<items.size(); i++) {
    %>
        <img src="<%=request.getContextPath()%><%=items.get(i).image%>" width="50" />
    <button type="submit" value="<%=items.get(i).id%>" name="+">Add to Cart</button> <%=items.get(i).name%>
    <br>
    <%}%>
</form>
<form style="display: inline-block" action="LogoutServlet" method="post">
    <input type="submit" value="Logout" name="logout"/>
</form>
<form style="display: inline-block" action="cart.jsp" method="post">
    <input type="submit" value="View Cart" name="viewCart"/>
</form>
</body>
</html>
