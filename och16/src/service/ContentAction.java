package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Board;
import dao.BoardDao;

public class ContentAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");
		
		try {
			BoardDao bd = BoardDao.getInstance();
		    bd.readCount(num);
		    Board board = bd.select(num);
		    request.setAttribute("num", num);
		    request.setAttribute("pageNum", pageNum);
		    request.setAttribute("board", board);
		}catch(Exception e) {
			System.out.println("ContentAction requestPro 메소드에서 에러가 나옴="+ e.getMessage());
		}
		return "content.jsp";
	}

}
