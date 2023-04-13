package sec05.ex01;

import java.sql.ResultSet;

import javax.activation.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

/**
 * Servlet implementation class MemberDAO
 */
@WebServlet("/MemberDAO")
public class MemberDAO extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DataSource dataFactory; 
    public MemberDAO() {
    	try {
    		Context ctx=new InitialContext();
    		Context envContext=(Context) ctx.lookup("java:/comp/env");
    		dataFactory=(DataSource)envContext.lookup("jdbc/oracle");
    		
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    }
	public boolean isExisted(MemberVO memberVO) {
		// TODO Auto-generated method stub
		boolean result= false;
		String id=memberVO.getId();
		String pwd=memberVO.getPwd();
		try{
			 con = dataFactory.getContection();
			String query="select decode(count(*),1,'true','false')as result from t_member";query+="where id=? and pwd=?";
			pstmt = con.preparestatement (query) ;
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			ResultSet rs =pstmt.executeQuery();
			rs.next();
			result=Boolean.parseBoolean(rs.getString("result"));
			System.out.println("result="+result);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

}
