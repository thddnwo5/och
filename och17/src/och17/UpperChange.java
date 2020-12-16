package och17;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class UpperChange extends HttpServletRequestWrapper {

	private HttpServletRequest request;

	public UpperChange(HttpServletRequest request) {
		super(request);
		this.request = request;
	}
   public String getParameter(String name) {
	   String value = request.getParameter(name);
	   return value.toUpperCase()+"씨";
   }
}
