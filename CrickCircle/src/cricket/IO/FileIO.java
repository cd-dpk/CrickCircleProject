package cricket.IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import cricket.assist.Assistant;
import cricket.entities.Nation;
import cricket.entities.Player;

public class FileIO {
	
	public List<Nation> readNations(String filename)
			{
				List<Nation>nations=new ArrayList<Nation>();
				try {
					InputStream is = getClass().getResourceAsStream(filename);
					InputStreamReader isr = new InputStreamReader(is);
					BufferedReader br = new BufferedReader(isr);				
					String line;
					while ((line = br.readLine()) != null)
					{
						StringTokenizer strtk=new StringTokenizer(line," ",false);
						String str1[]=new String[strtk.countTokens()];
						int k=0;
						while(strtk.hasMoreTokens()){
							str1[k]=strtk.nextToken();
							k++;
						}
						Nation nation=new Nation();
						nation.setIdOfNation(str1[0]);
						nation.setRankOfNation(str1[1]);
						nation.setCodeNameOfNation(str1[2]);
						nation.setNameOfNation(new Assistant().getNationName(str1[3]));
						nation.setFlagOfNation(nation.getIdOfNation()+"fl.PNG");
						nation.setImageOfNation(nation.getIdOfNation()+"im.PNG");	  
						nations.add(nation);
					}
					  br.close();
					  isr.close();
					  is.close();
				} catch (IOException exception) {
					exception.printStackTrace();
				}
				  return nations;
			}
	
	public List<Player>  readPlayers(String fileName) {
			
		List<Player> players=new ArrayList<Player>();
			try {
				InputStream is = getClass().getResourceAsStream(fileName);
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);				
				
				players = new ArrayList<Player>();
				
				String line;
				
				while ((line = br.readLine()) != null){
					Player player=new Player();
					int count=0;
					
					StringTokenizer strtk1=new StringTokenizer(line," \t",false);
					int countTokens=0;
					
					while(strtk1.hasMoreTokens()){
						String st=strtk1.nextToken();
						if(!(st.equals(" ") || st.equals("\t"))) countTokens++;
					}
					
					StringTokenizer strtk2=new StringTokenizer(line," \t",false);
					String[] str=new String[countTokens];
					while(strtk2.hasMoreTokens()){
						str[count]=strtk2.nextToken();
						count++;
					}
				
						player.setFirstName(str[0]);
						player.setLastName(str[1]);	
						player.setplayerID(str[2]);
						player.setnationID(str[3]);	
						player.setMatch(Integer.parseInt(str[4]));	
						player.setInnings(Integer.parseInt(str[5]));	
						player.setNO(Integer.parseInt(str[6]));
						player.setRUNS(Integer.parseInt(str[7]));
						player.setHS(Integer.parseInt(str[8]));
						player.setAverage(Double.parseDouble(str[9]));	
						player.setBF(Integer.parseInt(str[10]));
						player.setStrikeRate(Double.parseDouble(str[11]));
						player.setHundreds(Integer.parseInt(str[12]));
						player.setFifties(Integer.parseInt(str[13]));
						player.setFours(Integer.parseInt(str[14]));
						player.setSixes(Integer.parseInt(str[15]));
						player.setZeroes(Integer.parseInt(str[16]));	
						player.setOnes(Integer.parseInt(str[17]));
						player.setTwos(Integer.parseInt(str[18]));
						player.setThrees(Integer.parseInt(str[19]));
						player.setBold(Integer.parseInt(str[20]));
						player.setLBW(Integer.parseInt(str[21]));
						player.setROUT(Integer.parseInt(str[22]));	
						player.setCatch(Integer.parseInt(str[23]));
						player.setSt(Integer.parseInt(str[24]));
						players.add(player);
				
				}
			} catch (NumberFormatException exception) {
				// TODO Auto-generated catch block
				exception.printStackTrace();
			} catch (IOException exception) {
				// TODO Auto-generated catch block
				exception.printStackTrace();
			}
			return players;
		}
		
	/*public void testFileIO(String fileName) throws IOException {
			
			InputStream is = getClass().getResourceAsStream(fileName);
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String line="";
			try {
				while ((line = br.readLine()) != null){
					System.out.println(line);
				}
			} catch (IOException exception) {
				// TODO Auto-generated catch block
				exception.printStackTrace();
			}is.close();
			isr.close();
			br.close();
			
		}
*/	
}