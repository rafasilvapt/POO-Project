import java.util.*;
import java.io.*;

public class Imoobiliaria{
    private TreeMap<Integer, Imovel> imoveis;
    private TreeMap<String, Actores> actores;
    private String logado;
    //public List<Consulta> coisita = new ArrayList<Consulta>();

    public Imoobiliaria(TreeMap<Integer, Imovel> imoveis, TreeMap<String, Actores> actores, String logado){
        this.imoveis = copiaTreeMapImovel(imoveis);
        this.actores = copiaTreeMapActores(actores);
        this.logado = logado;
    }
    
    public Imoobiliaria(){
        this.imoveis = new TreeMap<Integer, Imovel>();
        this.actores = new TreeMap<String, Actores>();
        this.logado = "";
    }
    
    public Imoobiliaria(Imoobiliaria imo){
        this.imoveis = imo.getImoveis();
        this.actores = imo.getActores();
        this.logado = imo.getLogado();
    }
    
    public TreeMap<Integer, Imovel> copiaTreeMapImovel(TreeMap<Integer, Imovel> cop){
        TreeMap<Integer, Imovel> novo = new TreeMap<Integer, Imovel>();
        
        for(Map.Entry<Integer, Imovel> entry : cop.entrySet()) {
            Integer key = entry.getKey();
            Imovel value = entry.getValue();
            
            novo.put(key, value);
        }
        return novo;
    }
    
    public TreeMap<Integer, Imovel> getImoveis(){
        return imoveis;
    }
    
    public TreeMap<String, Actores> getActores(){
        return actores;
    }

    public String getLogado(){
        return logado;
    }
    
    public TreeMap<String, Actores> copiaTreeMapActores(TreeMap<String, Actores> cop){
        TreeMap<String, Actores> novo = new TreeMap<String, Actores>();
        
        for(Map.Entry<String, Actores> entry : cop.entrySet()) {
            String key = entry.getKey();
            Actores value = entry.getValue();
            
            novo.put(key, value);
        }
        return novo;
    }

    // Registar um utilizador, quer vendedor, quer comprador
     //FEITO
    public void registarUtilizador(Actores utilizador) throws UtilizadorExistenteException{ 
        String email = utilizador.getEmail();
        /*try{*/
        if(!actores.containsKey(email)){
            actores.put(email, utilizador);
        }else{
            throw new UtilizadorExistenteException();
        }
        /*}catch(Exception e){
            int opcao = -1;
            while(opcao == -1){
                System.out.print('\f');
                System.out.println("Este utilizador já existe!");
                System.out.println("0- Sair");
                System.out.println("1- Voltar ao menu");
                opcao = sc.nextInt();
                if(opcao == 0){
                    Sair();
                }else if(opcao == 1){
                    Menu();
                }else{
                    opcao = -1;
                }
            }
        }*/
    }

    // Validar o acesso à aplicação utilizando as credenciais (email e password)
    //FEITO
    public void iniciaSessao(String email, String password) throws SemAutorizacaoException{
        if(logado.equals("")){
            if(actores.containsKey(email) && actores.get(email).getPassword().equals(password) && logado.equals("")){
                logado = email;
            }else{
                throw new SemAutorizacaoException("Utilzador  ou password não existente!");
            }
        }else{
            throw new SemAutorizacaoException();
        }  
    }

    // Fecha a sessão iniciada
    //FEITO
    public void fechaSessao(){
        logado = "";
    }
// Vendedores devidamente autenticados
    // Colocar um imóvel à venda
    //FEITO
    public void registaImovel(Imovel im) throws ImovelExisteException, SemAutorizacaoException{
        Actores vend = this.getActores().get(this.getLogado());
        
        if(vend.getClass().toString().equals("class Vendedor")){
            if(true){ // Condicao para verificar se o imovel 
                Integer chave = 1;
                if(!this.getImoveis().isEmpty()){
                    chave = this.getImoveis().lastKey()+1;
                }
                imoveis.put(chave, im);
                Vendedor k = (Vendedor)vend;
                k.getImoveis_mercado().add(chave);
                this.getImoveis().put(chave, im);
                
            }else{
                throw new ImovelExisteException();
            }
        }else{
            throw new SemAutorizacaoException();
        }
    }

