<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
       div#main{ margin-top: 10px;}
       div#main_logo {margin-top: 5px;}
       div#main_left{margin-top: 10px;}
       div#nav_logo{margin-top:5px;}
</style>
</head>
<body>
     <div ><img src="iconImg/backgroundline.png" width="1250px" height="10px"></div>
      <div class="main">
         <span style="position:relative; bottom: 30px; left:50px;">
           <a href="myPage.jsp"><img src="iconImg/my-page.png" width="50px" height="50px">
           </a></span>
          <span style=" position: relative; left: 500px;">
          <a href="main.jsp">
          <img src="iconImg/main-logo.png" width="170px" height="100px">
          </a></span>
          <span style=" position: relative;  bottom: 30px; left: 900px;">
              <a href="login.jsp">
              <img src="iconImg/icon-login.png" width="50px" height="50px"></a>
              <a href="join.jsp">
              <img src="iconImg/icon-join.png" width="50px" height="50px"></a>
          </span>
      </div> 
      <div>
      <img src="iconImg/backgroundline.png" width="1250px" height="10px"></div>   
     
        <div style=" position:relative; left:230px">
         <img src="iconImg/nav_img-logo.png" width="800px" height="150px">
         <span style="left: 100px; width:250px; bottom: 50px; position: absolute;">
              <a href="pet_boast.jsp"><img src="iconImg/nav_vanrue-icon.png" width="170px" height="80px"></a>
            </span>
            <span style="left: 320px; width:250px; bottom: 53px; position: absolute;">
              <a href="tip.jsp"><img src="iconImg/nav_tip-icon.png" width="170px" height="70px"></a>
            </span>
            <span style="left: 535px; width:250px; bottom: 58px; position: absolute;">
              <a href="storeBoard.jsp"><img src="iconImg/nav_store-icon.png" width="170px" height="57px"></a>
            </span>
      </div>
       
            
          
     <div>
      <img src="iconImg/backgroundline.png" width="1250px" height="10px"></div>
      <div style="margin-top: 10px; position: relative; left: 380px;" >
             <img src="iconImg/search_bar-icon.png" width="500px" height="50px">
      </div>
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