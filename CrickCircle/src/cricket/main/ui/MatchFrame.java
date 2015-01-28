package cricket.main.ui;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import cricket.constant.Over;
import cricket.constant.Stage;
import cricket.entities.Batsman;
import cricket.entities.Edge;
import cricket.entities.Innings;
import cricket.entities.Match;
import cricket.entities.Nation;
import cricket.entities.Player;
import cricket.entities.Settings;
import cricket.entities.Team;
import cricket.entities.Tournament;
import cricket.intrface.View;
import cricket.main.thread.Counter1;

public class MatchFrame extends JFrame implements View{

	
	static long endTime=0;
	JProgressBar yourTeamPerformance;
	JProgressBar oppositeTeamPerformance;

	JButton yourTeamCodeName;
	JButton oppositeTeamCodeName;
	
	ImageIcon yourIconImg;
	ImageIcon oppositeIconImg;
	
	JLabel yourTeamImg;
	JLabel oppositeTeamImg;
	
	JLabel yourTeamJLabel;
	JLabel oppositeTeamJLabel;
 	
	ImageIcon iconOwn;
	ImageIcon iconOpp;
	
	JLabel yourTeamImageJLabel;
	JLabel oppositeTeamImageJLabel;
	
	JLabel versesImage;
	ImageIcon versesImageIcon;
	
	JLabel yourStrength,oppositeStrength;
	JButton next;
	
	Settings settings;
	JButton findTarget;
	
	static  int run,overBall,wk,targetRun,targetOver; 
	
	JLabel ownScoreJLabel,oppScoreJLabel,ownOversJLabel,oppOversJLabel;
	public static JLabel ownJLabel[];
	public static JLabel oppJLabel[];
	JLabel toWinJLabel,leftOverJLabel,withWicketJLabel;
	
	Nation userNation,opponentNation;
	List<Player>nationPlayers=new ArrayList<Player>();
	List<Batsman>batsmen=new ArrayList<Batsman>();
	
