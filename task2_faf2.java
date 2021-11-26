import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Stack;

public class task2_faf2 {

    public static void main(String[] args) throws FileNotFoundException {

        Stack pilha = new Stack();
        Scanner in = new Scanner(new FileReader("teste.txt"));
        boolean ok = true;
        String temp = "";
        StringBuilder sb = new StringBuilder();

        while (in.hasNextLine() && ok) {
            temp = in.nextLine();
            if (temp.equals("+")) {
                sb.append("Token [type=PLUS, lexeme=+]\n");
                pilha.push(temp);
            } else if (temp.equals("-")) {
                sb.append("Token [type=MINUS, lexeme=-]\n");
                pilha.push(temp);
            } else if (temp.equals("*")) {
                sb.append("Token [type=STAR, lexeme=*]\n");
                pilha.push(temp);
            } else if (temp.equals("/")) {
                sb.append("Token [type=SLASH, lexeme=/]\n");
                pilha.push(temp);
            } else {
                try {
                    int x = Integer.parseInt(temp);
                    sb.append("Token [type=NUM, lexeme="+temp+"]\n");
                    pilha.push(temp);
                } catch (Exception e) {
                    sb.delete(0, sb.length());
                    sb.append("Error: Unexpected character: "+temp);
                    ok = false;
                }
            }
        }

        if (ok) {
            System.out.println(sb.toString());
            System.out.println("Saída: " + calcula(pilha));
        } else {
            System.out.println(sb.toString());
        }

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
