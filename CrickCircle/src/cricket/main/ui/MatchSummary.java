package cricket.main.ui;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import cricket.assist.Assistant;
import cricket.entities.Innings;
public class MatchSummary extends JPanel {

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
	
	
	JLabel ownScoreJLabel,oppScoreJLabel,ownOversJLabel,oppOversJLabel;
	static JLabel ownJLabel[],oppJLabel[];
	JLabel toWinJLabel,leftOverJLabel,withWicketJLabel;

	Innings userInnings,opponentInnings;
	
	public MatchSummary(Innings userInnings,Innings opponentInnings) {
	
		/*
		 * this summary
		 */
		setLayout(null);
		setBackground(Color.WHITE);
		this.userInnings=userInnings;
		this.opponentInnings=opponentInnings;
		versesImageIcon=new ImageIcon("src/resource/"+("Vs.png"));
		versesImage=new JLabel(versesImageIcon);
		versesImage.setBounds(390,50,150,150);
		add(versesImage);
		
		yourTeamJLabel=new JLabel("You");
		yourTeamJLabel.setBounds(120,10,100,30);
		yourTeamJLabel.setFont(new Font(yourTeamJLabel.getText(),Font.BOLD,25));
		yourTeamJLabel.setForeground(Color.BLUE);
		add(yourTeamJLabel);
		

		oppositeTeamJLabel=new JLabel("Opposite");
		oppositeTeamJLabel.setBounds(690,10,150,30);
		oppositeTeamJLabel.setFont(new Font(oppositeTeamJLabel.getText(),Font.BOLD,25));
		oppositeTeamJLabel.setForeground(Color.BLUE);
		add(oppositeTeamJLabel);
		


		iconOwn=new ImageIcon("src/resource/"+(userInnings.getNation().getFlagOfNation()));
		yourTeamImageJLabel=new JLabel(iconOwn);
		yourTeamImageJLabel.setBounds(90, 50, 125, 125);
		add(yourTeamImageJLabel);

		
		yourIconImg=new ImageIcon("src/resource/"+(userInnings.getNation().getImageOfNation()));
		yourTeamImg=new JLabel(yourIconImg);
		yourTeamImg.setBounds(30,180,60,60);
		add(yourTeamImg);
		
		
		yourTeamCodeName=new JButton(userInnings.getNation().getCodeNameOfNation());
		yourTeamCodeName.setBounds(100,200,170,30);
		yourTeamCodeName.setForeground(Color.YELLOW);
		yourTeamCodeName.setEnabled(false);
		add(yourTeamCodeName);

		
		MatchSummary.ownJLabel=new JLabel[3];
		MatchSummary.ownJLabel[0]=new JLabel((userInnings.getTargetRun()-userInnings.getRuns())+"");
		MatchSummary.ownJLabel[0].setBounds(260,250,150,50);
		MatchSummary.ownJLabel[0].setFont(new Font(MatchSummary.ownJLabel[0].getText(),Font.BOLD,25));
		MatchSummary.ownJLabel[0].setForeground(Color.BLUE);
		add(MatchSummary.ownJLabel[0]);
		
		MatchSummary.ownJLabel[1]=new JLabel((10-userInnings.getWickets())+"");
		MatchSummary.ownJLabel[1].setBounds(260,300,60,50);
		MatchSummary.ownJLabel[1].setFont(new Font(MatchSummary.ownJLabel[1].getText(),Font.BOLD,25));
		MatchSummary.ownJLabel[1].setForeground(Color.BLUE);
		add(MatchSummary.ownJLabel[1]);
		
		toWinJLabel=new JLabel("To Win :");
		toWinJLabel.setBounds(0,250,200,50);
		toWinJLabel.setFont(new Font(toWinJLabel.getText(),Font.BOLD,25));
		toWinJLabel.setForeground(Color.BLUE);
		add(toWinJLabel);
		
		withWicketJLabel=new JLabel("Left wkt:");
		withWicketJLabel.setBounds(0,300,200,50);
		withWicketJLabel.setFont(new Font(withWicketJLabel.getText(),Font.BOLD,25));
		withWicketJLabel.setForeground(Color.BLUE);
		add(withWicketJLabel);
		
		
		leftOverJLabel=new JLabel("Left Over:");
		leftOverJLabel.setBounds(0,350,200,50);
		leftOverJLabel.setFont(new Font(leftOverJLabel.getText(),Font.BOLD,25));
		leftOverJLabel.setForeground(Color.BLUE);
		add(leftOverJLabel);
		
		
		double over=0;
		
		
		MatchSummary.ownJLabel[2]=new JLabel(new Assistant().getOverFromInt(userInnings.getTargetBall()-userInnings.getBalls())+"");
		MatchSummary.ownJLabel[2].setBounds(260,350,200,50);
		MatchSummary.ownJLabel[2].setFont(new Font(MatchSummary.ownJLabel[2].getText(),Font.BOLD,25));
		MatchSummary.ownJLabel[2].setForeground(Color.BLUE);
		add(MatchSummary.ownJLabel[2]);
			
		
		iconOpp=new ImageIcon("src/resource/"+(opponentInnings.getNation().getFlagOfNation()));
		oppositeTeamImageJLabel=new JLabel();
		oppositeTeamImageJLabel.setIcon(iconOpp);
		oppositeTeamImageJLabel.setBounds(690, 50, 125, 125);
		add( oppositeTeamImageJLabel);
		

		oppositeTeamCodeName=new JButton(opponentInnings.getNation().getCodeNameOfNation());
		oppositeTeamCodeName.setBounds(700,200,170,30);
		oppositeTeamCodeName.setForeground(Color.YELLOW);
		oppositeTeamCodeName.setEnabled(false);
		add(oppositeTeamCodeName);
		
		
		oppositeIconImg=new ImageIcon("src/resource/"+(opponentInnings.getNation().getImageOfNation()));
		oppositeTeamImg=new JLabel();
		oppositeTeamImg.setIcon(oppositeIconImg);
		oppositeTeamImg.setBounds(630,180,60,60);
		add(oppositeTeamImg);
		

		oppScoreJLabel=new JLabel("Runs :");
		oppScoreJLabel.setBounds(600-120,250,200,50);
		oppScoreJLabel.setFont(new Font(oppScoreJLabel.getText(),Font.BOLD,25));
		oppScoreJLabel.setForeground(Color.BLUE);
		add(oppScoreJLabel);
		
		JLabel anoppScoreJLabel=new JLabel("Wkts :");
		anoppScoreJLabel.setBounds(600-120,300,200,50);
		anoppScoreJLabel.setFont(new Font(anoppScoreJLabel.getText(),Font.BOLD,25));
		anoppScoreJLabel.setForeground(Color.BLUE);
		add(anoppScoreJLabel);
		
		
		
		MatchSummary.oppJLabel=new JLabel[3];
		
		MatchSummary.oppJLabel[0]=new JLabel(opponentInnings.getRuns()+"");
		MatchSummary.oppJLabel[0].setBounds(690-120,250,100,50);
		MatchSummary.oppJLabel[0].setFont(new Font(MatchSummary.oppJLabel[0].getText(),Font.BOLD,25));
		MatchSummary.oppJLabel[0].setForeground(Color.BLUE);
		add(MatchSummary.oppJLabel[0]);
		
		MatchSummary.oppJLabel[1]=new JLabel(opponentInnings.getWickets()+"");
		MatchSummary.oppJLabel[1].setBounds(600+90-120,300,100,50);
		MatchSummary.oppJLabel[1].setFont(new Font(MatchSummary.oppJLabel[1].getText(),Font.BOLD,25));
		MatchSummary.oppJLabel[1].setForeground(Color.BLUE);
		add(MatchSummary.oppJLabel[1]);
		
		oppOversJLabel=new JLabel("Overs:");
		oppOversJLabel.setBounds(600-120,350,200,50);
		oppOversJLabel.setFont(new Font(oppOversJLabel.getText(),Font.BOLD,25));
		oppOversJLabel.setForeground(Color.BLUE);
		add(oppOversJLabel);
		
		MatchSummary.oppJLabel[2]=new JLabel(opponentInnings.getOvers()+"");
		MatchSummary.oppJLabel[2].setBounds(600+90-120,350,200,50);
		MatchSummary.oppJLabel[2].setFont(new Font(MatchSummary.oppJLabel[2].getText(),Font.BOLD,25));
		MatchSummary.oppJLabel[2].setForeground(Color.BLUE);
		add(MatchSummary.oppJLabel[2]);

	}

}
