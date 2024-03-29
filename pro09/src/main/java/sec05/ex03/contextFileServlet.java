package sec05.ex03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.portable.InputStream;

/**
 * Servlet implementation class contextFileServlet
 */
@WebServlet("/cfile")
public class contextFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        ServletContext context = getServletContext();
        java.io.InputStream is=context.getResourceAsStream("/WEB-INF/bin/init.txt");
        BufferedReader  buffer=new BufferedReader(new InputStreamReader(is));
        
        String menu=null;
        String menu_member = null;
        String menu_order = null;
        String menu_goods = null;
        while((menu=buffer.readLine())!=null) {
        	StringTokenizer tokens=new StringTokenizer(menu,",");
        	menu_member=tokens.nextToken();
        	menu_order=tokens.nextToken();
        	menu_goods=tokens.nextToken();
        }

        out.print("<html><body>");
        out.print("<table border='1' cellspacing='0'><tr><th>메뉴 이름</th></tr>");
        out.print("<tr><td>" + menu_member + "</td></tr>");
        out.print("<tr><td>" + menu_order + "</td></tr>");
        out.print("<tr><td>" + menu_goods + "</td></tr>");
        out.print("</table></body></html>");

        out.close();
    }
	}
