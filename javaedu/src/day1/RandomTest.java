package day1;

public class RandomTest {

	public static void main(String[] args) {
		double rand = Math.random();
		System.out.println(rand);    // 0.0 <= x < 1.0  0.0000 ~ 0.9999
		System.out.println(rand*10);
		System.out.println(rand*100);
		System.out.println(rand*6);
		System.out.println((int)(rand*10));   // 강제 형 변환 연산자(cast 연산자)
		System.out.println((int)(rand*100));  
		System.out.println((int)(rand*6));  
		System.out.println((int)(rand*10)+1);   
		System.out.println((int)(rand*100)+1);  
		System.out.println((int)(rand*6)+1);   
		System.out.println((int)(rand*45)+1);   
	}

}
