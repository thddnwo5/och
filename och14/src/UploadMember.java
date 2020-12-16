

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class UploadMember
 */
@WebServlet("/UploadMember")
public class UploadMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public UploadMember() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    System.out.println("UploadMember doPost start..."); // 체크용 항상 작성하자
		    request.setCharacterEncoding("utf-8");
		    int result = 0;
	        int maxSize = 5 * 1024 * 1024;  // 5M 까지 허용
	        String fileSave = "/fileSave";
	        String realPath = getServletContext().getRealPath(fileSave);
	        String filename = "";
	        System.out.println("realPath -> " + realPath);
	        MultipartRequest multi = new MultipartRequest(request,realPath,maxSize,"utf-8",new DefaultFileRenamePolicy());
	        Enumeration en = multi.getFileNames();
	        
	        while(en.hasMoreElements()){
	        	  //input 태그의 속성이 file인 태그의 name 속성값 : 파라미터이름 m
	        	  String filename1 = (String)en.nextElement();
	              //서버의 저장된 파일 이름
	                     filename  = multi.getFilesystemName(filename1);
	              //전송전 원래의 파일 이름
	              String original  = multi.getOriginalFileName(filename1);
	              //전송된 파일의 내용 타입
	              String type      = multi.getContentType(filename1);
	              //전송된 파일속성이 file인 태그의 name 속성값을 이용해 파일객체 생성
	              // 저장된게 안올라갈수도있다 그러므로 폴더가 생성이 안될때 직접 폴더를 만들어서 집어넣을수있다.realpath경로에 
	              File file        = multi.getFile(filename1);
	              
	              System.out.println("real Path : " + realPath);
	              System.out.println("파라메터 이름 : " + filename1);
	              System.out.println("실제 파일 이름 : " + original);
	              System.out.println("저장된 파일 이름 : " + filename);
	              System.out.println("파일 타입 : " + type);
	              if(file != null){
	            	  System.out.println("크기 : " + file.length());
	              }
	        }
	        
	        String id        = multi.getParameter("id");
	        String password  = multi.getParameter("password");
	        String name      = multi.getParameter("name");
	        
	        MemberDao md     = new MemberDao();
	        MemberDto member = new MemberDto();
	        
	        member.setId(id);
	        member.setName(name);
	        member.setPassword(password);
	        member.setImage("fileSave\\"+filename);
	        
	        try {
				result = md.insert(member);
			} catch (SQLException e) {
				e.printStackTrace();
			}
	        
	        request.setAttribute("id", id);
	        request.setAttribute("password", password);
	        request.setAttribute("name", name);
	        request.setAttribute("fileName", "fileSave\\"+filename);
	        RequestDispatcher rd = request.getRequestDispatcher("uploadMemberResult.jsp");
	        rd.forward(request, response);
	}

}
