import java.util.GregorianCalendar;
import java.util.ArrayList;

public class Terreno extends Imovel{
    private double area_construcao;
    private String tipo; //Construção de Habitação ou Construção de Armazem
    private double diametro_canalizacao;
    private Integer kWh_maximo; // 0 -> se não estiver instalad rede eletrica
    private boolean acesso_esgotos;

    public Terreno(String rua, double preco_pedido, double preco_aceite, Integer consultas, Integer id,
                            String tipo, double area_construcao, double diametro_canalizacao, Integer kWh_maximo, 
                            boolean acesso_esgoto){
        super(rua, preco_pedido, preco_aceite, consultas, id);
        this.tipo = tipo;
        this.area_construcao = area_construcao;
        this.diametro_canalizacao = diametro_canalizacao;
        this.kWh_maximo = kWh_maximo;
        this.acesso_esgotos = acesso_esgotos;
    }
    public Terreno(Terreno t){
        super(t.getRua(), t.getPreco_pedido(),t.getPreco_aceite(), t.getConsultas(), t.getID());
        tipo = getTipo();
        area_construcao = getArea_construcao();
        diametro_canalizacao = getDiametro_canalizacao();
        kWh_maximo = getKWh_maximo();
        acesso_esgotos = getAcesso_esgotos();
    }
    public String getTipo(){return tipo;}
    public double getArea_construcao(){return area_construcao;}
    public double getDiametro_canalizacao(){return diametro_canalizacao;}
    public Integer getKWh_maximo(){return kWh_maximo;}
    public boolean getAcesso_esgotos(){return acesso_esgotos;}
    public int getConsultas() {
        return consultas;
    }
    
    public void setTipo(String tipo){this.tipo = tipo;}
    public void setArea_construcao(double area_construcao){this.area_construcao = area_construcao;}
    public void setDiametro_canalizacao(double diametro_canalizacao){this.diametro_canalizacao = diametro_canalizacao;}
    public void setKWh_maximo(Integer kWh_maximo){this.kWh_maximo = kWh_maximo;}
    public void setAcesso_esgotos(boolean acesso_esgotos){this.acesso_esgotos = acesso_esgotos;}

    public Terreno clone(){
        return new Terreno(this);
    }

    public boolean equals(Object o){
        if(this == o)
            return true;

        if((o == null) || (this.getClass() != o.getClass()))
            return false;

        Terreno a = (Terreno)o;
        return (this.rua.equals(a.getRua()) &&
                this.preco_pedido == a.getPreco_pedido() &&
                this.preco_aceite == a.getPreco_aceite() &&
                this.consultas == a.getConsultas() &&
                this.tipo.equals(a.getTipo()) &&
                this.area_construcao == a.getArea_construcao() &&
                this.diametro_canalizacao == a.getDiametro_canalizacao() &&
                this.kWh_maximo.equals(a.getKWh_maximo()) &&
                this.acesso_esgotos == a.getAcesso_esgotos());
    }

    // Para mostrar no menu
    public String toString(){
        StringBuilder sb = new StringBuilder();
        
        sb.append("Rua: "+this.rua+"\n");
        sb.append("Preço pedido: "+this.preco_pedido+"\n");
        sb.append("Tipo: "+this.tipo+"\n");
        sb.append("Area construção: "+this.area_construcao+"\n");
        sb.append("Diametro da canalização: "+this.diametro_canalizacao+"\n");
        sb.append("kWh máximos: "+this.kWh_maximo+"\n");
        if(this.acesso_esgotos){
            sb.append("Possui acesso ao esgoto.\n");
        }else{
            sb.append("Não possui acesso ao esgoto.\n");
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
        sb.append(this.area_construcao+",");
        sb.append(this.diametro_canalizacao+",");
        sb.append(this.kWh_maximo+",");
        sb.append(this.acesso_esgotos);
        return sb.toString();
    }
}
