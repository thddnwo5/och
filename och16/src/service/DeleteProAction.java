package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;

public class DeleteProAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			 request.setCharacterEncoding("utf-8");
			 int num = Integer.parseInt(request.getParameter("num"));		   
		     String pageNum = request.getParameter("pageNum"); 
		     String passwd = request.getParameter("passwd"); 
			 BoardDao bd = BoardDao.getInstance();
			 int result = bd.delete(num,passwd);
			 
			 request.setAttribute("num", num);
			 request.setAttribute("pageNum", pageNum);
			 request.setAttribute("result", result);
		}catch(Exception e) {
			System.out.println("DeleteProAction 에러 =" + e.getMessage());
			e.printStackTrace();
		}
		return "deletePro.jsp";
	}

}
