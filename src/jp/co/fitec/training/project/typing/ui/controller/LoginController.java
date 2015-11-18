package jp.co.fitec.training.project.typing.ui.controller;

import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.fitec.training.project.typing.util.MD5Generater;
import jp.co.fitec.traning.project.typing.entity.UserAccount;
import jp.co.fitec.traning.project.typing.service.AccountManager;
import jp.co.fitec.traning.project.typing.service.GameServiceException;

public class LoginController implements Controller {

	@Override
	public String doAction(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, GameServiceException {
		
String flag = request.getParameter("flag");
		
		if(flag!=null&&flag.equals("true"))
		{
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			String encryptedPass;
			
			try {
				encryptedPass = MD5Generater.digestMd5(password);
			} catch (NoSuchAlgorithmException e) {
				throw new GameServiceException();
			}
			
			UserAccount userAccount= AccountManager.login(name, encryptedPass);
//			System.out.println(userAccount.getName());
			if(userAccount==null){
				request.setAttribute("message", "Username or password is incorrect.");
				request.setAttribute("flag", "true");
				return "login.jsp";
			}
			HttpSession session = request.getSession();
			session.setAttribute("player", userAccount);
			request.removeAttribute("name");
			request.removeAttribute("password");
			request.setAttribute("level", "easy");
			
			return "top.jsp";
		}
		
		else {
			request.setAttribute("flag", "true");
			return "login.jsp";
		}
	}

}
