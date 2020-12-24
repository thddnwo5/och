package service;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Board;
import dao.BoardDao;

public class ListAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		     BoardDao           bd = BoardDao.getInstance();
		try {
			 // request의 파라미터를 빈깡통만 선언해서 가져올수있다
			// 다만 빈깡통을 그냥가져오면 안되고 조건문을 사용해서 로컬변수값을 넣어줘야 에러가 안난다.
			 String pageNum = request.getParameter("pageNum");
			 if(pageNum == null || pageNum.equals("")) { pageNum = "1";}
			 int currentPage = Integer.parseInt(pageNum);
			 // pageSize = row갯수 // blockSize = pageNum 갯수 // 갯수를 초과하면 이벤트가 생기게 하기위해 설정한값들
			 int pageSize = 10 , blockSize = 10;
			 int          startRow = (currentPage -1) * pageSize + 1;  // 초기값은 1 + -1 * 10 +1
			 int            endRow = startRow + pageSize - 1;          // 초기값은 1+10-1
		     int            totCnt = bd.getTotalCnt();                //38
		     int          startNum = totCnt - startRow + 1;   // 38-1+1
		     ArrayList<Board> list = bd.list(startRow,endRow);
		     int pageCnt   = (int)Math.ceil((double)totCnt/pageSize); // 3.8 을 올림으로 4개
		     int startPage = (int)(currentPage-1)/blockSize*blockSize + 1; // 초기값 1
		     int endPage = startPage + blockSize - 1;  // 초기값 1+10-1
		     if(endPage > pageCnt) endPage = pageCnt;
		     
		     request.setAttribute("totCnt",     totCnt);
		     request.setAttribute("pageNum",    pageNum);
		     request.setAttribute("currentPage", currentPage);
		     request.setAttribute("startNum", startNum);
		     request.setAttribute("list", list);
		     request.setAttribute("blockSize", blockSize);
		     request.setAttribute("pageCnt", pageCnt);
		     request.setAttribute("startPage", startPage);
		     request.setAttribute("endPage", endPage);
		    }catch(Exception e) {
			 System.out.println("ListAction =>"+e.getMessage());
		    }
		
		return "list.jsp";
	}

}
