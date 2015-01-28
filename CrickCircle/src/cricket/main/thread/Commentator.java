package cricket.main.thread;

import java.util.Random;

import cricket.main.ui.CrickCircle;

public class Commentator implements Runnable {

	String str[]=new String[8];
	
	public Commentator() {
	
		str[0]="Wow!";
		str[1]="Shit";
		str[2]="Yes";
		str[3]="Good Shoot";
		str[4]="Off!!";
		str[5]="Oh No";
		str[6]="OMG";		
		str[7]="My Goodness";		
				
				// TODO Auto-generated constructor stub
	}

	@Override
	public synchronized void run() {
		
		while(System.currentTimeMillis()<CrickCircle.match.ball.totalTimeofRotateInSys){
			int index=new Random().nextInt(8);
			
			CrickCircle.commentryTextArea.setText(str[index]);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		long time=System.currentTimeMillis();
		long wait=time+5*100;
		
		while(System.currentTimeMillis()<wait){
			
			
		}
		CrickCircle.commentryTextArea.setText(CrickCircle.sector.getSectorName());
		
		long time1=System.currentTimeMillis();
		long wait2=time1+20*1000;
		int i=0;
		
		CrickCircle.commentry=false;
		String comment="Hi,How are you?\nI am Totaly fine today.\nBecause My project may be come to light";
		
		while(System.currentTimeMillis()<wait2 ){
				
			i=i+new Random().nextInt(15);
			i=i%comment.length();
			String string="";
			for(int j=0;j<i;j++){
				string=string+comment.charAt(j);
			}
			CrickCircle.commentryTextArea.setText(string);
			try {
					Thread.currentThread().sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				i++;
				
				if(CrickCircle.commentry==true){
					Thread.currentThread().stop();
				}
			
		}
	
	}
}