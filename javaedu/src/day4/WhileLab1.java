package day4;

public class WhileLab1 {

	public static void main(String[] args) {
		int rand = (int)(Math.random()*6+5);
		int start = 1;
		System.out.println(rand);
		System.out.println("[for 결과]");
		for(int i = 1; i<=rand;i++) {
			System.out.printf("%d -> %d\n", i,i*i);
		}
		
		System.out.println("[while 결과]");
		while(start <= rand) {
			System.out.printf("%d -> %d\n", start,start*start);
			start ++;
		}
	}
}