    /*public <K, V extends Comparable<V>> Map<K, V> sortByValues(final Map<K, V> map) {
        Comparator<K> valueComparator =  new Comparator<K>() {
            public int compare(K k1, K k2) {
                int compare = map.get(k1).compareTo(map.get(k2));
                if (compare == 0) return 1;
                else return compare;
            }
        };
        Map<K, V> sortedByValues = new TreeMap<K, V>(valueComparator);
        sortedByValues.putAll(map);
        return sortedByValues;
    }

    // Visualizar uma lista com as datas (e emails, caso exista essa informação) das 10 últimas consultas aos imóveis que tem para venda
    // Não feito
    public List<Consulta> getConsultas()  throws SemAutorizacaoException{
        List<Consulta> co = new ArrayList<Consulta>();
        TreeMap<Integer, Integer> id_Cons = new TreeMap<Integer, Integer>();

        if(actores.get(logado).getClass().toString().equals("class Vendedor")){
            Set<Integer> keys = imoveis.keySet();
            for(Integer key: keys){
                Imovel k = imoveis.get(key);
                id_Cons.put(key, k.getConsultas());
            }
            
            Set<Integer> keyss = id_Cons.keySet();
            for(Integer key: keyss){
                Imovel k = imoveis.get(key);
                System.out.println(key + ": " + k.getConsultas());
                if(k instanceof Consulta){
                    co.add((Consulta) k.clone());
                }
            }

            try {
                Thread.sleep(10000);                 //1000 milliseconds is one second.
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }

        }else{
            throw new SemAutorizacaoException();
        }
        return co;
    }*/

    // Alterar o estado de um imóvel, de acordo com as acções feitas sobre ele
    // FEITO
    public void setEstado(String idImovel, String estado) throws ImovelInexistenteException,
                                                                 SemAutorizacaoException ,
                                                                 EstadoInvalidoException
    {
        if(estado.equals("vender")){
            Actores act = this.getActores().get(logado);
            if(act != null){    
                Vendedor c = (Vendedor)act;
                int indice = c.getImoveis_vendidos().indexOf(Integer.parseInt(idImovel));
                if(indice >= 0){
                    c.getImoveis_vendidos().remove(indice);
                    c.getImoveis_mercado().add(Integer.parseInt(idImovel));
                }
            }
        }else{
            if(estado.equals("vendido")){
                Actores act = this.getActores().get(logado);
                if(act != null){    
                    Vendedor c = (Vendedor)act;
                    int indice = c.getImoveis_mercado().indexOf(Integer.parseInt(idImovel));
                    if(indice >= 0){
                        c.getImoveis_mercado().remove(indice);
                        c.getImoveis_vendidos().add(Integer.parseInt(idImovel));
                    }
                }
            }
        }
        throw new ImovelInexistenteException();
    }

    // Obter um conjunto com os códigos dos imóveis mais consultados (ou seja, com mais de N consultas)
    public Set<String> getTopImoveis(int n){
        Set<String> topImoveis = new TreeSet<String>();
        
        Set<Integer> keys = this.getImoveis().keySet();
        for(Integer key: keys){
            Imovel im = this.getImoveis().get(key);
            if(im.getConsultas() > n){
                topImoveis.add(Integer.toString(key));
            }
        }

        return topImoveis;
    }

// Todos os utilizadores
    // Consultar a lista de todos os imóveis de um dado tipo (Terreno, Moradia, etc.) e até um certo preço
    public ArrayList<Imovel> getImovel(String classe, int preco){
        ArrayList<Imovel> im = new ArrayList<Imovel>();
        for (Imovel k : imoveis.values()) {
            if(k.getClass().toString().equals("class "+classe) && k.getPreco_pedido() <= preco){
                /*if(this.getActores().getClass().toString().equals("class Vendedor")){
                    if(this.getImoveis().get(this.getActores().get(this.getLogado()).getImoveis_mercado()).contais(k.getID())){
                        im.add(k);
                    }
                }else if(this.getActores().getClass().toString().equals("class Comprador")){
                    if(this.getImoveis().get(this.getActores().get(this.getLogado()).getLista_imoveis()).contais(k.getID())){
                        im.add(k);
                    }
                }*/
                im.add(k);
            }
        }
        return im;
    }
    
