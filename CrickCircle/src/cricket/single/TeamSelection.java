package cricket.single;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

import cricket.IO.FileIO;
import cricket.entities.Nation;
import cricket.entities.Settings;
import cricket.intrface.View;
import cricket.main.ui.BackGround;
import cricket.main.ui.MainMenu;
import cricket.main.ui.PlayerSelection;

public class TeamSelection extends JFrame implements View {
	List<Nation>nationList=new ArrayList<Nation>();
	int NationIndexA,NationIndexB;
	
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
	
	JButton yourPrevButton;
	JButton yourNextButton;
	JButton oppositePrevButton;
	JButton oppositeNextButton;
	
	JLabel versesImage;
	ImageIcon versesImageIcon;
	
	JLabel yourStrength,oppositeStrength;
	JButton next;
	
	Settings settings;
	JButton mainMenu;
	JTextField label;
	
	public TeamSelection(final Settings settings) {
		super("Single Match");
		setLayout(null);
		readNations();
		this.settings=settings;
		label=new JTextField("Single Match-Team Selection");
		label.setFont(new Font(label.getText(),Font.BOLD,25));
		label.setBounds(100,100,900,50);
		label.setForeground(Color.BLACK);
		label.setBackground(Color.WHITE);
		label.setEditable(false);
		add(label);
		
		JPanel panel=new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		
		NationIndexA=Integer.parseInt(nationList.get(0).getIdOfNation());
		NationIndexB=Integer.parseInt(nationList.get(1).getIdOfNation());
		
		versesImageIcon=new ImageIcon("src/resource/Vs.png");
		versesImage=new JLabel(versesImageIcon);
		versesImage.setBounds(390,50,150,150);
		panel.add(versesImage);
		
		next=new JButton("Next");
		next.setBounds(400,350,100,30);
		next.setForeground(Color.MAGENTA);
		next.setBackground(Color.BLUE);
		panel.add(next);
		
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
		
		yourPrevButton=new JButton("<");
		yourPrevButton.setBounds(30,95, 50, 20);
		panel.add(yourPrevButton);

		iconOwn=new ImageIcon("src/resource/"+(nationList.get(0).getFlagOfNation()));
		//iconOwn=new ImageIcon("resource/"+(nationList.get(0).getFlagOfNation()));
		yourTeamImageJLabel=new JLabel(iconOwn);
		yourTeamImageJLabel.setBounds(90, 50, 125, 125);
		panel.add(yourTeamImageJLabel);
		
		yourNextButton=new JButton(">");
		yourNextButton.setBounds(220, 95, 50, 20);
		yourNextButton.setBorderPainted(false);
		panel.add(yourNextButton);
		

		
		yourIconImg=new ImageIcon("src/resource/"+(nationList.get(0).getImageOfNation()));
		yourTeamImg=new JLabel(yourIconImg);
		yourTeamImg.setBounds(30,180,60,60);
		panel.add(yourTeamImg);
		
		
		yourTeamCodeName=new JButton(nationList.get(0).getCodeNameOfNation());
		yourTeamCodeName.setBounds(100,200,170,30);
		yourTeamCodeName.setForeground(Color.YELLOW);
		yourTeamCodeName.setEnabled(false);
		panel.add(yourTeamCodeName);
		
		yourTeamPerformance=new JProgressBar(0,131);
		yourTeamPerformance.setValue(Integer.parseInt(nationList.get(1).getRankOfNation()));
		yourTeamPerformance.setBounds(150,250,120,30);
		yourTeamPerformance.setForeground(Color.PINK);
		panel.add(yourTeamPerformance);
		
		yourStrength=new JLabel();
		yourStrength.setText((int)(Double.parseDouble(nationList.get(0).getRankOfNation())/Double.parseDouble(nationList.get(0).getRankOfNation())*100)+"%");
		yourStrength.setBounds(30,250 ,110 ,30);
		yourStrength.setForeground(Color.GREEN);
		panel.add(yourStrength);
		
		oppositePrevButton=new JButton("<");
		oppositePrevButton.setBounds(630,95,50,20);
		panel.add(oppositePrevButton);
		
		iconOpp=new ImageIcon("src/resource/"+(nationList.get(1).getFlagOfNation()));
		oppositeTeamImageJLabel=new JLabel();
		oppositeTeamImageJLabel.setIcon(iconOpp);
		oppositeTeamImageJLabel.setBounds(690, 50, 125, 125);
		panel.add( oppositeTeamImageJLabel);
		

		oppositeTeamCodeName=new JButton(nationList.get(1).getCodeNameOfNation());
		oppositeTeamCodeName.setBounds(700,200,170,30);
		oppositeTeamCodeName.setForeground(Color.YELLOW);
		oppositeTeamCodeName.setEnabled(false);
		panel.add(oppositeTeamCodeName);
		
		
		oppositeIconImg=new ImageIcon("src/resource/"+(nationList.get(1).getImageOfNation()));
		oppositeTeamImg=new JLabel (oppositeIconImg);
		oppositeTeamImg.setBounds(630,180,60,60);
		panel.add(oppositeTeamImg);
		
		oppositeTeamPerformance=new JProgressBar(0,131);
		oppositeTeamPerformance.setValue(Integer.parseInt(nationList.get(1).getRankOfNation()));
		oppositeTeamPerformance.setBounds(750,250,120,30);
		oppositeTeamPerformance.setForeground(Color.PINK);
		panel.add(oppositeTeamPerformance);
		
		oppositeStrength=new JLabel();
		oppositeStrength.setText((int)(Double.parseDouble(nationList.get(1).getRankOfNation())/Double.parseDouble(nationList.get(0).getRankOfNation())*100)+"%");
		oppositeStrength.setBounds(630,250 ,110 ,30);
		oppositeStrength.setForeground(Color.GREEN);
		panel.add(oppositeStrength);
		
		oppositeNextButton=new JButton(">");
		oppositeNextButton.setBounds(820, 95, 50, 20);
		oppositeNextButton.setBorderPainted(false);
		panel.add(oppositeNextButton);
		
		panel.setBounds(100, 200, 900, 400);
		add(panel);

		mainMenu=new JButton("MainMenu");
		mainMenu.setBounds(300, 630, 300, 50);
		mainMenu.setFont(new Font(mainMenu.getText(),Font.BOLD,25));
		mainMenu.setBackground(Color.BLUE);
		mainMenu.setForeground(Color.MAGENTA);
		add(mainMenu);
	
		
		next.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(NationIndexA==NationIndexB){
					JOptionPane.showMessageDialog(null, "Same Team");
				}
				else{
					
					Nation NationA = new Nation();
					Nation NationB = new Nation();
					
					for(int i=0;i<nationList.size();i++){
						if(nationList.get(i).getIdOfNation().equals(Integer.toString(NationIndexA))){
								NationA.setNameOfNation(nationList.get(i).getNameOfNation());
								NationA.setCodeNameOfNation(nationList.get(i).getCodeNameOfNation());
								NationA.setIdOfNation(nationList.get(i).getIdOfNation());
								NationA.setFlagOfNation(nationList.get(i).getFlagOfNation());
								NationA.setImageOfNation(nationList.get(i).getImageOfNation());
								NationA.setRankOfNation(nationList.get(i).getRankOfNation());
						}
						else if(nationList.get(i).getIdOfNation().equals(Integer.toString(NationIndexB))){
							NationB.setNameOfNation(nationList.get(i).getNameOfNation());
							NationB.setCodeNameOfNation(nationList.get(i).getCodeNameOfNation());
							NationB.setIdOfNation(nationList.get(i).getIdOfNation());
							NationB.setFlagOfNation(nationList.get(i).getFlagOfNation());
							NationB.setImageOfNation(nationList.get(i).getImageOfNation());
							NationB.setRankOfNation(nationList.get(i).getRankOfNation());
						}
					}
					
					TeamSelection.this.dispose();
					PlayerSelection frame=new PlayerSelection(NationA,NationB,settings);
					frame.setView(1300, 800);
				}
			}
		});

		yourPrevButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				int highestIndex=Integer.parseInt(nationList.get(nationList.size()-1).getIdOfNation());
				int lowestIndex=Integer.parseInt(nationList.get(0).getIdOfNation());
	
				if(NationIndexA==lowestIndex){
					NationIndexA=highestIndex;
				}
				else{
					NationIndexA--;
				}
				for(int i=0;i<nationList.size();i++){
					
					if(Integer.parseInt(nationList.get(i).getIdOfNation())==NationIndexA){
						iconOwn=new ImageIcon("src/resource/"+(nationList.get(i).getFlagOfNation()));
						yourTeamImageJLabel.setIcon(iconOwn);
						yourIconImg=new ImageIcon("src/resource/"+(nationList.get(i).getImageOfNation()));
						yourTeamImg.setIcon(yourIconImg);
						yourTeamCodeName.setText(nationList.get(i).getCodeNameOfNation());
						yourTeamPerformance.setValue(Integer.parseInt(nationList.get(i).getRankOfNation()));
						yourStrength.setText((int)(Double.parseDouble(nationList.get(i).getRankOfNation())/Double.parseDouble(nationList.get(0).getRankOfNation())*100)+"%");
						
					}
				}	
			}
			
		});
		
		yourNextButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int highestIndex=Integer.parseInt(nationList.get(nationList.size()-1).getIdOfNation());
				int lowestIndex=Integer.parseInt(nationList.get(0).getIdOfNation());
				if(NationIndexA==highestIndex){
					NationIndexA=lowestIndex;
				}
				else{
					NationIndexA++;
				}
				for(int i=0;i<nationList.size();i++){
					
					if( Integer.parseInt(nationList.get(i).getIdOfNation())== NationIndexA){
						iconOwn=new ImageIcon("src/resource/"+nationList.get(i).getFlagOfNation());
						yourTeamImageJLabel.setIcon(iconOwn);
						yourIconImg=new ImageIcon("src/resource/"+(nationList.get(i).getImageOfNation()));
						yourTeamImg.setIcon(yourIconImg);
						yourTeamCodeName.setText(nationList.get(i).getCodeNameOfNation());
						yourTeamPerformance.setValue(Integer.parseInt(nationList.get(i).getRankOfNation()));
						yourStrength.setText((int)(Double.parseDouble(nationList.get(i).getRankOfNation())/Double.parseDouble(nationList.get(0).getRankOfNation())*100)+"%");
						
					}
				}
			}
			
		});
		


		oppositePrevButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				int highestIndex=Integer.parseInt(nationList.get(nationList.size()-1).getIdOfNation());
				int lowestIndex=Integer.parseInt(nationList.get(0).getIdOfNation());
	
				if(NationIndexB==lowestIndex){
					NationIndexB=highestIndex;
				}
				else{
					NationIndexB--;
				}
				for(int i=0;i<nationList.size();i++){
					
					if(Integer.parseInt(nationList.get(i).getIdOfNation())==NationIndexB){
						iconOpp=new ImageIcon("src/resource/"+(nationList.get(i).getFlagOfNation()));
						oppositeTeamImageJLabel.setIcon(iconOpp);
						oppositeIconImg=new ImageIcon("src/resource/"+(nationList.get(i).getImageOfNation()));
						oppositeTeamImg.setIcon(oppositeIconImg);
						oppositeTeamCodeName.setText(nationList.get(i).getCodeNameOfNation());
						oppositeTeamPerformance.setValue(Integer.parseInt(nationList.get(i).getRankOfNation()));
						oppositeStrength.setText((int)(Double.parseDouble(nationList.get(i).getRankOfNation())/Double.parseDouble(nationList.get(0).getRankOfNation())*100)+"%");
						
					}
				}	
			}
			
		});
		
		oppositeNextButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int highestIndex=Integer.parseInt(nationList.get(nationList.size()-1).getIdOfNation());
				int lowestIndex=Integer.parseInt(nationList.get(0).getIdOfNation());
				if(NationIndexB==highestIndex){
					NationIndexB=lowestIndex;
				}
				else{
					NationIndexB++;
				}
				for(int i=0;i<nationList.size();i++){
					if( Integer.parseInt(nationList.get(i).getIdOfNation())== NationIndexB){
						iconOpp=new ImageIcon("src/resource/"+(nationList.get(i).getFlagOfNation()));
						oppositeTeamImageJLabel.setIcon(iconOpp);
						oppositeIconImg=new ImageIcon("src/resource/"+(nationList.get(i).getImageOfNation()));
						oppositeTeamImg.setIcon(oppositeIconImg);
						oppositeTeamCodeName.setText(nationList.get(i).getCodeNameOfNation());
						oppositeTeamPerformance.setValue(Integer.parseInt(nationList.get(i).getRankOfNation()));
						oppositeStrength.setText((int)(Double.parseDouble(nationList.get(i).getRankOfNation())/Double.parseDouble(nationList.get(0).getRankOfNation())*100)+"%");
					}
				}
			}
			
		});
		
		
		mainMenu.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				TeamSelection.this.dispose();
				MainMenu frame=new MainMenu(settings);	
				frame.setLayout(null);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setSize(1300, 800);	
				BackGround background=new BackGround(new Color(150,200,100)); 
				background.setBounds(0, 0, 1300, 800);
				frame.add(background);
				frame.setVisible(true);
				
			}
			
		});
	
		
	}
	
	private void readNations(){
		FileIO fileIO=new FileIO();
		nationList=fileIO.readNations("/resource/Ranking.txt");
		for (int i = 0; i < nationList.size(); i++) {
			System.out.println(nationList.get(i).getIdOfNation()+" "+nationList.get(i).getNameOfNation());
		}
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

