package jp.co.fitec.traning.project.typing.gamedata;

import jp.co.fitec.traning.project.typing.entity.UserAccount;

public class BattleMatch {
	public static enum BattleState {WAITING,PLAYING,END};
	private Level level;
	private UserAccount hostPlayer;
	private UserAccount joinedPlayer;
	private int hostPlayerLife;
	private int joinedPlayerLife;
	private BattleState battleState;
	
	public UserAccount getHostPlayer() {
		return hostPlayer;
	}
	public void setHostPlayer(UserAccount hostPlayer) {
		this.hostPlayer = hostPlayer;
	}
	public UserAccount getJoinedPlayer() {
		return joinedPlayer;
	}
	public void setJoinedPlayer(UserAccount joinedPlayer) {
		this.joinedPlayer = joinedPlayer;
	}
	public int getHostPlayerLife() {
		return hostPlayerLife;
	}
	public void setHostPlayerLife(int hostPlayerLife) {
		this.hostPlayerLife = hostPlayerLife;
	}
	public int getJoinedPlayerLife() {
		return joinedPlayerLife;
	}
	public void setJoinedPlayerLife(int joinedPlayerLife) {
		this.joinedPlayerLife = joinedPlayerLife;
	}
	public BattleState getBattleState() {
		return battleState;
	}
	public void setBattleState(BattleState battleState) {
		this.battleState = battleState;
	}
	public Level getLevel() {
		return level;
	}
	public void setLevel(Level level) {
		this.level = level;
	}
	
	
}
