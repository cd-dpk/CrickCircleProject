package cricket.tournament;
import java.awt.Color;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import cricket.entities.Nation;
import cricket.entities.Team;

public class PointTable  extends JPanel{

	List<Team> group;
	JLabel [][] label;
	Nation userNation;
	
	public PointTable(Nation userNation,List<Team>group, String string) {
		
		setLayout(null);
		this.group=group;
		this.userNation=userNation;
		
		JButton groupButton=new JButton(string);
		groupButton.setBounds(200,10,200,30);
		groupButton.setForeground(Color.MAGENTA);
		groupButton.setBackground(Color.BLUE);
		groupButton.setEnabled(false);
		add(groupButton);
		
		label=new JLabel[6][6];
		setBackground(Color.WHITE);

		label[0][0]=new JLabel();
		label[0][0].setText("County");
		label[0][0].setForeground(Color.BLUE);
		label[0][0].setBounds(0,50+0, 100,30);
		add(label[0][0]);
		
		label[0][1]=new JLabel();
		label[0][1].setText("Played");
		label[0][1].setForeground(Color.BLUE);
		label[0][1].setBounds(100, 50+0, 100,30);
		add(label[0][1]);
		
		label[0][2]=new JLabel();
		label[0][2].setText("Win");
		label[0][2].setForeground(Color.BLUE);
		label[0][2].setBounds(200, 50+0, 100,30);
		add(label[0][2]);
		
		label[0][3]=new JLabel();
		label[0][3].setForeground(Color.BLUE);
		label[0][3].setText("Loss");
		label[0][3].setBounds(300, 50+0, 100,30);
		add(label[0][3]);
		
		label[0][4]=new JLabel();
		label[0][4].setForeground(Color.BLUE);
		label[0][4].setText("Dr/Tr");
		label[0][4].setBounds(400, 50+0, 100,30);
		add(label[0][4]);
		
		label[0][5]=new JLabel();
		label[0][5].setForeground(Color.BLUE);
		label[0][5].setText("Point");
		label[0][5].setBounds(500, 50+0, 100,30);
		add(label[0][5]);
		

		
		for(int i=1;i<6;i++){
				label[i][0]=new JLabel();
				label[i][0].setText(group.get(i-1).getCodeNameOfNation());
				if(group.get(i-1).getIdOfNation().equals(userNation.getIdOfNation())){
					label[i][0].setText("*"+label[i][0].getText());
				}
				label[i][0].setBounds(0+10,i*50+50, 100,30);
				add(label[i][0]);
				
				label[i][1]=new JLabel();
				label[i][1].setText(group.get(i-1).getMatchPlayed()+"");
				label[i][1].setBounds(10+100, i*50+50, 100,30);
				add(label[i][1]);
				
				label[i][2]=new JLabel();
				label[i][2].setText(group.get(i-1).getWon()+"");
				label[i][2].setBounds(10+200, i*50+50, 100,30);
				add(label[i][2]);
				
				label[i][3]=new JLabel();
				label[i][3].setText(group.get(i-1).getLoss()+"");
				label[i][3].setBounds(10+300, i*50+50, 100,30);
				add(label[i][3]);
				
				label[i][4]=new JLabel();
				label[i][4].setText(group.get(i-1).getDr()+"");
				label[i][4].setBounds(400+10, i*50+50, 100,30);
				add(label[i][4]);
				
				label[i][5]=new JLabel();
				label[i][5].setText(group.get(i-1).getPoint()+"");
				label[i][5].setBounds(500+10, i*50+50, 100,30);
				add(label[i][5]);
		}
	}		
}