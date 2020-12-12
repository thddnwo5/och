<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
      
     
     
      <div style=" height:800px; ">
       <table border="1" style="border: none; width: 300px; height: 300px;">
          <thead>
               <tr>
                   <td colspan="5" align="center">2020-12-11 18:31</td>
               </tr>
          </thead>
           <tbody>
               <tr>
                 <td  colspan="5" align="center" style="height: 200px;">사진</td>
              </tr>
              <tr>
                <td   style="width: 70px;" align="center">카테고리</td>
                <td colspan="4" align="center">제품명</td>
              </tr>
              <tr>
                <td align="center">인기수</td>                
                <td align="center">평수</td>
                <td align="center">댓수</td>
                <td colspan="2" align="center" style="width:130px;">가격</td>
              </tr>
           </tbody>
       </table>
       </div>
       
       <div><button onclick="location.href='storeWrite.jsp'">물품올리기(관리자용)</button></div>
</body>
</html>