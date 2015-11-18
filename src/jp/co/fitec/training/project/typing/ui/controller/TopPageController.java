package jp.co.fitec.training.project.typing.ui.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TopPageController implements Controller {

	@Override
	public String doAction(HttpServletRequest request,
			HttpServletResponse response) throws ServletException {
		// TODO Auto-generated method stub
		String level = request.getParameter("level");
		request.setAttribute("level", level);
		return "top.jsp";
	}

}
