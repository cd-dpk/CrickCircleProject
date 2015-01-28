package cricket.main.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import cricket.assist.Assistant;
import cricket.constant.GameMode;
import cricket.constant.Status;
import cricket.entities.Circle;
import cricket.entities.Match;
import cricket.entities.Sector;
import cricket.intrface.View;
import cricket.main.thread.Ball;
import cricket.main.thread.Commentator;
import cricket.serialization.OUTPUT;
import cricket.single.SingleMatchNoteBook;
import cricket.tournament.TournamentFrame;
import cricket.tournament.TournamentNoteBook;

public class CrickCircle extends JFrame implements View {
	
		public static boolean notSelectedFlag = true;
		public static boolean commentry=false;
		
		public static String timeLineStr="";
		public static JProgressBar progressBar;
		public static JProgressBar progressBar1;
		public static JTextField click,wait;
		
		public static Field gameField;
		public static List<Sector>list;
		public static Sector sector;
		
		public static JButton nextBallButton;
		public static JButton singleMatchNoteBook;
		public static JButton tournamentMatchNoteBook;
		
		public static JLabel onCrease;
		public static JButton strikeBatsText;
		public static String strikeStr="Virat 30(10)";
		public static String strikeStk="*";
		
		public static JButton nonStrikeBatsText;
		public static String nonStrikeStr="Dhoni 39(20)";
		public static String nonStrikeStk=" ";
		
