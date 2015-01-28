package cricket.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import cricket.constant.Stage;

public class Tournament implements Serializable{
	
	private  double extraBonus=0;
	private  double timeBonus=0;
	private  double runRateBonus=0;
	private  double prizeMonus=0;
	private  double totatPoint=0;
	private Settings settings;
	private Nation userNation;
	private List<Edge>groupAEdges=new ArrayList<Edge>();
	private List<Edge>groupBEdges=new ArrayList<Edge>();
	private List<Team> groupA=new ArrayList<Team>();
	private List<Team> groupB=new ArrayList<Team>();
	private Stage stage;
	private int indexOfEdge=0;
	private Nation semiFinal[][];
	private Nation finale[];
	private Nation championNation;
	private int playOffIndex=0;
	
	public void setTournament(Nation userNation, List<Nation>tournamentNations){

		setStage(Stage.GROUP);
		Edge edge;
		this.userNation=userNation;
		Nation nation=new Nation();
		nation.setIdOfNation("null");
		nation.setCodeNameOfNation("TBD");
		nation.setNameOfNation("TBD");
		nation.setFlagOfNation("null");
		nation.setImageOfNation("null");
		nation.setRankOfNation("null");
		
		Team team;
		
		for(int i=0;i<(tournamentNations.size()/2-1);i++){
			for(int j=i+1;j<tournamentNations.size()/2;j++){
				edge=new Edge(tournamentNations.get(i),tournamentNations.get(j),false,nation);
				groupAEdges.add(edge);
			}
			team=new Team();
			team.setIdOfNation(tournamentNations.get(i).getIdOfNation());
			team.setCodeNameOfNation(tournamentNations.get(i).getCodeNameOfNation());
			team.setNameOfNation(tournamentNations.get(i).getNameOfNation());
			team.setFlagOfNation(tournamentNations.get(i).getFlagOfNation());
			team.setImageOfNation(tournamentNations.get(i).getImageOfNation());
			team.setRankOfNation(tournamentNations.get(i).getRankOfNation());
			groupA.add(team);
		}
		Collections.shuffle(groupAEdges);

		team=new Team();
		team.setIdOfNation(tournamentNations.get(tournamentNations.size()/2-1).getIdOfNation());
		team.setCodeNameOfNation(tournamentNations.get(tournamentNations.size()/2-1).getCodeNameOfNation());
		team.setNameOfNation(tournamentNations.get(tournamentNations.size()/2-1).getNameOfNation());
		team.setFlagOfNation(tournamentNations.get(tournamentNations.size()/2-1).getFlagOfNation());
		team.setImageOfNation(tournamentNations.get(tournamentNations.size()/2-1).getImageOfNation());
		team.setRankOfNation(tournamentNations.get(tournamentNations.size()/2-1).getRankOfNation());
		groupA.add(team);
		
		for(int i=tournamentNations.size()/2;i<(tournamentNations.size()-1);i++){
			for(int j=i+1;j<tournamentNations.size();j++){
				edge=new Edge(tournamentNations.get(i),tournamentNations.get(j),false,nation);
				groupBEdges.add(edge);
			}
			team=new Team();
			team.setIdOfNation(tournamentNations.get(i).getIdOfNation());
			team.setCodeNameOfNation(tournamentNations.get(i).getCodeNameOfNation());
			team.setNameOfNation(tournamentNations.get(i).getNameOfNation());
			team.setFlagOfNation(tournamentNations.get(i).getFlagOfNation());
			team.setImageOfNation(tournamentNations.get(i).getImageOfNation());
			team.setRankOfNation(tournamentNations.get(i).getRankOfNation());
			groupB.add(team);
		}
		team=new Team();
		team.setIdOfNation(tournamentNations.get(tournamentNations.size()-1).getIdOfNation());
		team.setCodeNameOfNation(tournamentNations.get(tournamentNations.size()-1).getCodeNameOfNation());
		team.setNameOfNation(tournamentNations.get(tournamentNations.size()-1).getNameOfNation());
		team.setFlagOfNation(tournamentNations.get(tournamentNations.size()-1).getFlagOfNation());
		team.setImageOfNation(tournamentNations.get(tournamentNations.size()-1).getImageOfNation());
		team.setRankOfNation(tournamentNations.get(tournamentNations.size()-1).getRankOfNation());
		groupB.add(team);
		Collections.shuffle(groupBEdges);
		semiFinal=new Nation[2][2];
		for (int i = 0; i < semiFinal.length; i++) {
			for (int j = 0; j < semiFinal[i].length; j++) {
				semiFinal[i][j]=nation;	
			}
		}
		finale=new Nation[2];
		for (int i = 0; i < finale.length; i++) {
			finale[i]=nation;
		}
		championNation=nation;
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
	public List<Edge> getGroupAEdges() {
		return groupAEdges;
	}
	public void setGroupAEdges(List<Edge> groupAEdges) {
		this.groupAEdges = groupAEdges;
	}
	public List<Edge> getGroupBEdges() {
		return groupBEdges;
	}
	public void setGroupBEdges(List<Edge> groupBEdges) {
		this.groupBEdges = groupBEdges;
	}
	public List<Team> getGroupA() {
		return groupA;
	}
	public void setGroupA(List<Team> groupA) {
		this.groupA = groupA;
	}
	public List<Team> getGroupB() {
		return groupB;
	}
	public void setGroupB(List<Team> groupB) {
		this.groupB = groupB;
	}
	public Stage getStage() {
		return stage;
	}
	public void setStage(Stage stage) {
		this.stage = stage;
	}
	public Nation getUserNation() {
		return userNation;
	}
	public void setUserNation(Nation userNation) {
		this.userNation = userNation;
	}
	public Settings getSettings() {
		return settings;
	}
	public void setSettings(Settings settings) {
		this.settings = settings;
	}
	public int getIndexOfEdge() {
		return indexOfEdge;
	}
	public void setIndexOfEdge(int indexOfEdge) {
		this.indexOfEdge = indexOfEdge;
	}
	public Nation[][] getSemiFinal() {
		return semiFinal;
	}
	public void setSemiFinal(Nation semiFinal[][]) {
		this.semiFinal = semiFinal;
	}
	public Nation[] getFinal() {
		return finale;
	}
	public void setFinal(Nation[] finale) {
		this.finale = finale;
	}
	public Nation getChampionNation() {
		return championNation;
	}
	public void setChampionNation(Nation championNation) {
		this.championNation = championNation;
	}
	public int getPlayOffIndex() {
		return playOffIndex;
	}
	public void setPlayOffIndex(int playOffIndex) {
		this.playOffIndex = playOffIndex;
	}
}
