<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
     <h2>영어로 이름을 입력하세요.</h2>
     <form action="nameView.jsp">
         <fieldset>
            <legend>이름 입력창</legend>
                <label for="name">이름 : </label>
                <input type="text" name="name"><p>
                <input type="submit" value="확인"><p>         
         </fieldset>
     </form>
</body>
</html>