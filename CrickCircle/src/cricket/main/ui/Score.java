package cricket.main.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import cricket.constant.GameMode;
import cricket.constant.Result;
import cricket.constant.Stage;
import cricket.entities.HighScore;
import cricket.entities.Match;
import cricket.entities.Tournament;
import cricket.serialization.highScore.INPUT;
import cricket.serialization.highScore.OUTPUT;
import cricket.tournament.TournamentFrame;

public class Score extends JDialog{

	public static JLabel scoreLabel[];
	JLabel nameLabel[];
	Match match;
	Tournament tournament;
	JLabel	status;
	JLabel score=new JLabel("Score");
	JTextField[] textField;	
	JButton ok;
	List<HighScore>highScore=new ArrayList<HighScore>();
	
	public Score(CrickCircle frame, boolean modal,final Match match){
		super(frame,modal);
		//TODO Single-Match
		setLayout(null);
		this.match=match;
		JLabel label=new JLabel("");
		if (match.result.equals(Result.Win)) {
			label.setText("Match Won :) ");
		}
		else {
			label.setText("Match lost :( ");
		}
		label.setFont(new Font(label.getText(), Font.BOLD, 26));
		label.setBounds(300, 10, 300, 40);
		add(label);
		
		status=new JLabel();
		status.setBounds(250, 400, 250, 30);
		add(status);
		textField=new JTextField[2];
		textField[0]=new JTextField("Enter name");
		textField[0].setBounds(200, 450, 200, 40);
		textField[0].setForeground(Color.BLACK);
		textField[0].setFont(new Font(textField[0].getText(), Font.ITALIC, 25));
		add(textField[0]);
		textField[0].setEditable(false);
		textField[0].setVisible(false);
		textField[1]=new JTextField("");
		textField[1].setForeground(Color.BLACK);
		textField[1].setFont(new Font(textField[1].getText(), Font.ITALIC, 25));
		textField[1].setBounds(400, 450, 200, 40);
		add(textField[1]);
		
		textField[1].setEditable(true);
		textField[1].setVisible(false);
		ok=new JButton("Ok");
		ok.setBounds(600, 450, 60, 40);
		add(ok);
		ok.setVisible(false);
		justifyScore();
		
		if (match.getSettings().getGameMode().equals(GameMode.TOURNAMENT)) {
			if(match.getTournament().getStage().equals(Stage.GROUP)) {
				match.getTournament().getGroupAEdges().get(match.getTournament().getIndexOfEdge()).setPlayed(true);
				if (match.getResult()==Result.Win) {
					match.getTournament().getGroupAEdges().get(match.getTournament().getIndexOfEdge()).setWinNation(match.getUserInnings().getNation());
				} else if (match.getResult()==Result.Loss){
					match.getTournament().getGroupAEdges().get(match.getTournament().getIndexOfEdge()).setWinNation(match.getOpponentInnings().getNation());
				} 
				for (int i = 0; i < match.getTournament().getGroupA().size(); i++) {
					if (match.getTournament().getGroupA().get(i).getIdOfNation().equals(match.getUserInnings().getNation().getIdOfNation())) {
						if (match.getResult().equals(Result.Win)) {
							match.getTournament().getGroupA().get(i).setMatchPlayed(match.getTournament().getGroupA().get(i).getMatchPlayed()+1);
							match.getTournament().getGroupA().get(i).setWon(match.getTournament().getGroupA().get(i).getWon()+1);
							match.getTournament().getGroupA().get(i).setPoint(match.getTournament().getGroupA().get(i).getPoint()+3);
						}
						else if (match.getResult().equals(Result.Draw)){
							match.getTournament().getGroupA().get(i).setMatchPlayed(match.getTournament().getGroupA().get(i).getMatchPlayed()+1);
							match.getTournament().getGroupA().get(i).setDr(match.getTournament().getGroupA().get(i).getDr()+1);
							match.getTournament().getGroupA().get(i).setPoint(match.getTournament().getGroupA().get(i).getPoint()+1);
						}
						else if(match.getResult().equals(Result.Loss)){
							match.getTournament().getGroupA().get(i).setMatchPlayed(match.getTournament().getGroupA().get(i).getMatchPlayed()+1);
							match.getTournament().getGroupA().get(i).setLoss(match.getTournament().getGroupA().get(i).getLoss()+1);
						}
					}
					else if (match.getTournament().getGroupA().get(i).getIdOfNation().equals(match.getOpponentInnings().getNation().getIdOfNation())){
						if (match.getResult().equals(Result.Win)) {
							match.getTournament().getGroupA().get(i).setMatchPlayed(match.getTournament().getGroupA().get(i).getMatchPlayed()+1);
							match.getTournament().getGroupA().get(i).setLoss(match.getTournament().getGroupA().get(i).getLoss()+1);
						}
						else if (match.getResult().equals(Result.Draw)){
							match.getTournament().getGroupA().get(i).setMatchPlayed(match.getTournament().getGroupA().get(i).getMatchPlayed()+1);
							match.getTournament().getGroupA().get(i).setDr(match.getTournament().getGroupA().get(i).getDr()+1);
							match.getTournament().getGroupA().get(i).setPoint(match.getTournament().getGroupA().get(i).getPoint()+1);
						}
						else if(match.getResult().equals(Result.Loss)){
							match.getTournament().getGroupA().get(i).setMatchPlayed(match.getTournament().getGroupA().get(i).getMatchPlayed()+1);
							match.getTournament().getGroupA().get(i).setWon(match.getTournament().getGroupA().get(i).getWon()+1);
							match.getTournament().getGroupA().get(i).setPoint(match.getTournament().getGroupA().get(i).getPoint()+3);
						}
					}
				}
			}
			else if(match.getTournament().getStage().equals(Stage.SEMI_FINAL)) {
				if (match.getTournament().getPlayOffIndex()/2==0) {
					if (match.getResult().equals(Result.Win)) {
						match.getTournament().getFinal()[0]=match.getUserInnings().getNation();
					} else {
						match.getTournament().getFinal()[0]=match.getOpponentInnings().getNation();
					}
				} else  if (match.getTournament().getPlayOffIndex()/2==1){
					if (match.getResult().equals(Result.Win)) {
						match.getTournament().getFinal()[1]=match.getUserInnings().getNation();
					} else {
						match.getTournament().getFinal()[1]=match.getOpponentInnings().getNation();
					}
				}
			}
			else if (match.getTournament().getStage().equals(Stage.FINAL)) {
				if (match.getResult().equals(Result.Win)) {
					match.getTournament().setChampionNation(match.getUserInnings().getNation());
				} else {
					match.getTournament().setChampionNation(match.getOpponentInnings().getNation());
					
				}
			}
		}
		scoreLabel=new JLabel[4];
		nameLabel=new JLabel[4];
		
		nameLabel[0]=new JLabel("Time			Bonus");
		nameLabel[0].setBounds(100,50, 260, 30);
		nameLabel[0].setFont(new Font(nameLabel[0].getText(),Font.BOLD,26));
		nameLabel[0].setForeground(Color.GREEN);
		add(nameLabel[0]);
		
		nameLabel[1]=new JLabel("RunRate		Bonus");
		nameLabel[1].setBounds(100,100, 280, 30);
		nameLabel[1].setFont(new Font(nameLabel[1].getText(),Font.BOLD,26));
		nameLabel[1].setForeground(Color.GREEN);
		add(nameLabel[1]);
		
		nameLabel[2]=new JLabel("PrizeMoney		Bonus");
		nameLabel[2].setBounds(100,150, 280, 30);
		nameLabel[2].setFont(new Font(nameLabel[2].getText(),Font.BOLD,26));
		nameLabel[2].setForeground(Color.GREEN);
		add(nameLabel[2]);
		
		
		nameLabel[3]=new JLabel("Total 			Point");
		nameLabel[3].setBounds(100,300, 280, 30);
		nameLabel[3].setFont(new Font(nameLabel[3].getText(),Font.BOLD,26));
		nameLabel[3].setForeground(Color.GREEN);
		add(nameLabel[3]);

		scoreLabel[0]=new JLabel("<<<<<<");
		scoreLabel[0].setBounds(500,50, 200, 30);
		scoreLabel[0].setFont(new Font(scoreLabel[0].getText(),Font.BOLD,26));
		scoreLabel[0].setForeground(Color.RED);
		add(scoreLabel[0]);
		
		scoreLabel[1]=new JLabel(">>>>>>");
		scoreLabel[1].setBounds(500,100, 200, 30);
		scoreLabel[1].setFont(new Font(scoreLabel[1].getText(),Font.BOLD,26));
		scoreLabel[1].setForeground(Color.RED);
		add(scoreLabel[1]);
		
		scoreLabel[2]=new JLabel("-------------");
		scoreLabel[2].setBounds(500,150, 200, 30);
		scoreLabel[2].setFont(new Font(scoreLabel[2].getText(),Font.BOLD,26));
		scoreLabel[2].setForeground(Color.RED);
		
		add(scoreLabel[2]);
		
		
		scoreLabel[3]=new JLabel("********");
		scoreLabel[3].setBounds(500,300, 200, 30);
		scoreLabel[3].setFont(new Font(scoreLabel[3].getText(),Font.BOLD,26));
		scoreLabel[3].setForeground(Color.RED);
		add(scoreLabel[3]);
		
		score.setBounds(350,350,250,50);
		score.setFont(new Font(score.getText(),Font.ITALIC,50));
		score.setForeground(Color.BLUE);
		add(score);
		
		ok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				ok.setVisible(false);
				textField[1].setEditable(false);
				Calendar localCalendar = Calendar.getInstance(TimeZone.getDefault()); 
		        Date currentTime = localCalendar.getTime();
		        String name=textField[1].getText();
		        HighScore score=new HighScore(name,(int) match.getTotatPoint(),currentTime.toString());
				manageHighScore(highScore,score);
				OUTPUT output=new OUTPUT(highScore, "Single");
				output.openfile();
				output.addRecords();
				output.closeFile();
				
			}
		});
		
		add(new JPanel(){
			@Override
			public void setLayout(LayoutManager fLayoutManager) {
				super.setLayout(null);
			}
			public void paintComponent(Graphics g){
				super.paintComponent(g);
				g.setColor(Color.RED);
				g.drawLine(90, 40, 710, 40);
				g.drawLine(90, 100-10, 710, 100-10);
				g.drawLine(90, 150-10, 710, 150-10);
				g.drawLine(90, 200-10, 710, 200-10);
				g.drawLine(90, 200-10+50, 710, 200-10+50);
				g.drawLine(90, 40, 90, 200-10+50);
				g.drawLine(710, 40, 710, 200-10+50);
				g.drawLine(500-50, 40, 500-50, 200-10+50);
				g.drawLine(90, 200-10+50+50, 710, 200-10+50+50);
				g.drawLine(90, 200-10+50+50+50, 710, 200-10+50+50+50);
				g.drawLine(90, 200-10+50+50, 90, 200-10+50+50+50);
				g.drawLine(710, 200-10+50+50, 710, 200-10+50+50+50);
			}
		});
		
		long sleepTimeB=(long )((double)2000/(double)match.getTimeBonus());
		long sleepRRB=(long )((double)2000/(double)match.getRunRateBonus());
		long sleepPMB=0;
		if(match.getPrizeMonus()!=0){
			sleepPMB=(long )((double)2000/(double)match.getPrizeMonus());
		}
		else{
			sleepPMB=0;
		}
		long sleepTP=(long )((double)2000/(double)match.getTotatPoint());
		
		Thread t1=new Thread(new Counter(0,(long)match.getTimeBonus(),sleepTimeB));
		Thread t2=new Thread(new Counter(1,(long)match.getRunRateBonus(),sleepRRB));
		Thread t3=new Thread(new Counter(2,(long)match.getPrizeMonus(),sleepPMB));
		Thread t5=new Thread(new Counter(3,(long)match.getTotatPoint(),sleepTP));
		
		t1.start();				
		t2.start();
		t3.start();
		t5.start();
	}
	public Score(TournamentFrame frame, boolean modal,final  Tournament tournament){
		super(frame,modal);
		setLayout(null);
		//TODO Tournament
		
		this.tournament=tournament;
		JLabel label=new JLabel("");
		if (tournament.getChampionNation().getIdOfNation().equals(tournament.getUserNation().getIdOfNation())) {
			label.setText("Tournament Won :) ");
		}
		else {
			label.setText("Tournament Lost :( ");
		}
		label.setFont(new Font(label.getText(), Font.BOLD, 26));
		label.setBounds(300, 10, 300, 40);
		add(label);
		
		status=new JLabel();
		status.setBounds(250, 400, 250, 30);
		add(status);
		textField=new JTextField[2];
		textField[0]=new JTextField("Enter name");
		textField[0].setBounds(200, 450, 200, 40);
		textField[0].setForeground(Color.BLACK);
		textField[0].setFont(new Font(textField[0].getText(), Font.ITALIC, 25));
		add(textField[0]);
		textField[0].setEditable(false);
		textField[0].setVisible(false);
		textField[1]=new JTextField("");
		textField[1].setForeground(Color.BLACK);
		textField[1].setFont(new Font(textField[1].getText(), Font.ITALIC, 25));
		textField[1].setBounds(400, 450, 200, 30);
		add(textField[1]);
		ok=new JButton("Ok");
		ok.setBounds(600, 450, 60, 40);
		add(ok);
		ok.setVisible(false);
		justifyScore(tournament);
		scoreLabel=new JLabel[4];
		nameLabel=new JLabel[4];
		
		nameLabel[0]=new JLabel("Time			Bonus");
		nameLabel[0].setBounds(100,50, 260, 30);
		nameLabel[0].setFont(new Font(nameLabel[0].getText(),Font.BOLD,26));
		nameLabel[0].setForeground(Color.GREEN);
		add(nameLabel[0]);
		
		nameLabel[1]=new JLabel("RunRate		Bonus");
		nameLabel[1].setBounds(100,100, 280, 30);
		nameLabel[1].setFont(new Font(nameLabel[1].getText(),Font.BOLD,26));
		nameLabel[1].setForeground(Color.GREEN);
		add(nameLabel[1]);
		
		nameLabel[2]=new JLabel("PrizeMoney		Bonus");
		nameLabel[2].setBounds(100,150, 280, 30);
		nameLabel[2].setFont(new Font(nameLabel[2].getText(),Font.BOLD,26));
		nameLabel[2].setForeground(Color.GREEN);
		add(nameLabel[2]);
		
		
		nameLabel[3]=new JLabel("Total 			Point");
		nameLabel[3].setBounds(100,300, 280, 30);
		nameLabel[3].setFont(new Font(nameLabel[3].getText(),Font.BOLD,26));
		nameLabel[3].setForeground(Color.GREEN);
		add(nameLabel[3]);
		scoreLabel[0]=new JLabel("<<<<<<");
		scoreLabel[0].setBounds(500,50, 200, 30);
		scoreLabel[0].setFont(new Font(scoreLabel[0].getText(),Font.BOLD,26));
		scoreLabel[0].setForeground(Color.RED);
		add(scoreLabel[0]);
		scoreLabel[1]=new JLabel(">>>>>>");
		scoreLabel[1].setBounds(500,100, 200, 30);
		scoreLabel[1].setFont(new Font(scoreLabel[1].getText(),Font.BOLD,26));
		scoreLabel[1].setForeground(Color.RED);
		add(scoreLabel[1]);
		scoreLabel[2]=new JLabel("-------------");
		scoreLabel[2].setBounds(500,150, 200, 30);
		scoreLabel[2].setFont(new Font(scoreLabel[2].getText(),Font.BOLD,26));
		scoreLabel[2].setForeground(Color.RED);
		add(scoreLabel[2]);
		scoreLabel[3]=new JLabel("********");
		scoreLabel[3].setBounds(500,300, 200, 30);
		scoreLabel[3].setFont(new Font(scoreLabel[3].getText(),Font.BOLD,26));
		scoreLabel[3].setForeground(Color.RED);
		add(scoreLabel[3]);
		
		score.setBounds(350,350,250,50);
		score.setFont(new Font(score.getText(),Font.ITALIC,50));
		score.setForeground(Color.BLUE);
		add(score);
		ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ok.setVisible(false);
				textField[1].setEditable(false);
				Calendar localCalendar = Calendar.getInstance(TimeZone.getDefault()); 
		        Date currentTime = localCalendar.getTime();
		        String name=textField[1].getText();
		        HighScore score=new HighScore(name,(int) match.getTotatPoint(),currentTime.toString());
				manageHighScore(highScore,score);
				OUTPUT output=new OUTPUT(highScore, "Tournament");
				output.openfile();
				output.addRecords();
				output.closeFile();
				
			}
		});
		
		add(new JPanel(){
			@Override
			public void setLayout(LayoutManager fLayoutManager) {
				super.setLayout(null);
			}
			public void paintComponent(Graphics g){
				super.paintComponent(g);
				g.setColor(Color.RED);
				g.drawLine(90, 40, 710, 40);
				g.drawLine(90, 100-10, 710, 100-10);
				g.drawLine(90, 150-10, 710, 150-10);
				g.drawLine(90, 200-10, 710, 200-10);
				g.drawLine(90, 200-10+50, 710, 200-10+50);
				g.drawLine(90, 40, 90, 200-10+50);
				g.drawLine(710, 40, 710, 200-10+50);
				g.drawLine(500-50, 40, 500-50, 200-10+50);
				g.drawLine(90, 200-10+50+50, 710, 200-10+50+50);
				g.drawLine(90, 200-10+50+50+50, 710, 200-10+50+50+50);
				g.drawLine(90, 200-10+50+50, 90, 200-10+50+50+50);
				g.drawLine(710, 200-10+50+50, 710, 200-10+50+50+50);
			}
		});
		
		long sleepTimeB=(long )((double)2000/(double)tournament.getTimeBonus());
		long sleepRRB=(long )((double)2000/(double)tournament.getRunRateBonus());
		long sleepPMB=0;
		if(tournament.getPrizeMonus()!=0){
			sleepPMB=(long )((double)2000/(double)tournament.getPrizeMonus());
		}
		else{
			sleepPMB=0;
		}
		long sleepTP=(long )((double)2000/(double)tournament.getTotatPoint());
		
		Thread t1=new Thread(new Counter(0,(long)tournament.getTimeBonus(),sleepTimeB));
		Thread t2=new Thread(new Counter(1,(long)tournament.getRunRateBonus(),sleepRRB));
		Thread t3=new Thread(new Counter(2,(long)tournament.getPrizeMonus(),sleepPMB));
		Thread t5=new Thread(new Counter(3,(long)tournament.getTotatPoint(),sleepTP));
		
		t1.start();				
		t2.start();
		t3.start();
		t5.start();
	}
	
	private class Counter implements Runnable {
		int i;
		long count;
		long sleep;
		int index;
		public Counter(int index ,long count,long sleep) {
			this.count=count;
			this.sleep=sleep;
			this.index=index;
			i=0;
		}
		@Override
		public void run() {
			while(i<count){
				i=i+1;
				Score.scoreLabel[index].setText(i+"");
				try {
					Thread.currentThread().sleep(sleep);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			setUp();
		}
		public void setUp(){
			Score.scoreLabel[index].setText(count+"");
		}
	}
	private  void justifyScore(Tournament tournament){
		INPUT input=new INPUT("Tournament");
		input.openfile();
		input.readRecords();
		input.closeFile();
		highScore=input.highScore;
		for (int i = 0; i <input.highScore.size(); i++) {
			if (match.getTotatPoint()>=highScore.get(i).getScore()) {
				status.setText("You have a new high Score! :)");
				textField[0].setVisible(true);
				textField[1].setVisible(true);
				ok.setVisible(true);
				break;
			}
		}
	}
	private  void  justifyScore(){
		if (match.getSettings().getGameMode().equals(GameMode.SINGLE_MATCH)){
			INPUT input=new INPUT("Single");
			input.openfile();
			input.readRecords();
			input.closeFile();
			highScore=input.highScore;
			
			for (int i = 0; i <input.highScore.size(); i++) {
				if (match.getTotatPoint()>=highScore.get(i).getScore()) {
					status.setText("You have a new high Score! :)");
					textField[0].setVisible(true);
					textField[1].setVisible(true);
					ok.setVisible(true);
					break;
				}
			}
		}
	}
	private void manageHighScore(List<HighScore>list,HighScore score) {
		list.add(score);
		for(int a=1;a<list.size()-1;a++){
			for(int b=list.size()-1;b>=a;b--){
				if(list.get(b-1).getScore()<list.get(b).getScore()){
					HighScore highScore=list.get(b-1);
					list.set(b-1,list.get(b));
					list.set(b,highScore);
				}
			}
		}
		list.remove(list.size()-1);
	}
	
}