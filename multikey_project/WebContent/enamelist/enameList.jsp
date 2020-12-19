<%@page import="multikey_project.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="multikey_project.Emp_Dept_Dao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
       <%
            EmpDao ed = EmpDao.getInstance();
            DeptDao dd = DeptDao.getInstance();
            ArrayList<EmpDto> list1 = ed.list();
            ArrayList<DeptDto> list2 = dd.list();         
       %>
        <h2>사원 테이블구조</h2>
        <table border="1">
          <tr><td>사원번호</td><td>사원이름</td><td>직급</td><td>해당사원담당번호</td><td>입사일</td><td>급여</td><td>보너스</td><td>부서번호</td></tr>
        <%
            for(int i =0; i<list1.size(); i++){
        %>
            <tr>
             <td><%=list1.get(i).getEmpno() %></td>
             <td><%=list1.get(i).getEname() %></td>
             <td><%=list1.get(i).getJob() %></td>
             <td><%=list1.get(i).getMgr() %></td>
             <td><%=list1.get(i).getHiredate() %></td>
             <td><%=list1.get(i).getSal() %></td>
             <td><%=list1.get(i).getComm() %></td>
             <td><%=list1.get(i).getDeptno() %></td>
            </tr>
       <% } %>
       </table><p>
       <h2>부서 테이블구조</h2>
       <table border="1">
         <tr><td>부서번호</td><td>부서명</td><td>부서위치</td></tr>
        <%
          for(int i=0; i<list2.size(); i++){
       %>
           <tr>
             <td><%=list2.get(i).getDeptno() %></td>
             <td><%=list2.get(i).getDname() %></td>
             <td><%=list2.get(i).getLoc() %></td>            
            </tr>
       <% } %>
       </table>
       <% 
          Emp_Dept_Dao edo = Emp_Dept_Dao.getInstance();
          ArrayList<Emp_Dept_Dto> list3 = edo.getList();
       %> 
       <h2>사원 테이블과 부서 테이블 조인</h2>
        <table border="1">
          <tr><td>사원번호</td><td>사원이름</td><td>직급</td><td>해당사원담당번호</td><td>입사일</td><td>급여</td>
              <td>보너스</td><td>부서번호</td><td>부서명</td><td>부서위치</td></tr>
       <%
          for(int i=0; i<list3.size(); i++){
       %>
          <tr>
             <td><%=list3.get(i).getEmpDto().getEmpno() %></td>
             <td><%=list3.get(i).getEmpDto().getEname() %></td>
             <td><%=list3.get(i).getEmpDto().getJob() %></td>
             <td><%=list3.get(i).getEmpDto().getMgr() %></td>
             <td><%=list3.get(i).getEmpDto().getHiredate() %></td>
             <td><%=list3.get(i).getEmpDto().getSal() %></td>
             <td><%=list3.get(i).getEmpDto().getComm() %></td>
             <td><%=list3.get(i).getEmpDto().getDeptno() %></td>
             <td><%=list3.get(i).getDeptDto().getDname() %></td>
             <td><%=list3.get(i).getDeptDto().getLoc() %></td>            
            </tr>
       
       <% } %>
       </table> 
</body>
</html>