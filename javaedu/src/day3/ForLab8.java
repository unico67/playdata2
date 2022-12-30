package day3;

public class ForLab8 {
    public static void main(String[] args) {
        char alpha = 'A';

        for (int i = 1; i < 6; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(alpha);
                alpha++;   // alpha += 1, alpha = (char)(alpha + 1)
            }
            System.out.println();
        }
    }
}

