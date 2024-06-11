import static org.junit.Assert.*;

import org.junit.Test;
import sistemabancario.Models.Cliente;

public class TestCliente {

    @Test
    public void TestClienteVazio() {
        Cliente cliente = new Cliente();
        assertNull(cliente.getNome());
        assertNull(cliente.getCpf());
        assertNull(cliente.getSenha());
        assertNull(cliente.getConta());
    }

    @Test
    public void TestClientePreenchido() {
        Cliente cliente = new Cliente("12345", "password123", "Cliente");
        assertEquals(cliente.getNome(), "Cliente");
        assertEquals(cliente.getCpf(), "12345");
        assertEquals(cliente.getSenha(), "password123");
    }
}
