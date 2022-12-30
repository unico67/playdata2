package day1;
public class VarTest2 {
	public static void main(String[] args) {
		System.out.println(100);
		int num;  // 변수 선언
		num = 1000;
		System.out.println("연산 전 : "+num);
		num = 10+20;
		System.out.println("연산 후 : "+num);
		char munja = 'A';  // 0x41, 65
		System.out.print(munja); // A
		munja++;
		System.out.print(munja); // B
		munja += 1;
		System.out.print(munja); // C
		munja = (char)(munja+1); // munja = munja + 1
		System.out.println(munja);  // D
	}
}








