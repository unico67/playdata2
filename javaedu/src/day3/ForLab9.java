package day3;

public class ForLab9 {
	public static void main(String[] args) {
		int num = (int)(Math.random() * 2) + 1;

		if (num == 1) {
			for (int i = 1; i <= 9; i += 2) {
				for (int j = 1; j <= 9; j++) {
					System.out.print(i + "x" + j + "=" + i * j + "\t");
				}
				System.out.print("\n");
			}
		} else {
			for (int i = 2; i <= 8; i += 2) {
				for (int j = 1; j <= 9; j++) {
					System.out.print(i + "x" + j + "=" + i * j + "\t");
				}
				System.out.print("\n");
			}
		}
	}
}
