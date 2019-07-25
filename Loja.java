import java.util.GregorianCalendar;
import java.util.ArrayList;

public class Loja extends Imoveis{
    private double area;
    private boolean possui_wc;
    private int num_porta;
    private String tipo_negocio;
    //Falta prever a situação em que a loja tem parte habitacional (talvez -> Extends Apartamento)
    public Loja(String rua, double preco_pedido, double preco_aceite,
                       double area, boolean possui_wc, int num_porta, String tipo_negocio){
        super(rua, preco_pedido, preco_aceite);
        this.area = area;
        this.possui_wc = possui_wc;
        this.num_porta = num_porta;
        this.tipo_negocio = tipo_negocio;
    }
    public Loja(Loja l){
        super(l.getRua(), l.getPreco_pedido(), l.getPreco_aceite());
        area = l.getArea();
        possui_wc  = l.getPossui_wc();
        num_porta = l.getNum_porta();
        tipo_negocio = l.getTipo_negocio();
    }
    
    public double getArea(){return area;}
    public boolean getPossui_wc(){return possui_wc;}
    public int getNum_porta(){return num_porta;}
    public String getTipo_negocio(){return tipo_negocio;}
    
    public void setArea(double area){this.area = area;}
    public void setPossui_wc(boolean possui_wc){this.possui_wc = possui_wc;}
    public void setNum_porta(int num_porta){this.num_porta = num_porta;}
    public void setTipo_negocio(String tipo_negocio){this.tipo_negocio = tipo_negocio;}
    
    //clone
    public Loja clone(){
        return new Loja(this);
    }

    // equals

    public boolean equals (Object l){
        if (this == l) return true;
        if ((l == null) || (this.getClass() != l.getClass())) return false;

        Loja le = (Loja) l;
        return (this.area == le.getArea() && this.possui_wc == le.getPossui_wc() && this.num_porta == le.getNum_porta() && this.tipo_negocio.equals(le.getTipo_negocio()));
    }
    
    //toString
       public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append("Area: ");
        sb.append(this.getArea() + " | ");
        sb.append("Possui WC: ");
        sb.append(this.getPossui_wc() + " | ");
        sb.append("Numero da Porta: ");
        sb.append(this.getNum_porta() + " | ");
        sb.append("Tipo de Negocio: ");
        sb.append(this.getTipo_negocio());
     

        return sb.toString();
    }

    
}
