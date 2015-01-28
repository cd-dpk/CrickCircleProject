package cricket.tournament;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import cricket.constant.Stage;
import cricket.entities.Nation;
import cricket.entities.Tournament;

public class PlayOFF extends JPanel{
	
		private JButton[] semiButton=new JButton[4];
		private JButton[] finalButton=new JButton[2];
		private JButton championButton=new JButton();
		
	 	public PlayOFF(Tournament tournament){
			
	 		setLayout(null);
			setBackground(Color.WHITE);
			JLabel playOff=new JLabel("PlayOFF");
			playOff.setBounds(400, 10, 200, 30);
			playOff.setForeground(Color.BLUE);
			add(playOff);
			
			JLabel semiFinalLabel,finalLabel,championLabel;
			
			semiFinalLabel=new JLabel("SemiFinal");			
			semiFinalLabel.setBounds(180, 50, 150, 30);
			add(semiFinalLabel);
			
			finalLabel=new JLabel("Final");			
			finalLabel.setBounds(430, 50, 150, 30);
			add(finalLabel);
			
			championLabel=new JLabel("Champion");			
			championLabel.setBounds(680, 50, 150, 30);
			add(championLabel);
			
			JLabel label[]=new JLabel[4];
			label[0]=new JLabel("GA Champion");
			label[1]=new JLabel("GB RunnerUP");
			
			label[2]=new JLabel("GB Champion");
			label[3]=new JLabel("GA RunnerUp");
			
			label[0].setBounds(10, 90, 120, 30);
			label[1].setBounds(10, 60+90, 120, 30);
			label[2].setBounds(10, 60+60+90, 120, 30);
			label[3].setBounds(10, 60+60+60+90, 120, 30);
			
			add(label[0]);
			add(label[1]);
			add(label[2]);
			add(label[3]);
			
			for(int i=0;i<4;i=i+1){
				semiButton[i]=new JButton();
				if (i%2==0) {
					semiButton[i].setText(tournament.getSemiFinal()[i/2][i%2].getNameOfNation());
					if(tournament.getUserNation().getIdOfNation().equals(tournament.getSemiFinal()[i/2][i%2].getIdOfNation())){
						semiButton[i].setText("*"+semiButton[i].getText());	
					}
				}
				else {
					semiButton[i].setText(tournament.getSemiFinal()[i/2][i%2].getNameOfNation());					
					if(tournament.getUserNation().getIdOfNation().equals(tournament.getSemiFinal()[i/2][i%2].getIdOfNation())){
						semiButton[i].setText("*"+semiButton[i].getText());	
					}
				}
				semiButton[i].setBounds(130, i*60+90, 150, 30);
				add(semiButton[i]);
				semiButton[i].setEnabled(false);
				if (tournament.getStage().equals(Stage.FINAL)) {
					
				} 
				
			}
			
			for(int i=0;i<2;i++){
				finalButton[i]=new JButton();
				if (i%2==0) {
					finalButton[i].setText(tournament.getFinal()[i%2].getNameOfNation());
					if(tournament.getUserNation().getIdOfNation().equals(tournament.getFinal()[i%2].getIdOfNation())){
						finalButton[i].setText("*"+finalButton[i].getText());	
					}
				}
				else {
					finalButton[i].setText(tournament.getFinal()[i%2].getNameOfNation());					
					if(tournament.getUserNation().getIdOfNation().equals(tournament.getFinal()[i%2].getIdOfNation())){
						finalButton[i].setText("*"+finalButton[i].getText());	
					}
				}
				finalButton[i].setBounds(380,i*120+125, 150, 30);
				finalButton[i].setEnabled(false);
				add(finalButton[i]);
				
				/*if(TournamentFrame.height==1){
					finalButton[i].setBackground(Color.GREEN);
					finalButton[i].setForeground(Color.MAGENTA);
				}
				*/
			}
				
			championButton=new JButton(tournament.getChampionNation().getNameOfNation());
			championButton.setBounds(630, 185, 150, 30);
			championButton.setEnabled(false);
			add(championButton);
			/*if(TournamentFrame.height==0){
				championButton.setBackground(Color.GREEN);
				championButton.setForeground(Color.MAGENTA);
			}
		*/}
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			g.setColor(Color.BLUE);
			for(int i=0;i<4;i++){
				g.drawLine(280, i*60+90+15, 330,i*60+90+15 );
			}
			g.drawLine(330,105,330,165);
			g.drawLine(330,225,330,285);
			g.setColor(Color.RED);
			for(int i=0;i<2;i++){
				g.drawLine(330, i*120+125+15, 380,i*120+125+15 );
				g.drawLine(530, i*120+125+15, 580,i*120+125+15 );
			}
			g.drawLine(580,140,580,260);
			g.setColor(Color.GREEN);
			g.drawLine(630,200,580,200);
		}
		
}