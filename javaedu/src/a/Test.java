package a;

public class Test {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = (int)(Math.random() * 26) + 1; //1~26		
		System.out.printf("추출된 숫자%d %c\n",num, (char)(num+64));
		System.out.println("추출된 숫자 : "+num);
		System.out.println((char)(num+64));
	}
}