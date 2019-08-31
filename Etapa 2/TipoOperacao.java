public enum TipoOperacao {
    
    SAIDA(1), ENTRADA(2);
    
    private final int valor;
    
    TipoOperacao(int tipoOperacao){
        valor = tipoOperacao;
    }
    
    public int getValor(){
        return valor;
    }
    
}
