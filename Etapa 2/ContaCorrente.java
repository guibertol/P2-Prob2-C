import java.util.Observable;
import java.util.Observer;
import com.sun.xml.internal.ws.api.message.ExceptionHasMessage;
import java.util.ArrayList;
import java.util.Date;
import javafx.collections.ObservableList;

public class ContaCorrente extends Observable{
    
    private int numero;
    private int agencia;
    private Cliente cliente;
    private double saldo;
    private ArrayList<Operacao> operacoes = new ArrayList<Operacao>();
    private ArrayList<Servico> servicos = new ArrayList<Servico>();

    public ContaCorrente() {
    }

    public ContaCorrente(int numero, int agencia, Cliente cliente, double saldo) {
        this.setNumero(numero);
        this.setAgencia(agencia);
        this.setCliente(cliente);
        this.setSaldo(saldo);
    }
    
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public ArrayList<Operacao> getOperacoes() {
        return operacoes;
    }

    public void setOperacoes(ArrayList<Operacao> operacoes) {
        this.operacoes = operacoes;
    }

    public ArrayList<Servico> getServicos() {
        return servicos;
    }

    public void setServicos(ArrayList<Servico> servicos) {
        this.servicos = servicos;
    }
  
    public void addServico(Servico servico){
       
        servicos.add(servico);
        
        setChanged();
        notifyObservers();
        
    }
    
    public void sacar(double valor){
                
        double saldo = getSaldo();
        
        if((saldo - valor) > 0){
            
            this.gravarSaida(valor);
             
            saldo -= valor;
            setSaldo(saldo);
            
            System.out.println("Cliente "+this.cliente.getNome()+", Sacou R$ "+valor+" de sua conta.");
                    
        }else{
            
            IllegalArgumentException erro = new IllegalArgumentException("Saldo insuficiente.");
            throw erro;
            
        }
        
    }
    
    public void depositar(double valor){
        
        double saldoFuturo = getSaldo();
        saldoFuturo += valor;
        this.gravarEntrada(valor);
        setSaldo(saldoFuturo);
        System.out.println("Cliente "+this.cliente.getNome()+", Depositado R$ "+valor+" em sua conta.");
        
    }
    
    public void transferir(double valor, ContaCorrente contaDestino){
        
        if((getSaldo()-valor) > 0){
            this.gravarSaida(valor);
            sacar(valor);
            contaDestino.depositar(valor);
            System.out.println("Cliente "+cliente.getNome()+", depositou R$ "+valor+" na conta 2"+contaDestino.numero+".");
        }else{
            IllegalArgumentException erro = new IllegalArgumentException("Saldo insuficiente.");
            throw erro;
        }
        
    }
    
    private void receberTransferencia(double valor, ContaCorrente conta){
        
        this.gravarEntrada(valor);
        conta.depositar(valor);
        System.out.println("Transferencia de R$ "+conta.getCliente().getNome()+" realizada.");
        
    }
    
    private void gravarSaida(double valor){
        
        Date data = new Date();
        Operacao operacao = new Operacao(valor, getSaldo(), TipoOperacao.SAIDA,this, data);
        operacoes.add(operacao);
        
        if(this.getCliente()instanceof ClientePessoaFisica){
            
            ClientePessoaFisica fisica = (ClientePessoaFisica) this.getCliente();
            
            if(fisica.isMsgSms()){
                Mensagem m = new Mensagem('M', fisica.getTelCelular());
                m.enviar("Saida da conta realizada, verifique sua conta");
            }
            
            if(fisica.isMsgWhatsapp()){
                Mensagem m = new Mensagem('W', fisica.getTelCelular());
                m.enviar("Saida da conta realizada, verifique sua conta");
            }
            
        }else if(this.getCliente()instanceof ClientePessoaJuridica){
            
            ClientePessoaJuridica juridica = (ClientePessoaJuridica) this.getCliente();
            
            if(juridica.isMsmJms()){
                Mensagem m = new Mensagem('J', juridica.getTelCelular());
                m.enviar("Saida da conta realizada, verifique sua conta");
            }
            
        }
        
        
    }
    
    private void gravarEntrada(double valor){
        Date data = new Date();
        Operacao operacao = new Operacao(valor, getSaldo(), TipoOperacao.ENTRADA,this, data);
        operacoes.add(operacao);
    }
    
    
    public static void main(String[] args) {
        
        System.out.println("=== Cadastro conta ===");
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
        Servico servico = new Servico("aa", conta);
        conta.addServico(servico);
        System.out.println("=== Cadastro conta ===");
        
    }
    
    
}
