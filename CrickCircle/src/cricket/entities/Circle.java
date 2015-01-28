package cricket.entities;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import cricket.constant.Value;
import cricket.main.ui.CrickCircle;

public class Circle  {
	
	private List<Sector>list=new ArrayList<Sector>();
	private Collections collections;
	double runArea=150;
	double outArea=150;
	Player  player;
	
	public Circle(Player player){
		
		this.player=player;
		sectors(player);
		collections.shuffle(list);
		doGenerate(player);
	}
	
	public Circle(){
		sectors();
		collections.shuffle(list);
		doGenerate();
	}
	
	public void   sectors(Player player){
		Color color;
		System.out.println();
		Sector six=new Sector("Six");
		six.setRange(0);
		six.setSectorId(1);
		six.setNature(Value.Run);
		six.setPoint(6);
		six.setStatValue(player.getSixes());
		six.setImage("Six.png");
		color=new Color(250,100,50);
		six.setColor(color);
		list.add(six);
		

		
		
		Sector four=new Sector("Four");
		four.setRange(0);
		four.setSectorId(2);
		four.setNature(Value.Run);
		four.setPoint(4);
		four.setStatValue(player.getFours());
		four.setImage("Four.png");
		color=new Color(250,50,100);
		four.setColor(color);
		list.add(four);
		
		
		Sector three=new Sector("Three");
		three.setRange(0);
		three.setSectorId(3);
		three.setNature(Value.Run);
		three.setPoint(3);
		three.setStatValue(player.getThrees());
		three.setImage("Three.png");
		color=new Color(50,100,250);
		three.setColor(color);
		list.add(three);
		

		
		
		Sector two=new Sector("Two");
		two.setRange(0);
		two.setSectorId(4);
		two.setNature(Value.Run);
		two.setPoint(2);
		two.setStatValue(player.getTwos());
		two.setImage("Two.png");
		color=new Color(50,250,100);
		two.setColor(color);
		list.add(two);
		
		
		
		Sector one=new Sector("One");
		one.setRange(0);
		one.setSectorId(5);
		one.setNature(Value.Run);
		one.setPoint(1);
		one.setStatValue(player.getOnes());
		one.setImage("One.png");
		color=new Color(100,50,250);
		one.setColor(color);
		list.add(one);
		
		

		Sector rnout=new Sector("RunOut");
		rnout.setRange(0);
		rnout.setSectorId(6);
		rnout.setNature(Value.Out);
		rnout.setPoint(1);
		rnout.setStatValue(player.getROUT());
		rnout.setImage("RunOut.png");
		color=new Color(100,250,50);
		rnout.setColor(color);		
		list.add(rnout);
				
		
		
		Sector stmp=new Sector("Stamping");
		stmp.setRange(0);
		stmp.setPoint(1);
		stmp.setSectorId(7);
		stmp.setNature(Value.Out);
		stmp.setStatValue(player.getSt());
		stmp.setImage("Stmp.png");
		color=new Color(50,150,200);
		stmp.setColor(color);
		list.add(stmp);
		
		
		
		Sector lbw=new Sector("LBW");
		lbw.setRange(0);
		lbw.setSectorId(8);
		lbw.setNature(Value.Out);
		lbw.setPoint(1);
		lbw.setStatValue(player.getLBW());
		lbw.setImage("LBW.png");
		color=new Color(150,100,100);
		lbw.setColor(color);
		list.add(lbw);

		
		
		Sector cath  =new Sector("Catch");
		cath.setRange(0);
		cath.setSectorId(9);
		cath.setNature(Value.Out);
		cath.setPoint(1);
		cath.setStatValue(player.getCatch());
		cath.setImage("Catch.png");
		color=new Color(150,50,250);
		cath.setColor(color);
		list.add(cath);
		
		
		
		Sector bold  =new Sector("Bold");
		bold.setRange(0);
		bold.setSectorId(10);
		bold.setNature(Value.Out);
		bold.setPoint(1);
		bold.setStatValue(player.getBold());
		bold.setImage("Bold.png");
		color=new Color(100,50,200);
		bold.setColor(color);
		list.add(bold);
		
		
		
		Sector wd=new Sector("Wide");
		wd.setRange(0);
		wd.setSectorId(11);
		wd.setNature(Value.Extra);
		wd.setPoint(1);
		wd.setStatValue(0.0);
		wd.setImage("wide.png");
		color=new Color(150,150,200);
		wd.setColor(color);
		list.add(wd);
		
		
		
		Sector nbl=new Sector("No Ball");
		nbl.setNature(Value.Extra);
		nbl.setPoint(1);
		nbl.setSectorId(12);
		nbl.setStatValue(0.0);
		nbl.setImage("NB.png");
		color=new Color(200,50,200);
		nbl.setColor(color);
		list.add(nbl);		
		

		for(int i=0;i<list.size();i++){
			list.get(i).setStatValue((list.get(i).getStatValue()/(player.getBF()-player.getZeroes()))*100.0);
		}
		
	}
	
