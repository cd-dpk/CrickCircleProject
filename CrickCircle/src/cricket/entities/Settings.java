package cricket.entities;
import java.io.Serializable;
import cricket.constant.GameMode;
import cricket.constant.Level;
import cricket.constant.Over;
import cricket.constant.Sound;

public class Settings implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private GameMode gameMode;
	private Sound  sound;
	private Level level;
	private Over doubleOver;
	
	public Settings(GameMode gameMode,Sound  sound,Level level,Over doubleOver) {
		setGameMode(gameMode);
		setSound(sound);
		setLevel(level);
		setOver(doubleOver);
	}
	public Sound getSound() {
		return sound;
	}

	public void setSound(Sound sound) {
		this.sound = sound;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}
	public Over getOver() {
		return doubleOver;
	}
	public void setOver(Over doubleOver) {
		this.doubleOver = doubleOver;
	}
	public GameMode getGameMode() {
		return gameMode;
	}
	public void setGameMode(GameMode gameMode) {
		this.gameMode = gameMode;
	}
	
	public double toDouble(Level level){

		double doubleLevel=0.0;
		
		if(level==Level.EASY)
		{
				doubleLevel=0.0;
		}
		else if (level==Level.MEDIUM){
				doubleLevel=1.0;
		}
		else if(level==Level.HARD){
				doubleLevel=2.0;
		}
		
		return doubleLevel;
	}
	
	public double toDouble(Over over){

		double doubleOver=0.0;
		
		if(over==Over.FIVE){
			doubleOver=5.0;
		}
		else if(over==Over.TEN){
			doubleOver=10.0;
		}
		else if(over==Over.TWENTY){
			doubleOver=20.0;
		}
		
		return doubleOver;
	}
}
