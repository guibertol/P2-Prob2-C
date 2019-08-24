
import java.util.Date;

public class Operacao {
    
    private double valor;
    private double saldoAnterior;
    private TipoOperacao tipo;
    private ContaCorrente conta;
    private Date date;

    public Operacao() {
    }

    public Operacao(double valor, double saldoAnterior, TipoOperacao tipo, ContaCorrente conta, Date date) {
        this.setValor(valor);
        this.setSaldoAnterior(saldoAnterior);
        this.setTipo(tipo);
        this.setConta(conta);
        this.setDate(date);
    }
    
    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getSaldoAnterior() {
        return saldoAnterior;
    }

    public void setSaldoAnterior(double saldoAnterior) {
        this.saldoAnterior = saldoAnterior;
    }

    public TipoOperacao getTipo() {
        return tipo;
    }

    public void setTipo(TipoOperacao tipo) {
        this.tipo = tipo;
    }

    public ContaCorrente getConta() {
        return conta;
    }

    public void setConta(ContaCorrente conta) {
        this.conta = conta;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
}
