package jp.co.fitec.traning.project.typing.gamedata;

public class GameSetting {
	private Mode mode;
	private Level level;
	public GameSetting() {
		
	}
	
	public GameSetting(Mode mode, Level level) {
	
		this.mode = mode;
		this.level = level;
	}
	public Mode getMode() {
		return mode;
	}
	public void setMode(Mode mode) {
		this.mode = mode;
	}
	public Level getLevel() {
		return level;
	}
	public void setLevel(Level level) {
		this.level = level;
	}
	
	
}
