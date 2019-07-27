import java.util.GregorianCalendar;
import java.util.ArrayList;

public abstract class Imovel {
    public String rua;
    public double preco_pedido;
    public double preco_aceite;
    public int consultas;
    public Integer id;
    
    public Imovel(){
        this("", 0, 0, 0, 0);
    }

    public Imovel(String rua, double preco_pedido, double preco_aceite, int consultas, Integer id){
        this.rua = rua;
        this.preco_pedido = preco_pedido;
        this.preco_aceite = preco_aceite;
        this.consultas = consultas;
        this.id = id;
    }

    public Imovel(Imovel i){
        this.rua = i.getRua();
        this.preco_pedido = i.getPreco_pedido();
        this.preco_aceite = i.getPreco_aceite();
        this.consultas = i.getConsultas();
        this.id = i.getID();
    }

    public String getRua() {
        return rua;
    }
    public int getConsultas() {
        return consultas;
    }
    public double getPreco_pedido() {
        return preco_pedido;
    }
    public double getPreco_aceite() {
        return preco_aceite;
    }
    public Integer getID(){
        return id;
    }
    public void setRua(String rua) {
        this.rua = rua;
    }
    public void setID(Integer id){
        this.id = id;
    }
    public void setConsultas(String rua) {
        this.consultas = consultas;
    }
    public void setPreco_pedido(double preco_pedido) {
        this.preco_pedido = preco_pedido;
    }
    public void setPreco_aceite(double preco_aceite) {
        this.preco_aceite = preco_aceite;
    }

    public Imovel clone(){
        return this;
    }
}