	public void  doGenerate(Player player){
		
		double delArea;
		double performance=0.0;
		double percentage=0.0;
		double runPer=0.0,outPer=0.0;
		
		performance=(player.getAverage()-(25+3*(CrickCircle.match.getSettings().getLevel().ordinal())));
		delArea=performance*2.0;
		runArea=runArea+delArea;
		
		if(runArea>200){
			runArea=200;
		}
		if(runArea<100){
			runArea=100;
		}
		outArea=outArea-delArea;
		
		if(outArea>200){
			outArea=200;
		}
		if(outArea<100){
			outArea=100;
		}
		
		System.out.println("RunArea :"+runArea);
		System.out.println("OutArea :"+outArea);
			
		List<Sector>Out=new ArrayList<Sector>();
		List<Sector>Run=new ArrayList<Sector>();
		List<Sector>Extra=new ArrayList<Sector>();
		
		
		for(int i=0;i<list.size();i++){
			if(list.get(i).getNature()==Value.Run){
				Run.add(list.get(i));
				runPer=runPer+list.get(i).getStatValue();
			}
			else if(list.get(i).getNature()==Value.Out){
				outPer=outPer+list.get(i).getStatValue();
				Out.add(list.get(i));
			}
			else if(list.get(i).getNature()==Value.Extra){
				Extra.add(list.get(i));
			}
			
		}
		/*
		 * Special algorithm used to distribute range
		 */
		
		//TODO manipulating runArea
		
		for(int i=0;i<Run.size();i++){
			percentage=(Run.get(i).getStatValue()/runPer);
			Run.get(i).setRange(percentage*runArea);
		}
		
		boolean[] status=new boolean[Run.size()];
		for(int i=0;i<Run.size();i++){
			status[i]=false;
		}
		
		double extra=0,total=runArea,anotherTotal=0.0;
		while(total!=0){
			anotherTotal=0.0;
			extra=0.0;
			for(int i=0;i<Run.size();i++){
				if(status[i]==false){
					if(Run.get(i).getRange()>40.0){
						extra=extra+Run.get(i).getRange()-40.0;
						Run.get(i).setRange(40.0);
						status[i]=true;
					}
					else if(Run.get(i).getRange()<20.0){
						extra=extra-(20.0-Run.get(i).getRange());
						Run.get(i).setRange(20);
						status[i]=true;
					}
					else{
						anotherTotal=anotherTotal+Run.get(i).getRange();
					}
				}	
			}
			for(int i=0;i<5;i++){
				if(status[i]==false){
					Run.get(i).setRange(Run.get(i).getRange()+(Run.get(i).getRange()/anotherTotal)*(extra));
				}	
			}
			total=extra;
		}
		
		
		//TODO manipulating runArea ends
		
	//TODO outArea starts	
		for(int i=0;i<Out.size();i++){
			status[i]=false;
		}
		for(int i=0;i<Out.size();i++){
			percentage=(Out.get(i).getStatValue()/outPer);
			Out.get(i).setRange(percentage*outArea);
		}
		
		
		extra=0;
		total=outArea;
		anotherTotal=0.0;
		while(total!=0){
			anotherTotal=0.0;
			extra=0.0;
			for(int i=0;i<Out.size();i++){
				if(status[i]==false){
					if(Out.get(i).getRange()>40.0){
						extra=extra+Out.get(i).getRange()-40.0;
						Out.get(i).setRange(40.0);
						status[i]=true;
					}
					else if(Out.get(i).getRange()<20.0){
						extra=extra-(20.0-Out.get(i).getRange());
						Out.get(i).setRange(20);
						status[i]=true;
					}
					else{
						anotherTotal=anotherTotal+Out.get(i).getRange();
					}
				}	
			}
			for(int i=0;i<Out.size();i++){
				if(status[i]==false){
					Out.get(i).setRange(Out.get(i).getRange()+(Out.get(i).getRange()/anotherTotal)*(extra));
				}	
			}
			total=extra;
		}
	//TODO outArea finishes

		
	//TODO merging
		int x=0,y=0,z=0;
		for(int i=0;i<list.size();i++){
			if(list.get(i).getNature()==Value.Run){
				list.set(i, Run.get(x));
				x++;
			}
			else if(list.get(i).getNature()==Value.Out){
				list.set(i, Out.get(y));
				y++;
			}
			else if(list.get(i).getNature()==Value.Extra){
				list.set(i, Extra.get(z));
				z++;
			}
		}
		double totalArea=0.0;
		for(int i=0;i<list.size();i++){
			if(list.get(i).getNature()!=Value.Extra){
				totalArea=totalArea+list.get(i).getRange();
			}
		}
		double helper=300-totalArea;
		
		for(int i=0;i<list.size();i++){
			if(list.get(i).getNature()==Value.Extra){
				list.get(i).setRange(30+(helper/2.0));
			}
		}
		list.get(0).setStart(0.0);
		list.get(0).setEnd(list.get(0).getRange());
		
		for(int i=1;i<list.size();i++){
			list.get(i).setStart(list.get(i-1).getEnd());
			list.get(i).setEnd(list.get(i).getStart()+list.get(i).getRange());
		}
		
		int random=new Random().nextInt(360);
		for(int i=0;i<list.size();i++){
			list.get(i).setStart((list.get(i).getStart()+random));
			list.get(i).setEnd((list.get(i).getEnd()+random));
			
		}
		for(int i=0;i<list.size();i++){
			
			double mid=list.get(i).getStart()+(list.get(i).getRange()/2.0);
			list.get(i).setX((int) Math.ceil(250 * Math.cos(Math.toRadians(mid))));
			list.get(i).setY((int) Math.ceil(250 * Math.sin(Math.toRadians(mid))));
			list.get(i).setR(30);	
		}
		
	}	
	
	
	public List<Sector> getCircle(){
/*		for(int i=0;i<list.size();i++){
			System.out.println("Name	:"+list.get(i).getSectorName()+"	Start	:"+list.get(i).getStart()%360+"	End	:"+list.get(i).getEnd()%360+"	StatValue: "+list.get(i).getStatValue()+"	Range	:"+list.get(i).getRange());	
		}
*/		return list;
	}
	

