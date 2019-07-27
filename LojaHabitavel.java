public class LojaHabitavel extends Imovel{
    private double area;
    private boolean possui_wc;
    private Integer num_porta_loja;
    private String tipo_negocio;
    private String tipo; //Simples, Duplex, Triplex
    private double area_total;
    private Integer num_quartos;
    private Integer num_wcs;
    private Integer num_porta_casa;
    private Integer andar;
    private boolean possui_garagem;
    
    public LojaHabitavel(String rua, double preco_pedido, double preco_aceite, Integer consultas, Integer id,
                       double area, boolean possui_wc, Integer num_porta_loja, String tipo_negocio, 
                       String tipo, double area_total, Integer num_quartos, Integer num_wcs, Integer num_porta_casa, 
                       Integer andar, boolean possui_garagem)
   	{

        super(rua, preco_pedido, preco_aceite, consultas, id);
        this.area = area;
        this.possui_wc = possui_wc;
        this.num_porta_loja = num_porta_loja;
        this.tipo_negocio = tipo_negocio;
        this.tipo = tipo;
        this.area_total = area_total;
        this.num_quartos = num_quartos;
        this.num_wcs = num_wcs;
        this.num_porta_casa = num_porta_casa;
        this.andar = andar;
        this.possui_garagem = possui_garagem;
   	}

   	public LojaHabitavel(LojaHabitavel l){
   		super(l.getRua(), l.getPreco_pedido(), l.getPreco_aceite(), l.getConsultas(), l.getID());
   		area = l.getArea();
        possui_wc  = l.getPossui_wc();
        num_porta_loja = l.getNum_porta_loja();
        tipo_negocio = l.getTipo_negocio();
        tipo = l.getTipo();
        area_total = l.getArea_total();
        num_quartos = l.getNum_quartos();
        num_wcs = l.getNum_wcs();
        num_porta_casa = l.getNum_porta_casa();
        andar = l.getAndar();
        possui_garagem = l.getPossuiGaragem();
   	}
   	
   	public double getArea(){return area;}
    public boolean getPossui_wc(){return possui_wc;}
    public Integer getNum_porta_loja(){return num_porta_loja;}
    public String getTipo_negocio(){return tipo_negocio;}
    public int getConsultas() {
        return consultas;
    }
    
    public void setArea(double area){this.area = area;}
    public void setPossui_wc(boolean possui_wc){this.possui_wc = possui_wc;}
    public void setNum_porta_loja(Integer num_porta_loja){this.num_porta_loja = num_porta_loja;}
    public void setTipo_negocio(String tipo_negocio){this.tipo_negocio = tipo_negocio;}

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

    public Integer getNum_porta_casa() {
        return num_porta_casa;
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

    public void setNum_quartos(Integer num_quartos) {
        this.num_quartos = num_quartos;
    }

    public void setNum_wcs(Integer num_wcs) {
        this.num_wcs = num_wcs;
    }

    public void setNum_porta_casa(Integer num_porta_casa) {
        this.num_porta_casa = num_porta_casa;
    }

    public void setAndar(Integer andar) {
        this.andar = andar;
    }

    public void setPossui_garagem(boolean possui_garagem) {
        this.possui_garagem = possui_garagem;
    }

    public LojaHabitavel clone(){
        return new LojaHabitavel(this);
    }

    public boolean equals(Object o){
        if(this == o)
            return true;

        if((o == null) || (this.getClass() != o.getClass()))
            return false;

        LojaHabitavel a = (LojaHabitavel)o;
        return (this.rua.equals(a.getRua()) &&
                this.preco_pedido == a.getPreco_pedido() &&
                this.preco_aceite == a.getPreco_aceite() &&
                this.consultas == a.getConsultas() &&
                this.area == a.getArea() &&
                this.possui_wc == a.getPossui_wc() &&
                this.num_porta_loja.equals(a.getNum_porta_loja()) &&
                this.tipo_negocio.equals(a.getTipo_negocio()) &&
                this.tipo.equals(a.getTipo()) &&
                this.area_total == a.getArea() &&
                this.num_quartos.equals(a.getNum_quartos()) &&
                this.num_wcs.equals(a.getNum_wcs()) &&
                this.num_porta_casa.equals(a.getNum_porta_casa()) &&
                this.andar.equals(a.getAndar()) &&
                this.possui_garagem == a.getPossuiGaragem());
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Rua: "+this.rua+"\n");
        sb.append("Preço pedido: "+this.preco_pedido+"\n");
        sb.append("Area loja: "+this.area+"\n");
        if(this.possui_wc){
            sb.append("Possui wc.\n");
        }else{
            sb.append("Não possui wc.\n");
        }
        sb.append("Nº porta: "+this.num_porta_loja+"\n");
        sb.append("Tipo de negócio: "+this.tipo_negocio+"\n");
        sb.append("Tipo: "+this.tipo+"\n");
        sb.append("Area habitação: "+this.area_total+"\n");
        sb.append("Nº quartos: "+this.num_quartos+"\n");
        sb.append("Nº wcs: "+this.num_wcs+"\n");
        sb.append("Nº porta: "+this.num_porta_casa+"\n");
        sb.append("Nº andar: "+this.andar+"\n");
        return sb.toString();
    }

    public String formatoGravar(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.rua+",");
        sb.append(this.preco_pedido+",");
        sb.append(this.preco_aceite+",");
        sb.append(this.consultas+",");
        sb.append(this.area+",");
        if(this.possui_wc){
            sb.append("true"+",");
        }else{
            sb.append("false"+",");
        }
        sb.append(this.num_porta_loja+",");
        sb.append(this.tipo_negocio+",");
        sb.append(this.tipo+",");
        sb.append(this.area_total+",");
        sb.append(this.num_quartos+",");
        sb.append(this.num_wcs+",");
        sb.append(this.num_porta_casa+",");
        sb.append(this.andar+",");
        if(this.possui_garagem){
            sb.append("true");
        }else{
            sb.append("false");
        }
        return sb.toString();
    }
}
