import java.util.GregorianCalendar;
import java.util.ArrayList;

public class Moradia extends Imoveis{
    private String tipo; //isolada, geminada, banda, gaveto
    private double area_implantacao;
    private double area_coberta;
    private double area_terreno;
    private int num_quartos;
    private int num_wcs;
    private int num_porta;
    
    public Moradia(String rua, double preco_pedido, double preco_aceite,
                    String tipo, double area_implatacao, double area_coberta, double area_terreno, int num_quartos, int num_wcs, int num_porta){
        super(rua, preco_pedido, preco_aceite);
        this.tipo = tipo;
        this.area_implantacao = area_implantacao;
        this.area_coberta = area_coberta;
        this.area_terreno = area_terreno;
        this.num_quartos = num_quartos;
        this.num_wcs = num_wcs;
        this.num_porta = num_porta;
    }
    public Moradia(Moradia m){
        super(m.getRua(), m.getPreco_pedido(), m.getPreco_aceite());
        tipo = m.getTipo();
        area_implantacao = m.getArea_implantacao();
        area_coberta = m.getArea_coberta();
        area_terreno = m.getArea_terreno();
        num_quartos = m.getNum_quartos();
        num_wcs = m.getNum_wcs();
        num_porta = m.getNum_porta();
    }
    public String getTipo(){return tipo;}
    public double getArea_implantacao(){return area_implantacao;}
    public double getArea_coberta(){return area_coberta;}
    public double getArea_terreno(){return area_terreno;}
    public int getNum_quartos(){return num_quartos;}
    public int getNum_wcs(){return num_wcs;}
    public int getNum_porta(){return num_porta;}
    
    public void setTipo(String tipo){this.tipo = tipo;}
    public void setArea_implantacao(double area_implantacao){this.area_implantacao = area_implantacao;}
    public void setArea_coberta(double area_coberta){this.area_coberta = area_coberta;}
    public void setArea_terreno(double area_terreno){this.area_terreno = area_terreno;}
    public void setNum_quartos(int num_quartos){this.num_quartos = num_quartos;}
    public void setNum_wcs(int num_wcs){this.num_wcs = num_wcs;}
    public void setNum_porta(int num_porta){this.num_porta = num_porta;}

    //clone
    public Moradia clone(){
        return new Moradia(this);
    }
    
    // equals
    public boolean equals (Object m){
        if (this == m) return true;
        if ((m == null) || (this.getClass() != m.getClass())) return false;

        Moradia me = (Moradia) m;
        return (this.tipo.equals(me.getTipo()) && this.area_implantacao == me.getArea_implantacao() && this.area_coberta == me.getArea_coberta() && this.area_terreno == me.getArea_terreno()  && this.num_quartos == me.getNum_quartos() && this.num_wcs == me.getNum_wcs() && this.num_porta == me.getNum_porta());
    }

    //toString
    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append("Tipo: ");
        sb.append(this.getTipo() + " | ");
        sb.append("Area Implantação: ");
        sb.append(this.getArea_implantacao() + " | ");
        sb.append("Area Coberta: ");
        sb.append(this.getArea_coberta() + " | ");
        sb.append("Area do Terreno: ");
        sb.append(this.getArea_terreno() + " | ");
        sb.append("Numero de quartos: ");
        sb.append(this.getNum_quartos() + " | ");
        sb.append("Numero de WC: ");
        sb.append(this.getNum_wcs() + " | ");
        sb.append("Numero da porta: ");
        sb.append(this.getNum_porta() + " | ");

        return sb.toString();
    }
}