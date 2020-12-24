package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Board;
import dao.BoardDao;

public class DeleteFormAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	    
		try {
			 request.setCharacterEncoding("utf-8");
			 int num = Integer.parseInt(request.getParameter("num"));		   
		     String pageNum = request.getParameter("pageNum");
			 BoardDao bd = BoardDao.getInstance();
		     Board board  =  bd.select(num);
			
		     request.setAttribute("num", num);
		     request.setAttribute("pageNum", pageNum);
		     request.setAttribute("board", board);
		     
		}catch(Exception e) {
			System.out.println("DeleteFormAction request메소드 내에서 에러 = " + e.getMessage());
			e.printStackTrace();
		}
		return "deleteForm.jsp";
	}

}
