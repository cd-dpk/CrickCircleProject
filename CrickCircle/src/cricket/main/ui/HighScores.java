package cricket.main.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;
import cricket.entities.HighScore;

public class HighScores extends JDialog{

	public HighScores(MainMenu frame,boolean view,final List<HighScore>highScore){
		super(frame, "HighScores", true);
//		setLayout(null);
		add(new JPanel(){
			@Override
			public void setLayout(LayoutManager mgr) {
				super.setLayout(null);
			}
			public void paintComponent(Graphics g){
				super.paintComponent(g);

				JTextField textField[][]=new JTextField[6][3];
				JTextField name=new JTextField("Name");
				name.setBounds(50, 50, 150, 30);
				name.setEditable(false);
				name.setBackground(Color.WHITE);
				name.setForeground(Color.MAGENTA);
				add(name);
				
				JTextField score=new JTextField("Score");
				score.setBounds(200, 50, 150, 30);
				score.setEditable(false);
				score.setBackground(Color.WHITE);
				score.setForeground(Color.MAGENTA);
				add(score);
				
				JTextField date=new JTextField("Date");
				date.setBounds(350, 50, 250, 30);
				date.setEditable(false);
				date.setBackground(Color.WHITE);
				date.setForeground(Color.MAGENTA);
				add(date);
				
				for (int i = 0; i < highScore.size(); i++) {
						textField[i+1][0]=new JTextField(highScore.get(i).getName());
						textField[i+1][0].setBounds(50+150*0, 100+50*i, 150, 30);
						textField[i+1][0].setEditable(false);
						textField[i+1][0].setBackground(Color.WHITE);
						textField[i+1][0].setForeground(Color.MAGENTA);
						add(textField[i+1][0]);
						
						textField[i+1][1]=new JTextField(""+highScore.get(i).getScore());
						textField[i+1][1].setBounds(50+150*1, 100+50*i, 150, 30);
						textField[i+1][1].setEditable(false);
						textField[i+1][1].setBackground(Color.WHITE);
						textField[i+1][1].setForeground(Color.MAGENTA);
						add(textField[i+1][1]);
						
						textField[i+1][2]=new JTextField(highScore.get(i).getDate());
						textField[i+1][2].setBounds(50+150*2, 100+50*i, 250, 30);
						textField[i+1][2].setEditable(false);
						textField[i+1][2].setBackground(Color.WHITE);
						textField[i+1][2].setForeground(Color.MAGENTA);
						add(textField[i+1][2]);
				}
			}
		});
	}	
}
