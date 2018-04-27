package sistema_RBC;

import sistemarbcks.Projeto;

public class SistemaRBC_KS {

    static final double PESO_CATEGORIA = 1.0;
    static final double PESO_OBJETIVO = 0.4;
    static final double PESO_QUANTIDADE_DIAS = 0.3;
    static final double PESO_MOEDA = 0.2;
    static final double PESO_PAIS = 0.1;

    static final int VALOR_MAXIMO_OBJETIVO = 9;
    static final int VALOR_MAXIMO_QUANTIDADE_DIAS = 4;

    static final double[][] MATRIZ_CATEGORIAS = {
        /*Impressão 3D*/{1, 0.4, 0.4, 0.8, 0.8, 0.6, 0.3, 0.8, 0.9, 0.3, 0.4, 0.1, 0, 0.3, 0.3, 0.4},
        /*Aplicativos*/ {0.4, 1, 0.4, 0.5, 0.3, 0.3, 0.6, 0.3, 0.2, 0.2, 0.8, 0.3, 0, 0.3, 0.5, 0.7},
        /*Equipamentos de Camera*/ {0.4, 0.4, 1, 0, 0, 0.2, 0.3, 0.5, 0.1, 0.2, 0.3, 0, 0.3, 0.3, 0.1, 0.1},
        /*Eletrônicos (Faça você Mesmo)*/ {0.8, 0.5, 0, 1, 0.8, 0.3, 0.2, 0.5, 0.5, 0.6, 0.2, 0.1, 0, 0.3, 0.1, 0.2},
        /*Ferramentas de Fabricação*/ {0.8, 0.3, 0, 0.8, 1, 0.2, 0.2, 0.5, 0.6, 0.3, 0.1, 0, 0, 0.3, 0, 0},
        /*Equipamentos de Voos*/ {0.6, 0.3, 0.2, 0.3, 0.2, 1, 0.1, 0.6, 0, 0.3, 0.1, 0, 0.5, 0.3, 0, 0},
        /*Gadgets*/ {0.3, 0.6, 0.3, 0.2, 0.2, 0.1, 1, 0.2, 0, 0, 0.4, 0.1, 0, 0.3, 0.5, 0},
        /*Hardware*/ {0.8, 0.3, 0.5, 0.5, 0.5, 0.6, 0.2, 1, 0.2, 0.8, 0, 0, 0.2, 0.3, 0.4, 0},
        /*Espaço Maker*/ {0.9, 0.2, 0.1, 0.5, 0.6, 0, 0, 0.2, 1, 0.5, 0.2, 0, 0, 0.3, 0.1, 0},
        /*Robótica*/ {0.3, 0.2, 0.2, 0.6, 0.3, 0.3, 0, 0.8, 0.5, 1, 0.1, 0, 0.2, 0.3, 0.1, 0},
        /*Software*/ {0.4, 0.8, 0.3, 0.2, 0.1, 0.1, 0.4, 0, 0, 0.2, 1, 0.2, 0.3, 0.3, 0.3, 0.7},
        /*Música*/ {0.1, 0.3, 0, 0.1, 0, 0, 0.1, 0, 0, 0, 0.2, 1, 0, 0.3, 0.3, 0},
        /*Exploração Espacial*/ {0, 0, 0.3, 0, 0, 0.5, 0, 0.2, 0.2, 0, 0.3, 0, 1, 0.3, 0, 0},
        /*Tecnologia*/ {0.3, 0.3, 0.3, 0.3, 0.3, 0.3, 0.3, 0.3, 0.3, 0.3, 0.3, 0.3, 0.3, 1, 0.3, 0.3},
        /*Usáveis*/ {0.3, 0.5, 0.1, 0.1, 0, 0, 0.5, 0.4, 0.4, 0.1, 0.3, 0.3, 0, 0.3, 1, 0.2},
        /*Web*/ {0.4, 0.7, 0.1, 0.2, 0, 0, 0, 0, 0, 0, 0.7, 0, 0, 0.3, 0.2, 1}
    };

