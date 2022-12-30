package day3;

public class ForLab3 {

	public static void main(String[] args) {
		// CASE1
		int x = (int)(Math.random() * 10) + 1;
		int y = (int)(Math.random()* (40 - 30 + 1)) + 30;
		
		int sum = 0;
		for(int i = x; i <= y; i++) {
			sum += i;
			
		}
		System.out.println(sum);
		
		// CASE2		
		int rand1 = (int)(Math.random() * 10) + 1;
		int rand2 = (int)(Math.random() * 11) + 30;
        		
		sum=0;
		
        for(int result=rand1; result<=rand2; result++) {
        	if (result % 2 == 0)
        		sum += result;
        }
		
		System.out.println(rand1 + " 부터 " + rand2 + " 까지의 짝수의 합 : " + sum);
	}

}
