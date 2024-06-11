package sistemabancario.Models;

import lombok.Data;

import static sistemabancario.Utils.IOHelper.*;

@Data
public class ContaBancaria {

    private String agencia;
    private int numeroConta;
    private double saldo;

    public ContaBancaria(int numeroConta) {
        this.agencia = "001";
        this.numeroConta = numeroConta;
        this.saldo = 0.0;
    }

    public void depositar(double valor) {
        this.setSaldo(this.getSaldo() + valor);
    }

    public boolean sacar(double valor) {
        if(this.getSaldo() < valor) {
            return false;
        }

        this.setSaldo(this.getSaldo() - valor);
        return true;
    }

    public void getInformacoesConta() {
        print("Agencia: " + this.getAgencia());
        print("Conta: " + this.getNumeroConta());
    }

}
