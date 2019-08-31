import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class Testes {
    
    public Testes() {
    }
    
    @Test
    public void setCadastraCliente() {
        
        System.out.println("=== Teste cadastra cliente ===");
        ClientePessoaFisica pessoaFisica = new ClientePessoaFisica();
        pessoaFisica.setNome("Gustavo");
        pessoaFisica.setTelCelular("48 98894-4588");
        pessoaFisica.setTelFixo("48 4569-4879");
        
      
        
        
        
        assertSame(pessoaFisica, pessoaFisica);
        
    }
    
    @Test
    public void setCadastroConta(){
        
        System.out.println("=== Cadastro conta ===");
        ClientePessoaFisica pessoaFisica = new ClientePessoaFisica();
        pessoaFisica.setNome("Gustavo");
        pessoaFisica.setCpf("02148934896");
        pessoaFisica.setTelCelular("48 98894-4588");
        pessoaFisica.setTelFixo("48 4569-4879");
        assertSame(pessoaFisica, pessoaFisica);
        
       
 
        ContaCorrente conta = new ContaCorrente();
        conta.setAgencia(1234);
        conta.setCliente(pessoaFisica);
        conta.setNumero(123456);
        conta.setSaldo(45000.00);
        Servico servico = new Servico("aaa", conta);
        conta.addServico(servico);
        
        assertNotNull(conta);
        
    }
    
    @Test
    public void setRealizarSaque(){
        
        System.out.println("=== Teste Realiza saque ===");
        ClientePessoaFisica pessoaFisica = new ClientePessoaFisica();
        pessoaFisica.setNome("Gustavo");
        pessoaFisica.setCpf("02148934896");
        pessoaFisica.setTelCelular("48 98894-4588");
        pessoaFisica.setTelFixo("48 4569-4879");
        
        ContaCorrente conta = new ContaCorrente();
        conta.setAgencia(1234);
        conta.setCliente(pessoaFisica);
        conta.setNumero(123456);
        conta.setSaldo(45000.00);
        conta.sacar(20000.00);
        
        assertEquals(25000.00, conta.getSaldo(), 0.00);
    
    }
    
    @Test
    public void setTransferencia(){
        
        System.out.println("=== Teste Realiza tranferencia ===");
        ClientePessoaFisica pessoaFisica = new ClientePessoaFisica();
        pessoaFisica.setNome("Gustavo");
        pessoaFisica.setCpf("02148934896");
        pessoaFisica.setTelCelular("48 98894-4588");
        pessoaFisica.setTelFixo("48 4569-4879");
        
        ContaCorrente conta1 = new ContaCorrente();
        conta1.setAgencia(1234);
        conta1.setCliente(pessoaFisica);
        conta1.setNumero(123456);
        conta1.setSaldo(1000.00);
        
        ClientePessoaJuridica pessoaJuridica = new ClientePessoaJuridica();
        pessoaJuridica.setNome("Gustavo");
        pessoaJuridica.setTelCelular("48 98894-4588");
        pessoaJuridica.setTelFixo("48 4569-4879");
        pessoaJuridica.setCnpj("777888999666555");
        
        ContaCorrente conta2 = new ContaCorrente();
        conta2.setAgencia(1234);
        conta2.setCliente(pessoaJuridica);
        conta2.setNumero(123456);
        conta2.setSaldo(45000.00);
        conta1.transferir(658.00, conta2);
        
        assertEquals(conta1.getSaldo(), 342.00, 0.00);
        
    }
    
    @Test
    public void setTransferencia2(){
        
        System.out.println("=== Teste Realiza tranferencia ===");
        ClientePessoaFisica pessoaFisica = new ClientePessoaFisica();
        pessoaFisica.setNome("Gustavo");
        pessoaFisica.setCpf("02148934896");
        pessoaFisica.setTelCelular("48 98894-4588");
        pessoaFisica.setTelFixo("48 4569-4879");
        
        ContaCorrente conta1 = new ContaCorrente();
        conta1.setAgencia(1234);
        conta1.setCliente(pessoaFisica);
        conta1.setNumero(123456);
        conta1.setSaldo(1000.00);
        
        ClientePessoaJuridica pessoaJuridica = new ClientePessoaJuridica();
        pessoaJuridica.setNome("Gustavo");
        pessoaJuridica.setTelCelular("48 98894-4588");
        pessoaJuridica.setTelFixo("48 4569-4879");
        pessoaJuridica.setCnpj("777888999666555");
        
        ContaCorrente conta2 = new ContaCorrente();
        conta2.setAgencia(1234);
        conta2.setCliente(pessoaJuridica);
        conta2.setNumero(123456);
        conta2.setSaldo(45000.00);
        conta1.transferir(658.00, conta2);
        
        assertEquals(conta2.getSaldo(), 45658.00, 0.00);
        
    }
    
    @Test
    public void setVerificaOperacoes(){
        
        System.out.println("=== Teste Realiza tranferencia ===");
        ClientePessoaFisica pessoaFisica = new ClientePessoaFisica();
        pessoaFisica.setNome("Gustavo");
        pessoaFisica.setCpf("02148934896");
        pessoaFisica.setTelCelular("48 98894-4588");
        pessoaFisica.setTelFixo("48 4569-4879");
        
        ContaCorrente conta1 = new ContaCorrente();
        conta1.setAgencia(1234);
        conta1.setCliente(pessoaFisica);
        conta1.setNumero(123456);
        conta1.setSaldo(1000.00);
        conta1.sacar(150.00);

        assertNotNull(conta1.getOperacoes());
        
    }
    
    
}
