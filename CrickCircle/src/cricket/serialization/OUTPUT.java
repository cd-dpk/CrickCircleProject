package cricket.serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import cricket.entities.Match;

public class OUTPUT {
	
	private ObjectOutputStream output;
	Match match;
	String fileName;
	public OUTPUT(Match match,String fileName){
		this.match=match;
		this.fileName=fileName;
	}
	
	public void openfile(){		
		try{
			output=new ObjectOutputStream(new FileOutputStream("src/cricket/serialization/"+fileName+".txt"));
		}
		catch(Exception e){
			System.out.println("Error opening file");
			
		}
	}
	public  void addRecords(){
		
		try {
			output.writeObject(match);
		} catch (IOException e) {
			// TODO Auto-generated catch block
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/*public static void  main(String [] args) {
		
		OUTPUT output=new OUTPUT(new Match(), "Single");
		output.openfile();
		output.addRecords();
		output.closeFile();
		
		OUTPUT input=new OUTPUT(new Match(), "Tournament");
		input.openfile();
		input.addRecords();
		input.closeFile();
		
		
	}*/

}
