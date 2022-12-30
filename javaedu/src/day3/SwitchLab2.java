package day3;

public class SwitchLab2 {
	public static void main(String[] args) {
		int num = (int)(Math.random() * 5) + 1;
		int res;
		switch (num) {
		case 1:
			res = 300 + 50;
			break;
		case 2:
			res = 300 - 50;
			break;
		case 3:
			res = 300 * 50;
			break;
		case 4:
			res = 300 / 50;
			break;
		default:
			res = 300 % 50;			
		}
		System.out.println("결과값 : " + res);
	}
}
