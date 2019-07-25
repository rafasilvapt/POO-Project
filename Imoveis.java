import java.util.GregorianCalendar;
import java.util.ArrayList;

public class Imoveis {
    public String rua;
    public double preco_pedido;
    public double preco_aceite;

    public Imoveis(){
        this("", 0, 0);
    }

    public Imoveis(String rua, double preco_pedido, double preco_aceite){
        this.rua = rua;
        this.preco_pedido = preco_pedido;
        this.preco_aceite = preco_aceite;
    }

    public Imoveis(Imoveis i){
        this.rua = i.getRua();
        this.preco_pedido = i.getPreco_pedido();
        this.preco_aceite = i.getPreco_aceite();
    }

    public String getRua() {
        return rua;
    }
    public double getPreco_pedido() {
        return preco_pedido;
    }
    public double getPreco_aceite() {
        return preco_aceite;
    }
    public void setRua(String rua) {
        this.rua = rua;
    }
    public void setPreco_pedido(double preco_pedido) {
        this.preco_pedido = preco_pedido;
    }
    public void setPreco_aceite(double preco_aceite) {
        this.preco_aceite = preco_aceite;
    }

    //clone
    public Imoveis clone(){
        return new Imoveis(this);
    }
    
    // equals
    public boolean equals (Object i){
        if (this == i) return true;
        if ((i == null) || (this.getClass() != i.getClass())) return false;

        Imoveis ie = (Imoveis) i;
        return (this.rua.equals(ie.getRua()) && this.preco_pedido == ie.getPreco_pedido() && this.preco_aceite == ie.getPreco_aceite());
    }
    
    //toString
        public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append("Rua: ");
        sb.append(this.getRua() + " | ");
        sb.append("Preco Pedido: ");
        sb.append(this.getPreco_pedido() + " | ");
        sb.append("Preco Aceite: ");
        sb.append(this.getPreco_aceite());

        return sb.toString();
    }



}


