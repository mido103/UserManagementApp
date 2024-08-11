package web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import model.UserModel;

@WebServlet("/")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDao ud ;
    public UserServlet() {
        super();

    }

	public void init(ServletConfig config) throws ServletException {
		ud = new UserDao();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	String action = request.getServletPath();
	
	switch (action) {
	case "/list": {
		
		try {
			show_all_users(request, response);
		} catch (ClassNotFoundException | SQLException | IOException e) {
		
			e.printStackTrace();
		}
	}
	
	break;
	
	case"/edit":
		
	{
		try {
			show_edit_form(request, response);
		} catch (ClassNotFoundException | SQLException | ServletException | IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	break;
	
	case"/new":
		
		{show_new_form(request, response);}
		
		break;
		
	case"/add":
	{
		try {
			add_new_user(request, response);
		} catch (ClassNotFoundException | SQLException | ServletException | IOException e) {
			e.printStackTrace();
		}
		
	}
	
	break;
	
	case"/modify":
	
		{try {
			edit(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		}
		break;
		
		default:
		
		try {
			delete(request, response);
		} catch (ClassNotFoundException | ServletException | IOException | SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	}



	
	public void show_all_users(HttpServletRequest request , HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException, ServletException {
		
	List<UserModel> um  = ud.select_all_user();		

	
	
	
	  request.setAttribute("user", um); RequestDispatcher rd =
	  request.getRequestDispatcher("list.jsp"); rd.forward(request, response);
	 
	 
	
	/*
	 * HttpSession session = request.getSession() ; session.setAttribute("um", um);
	 * response.sendRedirect("list.jsp");
	 */
		 
		 
	}
	
	public void show_edit_form (HttpServletRequest request , HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		UserModel um = ud.select_user_by_id(id);
		request.setAttribute("um", um);
		RequestDispatcher rd = request.getRequestDispatcher("form.jsp");
		rd.forward(request, response);
	}

	public void show_new_form(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {
		
		
		  RequestDispatcher rd = request.getRequestDispatcher("form.jsp");
		  rd.forward(request, response);
		 
			/* response.sendRedirect("form.jsp"); */
	}
	
	public void add_new_user(HttpServletRequest request , HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException {
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String country = request.getParameter("country");
		ud.add_user(name, email, country);
		
		/*
		 * RequestDispatcher rd = request.getRequestDispatcher("list");
		 * rd.forward(request, response);
		 */
		HttpSession session = request.getSession() ;
		response.sendRedirect("list");
		
		
	}
	
	public void edit(HttpServletRequest request , HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String country = request.getParameter("country");
		ud.update_user(id, name, email, country);
		
		/*
		 * RequestDispatcher rd = request.getRequestDispatcher("list");
		 * rd.forward(request, response);
		 */
		 
		
		HttpSession session = request.getSession() ;
		response.sendRedirect("list");
		
		
		
		
	}
	
	public void delete(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException {
		int id = Integer.parseInt(request.getParameter("id"));
		ud.delete_user(id);
		/*
		 * RequestDispatcher rd = request.getRequestDispatcher("list");
		 * rd.forward(request, response);
		 */
		
		HttpSession session = request.getSession() ;
		response.sendRedirect("list");
	}
	
	
	
}