    // Consultar a lista de todos os imóveis habitáveis (até um certo preço)
    public ArrayList<Imovel> getHabitaveis(int preco){
        ArrayList<Imovel> habitaveis = new ArrayList<Imovel>();
        for (Imovel k : imoveis.values()) {
            if(k.getClass().toString().equals("class Moradia") && k.getPreco_pedido() <= preco){
                habitaveis.add(k);
            }
            if(k.getClass().toString().equals("class Apartamento") && k.getPreco_pedido() <= preco){
                habitaveis.add(k);
            }
            if(k.getClass().toString().equals("class LojaHabitavel") && k.getPreco_pedido() <= preco){
                habitaveis.add(k);
            }
            /*if(k.getClass().toString().equals("class Terreno") && k.getTipo().equals("Habitação") && k.getPreco_pedido() <= preco){
                habitaveis.add(k);}
           }*/
        }

        return habitaveis;
    }
    
    // Obter um mapeamento entre todos os imóveis e respectivos vendedores
    public TreeMap<Imovel, Vendedor> getMapeamentoImoveis(){
        TreeMap<Imovel, Vendedor> mapeamento = new TreeMap<Imovel, Vendedor>(new Comparator<Imovel>()
            {
                public int compare(Imovel i1, Imovel i2)
                {
                    if(i1 != null && i2 != null){
                        return i1.getRua().compareTo(i2.getRua());
                    }else{
                        return 0;
                    }
                        
                } 
        });
        Set<String> keys = this.getActores().keySet();
        for(String key: keys){
            Actores act = this.getActores().get(key);
            if(act.getClass().toString().equals("class Vendedor")){
                Vendedor c = (Vendedor)act;
                for(Integer x : c.getImoveis_mercado()){
                    mapeamento.put(imoveis.get(x), c);
                }
                for(Integer x : c.getImoveis_vendidos()){
                    mapeamento.put(imoveis.get(x), c);
                }
            }
        }
        return mapeamento;
    }

// Compradores registados
    // Marcar um imóvel como favorito
    public void setFavorito(String idImovel) throws ImovelInexistenteException ,
                                                    SemAutorizacaoException
    {
        Integer id = Integer.parseInt(idImovel);
        if(imoveis.containsKey(id)){
            Actores act = this.getActores().get(this.getLogado());
            if(act.getClass().toString().equals("class Comprador")){
                Comprador c = (Comprador)act;
                c.getFavoritos().add(id);
            }else{
                throw new SemAutorizacaoException();
            }
        }else{
            throw new ImovelInexistenteException();
        }
    }

    // Consultar imóveis favoritos ordenados por preço
    public TreeSet<Imovel> getFavoritos() throws SemAutorizacaoException{
        TreeSet<Imovel> favoritos = new TreeSet<Imovel>();

        Actores act = this.getActores().get(this.getLogado());
        if(act.getClass().toString().equals("class Comprador")){
            Comprador c = (Comprador)act;
            for(Integer x : c.getFavoritos()){
                Imovel im = this.getImoveis().get(x);
                favoritos.add(im);
            }        
        }else{
            throw new SemAutorizacaoException();
        }

        return favoritos;
    }

}
