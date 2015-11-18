package jp.co.fitec.training.project.typing.ui.controller;


public class ControllerFactory {

	public static Controller getController(String servletPath) {
		System.out.println(servletPath);
		switch (servletPath) {

		case "/TypingGame/game.do":
			return new GameController();
		case "/game.do":
			return new GameController();
		case "/login.do":
			return new LoginController();			
		case "/profile.do":
			return new ProfileController() ;			
		case "/ranking.do":
			return new RankingController();			
		case "/register.do":
			return new RegisterController() ;				
		case "/top.do":
			return new TopPageController();	
		case "/logout.do":
			return new LogOutController();
		case "/battle.do":
			return new BattleController();
		case "/delete.do":
			return new DeleteController();
	}
	
	return null;
	}

}
