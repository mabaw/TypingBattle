/**
 * 
 */
package jp.co.fitec.training.project.typing.ui.controller;

import java.security.NoSuchAlgorithmException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jp.co.fitec.training.project.typing.util.MD5Generater;
import jp.co.fitec.traning.project.typing.entity.UserAccount;
import jp.co.fitec.traning.project.typing.service.AccountManager;
import jp.co.fitec.traning.project.typing.service.GameServiceException;

/**
 * @author R.Miyachi
 *
 */
public class DeleteController implements Controller {

	/* (non-Javadoc)
	 * @see jp.co.fitec.training.project.typing.ui.controller.Controller#doAction(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public String doAction(HttpServletRequest request,
			HttpServletResponse response) throws ServletException,
			GameServiceException {
		
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
				request.setAttribute("message", "password is incorrect.");
				request.setAttribute("flag", "true");
				return "deleteAccount.jsp";
			}
				
//			HttpSession session = request.getSession();
			AccountManager.deleteAccount(userAccount);
//			request.removeAttribute("name");
//			request.removeAttribute("password");	
				
			return "index.jsp";
		}
		else
		{
			request.setAttribute("flag", "true");
			return "deleteAccount.jsp";
		}
		
	}

}
