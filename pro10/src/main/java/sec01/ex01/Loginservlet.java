package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Loginservlet
 */
@WebServlet("/login")
public class Loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() {
		// TODO Auto-generated method stub
		System.out.println("init 메서드 호출");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		String ueser_id=request.getParameter("user_id");
		String ueser_pw=request.getParameter("user_pw");
		String ueser_address=request.getParameter("user_address");
		String ueser_email=request.getParameter("user_email");
		String ueser_hp=request.getParameter("user_hp");
		
		String data="안녱하세요<br>로그인하솄습니다.<br><br>";
		data+="<html><body>";
		data+="아이디"+"user_id";
		data+="<br>";
		data+="패스워드"+"user_pw";
		data+="<br>";
		data+="주소"+"user_address";
		data+="<br>";
		data+="email"+"user_email";
		data+="<br>";
		data+="휴대전화"+"user_hp";
		data+="</body></html>";
		out.print(data);
		
	}
	public void destroy() {
		System.out.println("destroy 메서드 호출");
	}

}
