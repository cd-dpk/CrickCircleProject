package cricket.entities;

import java.io.Serializable;
import cricket.constant.Result;
import cricket.entities.Ball;
import cricket.entities.Innings;

public class Match implements Serializable{

	private Settings settings;
	public boolean isContinue=false;
	public Result result;
	public double extraBonus=0;
	public double timeBonus=0;
	public double runRateBonus=0;
	public double prizeMonus=0;
	public double totatPoint=0;
	public int timeLineIndex=0;
	public int totalBall=0;
	public Innings userInnings,opponentInnings;

	public Ball ball=null;
	
	private Tournament tournament;
	public Match(){
		ball=new Ball();
	}
	public Match( Tournament tournament){
		ball=new Ball();
		this.tournament=tournament;
	}
	public void initBall(){
		ball=new Ball();
	}
	public Result getResult() {
		return result;
	}
	public void setResult(Result result) {
		this.result = result;
	}
	public double getExtraBonus() {
		return extraBonus;
	}
	public void setExtraBonus(double extraBonus) {
		this.extraBonus = extraBonus;
	}
	public double getTimeBonus() {
		return timeBonus;
	}
	public void setTimeBonus(double timeBonus) {
		this.timeBonus = timeBonus;
	}
	public double getRunRateBonus() {
		return runRateBonus;
	}
	public void setRunRateBonus(double runRateBonus) {
		this.runRateBonus = runRateBonus;
	}
	public double getPrizeMonus() {
		return prizeMonus;
	}
	public void setPrizeMonus(double prizeMonus) {
		this.prizeMonus = prizeMonus;
	}
	public double getTotatPoint() {
		return totatPoint;
	}
	public void setTotatPoint(double totatPoint) {
		this.totatPoint = totatPoint;
	}
	public int getTimeLineIndex() {
		return timeLineIndex;
	}
	public void setTimeLineIndex(int timeLineIndex) {
		this.timeLineIndex = timeLineIndex;
	}
	public int getBalls() {
		return totalBall;
	}
	public void setBalls(int totalBall) {
		this.totalBall = totalBall;
	}
	public Innings getUserInnings() {
		return userInnings;
	}
	public void setUserInnings(Innings userInnings) {
		this.userInnings = userInnings;
	}
	public Innings getOpponentInnings() {
		return opponentInnings;
	}
	public void setOpponentInnings(Innings opponentInnings) {
		this.opponentInnings = opponentInnings;
	}

	public Tournament getTournament() {
		return tournament;
	}

	public void setTournament(Tournament tournament) {
		this.tournament = tournament;
	}
	public Settings getSettings() {
		return settings;
	}
	public void setSettings(Settings settings) {
		this.settings = settings;
	}
} 