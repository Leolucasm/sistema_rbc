package gerenciadordebancodedados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import sistemarbcks.Moeda;
import sistemarbcks.Pais;
import sistemarbcks.Projeto;

public class Gerenciador {
    public final String url = "jdbc:postgresql://localhost:5432/rbc_projetos";  
    public final String usuario = "postgres";  
    public final String senha = "12345";
	
    public Connection con;
    public Statement stm;
    public ResultSet rs;
    private ArrayList<Moeda> moedas;
    private ArrayList<Pais> paises;

    public Gerenciador() {
        inicializaMoedas();
        inicializaPaises();
    }            	
    
    public void conexao(String SQL){
        try {   
  
            Class.forName("org.postgresql.Driver");  
  
            con = DriverManager.getConnection(url, usuario, senha);  
  
            stm = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                                      ResultSet.CONCUR_UPDATABLE);  
           
            stm.executeUpdate(SQL);  
     
            con.close();  
  
        } catch (Exception e) {  
             e.printStackTrace();  
             JOptionPane.showMessageDialog(null, "Houve um erro na conexão ao banco de dados");
        }
    }
    
    public void conexao(){
        try {   
  
            Class.forName("org.postgresql.Driver");   
  
            con = DriverManager.getConnection(url, usuario, senha);  
  
            stm = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                                      ResultSet.CONCUR_UPDATABLE);  
 
        } catch (Exception e) {  
             e.printStackTrace();  
        }
    }               
    
    public ArrayList<Projeto> getProjetos(){        
        ArrayList<Projeto> projetos =  new ArrayList<Projeto>();                
        
        conexao();
		
        try {            
            rs = stm.executeQuery("select * from projetos");
//            rs = stm.executeQuery("select * from projetos where nome = 'DogTags'");
        } catch (SQLException ex) {
            Logger.getLogger(Gerenciador.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        try {
            while(rs.next()){
                Projeto projeto = new Projeto();
                
                projeto.setId(rs.getInt("id"));
                projeto.setNome(rs.getString("nome"));
                projeto.setCategoria(rs.getString("categoria"));
                projeto.setMoeda(rs.getString("moeda"));                
                projeto.setStatus(rs.getString("status"));
                projeto.setApoiadores(rs.getInt("apoiadores"));
                projeto.setPais(rs.getString("pais"));        
                projeto.setValor_arrecadado(rs.getDouble("arrecadado"));                                
                projeto.setObjetivo(rs.getDouble("objetivo"));                          
                projeto.setDiasDuracao(rs.getInt("dias"));
                projeto.setAno_projeto(rs.getInt("ano"));                                                
                projetos.add(projeto);                                            
            }
        } catch (SQLException ex) {
            Logger.getLogger(Gerenciador.class.getName()).log(Level.SEVERE, null, ex);
        }		        
            
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Gerenciador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return projetos;
    }
    
    public ArrayList<String> getCategorias(){
        ArrayList<String> categorias = new ArrayList<>();
        
        categorias.add("Impressoras 3D");
        categorias.add("Aplicativos");
        categorias.add("Equipamentos de Camera");
        categorias.add("Eletrônicos (faça você mesmo)");
        categorias.add("Ferramentas de Fabricação");
        categorias.add("Voos");
        categorias.add("Gadgets");
        categorias.add("Hardware");
        categorias.add("Espaço Maker");
        categorias.add("Robótica");
        categorias.add("Software");
        categorias.add("Música");
        categorias.add("Exploração Espacial");
        categorias.add("Tecnologia");
        categorias.add("Usáveis");
        categorias.add("Web");        
        
        return categorias;
    }
    
    private void inicializaMoedas(){
        moedas = new ArrayList<>();
        
        moedas.add(new Moeda("Dólar", "USD"));
        moedas.add(new Moeda("Dólar de Singapura", "SGD"));
        moedas.add(new Moeda("Coroa Sueca", "SEK"));
        moedas.add(new Moeda("Dólar neozelandês", "NZD"));
        moedas.add(new Moeda("Coroa norueguesa", "NOK"));
        moedas.add(new Moeda("Peso mexicano", "MXN"));
        moedas.add(new Moeda("Iene", "JPY"));
        moedas.add(new Moeda("Dólar de Hong Kong", "HKD"));
        moedas.add(new Moeda("Libra esterlina", "GBP"));
        moedas.add(new Moeda("Euro", "EUR"));
        moedas.add(new Moeda("Coroa dinamarquesa", "DKK"));
        moedas.add(new Moeda("Franco suíço", "CHF"));
        moedas.add(new Moeda("Dólar canadense", "CAD"));
        moedas.add(new Moeda("Dólar australiano", "AUD"));
    }        
        
    public ArrayList<String> getMoedas(){
        ArrayList<String> retorno_moedas = new ArrayList<>();
        
        for (Moeda moeda:moedas) {
            retorno_moedas.add(moeda.getNome());
        }                                
        
        return retorno_moedas;
    }
    
    public String getSiglaMoeda(String nome_moeda){
                
        for(Moeda moeda:moedas) {
           if (moeda.getNome().equals(nome_moeda)) {
               return moeda.getSigla();
           }
        }
        
        return "";
    }
    
    public String getNomeMoeda(String sigla_moeda){
                
        for(Moeda moeda:moedas) {
           if (moeda.getSigla().equals(sigla_moeda)) {
               return moeda.getNome();
           }
        }
        
        return "";
    }
        
    private void inicializaPaises(){
        paises = new ArrayList<>();
        
        paises.add(new Pais("Áustria", "AT"));
        paises.add(new Pais("Austrália", "AU"));
        paises.add(new Pais("Bélgica", "BE"));
        paises.add(new Pais("Canadá", "CA"));
        paises.add(new Pais("Suíça", "CH"));
        paises.add(new Pais("Alemanha", "DE"));
        paises.add(new Pais("Dinamarca", "DK"));
        paises.add(new Pais("Espanha", "ES"));
        paises.add(new Pais("França", "FR"));
        paises.add(new Pais("Reino Unido", "GB"));
        paises.add(new Pais("Hong-Kong", "HK"));
        paises.add(new Pais("Irlanda", "IE"));
        paises.add(new Pais("Itália", "IT"));
        paises.add(new Pais("Japão", "JP"));
        paises.add(new Pais("Luxemburgo", "LU"));
        paises.add(new Pais("México", "MX"));
        paises.add(new Pais("Holanda", "NL"));
        paises.add(new Pais("Noruega", "NO"));
        paises.add(new Pais("Nova Zelândia", "NZ"));
        paises.add(new Pais("Suécia", "SE"));
        paises.add(new Pais("Singapura", "SG"));
        paises.add(new Pais("Estados Unidos da América", "US"));                
    }       
    
    public ArrayList<String> getPaises(){
        ArrayList<String> retorno_paises = new ArrayList<>();
        
        for(Pais pais:paises) {
            retorno_paises.add(pais.getNome());
        }                                
        
        return retorno_paises;
    }
    
    public String getSiglaPais(String nome_pais){
                
        for(Pais pais:paises) {
           if (pais.getNome().equals(nome_pais)) {
               return pais.getSigla();
           }
        }
        
        return "";
    }
    
    public String getNomePais(String sigla_pais){
                
        for(Pais pais:paises) {
           if (pais.getSigla().equals(sigla_pais)) {
               return pais.getNome();
           }
        }
        
        return "";
    }
}
