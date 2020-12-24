package control;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CommandProcess;

// @WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// Map객체 변수선언이유는 command.properties에 저장된 키와 값을 저장하는 Map객체를 만들어야하기때문에
    private Map<String,Object> commandMap = new HashMap<String, Object>();
    
    public Controller() {
        super();
    }

	
	public void init(ServletConfig config) throws ServletException {
		// web.xml 에서 propertyConfig 에 해당하는 init-param 의 값을 읽어옴
		String props      = config.getInitParameter("config");
		System.out.println("Controller init props =>" +props);
		// 명령어와 처리클래스의 매핑정보를 저장할 Properties 객체 생성
		Properties pr     = new Properties();
		FileInputStream f = null;
		
		
		try {
			String ConfigFilePath = config.getServletContext().getRealPath(props);
			System.out.println("Controller init ConfigFilePath =>" +ConfigFilePath);
			f = new FileInputStream(ConfigFilePath);
			// command.properties파일의 정보를 Properties 객체에 저장
			pr.load(f);
			//메모리위에 properties가 로드된다.
		} catch (IOException e) {
			throw new ServletException(e);
		}finally {
			 if(f != null) try {f.close();}catch(IOException ex) {}
		}
		
		// Iterator 객체는 Enumeration객체를 확장시킨 개념의 객체
		// keyset 은 키값만 가져옴
		Iterator keyIter = pr.keySet().iterator();
		
		while(keyIter.hasNext()) {
			String command = (String)keyIter.next();  // list.do
			String className = pr.getProperty(command); // service.ListAction
			// 예) UpdateFormAction ufa = new UpdateFormAction(); 
			//이런생성과정을 일일이 코드로 작성할수없으니 자동으로 init으로 생성하는과정
			try {
				  Class commandClass = Class.forName(className); // 해당 문자열을 클래스로 만든다.	
				  // 밑코드는 다음 버전에서는 사라질예정 
				  // Object commandInstance = commandClass.newInstance();
				  //사라지는 코드를 대처할수있는 코드 종류
				  //1. getDeclaredConstructor은 접근제어자타입 상관없이 접근가능
				  Object commandInstance = commandClass.getDeclaredConstructor().newInstance();
				  //2. getConstructor는 public만 접근할수있다.
				  
				  //Constructor<?> constructor = commandClass.getConstructor(null);
				  //constructor.newInstance();
				  //Object commandInstance = constructor.newInstance(); // 해당클래스의 객체를 생성 
				 commandMap.put(command, commandInstance); // MAP객체인 commandMap에 객체 저장
			}catch(Exception e) {
				throw new ServletException(e);
			}
		}
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		requestPro(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		requestPro(request, response);
	}
	// 사용자의 요청을 분석해서 해당 작업을 처리
    private void requestPro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException,IOException{
    	String view = null;
    	CommandProcess com = null;
    	String command = request.getRequestURI();
    	 
    	  try {
    		  System.out.println("requestPro command 1 => "+command); // /och16/list.do
        	 // System.out.println(request.getContextPath()); // /och16
        	//  System.out.println(command.indexOf(request.getContextPath()));  // 0
        	//  if(command.indexOf(request.getContextPath()) == 0) {
        		  command = command.substring(request.getContextPath().length());
        	//  }
        	  
        	  com = (CommandProcess)commandMap.get(command);
        	  System.out.println("requestPro command 2 => " + command); // /och16/com
        	  System.out.println("requestPro com=>" + com);            // /och16/com
        	  view = com.requestPro(request, response);                // updateFrom.jsp
        	  System.out.println("requestPro view=>" + view);          // /och16/com
    		  
    	  }catch(Throwable e) {
    		  throw new ServletException(e);
    	  }
    	  RequestDispatcher dispatcher = request.getRequestDispatcher(view);
    	  dispatcher.forward(request, response);
    }
}
