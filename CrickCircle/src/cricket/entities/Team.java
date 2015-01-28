package cricket.entities;

import java.io.Serializable;

public class Team  extends Nation implements Serializable{

	private int matchPlayed;
	private int won;
	private int loss;
	private int dr;
	private int point;

	public Team() {
		setMatchPlayed(0);
		setWon(0);
		setLoss(0);
		setDr(0);
		setPoint(0);
		
	}
	public int getMatchPlayed() {
		return matchPlayed;
	}
	public void setMatchPlayed(int matchPlayed) {
		this.matchPlayed = matchPlayed;
	}
	public int getWon() {
		return won;
	}
	public void setWon(int won) {
		this.won = won;
	}
	public int getLoss() {
		return loss;
	}
	public void setLoss(int loss) {
		this.loss = loss;
	}
	public int getDr() {
		return dr;
	}
	public void setDr(int dr) {
		this.dr = dr;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
}
