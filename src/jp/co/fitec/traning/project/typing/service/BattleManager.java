package jp.co.fitec.traning.project.typing.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.co.fitec.traning.project.typing.entity.UserAccount;
import jp.co.fitec.traning.project.typing.gamedata.BattleMatch;
import jp.co.fitec.traning.project.typing.gamedata.BattleMatch.BattleState;
import jp.co.fitec.traning.project.typing.gamedata.Level;

public class BattleManager {
	
	private static Map<String,BattleMatch> battleMatchMap = new HashMap<>();
	
	public static List<BattleMatch> getAllWaitingMatch(){
		List<BattleMatch> result = new ArrayList<>();
		for (BattleMatch bm : battleMatchMap.values()) {
			if(bm.getBattleState()==BattleState.WAITING){
				result.add(bm);
			}
		}
		return result;
	}
	
	public static void createNewRoom(UserAccount host,Level level){
		BattleMatch match = new BattleMatch();
		match.setHostPlayer(host);
		match.setBattleState(BattleState.WAITING);
		match.setLevel(level);
		battleMatchMap.put(host.getName(),match);
	}
	
	public static boolean joinMatch(String hostname,UserAccount joinedPlayer){
		BattleMatch match = battleMatchMap.get(hostname);
		if(match.getBattleState()==BattleState.WAITING)
		{
			match.setJoinedPlayer(joinedPlayer);
			return true;
		}
		return false;
	}
	
	public static boolean startMatch(String hostname){
		BattleMatch match = battleMatchMap.get(hostname);
		if(match.getBattleState()==BattleState.WAITING
				&& match.getHostPlayer()!=null
				&& match.getJoinedPlayer() != null){
			match.setHostPlayerLife(20);
			match.setJoinedPlayerLife(20);
			match.setBattleState(BattleState.PLAYING);
			return true;
		}
		return false;
	}
	
	public static int getHostLife(String hostname) throws GameServiceException{
		BattleMatch match = battleMatchMap.get(hostname);
		if(match==null)
			throw new GameServiceException("Match doesn't exist.");
		return match.getHostPlayerLife();
	}
	
	public static int getJoinedLife(String hostname) throws GameServiceException{
		BattleMatch match = battleMatchMap.get(hostname);
		if(match==null)
			throw new GameServiceException("Match doesn't exist.");
		return match.getJoinedPlayerLife();
	}
	
	public static void attackHost(String hostname,int power) throws GameServiceException{
		BattleMatch match = battleMatchMap.get(hostname);
		if(match==null)
			throw new GameServiceException("Match doesn't exist.");
		int currentLife = match.getHostPlayerLife();
		match.setHostPlayerLife(currentLife-power);
	}
	
	public static void attackJoined(String hostname,int power) throws GameServiceException{
		BattleMatch match = battleMatchMap.get(hostname);
		if(match==null)
			throw new GameServiceException("Match doesn't exist.");
		int currentLife = match.getJoinedPlayerLife();
		match.setJoinedPlayerLife(currentLife-power);
	}
	
	public static boolean isGameEnd(String hostname) throws GameServiceException{
		BattleMatch match = battleMatchMap.get(hostname);
		if(match==null)
			throw new GameServiceException("Match doesn't exist.");
		if(match.getJoinedPlayerLife()<=0||match.getHostPlayerLife()<=0)
			return true;
		return false;
	}
	
	
	
	public static UserAccount getWinner(String hostname){
		BattleMatch match = battleMatchMap.get(hostname);
		if(match.getHostPlayerLife() > match.getJoinedPlayerLife())
			return match.getHostPlayer();
		else if(match.getHostPlayerLife() < match.getJoinedPlayerLife())
			return match.getJoinedPlayer();
		return null;
	}
	
	public static void removeMatch(String hostname){
		if(battleMatchMap.containsKey(hostname))
			battleMatchMap.remove(hostname);			
	}

	public static BattleMatch getMatch(
			String hostname) {
		BattleMatch match = battleMatchMap.get(hostname);
		return match;
	}
}
