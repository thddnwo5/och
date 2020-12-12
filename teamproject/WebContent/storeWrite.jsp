<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PetStore Product Update</title>
<script type="text/javascript">
     function chk(){
    	 if(!frm.storeProduct.value){
    		 alert('제품명을 써주셔야합니다.');
    		 frm.storeProduct.focus();
    		 return false;
    	 }
    	 if(!frm.productInfo.value){
    		 alert('제품설명을 써주셔야합니다.');
    		 frm.productInfo.focus();
    		 return false;
    	 }
    	 if(!frm.ProductPrice.value){
    		 alert('가격을 써주셔야합니다.');
    		 frm.ProductPrice.focus();
    		 return false;
    	 }else if(isNaN(frm.ProductPrice.value)){
    		 alert('가격을 숫자로 입력해주세요');
    		 frm.ProductPrice.focus();
    		 return false;
    	 }
     }
    
    	  
</script>
</head>
<body>
      <form action="productWrite.jsp" name="frm" method="post" 
       onsubmit="return chk()" autocomplete="off">
      <table border="1">
      <thead>
         <tr><th colspan="2">상품</th></tr>
      </thead>
      <tbody>
          <tr><td>제품카테코리</td>
          <td><select name="storeKgori">
                  <option value="사료">사료</option>
                  <option value="간식">간식</option>
                  <option value="패션">패션</option>
                  <option value="장난감">장난감</option>
          </select></td></tr>
          <tr><td>제품명</td>
          <td><input type="text" name="storeProduct" style=" width:500px; "></td></tr>
          <tr><td>제품이미지</td>
          <td><input type="file" id="storeImg" name="storeImg" ></td></tr>
          <tr><td>제품설명</td>
          <td><textarea name="productInfo" cols="100" rows="50"></textarea></td></tr>
          <tr><td>제품가격</td>
          <td><input type="text" name="productPrice"></td></tr>
       
      </tbody>
      </table>
         <input type="submit" value="확인">
      </form>
</body>
</html>