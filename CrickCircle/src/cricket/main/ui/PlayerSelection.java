package cricket.main.ui;

import java.awt.Color;
import java.awt.Font;
import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import cricket.IO.FileIO;
import cricket.constant.Stage;
import cricket.constant.Status;
import cricket.entities.Batsman;
import cricket.entities.Nation;
import cricket.entities.Player;
import cricket.entities.Settings;
import cricket.entities.Tournament;
import cricket.intrface.View;
import cricket.main.ui.BackGround;
import cricket.single.TeamSelection;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PlayerSelection extends JFrame implements View{

	 JList<Player>squaredJList;
	 JList <Player>teamJList;
	 
	 List<JProgressBar> squaredPerformanceBar=new ArrayList<JProgressBar>();
	 List<JProgressBar> teamPerformanceBar=new ArrayList<JProgressBar>();
	 public JButton selectButton;
	 public JButton deselectButton;
	 
	 List<Player>players=new ArrayList<Player>();
	 List<Player>nationSquard=new ArrayList<Player>();
	 List<Player>nationTeam=new ArrayList<Player>();
	 List<Boolean>selected=new ArrayList<Boolean>();
	 DefaultListModel<String> squaredModel=new DefaultListModel();
	 DefaultListModel<String> teamModel=new DefaultListModel();
	 
	 Box box1,box2;
	 Settings  settings;
	 JButton back;
	 
	 Nation userNation,opponentNation;
	 int NoOfPlayer=0;
	 
	 public PlayerSelection(final Nation userNation,final Nation opponentNation,final Settings settings) {
			super("Players");
			setLayout(null);
			this.userNation=userNation;
			this.opponentNation=opponentNation;
			this.settings=settings;
			
			readPlayers();
			getNationPlayers();
			
			ImageIcon icon=new ImageIcon("src/resource/"+this.userNation.getFlagOfNation());			
			JLabel flag=new JLabel(icon);
			flag.setBounds(350-100, 10, 125, 125);
			add(flag);
			
			ImageIcon versesImageIcon=new ImageIcon(("src/resource/Vs.png"));
			JLabel versesImage=new JLabel(versesImageIcon);
			versesImage.setBounds(600-150,10,150,150);
			add(versesImage);
			
			ImageIcon icon1=new ImageIcon("src/resource/"+(this.opponentNation.getFlagOfNation()));
			
			JLabel flag1=new JLabel(icon1);
			flag1.setBounds(800-150, 10, 125, 125);
			add(flag1);
			
			
			JLabel name=new JLabel(this.userNation.getNameOfNation());
			name.setBounds(350-150,140,150,30);
			name.setFont(new Font(name.getText(),Font.BOLD,25));
			name.setForeground(Color.BLUE);
			add(name);
			
			JLabel name1=new JLabel(this.opponentNation.getNameOfNation());
			name1.setBounds(800-150,140,200,30);
			name1.setFont(new Font(name1.getText(),Font.BOLD,25));
			name1.setForeground(Color.BLUE);
			add(name1);
			
			
			
			JButton squaredLabel=new JButton("Squard");
			squaredLabel.setBounds(200-50,170,200,30);
			squaredLabel.setFont(new Font(squaredLabel.getText(),Font.BOLD,25));
			squaredLabel.setBackground(Color.GREEN);
			squaredLabel.setEnabled(false);
			add(squaredLabel);
			
			JButton squaredName=new JButton("Name");
			squaredName.setBounds(100-50,210,250,30);
			squaredName.setFont(new Font(squaredName.getText(),Font.BOLD,25));
			squaredName.setBackground(Color.GREEN);
			squaredName.setEnabled(false);
			add(squaredName);
			
			JButton squaredPer=new JButton("Performance");
			squaredPer.setBounds(455-150,210,150,30);
			squaredPer.setFont(new Font(squaredPer.getText(),Font.BOLD,10));
			squaredPer.setBackground(Color.GREEN);
			squaredPer.setEnabled(false);
			add(squaredPer);
			
			for(int i=0;i<nationSquard.size();i++){
				squaredModel.addElement(nationSquard.get(i).getFirstName()+" "+nationSquard.get(i).getLastName());
				selected.add(false);
			}
			
			for(int i=0;i<nationTeam.size();i++){
				teamModel.addElement(nationTeam.get(i).getFirstName()+" "+nationTeam.get(i).getLastName());
					
			}
			box1=Box.createHorizontalBox();
			squaredJList=new JList(squaredModel);
			squaredJList.setFixedCellHeight(25);
			squaredJList.setFixedCellWidth(200);
			squaredJList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
			squaredJList.setFont(new Font(squaredJList.getToolTipText(),Font.PLAIN,20));
			squaredJList.setForeground(Color.BLACK);
			squaredJList.setBackground(Color.WHITE);
			squaredJList.setVisibleRowCount(10);
			box1.add(new JScrollPane(squaredJList));
			box1.setBounds(50,250,250,400);
			add(box1);
			


			
			for(int i=0;i<nationSquard.size();i++){
				JProgressBar bar=new JProgressBar(0,25);
				int performance=(int) nationSquard.get(i).getAverage();
				if(performance >=25){
					performance=25;
				}
				bar.setValue(performance);
				squaredPerformanceBar.add(bar);
			}
			for(int i=0;i<nationSquard.size();i++){
				squaredPerformanceBar.get(i).setBounds(455-150, 250+i*25, 150, 25);
				squaredPerformanceBar.get(i).setBackground(Color.WHITE);
				squaredPerformanceBar.get(i).setForeground(Color.PINK);
				add(squaredPerformanceBar.get(i));
			}
			
			for(int i=0;i<11;i++){
				JProgressBar bar=new JProgressBar(0,25);
				bar.setValue(0);
				teamPerformanceBar.add(bar);
			}
			for(int i=0;i<11;i++){
				teamPerformanceBar.get(i).setBounds(860, 250+i*25, 150, 25);
				teamPerformanceBar.get(i).setBackground(Color.WHITE);
				teamPerformanceBar.get(i).setForeground(Color.PINK);
				add(teamPerformanceBar.get(i));
			}
			
			selectButton=new JButton("+");
			selectButton.setBounds(620-150, 450, 100, 30);
			selectButton.setFont(new Font(selectButton.getText(),Font.BOLD,25));
			selectButton.setBackground(Color.BLUE);
			selectButton.setForeground(Color.MAGENTA);
			selectButton.setVisible(true);
			add(selectButton);
			
			
			deselectButton=new JButton("-");
			deselectButton.setBounds(620-150, 450, 100, 30);
			deselectButton.setFont(new Font(deselectButton.getText(),Font.BOLD,25));
			deselectButton.setBackground(Color.BLUE);
			deselectButton.setForeground(Color.MAGENTA);
			deselectButton.setVisible(false);
			add(deselectButton);
			
			box2=Box.createHorizontalBox();
			teamJList=new JList(teamModel);
			teamJList.setFixedCellHeight(25);
			teamJList.setFixedCellWidth(200);
			teamJList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
			teamJList.setFont(new Font(teamJList.getToolTipText(),Font.PLAIN,20));
			teamJList.setForeground(Color.BLACK);
			teamJList.setBackground(Color.WHITE);
			teamJList.setVisibleRowCount(5);
			box2.add(new JScrollPane(teamJList));
			box2.setBounds(750-150,250,250,400);
			add(box2);
			
			JButton teamLabel=new JButton("Team");
			teamLabel.setBounds(650+200-150,170,200,30);
			teamLabel.setFont(new Font(teamLabel.getText(),Font.BOLD,25));
			teamLabel.setBackground(Color.GREEN);
			teamLabel.setEnabled(false);
			add(teamLabel);
			
			JButton teamName=new JButton("Name");
			teamName.setBounds(650+100-150,210,250,30);
			teamName.setFont(new Font(teamName.getText(),Font.BOLD,25));
			teamName.setBackground(Color.GREEN);
			teamName.setEnabled(false);
			add(teamName);
			
			JButton teamPer=new JButton("Performance");
			teamPer.setBounds(1110-250,210,150,30);
			teamPer.setFont(new Font(teamPer.getText(),Font.BOLD,10));
			teamPer.setBackground(Color.GREEN);
			teamPer.setEnabled(false);
			add(teamPer);
			
			squaredJList.addListSelectionListener(new ListSelectionListener(){
	
				@Override
				public void valueChanged(ListSelectionEvent arg0) {
				
					selectButton.setVisible(true);
					selectButton.setEnabled(true);
					deselectButton.setVisible(false);
					deselectButton.setEnabled(false);
					
				//	
					
				}
				
			});
			
			teamJList.addListSelectionListener(new ListSelectionListener(){
	
				@Override
				public void valueChanged(ListSelectionEvent arg0) {
					
				
					selectButton.setVisible(false);
					selectButton.setEnabled(false);
					deselectButton.setVisible(true);
					deselectButton.setEnabled(true);
					
				}
				
			});
					
			selectButton.addActionListener(new ActionListener(){
	
				@Override
				public void actionPerformed(ActionEvent arg0) {
					
					if(squaredJList.getSelectedIndex()==-1){
						JOptionPane.showMessageDialog(null, "Please Select an Item!!!");
					}
					else
					{
						
						int index[]=squaredJList.getSelectedIndices();
						
						for(int i=0;i<index.length;i++){
							
							if(selected.get(index[i])==true){
								JOptionPane.showMessageDialog(null,nationSquard.get(index[i]).getFirstName()+""+nationSquard.get(index[i]).getLastName()+" has already been selected!!!" );
								continue;
							}
							
							nationTeam.add(nationSquard.get(index[i]));
							teamModel.addElement(squaredModel.get(index[i]));	
							int performance=(int) nationSquard.get(index[i]).getAverage();
							teamPerformanceBar.get(nationTeam.size()-1).setValue(performance);
							squaredPerformanceBar.get(index[i]).setValue(0);
							selected.set(index[i],true);
							NoOfPlayer++;
							
							if(NoOfPlayer==11){
								
								JOptionPane.showMessageDialog(null, "11 Players has been selected");
								break;
							}
						}
						if(NoOfPlayer==11){
							int choice=JOptionPane.showConfirmDialog(null, "Do You want to Play??", "Confirmation", JOptionPane.YES_NO_OPTION);
							
							if(choice==-1){
								selectButton.setVisible(false);
								deselectButton.setVisible(true);
							}
							else if(choice==0){
								
								List<Batsman> batsmen=new ArrayList<Batsman>();
								for (int i = 0; i < nationTeam.size(); i++) {
									Batsman batsman=new Batsman();
									batsman.setBall(0);
									batsman.setNoOfFour(0);
									batsman.setNoOfOne(0);
									batsman.setNoOfSix(0);
									batsman.setNoOfThree(0);
									batsman.setNoOfTwo(0);
									batsman.setNoOfZero(0);
									batsman.setRun(0);
									batsman.setStatus(Status.STILL_TO_BAT);
									batsmen.add(batsman);	
								}
								PlayerSelection.this.dispose();
								MatchFrame frame=new MatchFrame(userNation,opponentNation,nationTeam,batsmen,settings,1);
								frame.setView(1300, 800);
							}
							else if(choice==1){	
								selectButton.setVisible(false);
								deselectButton.setVisible(true);
							}
						}
					}
				}
			});
			deselectButton.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent event) {
					if(teamJList.getSelectedIndex()==-1){
						JOptionPane.showMessageDialog(null, "Please Select an Item!!!");
					}
					else{
						int index[]=teamJList.getSelectedIndices();
						for(int i=0;i<index.length;i++){
							
							String getId=(nationTeam.get(index[i]).getplayerID());
							for(int j=0;j<nationSquard.size();j++){
								if(getId.equals(nationSquard.get(j).getplayerID())){
									squaredPerformanceBar.get(j).setValue(teamPerformanceBar.get(index[i]).getValue());
									selected.set(j,false);
								}
							}
							teamPerformanceBar.get(index[i]).setValue(0);
							
							for(int j=index[i];j<nationTeam.size()-1;j++){
								int performance=(int) nationTeam.get(j+1).getAverage();
								teamPerformanceBar.get(j).setValue(performance);
							}
							if(nationTeam.size()>0){
								teamPerformanceBar.get(nationTeam.size()-1).setValue(0);
							}
							teamModel.remove(index[i]);
							nationTeam.remove(index[i]);
							NoOfPlayer--;						
							}
					}
				}			
			});
			back=new JButton("Back");
			back.setBounds(500,650 ,200 ,40 );
			back.setBackground(Color.BLUE);
			back.setForeground(Color.MAGENTA);
			add(back);
			back.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					PlayerSelection.this.dispose();
					TeamSelection frame=new TeamSelection(settings);
					frame.setView(1300, 800);
				}
				
			});
			
		}
	 public PlayerSelection(final Tournament tournament) {
			super("Players");
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
			
			readPlayers();
			getNationPlayers();
			
			ImageIcon icon=new ImageIcon("src/resource/"+this.userNation.getFlagOfNation());			
			JLabel flag=new JLabel(icon);
			flag.setBounds(350-100, 10, 125, 125);
			add(flag);
			
			ImageIcon versesImageIcon=new ImageIcon(("src/resource/Vs.png"));
			JLabel versesImage=new JLabel(versesImageIcon);
			versesImage.setBounds(600-150,10,150,150);
			add(versesImage);
			
			ImageIcon icon1=new ImageIcon("src/resource/"+(this.opponentNation.getFlagOfNation()));
			
			JLabel flag1=new JLabel(icon1);
			flag1.setBounds(800-150, 10, 125, 125);
			add(flag1);
			
			
			JLabel name=new JLabel(this.userNation.getNameOfNation());
			name.setBounds(350-150,140,150,30);
			name.setFont(new Font(name.getText(),Font.BOLD,25));
			name.setForeground(Color.BLUE);
			add(name);
			
			JLabel name1=new JLabel(this.opponentNation.getNameOfNation());
			name1.setBounds(800-150,140,200,30);
			name1.setFont(new Font(name1.getText(),Font.BOLD,25));
			name1.setForeground(Color.BLUE);
			add(name1);
			
			
			
			JButton squaredLabel=new JButton("Squard");
			squaredLabel.setBounds(200-50,170,200,30);
			squaredLabel.setFont(new Font(squaredLabel.getText(),Font.BOLD,25));
			squaredLabel.setBackground(Color.GREEN);
			squaredLabel.setEnabled(false);
			add(squaredLabel);
			
			JButton squaredName=new JButton("Name");
			squaredName.setBounds(100-50,210,250,30);
			squaredName.setFont(new Font(squaredName.getText(),Font.BOLD,25));
			squaredName.setBackground(Color.GREEN);
			squaredName.setEnabled(false);
			add(squaredName);
			
			JButton squaredPer=new JButton("Performance");
			squaredPer.setBounds(455-150,210,150,30);
			squaredPer.setFont(new Font(squaredPer.getText(),Font.BOLD,10));
			squaredPer.setBackground(Color.GREEN);
			squaredPer.setEnabled(false);
			add(squaredPer);
			
			for(int i=0;i<nationSquard.size();i++){
				squaredModel.addElement(nationSquard.get(i).getFirstName()+" "+nationSquard.get(i).getLastName());
				selected.add(false);
			}
			
			for(int i=0;i<nationTeam.size();i++){
				teamModel.addElement(nationTeam.get(i).getFirstName()+" "+nationTeam.get(i).getLastName());
					
			}
			box1=Box.createHorizontalBox();
			squaredJList=new JList(squaredModel);
			squaredJList.setFixedCellHeight(25);
			squaredJList.setFixedCellWidth(200);
			squaredJList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
			squaredJList.setFont(new Font(squaredJList.getToolTipText(),Font.PLAIN,20));
			squaredJList.setForeground(Color.BLACK);
			squaredJList.setBackground(Color.WHITE);
			squaredJList.setVisibleRowCount(10);
			box1.add(new JScrollPane(squaredJList));
			box1.setBounds(50,250,250,400);
			add(box1);
			


			
			for(int i=0;i<nationSquard.size();i++){
				JProgressBar bar=new JProgressBar(0,25);
				int performance=(int) nationSquard.get(i).getAverage();
				if(performance >=25){
					performance=25;
				}
				bar.setValue(performance);
				squaredPerformanceBar.add(bar);
			}
			for(int i=0;i<nationSquard.size();i++){
				squaredPerformanceBar.get(i).setBounds(455-150, 250+i*25, 150, 25);
				squaredPerformanceBar.get(i).setBackground(Color.WHITE);
				squaredPerformanceBar.get(i).setForeground(Color.PINK);
				add(squaredPerformanceBar.get(i));
			}
			
			for(int i=0;i<11;i++){
				JProgressBar bar=new JProgressBar(0,25);
				bar.setValue(0);
				teamPerformanceBar.add(bar);
			}
			for(int i=0;i<11;i++){
				teamPerformanceBar.get(i).setBounds(860, 250+i*25, 150, 25);
				teamPerformanceBar.get(i).setBackground(Color.WHITE);
				teamPerformanceBar.get(i).setForeground(Color.PINK);
				add(teamPerformanceBar.get(i));
			}
			
			selectButton=new JButton("+");
			selectButton.setBounds(620-150, 450, 100, 30);
			selectButton.setFont(new Font(selectButton.getText(),Font.BOLD,25));
			selectButton.setBackground(Color.BLUE);
			selectButton.setForeground(Color.MAGENTA);
			selectButton.setVisible(true);
			add(selectButton);
			
			
			deselectButton=new JButton("-");
			deselectButton.setBounds(620-150, 450, 100, 30);
			deselectButton.setFont(new Font(deselectButton.getText(),Font.BOLD,25));
			deselectButton.setBackground(Color.BLUE);
			deselectButton.setForeground(Color.MAGENTA);
			deselectButton.setVisible(false);
			add(deselectButton);
			
			box2=Box.createHorizontalBox();
			teamJList=new JList(teamModel);
			teamJList.setFixedCellHeight(25);
			teamJList.setFixedCellWidth(200);
			teamJList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
			teamJList.setFont(new Font(teamJList.getToolTipText(),Font.PLAIN,20));
			teamJList.setForeground(Color.BLACK);
			teamJList.setBackground(Color.WHITE);
			teamJList.setVisibleRowCount(5);
			box2.add(new JScrollPane(teamJList));
			box2.setBounds(750-150,250,250,400);
			add(box2);
			
			JButton teamLabel=new JButton("Team");
			teamLabel.setBounds(650+200-150,170,200,30);
			teamLabel.setFont(new Font(teamLabel.getText(),Font.BOLD,25));
			teamLabel.setBackground(Color.GREEN);
			teamLabel.setEnabled(false);
			add(teamLabel);
			
			JButton teamName=new JButton("Name");
			teamName.setBounds(650+100-150,210,250,30);
			teamName.setFont(new Font(teamName.getText(),Font.BOLD,25));
			teamName.setBackground(Color.GREEN);
			teamName.setEnabled(false);
			add(teamName);
			
			JButton teamPer=new JButton("Performance");
			teamPer.setBounds(1110-250,210,150,30);
			teamPer.setFont(new Font(teamPer.getText(),Font.BOLD,10));
			teamPer.setBackground(Color.GREEN);
			teamPer.setEnabled(false);
			add(teamPer);
			
			squaredJList.addListSelectionListener(new ListSelectionListener(){
	
				@Override
				public void valueChanged(ListSelectionEvent arg0) {
				
					selectButton.setVisible(true);
					selectButton.setEnabled(true);
					deselectButton.setVisible(false);
					deselectButton.setEnabled(false);
				}
			});
			teamJList.addListSelectionListener(new ListSelectionListener(){
	
				@Override
				public void valueChanged(ListSelectionEvent arg0) {
					
				
					selectButton.setVisible(false);
					selectButton.setEnabled(false);
					deselectButton.setVisible(true);
					deselectButton.setEnabled(true);
					
				}
				
			});
					
			selectButton.addActionListener(new ActionListener(){
	
				@Override
				public void actionPerformed(ActionEvent arg0) {
					
					if(squaredJList.getSelectedIndex()==-1){
						JOptionPane.showMessageDialog(null, "Please Select an Item!!!");
					}
					else
					{
						
						int index[]=squaredJList.getSelectedIndices();
						
						for(int i=0;i<index.length;i++){
							
							if(selected.get(index[i])==true){
								JOptionPane.showMessageDialog(null,nationSquard.get(index[i]).getFirstName()+""+nationSquard.get(index[i]).getLastName()+" has already been selected!!!" );
								continue;
							}
							
							nationTeam.add(nationSquard.get(index[i]));
							teamModel.addElement(squaredModel.get(index[i]));	
							int performance=(int) nationSquard.get(index[i]).getAverage();
							teamPerformanceBar.get(nationTeam.size()-1).setValue(performance);
							squaredPerformanceBar.get(index[i]).setValue(0);
							selected.set(index[i],true);
							NoOfPlayer++;
							
							if(NoOfPlayer==11){
								
								JOptionPane.showMessageDialog(null, "11 Players has been selected");
								break;
							}
						}
						if(NoOfPlayer==11){
							int choice=JOptionPane.showConfirmDialog(null, "Do You want to Play??", "Confirmation", JOptionPane.YES_NO_OPTION);
							
							if(choice==-1){
								selectButton.setVisible(false);
								deselectButton.setVisible(true);
							}
							else if(choice==0){
								
								List<Batsman> batsmen=new ArrayList<Batsman>();
								for (int i = 0; i < nationTeam.size(); i++) {
									Batsman batsman=new Batsman();
									batsman.setBall(0);
									batsman.setNoOfFour(0);
									batsman.setNoOfOne(0);
									batsman.setNoOfSix(0);
									batsman.setNoOfThree(0);
									batsman.setNoOfTwo(0);
									batsman.setNoOfZero(0);
									batsman.setRun(0);
									batsman.setStatus(Status.STILL_TO_BAT);
									batsmen.add(batsman);	
								}
								PlayerSelection.this.dispose();
								MatchFrame frame=new MatchFrame(tournament, nationTeam, batsmen);
								frame.setView(1300, 800);
							}
							else if(choice==1){	
								selectButton.setVisible(false);
								deselectButton.setVisible(true);
							}
						}
					}
				}
			});
			deselectButton.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent event) {
					if(teamJList.getSelectedIndex()==-1){
						JOptionPane.showMessageDialog(null, "Please Select an Item!!!");
					}
					else{
						int index[]=teamJList.getSelectedIndices();
						for(int i=0;i<index.length;i++){
							
							String getId=(nationTeam.get(index[i]).getplayerID());
							for(int j=0;j<nationSquard.size();j++){
								if(getId.equals(nationSquard.get(j).getplayerID())){
									squaredPerformanceBar.get(j).setValue(teamPerformanceBar.get(index[i]).getValue());
									selected.set(j,false);
								}
							}
							teamPerformanceBar.get(index[i]).setValue(0);
							
							for(int j=index[i];j<nationTeam.size()-1;j++){
								int performance=(int) nationTeam.get(j+1).getAverage();
								teamPerformanceBar.get(j).setValue(performance);
							}
							if(nationTeam.size()>0){
								teamPerformanceBar.get(nationTeam.size()-1).setValue(0);
							}
							teamModel.remove(index[i]);
							nationTeam.remove(index[i]);
							NoOfPlayer--;						
							}
					}
				}			
			});
			back=new JButton("Back");
			back.setBounds(500,650 ,200 ,40 );
			back.setBackground(Color.BLUE);
			back.setForeground(Color.MAGENTA);
			add(back);
			back.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					PlayerSelection.this.dispose();
					MatchFrame frame=new MatchFrame(tournament);
					frame.setView(1300, 700);
				}
				
			});
			
		}	
	 private void readPlayers(){
		 players= new FileIO().readPlayers("/resource/Players.txt");
	 }
	 private void getNationPlayers(){
		 System.out.println("\n\n"+userNation.getIdOfNation()+"\n\n");
		 String constant=userNation.getIdOfNation();
		 for (int i = 0; i < players.size(); i++) {
			 if(players.get(i).getnationID().equals(constant)){
				 nationSquard.add(players.get(i));
			 }
		}
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