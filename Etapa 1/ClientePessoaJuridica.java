public class ClientePessoaJuridica extends Cliente{
    
    private String cnpj;
    private boolean msmJms;

    public ClientePessoaJuridica() {
    }

    public ClientePessoaJuridica(String cnpj, boolean servidorJMS) {
        this.cnpj = cnpj;
    }

    public ClientePessoaJuridica(String cnpj, boolean msmJms, String nome, String telFixo, String telCelular) {
        super(nome, telFixo, telCelular);
        this.setCnpj(cnpj);
        this.setMsmJms(msmJms);
    }
    
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public boolean isMsmJms() {
        return msmJms;
    }

    public void setMsmJms(boolean msmJms) {
        this.msmJms = msmJms;
    }
     
}
