package sec05;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/LoginTestW")
public class LoginTestW extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public void init(ServletConfig config)
			throws ServletException {		
		System.out.println("init 메서드 호출");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException {	
	request.setCharacterEncoding("utf-8");
	response.setContentType("text/html;charset=utf-8");
	PrintWriter out = response.getWriter();
	String id = request.getParameter("user_id");
	String pw = request.getParameter("user_pw");

	System.out.println("아이디 :"+ id);
	System.out.println("패스워드 :"+ pw);

	if(id != null && !id.isEmpty()) {
		if (id.equals("admin")){		
			out.println("<html>");
			out.println("<body>");
			out.println("<font size='12'>관리자로 로그인 하셨습니다!</font>");
			out.println("<br>");
			out.println("<html>");
			out.println("<input type=button value='회원정보 수정하지' />");
			out.println("<input type=button value='회원정보 삭제하지' />");
			out.println("</html>");
			out.println("</body>");
		} else {
			out.print("<html>");
			out.print("<body>");
			out.print(id + "님!! 로그인 하셨습니다.");
			out.print("</body>");
			out.print("</html>");
		}
	} else {
		out.print("<html>");
		out.print("<body>");
		out.print("아이디를 입력하세요.");
		out.print("<br>");
		out.print("<a href='http://localhost:8090/Charpter06/test01.html'>로그인 이동</a>");
		out.print("</body>");
		out.print("</html>");
	}
}

	
	public void destroy() {		

		System.out.println("destroy 메서드 호출");

		
	}

}
