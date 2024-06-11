import static org.junit.Assert.*;

import org.junit.Test;
import sistemabancario.Models.ContaBancaria;

public class TestContaBancaria {

    @Test
    public void TestInicializacaoContaBancaria() {
        ContaBancaria conta = new ContaBancaria();
        assertEquals(conta.getSaldo(), 0.0, 0.00000001);
    }
}
