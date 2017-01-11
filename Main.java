import java.util.*;


public class Main {
	static String[][] mainArray;
	static Scanner keyboard = new Scanner(System.in);
	public static void main (String args[]){
		int columnPointer = 0;
		System.out.println("Please input operator");
		String operator = keyboard.nextLine();
		System.out.println("How many statements?");
		int statements = keyboard.nextInt();
		int rowNum = (int) (1 + Math.pow(2, statements));
		int columnNum = statements+1;
		mainArray = new String[rowNum][columnNum];
		for(int i=0,j=1;i<columnNum-1;i++,j++){
			mainArray[0][i]="Argument"+Integer.toString(j);
		}
		
		mainArray[0][columnNum-1] = "Result with P "+ operator +" Q";
		int truthNum = rowNum / 2;
		for (columnPointer = 0; columnPointer<columnNum;columnPointer++){
			int rowPointer = 1;
			if(truthNum>0){
				if(truthNum>1){
					while(rowPointer<rowNum){
						for(int j=0;j<truthNum;rowPointer++,j++){
							mainArray[rowPointer][columnPointer] = "T";
						}
						for(int k=truthNum;k<truthNum*2;k++){
							mainArray[rowPointer][columnPointer] = "F";
							rowPointer++;
						}
					}
				}
				else if(truthNum==1){
					while(rowPointer<rowNum){
						if(rowPointer%2==0){
							mainArray[rowPointer][columnPointer] = "F";
							rowPointer++;
						}
						else{
							mainArray[rowPointer][columnPointer] = "T";
							rowPointer++;
						}
					}
				}
			}
			
			truthNum/=2;
		}
		if (operator.equalsIgnoreCase("and")){
			columnPointer = 0;
			int rowPointer;
			boolean isTrue = true;
			for (rowPointer=1;rowPointer<rowNum;rowPointer++){
				for(columnPointer=0;columnPointer<columnNum;columnPointer++){
					if(mainArray[rowPointer][columnPointer]=="F"){
						isTrue = false;	
					}
					if(!isTrue){
						mainArray[rowPointer][columnNum-1]="F";
					}
					else{
						mainArray[rowPointer][columnNum-1]="T";
					}
				}
			}
		}
		if (operator.equalsIgnoreCase("or")){
			columnPointer = 0;
			int rowPointer;
			boolean isTrue=false;
			for (rowPointer=1;rowPointer<rowNum;rowPointer++){
				boolean stayInLoop=true;
				do{
					for(columnPointer=0;columnPointer<columnNum-1;columnPointer++){
						if(mainArray[rowPointer][columnPointer]=="T"){
							mainArray[rowPointer][columnNum-1]="T";	
							columnPointer=columnNum;
							stayInLoop=false;
						}
						else if(mainArray[rowPointer][columnPointer]=="F"){
							mainArray[rowPointer][columnNum-1]="F";	
							//stayInLoop=false;
						}
						if(columnPointer==columnNum-2){
							stayInLoop=false;
						}
					}
				}while(stayInLoop);
				
			}
		}
		for(int i=0;i<rowNum;i++){
			System.out.println(Arrays.deepToString(mainArray[i]));
		}
		
	}
}