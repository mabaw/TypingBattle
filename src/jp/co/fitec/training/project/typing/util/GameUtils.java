package jp.co.fitec.training.project.typing.util;

import jp.co.fitec.traning.project.typing.gamedata.Level;
import jp.co.fitec.traning.project.typing.gamedata.Mode;

public class GameUtils {
	public static Mode IntToMode(int n){
		if(n==1)
			return Mode.TIME_LIMIT_MODE;
		if(n==2)
			return Mode.LIFE_MODE;
		if(n==3)
			return Mode.BATTLE_MODE;
		return null;
	}
	
	public static  int modeToInt(Mode m){		
		if(m==Mode.TIME_LIMIT_MODE){
			return 1;
		}
		else if(m==Mode.LIFE_MODE){
			return 2;
		}
		else if(m==Mode.BATTLE_MODE){
			return 3;
		}
		return 0;
	}
	
	public static  Level IntToLevel(int n){
		if(n==1)
			return Level.EASY;
		if(n==2)
			return Level.NORMAL;
		if(n==3)
			return Level.DIFFICULT;
		return null;
	}
	
	public static  int levelToInt(Level l){
		if(l==Level.EASY){
			return 1;
		}
		else if(l==Level.NORMAL){
			return 2;
		}
		else if(l==Level.DIFFICULT){
			return 3;
		}
		return 0;		
	}
}
