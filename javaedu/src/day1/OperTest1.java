package day1;
public class OperTest1 {
	public static void main(String[] args) {
		double r_num = Math.random(); // 0.0 <= n < 1.0
		System.out.println(r_num);
		double r_num2 = r_num * 10;
		System.out.println(r_num2);
		int r_num3 = (int)r_num2;     // 형 변환 연산
		System.out.println(r_num3); 
		System.out.println(r_num3+1); 
	}
}
