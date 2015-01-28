package cricket.entities;

import java.io.Serializable;

import cricket.constant.Status;

/**
 * @author geet
 *
 */
public class Batsman  implements Serializable  {

	private int run;
	private int ball;
	private int noOfSix;
	private int noOfFour;
	private int noOfOne;
	private int noOfTwo;
	private int noOfThree;
	private int noOfZero;
	private Status status;
	
	public int getRun() {
		return run;
	}
	public void setRun(int run) {
		this.run = run;
	}
	public int getBall() {
		return ball;
	}
	public void setBall(int ball) {
		this.ball = ball;
	}
	public int getNoOfSix() {
		return noOfSix;
	}
	public void setNoOfSix(int noOfSix) {
		this.noOfSix = noOfSix;
	}
	public int getNoOfFour() {
		return noOfFour;
	}
	public void setNoOfFour(int noOfFour) {
		this.noOfFour = noOfFour;
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
	public int getNoOfThree() {
		return noOfThree;
	}
	public void setNoOfThree(int noOfThree) {
		this.noOfThree = noOfThree;
	}
	public int getNoOfZero() {
		return noOfZero;
	}
	public void setNoOfZero(int noOfZero) {
		this.noOfZero = noOfZero;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	
}