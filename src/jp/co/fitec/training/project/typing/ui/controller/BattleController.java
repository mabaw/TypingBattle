package jp.co.fitec.training.project.typing.ui.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.fitec.training.project.typing.util.GameUtils;
import jp.co.fitec.traning.project.typing.entity.UserAccount;
import jp.co.fitec.traning.project.typing.gamedata.BattleMatch;
import jp.co.fitec.traning.project.typing.gamedata.Level;
import jp.co.fitec.traning.project.typing.service.BattleManager;
import jp.co.fitec.traning.project.typing.service.GameServiceException;
import jp.co.fitec.traning.project.typing.service.QuestionManager;

public class BattleController implements Controller {

	@Override
	public String doAction(HttpServletRequest request,
			HttpServletResponse response) throws ServletException,
			GameServiceException {
		String action = request.getParameter("action");
		HttpSession session = request.getSession();
		UserAccount player = (UserAccount) session.getAttribute("player");
		if(action==null){
		
				List<BattleMatch> matchList =  BattleManager.getAllWaitingMatch();
				request.setAttribute("matchList", matchList);
				return "matchlobby.jsp";			
		}
		if(action.equals("create")){
			String level = request.getParameter("level");
			System.out.println("Battle level is : " + level);
			Level l = ControllerUtil.getLevelFromString(level);
			BattleManager.createNewRoom(player, l);
			String realpath = request.getServletContext().getRealPath("questionfile/question_"+player.getName()+".JSON");
			QuestionManager.generateJSONQuestionFile(realpath,l);	
			request.setAttribute("host", player.getName());
			return "battle.jsp";
		}
		else if(action.equals("join")){
			String hostName = request.getParameter("name");
			request.setAttribute("host", hostName);
			request.setAttribute("join", player.getName());
			
			// call battle servlet to broadcast joined player
			//try {
			//	request.getRequestDispatcher("battle").forward(request, response);
				//request.
			//} catch (IOException e) {
			//	System.err.println("cannot broadcast join!!!");
			//	e.printStackTrace();
			//}
			
			return "battle.jsp";
		}
		return null;
	}

}
