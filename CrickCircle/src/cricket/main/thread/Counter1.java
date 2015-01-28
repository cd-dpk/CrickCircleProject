package cricket.main.thread;

import cricket.constant.Over;
import cricket.entities.Settings;
import cricket.main.ui.MatchFrame;
public class Counter1 implements Runnable {
	int i=0;
	int count;
	long sleep;
	String name;
	int index;
	Settings settings;
	public Counter1(int index ,int count,long sleep,Settings settings) {
		// TODO Auto-generated constructor stub
		this.count=count;
		this.sleep=sleep;
		this.index=index;
		this.settings=settings;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while( i<count){
			i=i+1;
		//	System.out.println("What?");
			if(index==2){
				int q=i/6;
				int r=i%6;
				MatchFrame.oppJLabel[index].setText(q+"."+r);
				
			}
			else{
				MatchFrame.oppJLabel[index].setText(i+"");
			}
			
			try {
				Thread.currentThread().sleep(sleep);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		if(index==0){
			setUp();
		}
	}
	
	public void setUp(){
		
		MatchFrame.ownJLabel[0].setText(count+1+"");
			
		if(settings.getOver()==Over.FIVE){
				MatchFrame.ownJLabel[2].setText("5.0");
				
			}
		else if(settings.getOver()==Over.TEN){
				MatchFrame.ownJLabel[2].setText("10.0");
				
			}
		else if(settings.getOver()==Over.TWENTY){
				MatchFrame.ownJLabel[2].setText("20.0");
			}
			
		MatchFrame.ownJLabel[1].setText("10");
		
	}
}