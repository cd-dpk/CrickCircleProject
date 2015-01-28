package cricket.serialization.highScore;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import cricket.entities.HighScore;
import cricket.main.ui.HighScores;

public class OUTPUT {
	
	private ObjectOutputStream output;
	public List<HighScore>highScore=new ArrayList<HighScore>();
	String fileName;
	public OUTPUT(List<HighScore>highScore, String fileName){
		this.highScore=highScore;
		this.fileName=fileName;
	}
	public void openfile(){		
		try{
			output=new ObjectOutputStream(new FileOutputStream("src/cricket/serialization/highScore/"+fileName+"HighScore.txt"));
		}
		catch(Exception e){
			System.out.println("Error opening file");
		}
	}
	public  void addRecords(){
		try {
			for (int i = 0; i<highScore.size() && i<5; i++) {
				output.writeObject(highScore.get(i));	
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void closeFile(){
		try {
			if(output!=null)
				output.close();
			else{
				System.exit(0);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
//	/*
	public static void main(String [] args) {
		
		List<HighScore>highScores=new ArrayList<HighScore>();
		highScores.add(new HighScore("null",0,"null"));
		highScores.add(new HighScore("null",0,"null"));
		highScores.add(new HighScore("null",0,"null"));
		highScores.add(new HighScore("null",0,"null"));
		highScores.add(new HighScore("null",0,"null"));
		
		OUTPUT outputS=new OUTPUT(highScores,"Single");
		OUTPUT outputT=new OUTPUT(highScores,"tournament");
		
		outputS.openfile();
		outputS.addRecords();
		outputS.closeFile();
		
		outputT.openfile();
		outputT.addRecords();
		outputT.closeFile();
		
		System.out.println("Done");
	}
//	*/
}
