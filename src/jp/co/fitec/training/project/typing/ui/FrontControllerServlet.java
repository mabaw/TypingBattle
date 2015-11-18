package jp.co.fitec.training.project.typing.ui;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.fitec.training.project.typing.ui.controller.Controller;
import jp.co.fitec.training.project.typing.ui.controller.ControllerFactory;
import jp.co.fitec.traning.project.typing.service.GameServiceException;



/**
 * Servlet implementation class FrontControllerServlet
 */
@WebServlet("*.do")
public class FrontControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
private void doService(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
		
		Controller controller = ControllerFactory.getController(request.getServletPath());
		HttpSession session = request.getSession();
		if(checkRequireAuthentication(request.getServletPath()) && session.getAttribute("player")==null)
		{
			request.setAttribute("message", "Please log in");
			request.getRequestDispatcher("login.do").forward(request, response);
			return;
		}
		String forwardPath=null;
		try {
			forwardPath = controller.doAction(request, response);
			request.getRequestDispatcher(forwardPath).forward(request, response);
		} catch (GameServiceException e) {
			request.setAttribute("message", "There is error in game system. (Game service)");
			e.printStackTrace();
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
		catch (Exception e){
			request.setAttribute("message", "There is error in game system. (Exception)");
			e.printStackTrace();
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
		
		
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doService(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doService(request, response);
	}
	
	private boolean checkRequireAuthentication(String path)
	{
		if(path.equals("/login.do")||path.equals("/index.jsp")||path.equals("/register.do")){
			return false;
		}
		return true;
	}

}
