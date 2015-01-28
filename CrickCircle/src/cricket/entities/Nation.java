package cricket.entities;

import java.io.Serializable;

public class Nation implements Serializable{

	private String nameOfNation;
	private String codeNameOfNation;
	private String idOfNation;
	private String flagOfNation;
	private String rankOfNation;
	private String imageOfNation;
	
	

	public String getNameOfNation() {
		return nameOfNation;
	}
	public void setNameOfNation(String nameOfNation) {
		this.nameOfNation = nameOfNation;
	}
	public String getCodeNameOfNation() {
		return codeNameOfNation;
	}
	public void setCodeNameOfNation(String codeNameOfNation) {
		this.codeNameOfNation = codeNameOfNation;
	}
	public String getIdOfNation() {
		return idOfNation;
	}
	public void setIdOfNation(String idOfNation) {
		this.idOfNation = idOfNation;
	}
	public String getFlagOfNation() {
		return flagOfNation;
	}
	public void setFlagOfNation(String flagOfNation) {
		this.flagOfNation = flagOfNation;
	}
	public String getRankOfNation() {
		return rankOfNation;
	}
	public void setRankOfNation(String rankOfNation) {
		this.rankOfNation = rankOfNation;
	}
	public String getImageOfNation() {
		return imageOfNation;
	}
	public void setImageOfNation(String imageOfNation) {
		this.imageOfNation = imageOfNation;
	}
}