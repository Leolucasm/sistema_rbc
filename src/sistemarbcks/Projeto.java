package sistemarbcks;

import java.util.Date;

public class Projeto {        
    private int id;
    private String nome;
    private String categoria;
    private String moeda;
    private String status;
    private int apoiadores;
    private String pais;
    private double valor_arrecadado;
    private double objetivo;
    
    private Date inicio_projeto;
    private Date fim_projeto;
    private int dias_duracao;
    private int ano_projeto;
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getMoeda() {
        return moeda;
    }

    public void setMoeda(String moeda) {
        this.moeda = moeda;
    }

    public Date getInicio_projeto() {
        return inicio_projeto;
    }

    public void setInicio_projeto(Date inicio_projeto) {
        this.inicio_projeto = inicio_projeto;
        this.setAno_projeto(inicio_projeto.getYear());
    }

    public Date getFim_projeto() {
        return fim_projeto;
    }

    public void setFim_projeto(Date fim_projeto) {
        this.fim_projeto = fim_projeto;
    }

    public double getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(double objetivo) {
        this.objetivo = objetivo;
    }

    public double getValor_arrecadado() {
        return valor_arrecadado;
    }

    public void setValor_arrecadado(double valor_arrecadado) {
        this.valor_arrecadado = valor_arrecadado;
    }
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getApoiadores() {
        return apoiadores;
    }

    public void setApoiadores(int apoiadores) {
        this.apoiadores = apoiadores;
    }

    public String getPais() {
        return pais;
    }

    public int getIDCategoria() {
        String categoria_projeto = this.getCategoria().toLowerCase();

        switch (categoria_projeto) {
            case "3d printing":
                return 0;
            case "apps":
                return 1;
            case "camera equipment":
                return 2;
            case "diy electronics":
                return 3;
            case "fabrication tools":
                return 4;
            case "flight":
                return 5;
            case "gadgets":
                return 6;
            case "hardware":
                return 7;
            case "makerspaces":
                return 8;
            case "robots":
                return 9;
            case "software":
                return 10;
            case "sound":
                return 11;
            case "space exploration":
                return 12;
            case "technology":
                return 13;
            case "wearables":
                return 14;
            case "web":
                return 15;
        }

        //retornar exceção caso não encontre a categoria
        return 0;
    }

    public int getIDMoeda() {
        String moeda_projeto = this.getMoeda().toLowerCase();

        switch (moeda_projeto) {
            case "usd":
                return 0;
            case "sgd":
                return 1;
            case "sek":
                return 2;
            case "nzd":
                return 3;
            case "nok":
                return 4;
            case "mxn":
                return 5;
            case "jpy":
                return 6;
            case "hkd":
                return 7;
            case "gbp":
                return 8;
            case "eur":
                return 9;
            case "dkk":
                return 10;
            case "chf":
                return 11;
            case "cad":
                return 12;
            case "aud":
                return 13;
        }

        //retornar exceção caso não encontre a moeda
        return 0;
    }

    public int getIDPais() {
        String pais_projeto = this.getPais().toLowerCase();

        switch (pais_projeto) {
            case "at":
                return 0;
            case "au":
                return 1;
            case "be":
                return 2;
            case "ca":
                return 3;
            case "ch":
                return 4;
            case "de":
                return 5;
            case "dk":
                return 6;
            case "es":
                return 7;
            case "fr":
                return 8;
            case "gb":
                return 9;
            case "hk":
                return 10;
            case "ie":
                return 11;
            case "it":
                return 12;
            case "jp":
                return 13;
            case "lu":
                return 14;
            case "mx":
                return 15;
            case "nl":
                return 16;
            case "no":
                return 17;
            case "nz":
                return 18;
            case "se":
                return 19;
            case "sg":
                return 20;
            case "us":
                return 21;            
        }

        return 0;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
    
    public void calculaDiferencaDias(){
        this.setDiasDuracao((int) ((this.getFim_projeto().getTime() - this.getInicio_projeto().getTime()) / (1000 * 60 * 60 * 24)));
    }        

    public int getAno_projeto() {
        return ano_projeto;
    }

    public void setAno_projeto(int ano_projeto) {
        this.ano_projeto = ano_projeto;
    }

    public void setDiasDuracao(int dias_duracao) {
        this.dias_duracao = dias_duracao;
    }

    public int getDiasDuracao() {
        return dias_duracao;
    }                

}
