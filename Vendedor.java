import java.util.GregorianCalendar;
import java.util.ArrayList;
import java.util.*;

public class Vendedor extends Actores{
    private ArrayList<Integer> imoveis_mercado;
    private ArrayList<Integer> imoveis_vendidos;

    public Vendedor(String email, String nome, String password, String morada, String data, ArrayList<Integer> imoveis_mercado, ArrayList<Integer> imoveis_vendidos) {
        super(email, nome, password, morada, data);
        this.imoveis_mercado = copiaArray(imoveis_mercado);
        this.imoveis_vendidos = copiaArray(imoveis_vendidos);
    }

    public Vendedor(Vendedor v){
        super(v.getEmail(), v.getNome(), v.getPassword(), v.getMorada(), v.getData_nascimento().toString());
        this.imoveis_mercado = v.getImoveis_mercado();
        this.imoveis_vendidos = v.getImoveis_vendidos();
    }

    public ArrayList<Integer> getImoveis_mercado() {
        return imoveis_mercado;
    }
    public ArrayList<Integer> getImoveis_vendidos() {
        return imoveis_vendidos;
    }

    public void setImoveis_mercado(ArrayList<Integer> imoveis_mercado) {
        this.imoveis_mercado = imoveis_mercado;
    }
    public void setImoveis_vendidos(ArrayList<Integer> imoveis_vendidos) {
        this.imoveis_vendidos = imoveis_vendidos;
    }

    public Vendedor clone(){
        return new Vendedor(this);
    }
    
    public ArrayList<Integer> copiaArray(ArrayList<Integer> cop){
        ArrayList<Integer> novo = new ArrayList<Integer>();
        for (Integer x: cop) {
            novo.add(x);
        }
        return novo;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(email+",");
        sb.append(nome+",");
        sb.append(password+",");
        sb.append(morada+",");
        sb.append(this.getData_nascimento().get(Calendar.YEAR)+"-"+this.getData_nascimento().get(Calendar.MONTH)+"-"+this.getData_nascimento().get(Calendar.DAY_OF_MONTH)+",");
        int flag = 0;
        for(Integer x : imoveis_mercado){
            if(flag == 0){
                sb.append(x);
                flag = 1; 
            }else{
                sb.append(";"+x);
            }
        }
        sb.append(",");
        flag = 0;
        for(Integer x : imoveis_vendidos){
            if(flag == 0){
                sb.append(x);
                flag = 1; 
            }else{
                sb.append(";"+x);
            }
        }
        return sb.toString();
    }
}
