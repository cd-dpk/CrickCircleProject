package cricket.main.ui;


import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import cricket.constant.GameMode;
import cricket.constant.Level;
import cricket.constant.Over;
import cricket.constant.Sound;
import cricket.entities.*;
import cricket.intrface.View;

public class SettingsFrame extends JFrame implements View  {
 
	JButton mainMenu=new JButton("MainMenu");

	JLabel label[]=new JLabel[4];
	JTextField settingsLabel;
	
	private JRadioButton gameModeJRadioButton[]=new JRadioButton[2]; // selects plain text
	private ButtonGroup gameModeRadioGroup;

	private JRadioButton []soundJRadioButton=new JRadioButton[2]; // selects plain text
	private ButtonGroup soundRadioGroup;

	private JRadioButton[] levelJRadioButton=new JRadioButton[3]; // selects plain text
	private ButtonGroup levelRadioGroup;

	private JRadioButton[] overJRadioButton=new JRadioButton[3]; // selects plain text
	private ButtonGroup overRadioGroup;
	
	Settings settings,newSettings;
	List<Nation>nations;
	
	
	public SettingsFrame(final List<Nation>nations,final Settings settings) {
		
		super("Settings");
		setLayout(null );
		this.settings=settings;
		this.nations=nations;
		newSettings=new Settings(settings.getGameMode(),settings.getSound(),settings.getLevel(),settings.getOver());
		
		settingsLabel=new JTextField("Settings");
		settingsLabel.setBounds(200, 200, 800, 50);
		settingsLabel.setFont(new Font(settingsLabel.getText(),Font.BOLD,25));
		settingsLabel.setBackground(Color.WHITE);
		settingsLabel.setForeground(Color.BLACK);
		settingsLabel.setEditable(false);
		add(settingsLabel);
		
		mainMenu.setBounds(420, 600, 300, 50);
		mainMenu.setFont(new Font(mainMenu.getText(),Font.BOLD,25));
		mainMenu.setBackground(Color.BLUE);
		mainMenu.setForeground(Color.MAGENTA);
		add(mainMenu);
		
		JPanel panel=new JPanel();
		panel.setLayout(null);
		
		JPanel panel1=new JPanel();
		panel1.setLayout(new GridLayout(1,3,5,5));
		
		label[0]=new JLabel("Play");
		label[0].setFont(new Font(label[0].getText(),Font.BOLD,25));
		label[0].setBackground(Color.BLUE);
		label[0].setForeground(Color.MAGENTA);
		label[0].setBounds(0,0,150,50);
		panel.add(label[0]);
		
		
		gameModeJRadioButton[0] = new JRadioButton( "Single Match");
		gameModeJRadioButton[0].setFont(new Font(gameModeJRadioButton[0].getText(),Font.ITALIC,25));
		gameModeJRadioButton[0].setForeground(Color.MAGENTA);
		gameModeJRadioButton[1] = new JRadioButton( "Tournament");
		gameModeJRadioButton[1].setFont(new Font(gameModeJRadioButton[1].getText(),Font.ITALIC,25));
		gameModeJRadioButton[1].setForeground(Color.MAGENTA);/*
		gameModeJRadioButton[2] = new JRadioButton( "Challenge");
		gameModeJRadioButton[2].setFont(new Font(gameModeJRadioButton[2].getText(),Font.ITALIC,25));
		gameModeJRadioButton[2].setForeground(Color.MAGENTA);*/
		
		
		
		
		if(settings.getGameMode()==GameMode.SINGLE_MATCH){
				gameModeJRadioButton[0].setSelected(true);
		
		}
		else if (settings.getGameMode()==GameMode.TOURNAMENT){
			gameModeJRadioButton[1].setSelected(true);
		}
		
		panel1.add( gameModeJRadioButton[0] );
		panel1.add( gameModeJRadioButton[1] );/*
		panel1.add( gameModeJRadioButton[2] );*/
		panel1.setBounds(200,0,600,30);
		panel.add(panel1);
		
		
		
		gameModeRadioGroup = new ButtonGroup();
		gameModeRadioGroup.add(gameModeJRadioButton[0] );
		gameModeRadioGroup.add(gameModeJRadioButton[1] );/* 
		gameModeRadioGroup.add(gameModeJRadioButton[2] );*/ 
		

		label[1]=new JLabel("Sound");
		label[1].setFont(new Font(label[1].getText(),Font.BOLD,25));
		label[1].setBackground(Color.BLUE);
		label[1].setForeground(Color.MAGENTA);
		label[1].setBounds(0,60,150,50);
		panel.add(label[1]);
		
		JPanel panel2=new JPanel();
		panel2.setLayout(new GridLayout(1,3,5,5));
		
		soundJRadioButton[0] = new JRadioButton( "OFF");
		soundJRadioButton[0].setFont(new Font(soundJRadioButton[0].getText(),Font.ITALIC,25));
		soundJRadioButton[0].setForeground(Color.MAGENTA);
		soundJRadioButton[1] = new JRadioButton( "ON");
		soundJRadioButton[1].setFont(new Font(soundJRadioButton[1].getText(),Font.ITALIC,25));
		soundJRadioButton[1].setForeground(Color.MAGENTA);
		/*
		soundJRadioButton[2] = new JRadioButton( "High");
		soundJRadioButton[2].setFont(new Font(soundJRadioButton[2].getText(),Font.ITALIC,25));
		soundJRadioButton[2].setForeground(Color.MAGENTA);
		*/
	/*	for(int i=0;i<3;i++){
			if(settings.getGameMode()==i){
				soundJRadioButton[i].setSelected(true);
			}
			else{
				soundJRadioButton[i].setSelected(false);
			}
		}
		
	*/	

		if(settings.getSound()==Sound.OFF){
			soundJRadioButton[0].setSelected(true);
		
		}
		else if (settings.getSound()==Sound.ON){
			gameModeJRadioButton[1].setSelected(true);
		}
		
		panel2.add(soundJRadioButton[0] ); // add plain button to JFrame
		panel2.add(soundJRadioButton[1] ); // add bold button to JFrame
		/*panel2.add(soundJRadioButton[2] ); // add italic button to JFrame
		*/
		panel2.setBounds(200,60, 600, 50);
		panel.add(panel2);
		
		soundRadioGroup = new ButtonGroup(); // create ButtonGroup
		soundRadioGroup.add( soundJRadioButton[0] ); // add plain to group
		soundRadioGroup.add( soundJRadioButton[1] ); // add bold to group
		/*soundRadioGroup.add( soundJRadioButton[2] ); // add italic to group
*/
		label[2]=new JLabel("Level");
		label[2].setFont(new Font(label[2].getText(),Font.BOLD,25));
		label[2].setBackground(Color.BLUE);
		label[2].setForeground(Color.MAGENTA);
		label[2].setBounds(0, 120, 150, 50);
		panel.add(label[2]);		
		
		JPanel panel3=new JPanel();
		panel3.setLayout(new GridLayout(1,3,5,5));
		
		levelJRadioButton[0] = new JRadioButton( "Easy" );
		levelJRadioButton[0].setFont(new Font(levelJRadioButton[0].getText(),Font.ITALIC,25));
		levelJRadioButton[0].setForeground(Color.MAGENTA);
		levelJRadioButton[1] = new JRadioButton( "Medium" );
		levelJRadioButton[1].setFont(new Font(levelJRadioButton[1].getText(),Font.ITALIC,25));
		levelJRadioButton[1].setForeground(Color.MAGENTA);
		
		levelJRadioButton[2] = new JRadioButton( "Hard");
		levelJRadioButton[2].setFont(new Font(levelJRadioButton[2].getText(),Font.ITALIC,25));
		levelJRadioButton[2].setForeground(Color.MAGENTA);
		

		if(settings.getLevel()==Level.EASY){
				levelJRadioButton[0].setSelected(true);
		
		}
		else if (settings.getLevel()==Level.MEDIUM){
				levelJRadioButton[1].setSelected(true);
		}
		else if(settings.getLevel()==Level.HARD){
				levelJRadioButton[2].setSelected(true);
		}
	/*	for(int i=0;i<3;i++){
			if(settings.getLevel()==i){
				levelJRadioButton[i].setSelected(true);
			}
			else{
				levelJRadioButton[i].setSelected(false);
			}
		}
	*/	panel3.add( levelJRadioButton[0] ); // add plain button to JFrame
		panel3.add( levelJRadioButton[1] ); // add bold button to JFrame
		panel3.add( levelJRadioButton[2] ); // add italic button to JFrame

		panel3.setBounds(200,120,600,50);
		panel.add(panel3);
		
		
		levelRadioGroup = new ButtonGroup(); // create ButtonGroup
		levelRadioGroup.add(levelJRadioButton[0] ); // add plain to group
		levelRadioGroup.add(levelJRadioButton[1] ); // add bold to group
		levelRadioGroup.add(levelJRadioButton[2] ); // add italic to group
		
		

		label[3]=new JLabel("Over");
		label[3].setFont(new Font(label[3].getText(),Font.BOLD,25));
		label[3].setBounds(0,180, 150, 50);
		label[3].setBackground(Color.BLUE);
		label[3].setForeground(Color.MAGENTA);
		panel.add(label[3]);
		
		JPanel panel4=new JPanel();
		panel4.setLayout(new GridLayout(1,4,5,5));
		
		overJRadioButton[0] = new JRadioButton( "5.0" );
		overJRadioButton[0].setFont(new Font(overJRadioButton[0].getText(),Font.ITALIC,25));
		overJRadioButton[0].setForeground(Color.MAGENTA);
		
		overJRadioButton[1] = new JRadioButton( "10.0");
		overJRadioButton[1].setFont(new Font(overJRadioButton[1].getText(),Font.ITALIC,25));
		overJRadioButton[1].setForeground(Color.MAGENTA);
		
		overJRadioButton[2] = new JRadioButton( "20.0" );
		overJRadioButton[2].setFont(new Font(overJRadioButton[2].getText(),Font.ITALIC,25));
	
		overJRadioButton[2].setForeground(Color.MAGENTA);
		
/*		overJRadioButton [3]= new JRadioButton( "50.0" );
		overJRadioButton[3].setFont(new Font(overJRadioButton[3].getText(),Font.ITALIC,25));
		overJRadioButton[3].setForeground(Color.MAGENTA);
	
*/		/*for(int i=0;i<4;i++){
			if(settings.getOver()==i){
				overJRadioButton[i].setSelected(true);
			}
			else{
				overJRadioButton[i].setSelected(false);
			}
		}*/

		if(settings.getOver()==Over.FIVE){
				overJRadioButton[0].setSelected(true);
		
		}
		else if (settings.getOver()==Over.TEN){
				overJRadioButton[1].setSelected(true);
		}
		else if(settings.getOver()==Over.TWENTY){
				overJRadioButton[2].setSelected(true);
		}
		panel4.add( overJRadioButton[0] ); // add plain button to JFrame
		panel4.add( overJRadioButton [1]); // add bold button to JFrame
		panel4.add( overJRadioButton [2]); // add italic button to JFrame
/*		panel4.add( overJRadioButton[3] ); // add italic button to JFrame
*/		panel4.setBounds(200,180, 600, 50);
		panel.add(panel4);
		
		
		overRadioGroup = new ButtonGroup(); // create ButtonGroup
		overRadioGroup.add( overJRadioButton[0] ); // add plain to group
		overRadioGroup.add( overJRadioButton [1]); // add bold to group
		overRadioGroup.add( overJRadioButton[2] ); // add italic to group
/*		overRadioGroup.add( overJRadioButton [3]); // add italic to group
*/		
		
		add(panel);
		panel.setBounds(200, 300, 800, 250);
		
		for(int i=0;i<gameModeJRadioButton.length;i++){
			final int number=i;
			gameModeJRadioButton[i].addItemListener(new ItemListener(){
				public void itemStateChanged(ItemEvent event) {
					// TODO Auto-generated method stub
					switch(number){
						case 0:
							newSettings.setGameMode(GameMode.SINGLE_MATCH);
							break;
						case 1:
							newSettings.setGameMode(GameMode.TOURNAMENT);
							break;
					}
					
				}
			});

		}
		for(int i=0;i<soundJRadioButton.length;i++){
			final int number=i;
			soundJRadioButton[i].addItemListener(new ItemListener(){
				public void itemStateChanged(ItemEvent event) {
					// TODO Auto-generated method stub
					switch(number){
					case 0:
						newSettings.setSound(Sound.OFF);
						break;
					case 1:
						newSettings.setSound(Sound.ON);
						break;
				}
				}
			});
		}
		for(int i=0;i<levelJRadioButton.length;i++){
			final int number=i;
			levelJRadioButton[i].addItemListener(new ItemListener(){
				public void itemStateChanged(ItemEvent event) {
					// TODO Auto-generated method stub
					switch(number){
					case 0:
						newSettings.setLevel(Level.EASY);
						break;
					case 1:
						newSettings.setLevel(Level.MEDIUM);
						break;
					case 2:
						newSettings.setLevel(Level.HARD);
						break;
					}
				}
			});

		}
		for(int i=0;i<overJRadioButton.length;i++){
			final int number=i;
			overJRadioButton[i].addItemListener(new ItemListener(){
				public void itemStateChanged(ItemEvent event) {
					// TODO Auto-generated method stub
					switch(number){
					case 0:
						newSettings.setOver(Over.FIVE);
						break;
					case 1:
						newSettings.setOver(Over.TEN);
						break;
					case 2:
						newSettings.setOver(Over.TWENTY);
						break;
					}
				}
			});

		}
		mainMenu.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				SettingsFrame.this.dispose();
				MainMenu frame=new MainMenu(newSettings);
				frame.setView(1300, 800);
			}
			
		});
		
		
	}

	@Override
	public void setView(int width, int height) {
		// TODO Auto-generated method stub
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(width, height);
		this.setVisible(true);
		BackGround background=new BackGround(new Color(150,200,100)); 
		background.setBounds(0, 0, width, height);
		this.add(background);
	}
	
}
