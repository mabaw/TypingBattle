package jp.co.fitec.traning.project.typing.entity.hibernate;

import java.io.Serializable;
import java.util.Date;

import jp.co.fitec.traning.project.typing.entity.UserAccount;

public class HibernateResult  implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private UserAccount player;
	private Date playDate;
	private int score;
	private int correctType;
	private int incorrectType;
	private int mode;
	private int level;
	
	
	public HibernateResult() {
		
	}
	

	public int getMode() {
		return mode;
	}


	public void setMode(int mode) {
		this.mode = mode;
	}


	public int getLevel() {
		return level;
	}


	public void setLevel(int level) {
		this.level = level;
	}


	public HibernateResult(UserAccount player, Date playDate, int score,
			int correctType, int incorrectType, int mode, int level) {
		super();
		this.player = player;
		this.playDate = playDate;
		this.score = score;
		this.correctType = correctType;
		this.incorrectType = incorrectType;
		this.mode = mode;
		this.level = level;
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
