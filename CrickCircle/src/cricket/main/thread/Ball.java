package cricket.main.thread;

import javax.swing.JOptionPane;
import cricket.assist.Assistant;
import cricket.constant.GameMode;
import cricket.constant.Result;
import cricket.constant.Status;
import cricket.constant.Value;
import cricket.entities.Sector;
import cricket.main.ui.CrickCircle;
import cricket.main.ui.Score;

public class Ball implements Runnable {
	
	CrickCircle frame;
	public Ball(CrickCircle frame) {
		this.frame=frame;
	}
	@Override
	public synchronized void run() {

		CrickCircle.commentry=true;
		while (System.currentTimeMillis() < CrickCircle.match.ball.totalTimeofRotateInSys) {	
		
			if(System.currentTimeMillis()<CrickCircle.match.ball.selectionTimeInSys){
				CrickCircle.progressBar.setValue((int) System.currentTimeMillis());
			}
			else {
				CrickCircle.progressBar1.setValue((int) System.currentTimeMillis());
			}
			CrickCircle.match.ball.instantVelocity=CrickCircle.match.ball.acceleration*Math.sqrt((CrickCircle.match.ball.totalTimeofRotate-CrickCircle.match.ball.instantTime));
			CrickCircle.match.ball.newArgc=CrickCircle.match.ball.intitialVelocity*CrickCircle.match.ball.instantTime-0.5*CrickCircle.match.ball.acceleration*CrickCircle.match.ball.instantTime*CrickCircle.match.ball.instantTime;
			
			for(int i=0;i<CrickCircle.list.size();i++){
				CrickCircle.list.get(i).setStart((CrickCircle.list.get(i).getStart()+CrickCircle.match.ball.newArgc-CrickCircle.match.ball.prevArgc));
				CrickCircle.list.get(i).setEnd((CrickCircle.list.get(i).getEnd()+CrickCircle.match.ball.newArgc-CrickCircle.match.ball.prevArgc));
				
			}
			CrickCircle.match.ball.prevArgc=CrickCircle.match.ball.newArgc;
			for(int i=0;i<CrickCircle.list.size();i++){	
				double mid=CrickCircle.list.get(i).getStart()+CrickCircle.list.get(i).getRange()/2.0;
				CrickCircle.list.get(i).setX((int) Math.ceil(200 * Math.cos(Math.toRadians(mid))));
				CrickCircle.list.get(i).setY((int) Math.ceil(200 * Math.sin(Math.toRadians(mid))));
				CrickCircle.list.get(i).setR(Math.abs((int) Math.ceil(200 * Math.sin(Math.toRadians((CrickCircle.list.get(i).getEnd()-5-CrickCircle.list.get(i).getStart()-5)/2.0)))));		
			}
			try {

				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			CrickCircle.gameField.removeAll();
			CrickCircle.gameField.repaint();
			
			CrickCircle.match.ball.instantTime = CrickCircle.match.ball.instantTime+ 0.1;
			
		}
		
		CrickCircle.match.ball.tangentValue = 0;
		CrickCircle.sector=new Sector("Zero");
		CrickCircle.sector.setRange(0);
		CrickCircle.sector.setSectorId(0);
		CrickCircle.sector.setNature(Value.Run);
		CrickCircle.sector.setPoint(0);
		CrickCircle.sector.setStatValue(0.0);
		
		if(CrickCircle.match.ball.actualX==0 && CrickCircle.match.ball.actualY==0){
			CrickCircle.match.ball.tangentValue=0;
			
		}
		else if ((CrickCircle.match.ball.actualX) == 0 && (CrickCircle.match.ball.actualY)!=0) {
			if((CrickCircle.match.ball.actualY)>0){
				CrickCircle.match.ball.tangentValue=90;
			}
			else if((CrickCircle.match.ball.actualY)<0){
				CrickCircle.match.ball.tangentValue=270;
			}
		} 
		else {
			CrickCircle.match.ball.tangentValue = Math.toDegrees(Math.atan2( CrickCircle.match.ball.actualY,
					CrickCircle.match.ball.actualX ));
			 if(CrickCircle.match.ball.tangentValue<0){
				 CrickCircle.match.ball.tangentValue=360+CrickCircle.match.ball.tangentValue;
			 }
					 
		}
		
		if(CrickCircle.notSelectedFlag==false){
		
		 for(int i=0;i<CrickCircle.list.size();i++){
			 double start1=CrickCircle.list.get(i).getStart()%360;
			 double end=CrickCircle.list.get(i).getEnd()%360;
			 
			 if(end<start1){
				 if( CrickCircle.match.ball.tangentValue>start1 ||  CrickCircle.match.ball.tangentValue<end){
					 System.out.println(start1+":"+end);
					 if(CrickCircle.list.get(i).getNature()==Value.Run){
						 CrickCircle.sector=CrickCircle.list.get(i);
						 break;
					 }
					 else if(CrickCircle.list.get(i).getNature()==Value.Out){
						 CrickCircle.sector=CrickCircle.list.get(i);
						 break;
					 }
					 else if(CrickCircle.list.get(i).getNature()==Value.Extra){
						 CrickCircle.sector=CrickCircle.list.get(i);
						 break;
					 }
				 }
				 
			 }
			 else{
				 if( CrickCircle.match.ball.tangentValue>start1 &&  CrickCircle.match.ball.tangentValue<end){
					System.out.println(start1+":"+end);
					 if(CrickCircle.list.get(i).getNature()==Value.Run){
						 CrickCircle.sector=CrickCircle.list.get(i);
						 break;
					 }
					 else if(CrickCircle.list.get(i).getNature()==Value.Out){
						 CrickCircle.sector=CrickCircle.list.get(i);
						 break;
					 }
					 else if(CrickCircle.list.get(i).getNature()==Value.Extra){
						 CrickCircle.sector=CrickCircle.list.get(i);
						 break;
					 	}
				 	}
			 	}
		 	}	
		}
		if(CrickCircle.sector.getSectorId()==0){
			
			 CrickCircle.match.userInnings.getBatsman().get(CrickCircle.match.userInnings.getStrikeIndex()).setNoOfZero(CrickCircle.match.userInnings.getBatsman().get(CrickCircle.match.userInnings.getStrikeIndex()).getNoOfZero()+1);
			 CrickCircle.match.userInnings.getBatsman().get(CrickCircle.match.userInnings.getStrikeIndex()).setBall(CrickCircle.match.userInnings.getBatsman().get(CrickCircle.match.userInnings.getStrikeIndex()).getBall()+1); 
			 CrickCircle.match.userInnings.setNoOfZeros(CrickCircle.match.userInnings.getNoOfZeros()+1);
			 CrickCircle.match.userInnings.setRuns(CrickCircle.match.userInnings.getRuns()+CrickCircle.sector.getPoint());
			 CrickCircle.match.userInnings.setBalls(CrickCircle.match.userInnings.getBalls()+1);
			
			 CrickCircle.match.userInnings.getTimeLineStrList().add("0");
			 System.out.println("0");
			 if((CrickCircle.match.userInnings.getBalls()%6)==0){
				int temp=CrickCircle.match.userInnings.getStrikeIndex();
				CrickCircle.match.userInnings.setStrikeIndex(CrickCircle.match.userInnings.getNonStrikeIndex());
				CrickCircle.match.userInnings.setNonStrikeIndex(temp);
				CrickCircle.match.userInnings.getTimeLineStrList().add("|");					
			 }
		}
		 else if(CrickCircle.sector.getSectorId()==1){
			
			 CrickCircle.match.userInnings.getBatsman().get(CrickCircle.match.userInnings.getStrikeIndex()).setNoOfSix(CrickCircle.match.userInnings.getBatsman().get(CrickCircle.match.userInnings.getStrikeIndex()).getNoOfSix()+1);
			 CrickCircle.match.userInnings.getBatsman().get(CrickCircle.match.userInnings.getStrikeIndex()).setBall(CrickCircle.match.userInnings.getBatsman().get(CrickCircle.match.userInnings.getStrikeIndex()).getBall()+1); 
			 CrickCircle.match.userInnings.getBatsman().get(CrickCircle.match.userInnings.getStrikeIndex()).setRun(CrickCircle.match.userInnings.getBatsman().get(CrickCircle.match.userInnings.getStrikeIndex()).getRun()+CrickCircle.sector.getPoint()); 
			
			 CrickCircle.match.userInnings.setNoOfSix(CrickCircle.match.userInnings.getNoOfSix()+1);
			 CrickCircle.match.userInnings.setRuns(CrickCircle.match.userInnings.getRuns()+CrickCircle.sector.getPoint());
			 CrickCircle.match.userInnings.setBalls(CrickCircle.match.userInnings.getBalls()+1);
		 
			System.out.println("1");
			 
			CrickCircle.match.userInnings.getTimeLineStrList().add("6");

			 if((CrickCircle.match.userInnings.getBalls()%6)==0){
					int temp=CrickCircle.match.userInnings.getStrikeIndex();
					CrickCircle.match.userInnings.setStrikeIndex(CrickCircle.match.userInnings.getNonStrikeIndex());
					CrickCircle.match.userInnings.setNonStrikeIndex(temp);
					CrickCircle.match.userInnings.getTimeLineStrList().set(CrickCircle.match.userInnings.getTimeLineStrList().size()-1, "6|");					
			 }
			
		 }
		 else if(CrickCircle.sector.getSectorId()==2){
			 CrickCircle.match.userInnings.getBatsman().get(CrickCircle.match.userInnings.getStrikeIndex()).setNoOfFour(CrickCircle.match.userInnings.getBatsman().get(CrickCircle.match.userInnings.getStrikeIndex()).getNoOfFour()+1);
			 CrickCircle.match.userInnings.getBatsman().get(CrickCircle.match.userInnings.getStrikeIndex()).setBall(CrickCircle.match.userInnings.getBatsman().get(CrickCircle.match.userInnings.getStrikeIndex()).getBall()+1); 
			 CrickCircle.match.userInnings.getBatsman().get(CrickCircle.match.userInnings.getStrikeIndex()).setRun(CrickCircle.match.userInnings.getBatsman().get(CrickCircle.match.userInnings.getStrikeIndex()).getRun()+CrickCircle.sector.getPoint()); 
				
			 CrickCircle.match.userInnings.setNoOfFour(CrickCircle.match.userInnings.getNoOfFour()+1);
			 CrickCircle.match.userInnings.setRuns(CrickCircle.match.userInnings.getRuns()+CrickCircle.sector.getPoint());
			 CrickCircle.match.userInnings.setBalls(CrickCircle.match.userInnings.getBalls()+1);
			 
			 CrickCircle.match.userInnings.getTimeLineStrList().add("4");
			 System.out.println("2");
			 

			 if((CrickCircle.match.userInnings.getBalls()%6)==0){
					int temp=CrickCircle.match.userInnings.getStrikeIndex();
					CrickCircle.match.userInnings.setStrikeIndex(CrickCircle.match.userInnings.getNonStrikeIndex());
					CrickCircle.match.userInnings.setNonStrikeIndex(temp);
					CrickCircle.match.userInnings.getTimeLineStrList().set(CrickCircle.match.userInnings.getTimeLineStrList().size()-1, "4|");				
			 }
			 
		 }
		 else if(CrickCircle.sector.getSectorId()==3){
			 CrickCircle.match.userInnings.getBatsman().get(CrickCircle.match.userInnings.getStrikeIndex()).setNoOfThree(CrickCircle.match.userInnings.getBatsman().get(CrickCircle.match.userInnings.getStrikeIndex()).getNoOfThree()+1);
			 CrickCircle.match.userInnings.getBatsman().get(CrickCircle.match.userInnings.getStrikeIndex()).setBall(CrickCircle.match.userInnings.getBatsman().get(CrickCircle.match.userInnings.getStrikeIndex()).getBall()+1); 
			 CrickCircle.match.userInnings.getBatsman().get(CrickCircle.match.userInnings.getStrikeIndex()).setRun(CrickCircle.match.userInnings.getBatsman().get(CrickCircle.match.userInnings.getStrikeIndex()).getRun()+CrickCircle.sector.getPoint()); 
			 CrickCircle.match.userInnings.setNoOfThree(CrickCircle.match.userInnings.getNoOfThree()+1);
			 CrickCircle.match.userInnings.setRuns(CrickCircle.match.userInnings.getRuns()+CrickCircle.sector.getPoint());
			 CrickCircle.match.userInnings.setBalls(CrickCircle.match.userInnings.getBalls()+1);
			 int temp=CrickCircle.match.userInnings.getStrikeIndex();
			 CrickCircle.match.userInnings.setStrikeIndex(CrickCircle.match.userInnings.getNonStrikeIndex());
			 CrickCircle.match.userInnings.setStrikeIndex(temp);
			 CrickCircle.match.userInnings.getTimeLineStrList().add("3");
			 System.out.println("3");
			 
			 if((CrickCircle.match.userInnings.getBalls()%6)==0){
					temp=CrickCircle.match.userInnings.getStrikeIndex();
					CrickCircle.match.userInnings.setStrikeIndex(CrickCircle.match.userInnings.getNonStrikeIndex());
					CrickCircle.match.userInnings.setNonStrikeIndex(temp);
					CrickCircle.match.userInnings.getTimeLineStrList().set(CrickCircle.match.userInnings.getTimeLineStrList().size()-1, "3|");					
			 }
			 
		 }
		 else if(CrickCircle.sector.getSectorId()==4){
			 CrickCircle.match.userInnings.getBatsman().get(CrickCircle.match.userInnings.getStrikeIndex()).setNoOfTwo(CrickCircle.match.userInnings.getBatsman().get(CrickCircle.match.userInnings.getStrikeIndex()).getNoOfTwo()+1);
			 CrickCircle.match.userInnings.getBatsman().get(CrickCircle.match.userInnings.getStrikeIndex()).setBall(CrickCircle.match.userInnings.getBatsman().get(CrickCircle.match.userInnings.getStrikeIndex()).getBall()+1); 
			 CrickCircle.match.userInnings.getBatsman().get(CrickCircle.match.userInnings.getStrikeIndex()).setRun(CrickCircle.match.userInnings.getBatsman().get(CrickCircle.match.userInnings.getStrikeIndex()).getRun()+CrickCircle.sector.getPoint()); 
			
			 
			 CrickCircle.match.userInnings.setNoOfTwo(CrickCircle.match.userInnings.getNoOfTwo()+1);
			 CrickCircle.match.userInnings.setRuns(CrickCircle.match.userInnings.getRuns()+CrickCircle.sector.getPoint());
			 CrickCircle.match.userInnings.setBalls(CrickCircle.match.userInnings.getBalls()+1);
		
			 CrickCircle.match.userInnings.getTimeLineStrList().add("2");
			 if((CrickCircle.match.userInnings.getBalls()%6)==0){
					int temp=CrickCircle.match.userInnings.getStrikeIndex();
					CrickCircle.match.userInnings.setStrikeIndex(CrickCircle.match.userInnings.getNonStrikeIndex());
					CrickCircle.match.userInnings.setNonStrikeIndex(temp);
					CrickCircle.match.userInnings.getTimeLineStrList().set(CrickCircle.match.userInnings.getTimeLineStrList().size()-1, "2|");					
			 }
		}
		 else if(CrickCircle.sector.getSectorId()==5){
			 CrickCircle.match.userInnings.getBatsman().get(CrickCircle.match.userInnings.getStrikeIndex()).setNoOfOne(CrickCircle.match.userInnings.getBatsman().get(CrickCircle.match.userInnings.getStrikeIndex()).getNoOfOne()+1);
			 CrickCircle.match.userInnings.getBatsman().get(CrickCircle.match.userInnings.getStrikeIndex()).setBall(CrickCircle.match.userInnings.getBatsman().get(CrickCircle.match.userInnings.getStrikeIndex()).getBall()+1); 
			 CrickCircle.match.userInnings.getBatsman().get(CrickCircle.match.userInnings.getStrikeIndex()).setRun(CrickCircle.match.userInnings.getBatsman().get(CrickCircle.match.userInnings.getStrikeIndex()).getRun()+CrickCircle.sector.getPoint()); 
			 CrickCircle.match.userInnings.setNoOfOne(CrickCircle.match.userInnings.getNoOfOne()+1);
			 CrickCircle.match.userInnings.setRuns(CrickCircle.match.userInnings.getRuns()+CrickCircle.sector.getPoint());
			 CrickCircle.match.userInnings.setBalls(CrickCircle.match.userInnings.getBalls()+1);
			 int temp=CrickCircle.match.userInnings.getStrikeIndex();
			 CrickCircle.match.userInnings.setStrikeIndex(CrickCircle.match.userInnings.getNonStrikeIndex());
			 CrickCircle.match.userInnings.setNonStrikeIndex(temp);
			 System.out.println("5");
			 CrickCircle.match.userInnings.getTimeLineStrList().add("1");
			 if((CrickCircle.match.userInnings.getBalls()%6)==0){
					temp=CrickCircle.match.userInnings.getStrikeIndex();
					CrickCircle.match.userInnings.setStrikeIndex(CrickCircle.match.userInnings.getNonStrikeIndex());
					CrickCircle.match.userInnings.setNonStrikeIndex(temp);
					CrickCircle.match.userInnings.getTimeLineStrList().set(CrickCircle.match.userInnings.getTimeLineStrList().size()-1, "1|");				
			 }
		 }
		 else if(CrickCircle.sector.getSectorId()==6){
			 CrickCircle.match.userInnings.getBatsman().get(CrickCircle.match.userInnings.getStrikeIndex()).setBall(CrickCircle.match.userInnings.getBatsman().get(CrickCircle.match.userInnings.getStrikeIndex()).getBall()+1); 		 
			 CrickCircle.match.userInnings.setNoOfROUT(CrickCircle.match.userInnings.getNoOfROUT()+1);
			 CrickCircle.match.userInnings.setBalls(CrickCircle.match.userInnings.getBalls()+1);
			 CrickCircle.match.userInnings.setWickets(CrickCircle.match.userInnings.getWickets()+1);
			 if(CrickCircle.match.userInnings.getNextBatsManIndex()<=10){
				 CrickCircle.match.userInnings.getBatsman().get(CrickCircle.match.userInnings.getStrikeIndex()).setStatus(Status.OUT);
				 CrickCircle.match.userInnings.setStrikeIndex(CrickCircle.match.userInnings.getNextBatsManIndex());
				 
				 CrickCircle.match.userInnings.getBatsman().get(CrickCircle.match.userInnings.getStrikeIndex()).setStatus(Status.NOT_OUT);				 
				 CrickCircle.match.userInnings.setNextBatsManIndex(CrickCircle.match.userInnings.getNextBatsManIndex()+1);
			 }
			 CrickCircle.match.userInnings.getTimeLineStrList().add("W");
			 if((CrickCircle.match.userInnings.getBalls()%6)==0){
					int temp=CrickCircle.match.userInnings.getStrikeIndex();
					CrickCircle.match.userInnings.setStrikeIndex(CrickCircle.match.userInnings.getNonStrikeIndex());
					CrickCircle.match.userInnings.setNonStrikeIndex(temp);
					CrickCircle.match.userInnings.getTimeLineStrList().set(CrickCircle.match.userInnings.getTimeLineStrList().size()-1, "W|");					
			 }
		 }
		 else if(CrickCircle.sector.getSectorId()==7){
			 CrickCircle.match.userInnings.getBatsman().get(CrickCircle.match.userInnings.getStrikeIndex()).setBall(CrickCircle.match.userInnings.getBatsman().get(CrickCircle.match.userInnings.getStrikeIndex()).getBall()+1); 
			 CrickCircle.match.userInnings.setNoOfSTM(CrickCircle.match.userInnings.getNoOfSTM()+1);
			 CrickCircle.match.userInnings.setBalls(CrickCircle.match.userInnings.getBalls()+1);
			 CrickCircle.match.userInnings.setWickets(CrickCircle.match.userInnings.getWickets()+1);
			 System.out.println("7");
			 CrickCircle.match.userInnings.getBatsman().get(CrickCircle.match.userInnings.getStrikeIndex()).setStatus(Status.OUT);
			 if(CrickCircle.match.userInnings.getNextBatsManIndex()<=10){
				 CrickCircle.match.userInnings.getBatsman().get(CrickCircle.match.userInnings.getStrikeIndex()).setStatus(Status.OUT);
				 CrickCircle.match.userInnings.setStrikeIndex(CrickCircle.match.userInnings.getNextBatsManIndex());
				 
				 CrickCircle.match.userInnings.getBatsman().get(CrickCircle.match.userInnings.getStrikeIndex()).setStatus(Status.NOT_OUT);				 
				 CrickCircle.match.userInnings.setNextBatsManIndex(CrickCircle.match.userInnings.getNextBatsManIndex()+1);
			 }
			 
			 CrickCircle.match.userInnings.getTimeLineStrList().add("W");
			 
			 if((CrickCircle.match.userInnings.getBalls()%6)==0){
					int temp=CrickCircle.match.userInnings.getStrikeIndex();
					CrickCircle.match.userInnings.setStrikeIndex(CrickCircle.match.userInnings.getNonStrikeIndex());
					CrickCircle.match.userInnings.setNonStrikeIndex(temp);
					CrickCircle.match.userInnings.getTimeLineStrList().set(CrickCircle.match.userInnings.getTimeLineStrList().size()-1, "W|");					
			 }
		 }
		 else if(CrickCircle.sector.getSectorId()==8){
			 CrickCircle.match.userInnings.getBatsman().get(CrickCircle.match.userInnings.getStrikeIndex()).setBall(CrickCircle.match.userInnings.getBatsman().get(CrickCircle.match.userInnings.getStrikeIndex()).getBall()+1); 
			 
			 CrickCircle.match.userInnings.setNoOfLBW(CrickCircle.match.userInnings.getNoOfLBW()+1);
			 CrickCircle.match.userInnings.setBalls(CrickCircle.match.userInnings.getBalls()+1);
			 CrickCircle.match.userInnings.setWickets(CrickCircle.match.userInnings.getWickets()+1);
			 if(CrickCircle.match.userInnings.getNextBatsManIndex()<=10){
				 CrickCircle.match.userInnings.getBatsman().get(CrickCircle.match.userInnings.getStrikeIndex()).setStatus(Status.OUT);
				 CrickCircle.match.userInnings.setStrikeIndex(CrickCircle.match.userInnings.getNextBatsManIndex());
				 
				 CrickCircle.match.userInnings.getBatsman().get(CrickCircle.match.userInnings.getStrikeIndex()).setStatus(Status.NOT_OUT);				 
				 CrickCircle.match.userInnings.setNextBatsManIndex(CrickCircle.match.userInnings.getNextBatsManIndex()+1);
			 }
			 CrickCircle.match.userInnings.getTimeLineStrList().add("W");
			 System.out.println("8");
			 
			 if((CrickCircle.match.userInnings.getBalls()%6)==0){
					int temp=CrickCircle.match.userInnings.getStrikeIndex();
					CrickCircle.match.userInnings.setStrikeIndex(CrickCircle.match.userInnings.getNonStrikeIndex());
					CrickCircle.match.userInnings.setNonStrikeIndex(temp);
					CrickCircle.match.userInnings.getTimeLineStrList().set(CrickCircle.match.userInnings.getTimeLineStrList().size()-1, "W|");					
			 }
			 
		 }
		 else if(CrickCircle.sector.getSectorId()==9){
			 CrickCircle.match.userInnings.getBatsman().get(CrickCircle.match.userInnings.getStrikeIndex()).setBall(CrickCircle.match.userInnings.getBatsman().get(CrickCircle.match.userInnings.getStrikeIndex()).getBall()+1); 
			 
			 
			 CrickCircle.match.userInnings.setNoOfCATCH(CrickCircle.match.userInnings.getNoOfCATCH()+1);
			 CrickCircle.match.userInnings.setBalls(CrickCircle.match.userInnings.getBalls()+1);
			 CrickCircle.match.userInnings.setWickets(CrickCircle.match.userInnings.getWickets()+1);
			 
			 if(CrickCircle.match.userInnings.getNextBatsManIndex()<=10){
				 CrickCircle.match.userInnings.getBatsman().get(CrickCircle.match.userInnings.getStrikeIndex()).setStatus(Status.OUT);
				 CrickCircle.match.userInnings.setStrikeIndex(CrickCircle.match.userInnings.getNextBatsManIndex());
				 
				 CrickCircle.match.userInnings.getBatsman().get(CrickCircle.match.userInnings.getStrikeIndex()).setStatus(Status.NOT_OUT);				 
				 CrickCircle.match.userInnings.setNextBatsManIndex(CrickCircle.match.userInnings.getNextBatsManIndex()+1);
			 } 
			 CrickCircle.match.userInnings.getTimeLineStrList().add("W");
			 System.out.println("9");
			 
			 if((CrickCircle.match.userInnings.getBalls()%6)==0){
					int temp=CrickCircle.match.userInnings.getStrikeIndex();
					CrickCircle.match.userInnings.setStrikeIndex(CrickCircle.match.userInnings.getNonStrikeIndex());
					CrickCircle.match.userInnings.setNonStrikeIndex(temp);
					CrickCircle.match.userInnings.getTimeLineStrList().set(CrickCircle.match.userInnings.getTimeLineStrList().size()-1, "W|");					
			 }
			 
		 }
		 else if( CrickCircle.sector.getSectorId()==10){
			 CrickCircle.match.userInnings.getBatsman().get(CrickCircle.match.userInnings.getStrikeIndex()).setBall(CrickCircle.match.userInnings.getBatsman().get(CrickCircle.match.userInnings.getStrikeIndex()).getBall()+1); 
			 
			 CrickCircle.match.userInnings.setNoOfBOLD(CrickCircle.match.userInnings.getNoOfBOLD()+1);
			 CrickCircle.match.userInnings.setBalls(CrickCircle.match.userInnings.getBalls()+1);
			 CrickCircle.match.userInnings.setWickets(CrickCircle.match.userInnings.getWickets()+1);
			 
			 if(CrickCircle.match.userInnings.getNextBatsManIndex()<=10){
				 CrickCircle.match.userInnings.getBatsman().get(CrickCircle.match.userInnings.getStrikeIndex()).setStatus(Status.OUT);
				 CrickCircle.match.userInnings.setStrikeIndex(CrickCircle.match.userInnings.getNextBatsManIndex());
				 
				 CrickCircle.match.userInnings.getBatsman().get(CrickCircle.match.userInnings.getStrikeIndex()).setStatus(Status.NOT_OUT);				 
				 CrickCircle.match.userInnings.setNextBatsManIndex(CrickCircle.match.userInnings.getNextBatsManIndex()+1);
			 }
			 
			 CrickCircle.match.userInnings.getTimeLineStrList().add("W");
			 System.out.println("10");
			 if((CrickCircle.match.userInnings.getBalls()%6)==0){
					int temp=CrickCircle.match.userInnings.getStrikeIndex();
					CrickCircle.match.userInnings.setStrikeIndex(CrickCircle.match.userInnings.getNonStrikeIndex());
					CrickCircle.match.userInnings.setNonStrikeIndex(temp);
					CrickCircle.match.userInnings.getTimeLineStrList().set(CrickCircle.match.userInnings.getTimeLineStrList().size()-1, "W|");					
			 }
		 }
		 else if(CrickCircle.sector.getSectorId()==11){
			 
			 CrickCircle.match.userInnings.setNoOfWide(CrickCircle.match.userInnings.getNoOfWide()+1);
			 CrickCircle.match.userInnings.setRuns(CrickCircle.match.userInnings.getRuns()+1);
			 CrickCircle.match.userInnings.setNoOfExtra(CrickCircle.match.userInnings.getNoOfExtra()+1);
			 CrickCircle.match.userInnings.getTimeLineStrList().add("Wd");
			 
		 }
		 else if(CrickCircle.sector.getSectorId()==12){
			 CrickCircle.match.userInnings.setNoOfNoBall(CrickCircle.match.userInnings.getNoOfNoBall()+1);
			 CrickCircle.match.userInnings.setRuns(CrickCircle.match.userInnings.getRuns()+1);
			 CrickCircle.match.userInnings.setNoOfExtra(CrickCircle.match.userInnings.getNoOfExtra()+1);
			 CrickCircle.match.userInnings.getTimeLineStrList().add("NB");
		 }
		 CrickCircle.match.totalBall++;
		 CrickCircle.match.userInnings.setOvers((CrickCircle.match.userInnings.getBalls()/6)+(0.1*(CrickCircle.match.userInnings.getBalls()%6)));			 
		 JOptionPane.showMessageDialog(null, CrickCircle.sector.getSectorName()); 
		 setUpUpdate();
		 nextBall();
	}
	public  void nextBall(){
		if(isGameOver()==true){
			CrickCircle.nextBallButton.setVisible(false);
			CrickCircle.match.timeBonus=getTimeBonus();
			CrickCircle.match.runRateBonus=getRunRateBonus();
			CrickCircle.match.prizeMonus=getPrizeMoney();
			CrickCircle.match.totatPoint=getToTalPoint();
			if (CrickCircle.match.getSettings().getGameMode().equals(GameMode.SINGLE_MATCH)) {
				CrickCircle.home.setVisible(true);
			}
			else if (CrickCircle.match.getSettings().getGameMode().equals(GameMode.TOURNAMENT)) {
				CrickCircle.tournamentButton.setVisible(true);
				CrickCircle.match.getTournament().setTimeBonus(CrickCircle.match.getTournament().getTimeBonus()+CrickCircle.match.getTimeBonus());
				CrickCircle.match.getTournament().setRunRateBonus(CrickCircle.match.getTournament().getRunRateBonus()+CrickCircle.match.getRunRateBonus());
				CrickCircle.match.getTournament().setPrizeMonus(CrickCircle.match.getTournament().getPrizeMonus()+CrickCircle.match.getPrizeMonus());
				CrickCircle.match.getTournament().setTotatPoint(CrickCircle.match.getTournament().getTotatPoint()+CrickCircle.match.getTotatPoint());
			}
			Score dialog=new Score(frame, true, CrickCircle.match);
			dialog.setLocationRelativeTo(frame);
			dialog.setLocation(200,100);
			dialog.setSize(900, 600);
			dialog.show();
		}
		else{
			CrickCircle.nextBallButton.setEnabled(true);
		} 
	}
	public void setUpUpdate(){
		new Assistant().pushList(CrickCircle.showOption);
		for (int i = 0; i <3; i++) {
			for (int j = 0; j < 2; j++) {
				for (int k = 0; k < 2; k++) {
					if (i==CrickCircle.showOption.get(0)) {
						CrickCircle.myJLabel[i][j][k].setVisible(true);		
					}
					else {
						CrickCircle.myJLabel[i][j][k].setVisible(false);
					}
				}
			} 
		}
		CrickCircle.decorateGameField();
	} 
	private boolean isGameOver(){
		boolean gameOver=false;
		if(CrickCircle.match.userInnings.getRuns()>=CrickCircle.match.userInnings.getTargetRun()){
			gameOver=true;;
		}
		else if(CrickCircle.match.userInnings.getWickets()==CrickCircle.match.userInnings.getTargetWKT()){
			gameOver=true;
		}
		else if(CrickCircle.match.userInnings.getOvers()==CrickCircle.match.userInnings.getTargetOver()){
			gameOver=true;
		}
		return gameOver;
	}
	private double getTimeBonus(){
		double bonus=0.0;
		double saved=((double)CrickCircle.match.userInnings.getSavedTime()/1000)/(CrickCircle.match.userInnings.getOvers()*6.0*10);
		saved=saved*100;
		bonus=saved*5*(CrickCircle.match.getSettings().getLevel().ordinal()+1)+1000*Math.pow(2.0, CrickCircle.match.getSettings().getLevel().ordinal());
		return bonus;
	}
	private double getRunRateBonus(){
		double bonus=0.0;
		double runRate=(double)(CrickCircle.match.userInnings.getRuns())/CrickCircle.match.userInnings.getOvers();
		bonus=runRate*80.0*Math.pow(2.0,CrickCircle.match.getSettings().getLevel().ordinal());
		if(bonus>(500*(CrickCircle.match.getSettings().getLevel().ordinal()+1))){
			CrickCircle.match.extraBonus=bonus-(500*(CrickCircle.match.getSettings().getLevel().ordinal()+1));
			bonus=(500*(CrickCircle.match.getSettings().getLevel().ordinal()));
		}
		bonus=bonus+1000*Math.pow(2.0, CrickCircle.match.getSettings().getLevel().ordinal());
		return bonus;
	}
	private double getPrizeMoney(){
		double bonus=0.0;
		if(Result.Win==getResult()){
			bonus=500*(Math.pow(2.0, (CrickCircle.match.getSettings().getLevel().ordinal()+1))+(CrickCircle.match.getSettings().getLevel().ordinal()+1));
		}
		else if(Result.Draw==getResult()){
			bonus=500*(Math.pow(2.0, (CrickCircle.match.getSettings().getLevel().ordinal()+1))+(CrickCircle.match.getSettings().getLevel().ordinal()+1));
			bonus=bonus/2;
		}
		else if(Result.Loss==getResult()){
			bonus=0;
		}
		return bonus;
	}
	private double getToTalPoint(){
		return (getTimeBonus()+getRunRateBonus()+getPrizeMoney());
	}
	private Result getResult(){
		if(CrickCircle.match.userInnings.getRuns()>=CrickCircle.match.userInnings.getTargetRun()){
			CrickCircle.match.result=Result.Win;
		}
		else if(CrickCircle.match.userInnings.getRuns()<CrickCircle.match.userInnings.getTargetRun()){
			CrickCircle.match.result=Result.Loss;
		}
		else if(Math.abs(CrickCircle.match.userInnings.getRuns()-CrickCircle.match.userInnings.getTargetRun())==0){
			CrickCircle.match.result=Result.Tri;
		}
		return CrickCircle.match.result;
	}
}