package service;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.Board;
import dao.BoardDao;
public class AjaxAction1 implements CommandProcess {
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
	        request.setCharacterEncoding("utf-8"); 
		} catch(Exception e) { System.out.println(e.getMessage()); }
        return "ajax1";
	}
}