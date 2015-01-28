package cricket.entities;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Innings implements Serializable{
	/*
	 * innings attributes 
	 */
	public Innings(){
		
		setTargetRun(0) ;
		setTargetBall(0) ;
		setTargetOver(0.0);
		setTargetWKT(0);
		setNextBatsManIndex(2);
		setStrikeIndex(0) ;
		setNonStrikeIndex(1);
		setSavedTime(0) ;
		setTimeLineIndex(0); 
		setNoOfFour(0) ;
		setNoOfSix(0) ;
		setNoOfOne(0) ;
		setNoOfTwo(0) ;
		setNoOfZeros(0) ;
		setNoOfThree(0) ;
		setNoOfROUT(0) ;
		setNoOfSTM(0) ;
		setNoOfBOLD(0) ;
		setNoOfCATCH(0) ;
		setNoOfLBW(0) ;
		setNoOfWide(0) ;
		setNoOfNoBall(0) ;
		setNoOfExtra(0) ;
		setWickets(0) ;
		setOvers(0.0) ;
		setRuns(0) ;
		setBalls(0) ;
	}
	private Nation nation;
	private int nextBatsManIndex=2;
	private int strikeIndex=0;
	private int nonStrikeIndex=1;
	private long savedTime=0;
	private int timeLineIndex=0;
	private List<String> timeLineStrList=new ArrayList<String>();
	/*
	 * derived attributes
	 */
	private int noOfFour=0;
	private int noOfSix=0;
	private int noOfOne=0;
	private int noOfTwo=0;
	private int noOfZeros=0;
	private int noOfThree=0;
	private int noOfROUT=0;
	private int noOfSTM=0;
	private int noOfBOLD=0;
	private int noOfCATCH=0;
	private int noOfLBW=0;
	private int noOfWide=0;
	private int noOfNoBall=0;
	private int noOfExtra=0;
	/*
	 * main attributes
	 */
	private int wickets=0;
	private double overs=0.0;
	private int runs=0;
	private int balls=0;
	/*
	 * target
	 */
	private int targetRun=0;
	private int targetBall=0;
	private double targetOver=0.0;
	private int targetWKT=0;
	public int getTargetRun() {
		return targetRun;
	}
	public void setTargetRun(int targetRun) {
		this.targetRun = targetRun;
	}
	public int getTargetBall() {
		return targetBall;
	}
	public void setTargetBall(int targetBall) {
		this.targetBall = targetBall;
	}
	public double getTargetOver() {
		return targetOver;
	}
	public void setTargetOver(double targetOver) {
		this.targetOver = targetOver;
	}
	public int getTargetWKT() {
		return targetWKT;
	}
	public void setTargetWKT(int targetWKT) {
		this.targetWKT = targetWKT;
	}
	/**
	 * player
	 */
	private List<Player>players=new ArrayList<Player>();
	
	/*
	 * batsmans who play the innings
	 */
	private List<Batsman>batsman=new ArrayList<Batsman>();	
	/*
	 * nation information	
	 * 
	 */
	public int getNextBatsManIndex() {
		return nextBatsManIndex;
	}
	public void setNextBatsManIndex(int nextBatsManIndex) {
		this.nextBatsManIndex = nextBatsManIndex;
	}
	public int getStrikeIndex() {
		return strikeIndex;
	}
	public void setStrikeIndex(int strikeIndex) {
		this.strikeIndex = strikeIndex;
	}
	public int getNonStrikeIndex() {
		return nonStrikeIndex;
	}
	public void setNonStrikeIndex(int nonStrikeIndex) {
		this.nonStrikeIndex = nonStrikeIndex;
	}
	public long getSavedTime() {
		return savedTime;
	}
	public void setSavedTime(long savedTime) {
		this.savedTime = savedTime;
	}
	public int getTimeLineIndex() {
		return timeLineIndex;
	}
	public void setTimeLineIndex(int timeLineIndex) {
		this.timeLineIndex = timeLineIndex;
	}
	public List<String> getTimeLineStrList() {
		return timeLineStrList;
	}
	public void setTimeLineStrList(List<String> timeLineStrList) {
		this.timeLineStrList = timeLineStrList;
	}
	public int getNoOfFour() {
		return noOfFour;
	}
	public void setNoOfFour(int noOfFour) {
		this.noOfFour = noOfFour;
	}
	public int getNoOfSix() {
		return noOfSix;
	}
	public void setNoOfSix(int noOfSix) {
		this.noOfSix = noOfSix;
	}
	public int getNoOfOne() {
		return noOfOne;
	}
	public void setNoOfOne(int noOfOne) {
		this.noOfOne = noOfOne;
	}
	public int getNoOfTwo() {
		return noOfTwo;
	}
	public void setNoOfTwo(int noOfTwo) {
		this.noOfTwo = noOfTwo;
	}
	public int getNoOfZeros() {
		return noOfZeros;
	}
	public void setNoOfZeros(int noOfZeros) {
		this.noOfZeros = noOfZeros;
	}
	public int getNoOfThree() {
		return noOfThree;
	}
	public void setNoOfThree(int noOfThree) {
		this.noOfThree = noOfThree;
	}
	public int getNoOfROUT() {
		return noOfROUT;
	}
	public void setNoOfROUT(int noOfROUT) {
		this.noOfROUT = noOfROUT;
	}
	public int getNoOfSTM() {
		return noOfSTM;
	}
	public void setNoOfSTM(int noOfSTM) {
		this.noOfSTM = noOfSTM;
	}
	public int getNoOfBOLD() {
		return noOfBOLD;
	}
	public void setNoOfBOLD(int noOfBOLD) {
		this.noOfBOLD = noOfBOLD;
	}
	public int getNoOfCATCH() {
		return noOfCATCH;
	}
	public void setNoOfCATCH(int noOfCATCH) {
		this.noOfCATCH = noOfCATCH;
	}
	public int getNoOfLBW() {
		return noOfLBW;
	}
	public void setNoOfLBW(int noOfLBW) {
		this.noOfLBW = noOfLBW;
	}
	public int getNoOfWide() {
		return noOfWide;
	}
	public void setNoOfWide(int noOfWide) {
		this.noOfWide = noOfWide;
	}
	public int getNoOfNoBall() {
		return noOfNoBall;
	}
	public void setNoOfNoBall(int noOfNoBall) {
		this.noOfNoBall = noOfNoBall;
	}
	public int getNoOfExtra() {
		return noOfExtra;
	}
	public void setNoOfExtra(int noOfExtra) {
		this.noOfExtra = noOfExtra;
	}
	public int getWickets() {
		return wickets;
	}
	public void setWickets(int wickets) {
		this.wickets = wickets;
	}
	public double getOvers() {
		return overs;
	}
	public void setOvers(double overs) {
		this.overs = overs;
	}
	public int getRuns() {
		return runs;
	}
	public void setRuns(int runs) {
		this.runs = runs;
	}
	public int getBalls() {
		return balls;
	}
	public void setBalls(int balls) {
		this.balls = balls;
	}
	public List<Batsman> getBatsman() {
		return batsman;
	}
	public void setBatsman(List<Batsman> batsman) {
		this.batsman = batsman;
	}
	public Nation getNation() {
		return nation;
	}
	public void setNation(Nation nation) {
		this.nation = nation;
	}
	public List<Player> getPlayers() {
		return players;
	}
	public void setPlayers(List<Player> players) {
		this.players = players;
	}
}