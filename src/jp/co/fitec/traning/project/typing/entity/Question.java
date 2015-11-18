package jp.co.fitec.traning.project.typing.entity;

import java.io.Serializable;

import jp.co.fitec.traning.project.typing.gamedata.Level;

public class Question implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String question;
	private Level level;

	public Question() {
		
	}
	public Question(String question, Level level) {
		super();
		this.question = question;
		this.level = level;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}
	
}
