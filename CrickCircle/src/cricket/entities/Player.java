package cricket.entities;

import java.io.Serializable;

public class Player implements Serializable{
	
	private String firstName;
	private String lastName;
	private String playerID;
	private String nationID;
	private int match;
	private int innings;
	private int NO;
	private double RUNS;
	private double HS;
	private double Average;
	private int BF;
	private double StrikeRate;
	private int hundreds;
	private int fifties;
	private int fours;
	private int sixes;
	private int zeroes;
	private int ones;
	private int twos;
	private int threes;
	private int Bold;
	private int LBW;
	private int ROUT;
	private int Catch;
	private int St;
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getplayerID() {
		return playerID;
	}

	public void setplayerID(String playerID) {
		this.playerID = playerID;
	}
	public String getnationID() {
		return nationID;
	}

	public void setnationID(String nationID) {
		this.nationID = nationID;
	}

	public int getMatch() {
		return match;
	}

	public void setMatch(int match) {
		this.match = match;
	}

	public int getInnings() {
		return innings;
	}

	public void setInnings(int innings) {
		this.innings = innings;
	}

	public int getNO() {
		return NO;
	}

	public void setNO(int nO) {
		NO = nO;
	}

	public double getRUNS() {
		return RUNS;
	}

	public void setRUNS(double rUNS) {
		RUNS = rUNS;
	}

	public double getHS() {
		return HS;
	}

	public void setHS(double hS) {
		HS = hS;
	}

	public double getAverage() {
		return Average;
	}

	public void setAverage(double average) {
		Average = average;
	}

	public int getBF() {
		return BF;
	}

	public void setBF(int bF) {
		BF = bF;
	}

	public double getStrikeRate() {
		return StrikeRate;
	}

	public void setStrikeRate(double strikeRate) {
		StrikeRate = strikeRate;
	}

	public int getHundreds() {
		return hundreds;
	}

	public void setHundreds(int hundreds) {
		this.hundreds = hundreds;
	}

	public int getFifties() {
		return fifties;
	}

	public void setFifties(int fifties) {
		this.fifties = fifties;
	}

	public int getFours() {
		return fours;
	}

	public void setFours(int fours) {
		this.fours = fours;
	}

	public int getSixes() {
		return sixes;
	}

	public void setSixes(int sixes) {
		this.sixes = sixes;
	}

	public int getZeroes() {
		return zeroes;
	}

	public void setZeroes(int zeroes) {
		this.zeroes = zeroes;
	}

	public int getOnes() {
		return ones;
	}

	public void setOnes(int ones) {
		this.ones = ones;
	}

	public int getTwos() {
		return twos;
	}

	public void setTwos(int twos) {
		this.twos = twos;
	}

	public int getThrees() {
		return threes;
	}

	public void setThrees(int threes) {
		this.threes = threes;
	}

	public int getBold() {
		return Bold;
	}

	public void setBold(int bold) {
		Bold = bold;
	}

	public int getLBW() {
		return LBW;
	}

	public void setLBW(int lBW) {
		LBW = lBW;
	}

	public int getROUT() {
		return ROUT;
	}

	public void setROUT(int rOUT) {
		ROUT = rOUT;
	}

	public int getCatch() {
		return Catch;
	}

	public void setCatch(int catch1) {
		Catch = catch1;
	}

	public int getSt() {
		return St;
	}

	public void setSt(int st) {
		St = st;
	}

}
