package sistemabancario.Utils;

import static sistemabancario.Utils.IOHelper.*;

public class Validacoes {

    public static final String INVALID_USER = "USUARIO INVALIDO!";
    public static final String INVALID_PASSWORD = "SENHA INVALIDA!";
    public static int validaEscolhaInicial(int opcao) {
        if (opcao < 1 || opcao > 3) {
            while (opcao < 1 || opcao > 3) {
                print("Opção invalida! Por favor digite uma opção válida.");
                opcao = readNumber();
            }
        }

        return opcao;
    }

    public static int validaEscolhaOperacao(int opcao) {
        if (opcao < 1 || opcao > 6) {
            while (opcao < 1 || opcao > 6) {
                print("Opção invalida! Por favor digite uma opção válida.");
                opcao = readNumber();
            }
        }

        return opcao;
    }

}
