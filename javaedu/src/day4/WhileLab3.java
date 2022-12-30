package day4;

public class WhileLab3 {

	public static void main(String[] args) {
		// CASE1
		int count = 0;		
		while(true) {
			int rand = (int)(Math.random()*31);
			char alpha = (char)(rand+64);
			
			if(rand == 0 || rand>=27 && rand <=30) {				
				break;
			}
			else {
				count++;
				System.out.printf("%c(%d)\n",alpha,rand);					
			}				
		}
		System.out.printf("출력횟수는 %d번입니다.",count);
		// CASE2
		int sum = 0;
		char alpa = '@';
		while(true) {
			int num1 = (int)(Math.random()*31);
			//System.out.println(num1);
			
			if(0 < num1 && num1 < 27) {
				System.out.println((char)(alpa+num1)+"("+num1+")");
				sum++;
			}else if(num1 == 0 || num1 >= 27){
				System.out.println("출력횟수는 "+sum+" 번입니다.");
				break;
			}
		}
	}
}
