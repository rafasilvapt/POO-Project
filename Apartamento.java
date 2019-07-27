import java.util.GregorianCalendar;
import java.util.ArrayList;

public class Apartamento extends Imovel{
    private String tipo; //Simples, Duplex, Triplex
    private double area_total;
    private Integer num_quartos;
    private Integer num_wcs;
    private Integer num_porta;
    private Integer andar;
    private boolean possui_garagem;
    
    public Apartamento(){
        super();
        this.tipo = "";
        this.area_total = 0;
        this.num_quartos = 0;
        this.num_wcs = 0;
        this.num_porta = 0;
        this.andar = 0;
        this.possui_garagem = false;
    }

    public Apartamento(String rua, double preco_pedido, double preco_aceite, int consultas, Integer id,
                       String tipo, double area_total, Integer num_quartos, Integer num_wcs, Integer num_porta, Integer andar, boolean possui_garagem){
        super(rua, preco_pedido, preco_aceite, consultas, id);
        this.tipo = tipo;
        this.area_total = area_total;
        this.num_quartos = num_quartos;
        this.num_wcs = num_wcs;
        this.num_porta = num_porta;
        this.andar = andar;
        this.possui_garagem = possui_garagem;
    }

    public Apartamento(Apartamento a){
        super(a.getRua(), a.getPreco_pedido(), a.getPreco_aceite(), a.getConsultas(), a.getID());
        this.tipo = a.getTipo();
        this.area_total = a.getArea_total();
        this.num_quartos = a.getNum_quartos();
        this.num_wcs = a.getNum_wcs();
        this.num_porta = a.getNum_porta();
        this.andar = a.getAndar();
        this.possui_garagem = a.getPossuiGaragem();
    }
    public int getConsultas() {
        return consultas;
    }
    public String getTipo() {
        return tipo;
    }
    public double getArea_total() {
        return area_total;
    }
    public Integer getNum_quartos() {
        return num_quartos;
    }
    public Integer getNum_wcs() {
        return num_wcs;
    }
    public Integer getNum_porta() {
        return num_porta;
    }
    public Integer getAndar() {
        return andar;
    }
    public boolean getPossuiGaragem(){
        return possui_garagem;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public void setArea_total(double area_total) {
        this.area_total = area_total;
    }
    public void setNum_quartos(int num_quartos) {
        this.num_quartos = num_quartos;
    }
    public void setNum_wcs(int num_wcs) {
        this.num_wcs = num_wcs;
    }
    public void setNum_porta(int num_porta) {
        this.num_porta = num_porta;
    }
    public void setAndar(int andar) {
        this.andar = andar;
    }
    public void setPossui_garagem(boolean possui_garagem) {
        this.possui_garagem = possui_garagem;
    }

    public Apartamento clone(){
        return new Apartamento(this);
    }

    public boolean equals(Object o){
        if(this == o)
            return true;

        if((o == null) || (this.getClass() != o.getClass()))
            return false;

        Apartamento a = (Apartamento)o;
        return (this.rua.equals(a.getRua()) &&
                this.preco_pedido == a.getPreco_pedido() &&
                this.preco_aceite == a.getPreco_aceite() &&
                this.consultas == a.getConsultas() &&
                this.tipo.equals(a.getTipo()) &&
                this.area_total == a.getArea_total() &&
                this.num_quartos.equals(a.getNum_quartos()) &&
                this.num_wcs.equals(a.getNum_wcs()) &&
                this.num_porta.equals(a.getNum_porta()) &&
                this.andar == a.getAndar() &&
                this.possui_garagem == a.getPossuiGaragem());
    }

    // Para mostrar no menu
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Rua: "+this.rua+"\n");
        sb.append("Preço pedido: "+this.preco_pedido+"\n");
        sb.append("Tipo: "+this.tipo+"\n");
        sb.append("Area total: "+this.area_total+"\n");
        sb.append("Nº quartos: "+this.num_quartos+"\n");
        sb.append("Nº wcs: "+this.num_wcs+"\n");
        sb.append("Nº porta: "+this.num_porta+"\n");
        sb.append("Nº andar: "+this.andar+"\n");
        if(this.possui_garagem){
            sb.append("Possui garagem.\n");
        }else{
            sb.append("Não possui garagem.\n");
        }
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
        sb.append(this.area_total+",");
        sb.append(this.num_quartos+",");
        sb.append(this.num_wcs+",");
        sb.append(this.num_porta+",");
        sb.append(this.andar+",");
        sb.append(this.possui_garagem);
        return sb.toString();
    }
}
