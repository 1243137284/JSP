package sec05.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/login")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String MemberVO = null;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doHeadle(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doHeadle(request, response);
	}

	/**
	 * @see HttpServlet#doHead(HttpServletRequest, HttpServletResponse)
	 */
	protected void doHeadle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		String user_id= request.getParameter("user_id");
		String user_pwd=request.getParameter("user_pwd");
		MemberVO memberVO=new MemberVO();
		memberVO.setId(user_id);
		memberVO.setPwd(user_pwd);
		MemberDAO dao=new MemberDAO();
		boolean result =dao.isExisted(memberVO);
		if(result) {
			HttpSession session=request.getSession();
			session.setAttribute("isLogon", true);
			session.setAttribute("login.id", user_id);
			session.setAttribute("login.pwd", user_pwd);
			out.print("<html><body>");
			out.print("안녱하세요"+user_id+"님!!<br>");
			out.print("<a=href='show'>회원정보 보기</a>");
			out.print("</body><html>");
		}else {
			out.print("<html><body><center>회원 아이디가 틀립니다");
			out.print("<a=href='login3'>다시 로드인하기</a>");
			out.print("</body><html>");
		}
	}

}
