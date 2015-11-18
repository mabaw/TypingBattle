package jp.co.fitec.training.project.typing.ui.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.fitec.traning.project.typing.entity.UserAccount;
import jp.co.fitec.traning.project.typing.gamedata.GameSetting;
import jp.co.fitec.traning.project.typing.gamedata.Level;
import jp.co.fitec.traning.project.typing.gamedata.Mode;
import jp.co.fitec.traning.project.typing.service.GameServiceException;
import jp.co.fitec.traning.project.typing.service.QuestionManager;
import jp.co.fitec.traning.project.typing.service.ResultManager;

public class GameController implements Controller {

	@Override
	public String doAction(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, GameServiceException {
		
		HttpSession session = request.getSession();
		UserAccount player = (UserAccount) session.getAttribute("player");
		String levelStr = (String)request.getParameter("level");
		String modeStr =  (String)request.getParameter("mode");
		
		Level level = ControllerUtil.getLevelFromString(levelStr); 
		Mode mode = ControllerUtil.getModeFromString(modeStr);
		
		if(level==null)
		{
			request.setAttribute("message", "not select level");
			return "top.jsp";
		}		
		
		if(mode==null)
		{
			request.setAttribute("message", "not select mode");
			return "top.jsp";
		}
		
		String flag = request.getParameter("flag");
		if(flag!=null&&flag.equals("timeover"))
		{
			System.out.println("save result");
			GameSetting setting = new GameSetting(mode,level);
			int score = Integer.parseInt(request.getParameter("score"));
			double correct = Double.parseDouble(request.getParameter("correct"));
			double incorrect = Double.parseDouble(request.getParameter("incorrect"));	
			//System.out.println(correct + " " + incorrect + " " + (correct / (correct + incorrect)) * 100.0 + "%");
			ResultManager.saveGameResult(player, score, (int)correct, (int)incorrect , setting);			
			request.setAttribute("score", score);
			request.setAttribute("correctness", (correct / (correct + incorrect)) * 100.0 );
			request.setAttribute("mode", mode);
			request.setAttribute("level", level);
		    return "result.jsp";
		}
		else
		{
			String realpath = request.getServletContext().getRealPath("questionfile/question_"+player.getName()+".JSON");


			request.setAttribute("playername",player.getName());
			request.setAttribute("level",level);
			request.setAttribute("mode",mode);
			request.setAttribute("score",0);
			request.setAttribute("correct",0);
			request.setAttribute("incorrect",0);
			QuestionManager.generateJSONQuestionFile(realpath,level);	
			System.out.println("start game : level = " + level + "mode = " + mode);
			if(mode==Mode.TIME_LIMIT_MODE){
				return "game.jsp";
			}else{
				return "life.jsp";
			}
		}
	}
	


}
