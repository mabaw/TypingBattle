package jp.co.fitec.training.project.typing.ui.controller;

import jp.co.fitec.traning.project.typing.gamedata.Level;
import jp.co.fitec.traning.project.typing.gamedata.Mode;

public class ControllerUtil {
	public static Mode getModeFromString(String modeStr){
		Mode mode = null;
		if(modeStr.equals("timelimit") || modeStr.equals("TIME_LIMIT_MODE"))
		{
			mode = Mode.TIME_LIMIT_MODE;
		}
		else if(modeStr.equals("life") || modeStr.equals("LIFE_MODE"))
		{
			mode = Mode.LIFE_MODE;
			
		}
		else if(modeStr.equals("battle") || modeStr.equals("BATTLE_MODE"))
		{
			mode = Mode.BATTLE_MODE;
		}		
		return mode;
		
	}
	
	public static Level getLevelFromString(String levelStr){
		Level level = null;
		if(levelStr.equals("easy") || levelStr.equals("EASY"))
		{
			level = Level.EASY;
		}
		else if(levelStr.equals("normal")|| levelStr.equals("NORMAL"))
		{
			level = Level.NORMAL;
		}
		else if(levelStr.equals("difficult")|| levelStr.equals("DIFFICULT"))
		{
			level = Level.DIFFICULT;
		}
		return level;
		
	}
}
