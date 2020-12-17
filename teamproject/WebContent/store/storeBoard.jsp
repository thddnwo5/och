<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  
<!DOCTYPE html>
<html>
<head>
     <!-- css폴더안에있는 mainDegin.css파일 link -->
<link rel="stylesheet" type="text/css" href="../css/mainDegin.css"/>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style=" width : 850px;">
       <!-- 희미한 선 구역나누기용 -->
     <div ><img src="../iconImg/backgroundline.png" width="1250px" height="10px"></div>
      <div class="main">
             <!-- 상단 왼쪽부분 -->
         <span id="myPage-css">
             <!-- 메인페이지 버튼부분 -->
           <a href="myPage.jsp"><img src="../iconImg/my-page.png" width="50px" height="50px">
           </a></span>
           <!-- 상단 메인로고 부분 -->
          <span id="main-logo-css"><a href="main.jsp">
          <img src="../iconImg/main-logo.png" width="170px" height="100px"></a></span>
           <!-- 상단 오른쪽부분 -->
          <span id="top-right-css">
               <!-- 로그인버튼 -->
              <a href="login.jsp"><img src="../iconImg/icon-login.png" width="50px" height="50px"></a>
                   <!-- 회원가입버튼 -->
              <a href="join.jsp"><img src="../iconImg/icon-join.png" width="50px" height="50px"></a>
          </span>
      </div>
        <!-- 희미한선 구역나누기용 -->
      <div><img src="../iconImg/backgroundline.png" width="1250px" height="10px"></div>   
       <!-- nav구역 -->
       <div id="nav-logo-css">
             <!-- 버튼뒷배경 -->
         <img src="../iconImg/nav_img-logo.png" width="800px" height="150px">
               <!-- 반려동물자랑 버튼 -->
            <span id="pet-boast-css">
	              <a href="pet_boast.jsp">
	              <img src="../iconImg/nav_vanrue-icon.png" width="170px" height="80px"></a>
            </span>
            <!-- 팁 버튼 -->
            <span id="tip-css">
              <a href="tip.jsp"><img src="../iconImg/nav_tip-icon.png" width="170px" height="70px"></a>
            </span>
            <!-- 스토어버튼 -->
            <span id="store-css">
              <a href="storeBoard.jsp"><img src="../iconImg/nav_store-icon.png" width="170px" height="57px"></a>
            </span>
      </div>
        <!-- 희미한선 구역나누기용 -->
     <div>
      <img src="../iconImg/backgroundline.png" width="1250px" height="10px"></div>
      
      <!-- 검색기능div -->
    <div style="width:1250px; height: 100px; margin-top: 10px;">
    <div id="search-icon-css" >
             <span id="search-bar">
             <input type="text" name="search" id="search" class="search-bar-css">
             </span>
             <span id="search-dotbogi">
             <input type="submit" value="" id="seach" alt="seach">
             </span>
      </div>
    </div>  
       <!-- 희미한선 구역나누기용 -->
   <div><img src="../iconImg/backgroundline.png" width="1250px" height="10px"></div>    
     <!-- 여기까지는 모든 페이지에 들어갈 요소들 --> 
      
      <div style=" height:300px; width : 300px; ">
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