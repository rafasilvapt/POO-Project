import java.util.GregorianCalendar;
import java.util.ArrayList;
import java.util.*;

public class Comprador extends Actores{
    private ArrayList<Integer> lista_imoveis;
    TreeSet<Integer> favoritos = new TreeSet<Integer>();

    public Comprador(String email, String nome, String password, String morada, String data, ArrayList<Integer> lista_imoveis, TreeSet<Integer> favoritos) {
        super(email, nome, password, morada, data);
        this.lista_imoveis = copiaArray(lista_imoveis);
        this.favoritos = copiaTreeSet(favoritos);
    }

    public Comprador(Comprador c ){
        super(c.getEmail(), c.getNome(), c.getPassword(), c.getMorada(), c.getData_nascimento().toString());
        this.lista_imoveis = c.getLista_imoveis();
        this.favoritos = c.getFavoritos();
    }

    public ArrayList<Integer> getLista_imoveis() {
        return lista_imoveis;
    }

    public TreeSet<Integer> getFavoritos(){
        return favoritos;
    }

    public void setFavorito(Integer id){
        this.favoritos.add(id);
    }

    public Comprador clone(){
        return new Comprador(this);
    }
    
    public ArrayList<Integer> copiaArray(ArrayList<Integer> cop){
        ArrayList<Integer> novo = new ArrayList<Integer>();
        for (Integer x: cop) {
            novo.add(x);
        }
        return novo;
    }
    
    public TreeSet<Integer> copiaTreeSet(TreeSet<Integer> cop){
        TreeSet<Integer> novo = new TreeSet<Integer>();
        for (Integer x: cop) {
            novo.add(x);
        }
        return novo;
    }

    public String toString(){
        int flag = 0;
        StringBuilder sb = new StringBuilder();
        sb.append(email+",");
        sb.append(nome+",");
        sb.append(password+",");
        sb.append(morada+",");
        sb.append(this.getData_nascimento().get(Calendar.YEAR)+"-"+this.getData_nascimento().get(Calendar.MONTH)+"-"+this.getData_nascimento().get(Calendar.DAY_OF_MONTH)+",");
        for(Integer x : lista_imoveis){
            if(flag == 0){
                sb.append(x);
                flag = 1; 
            }else{
                sb.append(";"+x);
            }
        }
        flag = 0;
        sb.append(",");
        for(Integer x : favoritos){
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


