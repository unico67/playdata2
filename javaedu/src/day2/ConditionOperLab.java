package day2;

public class ConditionOperLab {
	public static void main(String[] args) {
		int num = (int)(Math.random() * 5) + 1;
		int res;
		if (num == 1) {
			res = num + 50;
		}
		else if (num == 2) {
			res = num - 50;
		}
		else if (num == 3) {
			res = num * 50;
		}
		else if (num == 4) {
			res = num / 50;
		}
		else {
			res = num % 50;
		}
		
		//System.out.println(num); // 결과 확인용		
		System.out.println("결과값 : " + res);
	}
}
