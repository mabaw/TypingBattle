package jp.co.fitec.training.project.typing.ui.controller;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.fitec.traning.project.typing.entity.Result;
import jp.co.fitec.traning.project.typing.gamedata.GameSetting;
import jp.co.fitec.traning.project.typing.gamedata.Level;
import jp.co.fitec.traning.project.typing.gamedata.Mode;
import jp.co.fitec.traning.project.typing.service.GameServiceException;
import jp.co.fitec.traning.project.typing.service.ResultManager;

public class RankingController implements Controller {

	@Override
	public String doAction(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, GameServiceException {
		
		String levelStr = request.getParameter("level");
		String modeStr =  request.getParameter("mode");
		int size =  Integer.parseInt(request.getParameter("size"));

		Mode mode = ControllerUtil.getModeFromString(modeStr);
		Level level = ControllerUtil.getLevelFromString(levelStr);
		GameSetting setting = new GameSetting(mode,level);
		
		List<Result> worldWideRanking = ResultManager.getWorldWideRanking(setting, size);
		request.setAttribute("resultList", worldWideRanking);
		request.setAttribute("mode", modeStr);
		request.setAttribute("level", levelStr);
		return "ranking.jsp";
	}

}