    static final double[][] MATRIZ_MOEDAS = {
        /*USD*/{1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.2, 0.3, 0.1, 0.1, 0.1, 0.1},
        /*SGD*/ {0.1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        /*SEK*/ {0.1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        /*NZD*/ {0.1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        /*NOK*/ {0.1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        /*MXN*/ {0.1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
        /*JPY*/ {0.1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
        /*HKD*/ {0.1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
        /*GBP*/ {0.2, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
        /*EUR*/ {0.3, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
        /*DKK*/ {0.1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
        /*CHF*/ {0.1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
        /*CAD*/ {0.1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
        /*AUD*/ {0.1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1}
    };

    static final double[][] MATRIZ_PAISES = {
        /*AT*/ {1.0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        /*AU*/ {0, 1.0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        /*BE*/ {0, 0, 1.0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        /*CA*/ {0, 0, 0, 1.0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        /*CH*/ {0, 0, 0, 0, 1.0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        /*DE*/ {0, 0, 0, 0, 0, 1.0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        /*DK*/ {0, 0, 0, 0, 0, 0, 1.0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        /*ES*/ {0, 0, 0, 0, 0, 0, 0, 1.0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        /*FR*/ {0, 0, 0, 0, 0, 0, 0, 0, 1.0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        /*GB*/ {0, 0, 0, 0, 0, 0, 0, 0, 0, 1.0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        /*HK*/ {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1.0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        /*IE*/ {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1.0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        /*IT*/ {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1.0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        /*JP*/ {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1.0, 0, 0, 0, 0, 0, 0, 0, 0},
        /*LU*/ {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1.0, 0, 0, 0, 0, 0, 0, 0},
        /*MX*/ {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1.0, 0, 0, 0, 0, 0, 0},
        /*NL*/ {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1.0, 0, 0, 0, 0, 0},
        /*NO*/ {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1.0, 0, 0, 0, 0},
        /*NZ*/ {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1.0, 0, 0, 0},
        /*SE*/ {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1.0, 0, 0},
        /*SG*/ {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1.0, 0},
        /*US*/ {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1.0}
    };

    Projeto projeto1;
    Projeto projeto2;

    public double calculaSimilaridadeFilmes(Projeto projeto1, Projeto projeto2) {
        this.projeto1 = projeto1;
        this.projeto2 = projeto2;

        double categoria = calculaCategoria();
        double objetivo = calculaObjetivo();
        double quantidade_dias = calculaQuantidadeDias();
        double moeda = calculaMoeda();
        double pais = calculaPais();                

        double similaridade = calculaSimilaridade(categoria, objetivo, quantidade_dias, moeda, pais);

        return similaridade;
    }

    private double calculaSimilaridade(double categoria, double objetivo, double quantidade_dias, double moeda, double pais) {
        double somatorioPesos = (categoria * PESO_CATEGORIA) + (objetivo * PESO_OBJETIVO) + (quantidade_dias * PESO_QUANTIDADE_DIAS)
                + (moeda * PESO_MOEDA) + (pais * PESO_PAIS);
        double pesoTotal = PESO_CATEGORIA + PESO_OBJETIVO + PESO_QUANTIDADE_DIAS + PESO_MOEDA + PESO_PAIS;

        return (somatorioPesos / pesoTotal) * 100;
    }

    private double calculaCategoria() {
        return MATRIZ_CATEGORIAS[projeto1.getIDCategoria()][projeto2.getIDCategoria()];                                
    }

    private double calculaObjetivo() {
        int valorAtributoProjeto1 = getValorObjetivo(projeto1.getObjetivo());
        int valorAtributoProjeto2 = getValorObjetivo(projeto2.getObjetivo());        
        
        double resultadoA = valorAtributoProjeto2 - valorAtributoProjeto1;
        double resultadoB = Math.abs(resultadoA / VALOR_MAXIMO_OBJETIVO);
        double resultadoFinal = 1 - resultadoB;
        
        return resultadoFinal;        
        //return Math.abs(((valorAtributoProjeto1 - valorAtributoProjeto2) / VALOR_MAXIMO_OBJETIVO) - 1);        
    }

    private double calculaQuantidadeDias() {        
        int valorAtributoProjeto1 = getValorQuantidadeDias(projeto1.getDiasDuracao());
        int valorAtributoProjeto2 = getValorQuantidadeDias(projeto2.getDiasDuracao());
        
        double resultadoA = valorAtributoProjeto2 - valorAtributoProjeto1;
        double resultadoB = Math.abs(resultadoA / VALOR_MAXIMO_QUANTIDADE_DIAS);
        double resultadoFinal = 1 - resultadoB;
        
        return resultadoFinal;
        //return Math.abs(((valorAtributoProjeto1 - valorAtributoProjeto2) / VALOR_MAXIMO_QUANTIDADE_DIAS) - 1);        
    }

    private int getValorQuantidadeDias(long quantidade_dias) {

        if (quantidade_dias >= 0 & quantidade_dias <= 10) {
            return 0;
        } else if (quantidade_dias <= 20) {
            return 1;
        } else if (quantidade_dias <= 30) {
            return 2;
        } else if (quantidade_dias <= 60) {
            return 3;
        } else if (quantidade_dias > 60) {
            return 4;
        }

        return 0;
    }

    private int getValorObjetivo(double objetivo) {

        if (objetivo >= 0 & objetivo <= 100) {
            return 0;
        } else if (objetivo <= 1000) {
            return 1;
        } else if (objetivo <= 5000) {
            return 2;
        } else if (objetivo <= 10000) {
            return 3;
        } else if (objetivo <= 30000) {
            return 4;
        } else if (objetivo <= 50000) {
            return 5;
        } else if (objetivo <= 100000) {
            return 6;
        } else if (objetivo <= 300000) {
            return 7;
        } else if (objetivo <= 500000) {
            return 8;
        } else if (objetivo > 500000) {
            return 9;
        }

        return 0;
    }

    private double calculaMoeda() {
        return MATRIZ_MOEDAS[projeto1.getIDMoeda()][projeto2.getIDMoeda()];
    }

    private double calculaPais() {
        return MATRIZ_PAISES[projeto1.getIDPais()][projeto2.getIDPais()];                                
    }        
}
