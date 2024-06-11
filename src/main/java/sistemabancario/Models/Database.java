package sistemabancario.Models;

import sistemabancario.Utils.Validacoes;

import java.util.ArrayList;
import java.util.List;

import static sistemabancario.Utils.Menus.*;
import static sistemabancario.Utils.IOHelper.*;
import static sistemabancario.Utils.Validacoes.*;
public class Database {

    private List<Cliente> clientes = new ArrayList<>();

    public Cliente getByCpf(String cpf) {
        for(Cliente cliente : this.clientes) {
            if(cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }

        return null;
    }

    public void efetuarCadastro() {

        ImprimeCadastro();
        Cliente novoCliente = new Cliente();

        printInLine("Digite seu nome: ");
        String nomeCliente = readString();
        printInLine("Digite seu CPF: ");
        String cpfCliente = readString();
        printInLine("Crie uma senha para sua conta: ");
        String senhaCliente = readString();

        novoCliente.setNome(nomeCliente);
        novoCliente.setCpf(cpfCliente);
        novoCliente.setSenha(senhaCliente);
        novoCliente.setConta(new ContaBancaria());

        this.adicionaCliente(novoCliente);
        ImprimeCadastroRealizado();
    }

    public void adicionaCliente(Cliente novoCliente) {
        clientes.add(novoCliente);
    }

    public String fazerLogin() {

        printInLine("Digite seu CPF: ");
        String cpf = readString();
        printInLine("Digite sua senha: ");
        String senha = readString();

        Cliente cliente = this.getByCpf(cpf);

        if(cliente == null)
            return INVALID_USER;

        if(!cliente.getSenha().equals(senha))
            return INVALID_PASSWORD;

        return cpf;
    }

}
