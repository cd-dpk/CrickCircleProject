package cricket.main.ui;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import cricket.constant.Status;
import cricket.entities.Innings;

public class FullScoreCard  extends JPanel{

	JLabel label[][]=new JLabel[11][7];
	Innings innings;
	public FullScoreCard(Innings innings) {
		setLayout(null);
		this.innings=innings;
		JLabel la[]=new JLabel[7];
		la[0]=new JLabel("Name");
		la[0].setBounds(20,0 ,300 , 30);
		la[0].setBackground(Color.GREEN);
		la[0].setForeground(Color.BLUE);
		add(la[0]);
		

		la[1]=new JLabel("Status");
		la[1].setBounds(325,0 ,300 , 30);
		la[1].setBackground(Color.GREEN);
		la[1].setForeground(Color.BLUE);
		add(la[1]);

		la[2]=new JLabel("Run");
		la[2].setBounds(430,0 ,300 , 30);
		la[2].setBackground(Color.GREEN);
		la[2].setForeground(Color.BLUE);
		add(la[2]);

		la[3]=new JLabel("Ball");
		la[3].setBounds(485,0 ,300 , 30);
		la[3].setBackground(Color.GREEN);
		la[3].setForeground(Color.BLUE);
		add(la[3]);

		la[4]=new JLabel("4's");
		la[4].setBounds(540,0 ,300 , 30);
		la[4].setBackground(Color.GREEN);
		la[4].setForeground(Color.BLUE);
		add(la[4]);
		

		la[5]=new JLabel("6's");
		la[5].setBounds(600,0 ,300 , 30);
		la[5].setBackground(Color.GREEN);
		la[5].setForeground(Color.BLUE);
		add(la[5]);
		

		la[6]=new JLabel("SR");
		la[6].setBounds(660,0 ,300 , 30);
		la[6].setBackground(Color.GREEN);
		la[6].setForeground(Color.BLUE);
		add(la[6]);
		for(int i=0;i<11;i++){
				label[i][0]=new JLabel(innings.getPlayers().get(i).getFirstName()+" "+innings.getPlayers().get(i).getLastName());
				label[i][0].setBounds(20,i*30+50 ,300 , 30);
				label[i][0].setBackground(Color.GREEN);
				label[i][0].setForeground(Color.BLUE);
				add(label[i][0]);
			
				label[i][1]=new JLabel();
				
				if(innings.getBatsman().get(i).getStatus()==Status.STILL_TO_BAT){
					label[i][1].setText("Still to bat");
				}
				else if(innings.getBatsman().get(i).getStatus()==Status.NOT_OUT){
					label[i][1].setText("not out");
				}
				else if(innings.getBatsman().get(i).getStatus()==Status.OUT){
					label[i][1].setText("out");
				}
				label[i][1].setBounds(325,i*30+50 ,100, 30);
				label[i][1].setBackground(Color.GREEN);
				label[i][1].setForeground(Color.BLUE);
				add(label[i][1]);
			
				label[i][2]=new JLabel();
				if(innings.getBatsman().get(i).getStatus()==Status.STILL_TO_BAT){
					label[i][2].setText("-");
				}
				else{
					label[i][2].setText(innings.getBatsman().get(i).getRun()+"");
				}
				
				label[i][2].setBounds(430,i*30+50 ,50, 30);
				label[i][2].setBackground(Color.GREEN);
				label[i][2].setForeground(Color.BLUE);
				add(label[i][2]);
				
				label[i][3]=new JLabel();
				label[i][3].setBounds(485,i*30+50, 50, 30);
				label[i][3].setBackground(Color.GREEN);
				label[i][3].setForeground(Color.BLUE);
				add(label[i][3]);
			
				if(innings.getBatsman().get(i).getStatus()==Status.STILL_TO_BAT){
					label[i][3].setText("-");
				}
				else{
					label[i][3].setText(innings.getBatsman().get(i).getBall()+"");
				}
				
				label[i][4]=new JLabel();
				if(innings.getBatsman().get(i).getStatus()==Status.STILL_TO_BAT){
					label[i][4].setText("-");
				}
				else{
					label[i][4].setText(innings.getBatsman().get(i).getNoOfFour()+"");
				}
				label[i][4].setBounds(540,i*30+50 , 50, 30);
				label[i][4].setBackground(Color.GREEN);
				label[i][4].setForeground(Color.BLUE);
				add(label[i][4]);
			
				label[i][5]=new JLabel();
				if(innings.getBatsman().get(i).getStatus()==Status.STILL_TO_BAT){
					label[i][5].setText("-");
				}
				else{
					label[i][5].setText(innings.getBatsman().get(i).getNoOfSix()+"");
				}
				label[i][5].setBounds(600,i*30+50, 50, 30);
				label[i][5].setBackground(Color.GREEN);
				label[i][5].setForeground(Color.BLUE);
				add(label[i][5]);
				

				label[i][6]=new JLabel(i+",6");
				if(innings.getBatsman().get(i).getStatus()==Status.STILL_TO_BAT){
					label[i][6].setText("-");
				}
				else{
					if(innings.getBatsman().get(i).getBall()!=0){
						label[i][6].setText(((int)((double)innings.getBatsman().get(i).getRun()/(double)innings.getBatsman().get(i).getBall())*100)+"");
					}
					else{
						label[i][6].setText("-");
					}
				}
				label[i][6].setBounds(660,i*30+50, 50, 30);
				label[i][6].setBackground(Color.GREEN);
				label[i][6].setForeground(Color.BLUE);
				add(label[i][6]);
		}
		
		JLabel over=new JLabel("Overs : "+innings.getOvers());
		over.setFont(new Font(over.getText(),Font.BOLD,16));
		over.setBounds(100,400, 250, 30);
		over.setBackground(Color.GREEN);
		over.setForeground(Color.BLUE);
		add(over);
		
		JLabel total=new JLabel("Total : "+innings.getRuns()+"/"+innings.getWickets());
		total.setFont(new Font(total.getText(),Font.BOLD,16));
		total.setBounds(400,400, 250, 30);
		total.setBackground(Color.GREEN);
		total.setForeground(Color.BLUE);
		add(total);
	}
}