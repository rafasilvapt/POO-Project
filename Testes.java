import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.Set;
import java.util.*;

public class Testes
{
    private Imoobiliaria imo;
    private Vendedor v;
    private Terreno t;

    /**
     * Teste principal
     */
    @Test
    public void mainTest() {
        imo = new Imoobiliaria();
        try {
            imo.iniciaSessao("",null);
        } catch(SemAutorizacaoException e) {
            
        } catch(Exception e) {
            fail();
        }
        
        try {
            v = new Vendedor("email@email.pt","email","pass","morada","1000-10-10",new ArrayList<Integer>(),new ArrayList<Integer>());  // Preencher parÃ¢metros do construtor
            imo.registarUtilizador(v);
        } catch(Exception e) {
            fail();
        }
        
        String email = v.getEmail();
        String password = v.getPassword();
        assertEquals("class Vendedor", v.getClass().toString());
        
        try {
            assertEquals("email@email.pt", email);
            assertEquals("pass", password);
            assertEquals("", imo.getLogado());
            imo.iniciaSessao(email, password);
            assertEquals("email@email.pt", imo.getLogado());
        } catch(Exception e) {
            fail();
        }
        
        t = new Terreno("rua",20.0,18.0,1,86,"Simples",80.0,80.0,30,false);  // Preencher parÃ¢metros do construtor
        try {
            imo.registaImovel(t);
        } catch (Exception e) {
            fail();
        }
            
        int s = imo.getImovel("Terreno", Integer.MAX_VALUE).size();
        assertTrue(s>0);
        Set<String> ids = imo.getTopImoveis(0);
        assertTrue(ids.contains(Integer.toString(t.getID())));
        assertTrue(imo.getMapeamentoImoveis().keySet().contains(t));
        /*try {
            assertTrue(imo.getConsultas().size()>0);
        } catch(Exception e) {
            fail();
        }*/
        
        imo.fechaSessao();
        Comprador c = new Comprador("comprador@comprador.pt","comprador","passComprador","morada","1000-10-10",new ArrayList<Integer>(),new TreeSet<Integer>());  // Preencher parÃ¢metros do construtor
        try {
            imo.registarUtilizador(c);
        } catch(Exception e) {
            fail();
        }
        email = c.getEmail();
        password = c.getPassword();
        assertEquals("comprador@comprador.pt", email);
        assertEquals("passComprador", password);
        /*try {
            imo.iniciaSessao(email, password);
            imo.setFavorito(t.getID().toString());
            assertTrue(imo.getFavoritos().contains(t));
        } catch(Exception e) {
            e.printStackTrace();
            fail();
        }*/
    }
    
}