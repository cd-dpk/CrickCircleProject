package cricket.main.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import cricket.constant.GameMode;
import cricket.entities.Match;
import cricket.entities.Nation;
import cricket.entities.Settings;
import cricket.intrface.View;
import cricket.serialization.INPUT;
import cricket.single.TeamSelection;


public class MainMenu extends JFrame implements View {

	 
	 JButton playButton;
	 JButton settingsButton;
	 JButton exitButton;
	 JButton helpButton;
	 JButton highScoresButton;
	 JButton continueButton; 
	 
	 
	 List<Nation>nations=new ArrayList<Nation>();
	 Settings settings;
	 
	public MainMenu(final Settings settings ){
		super("MainMenu");
		setLayout(null);
		this.settings=settings;
		
		/*continueButton=new JButton("Continue");
		continueButton.setFont(new Font(continueButton.getText(),Font.ITALIC,22));
		continueButton.setBorderPainted(false);
		continueButton.setBounds(20,230,200,50);
		continueButton.setBackground(Color.BLUE);
		continueButton.setForeground(Color.MAGENTA);
		add(continueButton);
		final Match match=readSavedMatch();
		/*if(match.isContinue!=true){
			continueButton.setVisible(false);
		}
		else {
			continueButton.setVisible(true);
		}
		*/
		playButton=new JButton("New Game");
		playButton.setFont(new Font(playButton.getText(),Font.ITALIC,22));
		playButton.setBorderPainted(false);
		playButton.setBounds(20,300,200,50);
		playButton.setBackground(Color.BLUE);
		playButton.setForeground(Color.MAGENTA);
		add(playButton);
		 
		 settingsButton=new JButton("Settings");
		 settingsButton.setFont(new Font(settingsButton.getText(),Font.PLAIN,22));
		 settingsButton.setBorderPainted(false);
		 settingsButton.setBounds(20,370,200,50);
		 settingsButton.setBackground(Color.BLUE);
		 settingsButton.setForeground(Color.MAGENTA);
		 add(settingsButton);
		
		 
		 highScoresButton=new JButton("High Scores");
		 highScoresButton.setFont(new Font(highScoresButton.getText(),Font.ITALIC,22));
		 highScoresButton.setBorderPainted(false);
		 highScoresButton.setBounds(20,440,200,50);
		 highScoresButton.setBackground(Color.BLUE);
		 highScoresButton.setForeground(Color.MAGENTA);
		 add(highScoresButton);
		 
		 helpButton=new JButton("Help");
		 helpButton.setFont(new Font(helpButton.getText(),Font.ITALIC,22));
		 helpButton.setBorderPainted(false);
		 helpButton.setBounds(20,510,200,50);
		 helpButton.setBackground(Color.BLUE);
		 helpButton.setForeground(Color.MAGENTA);
		 add(helpButton);
			
		 exitButton=new JButton("Exit");
		 exitButton.setFont(new Font(exitButton.getText(),Font.ITALIC,22));
		 exitButton.setBorderPainted(false);
		 exitButton.setBounds(20,580,200,50);
		 exitButton.setBackground(Color.BLUE);
		 exitButton.setForeground(Color.MAGENTA);
		 add(exitButton);

		 
		 playButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(settings.getGameMode()==GameMode.SINGLE_MATCH){
					MainMenu.this.dispose();
					TeamSelection frame=new TeamSelection(settings);
					frame.setView(1300, 800);
				}
				else if(settings.getGameMode()==GameMode.TOURNAMENT){
					MainMenu.this.dispose();
					cricket.tournament.TeamSelection frame=new cricket.tournament.TeamSelection(settings);
					frame.setView(1300, 800);
				}
			}			 
		 });

		/* continueButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent event) {
				MainMenu.this.dispose();
				CrickCircle frame=new CrickCircle(match);
				frame.setView(1300, 800);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
			}
			 
		 });*/
		 settingsButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				MainMenu.this.dispose();
				SettingsFrame frame=new SettingsFrame(nations,settings);
				frame.setView(1300, 800);
			}
			 
		 });
		 
		 helpButton.addActionListener(new ActionListener(){
			 @Override
			public void actionPerformed(ActionEvent arg0) {
				
				String help="e-mail\n" +
							"	   :chandradasdipok@gmail.com\n" +
							"	   :bsse0501@iit.du.ac.bd\n" +
							"	   :bsse0511@iit.du.ac.bd\n" +
							"	   :bsse0524@iit.du.ac.bd\n";
				JOptionPane.showMessageDialog(MainMenu.this,help);
			}
		});
		 
		 exitButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				MainMenu.this.dispose();
				System.exit(1);
			}
		 });
		 highScoresButton.addActionListener(new ActionListener(){
			 @Override
				public void actionPerformed(ActionEvent arg0) {
				 if (settings.getGameMode().equals(GameMode.SINGLE_MATCH)) {
					cricket.serialization.highScore.INPUT input=new cricket.serialization.highScore.INPUT("Single");
					input.openfile();
					input.readRecords();
					input.closeFile();
					HighScores dialog=new HighScores(MainMenu.this,true,input.highScore);
					dialog.setLocationRelativeTo(MainMenu.this);
					dialog.setLocation(200,100);
					dialog.setSize(900, 600);
					dialog.show();
				} 
				 else if(settings.getGameMode().equals(GameMode.TOURNAMENT)) {
					cricket.serialization.highScore.INPUT input=new cricket.serialization.highScore.INPUT("Tournament");
					input.openfile();
					input.readRecords();
					input.closeFile();
					HighScores dialog=new HighScores(MainMenu.this,true,input.highScore);
					dialog.setLocationRelativeTo(MainMenu.this);
					dialog.setLocation(200,100);
					dialog.setSize(900, 600);
					dialog.show();
				}
			}
			});
		
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
	public Match readSavedMatch(){
		Match match=null;
		INPUT input=new INPUT("Single");
		input.openfile();
		input.readRecords();
		input.closeFile();
		match=input.getMatch();
		return match;
	}
}