	public MatchFrame(final Nation userNation,final Nation opponentNation,final List<Player> nationPlayers,final List<Batsman>batsmen,final Settings settings) {
		//TODO Remember
		/*
		 *  Single Match
		 * Match Frame not to set target
		 * 
		 */
		
		setLayout(null);
		setBackground(new Color(150,200,100));
		
		JPanel panel=new JPanel();
		panel.setBackground(Color.WHITE);
	
		this.settings=settings;
		this.userNation=userNation;
		this.opponentNation=opponentNation;
		this.nationPlayers=nationPlayers;
		this.batsmen=batsmen;
		
		versesImageIcon=new ImageIcon("src/resource/"+"Vs.png");
		versesImage=new JLabel(versesImageIcon);
		versesImage.setBounds(200+390,100+50,150,150);
		panel.add(versesImage);
	
		next=new JButton("Next");
		next.setBounds(200+400,100+350,100,30);
		next.setBackground(Color.GREEN);
		add(next);
	
		yourTeamJLabel=new JLabel("You");
		yourTeamJLabel.setBounds(200+120,100+10,100,30);
		yourTeamJLabel.setFont(new Font(yourTeamJLabel.getText(),Font.BOLD,25));
		yourTeamJLabel.setForeground(Color.BLACK);
		panel.add(yourTeamJLabel);
	

		oppositeTeamJLabel=new JLabel("Opposite");
		oppositeTeamJLabel.setBounds(200+690,100+10,150,30);
		oppositeTeamJLabel.setFont(new Font(oppositeTeamJLabel.getText(),Font.BOLD,25));
		oppositeTeamJLabel.setForeground(Color.BLACK);
		panel.add(oppositeTeamJLabel);
	


		iconOwn=new ImageIcon("src/resource/"+userNation.getFlagOfNation());
		yourTeamImageJLabel=new JLabel(iconOwn);
		yourTeamImageJLabel.setBounds(200+90, 100+50, 125, 125);
		panel.add(yourTeamImageJLabel);

	
		yourIconImg=new ImageIcon("src/resource/"+userNation.getImageOfNation());
		yourTeamImg=new JLabel(yourIconImg);
		yourTeamImg.setBounds(200+30,100+180,60,60);
		panel.add(yourTeamImg);
	
		yourTeamCodeName=new JButton(userNation.getCodeNameOfNation());
		yourTeamCodeName.setBounds(200+100,100+200,170,30);
		yourTeamCodeName.setForeground(Color.YELLOW);
		yourTeamCodeName.setEnabled(false);
		panel.add(yourTeamCodeName);
	
	
	
		iconOpp=new ImageIcon("src/resource/"+opponentNation.getFlagOfNation());
		oppositeTeamImageJLabel=new JLabel();
		oppositeTeamImageJLabel.setIcon(iconOpp);
		oppositeTeamImageJLabel.setBounds(200+690, 100+50, 125, 125);
		panel.add(oppositeTeamImageJLabel);
	

	oppositeTeamCodeName=new JButton(opponentNation.getCodeNameOfNation());
	oppositeTeamCodeName.setBounds(200+700,100+200,170,30);
	oppositeTeamCodeName.setForeground(Color.YELLOW);
	oppositeTeamCodeName.setEnabled(false);
	panel.add(oppositeTeamCodeName);
	
	
	oppositeIconImg=new ImageIcon("src/resource/"+opponentNation.getImageOfNation());
	oppositeTeamImg=new JLabel();
	oppositeTeamImg.setIcon(oppositeIconImg);
	oppositeTeamImg.setBounds(200+630,100+180,60,60);
	panel.add(oppositeTeamImg);
	

	

	next.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
				MatchFrame.this.dispose();
				JOptionPane.showMessageDialog(null, "What?");
				PlayerSelection frame=new PlayerSelection(userNation,opponentNation,settings);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setSize(1300,700);
				frame.setVisible(true);
				BackGround background=new BackGround(new Color(150,200,100));
				background.setBounds(0,0,1300,700);
				frame.add(background);
		}
		
	});

	}
	public MatchFrame(final Nation userNation,final Nation opponentNation,final List<Player> nationPlayers, final List<Batsman> batsmen, final Settings settings,int a) {
		//TODO Remember
		/*
		 * Single Match
		 * Match Frame  to set target
		 * 
		 */
		setLayout(null);
		setBackground(new Color(150,200,100));
		this.settings=settings;
		this.userNation=userNation;
		this.opponentNation=opponentNation;
		this.nationPlayers=nationPlayers;
		this.batsmen=batsmen;
		
		JTextField label=new JTextField("Single Match-Set Target");
		label.setFont(new Font(label.getText(),Font.BOLD,25));
		label.setBounds(50,100,900,50);
		label.setForeground(Color.BLACK);
		label.setBackground(Color.WHITE);
		label.setEditable(false);
		add(label);
		JPanel panel=new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);
		
		versesImageIcon=new ImageIcon("src/resource/"+("Vs.png"));
		versesImage=new JLabel(versesImageIcon);
		versesImage.setBounds(390,50,150,150);
		panel.add(versesImage);
		
		
		findTarget=new JButton("Find Target");
		findTarget.setFont(new Font(findTarget.getText(),Font.BOLD,25));
		findTarget.setBounds(500,600,200,30);
		findTarget.setBackground(Color.BLUE);
		findTarget.setForeground(Color.MAGENTA);
		add(findTarget);
		
		next=new JButton("Next");
		next.setFont(new Font(next.getText(),Font.BOLD,25));
		next.setBounds(500,600,200,30);
		next.setBackground(Color.BLUE);
		next.setForeground(Color.MAGENTA);
		add(next);
		next.setVisible(false);
		
		yourTeamJLabel=new JLabel("You");
		yourTeamJLabel.setBounds(120,10,100,30);
		yourTeamJLabel.setFont(new Font(yourTeamJLabel.getText(),Font.BOLD,25));
		yourTeamJLabel.setForeground(Color.BLACK);
		panel.add(yourTeamJLabel);
		

		oppositeTeamJLabel=new JLabel("Opposite");
		oppositeTeamJLabel.setBounds(690,10,150,30);
		oppositeTeamJLabel.setFont(new Font(oppositeTeamJLabel.getText(),Font.BOLD,25));
		oppositeTeamJLabel.setForeground(Color.BLACK);
		panel.add(oppositeTeamJLabel);
		


		iconOwn=new ImageIcon("src/resource/"+(userNation.getFlagOfNation()));
		yourTeamImageJLabel=new JLabel(iconOwn);
		yourTeamImageJLabel.setBounds(90,50, 125, 125);
		panel.add(yourTeamImageJLabel);

		
		yourIconImg=new ImageIcon("src/resource/"+(userNation.getImageOfNation()));
		yourTeamImg=new JLabel(yourIconImg);
		yourTeamImg.setBounds(30,180,60,60);
		panel.add(yourTeamImg);
		
		
		yourTeamCodeName=new JButton(userNation.getCodeNameOfNation());
		yourTeamCodeName.setBounds(100,200,170,30);
		yourTeamCodeName.setForeground(Color.YELLOW);
		yourTeamCodeName.setEnabled(false);
		panel.add(yourTeamCodeName);

		MatchFrame.ownJLabel=new JLabel[3];
		MatchFrame.ownJLabel[0]=new JLabel("0");
		MatchFrame.ownJLabel[0].setBounds(210,250,150,50);
		MatchFrame.ownJLabel[0].setFont(new Font(MatchFrame.ownJLabel[0].getText(),Font.BOLD,25));
		MatchFrame.ownJLabel[0].setForeground(Color.BLACK);
		panel.add(MatchFrame.ownJLabel[0]);
		
		MatchFrame.ownJLabel[1]=new JLabel("0");
		MatchFrame.ownJLabel[1].setBounds(210,300,60,50);
		MatchFrame.ownJLabel[1].setFont(new Font(MatchFrame.ownJLabel[1].getText(),Font.BOLD,25));
		MatchFrame.ownJLabel[1].setForeground(Color.BLACK);
		panel.add(MatchFrame.ownJLabel[1]);
		
		toWinJLabel=new JLabel("To Win ");
		toWinJLabel.setBounds(0,250,200,50);
		toWinJLabel.setFont(new Font(toWinJLabel.getText(),Font.BOLD,25));
		toWinJLabel.setForeground(Color.BLACK);
		panel.add(toWinJLabel);
		
		withWicketJLabel=new JLabel("Wicket ");
		withWicketJLabel.setBounds(0,300,200,50);
		withWicketJLabel.setFont(new Font(withWicketJLabel.getText(),Font.BOLD,25));
		withWicketJLabel.setForeground(Color.BLACK);
		panel.add(withWicketJLabel);
		
		
		leftOverJLabel=new JLabel("Overs");
		leftOverJLabel.setBounds(0,350,200,50);
		leftOverJLabel.setFont(new Font(leftOverJLabel.getText(),Font.BOLD,25));
		leftOverJLabel.setForeground(Color.BLACK);
		panel.add(leftOverJLabel);
		
		
		
		
		MatchFrame.ownJLabel[2]=new JLabel("0");
		MatchFrame.ownJLabel[2].setBounds(210,350,200,50);
		MatchFrame.ownJLabel[2].setFont(new Font(MatchFrame.ownJLabel[2].getText(),Font.BOLD,25));
		MatchFrame.ownJLabel[2].setForeground(Color.BLACK);
		panel.add(MatchFrame.ownJLabel[2]);
			
		
		iconOpp=new ImageIcon("src/resource/"+(opponentNation.getFlagOfNation()));
		oppositeTeamImageJLabel=new JLabel();
		oppositeTeamImageJLabel.setIcon(iconOpp);
		oppositeTeamImageJLabel.setBounds(690, 50, 125, 125);
		panel.add( oppositeTeamImageJLabel);
		

		oppositeTeamCodeName=new JButton(opponentNation.getCodeNameOfNation());
		oppositeTeamCodeName.setBounds(700,200,170,30);
		oppositeTeamCodeName.setForeground(Color.YELLOW);
		oppositeTeamCodeName.setEnabled(false);
		panel.add(oppositeTeamCodeName);
		
		
		oppositeIconImg=new ImageIcon("src/resource/"+(opponentNation.getImageOfNation()));
		oppositeTeamImg=new JLabel();
		oppositeTeamImg.setIcon(oppositeIconImg);
		oppositeTeamImg.setBounds(630,180,60,60);
		panel.add(oppositeTeamImg);
		

		oppScoreJLabel=new JLabel("Runs ");
		oppScoreJLabel.setBounds(600-120,250,200,50);
		oppScoreJLabel.setFont(new Font(oppScoreJLabel.getText(),Font.BOLD,25));
		oppScoreJLabel.setForeground(Color.BLACK);
		panel.add(oppScoreJLabel);
		
		JLabel anoppScoreJLabel=new JLabel("Wkts ");
		anoppScoreJLabel.setBounds(600-120,300,200,50);
		anoppScoreJLabel.setFont(new Font(anoppScoreJLabel.getText(),Font.BOLD,25));
		anoppScoreJLabel.setForeground(Color.BLACK);
		panel.add(anoppScoreJLabel);
		
		MatchFrame.oppJLabel=new JLabel[3];
		
		MatchFrame.oppJLabel[0]=new JLabel("0");
		MatchFrame.oppJLabel[0].setBounds(690-120,250,100,50);
		MatchFrame.oppJLabel[0].setFont(new Font(MatchFrame.oppJLabel[0].getText(),Font.BOLD,25));
		MatchFrame.oppJLabel[0].setForeground(Color.BLACK);
		panel.add(MatchFrame.oppJLabel[0]);
		
		MatchFrame.oppJLabel[1]=new JLabel("0");
		MatchFrame.oppJLabel[1].setBounds(600+90-120,300,100,50);
		MatchFrame.oppJLabel[1].setFont(new Font(MatchFrame.oppJLabel[1].getText(),Font.BOLD,25));
		MatchFrame.oppJLabel[1].setForeground(Color.BLACK);
		panel.add(MatchFrame.oppJLabel[1]);
		
		oppOversJLabel=new JLabel("Overs");
		oppOversJLabel.setBounds(600-120,350,200,50);
		oppOversJLabel.setFont(new Font(oppOversJLabel.getText(),Font.BOLD,25));
		oppOversJLabel.setForeground(Color.BLACK);
		panel.add(oppOversJLabel);
		
		MatchFrame.oppJLabel[2]=new JLabel("0");
		MatchFrame.oppJLabel[2].setBounds(600+90-120,350,200,50);
		MatchFrame.oppJLabel[2].setFont(new Font(MatchFrame.oppJLabel[2].getText(),Font.BOLD,25));
		MatchFrame.oppJLabel[2].setForeground(Color.BLACK);
		panel.add(MatchFrame.oppJLabel[2]);

		add(panel);
		panel.setBounds(50,200,900,400);
		findTarget.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
			
					
				long time=System.currentTimeMillis();
				MatchFrame.endTime=time+2*1000;
				
				MatchFrame.run=getTarget();
				MatchFrame.wk=new Random().nextInt(11);
				
				if(MatchFrame.wk<10){
					
					if(settings.getOver()==Over.FIVE){
						MatchFrame.targetOver=30;
						MatchFrame.overBall=30;
					}
					else if(settings.getOver()==Over.TEN){
						MatchFrame.targetOver=60;
						MatchFrame.overBall=60;
					}
					else if(settings.getOver()==Over.TWENTY){
						MatchFrame.targetOver=120;
						MatchFrame.overBall=120;
					}
						
				}
				else{
					if(settings.getOver()==Over.FIVE){
						MatchFrame.targetOver=30;
						MatchFrame.overBall=15+new Random().nextInt(15);
					}
					else if(settings.getOver()==Over.TEN){
						MatchFrame.targetOver=60;
						MatchFrame.overBall=30+new Random().nextInt(30);
					}
					else if(settings.getOver()==Over.TWENTY){
						MatchFrame.targetOver=120;
						MatchFrame.overBall=60+new Random().nextInt(60);
					}
				}
				
				
				System.out.println("Run :"+run+"/"+wk+"\nOver  :"+overBall);
				long sleepRun=(long )((double)2000/(double)run);
				long sleepWk=(long )((double)2000/(double)wk);
				long sleepOvr=(long )((double)2000/(double)overBall);
				
				
				Thread t1=new Thread(new Counter1(0,run,sleepRun,settings));
				Thread t2=new Thread(new Counter1(1,wk,sleepWk,settings));
				Thread t3=new Thread(new Counter1(2,overBall,sleepOvr,settings));
				
				t1.start();				
				t2.start();
				t3.start();

				findTarget.setVisible(false);
				next.setVisible(true);
				
			}
			
		});
		
		
		next.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
			
				Innings opponentInnings=new Innings();
				Innings userInnings=new Innings();
				Match match=new Match();
				match.setUserInnings(userInnings);
				match.setOpponentInnings(opponentInnings);
				match.getOpponentInnings().setRuns(MatchFrame.run);
				match.getOpponentInnings().setBalls(MatchFrame.overBall);
				match.getOpponentInnings().setOvers(MatchFrame.overBall/6+0.1*(MatchFrame.overBall%6));
				match.getOpponentInnings().setWickets(MatchFrame.wk);
				match.getOpponentInnings().setNation(opponentNation);

				if (settings.getOver()==Over.FIVE) {
					match.getUserInnings().setTargetBall(5*6);
				}
				else if (settings.getOver()==Over.TEN) {
					match.getUserInnings().setTargetBall(10*6);
				}
				else if (settings.getOver()==Over.TWENTY){
					match.getUserInnings().setTargetBall(20*6);
				}
				match.getUserInnings().setTargetOver((double) (userInnings.getTargetBall())/6.0+0.1*(userInnings.getTargetBall()%6));
				match.getUserInnings().setTargetWKT(10);
				match.getUserInnings().setTargetRun(opponentInnings.getRuns()+1);
				//TODO
				/**
				 * Testing
				 */
				//match.getUserInnings().setTargetRun(1);
				//Testing End//
				match.getUserInnings().setNation(userNation);
				match.setSettings(settings);
				match.getUserInnings().setBatsman(batsmen);
				match.getUserInnings().setPlayers(nationPlayers);
				
				
				System.out.println(match.getUserInnings().getTargetBall());
				System.out.println(match.getUserInnings().getTargetRun());
				System.out.println(match.getUserInnings().getTargetWKT());
				
				
				System.out.println(match.getOpponentInnings().getBalls());
				System.out.println(match.getOpponentInnings().getRuns());
				System.out.println(match.getOpponentInnings().getWickets());
				
				MatchFrame.this.dispose();
				
				CrickCircle frame=new CrickCircle(match);
				frame.setView(1300, 750);
				}
		});
}
	public MatchFrame(final Tournament tournament) {
		//TODO Remember
		/**
		 * Tournament Match
		 * Match Frame  to see the match
		 * 
		 */
		if (tournament.getStage().equals(Stage.GROUP)) {
			userNation=tournament.getGroupAEdges().get(tournament.getIndexOfEdge()).getNationA();
			opponentNation=tournament.getGroupAEdges().get(tournament.getIndexOfEdge()).getNationB();
		}
		else if (tournament.getStage().equals(Stage.SEMI_FINAL)){
			if ((tournament.getPlayOffIndex()/2)==0) {
				if(tournament.getPlayOffIndex()%2==0){
					userNation=tournament.getSemiFinal()[0][0];
					opponentNation=tournament.getSemiFinal()[0][1];
				}
				else if (tournament.getPlayOffIndex()%2==1){
					userNation=tournament.getSemiFinal()[0][1];
					opponentNation=tournament.getSemiFinal()[0][0];
				}
				int winner2=new Random().nextInt(2);
				if (winner2==0) {
					tournament.getFinal()[1]=tournament.getSemiFinal()[1][0];
				} else {
					tournament.getFinal()[1]=tournament.getSemiFinal()[1][1];
				}
			
			} else  if((tournament.getPlayOffIndex()/2)==1){
				if(tournament.getPlayOffIndex()%2==0){
					userNation=tournament.getSemiFinal()[1][0];
					opponentNation=tournament.getSemiFinal()[1][1];
				}
				else if (tournament.getPlayOffIndex()%2==1){
					userNation=tournament.getSemiFinal()[1][1];
					opponentNation=tournament.getSemiFinal()[1][0];
				}
				int winner2=new Random().nextInt(2);
				if (winner2==0) {
					tournament.getFinal()[1]=tournament.getSemiFinal()[0][0];
				} else {
					tournament.getFinal()[1]=tournament.getSemiFinal()[0][1];
				}
			}
		}
		else if (tournament.getStage().equals(Stage.FINAL)){
			if(tournament.getPlayOffIndex()==0){
				userNation=tournament.getFinal()[0];
				opponentNation=tournament.getFinal()[1];
			}
			else  if(tournament.getPlayOffIndex()==1){
				userNation=tournament.getFinal()[1];
				opponentNation=tournament.getFinal()[0];
			}
		}
		settings=tournament.getSettings();
		setLayout(null);
		setBackground(new Color(150,200,100));
		
		JTextField label=new JTextField("Tournament Match");
		label.setFont(new Font(label.getText(),Font.BOLD,25));
		label.setBounds(200,50,900,50);
		label.setForeground(Color.BLACK);
		label.setBackground(Color.WHITE);
		label.setEditable(false);
		add(label);
		
		JPanel panel=new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);
		
		versesImageIcon=new ImageIcon("src/resource/"+"Vs.png");
		versesImage=new JLabel(versesImageIcon);
		versesImage.setBounds(390,50,150,150);
		panel.add(versesImage);
	
		next=new JButton("Next");
		next.setBounds(400,350,100,30);
		next.setBackground(Color.BLUE);
		next.setForeground(Color.MAGENTA);
		panel.add(next);
	
		yourTeamJLabel=new JLabel("You");
		yourTeamJLabel.setBounds(120,10,100,30);
		yourTeamJLabel.setFont(new Font(yourTeamJLabel.getText(),Font.BOLD,25));
		yourTeamJLabel.setForeground(Color.BLUE);
		panel.add(yourTeamJLabel);
	

		oppositeTeamJLabel=new JLabel("Opposite");
		oppositeTeamJLabel.setBounds(690,10,150,30);
		oppositeTeamJLabel.setFont(new Font(oppositeTeamJLabel.getText(),Font.BOLD,25));
		oppositeTeamJLabel.setForeground(Color.BLUE);
		panel.add(oppositeTeamJLabel);
	


		iconOwn=new ImageIcon("src/resource/"+(userNation.getFlagOfNation()));
		yourTeamImageJLabel=new JLabel(iconOwn);
		yourTeamImageJLabel.setBounds(90, 50, 125, 125);
		panel.add(yourTeamImageJLabel);

	
		yourIconImg=new ImageIcon("src/resource/"+(userNation.getImageOfNation()));
		yourTeamImg=new JLabel(yourIconImg);
		yourTeamImg.setBounds(30,180,60,60);
		panel.add(yourTeamImg);
	
		yourTeamCodeName=new JButton(userNation.getCodeNameOfNation());
		yourTeamCodeName.setBounds(100,200,170,30);
		yourTeamCodeName.setForeground(Color.YELLOW);
		yourTeamCodeName.setEnabled(false);
		panel.add(yourTeamCodeName);
	
	
	
		iconOpp=new ImageIcon("src/resource/"+(opponentNation.getFlagOfNation()));
		oppositeTeamImageJLabel=new JLabel();
		oppositeTeamImageJLabel.setIcon(iconOpp);
		oppositeTeamImageJLabel.setBounds(690, 50, 125, 125);
		panel.add(oppositeTeamImageJLabel);

	oppositeTeamCodeName=new JButton(opponentNation.getCodeNameOfNation());
	oppositeTeamCodeName.setBounds(700,200,170,30);
	oppositeTeamCodeName.setForeground(Color.YELLOW);
	oppositeTeamCodeName.setEnabled(false);
	panel.add(oppositeTeamCodeName);
	
	
	oppositeIconImg=new ImageIcon("src/resource/"+(opponentNation.getImageOfNation()));
	oppositeTeamImg=new JLabel();
	oppositeTeamImg.setIcon(oppositeIconImg);
	oppositeTeamImg.setBounds(630,180,60,60);
	panel.add(oppositeTeamImg);
	
	panel.setBounds(200, 200, 900,400);
	add(panel);
	

	next.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent arg0) {
			MatchFrame.this.dispose();
			PlayerSelection frame=new PlayerSelection(tournament) ;
			frame.setView(1300, 800);
		}
	
	});
	}
	public MatchFrame(final Tournament tournament,final List<Player>nationPlayers, final List<Batsman> batsmen) {
		//TODO Remember
		/*
		 * Tournament Match
		 * Match Frame  to set target
		 * 
		 */
		setLayout(null);
		
		if (tournament.getStage().equals(Stage.GROUP)) {
			userNation=tournament.getGroupAEdges().get(tournament.getIndexOfEdge()).getNationA();
			opponentNation=tournament.getGroupAEdges().get(tournament.getIndexOfEdge()).getNationB();
		}
		else if (tournament.getStage().equals(Stage.SEMI_FINAL)){
			if ((tournament.getPlayOffIndex()/2)==0) {
				if(tournament.getPlayOffIndex()%2==0){
					userNation=tournament.getSemiFinal()[0][0];
					opponentNation=tournament.getSemiFinal()[0][1];
				}
				else if (tournament.getPlayOffIndex()%2==1){
					userNation=tournament.getSemiFinal()[0][1];
					opponentNation=tournament.getSemiFinal()[0][0];
				}
			} else  if((tournament.getPlayOffIndex()/2)==1){
				if(tournament.getPlayOffIndex()%2==0){
					userNation=tournament.getSemiFinal()[1][0];
					opponentNation=tournament.getSemiFinal()[1][1];
				}
				else if (tournament.getPlayOffIndex()%2==1){
					userNation=tournament.getSemiFinal()[1][1];
					opponentNation=tournament.getSemiFinal()[1][0];
				}
			}
		}
		else if (tournament.getStage().equals(Stage.FINAL)){
			if(tournament.getPlayOffIndex()==0){
				userNation=tournament.getFinal()[0];
				opponentNation=tournament.getFinal()[1];
			}
			else  if(tournament.getPlayOffIndex()==1){
				userNation=tournament.getFinal()[1];
				opponentNation=tournament.getFinal()[0];
			}
		}
		this.settings=tournament.getSettings();
		this.nationPlayers=nationPlayers;
		this.batsmen=batsmen;
		
		JTextField label=new JTextField("Tournament Match-Set Target");
		label.setFont(new Font(label.getText(),Font.BOLD,25));
		label.setBounds(50,100,900,50);
		label.setForeground(Color.BLACK);
		label.setBackground(Color.WHITE);
		label.setEditable(false);
		add(label);
		JPanel panel=new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);
		
		versesImageIcon=new ImageIcon("src/resource/"+("Vs.png"));
		versesImage=new JLabel(versesImageIcon);
		versesImage.setBounds(390,50,150,150);
		panel.add(versesImage);
		
		
		findTarget=new JButton("Find Target");
		findTarget.setFont(new Font(findTarget.getText(),Font.BOLD,25));
		findTarget.setBounds(500,600,200,30);
		findTarget.setBackground(Color.BLUE);
		findTarget.setForeground(Color.MAGENTA);
		add(findTarget);
		
		next=new JButton("Next");
		next.setFont(new Font(next.getText(),Font.BOLD,25));
		next.setBounds(500,600,200,30);
		next.setBackground(Color.BLUE);
		next.setForeground(Color.MAGENTA);
		add(next);
		next.setVisible(false);
		
		yourTeamJLabel=new JLabel("You");
		yourTeamJLabel.setBounds(120,10,100,30);
		yourTeamJLabel.setFont(new Font(yourTeamJLabel.getText(),Font.BOLD,25));
		yourTeamJLabel.setForeground(Color.BLACK);
		panel.add(yourTeamJLabel);
		

		oppositeTeamJLabel=new JLabel("Opposite");
		oppositeTeamJLabel.setBounds(690,10,150,30);
		oppositeTeamJLabel.setFont(new Font(oppositeTeamJLabel.getText(),Font.BOLD,25));
		oppositeTeamJLabel.setForeground(Color.BLACK);
		panel.add(oppositeTeamJLabel);
		


		iconOwn=new ImageIcon("src/resource/"+(userNation.getFlagOfNation()));
		yourTeamImageJLabel=new JLabel(iconOwn);
		yourTeamImageJLabel.setBounds(90,50, 125, 125);
		panel.add(yourTeamImageJLabel);

		
		yourIconImg=new ImageIcon("src/resource/"+(userNation.getImageOfNation()));
		yourTeamImg=new JLabel(yourIconImg);
		yourTeamImg.setBounds(30,180,60,60);
		panel.add(yourTeamImg);
		
		
		yourTeamCodeName=new JButton(userNation.getCodeNameOfNation());
		yourTeamCodeName.setBounds(100,200,170,30);
		yourTeamCodeName.setForeground(Color.YELLOW);
		yourTeamCodeName.setEnabled(false);
		panel.add(yourTeamCodeName);

		MatchFrame.ownJLabel=new JLabel[3];
		MatchFrame.ownJLabel[0]=new JLabel("0");
		MatchFrame.ownJLabel[0].setBounds(210,250,150,50);
		MatchFrame.ownJLabel[0].setFont(new Font(MatchFrame.ownJLabel[0].getText(),Font.BOLD,25));
		MatchFrame.ownJLabel[0].setForeground(Color.BLACK);
		panel.add(MatchFrame.ownJLabel[0]);
		
		MatchFrame.ownJLabel[1]=new JLabel("0");
		MatchFrame.ownJLabel[1].setBounds(210,300,60,50);
		MatchFrame.ownJLabel[1].setFont(new Font(MatchFrame.ownJLabel[1].getText(),Font.BOLD,25));
		MatchFrame.ownJLabel[1].setForeground(Color.BLACK);
		panel.add(MatchFrame.ownJLabel[1]);
		
		toWinJLabel=new JLabel("To Win ");
		toWinJLabel.setBounds(0,250,200,50);
		toWinJLabel.setFont(new Font(toWinJLabel.getText(),Font.BOLD,25));
		toWinJLabel.setForeground(Color.BLACK);
		panel.add(toWinJLabel);
		
		withWicketJLabel=new JLabel("Wicket ");
		withWicketJLabel.setBounds(0,300,200,50);
		withWicketJLabel.setFont(new Font(withWicketJLabel.getText(),Font.BOLD,25));
		withWicketJLabel.setForeground(Color.BLACK);
		panel.add(withWicketJLabel);
		
		
		leftOverJLabel=new JLabel("Overs");
		leftOverJLabel.setBounds(0,350,200,50);
		leftOverJLabel.setFont(new Font(leftOverJLabel.getText(),Font.BOLD,25));
		leftOverJLabel.setForeground(Color.BLACK);
		panel.add(leftOverJLabel);
		
		
		
		
		MatchFrame.ownJLabel[2]=new JLabel("0");
		MatchFrame.ownJLabel[2].setBounds(210,350,200,50);
		MatchFrame.ownJLabel[2].setFont(new Font(MatchFrame.ownJLabel[2].getText(),Font.BOLD,25));
		MatchFrame.ownJLabel[2].setForeground(Color.BLACK);
		panel.add(MatchFrame.ownJLabel[2]);
			
		
		iconOpp=new ImageIcon("src/resource/"+(opponentNation.getFlagOfNation()));
		oppositeTeamImageJLabel=new JLabel();
		oppositeTeamImageJLabel.setIcon(iconOpp);
		oppositeTeamImageJLabel.setBounds(690, 50, 125, 125);
		panel.add( oppositeTeamImageJLabel);
		

		oppositeTeamCodeName=new JButton(opponentNation.getCodeNameOfNation());
		oppositeTeamCodeName.setBounds(700,200,170,30);
		oppositeTeamCodeName.setForeground(Color.YELLOW);
		oppositeTeamCodeName.setEnabled(false);
		panel.add(oppositeTeamCodeName);
		
		
		oppositeIconImg=new ImageIcon("src/resource/"+(opponentNation.getImageOfNation()));
		oppositeTeamImg=new JLabel();
		oppositeTeamImg.setIcon(oppositeIconImg);
		oppositeTeamImg.setBounds(630,180,60,60);
		panel.add(oppositeTeamImg);
		

		oppScoreJLabel=new JLabel("Runs ");
		oppScoreJLabel.setBounds(600-120,250,200,50);
		oppScoreJLabel.setFont(new Font(oppScoreJLabel.getText(),Font.BOLD,25));
		oppScoreJLabel.setForeground(Color.BLACK);
		panel.add(oppScoreJLabel);
		
		JLabel anoppScoreJLabel=new JLabel("Wkts ");
		anoppScoreJLabel.setBounds(600-120,300,200,50);
		anoppScoreJLabel.setFont(new Font(anoppScoreJLabel.getText(),Font.BOLD,25));
		anoppScoreJLabel.setForeground(Color.BLACK);
		panel.add(anoppScoreJLabel);
		
		MatchFrame.oppJLabel=new JLabel[3];
		
		MatchFrame.oppJLabel[0]=new JLabel("0");
		MatchFrame.oppJLabel[0].setBounds(690-120,250,100,50);
		MatchFrame.oppJLabel[0].setFont(new Font(MatchFrame.oppJLabel[0].getText(),Font.BOLD,25));
		MatchFrame.oppJLabel[0].setForeground(Color.BLACK);
		panel.add(MatchFrame.oppJLabel[0]);
		
		MatchFrame.oppJLabel[1]=new JLabel("0");
		MatchFrame.oppJLabel[1].setBounds(600+90-120,300,100,50);
		MatchFrame.oppJLabel[1].setFont(new Font(MatchFrame.oppJLabel[1].getText(),Font.BOLD,25));
		MatchFrame.oppJLabel[1].setForeground(Color.BLACK);
		panel.add(MatchFrame.oppJLabel[1]);
		
		oppOversJLabel=new JLabel("Overs");
		oppOversJLabel.setBounds(600-120,350,200,50);
		oppOversJLabel.setFont(new Font(oppOversJLabel.getText(),Font.BOLD,25));
		oppOversJLabel.setForeground(Color.BLACK);
		panel.add(oppOversJLabel);
		
		MatchFrame.oppJLabel[2]=new JLabel("0");
		MatchFrame.oppJLabel[2].setBounds(600+90-120,350,200,50);
		MatchFrame.oppJLabel[2].setFont(new Font(MatchFrame.oppJLabel[2].getText(),Font.BOLD,25));
		MatchFrame.oppJLabel[2].setForeground(Color.BLACK);
		panel.add(MatchFrame.oppJLabel[2]);

		add(panel);
		panel.setBounds(50,200,900,400);
		findTarget.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				long time=System.currentTimeMillis();
				MatchFrame.endTime=time+2*1000;
				MatchFrame.run=getTarget();
				MatchFrame.wk=new Random().nextInt(11);
				
				if(MatchFrame.wk<10){
					
					if(settings.getOver()==Over.FIVE){
						MatchFrame.targetOver=30;
						MatchFrame.overBall=30;
					}
					else if(settings.getOver()==Over.TEN){
						MatchFrame.targetOver=60;
						MatchFrame.overBall=60;
					}
					else if(settings.getOver()==Over.TWENTY){
						MatchFrame.targetOver=120;
						MatchFrame.overBall=120;
					}
						
				}
				else{
					if(settings.getOver()==Over.FIVE){
						MatchFrame.targetOver=30;
						MatchFrame.overBall=15+new Random().nextInt(15);
					}
					else if(settings.getOver()==Over.TEN){
						MatchFrame.targetOver=60;
						MatchFrame.overBall=30+new Random().nextInt(30);
					}
					else if(settings.getOver()==Over.TWENTY){
						MatchFrame.targetOver=120;
						MatchFrame.overBall=60+new Random().nextInt(60);
					}
				}
				
				
				System.out.println("Run :"+run+"/"+wk+"\nOver  :"+overBall);
				long sleepRun=(long )((double)2000/(double)run);
				long sleepWk=(long )((double)2000/(double)wk);
				long sleepOvr=(long )((double)2000/(double)overBall);
				
				
				Thread t1=new Thread(new Counter1(0,run,sleepRun,settings));
				Thread t2=new Thread(new Counter1(1,wk,sleepWk,settings));
				Thread t3=new Thread(new Counter1(2,overBall,sleepOvr,settings));
				
				t1.start();				
				t2.start();
				t3.start();
				findTarget.setVisible(false);
				next.setVisible(true);
			}
		});
		next.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
			
				Innings opponentInnings=new Innings();
				Innings userInnings=new Innings();
				Match match=new Match(tournament);
				match.setUserInnings(userInnings);
				match.setOpponentInnings(opponentInnings);
				match.getOpponentInnings().setRuns(MatchFrame.run);
				match.getOpponentInnings().setBalls(MatchFrame.overBall);
				match.getOpponentInnings().setOvers(MatchFrame.overBall/6+0.1*(MatchFrame.overBall%6));
				match.getOpponentInnings().setWickets(MatchFrame.wk);
				match.getOpponentInnings().setNation(opponentNation);

				if (settings.getOver()==Over.FIVE) {
					match.getUserInnings().setTargetBall(5*6);
				}
				else if (settings.getOver()==Over.TEN) {
					match.getUserInnings().setTargetBall(10*6);
				}
				else if (settings.getOver()==Over.TWENTY){
					match.getUserInnings().setTargetBall(20*6);
				}
				match.getUserInnings().setTargetOver((double) (userInnings.getTargetBall())/6.0+0.1*(userInnings.getTargetBall()%6));
				match.getUserInnings().setTargetWKT(10);
				//	match.getUserInnings().setTargetRun(opponentInnings.getRuns()+1);
				/**
				 * Test
				 */
				match.getUserInnings().setTargetRun(1);
				match.getUserInnings().setNation(userNation);
				match.setSettings(settings);
				match.getUserInnings().setBatsman(batsmen);
				match.getUserInnings().setPlayers(nationPlayers);
				
				MatchFrame.this.dispose();
				CrickCircle frame=new CrickCircle(match);
				frame.setView(1300, 800);
				frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			}
		});
	}
	public int getTarget(){
		int target=0;
		double over = settings.toDouble(settings.getOver());
		double level = settings.toDouble(settings.getLevel());	
	
		double usr=Double.parseDouble(userNation.getRankOfNation());		
		double opp=Double.parseDouble(opponentNation.getRankOfNation());
		double differ=usr-opp;
		differ=differ*over*1.0/100.0;
		int lowerTarget=0;
		lowerTarget=(int) Math.ceil(5.0*over+5*(level+1));
		lowerTarget=lowerTarget-(int)Math.ceil(differ);
		int randomRun=new Random().nextInt((int) (2*(level+1)*(over/5)));
		target=lowerTarget+randomRun;	
		return target;
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

	public void getOutCome(Edge edge){
				int winner2=new Random().nextInt(2);
				if (winner2==0) {
					edge.setWinNation(edge.getNationA());
				} else {
					edge.setWinNation(edge.getNationB());
				}
	}
}