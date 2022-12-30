package day4;

public class ArrayLab3 {

	public static void main(String[] args) {
		// CASE1
		char[] c = {'J','a','v','a'};
		
		for(int i = 0; i<c.length;i++) {
			if(c[i]>=65 && c[i]<=90) {    // c[i]>='A' && c[i]<='Z'
				c[i]+=32;
				System.out.println(c[i]);
			}
			else {
				c[i]-=32;
				System.out.println(c[i]);
			}		
			
		}
		System.out.println();
		// CASE2
		char[] arr = {'J','a','v','a'};
		int change;
		
		for(char i : arr) {
			if(Character.isUpperCase(i)) change = 32;
			else change = -32;
			System.out.printf("%c\n",i+change);
		}

	}

}
