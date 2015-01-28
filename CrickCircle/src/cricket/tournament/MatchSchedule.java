package cricket.tournament;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;

import cricket.constant.Stage;
import cricket.entities.Edge;
import cricket.entities.Nation;

public class MatchSchedule extends JPanel{

	List<Edge>groupEdges=new ArrayList<Edge>();
	Nation userNation;
	JLabel matchLabel[],vsLabel[];
	JLabel teamALabel[],teamBLabel[];
	JLabel winnerEdgesLabel[];
	int index;
	public MatchSchedule(Nation userNation,List<Edge>groupEdges,int index,String groupName) {
		setLayout(null);
		this.groupEdges=groupEdges;
		this.userNation=userNation;
		this.index=index;
		
		JLabel groupNameLabel=new JLabel(groupName);
		groupNameLabel.setFont(new Font(groupNameLabel.getText(),Font.BOLD,25));
		groupNameLabel.setBounds(300,10,200,30);
		groupNameLabel.setForeground(Color.BLUE);
		add(groupNameLabel);
		
		matchLabel=new JLabel[groupEdges.size()];
		vsLabel=new JLabel[groupEdges.size()];
		teamALabel=new JLabel[groupEdges.size()];
		teamBLabel=new JLabel[groupEdges.size()];
		winnerEdgesLabel=new JLabel[groupEdges.size()];
		
		JLabel match =new JLabel("Match");
		match.setBounds(20,50,150,30);
		add(match);
		
		JLabel teamA=new JLabel("TeamA");
		teamA.setBounds(180,50,150,30);
		add(teamA);
		
		
		JLabel vs=new JLabel("Vs");
		vs.setBounds(340,50,120,30);
		add(vs);
		
		JLabel teamB=new JLabel("TeamB");
		teamB.setBounds(470,50,150,30);
		add(teamB);
		
		JLabel winner=new JLabel ("Winner");
		winner.setBounds(600,50,150,30);
		add(winner);
		
		
		for(int i=0;i<groupEdges.size();i++){
			matchLabel[i]=new JLabel("Match"+(i+1));
			matchLabel[i].setBounds(20,i*40+40+50,150,30);
			if(groupEdges.get(i).isPlayed()==true){
				matchLabel[i].setForeground(Color.BLACK);
			}
			else{
				matchLabel[i].setForeground(Color.BLUE);
			}
			if(index==i && index<10){
				matchLabel[i].setForeground(Color.GREEN);
			}
			add(matchLabel[i]);
			
			
			teamALabel[i]=new JLabel(groupEdges.get(i).getNationA().getCodeNameOfNation());
			if(groupEdges.get(i).getNationA().getIdOfNation().equals(userNation.getIdOfNation())){
				teamALabel[i].setText("*"+teamALabel[i].getText());
			}
			teamALabel[i].setBounds(180,i*40+40+50,150,30);
			
			if(groupEdges.get(i).isPlayed()==true){
				teamALabel[i].setForeground(Color.BLACK);
			}
			else{
				teamALabel[i].setForeground(Color.BLUE);
			}
			if(index==i&& index<10){
				teamALabel[i].setForeground(Color.GREEN);
			}
			add(teamALabel[i]);
			
			vsLabel[i]=new JLabel("Vs");
			vsLabel[i].setBounds(340,i*40+40+50,120,30);
			if(groupEdges.get(i).isPlayed()==true){
				vsLabel[i].setForeground(Color.BLACK);
			}
			else{
				vsLabel[i].setForeground(Color.BLUE);
			}
			if(index==i&& index<10){
				vsLabel[i].setForeground(Color.GREEN);
			}
			add(vsLabel[i]);
			
			
			teamBLabel[i]=new JLabel(groupEdges.get(i).getNationB().getCodeNameOfNation());
			teamBLabel[i].setBounds(470,i*40+40+50,120,30);
			if(groupEdges.get(i).getNationB().getIdOfNation().equals(userNation.getIdOfNation())){
				teamBLabel[i].setText("*"+teamBLabel[i].getText());
			}
			if(groupEdges.get(i).isPlayed()==true){
				teamBLabel[i].setForeground(Color.BLACK);
			}
			else{
				teamBLabel[i].setForeground(Color.BLUE);
			}
			if(index==i&& index<10){
				teamBLabel[i].setForeground(Color.GREEN);
			}
			add(teamBLabel[i]);
			
			winnerEdgesLabel[i]=new JLabel(groupEdges.get(i).getWinNation().getCodeNameOfNation());
			winnerEdgesLabel[i].setBounds(600,i*40+40+50,120,30);
			if(groupEdges.get(i).isPlayed()==true){
				winnerEdgesLabel[i].setForeground(Color.BLACK);
			}
			else{
				winnerEdgesLabel[i].setForeground(Color.BLUE);
			}
			if(index==i&& index<10){
				winnerEdgesLabel[i].setForeground(Color.GREEN);
			}
			add(winnerEdgesLabel[i]);
		}
	}
}
