import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Algorithms {
    private static File f;
    private static Scanner s;

    public static void main(String[] args) throws FileNotFoundException {
        f = new File("Numbers.txt");
        int odds = odds();
        int evens = evens();
        System.out.println("Odd numbers count: " + odds);
        System.out.println("Even numbers count: " + evens);
        s.close();
    }

    public static int odds() throws FileNotFoundException {
        s = new Scanner(f);
        int odds = 0;
        while (s.hasNext()) {
            if (s.nextInt() % 2 != 0) {
                odds++;
            }
        }
        s.close();
        s = new Scanner(f);
        return odds;
    }

    public static int evens() throws FileNotFoundException {
        int evens = 0;
        while (s.hasNext()) {
            if (s.nextInt() % 2 == 0) {
                evens++;
            }
        }
        return evens;
    }
}
