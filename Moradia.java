import java.util.GregorianCalendar;
import java.util.ArrayList;

public class Moradia extends Imovel{
    private String tipo; //isolada, geminada, banda, gaveto
    private double area_implantacao;
    private double area_coberta;
    private double area_terreno;
    private Integer num_quartos;
    private Integer num_wcs;
    private Integer num_porta;
    
    public Moradia(String rua, double preco_pedido, double preco_aceite, Integer consultas, Integer id,
                    String tipo, double area_implantacao, double area_coberta, double area_terreno, 
                    Integer num_quartos, Integer num_wcs, Integer num_porta){
        super(rua, preco_pedido, preco_aceite, consultas, id);
        this.tipo = tipo;
        this.area_implantacao = area_implantacao;
        this.area_coberta = area_coberta;
        this.area_terreno = area_terreno;
        this.num_quartos = num_quartos;
        this.num_wcs = num_wcs;
        this.num_porta = num_porta;
    }
    public Moradia(Moradia m){
        super(m.getRua(), m.getPreco_pedido(), m.getPreco_aceite(), m.getConsultas(), m.getID());
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
    public Integer getNum_quartos(){return num_quartos;}
    public Integer getNum_wcs(){return num_wcs;}
    public Integer getNum_porta(){return num_porta;}
    public int getConsultas() {
        return consultas;
    }
    
    public void setTipo(String tipo){this.tipo = tipo;}
    public void setArea_implantacao(double area_implantacao){this.area_implantacao = area_implantacao;}
    public void setArea_coberta(double area_coberta){this.area_coberta = area_coberta;}
    public void setArea_terreno(double area_terreno){this.area_terreno = area_terreno;}
    public void setNum_quartos(Integer num_quartos){this.num_quartos = num_quartos;}
    public void setNum_wcs(Integer num_wcs){this.num_wcs = num_wcs;}
    public void setNum_porta(Integer num_porta){this.num_porta = num_porta;}

    public Moradia clone(){
        return new Moradia(this);
    }

    public boolean equals(Object o){
        if(this == o)
            return true;

        if((o == null) || (this.getClass() != o.getClass()))
            return false;

        Moradia a = (Moradia)o;
        return (this.rua.equals(a.getRua()) &&
                this.preco_pedido == a.getPreco_pedido() &&
                this.preco_aceite == a.getPreco_aceite() &&
                this.consultas == a.getConsultas() &&
                this.tipo.equals(a.getTipo()) &&
                this.area_implantacao == a.getArea_implantacao() &&
                this.area_coberta == a.getArea_coberta() &&
                this.area_terreno == a.getArea_terreno() &&
                this.num_quartos.equals(a.getNum_quartos()) &&
                this.num_wcs.equals(a.getNum_wcs()) &&
                this.num_porta.equals(a.getNum_porta()));
    }

    // Para mostrar no menu
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Rua: "+this.rua+"\n");
        sb.append("Preço pedido: "+this.preco_pedido+"\n");
        sb.append("Tipo: "+this.tipo+"\n");
        sb.append("Area implantacao: "+this.area_implantacao+"\n");
        sb.append("Area total coberta: "+this.area_coberta+"\n");
        sb.append("Area terreno envolvente: "+this.area_terreno+"\n");
        sb.append("Nº quartos: "+this.num_quartos+"\n");
        sb.append("Nº wcs: "+this.num_wcs+"\n");
        sb.append("Nº porta: "+this.num_porta+"\n");
        return sb.toString();
    }

    // Para guargar no ficheiro
    public String formatoGravar(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.rua+",");
        sb.append(this.preco_pedido+",");
        sb.append(this.preco_aceite+",");
        sb.append(this.consultas+",");
        sb.append(this.tipo+",");
        sb.append(this.area_implantacao+",");
        sb.append(this.area_coberta+",");
        sb.append(this.area_terreno+",");
        sb.append(this.num_quartos+",");
        sb.append(this.num_wcs+",");
        sb.append(this.num_porta);
        return sb.toString();
    }
}