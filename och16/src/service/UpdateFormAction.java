package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Board;
import dao.BoardDao;

public class UpdateFormAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 나중에 수정한다 일단 이해하기 쉽게 로우1을 불러오는 작업
		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");
		
		try {
			BoardDao bd = BoardDao.getInstance();
	        Board board = bd.select(num);
	        request.setAttribute("pageNum", pageNum);
		    request.setAttribute("board", board);
		}catch(Exception e) {
			System.out.println("UpdateFormAction requestPro =>" + e.getMessage());
		}
	    
	    
	    
		return "updateForm.jsp";
	}

}
