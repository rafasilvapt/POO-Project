import java.util.GregorianCalendar;
import java.util.ArrayList;

public class Loja extends Imovel{
    private double area;
    private boolean possui_wc;
    private Integer num_porta;
    private String tipo_negocio;
    //Falta prever a situação em que a loja tem parte habitacional (talvez -> Extends Apartamento)
    public Loja(String rua, double preco_pedido, double preco_aceite, Integer consultas, Integer id,
                       double area, boolean possui_wc, Integer num_porta, String tipo_negocio){
        super(rua, preco_pedido, preco_aceite, consultas, id);
        this.area = area;
        this.possui_wc = possui_wc;
        this.num_porta = num_porta;
        this.tipo_negocio = tipo_negocio;
    }
    public Loja(Loja l){
        super(l.getRua(), l.getPreco_pedido(), l.getPreco_aceite(), l.getConsultas(), l.getID());
        area = l.getArea();
        possui_wc  = l.getPossui_wc();
        num_porta = l.getNum_porta();
        tipo_negocio = l.getTipo_negocio();
    }
    
    public double getArea(){return area;}
    public boolean getPossui_wc(){return possui_wc;}
    public Integer getNum_porta(){return num_porta;}
    public String getTipo_negocio(){return tipo_negocio;}
    public int getConsultas() {
        return consultas;
    }
    
    public void setArea(double area){this.area = area;}
    public void setPossui_wc(boolean possui_wc){this.possui_wc = possui_wc;}
    public void setNum_porta(int num_porta){this.num_porta = num_porta;}
    public void setTipo_negocio(String tipo_negocio){this.tipo_negocio = tipo_negocio;}

    public Loja clone(){
        return new Loja(this);
    }

    public boolean equals(Object o){
        if(this == o)
            return true;

        if((o == null) || (this.getClass() != o.getClass()))
            return false;

        Loja a = (Loja)o;
        return (this.rua.equals(a.getRua()) &&
                this.preco_pedido == a.getPreco_pedido() &&
                this.preco_aceite == a.getPreco_aceite() &&
                this.consultas == a.getConsultas() &&
                this.area == a.getArea() &&
                this.possui_wc == a.getPossui_wc() &&
                this.num_porta.equals(a.getNum_porta()) &&
                this.tipo_negocio.equals(a.getTipo_negocio()));
    }

    // Para mostrar no menu
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Rua: "+this.rua+"\n");
        sb.append("Preço pedido: "+this.preco_pedido+"\n");
        sb.append("Area total: "+this.area+"\n");
        if(this.possui_wc){
            sb.append("Possui wc.\n");
        }else{
            sb.append("Não possui wc.\n");
        }
        sb.append("Nº porta: "+this.num_porta+"\n");
        sb.append("Tipo de negócio: "+this.tipo_negocio+"\n");
        return sb.toString();
    }

    // Para guargar no ficheiro
    public String formatoGravar(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.rua+",");
        sb.append(this.preco_pedido+",");
        sb.append(this.preco_aceite+",");
        sb.append(this.consultas+",");
        sb.append(this.area+",");
        sb.append(this.possui_wc+",");
        sb.append(this.num_porta+",");
        sb.append(this.tipo_negocio);
        return sb.toString();
    }
}
