package sistemabancario.Service;

import sistemabancario.Models.Cliente;
import sistemabancario.Models.Database;

import static sistemabancario.Utils.IOHelper.*;
import static sistemabancario.Utils.Menus.*;
import static sistemabancario.Utils.Validacoes.*;

public class OperacoesCliente {

    private boolean pularOperacoes = false;
    public void operacoesCliente(Cliente cliente, Database bancoDeDados) {

        ImprimeMenuCliente(cliente.getNome());
        ImprimeOpcoesCliente();
        int opcao = validaEscolhaOperacao(readNumber());

        while(true) {
            if(opcao == 1) {
                cliente.getConta().getInformacoesConta();
            }

            if(opcao == 2) {
                this.efetuaDeposito(cliente);
            }

            if(opcao == 3) {
                this.efetuaSaque(cliente);
            }

            if(opcao == 4) {
                this.efetuaTransferenciaPix(cliente, bancoDeDados);
            }

            if(opcao == 5) {
                cliente.imprimirExtrato();
            }

            if(opcao == 6) {
                ImprimeSaidaConta();
                break;
            }

            ImprimeNovasOpcoes();
            ImprimeOpcoesCliente();
            pularOperacoes = false;
            opcao = validaEscolhaOperacao(readNumber());

        }
    }

    private void efetuaDeposito(Cliente cliente) {
        printInLine("Digite o valor que deseja depositar: R$");
        double valor = readDouble();
        cliente.getConta().depositar(valor);
        print("Depósito efetuado com sucesso!");
    }

    private void efetuaSaque(Cliente cliente) {
        printInLine("Digite o valor que deseja sacar: R$");
        double valor = readDouble();
        boolean resultado = cliente.getConta().sacar(valor);
        if(resultado)
            print("Saque efetuado com sucesso!");
        else
            print("Saldo insuficiente.");
    }

    private void efetuaTransferenciaPix(Cliente cliente, Database bancoDeDados) {
        printInLine("Digite o CPF de quem receberá o PIX: ");
        String cpfRecebedor = readString();

        Cliente clienteRecebedor = bancoDeDados.getByCpf(cpfRecebedor);
        if(clienteRecebedor == null) {
            print("O CPF informado não possui conta ativa em nosso sistema.");
            pularOperacoes = true;
        }

        if(!pularOperacoes) {
            printInLine("Digite o valor que deseja transferir: R$");
            double valorEnviado = readDouble();
            if (valorEnviado > cliente.getConta().getSaldo()) {
                print("Você não possui saldo suficiente para fazer essa transferência");
                pularOperacoes = true;
            }

            if(!pularOperacoes) {
                cliente.getConta().sacar(valorEnviado);
                clienteRecebedor.getConta().depositar(valorEnviado);
                print("PIX efetuado com sucesso!");
            }
        }
    }
}
