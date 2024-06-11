package sistemabancario.Models;

import lombok.Data;

import static sistemabancario.Utils.IOHelper.print;

@Data
public class Cliente {

    private String cpf;
    private String senha;
    private String nome;
    private ContaBancaria conta;

    public void imprimirExtrato() {
        print("Extrato para o usuário " + this.getNome());
        print("Agência: " + this.getConta().getAgencia());
        print("Conta: " + this.getConta().getNumeroConta());
        print("Saldo disponível: R$" + this.getConta().getSaldo());
    }

    public void fazerPix(int valor, String cpf) {
        this.conta.sacar(valor);
    }

}
