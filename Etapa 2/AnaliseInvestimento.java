
import java.util.Observable;

public class AnaliseInvestimento extends Servico{
    
    private static AnaliseInvestimento singleton;

    
    
    public AnaliseInvestimento(String nome, Observable conta) {
        super(nome, conta);
    }
    
    
}
