package jp.co.fitec.traning.project.typing.entity;

import java.io.Serializable;
import java.util.Date;

import jp.co.fitec.traning.project.typing.gamedata.GameSetting;

public class Result  implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private UserAccount player;
	private Date playDate;
	private int score;
	private int correctType;
	private int incorrectType;
	private GameSetting gameMode;
	
	
	public Result() {
		
	}
	
	public Result(Date playDate, UserAccount player, int score,
			int correctType, int incorrectType, GameSetting gameMode) {
		super();
		this.playDate = playDate;
		this.player = player;
		this.score = score;
		this.correctType = correctType;
		this.incorrectType = incorrectType;
		this.gameMode = gameMode;
	}

	public Date getPlayDate() {
		return playDate;
	}
	public void setPlayDate(Date playDate) {
		this.playDate = playDate;
	}
	public UserAccount getPlayer() {
		return player;
	}
	public void setPlayer(UserAccount player) {
		this.player = player;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public GameSetting getGameMode() {
		return gameMode;
	}
	public void setGameMode(GameSetting gameMode) {
		this.gameMode = gameMode;
	}

	public int getCorrectType() {
		return correctType;
	}

	public void setCorrectType(int correctType) {
		this.correctType = correctType;
	}

	public int getIncorrectType() {
		return incorrectType;
	}

	public void setIncorrectType(int incorrectType) {
		this.incorrectType = incorrectType;
	}
	
	
}
