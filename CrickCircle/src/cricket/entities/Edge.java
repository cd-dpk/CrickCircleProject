/**
 * 
 * @author dipok
 * @date July 22,2014
 * @comment:
 *	//
 * 		
 * 	//			
 * 
 */
package cricket.entities;

public class Edge {
	
	private Nation NationA;
	private Nation NationB;
	private boolean isPlayed;
	private Nation winNation;
	
	public Edge(Nation NationA,Nation NationB,boolean isPlayed,Nation winNation) {
		this.NationA=NationA;
		this.NationB=NationB;
		this.isPlayed=isPlayed;
		this.setWinNation(winNation);
	}
	
	public Nation getNationA() {
		return NationA;
	}
	public void setNationA(Nation NationA) {
		this.NationA = NationA;
	}
	public Nation getNationB() {
		return NationB;
	}
	public void setNationB(Nation NationB) {
		this.NationB = NationB;
	}
	public boolean isPlayed() {
		return isPlayed;
	}
	public void setPlayed(boolean isPlayed) {
		this.isPlayed = isPlayed;
	}
	public Nation getWinNation() {
		return winNation;
	}

	public void setWinNation(Nation winNation) {
		this.winNation = winNation;
	}

}