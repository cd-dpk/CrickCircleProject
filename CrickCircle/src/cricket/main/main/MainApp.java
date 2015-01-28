package cricket.main.main;
import cricket.constant.GameMode;
import cricket.constant.Level;
import cricket.constant.Over;
import cricket.constant.Sound;
import cricket.entities.Settings;
import cricket.main.ui.MainMenu;
public class MainApp {
	public static void main(String args[])  {
		Settings settings=new Settings(GameMode.SINGLE_MATCH,Sound.OFF,Level.EASY,Over.FIVE);
		MainMenu frame=new MainMenu(settings);	
		frame.setView(1300, 800);
	}
}