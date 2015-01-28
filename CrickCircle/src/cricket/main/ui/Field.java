package cricket.main.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
public class Field extends JPanel {
	
		int array[][];
		double r;
		String ar[][];
		private JLabel label[]=new JLabel[12];
		public Field(double r) {
			setLayout(null);
			this.r=r;
			addMouseListener(new MouseAdapter(){
				public void mouseClicked(MouseEvent event){
					if(System.currentTimeMillis() <CrickCircle.match.ball.selectionTimeInSys && CrickCircle.notSelectedFlag==false){
						JOptionPane.showMessageDialog(null, "Twice Selection :o ");
					}
					else if(System.currentTimeMillis() < CrickCircle.match.ball.selectionTimeInSys && CrickCircle.notSelectedFlag==true){
						CrickCircle.match.userInnings.setSavedTime(CrickCircle.match.userInnings.getSavedTime()+(CrickCircle.match.ball.selectionTimeInSys-System.currentTimeMillis()));
						double radius=Math.sqrt((event.getX()-300)*(event.getX()-300)+(300-event.getY())*(300-event.getY()));
						if(radius<50 || radius>300 ){
							JOptionPane.showMessageDialog(null, "Out of Scope!!");
						}
						else{
							CrickCircle.match.ball.relativeX=event.getX();
							CrickCircle.match.ball.relativeY=event.getY();
							CrickCircle.match.ball.actualX=CrickCircle.match.ball.relativeX-300;
							CrickCircle.match.ball.actualY=300-CrickCircle.match.ball.relativeY;
							CrickCircle.notSelectedFlag=false;
						}
					
					}
					else if(System.currentTimeMillis() >CrickCircle.match.ball.selectionTimeInSys ) {
						JOptionPane.showMessageDialog(null, "Time Is Up");
					}
				}	
			});
		}
		
		
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			array=new int[CrickCircle.list.size()][2];
			
			for(int i=0;i<CrickCircle.list.size();i++){	
				array[i][0] = (int) (Math.ceil(CrickCircle.list.get(i).getStart()+0.5));
				array[i][1] = (int) (Math.ceil((CrickCircle.list.get(i).getEnd()-CrickCircle.list.get(i).getStart())));
				ImageIcon image=new ImageIcon("src/resource/"+(CrickCircle.list.get(i).getImage()));
				label[i]=new JLabel(image);
				label[i].setBounds(300+(int) (CrickCircle.list.get(i).getX()-(CrickCircle.list.get(i).getR()/Math.sqrt(2.0))),300-(int) (CrickCircle.list.get(i).getY()+(CrickCircle.list.get(i).getR()/Math.sqrt(2.0))),CrickCircle.list.get(i).getR(),CrickCircle.list.get(i).getR());
				add(label[i]);
			}
			for(int i=0;i<CrickCircle.list.size();i++){
				g.setColor(CrickCircle.list.get(i).getColor());
				g.fillArc(0, 0, 600,600 ,array[i][0],array[i][1]);
			}
			
			g.setColor(Color.RED);
			g.fillOval(250, 250, 100, 100);
			g.drawOval(0,0, 600,600);
			g.setColor(Color.ORANGE);
			if(CrickCircle.notSelectedFlag==false){
				g.fillOval(CrickCircle.match.ball.relativeX-10,CrickCircle.match.ball.relativeY-10,20,20);
			}
			
		}
}
