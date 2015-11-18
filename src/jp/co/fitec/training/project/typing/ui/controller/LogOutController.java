package jp.co.fitec.training.project.typing.ui.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.fitec.traning.project.typing.service.GameServiceException;

public class LogOutController implements Controller {

	@Override
	public String doAction(HttpServletRequest request,
			HttpServletResponse response) throws ServletException,
			GameServiceException {
		HttpSession session = request.getSession();
		session.removeAttribute("player");
		return "index.jsp";
	}

}
