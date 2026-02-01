import java.util.*;

public class VowelCheck {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        char ch;

        while (true) {
            System.out.print("Enter a character (# to stop): ");
            ch = sc.next().toLowerCase().charAt(0);

            if (ch == '#') {
                System.out.println("Program Ended.");
                break;
            }

            switch (ch) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    System.out.println("Vowel");
                    break;
                default:
                    System.out.println("Consonant");
            }
        }
    }
}
