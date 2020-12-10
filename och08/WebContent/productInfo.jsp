<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <!-- bean을 사용할때 -->
    <jsp:useBean id="pt" class="och08.Product" scope="request"/>
    <!-- Parameter 가져올때 -->
    <%-- <jsp:getProperty property="code"  name="pt"/> --%>
    <%-- <jsp:getProperty property="name"  name="pt"/> --%>
    <%-- <jsp:getProperty property="price" name="pt"/>  --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    코드 번호 : <%=pt.getCode() %><p>
    이름 :     <%=pt.getName() %><p>
    가격 :     <%=pt.getPrice() %><p>
</body>
</html>