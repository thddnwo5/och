package servlet;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import board.board;
import board.boardDAO;



/**
 * Servlet implementation class storeServlet
 */
@WebServlet("/storeServlet")
public class storeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public storeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int maxSize            = 5 * 1024 * 1024;
		String fileSave        = "/fileSave/";
		String realPath        = getServletContext().getRealPath(fileSave);
		String filename        = "";
		System.out.println("realPath -> " + realPath);
		MultipartRequest multi = new MultipartRequest(request,realPath,maxSize,"utf-8",new DefaultFileRenamePolicy());
		Enumeration en         = multi.getFileNames();
		
		while(en.hasMoreElements()) {
			String storeImg = (String)en.nextElement();
			       filename  = multi.getFilesystemName(storeImg);
		    String original  = multi.getOriginalFileName(storeImg);
		    String type      = multi.getContentType(storeImg);
			       
			File file        = multi.getFile(storeImg);
			
			System.out.println("real Path : " + realPath);
            System.out.println("파라메터 이름 : " + storeImg);
            System.out.println("실제 파일 이름 : " + original);
            System.out.println("저장된 파일 이름 : " + filename);
            System.out.println("파일 타입 : " + type);
            if(file != null) {
            	System.out.println("크기 : " + file.length());
            }
		}
		
		String storeKgori   = multi.getParameter("storeKgori");
		String storeProduct = multi.getParameter("storeProduct");
		String productInfo  = multi.getParameter("productInfo");
		int    productPrice = Integer.parseInt(multi.getParameter("productPrice"));
		
		board     board    = new board();
		boardDAO  boardDAO = new boardDAO();
		
		board.setStoreKgori(storeKgori);
		board.setStoreProduct(storeProduct);
		board.setProductInfo(productInfo);
		board.setProductPrice(productPrice);
		board.setStoreImg("fileSave\\"+filename);
		try {
		  int result = boardDAO.storeWrite(board);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
