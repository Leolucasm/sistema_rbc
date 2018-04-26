package sistemarbcks;

public class Moeda {
    private final String nome;
    private final String sigla;

    public Moeda(String nome, String sigla) {
        this.nome = nome;
        this.sigla = sigla;
    }

    public String getNome() {
        return nome;
    }

    public String getSigla() {
        return sigla;
    }        
        
}