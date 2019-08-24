
import java.util.Date;

public class OperacaoTransferencia extends Operacao{
    
    private ContaCorrente contaCorrente;

    public OperacaoTransferencia() {
    }

    public OperacaoTransferencia(ContaCorrente contaCorrente) {
        this.contaCorrente = contaCorrente;
    }

    public OperacaoTransferencia(ContaCorrente contaCorrente, float valor, float saldoAnterior, TipoOperacao tipo, ContaCorrente conta, Date date) {
        super(valor, saldoAnterior, tipo, conta, date);
        this.setContaCorrente(contaCorrente);
    }
    
    public ContaCorrente getContaCorrente() {
        return contaCorrente;
    }

    public void setContaCorrente(ContaCorrente contaCorrente) {
        this.contaCorrente = contaCorrente;
    }
        
}
