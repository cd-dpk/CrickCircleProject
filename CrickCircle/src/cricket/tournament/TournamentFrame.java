package cricket.tournament;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import cricket.constant.Stage;
import cricket.entities.Edge;
import cricket.entities.Nation;
import cricket.entities.Team;
import cricket.entities.Tournament;
import cricket.intrface.View;
import cricket.main.ui.BackGround;
import cricket.main.ui.CrickCircle;
import cricket.main.ui.MainMenu;
import cricket.main.ui.MatchFrame;
import cricket.main.ui.Score;

public class TournamentFrame extends JFrame implements View {

	MatchSchedule groupASchPanel,groupBSchPanel;
	PlayOFF playOff;
	PointTable groupATable;
	PointTable groupBTable;
	JButton groupASchButton,groupBSchButton,groupATableButton,groupBTableButton,playoffButton;
	JButton play;
	Tournament tournament;
	JButton mainMenu;
	public TournamentFrame(final Tournament tournament) {
		super("Tournament");
		setLayout(null);
		this.tournament=tournament;
		if (tournament.getStage().equals(Stage.GROUP)){
			setIndex();
			manageGroupEdges(this.tournament.getGroupAEdges(), this.tournament.getGroupA());
			manageGroupEdges(this.tournament.getGroupBEdges(), this.tournament.getGroupB());
			decorateGroupAsc(this.tournament.getGroupA());
			decorateGroupAsc(this.tournament.getGroupB());
			this.tournament.setPlayOffIndex(10);
			if (this.tournament.getIndexOfEdge()>=10) {
				setSemiFinal();
				this.tournament.setPlayOffIndex(-1);	
				for (int i = 0; i < this.tournament.getSemiFinal().length; i++) {
						for (int j = 0; j < this.tournament.getSemiFinal()[i].length; j++) {
							if (this.tournament.getUserNation().getIdOfNation().equals(this.tournament.getSemiFinal()[i][j].getIdOfNation())) {
								this.tournament.setPlayOffIndex(i*2+j);
							}
						}
				}
				this.tournament.setStage(Stage.SEMI_FINAL);
			}
		}else if (this.tournament.getStage().equals(Stage.SEMI_FINAL)){
			this.tournament.setPlayOffIndex(-1);
			for (int i=0; i<this.tournament.getFinal().length;i++) {
				if(this.tournament.getUserNation().getIdOfNation().equals(this.tournament.getFinal()[i].getIdOfNation())){
					this.tournament.setPlayOffIndex(i);
				}
			}
			this.tournament.setStage(Stage.FINAL);
		}
		else if (this.tournament.getStage().equals(Stage.FINAL)) {
			this.tournament.setPlayOffIndex(-1);
			if (this.tournament.getUserNation().getIdOfNation().equals(this.tournament.getChampionNation().getIdOfNation())) {
				this.tournament.setPlayOffIndex(0);
			} 
			this.tournament.setStage(Stage.CHAMPION);
		}
		
		JTextField label=new JTextField("Tournament");
		label.setFont(new Font(label.getText(),Font.BOLD,25));
		label.setBounds(200,30,800,50);
		label.setForeground(Color.BLACK);
		label.setBackground(Color.WHITE);
		label.setEditable(false);
		add(label);
		
		mainMenu=new JButton("Home");
		mainMenu.setFont(new Font(mainMenu.getText(),Font.BOLD,25));
		mainMenu.setBounds(200,650, 200, 30);
		mainMenu.setBackground(Color.BLUE);
		mainMenu.setForeground(Color.MAGENTA);
		add(mainMenu);
		
		groupASchPanel=new MatchSchedule(tournament.getUserNation(),tournament.getGroupAEdges(),tournament.getIndexOfEdge(),"GroupA");
		groupASchPanel.setBounds(200,100, 800, 500);
		add(groupASchPanel);
		groupASchPanel.setVisible(true);
		
		groupBSchPanel=new MatchSchedule(tournament.getUserNation(),tournament.getGroupBEdges(),tournament.getIndexOfEdge(),"GroupB");
		groupBSchPanel.setBounds(200,100, 800, 500);
		add(groupBSchPanel);
		groupBSchPanel.setVisible(false);
		
		groupATable=new PointTable(tournament.getUserNation(),tournament.getGroupA(),"GroupA");
		groupATable.setBounds(200,100, 800, 500);
		add(groupATable);
		groupATable.setVisible(false);
		
		groupBTable=new PointTable(tournament.getUserNation(),tournament.getGroupB(),"GroupB");
		groupBTable.setBounds(200,100, 800, 500);
		add(groupBTable);
		groupBTable.setVisible(false);
		
		
		groupASchButton=new JButton("GA Matches");
		groupASchButton.setBounds(200,600,160, 30);
		groupASchButton.setBackground(Color.WHITE);
		groupASchButton.setForeground(Color.MAGENTA);
		add(groupASchButton);
		

		groupBSchButton=new JButton("GB Matches");
		groupBSchButton.setBounds(360,600,160, 30);
		groupBSchButton.setBackground(Color.BLUE);
		groupBSchButton.setForeground(Color.MAGENTA);
		add(groupBSchButton);
		
		groupATableButton=new JButton("GA Tabel ");
		groupATableButton.setBounds(520,600,160 , 30);
		groupATableButton.setBackground(Color.BLUE);
		groupATableButton.setForeground(Color.MAGENTA);
		add(groupATableButton);
		
		groupBTableButton=new JButton("GB Tabel");
		groupBTableButton.setBounds(680,600,160 , 30);
		groupBTableButton.setBackground(Color.BLUE);
		groupBTableButton.setForeground(Color.MAGENTA);
		add(groupBTableButton);
		

		playoffButton=new JButton("PlayOff");
		playoffButton.setBounds(840,600,160 , 30);
		playoffButton.setForeground(Color.MAGENTA);
		playoffButton.setBackground(Color.BLUE);
		add(playoffButton);
		
		playOff=new PlayOFF(tournament);
		playOff.setBounds(200, 100, 800, 500);
		add(playOff);
		playOff.setVisible(true);
		
		play=new JButton("Play");
		play.setBounds(500, 650, 200,30);
		play.setBackground(Color.BLUE);
		play.setForeground(Color.MAGENTA);
		play.setVisible(true);
		add(play);
		
		playoffButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				groupASchPanel.setVisible(false);
				groupBSchPanel.setVisible(false);
				groupATable.setVisible(false);
				groupBTable.setVisible(false);
				playOff.setVisible(true);
				
				groupASchButton.setBackground(Color.BLUE);
				groupBSchButton.setBackground(Color.BLUE);
				groupATableButton.setBackground(Color.BLUE);
				groupBTableButton.setBackground(Color.BLUE);
				playoffButton.setBackground(Color.WHITE);
				
			}
			
		});
		groupASchButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				groupBSchPanel.setVisible(false);
				groupASchPanel.setVisible(true);
				groupATable.setVisible(false);
				groupBTable.setVisible(false);
				playOff.setVisible(false);
				play.setVisible(true);
				groupASchButton.setBackground(Color.WHITE);
				groupBSchButton.setBackground(Color.BLUE);
				groupATableButton.setBackground(Color.BLUE);
				groupBTableButton.setBackground(Color.BLUE);
				playoffButton.setBackground(Color.BLUE);
			}
			
		});
		
		groupBSchButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				groupBSchPanel.setVisible(true);
				groupASchPanel.setVisible(false);
				groupATable.setVisible(false);
				groupBTable.setVisible(false);
				//playOff.setVisible(false);
				groupASchButton.setBackground(Color.BLUE);
				groupBSchButton.setBackground(Color.WHITE);
				groupATableButton.setBackground(Color.BLUE);
				groupBTableButton.setBackground(Color.BLUE);
				playoffButton.setBackground(Color.BLUE);
			}
		});
		groupATableButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				groupBSchPanel.setVisible(false);
				groupASchPanel.setVisible(false);
				groupATable.setVisible(true);
				groupBTable.setVisible(false);
				playOff.setVisible(false);
				
				groupASchButton.setBackground(Color.BLUE);
				groupBSchButton.setBackground(Color.BLUE);
				groupATableButton.setBackground(Color.WHITE);
				groupBTableButton.setBackground(Color.BLUE);
				playoffButton.setBackground(Color.BLUE);
				play.setVisible(false);
			}
		});
		groupBTableButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				groupBSchPanel.setVisible(false);
				groupASchPanel.setVisible(false);
				groupATable.setVisible(false);
				groupBTable.setVisible(true);
				playOff.setVisible(false);
				groupASchButton.setBackground(Color.BLUE);
				groupBSchButton.setBackground(Color.BLUE);
				groupATableButton.setBackground(Color.BLUE);
				groupBTableButton.setBackground(Color.WHITE);
				playoffButton.setBackground(Color.BLUE);
			}
		});
		play.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0){
				//TODO
				/**
				 *  Main Work is done here
				 */
				if (((tournament.getStage().equals(Stage.SEMI_FINAL)|| tournament.getStage().equals(Stage.FINAL))&&tournament.getPlayOffIndex()==-1 )) {
						JOptionPane.showMessageDialog(null, "You are out of the tournament :( ");
						TournamentFrame.this.dispose();
						MainMenu frame=new MainMenu(tournament.getSettings());
						frame.setView(1300, 750);
				}
				else if(tournament.getStage().equals(Stage.CHAMPION)){
					if(tournament.getPlayOffIndex()!=-1){
						JOptionPane.showMessageDialog(null, "You have won the tournament");
					}
					else if(tournament.getPlayOffIndex()==-1){
						JOptionPane.showMessageDialog(null, "You have lost the tournament");
					}
					Score dialog=new Score(TournamentFrame.this, true, tournament);
					dialog.setLocationRelativeTo(TournamentFrame.this);
					dialog.setLocation(200,100);
					dialog.setSize(900, 600);
					dialog.show();
				}
				else{
					TournamentFrame.this.dispose();
					MatchFrame frame=new MatchFrame(tournament);
					frame.setView(1300,800);			
				}	
			}
		});
		mainMenu.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int choice=JOptionPane.showConfirmDialog(null, "Are you sure?", "Confirmation", JOptionPane.WARNING_MESSAGE);
				if(choice==-1| choice==1){
					
				}
				else{
					TournamentFrame.this.dispose();
				}
			}
		});
	}
	private void setSemiFinal() {
		// TODO Auto-generated method stub
		tournament.getSemiFinal()[0][0]=tournament.getGroupA().get(0);
		tournament.getSemiFinal()[0][1]=tournament.getGroupB().get(1);
		tournament.getSemiFinal()[1][0]=tournament.getGroupB().get(0);
		tournament.getSemiFinal()[1][1]=tournament.getGroupA().get(1);
	}
	private  void  decorateGroupAsc(List<Team> group){
		for(int a=1;a<group.size()-1;a++){
			for(int b=group.size()-1;b>=a;b--){
				if(group.get(b-1).getPoint()<group.get(b).getPoint()){
					Team team=group.get(b-1);
					group.set(b-1,group.get(b));
					group.set(b,team);
				}
			}
		}
	}
	private void manageGroupEdges(List<Edge>groupEdges,List<Team>group){
		for(int i=0;i<tournament.getIndexOfEdge();i++){
			if( groupEdges.get(i).isPlayed()==false){
				groupEdges.get(i).setPlayed(true);
				int winner2=new Random().nextInt(2);
				Nation winnerB = null, losserB = null;	
					if(winner2==0){
						winnerB=groupEdges.get(i).getNationA();
						losserB=groupEdges.get(i).getNationB();
					}
					else if(winner2==1){
						winnerB=groupEdges.get(i).getNationB();
						losserB=groupEdges.get(i).getNationA();
					}
					for(int j=0;j<group.size();j++){
						if(winnerB.getIdOfNation().equals(group.get(j).getIdOfNation())){
							group.get(j).setMatchPlayed(group.get(j).getMatchPlayed()+1);
							group.get(j).setWon(group.get(j).getWon()+1);
							group.get(j).setPoint(group.get(j).getPoint()+3);
						}
						if(losserB.getIdOfNation().equals(group.get(j).getIdOfNation())){
							group.get(j).setMatchPlayed(group.get(j).getMatchPlayed()+1);
							group.get(j).setLoss(group.get(j).getLoss()+1);
						}
					}
					groupEdges.get(i).setWinNation(winnerB);
				}
		}
	}
	private void setIndex(){
		int i = 0;
		for (; i < tournament.getGroupAEdges().size(); i++) {
			if(tournament.getGroupAEdges().get(i).getNationA().equals(tournament.getUserNation())&&tournament.getGroupAEdges().get(i).isPlayed()==false){
				tournament.setIndexOfEdge(i);				
				return;
			}
			
		}
		tournament.setIndexOfEdge(i);
		return;
	}
	@Override
	public void setView(int width, int height) {
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(width, height);
		this.setVisible(true);
		BackGround background=new BackGround(new Color(150,200,100)); 
		background.setBounds(0, 0, width, height);
		this.add(background);
	} 
}