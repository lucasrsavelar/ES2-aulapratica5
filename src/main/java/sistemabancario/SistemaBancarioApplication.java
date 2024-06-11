package sistemabancario;

import sistemabancario.Models.Cliente;
import sistemabancario.Models.Database;
import sistemabancario.Service.OperacoesCliente;

import static sistemabancario.Utils.IOHelper.*;
import static sistemabancario.Utils.Menus.*;
import static sistemabancario.Utils.Validacoes.*;

public class SistemaBancarioApplication {
    public static void main(String[] args) {

        Database bancoDeDados = new Database();

        ImprimeMenuInicial();
        ImprimeOpcoesIniciais();
        int opcao = validaEscolhaInicial(readNumber());

        while(true) {
            if (opcao == 1) {
                ImprimeBoasVindas();
                String resultadoLogin = bancoDeDados.fazerLogin();
                boolean loginValido = true;

                if(resultadoLogin.equals(INVALID_USER)) {
                    print("Usuário não encontrado! Verifique seu CPF e tente novamente.");
                    loginValido = false;
                }

                if(resultadoLogin.equals(INVALID_PASSWORD)) {
                    print("Senha incorreta para o usuário! Tente novamente.");
                    loginValido = false;
                }

                if(loginValido) {
                    print("Login efetuado com sucesso!");
                    Cliente clienteLogado = bancoDeDados.getByCpf(resultadoLogin);
                    OperacoesCliente operacoes = new OperacoesCliente();
                    operacoes.operacoesCliente(clienteLogado, bancoDeDados);
                }
            }

            if (opcao == 2) {
                bancoDeDados.efetuarCadastro();
            }

            if (opcao == 3) {
                ImprimeSaidaSistema();
                break;
            }

            ImprimeNovasOpcoes();
            ImprimeOpcoesIniciais();
            opcao = validaEscolhaInicial(readNumber());
        }

    }
}