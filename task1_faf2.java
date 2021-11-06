import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Stack;

public class task1_faf2 {

    public static void main(String[] args) throws FileNotFoundException {

        Stack pilha = new Stack();

        Scanner in = new Scanner(new FileReader("teste.txt"));
        while (in.hasNextLine()) {
            pilha.push(in.nextLine());
        }

        System.out.println(calcula(pilha));

    }

    public static double calcula(Stack p) {
        String t = p.pop().toString();
        double x;
        double y;
        if (t.equals("+")) {
            y = calcula(p);
            x = calcula(p);
            return x + y;
        } else if (t.equals("-")) {
            y = calcula(p);
            x = calcula(p);
            return x - y;
        } else if (t.equals("*")) {
            y = calcula(p);
            x = calcula(p);
            return x * y;
        } else if (t.equals("/")) {
            y = calcula(p);
            x = calcula(p);
            return x / y;
        } else {
            return Double.parseDouble(t);
        }
    }
}