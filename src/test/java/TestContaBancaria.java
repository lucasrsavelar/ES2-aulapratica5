import static org.junit.Assert.*;

import org.junit.Test;
import sistemabancario.Models.ContaBancaria;

public class TestContaBancaria {

    @Test
    public void TestNumeroContaBancaria() {
        ContaBancaria conta1 = new ContaBancaria(1);
        ContaBancaria conta2 = new ContaBancaria(2);
        ContaBancaria conta3 = new ContaBancaria(3);
        ContaBancaria conta4 = new ContaBancaria(4);

        assertEquals(conta1.getNumeroConta(), 1);
        assertEquals(conta2.getNumeroConta(), 2);
        assertEquals(conta3.getNumeroConta(), 3);
        assertEquals(conta4.getNumeroConta(), 4);
    }

    @Test
    public void TestInicializacaoContaBancaria() {
        ContaBancaria conta = new ContaBancaria(1);
        assertEquals(conta.getSaldo(), 0.0, 0.00000001);
    }

    @Test
    public void TestDepositosContaBancaria() {
        ContaBancaria conta = new ContaBancaria(1);
        conta.depositar(500.00);
        conta.depositar(300.50);

        assertEquals(conta.getSaldo(), 800.50, 0.00000001);
    }

    @Test
    public void TestSaquesContaBancaria() {
        ContaBancaria conta = new ContaBancaria(1);
        conta.depositar(700.0);

        boolean tentativaSaque = conta.sacar(1000.0);
        assertFalse(tentativaSaque);

        tentativaSaque = conta.sacar(250.0);
        assertTrue(tentativaSaque);
        assertEquals(conta.getSaldo(), 450.0, 0.00000001);
    }


}
