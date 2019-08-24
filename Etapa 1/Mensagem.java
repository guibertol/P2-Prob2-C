public class Mensagem {
    
    //W = whatsapp
    //M = mensagem
    //J = JMS
    
    private char tipo;
    private String destinatario;

    public Mensagem() {
    }

    public Mensagem(char tipo, String destinatario) {
        this.tipo = tipo;
        this.destinatario = destinatario;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public void enviar(String mensagem) {
        System.out.println(mensagem);
    }
    
}
