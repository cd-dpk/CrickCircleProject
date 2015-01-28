package cricket.serialization;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import cricket.entities.Match;

public class INPUT {

	private ObjectInputStream input;
	
	Match match;
	String fileName;
	public INPUT(String fileName) {
		this.fileName=fileName;
	}
	
	public void setMatch(Match match){
		this.match=match;
	}
	public Match getMatch(){
		return match;
	} 
	public void openfile(){		
		try{
			input=new ObjectInputStream(new FileInputStream("src/cricket/serialization/"+fileName+".txt"));
		}
		catch(Exception e){
			//System.out.println("Error opening file");
		}
	}
	public  void readRecords(){
		
		try {
				while(true){
					match=(Match)input.readObject();
					setMatch(match);
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
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
	}/*
	*//**
	 * @param args
	 *//*
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		INPUT obj=new INPUT("Single");
		obj.openfile();
		obj.readRecords();
		obj.closeFile();
		
		
		
	}

*/}