	public void   sectors(){
		Color color;
		
		color=new Color(250,100,50);
		
		System.out.println();
		Sector six=new Sector("Six");
		six.setRange(0);
		six.setSectorId(1);
		six.setNature(Value.Run);
		six.setPoint(6);
		six.setStatValue(0);
		six.setRange(30);
		six.setColor(color);
		six.setImage("Six.png");
		list.add(six);
		
				
		color=new Color(250,50,100);
		Sector four=new Sector("Four");
		four.setRange(0);
		four.setSectorId(2);
		four.setNature(Value.Run);
		four.setPoint(4);
		four.setStatValue(0);
		four.setRange(30);
		four.setColor(color);
		four.setImage("Four.png");	
		list.add(four);

		
		
		color=new Color(50,100,250);
		Sector three=new Sector("Three");
		three.setRange(0);
		three.setSectorId(3);
		three.setNature(Value.Run);
		three.setPoint(3);
		three.setStatValue(0);
		three.setRange(30);
		three.setColor(color);
		three.setImage("Three.png");
		list.add(three);
		


		
		color=new Color(50,250,100);
		Sector two=new Sector("Two");
		two.setRange(0);
		two.setSectorId(4);
		two.setNature(Value.Run);
		two.setPoint(2);
		two.setStatValue(0);
		two.setRange(30);
		two.setColor(color);
		two.setImage("Two.png");
		list.add(two);
		
		
		Sector one=new Sector("One");
		one.setRange(0);
		one.setSectorId(5);
		one.setNature(Value.Run);
		one.setPoint(1);
		one.setStatValue(0);
		one.setRange(30);
		color=new Color(100,50,250);
		one.setColor(color);
		one.setImage("One.png");
		list.add(one);
		



		
		Sector rnout=new Sector("RunOut");
		rnout.setRange(0);
		rnout.setSectorId(6);
		rnout.setNature(Value.Out);
		rnout.setPoint(1);
		rnout.setStatValue(0);
		rnout.setRange(30);
		color=new Color(100,250,50);
		rnout.setColor(color);
		rnout.setImage("RunOut.png");
		list.add(rnout);
		
		Sector stmp=new Sector("Stamping");
		stmp.setRange(0);
		stmp.setPoint(1);
		stmp.setSectorId(7);
		stmp.setNature(Value.Out);
		stmp.setStatValue(0);
		stmp.setRange(30);
		color=new Color(50,150,200);
		stmp.setColor(color);
		
		stmp.setImage("Stmp.png");
		list.add(stmp);
		
		Sector lbw=new Sector("LBW");
		lbw.setRange(0);
		lbw.setSectorId(8);
		lbw.setNature(Value.Out);
		lbw.setPoint(1);
		lbw.setStatValue(0);
		lbw.setRange(30);
		
		
		lbw.setImage("LBW.png");
		list.add(lbw);
		
				
		
		Sector cath  =new Sector("Catch");
		cath.setRange(0);
		cath.setSectorId(9);
		cath.setNature(Value.Out);
		cath.setPoint(1);
		cath.setStatValue(0);
		cath.setRange(30);
		
		color=new Color(150,50,250);
		cath.setColor(color);
		
		cath.setImage("Catch.png");
		list.add(cath);
		
		
		Sector bold  =new Sector("Bold");
		bold.setRange(0);
		bold.setSectorId(10);
		bold.setNature(Value.Out);
		bold.setPoint(1);
		bold.setStatValue(0);
		bold.setRange(30);
		
		color=new Color(100,50,200);
		bold.setColor(color);
		
		bold.setImage("Bold.png");
		list.add(bold);
		
		
		
		Sector wd=new Sector("Wide");
		wd.setRange(0);
		wd.setSectorId(11);
		wd.setNature(Value.Extra);
		wd.setPoint(1);
		wd.setStatValue(0.0);
		wd.setRange(30);
		
		color=new Color(150,150,200);
		wd.setColor(color);
		
		wd.setImage("wide.png");
		list.add(wd);
		
		
		
		Sector nbl=new Sector("No Ball");
		nbl.setNature(Value.Extra);
		nbl.setPoint(1);
		nbl.setSectorId(12);
		nbl.setStatValue(0.0);
		nbl.setRange(30);

		color=new Color(200,50,200);
		nbl.setColor(color);
		
		nbl.setImage("NB.png");
		list.add(nbl);		

		
	}
	
	public void  doGenerate(){
		
		list.get(0).setStart(0.0);
		list.get(0).setEnd(list.get(0).getRange());
		
		for(int i=1;i<list.size();i++){
			list.get(i).setStart(list.get(i-1).getEnd());
			list.get(i).setEnd(list.get(i).getStart()+list.get(i).getRange());
		}
		
		int random=new Random().nextInt(360);
		for(int i=0;i<list.size();i++){
			list.get(i).setStart((list.get(i).getStart()+random));
			list.get(i).setEnd((list.get(i).getEnd()+random));
			
		}
		for(int i=0;i<list.size();i++){
			double mid=list.get(i).getStart()+(list.get(i).getRange()/2.0);
			list.get(i).setX((int) Math.ceil(200 * Math.cos(Math.toRadians(mid))));
			list.get(i).setY((int) Math.ceil(200 * Math.sin(Math.toRadians(mid))));
			list.get(i).setR(Math.abs((int) Math.ceil(200 * Math.sin(Math.toRadians((list.get(i).getEnd()-3-list.get(i).getStart()-3)/2.0)))));	
			System.out.println("Radius"+list.get(i).getR());
		}
	}	
}