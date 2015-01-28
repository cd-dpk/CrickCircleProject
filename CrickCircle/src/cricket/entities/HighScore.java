package cricket.entities;

import java.io.Serializable;

public class HighScore  implements Serializable   {

	private String name;
	private long  score;
	private String date;
	public HighScore(){
		
	}
	public HighScore(String name, long score, String date){
		setName(name);
		setScore(score);
		setDate(date);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getScore() {
		return score;
	}
	public void setScore(long score) {
		this.score = score;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}	
}