package service;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.Board;
import dao.BoardDao;
public class AjaxAction2 implements CommandProcess {
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		BoardDao bd = BoardDao.getInstance();
		try {
			 int totCnt  = bd.getTotalCnt();
			 String pageNum = request.getParameter("pageNum");	
			if (pageNum==null || pageNum.equals("")) {	pageNum = "1";	}
			int currentPage = Integer.parseInt(pageNum);	
			int pageSize  = 10, blockSize = 10;
			int startRow = (currentPage - 1) * pageSize + 1;
			int endRow   = startRow + pageSize - 1;
			int startNum = totCnt - startRow + 1;
			List<Board> list = bd.list(startRow, endRow);	
			request.setAttribute("list", list);
			System.out.println("Service list.size()-->"+list.size());
			
		} catch(Exception e) { System.out.println(e.getMessage()); }
        return "ajax2";
	}
}