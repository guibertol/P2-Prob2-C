import java.util.Observable;
import java.util.Observer;

class Servico implements Observer {
    
    Observable conta;
    private String nome;


    public Servico(String nome, Observable conta) {
        this.nome = nome;
        this.conta = conta;
        this.conta.addObserver(this);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("VOCÊ ADICIONOU UMA CONTA");
    }
    
}
