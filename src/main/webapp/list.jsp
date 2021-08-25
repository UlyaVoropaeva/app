<%@ page import="com.example.app.Product" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List product</title>
</head>
<body>
<div>
<h3><%= "List product" %></h3>
<%
    List<Product> products = (List<Product>) request.getAttribute("Product");
    for(Product p : products){
       out.println("<li>" + p + "</li>");
    }
%>
</div>

</body>
</html>
