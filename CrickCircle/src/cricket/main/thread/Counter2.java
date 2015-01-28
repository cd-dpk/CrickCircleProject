package cricket.main.thread;

import cricket.entities.Settings;
import cricket.main.ui.Score;

public class Counter2 implements Runnable {
	int i=0;
	int count;
	long sleep;
	String name;
	int index;
	Settings settings;
	public Counter2(int index ,int count,long sleep) {
		// TODO Auto-generated constructor stub
		this.count=count;
		this.sleep=sleep;
		this.index=index;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while( i<count){
			i=i+1;
			Score.scoreLabel[index].setText(i+"");
			try {
				Thread.currentThread().sleep(sleep);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		setUp();
	}
	
	public void setUp(){
		
		Score.scoreLabel[index].setText(count+"");
	}
}