import java.util.GregorianCalendar;
import java.util.ArrayList;

public class Compradores extends User{
    private ArrayList<Imoveis> lista_imoveis;

    public Compradores(String email, String nome, String password, String morada, String data, ArrayList<Imoveis> lista_imoveis) {
        super(email, nome, password, morada, data);
        this.lista_imoveis = lista_imoveis;
    }

    public Compradores(Compradores c ){
        super(c.getEmail(), c.getNome(), c.getPassword(), c.getMorada(), c.getData_nascimento().toString());
        this.lista_imoveis = c.getLista_imoveis();
    }

    public ArrayList<Imoveis> getLista_imoveis() {
        return lista_imoveis;
    }

    public void setLista_imoveis(ArrayList<Imoveis> lista_imoveis) {
        this.lista_imoveis = lista_imoveis;
    }
}