		public static  JLabel timeLineLabel;
		public static  JTextField timeLineTextField;
		public static  JButton prevTimeLineButton;
		public static  JButton nextTimeLineButton;
		public static  JLabel commentryLabel;
		public static JTextArea commentryTextArea;
		public static JLabel image;
		Box box;
		public static JLabel scoreLabel;
		public static JLabel runLabel;
		public static JLabel overLabel;
		public static JLabel crtRateLabel;
		public static JLabel rqrRateLabel;
		public static JLabel toWinLabel;
		public static JLabel ballsLabel;
		public static JLabel runText;
		public static String runStr="100/3";
		public static JLabel overText;
		public static String overStr="1.5";
		public static JLabel crtRateText;
		public static String crtRateStr="5.0";
		public static JLabel rqrRateText;
		public static String rqrRateStr="5.0";
		public static JLabel toWinText;
		public static String toWinStr="10";
		public static  JLabel ballsText;
		public static String ballsStr="5";
		public static List<Integer> showOption=new ArrayList<Integer>();
		public static  JLabel targetLabel;
		public static  JLabel targetText;
		public static String targetStr="100(20.0)";
		public static  JLabel oponentLabel;
		public static String oponentStr="Ban";
		public static  JLabel oponentText;
		public static String oponentStrText;
		Circle circle;
		public static JButton home,tournamentButton;
		public static Match match;
		public static JLabel [][][] myJLabel=new JLabel[3][2][2];
		public CrickCircle(final Match match){
			setLayout(null);
			init();
			CrickCircle.match=match;
			CrickCircle.match.userInnings.getBatsman().get(0).setStatus(Status.NOT_OUT);
			CrickCircle.match.userInnings.getBatsman().get(1).setStatus(Status.NOT_OUT);
			CrickCircle.notSelectedFlag=true;
			Circle circle=new Circle();
			list=circle.getCircle();
			gameField=new Field(300);
			gameField.setBounds(140, 10,605,605);
			add(gameField);
			
			progressBar = new JProgressBar(0, 100);
			progressBar.setBounds(150, 630, 200, 30);
			progressBar.setValue(0);
			progressBar.setBackground(Color.WHITE);
			progressBar.setForeground(Color.GREEN);
			add(progressBar);
			
			click = new JTextField("Click...");
			click.setBounds(150, 660, 200, 30);
			click.setForeground(Color.green);
			click.setEditable(false);
			add(click);


			progressBar1 = new JProgressBar(0, 100);
			progressBar1.setBounds(350, 630, 200, 30);
			progressBar1.setValue(0);
			progressBar1.setBackground(Color.WHITE);
			progressBar1.setForeground(Color.RED);
			add(progressBar1);
			
			wait = new JTextField("Wait...");
			wait.setBounds(350, 660, 200, 30);
			wait.setForeground(Color.red);
			add(wait);

			timeLineLabel =new JLabel("TimeLine");
			timeLineLabel.setBounds(750+50, 575, 150, 50);
			timeLineLabel.setFont(new Font(timeLineLabel.getText(),Font.BOLD,25));
			add(timeLineLabel);
			timeLineLabel.setForeground(Color.RED);
			prevTimeLineButton=new JButton("<");
			prevTimeLineButton.setBounds(750,575+5,50, 30);
			add(prevTimeLineButton);
			prevTimeLineButton.setBackground(Color.LIGHT_GRAY);
			prevTimeLineButton.setVisible(true);
			
			nextTimeLineButton=new JButton(">");
			nextTimeLineButton.setBounds(950,575+5,50, 30);
			add(nextTimeLineButton);
			nextTimeLineButton.setBackground(Color.lightGray);
			nextTimeLineButton.setVisible(true);
			
			timeLineTextField=new JTextField(timeLineStr,20);
			timeLineTextField.setBounds(700, 630, 300, 50);
			add(timeLineTextField);
			timeLineTextField.setEditable(false);
			timeLineTextField.setBackground(Color.WHITE);
			timeLineTextField.setForeground(Color.BLUE);
			
			commentryLabel =new JLabel("Commentary");
			commentryLabel.setFont(new Font(commentryLabel.getText(),Font.BOLD,25));
			commentryLabel.setBounds(750, 300, 300, 50);
			add(commentryLabel);
			commentryLabel.setForeground(Color.RED);
			
			image =new JLabel("I");
			image.setFont(new Font(image.getText(),Font.BOLD,25));
			image.setBounds(800, 360, 310, 200);
			add(image);
			image.setVisible(false);
			
			box=Box.createHorizontalBox();
			commentryTextArea =new JTextArea("",10,10);
			commentryTextArea.setFont(new Font(commentryTextArea.getText(),Font.BOLD,10));
			commentryTextArea.setBounds(750, 360, 250, 200);
			commentryTextArea.setEditable(false);
			commentryTextArea.setBackground(Color.WHITE);
			box.add(new JScrollPane(commentryTextArea ));
			box.setBounds(750, 360, 250, 200);
			add(box);

			singleMatchNoteBook=new JButton("NoteBook");
			singleMatchNoteBook.setBounds(10, 600, 100, 30);
			singleMatchNoteBook.setBackground(Color.GREEN);
			singleMatchNoteBook.setForeground(Color.RED);
			add(singleMatchNoteBook);

			tournamentMatchNoteBook=new JButton("NoteBook");
			tournamentMatchNoteBook.setBounds(10, 600, 100, 30);
			tournamentMatchNoteBook.setBackground(Color.GREEN);
			tournamentMatchNoteBook.setForeground(Color.RED);
			add(tournamentMatchNoteBook);
			
			if (match.getSettings().getGameMode().equals(GameMode.SINGLE_MATCH)) {
				tournamentMatchNoteBook.setVisible(false);
			}
			else if (match.getSettings().getGameMode().equals(GameMode.TOURNAMENT)) {
				singleMatchNoteBook.setVisible(false);
			}
			
			
			
	/////////////////////////////////////////////////////////////////////////Text///////////////////////////////////////////////////
			scoreLabel =new JLabel("Score");
			scoreLabel.setFont(new Font(scoreLabel.getText(),Font.BOLD,25));
			scoreLabel.setBounds(950-150, 80, 310, 30);
			scoreLabel.setForeground(Color.RED);
			add(scoreLabel);
			
			
			runLabel=new JLabel("Run");
			runLabel.setFont(new Font(runLabel.getText(),Font.BOLD,25));
			runLabel.setBounds(950-150, 115, 150, 30);
			runLabel.setForeground(Color.BLACK);
			add(runLabel);
			
			runText=new JLabel(runStr);
			runText.setFont(new Font(runText.getText(),Font.BOLD,25));
			runText.setBounds(1110-150, 115, 150, 30);
			runText.setForeground(Color.BLUE);
			add(runText);
			
			overLabel=new JLabel("Over");
			overLabel.setFont(new Font(overLabel.getText(),Font.BOLD,25));
			overLabel.setBounds(950-150, 150, 150, 30);
			overLabel.setForeground(Color.BLACK);
			add(overLabel);
			
			overText=new JLabel(overStr);
			overText.setFont(new Font(overText.getText(),Font.BOLD,25));
			overText.setBounds(1110-150, 150, 150, 30);
			overText.setForeground(Color.BLUE);
			add(overText);
			
			
			
			
			myJLabel[0][0][0]=new JLabel("Current Run Rate");
			myJLabel[0][0][0].setFont(new Font(myJLabel[0][0][0].getText(),Font.BOLD,15));
			myJLabel[0][0][0].setBounds(950-150, 190, 150, 30);
			myJLabel[0][0][0].setForeground(Color.BLACK);
			add(myJLabel[0][0][0]);
			myJLabel[0][0][0].setVisible(false);
			
			myJLabel[0][0][1]=new JLabel(crtRateStr);
			myJLabel[0][0][1].setFont(new Font(myJLabel[0][0][1].getText(),Font.BOLD,25));
			myJLabel[0][0][1].setBounds(1110-150, 190, 50, 30);
			myJLabel[0][0][1].setForeground(Color.BLUE);
			add(myJLabel[0][0][1]);
			myJLabel[0][0][1].setVisible(false);
			
			myJLabel[0][1][0]=new JLabel("Required Run Rate ");
			myJLabel[0][1][0].setFont(new Font(myJLabel[0][1][0].getText(),Font.BOLD,15));
			myJLabel[0][1][0].setBounds(950-150, 225, 150, 30);
			myJLabel[0][1][0].setForeground(Color.BLACK);
			add(myJLabel[0][1][0]);
			myJLabel[0][1][0].setVisible(false);
			

			myJLabel[0][1][1]=new JLabel(rqrRateStr);
			myJLabel[0][1][1].setFont(new Font(myJLabel[0][1][1].getText(),Font.BOLD,25));
			myJLabel[0][1][1].setBounds(1110-150, 225, 180, 30);
			myJLabel[0][1][1].setForeground(Color.BLUE);
			add(myJLabel[0][1][1]);
			myJLabel[0][1][1].setVisible(false);
			
			myJLabel[1][0][0]=new JLabel("To Win");
			myJLabel[1][0][0].setFont(new Font(myJLabel[1][0][0].getText(),Font.BOLD,25));
			myJLabel[1][0][0].setBounds(950-150, 190, 150, 30);
			myJLabel[1][0][0].setForeground(Color.BLACK);
			add(myJLabel[1][0][0]);
			myJLabel[1][0][0].setVisible(false);
			
			myJLabel[1][0][1]=new JLabel(toWinStr);
			myJLabel[1][0][1].setFont(new Font(myJLabel[1][0][1].getText(),Font.BOLD,25));
			myJLabel[1][0][1].setBounds(1110-150, 190, 180, 30);
			myJLabel[1][0][1].setForeground(Color.BLUE);
			add(myJLabel[1][0][1]);
			myJLabel[1][0][1].setVisible(false);
			
			myJLabel[1][1][0]=new JLabel("Balls");
			myJLabel[1][1][0].setFont(new Font(myJLabel[1][1][0].getText(),Font.BOLD,25));
			myJLabel[1][1][0].setBounds(950-150, 225, 150, 30);
			myJLabel[1][1][0].setForeground(Color.BLACK);
			add(myJLabel[1][1][0]);
			myJLabel[1][1][0].setVisible(false);
			
			myJLabel[1][1][1]=new JLabel(ballsStr);
			myJLabel[1][1][1].setFont(new Font(myJLabel[1][1][1].getText(),Font.BOLD,25));
			myJLabel[1][1][1].setBounds(1110-150, 225, 180, 30);
			myJLabel[1][1][1].setForeground(Color.BLUE);
			add(myJLabel[1][1][1]);
			myJLabel[1][1][1].setVisible(false);
			

			myJLabel[2][0][0]=new JLabel("Target");
			myJLabel[2][0][0].setFont(new Font(myJLabel[2][0][0].getText(),Font.BOLD,25));
			myJLabel[2][0][0].setBounds(950-150, 190, 150, 30);
			myJLabel[2][0][0].setForeground(Color.BLACK);
			add(myJLabel[2][0][0]);
			myJLabel[2][0][0].setVisible(false);
			
			myJLabel[2][0][1]=new JLabel(targetStr);
			myJLabel[2][0][1].setFont(new Font(myJLabel[2][0][1].getText(),Font.BOLD,25));
			myJLabel[2][0][1].setBounds(1110-150, 190, 180, 30);
			myJLabel[2][0][1].setForeground(Color.BLUE);
			add(myJLabel[2][0][1]);
			myJLabel[2][0][1].setVisible(false);
			
			myJLabel[2][1][0]=new JLabel(oponentStr);
			myJLabel[2][1][0].setFont(new Font(myJLabel[2][1][0].getText(),Font.BOLD,25));
			myJLabel[2][1][0].setBounds(950-150, 225, 150, 30);
			myJLabel[2][1][0].setForeground(Color.BLACK);
			add(myJLabel[2][1][0]);
			myJLabel[2][1][0].setVisible(false);
			
			myJLabel[2][1][1]=new JLabel(oponentStrText);
			myJLabel[2][1][1].setFont(new Font(myJLabel[2][1][1].getText(),Font.BOLD,25));
			myJLabel[2][1][1].setBounds(1110-150, 225, 180, 30);
			myJLabel[2][1][1].setForeground(Color.BLUE);
			add(myJLabel[2][1][1]);
			myJLabel[2][1][1].setVisible(false);
			
////////////////////////////////////////////////////////////////////////////Text///////////////////////////////////			
			nextBallButton=new JButton("NextBall");
			nextBallButton.setBounds(10, 100, 100, 30);
			nextBallButton.setForeground(Color.RED);
			nextBallButton.setBackground(Color.GREEN);
			add(nextBallButton);
			
			home=new JButton("MainMenu");
			home.setFont(new Font(home.getText(),Font.BOLD,15));
			home.setBounds(10, 100, 140, 30);
			home.setBackground(Color.GREEN);
			add(home);
			home.setVisible(false);
			
			tournamentButton=new JButton("Tournament Schedule");
			tournamentButton.setFont(new Font(tournamentButton.getText(),Font.BOLD,10));
			tournamentButton.setBounds(10, 100, 140, 30);
			tournamentButton.setBackground(Color.GREEN);
			add(tournamentButton);
			tournamentButton.setVisible(false);
			
			onCrease=new JLabel("On Crease :");
			onCrease.setBounds(10, 150, 120, 30);
			onCrease.setForeground(Color.RED);
			add(onCrease);
		
			strikeBatsText=new JButton(strikeStk+""+strikeStr);
			strikeBatsText.setBounds(10, 190, 120, 30);
			strikeBatsText.setForeground(Color.BLUE);
			strikeBatsText.setBackground(Color.WHITE);
			add(strikeBatsText);
		
			nonStrikeBatsText=new JButton(nonStrikeStk+""+nonStrikeStr);
			nonStrikeBatsText.setBounds(10, 230, 120, 30);
			nonStrikeBatsText.setForeground(Color.BLUE);
			nonStrikeBatsText.setBackground(Color.WHITE);
			add(nonStrikeBatsText);
			
			decorateGameField();
			
			home.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent event) {
					// TODO Auto-generated method stub
					CrickCircle.this.dispose();
					MainMenu frame=new MainMenu(match.getSettings());
					frame.setView(1300, 700);
				}
			});
			tournamentButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					CrickCircle.this.dispose();
					TournamentFrame frame=new TournamentFrame(match.getTournament());
					frame.setView(1300, 700);
				}
			});
			
			nextBallButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent event) {
					nextBallButton.setEnabled(false);
					CrickCircle.match.initBall();
					System.out.println(CrickCircle.match.ball.selectionTime);
					long time = System.currentTimeMillis();		
					CrickCircle.match.ball.selectionTime =(long) (14.0-2*CrickCircle.match.getSettings().toDouble(CrickCircle.match.getSettings().getLevel()));
					CrickCircle.match.ball.totalTimeofRotate=CrickCircle.match.ball.selectionTime+5;
					CrickCircle.match.ball.selectionTimeInSys = time + (int)(CrickCircle.match.ball.selectionTime) * 1000;
					CrickCircle.match.ball.totalTimeofRotateInSys = time + (int) (CrickCircle.match.ball.totalTimeofRotate)*1000;
					Circle circle=new Circle(CrickCircle.match.userInnings.getPlayers().get(CrickCircle.match.userInnings.getStrikeIndex()));
					list=circle.getCircle();
					progressBar = new JProgressBar((int)time, (int)CrickCircle.match.ball.selectionTimeInSys);
					progressBar.setBounds(150, 630, 200, 30);
					progressBar.setForeground(Color.green);
					add(progressBar);
					progressBar1 = new JProgressBar((int)CrickCircle.match.ball.selectionTimeInSys, (int)CrickCircle.match.ball.totalTimeofRotateInSys);
					progressBar1.setBounds(350, 630, 200, 30);
					progressBar1.setForeground(Color.red);
					add(progressBar1);
					commentry=false;		 		
			 		CrickCircle.match.ball.intitialVelocity=CrickCircle.match.getSettings().toDouble(CrickCircle.match.getSettings().getLevel())+10.0;
					double V=.01*new Random().nextInt(100);		 
					CrickCircle.match.ball.intitialVelocity=CrickCircle.match.ball.intitialVelocity+V;
					CrickCircle.match.ball.actualX=0;
					CrickCircle.match.ball.actualY=0;
					CrickCircle.match.ball.relativeX=0;
					CrickCircle.match.ball.relativeY=0;
					notSelectedFlag=true;
					CrickCircle.match.ball.intitialVelocity=3.1416*20;
					CrickCircle.match.ball.instantTime = 0.0;
					CrickCircle.match.ball.instantVelocity =CrickCircle.match.ball.intitialVelocity;
					CrickCircle.match.ball.acceleration=CrickCircle.match.ball.intitialVelocity/CrickCircle.match.ball.totalTimeofRotate;
					CrickCircle.match.ball.prevArgc=0;
					CrickCircle.match.ball.newArgc=0.0;
					double totalDistance=.5*CrickCircle.match.ball.intitialVelocity*CrickCircle.match.ball.totalTimeofRotate;
					for(int i=0;i<list.size();i++){
						list.get(i).setStart(list.get(i).getStart()+totalDistance);
						list.get(i).setEnd(list.get(i).getEnd()+totalDistance);
					}
					Thread game = new Thread(new Ball(CrickCircle.this));
					ExecutorService threadExe=Executors.newCachedThreadPool();
					threadExe.execute(game);
					threadExe.execute(new Commentator());
					threadExe.shutdown();
				}
			});
			singleMatchNoteBook.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent arg0) {
						SingleMatchNoteBook dialog=new SingleMatchNoteBook(CrickCircle.this,true,CrickCircle.match);
						dialog.setLocationRelativeTo(CrickCircle.this);
						dialog.setLocation(200,100);
						dialog.setSize(900, 600);
						dialog.show();
					}	
			});
			tournamentMatchNoteBook.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent arg0) {
					TournamentNoteBook dialog=new TournamentNoteBook(CrickCircle.this, true,match.getTournament());
					dialog.setLocationRelativeTo(CrickCircle.this);
					dialog.setLocation(200,100);
					dialog.setSize(900, 600);
					dialog.show();
					}	
			});
			prevTimeLineButton.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent arg0) {
					nextTimeLineButton.setVisible(true);
					if(match.timeLineIndex>0){
						match.timeLineIndex--;
						timeLineStr="";
						int index=match.timeLineIndex;
						for(;index<(match.timeLineIndex+10);index++){
							timeLineStr=timeLineStr+" "+CrickCircle.match.userInnings.getTimeLineStrList().get(index);
						}
						timeLineTextField.setText(timeLineStr);
					}
					if(match.timeLineIndex==0){
						prevTimeLineButton.setVisible(false);
					}
				}
			});
			nextTimeLineButton.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent arg0) {
					prevTimeLineButton.setVisible(true);
					if(match.timeLineIndex<(CrickCircle.match.userInnings.getBalls()-10)){
						match.timeLineIndex++;
						timeLineStr="";
						int index=match.timeLineIndex;
						for(;index<(match.timeLineIndex+10);index++){
							timeLineStr=timeLineStr+" "+CrickCircle.match.userInnings.getTimeLineStrList().get(index);
						}
						timeLineTextField.setText(timeLineStr);
					}
					if(match.timeLineIndex==(CrickCircle.match.userInnings.getBalls()-10)){
						nextTimeLineButton.setVisible(false);
					}
				}
			});
			
			addWindowListener(new WindowAdapter() {
	            public void windowClosing(WindowEvent ev) {
	            	if (CrickCircle.match.getSettings().equals(GameMode.SINGLE_MATCH)) {
	            		int choice=JOptionPane.showConfirmDialog(null, "Do you want to save before closing?");
		            	if (choice==0) {
							CrickCircle.match.isContinue=true;
		            		OUTPUT output=new OUTPUT(CrickCircle.match,"Single");
							output.openfile();
							output.addRecords();
							output.closeFile();
							System.exit(0);
						
		            	} else if (choice==1) {
		            		OUTPUT output=new OUTPUT(new Match (),"Single");
							output.openfile();
							output.addRecords();
							output.closeFile();
							System.exit(0);
						}	
					}else if(CrickCircle.match.getSettings().equals(GameMode.TOURNAMENT)) {
						int choice=JOptionPane.showConfirmDialog(null, "Do you want to save before closing?");
		            	if (choice==0) {
							CrickCircle.match.isContinue=true;
		            		OUTPUT output=new OUTPUT(CrickCircle.match,"Tournament");
							output.openfile();
							output.addRecords();
							output.closeFile();
							System.exit(0);
						
		            	} else if (choice==1) {
		            		OUTPUT output=new OUTPUT(new Match (),"Tournament");
							output.openfile();
							output.addRecords();
							output.closeFile();
							System.exit(0);
						}	
					}
	            	
	                
	            }
	        });
	    }
		@Override
		public void setView(int width,int height) {
			this.setLayout(null);
			this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			this.setSize(width, height);
			this.setVisible(true);
			BackGround background=new BackGround(new Color(150,200,100)); 
			background.setBounds(0, 0, width, height);
			this.add(background);
		}
		public  static void decorateGameField() {
			strikeStr=CrickCircle.match.userInnings.getPlayers().get(CrickCircle.match.userInnings.getStrikeIndex()).getLastName()+" "+CrickCircle.match.userInnings.getBatsman().get(CrickCircle.match.userInnings.getStrikeIndex()).getRun()+"("+CrickCircle.match.userInnings.getBatsman().get(CrickCircle.match.userInnings.getStrikeIndex()).getBall()+")";
			strikeStk="*";
			nonStrikeStr=CrickCircle.match.userInnings.getPlayers().get(CrickCircle.match.userInnings.getNonStrikeIndex()).getLastName()+" "+CrickCircle.match.userInnings.getBatsman().get(CrickCircle.match.userInnings.getNonStrikeIndex()).getRun()+"("+CrickCircle.match.userInnings.getBatsman().get(CrickCircle.match.userInnings.getNonStrikeIndex()).getBall()+")";
			nonStrikeStk=" ";		
			runStr=CrickCircle.match.getUserInnings().getRuns()+"/"+CrickCircle.match.getUserInnings().getWickets();		
			overStr=""+CrickCircle.match.userInnings.getOvers();		
			
			if (CrickCircle.match.getUserInnings().getBalls()==0) {
				crtRateStr="--";
			} else {
				crtRateStr=Double.toString(new Assistant().getRunRate(CrickCircle.match.getUserInnings().getRuns(),CrickCircle.match.getUserInnings().getBalls()));
			}
			if (CrickCircle.match.getUserInnings().getTargetRun()>=CrickCircle.match.getUserInnings().getTargetRun()) {
				if (CrickCircle.match.getUserInnings().getTargetBall()==0) {
					rqrRateStr="--";
				} else {
					rqrRateStr=Double.toString((double)new Assistant().getRunRate(CrickCircle.match.getUserInnings().getTargetRun()-CrickCircle.match.getUserInnings().getRuns(),CrickCircle.match.getUserInnings().getTargetBall()-CrickCircle.match.getUserInnings().getBalls()));
				}
				toWinStr=""+(CrickCircle.match.userInnings.getTargetRun()-CrickCircle.match.userInnings.getRuns());
			}
			else{
				rqrRateStr=""+0.0;
				toWinStr=""+0;
			}
			ballsStr=""+(CrickCircle.match.userInnings.getTargetBall()-CrickCircle.match.userInnings.getBalls());	
			targetStr=CrickCircle.match.userInnings.getTargetRun()+"("+new Assistant().makeDoubleToStringRound(CrickCircle.match.userInnings.getTargetOver())+")";
			oponentStr=CrickCircle.match.opponentInnings.getNation().getCodeNameOfNation();
			oponentStrText=""+CrickCircle.match.opponentInnings.getRuns()+"/"+CrickCircle.match.opponentInnings.getWickets()+"("+CrickCircle.match.opponentInnings.getOvers()+")";
			timeLineStr="";
			if(CrickCircle.match.totalBall>10){
				prevTimeLineButton.setVisible(true);
				nextTimeLineButton.setVisible(false);
				match.timeLineIndex=CrickCircle.match.userInnings.getTimeLineStrList().size()-10;
				timeLineStr="";
				int index=CrickCircle.match.timeLineIndex;
				for(;index<CrickCircle.match.userInnings.getTimeLineStrList().size();index++){
					timeLineStr=CrickCircle.timeLineStr+" "+match.userInnings.getTimeLineStrList().get(index);
				}
			}
			else{
				timeLineStr="";
				match.timeLineIndex=0;
				for(int i=0;i<match.userInnings.getTimeLineStrList().size();i++){
					timeLineStr=timeLineStr+" "+match.userInnings.getTimeLineStrList().get(i);
				}
			}
			timeLineTextField.setText(CrickCircle.timeLineStr);
			strikeBatsText.setText(CrickCircle.strikeStk+""+CrickCircle.strikeStr);
			nonStrikeBatsText.setText(CrickCircle.nonStrikeStk+""+CrickCircle.nonStrikeStr);
			overText.setText(CrickCircle.overStr);
			runText.setText(CrickCircle.runStr);
			myJLabel[0][0][1].setText(CrickCircle.crtRateStr);
			myJLabel[0][1][1].setText(CrickCircle.rqrRateStr);
			myJLabel[1][0][1].setText(CrickCircle.toWinStr);
			myJLabel[1][1][1].setText(CrickCircle.ballsStr);
			myJLabel[2][0][1].setText(CrickCircle.targetStr);
			myJLabel[2][1][0].setText(CrickCircle.oponentStr);
			myJLabel[2][1][1].setText(CrickCircle.oponentStrText);
			progressBar.setValue(0);
			progressBar1.setValue(0);
		}
		public void init(){
			showOption.add(0);
			showOption.add(1);
			showOption.add(2);
		}
}