import java.util.GregorianCalendar;
import java.util.ArrayList;

public class Terreno extends Imoveis{
    private double area_construcao;
    private String tipo; //Construção de Habitação ou Construção de Armazem
    private double diametro_canalizacao;
    private int kWh_maximo; // 0 -> se não estiver instalad rede eletrica
    private boolean acesso_esgotos;
    public Terreno(String rua, double preco_pedido, double preco_aceite,
                            String tipo, double area_construcao, double diametro_canalizacao, int kWh_maximo, boolean acesso_esgoto){
        super(rua, preco_pedido, preco_aceite);
        this.tipo = tipo;
        this.area_construcao = area_construcao;
        this.diametro_canalizacao = diametro_canalizacao;
        this.kWh_maximo = kWh_maximo;
        this.acesso_esgotos = acesso_esgotos;
    }
    public Terreno(Terreno t){
        super(t.getRua(), t.getPreco_pedido(),t.getPreco_aceite());
        tipo = getTipo();
        area_construcao = getArea_construcao();
        diametro_canalizacao = getDiametro_canalizacao();
        kWh_maximo = getKWh_maximo();
        acesso_esgotos = getAcesso_esgotos();
    }
    public String getTipo(){return tipo;}
    public double getArea_construcao(){return area_construcao;}
    public double getDiametro_canalizacao(){return diametro_canalizacao;}
    public int getKWh_maximo(){return kWh_maximo;}
    public boolean getAcesso_esgotos(){return acesso_esgotos;}
    
    public void setTipo(String tipo){this.tipo = tipo;}
    public void setArea_construcao(double area_construcao){this.area_construcao = area_construcao;}
    public void setDiametro_canalizacao(double diametro_canalizacao){this.diametro_canalizacao = diametro_canalizacao;}
    public void setKWh_maximo(int kWh_maximo){this.kWh_maximo = kWh_maximo;}
    public void setAcesso_esgotos(boolean acesso_esgotos){this.acesso_esgotos = acesso_esgotos;}

    //clone
    public Terreno clone(){
        return new Terreno(this);
    }

    public boolean equals (Object t){
        if (this == t) return true;
        if ((t == null) || (this.getClass() != t.getClass())) return false;

        Terreno te = (Terreno) t;
        return (this.area_construcao == getArea_construcao() && this.tipo.equals(te.getTipo()) && this.diametro_canalizacao == te.getDiametro_canalizacao() && this.kWh_maximo == te.getKWh_maximo() && this.acesso_esgotos == te.getAcesso_esgotos());
    }
    
    //toString
    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append("Tipo: ");
        sb.append(this.getTipo() + " | ");
        sb.append("Area de construção: ");
        sb.append(this.getArea_construcao() + " | ");
        sb.append("Diametro Canalização: ");
        sb.append(this.getDiametro_canalizacao() + " | ");
        sb.append("Capacidade de kWh maxima: ");
        sb.append(this.getKWh_maximo() + " | ");
        sb.append("Acesso a esgotos: ");
        sb.append(this.getAcesso_esgotos());

        return sb.toString();
    }

}


