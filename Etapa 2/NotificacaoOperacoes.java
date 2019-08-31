
import java.util.Observable;

public class NotificacaoOperacoes extends Servico {
    
    private static NotificacaoOperacoes singleton;

    public NotificacaoOperacoes(String nome, Observable conta) {
        super(nome, conta);
    }
    
    
    
}
