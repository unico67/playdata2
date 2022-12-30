package day3;

public class ForLab6 {
    public static void main(String[] args) {
        final char DECO = '&';
        int num = (int)(Math.random()*6)+5;
        System.out.println(num);
        for (int i = 1; i <= num; i++) {     // 행의 갯수
            for (int j = 0; j < i; j++) {    // 데코문자의 갯수
                System.out.print(DECO);
            }
            System.out.println();
        }
    }
}

