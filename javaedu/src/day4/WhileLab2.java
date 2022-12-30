package day4;

public class WhileLab2 {

	public static void main(String[] args) {
		char truth = '작';	
		int pairNum1, pairNum2;
		while(true) {
			pairNum1 = (int)(Math.random()*6+1);
			pairNum2 = (int)(Math.random()*6+1);
			
			if(pairNum1 == pairNum2) { 
				System.out.println("게임 끝");
				break;
			}
			else {
				if (pairNum1 > pairNum2)
					truth = '크';
				System.out.printf("pairNum1이 pariNum2보다 %c다\n",truth);
			}				
		}		
	}
}
