package sistemabancario.Utils;

import sistemabancario.Models.Database;

import static sistemabancario.Utils.IOHelper.*;

public class Menus {

    public static void ImprimeMenuInicial() {
        print("-------------------------------");
        print("| Olá! Bem vindo(a) ao banco! |");
        print("| O que deseja fazer?         |");
        print("-------------------------------");
    }

    public static void ImprimeNovasOpcoes() {
        print("-----------------------------");
        print("| O que deseja fazer agora? |");
        print("-----------------------------");
    }

    public static void ImprimeOpcoesIniciais() {
        print("----------------------------");
        print("| 1 - Acessar minha conta  |");
        print("| 2 - Efetuar cadastro     |");
        print("| 3 - Sair                 |");
        print("----------------------------");
        print("");
        printInLine("Digite sua opção: ");
    }

    public static void ImprimeSaidaSistema() {
        print("----------------------------");
        print("| Saindo do sistema.       |");
        print("| Até logo!                |");
        print("----------------------------");
    }

    public static void ImprimeSaidaConta() {
        print("----------------------------");
        print("| Saindo da conta.         |");
        print("| Até logo!                |");
        print("----------------------------");
    }

    public static void ImprimeCadastro() {
        print("----------------------------------------------------------");
        print("| Ficamos muito felizes por você querer se juntar a nós! |");
        print("| Primeiro, vamos precisar de alguns dados:              |");
        print("----------------------------------------------------------");
    }

    public static void ImprimeCadastroRealizado() {
        print("------------------------------------------------------");
        print("| Parabéns! Seu cadastro já foi efetuado.            |");
        print("| Agora você pode utilizar a opção de acessar conta. |");
        print("------------------------------------------------------");
    }

    public static void ImprimeBoasVindas() {
        print("----------------------------");
        print("| Bem-vindo(a) de volta!      |");
        print("| Digite suas credenciais. |");
        print("----------------------------");
    }

    public static void ImprimeMenuCliente(String nome) {
        print("-----------------------------------");
        print("| Seja bem vindo(a), " + nome + ".   |");
        print("| O que deseja fazer?             |");
        print("-----------------------------------");
    }

    public static void ImprimeOpcoesCliente() {
        print("-----------------------------------");
        print("| 1 - Verificar dados da conta    |");
        print("| 2 - Efetuar depósito            |");
        print("| 3 - Efetuar saque               |");
        print("| 4 - Transferência PIX           |");
        print("| 5 - Imprimir extrato            |");
        print("| 6 - Sair da conta               |");
        print("-----------------------------------");
    }
}
