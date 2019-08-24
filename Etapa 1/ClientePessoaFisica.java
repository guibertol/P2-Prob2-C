public class ClientePessoaFisica extends Cliente{
    
    private String cpf;
    private boolean msgWhatsapp;
    private boolean msgSms;
    
    public ClientePessoaFisica() {
    }

    public ClientePessoaFisica(String cpf, boolean msgWhatsapp, boolean msgSms, String nome, String telFixo, String telCelular) {
        super(nome, telFixo, telCelular);
        this.setCpf(cpf);
        this.setMsgWhatsapp(msgWhatsapp);
        this.setMsgSms(msgSms);
    }

    public ClientePessoaFisica(String cpf) {
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public boolean isMsgWhatsapp() {
        return msgWhatsapp;
    }

    public void setMsgWhatsapp(boolean msgWhatsapp) {
        this.msgWhatsapp = msgWhatsapp;
    }

    public boolean isMsgSms() {
        return msgSms;
    }

    public void setMsgSms(boolean msgSms) {
        this.msgSms = msgSms;
    }
    
    
    
}
