package cricket.main.ui;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BackGround extends JPanel{

	Color color;
	JLabel label;
	
	public BackGround(Color color) {
		setLayout(null);
		this.color=color;
		setBackground(color);
	}
	public BackGround(Color color,String str){
		setLayout(null);
		this.color=color;
		setBackground(color);
		ImageIcon icon=new ImageIcon(str);
		label=new JLabel(icon);
		label.setBounds(600,50, 600,600);
		add(label);
	}

}
