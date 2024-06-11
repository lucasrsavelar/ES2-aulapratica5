package sistemabancario.Utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class IOHelper {

    private static final BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
    public static void print(String mensagem) {
        System.out.println(mensagem);
    }

    public static void printInLine(String mensagem) {
        System.out.print(mensagem);
    }

    public static String readString() {
        try {
            return scanner.readLine();
        } catch (Exception e) {
            print("\nErro na leitura de entrada, digite novamente");
            return readString();
        }
    }

    public static int readNumber() {
        try {
            return Integer.parseInt(readString());
        } catch (Exception e) {
            print("\nErro na leitura de entrada. Tente novamente");
            return readNumber();
        }
    }

    public static double readDouble() {
        try {
            return Double.parseDouble(readString());
        } catch (Exception e) {
            print("\nErro na leitura de entrada. Tente novamente");
            return readDouble();
        }
    }
}
