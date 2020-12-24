package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Board;
import dao.BoardDao;



public class WriteFormAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		    
		try {
			int num = 0, ref= 0 , re_level = 0, re_step = 0;
		    String pageNum = request.getParameter("pageNum");
		    // 댓글 작업
		    if(request.getParameter("num") != null) {
		    	 num = Integer.parseInt(request.getParameter("num"));
		    	 BoardDao bd = BoardDao.getInstance();
		    	 Board board = bd.select(num);
		    	 ref         = board.getRef();
		    	 re_level    = board.getRe_level();
		    	 re_step     = board.getRe_step();
		    	 request.setAttribute("num", num);
		  		 request.setAttribute("pageNum", pageNum);
		  		 //댓글 작업 추가해줘야할때
		  		 request.setAttribute("ref", ref);
		  		 request.setAttribute("re_level", re_level);
		  		 request.setAttribute("re_step", re_step);
		                                            } // if(request.getParameter("num") 끝
		       }catch(Exception e) {
   		           System.out.println("WriteFormAction에서 오류 =>" + e.getMessage());
   		            e.printStackTrace();
   	          }				
		return "writeForm.jsp";
	}

}
