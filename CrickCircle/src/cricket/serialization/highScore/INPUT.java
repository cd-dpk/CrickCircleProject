package cricket.serialization.highScore;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import cricket.entities.HighScore;
import cricket.main.ui.HighScores;

public class INPUT {

	private ObjectInputStream input;
	public List<HighScore> highScore=new ArrayList<HighScore>();
	String fileName;
	public INPUT(String fileName) {
		this.fileName=fileName;
	}
	public void openfile(){
		try{
			input=new ObjectInputStream(new FileInputStream("src/cricket/serialization/highScore/"+fileName+"HighScore.txt"));
		}
		catch(Exception e){
			//System.out.println("Error opening file");
		}
	}
	public  void readRecords(){
		
		try {
				while(true){
					this.highScore.add((HighScore) input.readObject());
				}
		}
		catch ( EOFException endOfFileException )
		{
		return; // end of file was reached
		} // end catch
		catch ( ClassNotFoundException classNotFoundException )
		{
		//System.err.println( "Unable to create object." );
		} // end catch
		catch ( IOException ioException )
		{
		//System.err.println( "Error during read from file." );
		} 

	}

	public void closeFile(){
		try {
			if(input!=null)
				input.close();
			else{
				//System.exit(0);
			}
		} catch (IOException e) {
			//e.printStackTrace();
		}
		
	}
	/*public static void main(String[] args) {
		INPUT inputS=new INPUT("Single");
		inputS.openfile();
		inputS.readRecords();
		inputS.closeFile();
		
		INPUT inputT=new INPUT("Tournament");
		inputT.openfile();
		inputT.readRecords();
		inputT.closeFile();

		System.out.println("Single Match");
		for (int i = 0; i < inputS.highScore.size(); i++) {
			System.out.println(inputS.highScore.get(i).getName()+" "+inputS.highScore.get(i).getScore() +" "+inputS.highScore.get(i).getDate());
		}
		System.out.println("Tournament");
		for (int i = 0; i < inputT.highScore.size(); i++) {
			System.out.println(inputT.highScore.get(i).getName()+" "+inputT.highScore.get(i).getScore() +" "+inputT.highScore.get(i).getDate());
		}
		
	}
*/
}
