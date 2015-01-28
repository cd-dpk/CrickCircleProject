package cricket.tournament;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

import cricket.IO.FileIO;
import cricket.entities.Edge;
import cricket.entities.Nation;
import cricket.entities.Settings;
import cricket.entities.Tournament;
import cricket.intrface.View;
import cricket.main.ui.BackGround;
import cricket.main.ui.MainMenu;

public class TeamSelection extends JFrame implements View {

	
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
	
	List<Nation> nationList=new ArrayList<Nation>();
	
	JLabel versesImage;
	ImageIcon versesImageIcon;
	
	JLabel yourStrength,oppositeStrength;
	JButton next;
	
	int teamIndexA,teamIndexB;
	Settings settings;
	JButton mainMenu;
	JTextField label;
	
	Edge edge;

	public TeamSelection(final Settings settings){
		super("Tournament");
		//tournament team selection
		setLayout(null);
		readNations();
		teamIndexA=Integer.parseInt(nationList.get(0).getIdOfNation());
		

		label=new JTextField("Tournament-Team Selection");
		label.setFont(new Font(label.getText(),Font.BOLD,25));
		label.setBounds(200,100,900,50);
		label.setForeground(Color.BLACK);
		label.setBackground(Color.WHITE);
		label.setEditable(false);
		add(label);//panel.add(next);
		
		JPanel panel=new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		
		next=new JButton("Next");
		next.setBounds(400,350,100,30);
		next.setForeground(Color.MAGENTA);
		next.setBackground(Color.BLUE);
		panel.add(next);
		
		yourTeamJLabel=new JLabel("You");
		yourTeamJLabel.setBounds(420,10,100,30);
		yourTeamJLabel.setFont(new Font(yourTeamJLabel.getText(),Font.BOLD,25));
		yourTeamJLabel.setForeground(Color.BLACK);
		panel.add(yourTeamJLabel);
		
		yourPrevButton=new JButton("<");
		yourPrevButton.setBounds(330,95, 50, 20);
		panel.add(yourPrevButton);


		iconOwn=new ImageIcon("src/resource/"+nationList.get(0).getFlagOfNation());
		yourTeamImageJLabel=new JLabel(iconOwn);
		yourTeamImageJLabel.setBounds(390, 50, 125, 125);
		panel.add(yourTeamImageJLabel);
		
		yourNextButton=new JButton(">");
		yourNextButton.setBounds(520, 95, 50, 20);
		panel.add(yourNextButton);
		

		yourIconImg=new ImageIcon("src/resource/"+nationList.get(0).getImageOfNation());
		yourTeamImg=new JLabel(yourIconImg);
		yourTeamImg.setBounds(330,180,60,60);
		panel.add(yourTeamImg);
		
		
		yourTeamCodeName=new JButton(nationList.get(0).getCodeNameOfNation());
		yourTeamCodeName.setBounds(400,200,170,30);
		yourTeamCodeName.setForeground(Color.YELLOW);
		yourTeamCodeName.setEnabled(false);
		panel.add(yourTeamCodeName);
		
		yourTeamPerformance=new JProgressBar(0,131);
		yourTeamPerformance.setValue(Integer.parseInt(nationList.get(0).getRankOfNation()));
		yourTeamPerformance.setBounds(450,250,120,30);
		yourTeamPerformance.setForeground(Color.PINK);
		panel.add(yourTeamPerformance);
		
		yourStrength=new JLabel();
		yourStrength.setText("100%");
		yourStrength.setBounds(330,250 ,110 ,30);
		yourStrength.setForeground(Color.GREEN);
		panel.add(yourStrength);
		

		panel.setBounds(200, 200, 900, 400);
		add(panel);
	
		mainMenu=new JButton("MainMenu");
		mainMenu.setBounds(200, 630, 300, 50);
		mainMenu.setFont(new Font(mainMenu.getText(),Font.BOLD,25));
		mainMenu.setBackground(Color.BLUE);
		mainMenu.setForeground(Color.MAGENTA);
		add(mainMenu);

		yourPrevButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int highestIndex=Integer.parseInt(nationList.get(nationList.size()-1).getIdOfNation());
				int lowestIndex=Integer.parseInt(nationList.get(0).getIdOfNation());
				if(teamIndexA==lowestIndex){
					teamIndexA=highestIndex;
				}
				else{
					teamIndexA--;
				}
				for(int i=0;i<nationList.size();i++){
					if(Integer.parseInt(nationList.get(i).getIdOfNation())==teamIndexA){
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
		yourNextButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int highestIndex=Integer.parseInt(nationList.get(nationList.size()-1).getIdOfNation());
				int lowestIndex=Integer.parseInt(nationList.get(0).getIdOfNation());
				if(teamIndexA==highestIndex){
					teamIndexA=lowestIndex;
				}
				else{
					teamIndexA++;
				}
				for(int i=0;i<nationList.size();i++){
					if( Integer.parseInt(nationList.get(i).getIdOfNation())== teamIndexA){
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
		next.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
	
				List<Nation>tournamentnations=new ArrayList<Nation>();
				Nation userTeam=new Nation();
				List<Nation>extranations=new ArrayList<Nation>();
				
				for(int i=0;i<nationList.size();i++){
					if(teamIndexA==Integer.parseInt(nationList.get(i).getIdOfNation())){
						userTeam=new Nation();
						userTeam.setIdOfNation(nationList.get(i).getIdOfNation());
						userTeam.setCodeNameOfNation(nationList.get(i).getCodeNameOfNation());
						userTeam.setNameOfNation(nationList.get(i).getNameOfNation());
						userTeam.setFlagOfNation(nationList.get(i).getFlagOfNation());
						userTeam.setImageOfNation(nationList.get(i).getImageOfNation());
						userTeam.setRankOfNation(nationList.get(i).getRankOfNation());
	//					System.out.println("You have selected "+nations.get(i).getNameOfNation());
					}
					else{
						Nation team=new Nation();
						team.setIdOfNation(nationList.get(i).getIdOfNation());
						team.setCodeNameOfNation(nationList.get(i).getCodeNameOfNation());
						team.setNameOfNation(nationList.get(i).getNameOfNation());
						team.setFlagOfNation(nationList.get(i).getFlagOfNation());
						team.setImageOfNation(nationList.get(i).getImageOfNation());
						team.setRankOfNation(nationList.get(i).getRankOfNation());
						extranations.add(team);
					}
				}
				Collections.shuffle(extranations);
				tournamentnations.add(userTeam);
				for(int i=0;i<9;i++){
					tournamentnations.add(extranations.get(i));
				}
				Tournament tournament=new Tournament();
				tournament.setTournament(userTeam, tournamentnations);
				tournament.setSettings(settings);
				TeamSelection.this.dispose();
				
				TournamentFrame frame=new TournamentFrame(tournament);
				frame.setView(1300,800);
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