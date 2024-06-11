package sistemabancario.Models;

import lombok.Data;

import static sistemabancario.Utils.IOHelper.*;

@Data
public class Cliente {

    private String cpf;
    private String senha;
    private String nome;
    private ContaBancaria conta;

    public Cliente() {
        this.cpf = null;
        this.senha = null;
        this.nome = null;
        this.conta = null;
    }

    public Cliente(String cpf, String senha, String nome) {
        this.cpf = cpf;
        this.senha = senha;
        this.nome = nome;
        this.conta = null;
    }

    public Cliente(String cpf, String senha, String nome, ContaBancaria conta) {
        this.cpf = cpf;
        this.senha = senha;
        this.nome = nome;
        this.conta = conta;
    }

    public void imprimirExtrato() {
        print("Extrato para o usuário " + this.getNome());
        print("Agência: " + this.getConta().getAgencia());
        print("Conta: " + this.getConta().getNumeroConta());
        print("Saldo disponível: R$" + this.getConta().getSaldo());
    }

}
