import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import sistemabancario.Models.Cliente;
import sistemabancario.Models.Database;

public class TestDatabase {

    Database database;

    @Before
    public void setUp() {
        database = new Database();
    }

    @Test
    public void TestInicializaDatabase() {
        assertTrue(database.getClientes().isEmpty());
    }

    @Test
    public void TestAdicionaCliente() {
        Cliente cliente1 = new Cliente("12345", "password", "User 1");
        Cliente cliente2 = new Cliente("78901", "mysenha", "User 2");

        database.adicionaCliente(cliente1);
        database.adicionaCliente(cliente2);

        assertEquals(database.getClientes().size(), 2);
    }

    @Test
    public void TestProcuraClienteInexistente() {
        Cliente cliente1 = new Cliente("456129", "senha", "Usuario Teste");
        Cliente cliente2 = new Cliente("78901", "mysenha", "User 2");

        database.adicionaCliente(cliente1);
        database.adicionaCliente(cliente2);

        assertNull(database.getByCpf("12345"));
    }

    @Test
    public void TestProcuraClienteExistente() {
        Cliente cliente1 = new Cliente("456129", "senha", "Usuario Teste");
        Cliente cliente2 = new Cliente("78901", "mysenha", "User 2");
        Cliente cliente3 = new Cliente("12345", "password", "User 1");

        database.adicionaCliente(cliente1);
        database.adicionaCliente(cliente2);
        database.adicionaCliente(cliente3);

        assertNotNull(database.getByCpf("12345"));

        Cliente recuperado = database.getByCpf("12345");
        assertEquals(recuperado.getNome(), "User 1");
    }

}
