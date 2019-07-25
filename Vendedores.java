import java.util.GregorianCalendar;
import java.util.ArrayList;

public class Vendedores extends User{
    private ArrayList<Imoveis> imoveis_mercado;
    private ArrayList<Imoveis> imoveis_vendidos;



    public Vendedores(String email, String nome, String password, String morada, String data, ArrayList<Imoveis> imoveis_mercado, ArrayList<Imoveis> imoveis_vendidos) {
        super(email, nome, password, morada, data);
        this.imoveis_mercado = imoveis_mercado;
        this.imoveis_vendidos = imoveis_vendidos;
    }

    public Vendedores(Vendedores v){
        super(v.getEmail(), v.getNome(), v.getPassword(), v.getMorada(), v.getData_nascimento().toString());
        this.imoveis_mercado = v.getImoveis_mercado();
        this.imoveis_vendidos = v.getImoveis_vendidos();
    }

    public ArrayList<Imoveis> getImoveis_mercado() {
        return imoveis_mercado;
    }
    public ArrayList<Imoveis> getImoveis_vendidos() {
        return imoveis_vendidos;
    }

    public void setImoveis_mercado(ArrayList<Imoveis> imoveis_mercado) {
        this.imoveis_mercado = imoveis_mercado;
    }
    public void setImoveis_vendidos(ArrayList<Imoveis> imoveis_vendidos) {
        this.imoveis_vendidos = imoveis_vendidos;
    }


}
