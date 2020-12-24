package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Board;
import dao.BoardDao;

public class UpdateProAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
        
		try {
			request.setCharacterEncoding("utf-8");
			int        num = Integer.parseInt(request.getParameter("num"));
			String pageNum = request.getParameter("pageNum");
			String  subject = request.getParameter("subject");
			String  writer = request.getParameter("writer");
			String   email = request.getParameter("email");
			String  passwd = request.getParameter("passwd");
			String content = request.getParameter("content");
			Board board = new Board();
			board.setNum(num);
			board.setSubject(subject);
			board.setWriter(writer);
			board.setEmail(email);
			board.setPasswd(passwd);
			board.setContent(content);
			board.setIp(request.getRemoteAddr());
	        BoardDao bd = BoardDao.getInstance();
	        int result = bd.update(board);
			
			request.setAttribute("num", board.getNum());
			request.setAttribute("result", result);
			request.setAttribute("pageNum", pageNum);
			
			}catch(Exception e) {
				System.out.println("UpdateProAction try에서 오류" + e.getMessage());
			}
			return "updatePro.jsp";
	}

}
