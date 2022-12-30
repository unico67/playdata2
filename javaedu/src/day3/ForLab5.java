package day3;

public class ForLab5 {
    public static void main(String[] args) {
        int num1 = (int)(Math.random()*8)+3;
        int num2 = (int)(Math.random()*3)+1;
        System.out.println("num1:"+num1+" num2:"+num2);
        // CASE1
        if (num2 == 1) {
            for (int i = 0; i < num1; i++) {
                System.out.print("*");
            }
        } else if (num2 == 2) {
            for (int i = 0; i < num1; i++) {
                System.out.print("$");
            }
        } else {
            for (int i = 0; i < num1; i++) {
                System.out.print("#");
            }
        }
        System.out.println();
        // CASE2
        char munja=' ';
        switch(num2) {
        case 1: munja = '*';  // l-value
                break;
        case 2: munja = '$';
        		break;
        case 3: munja = '#';       
        }        
        for (int i = 1; i <= num1; i++) {
            System.out.print(munja); // r-value
        }
    }
}

