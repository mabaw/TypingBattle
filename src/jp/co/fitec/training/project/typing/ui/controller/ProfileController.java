package jp.co.fitec.training.project.typing.ui.controller;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.fitec.traning.project.typing.entity.Result;
import jp.co.fitec.traning.project.typing.entity.UserAccount;
import jp.co.fitec.traning.project.typing.gamedata.GameSetting;
import jp.co.fitec.traning.project.typing.gamedata.Level;
import jp.co.fitec.traning.project.typing.gamedata.Mode;
import jp.co.fitec.traning.project.typing.service.GameServiceException;
import jp.co.fitec.traning.project.typing.service.ResultManager;

public class ProfileController implements Controller {
	@Override
	public String doAction(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, GameServiceException {
	
		//GameSetting setting = new GameSetting(Mode,level);
		
		HttpSession session = request.getSession();
		UserAccount player = (UserAccount) session.getAttribute("player");
		List<Result> weekResultList = ResultManager.getOneWeekResult(player);
		request.setAttribute("weekResultList", weekResultList);
		return "profile.jsp";
	}
}
