package cricket.assist;

import java.util.List;

import cricket.entities.HighScore;

public class Assistant {

	public String makeDoubleToStringRound(double doubleNumber){

		String string="";
		int intNumber=(int) (doubleNumber);
		doubleNumber=doubleNumber-intNumber;
		String str=Double.toString(doubleNumber);
		String cutter="";
		boolean cutFlag=false;
		int precision=2;
		int j=0;
		for(int i=0;i<str.length();i++){
			if(cutFlag==true && j<precision){
				cutter=cutter+str.charAt(i);
				j++;
			}
			if(str.charAt(i)=='.'){
				cutter=cutter+".";
				cutFlag=true;
			}
		}
		string=intNumber+cutter;	
		return string;
	}
	public String makeDoubleToStringRound(double doubleNumber,int precision){

		String string="";
		int intNumber=(int) (doubleNumber);
		doubleNumber=doubleNumber-intNumber;
		String str=Double.toString(doubleNumber);
		String cutter="";
		boolean cutFlag=false;
		int j=0;
		for(int i=0;i<str.length();i++){
			if(cutFlag==true && j<precision){
				cutter=cutter+str.charAt(i);
				j++;
			}
			if(str.charAt(i)=='.'){
				cutter=cutter+".";
				cutFlag=true;
			}
		}
		string=intNumber+cutter;	
		return string;
	}
	
	public double getOverFromInt(int ball) {
		double over=0.0;
		int a=ball/6;
		int b=ball%6;
		over=(double)a+((double)b/10.0) ;
		return over;
	}

	public double getRunRate(int run,int ball){
		double runRate=0;
		runRate=6.0*((double)run/(double)ball);
		runRate=Double.parseDouble(makeDoubleToStringRound(runRate));
		return runRate;
	}
	
	public void pushList(List<Integer>list){
		Integer intg=list.get(0);
		for (int i = 0; i < list.size()-1; i++) {
			list.set(i, list.get(i+1));
		}
		list.set(list.size()-1,	intg);
	}

	public String getNationName(String nationName){
		String name="";
		for (int i = 0; i < nationName.length(); i++) {
			char ch=nationName.charAt(i);
			if (ch=='?') {
				ch=' ';
			}
			name=name+ch;
		}
		return name;
	}
	public static void main(String args[]) {
		System.out.println(3.0/10.0);
		System.out.println(new Assistant().getOverFromInt(9));
		System.out.println(new Assistant().makeDoubleToStringRound(12.01));
		System.out.println(new Assistant().getRunRate(17,13));
		System.out.println(new Assistant().getNationName("South?Africa"));
	}

}
