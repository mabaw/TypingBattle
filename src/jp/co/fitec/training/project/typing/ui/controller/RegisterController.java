package jp.co.fitec.training.project.typing.ui.controller;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.fitec.training.project.typing.util.MD5Generater;
import jp.co.fitec.traning.project.typing.entity.Location;
import jp.co.fitec.traning.project.typing.entity.UserAccount;
import jp.co.fitec.traning.project.typing.service.AccountManager;
import jp.co.fitec.traning.project.typing.service.GameServiceException;
import jp.co.fitec.traning.project.typing.service.LocationManager;

public class RegisterController implements Controller {

	@Override
	public String doAction(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, GameServiceException {
		
		String flag = request.getParameter("flag");
		
		if(flag!=null&&flag.equals("true"))
		{
			
			try
			{
				String name = request.getParameter("name");
				String locationCode = request.getParameter("location");	
				String password = request.getParameter("password");	
				String encryptedPass;
				
					try {
						encryptedPass = MD5Generater.digestMd5(password);
					} catch (NoSuchAlgorithmException e) {
						throw new GameServiceException();
						
					}
				
				UserAccount user = new UserAccount();
				Location location = LocationManager.findByCode(locationCode);
				user.setLocation(location);
				user.setName(name);
				user.setPassword(encryptedPass);
				user.setPhoto("");
				AccountManager.register(user);
			
				request.setAttribute("name", name);
				request.setAttribute("location", location);
				request.setAttribute("password", encryptedPass);
				return "registerconfirm.jsp";
			}
			catch(Exception e)
			{
				request.setAttribute("message", "Cannot register please try again");
				System.err.println(e.getMessage());
				List<Location> locationList = new ArrayList<>();
				locationList = LocationManager.getAll();
				request.setAttribute("locationList", locationList);			
				request.setAttribute("flag", "true");
				return "register.jsp";
			}
		}
		else
		{
			List<Location> locationList = new ArrayList<>();
			locationList = LocationManager.getAll();
			request.setAttribute("locationList", locationList);			
			request.setAttribute("flag", "true");
			return "register.jsp";
		}
	}

}
