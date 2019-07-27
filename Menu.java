import java.util.*;
import java.io.*;

public class Menu {
    public Scanner sc = new Scanner(System.in);
    public String erros = "";
    public Imoobiliaria imo = initApp();
    
    public Menu(){
        Main();
    }
    
    public void Main(){
        Menu();
    }

    public Imoobiliaria initApp(){ //FEITO
        Imoobiliaria imo = new Imoobiliaria();
        ArrayList<String> texto = new ArrayList<String>();
        try{
            FileInputStream entrada = new FileInputStream("BaseDados.txt");
            InputStreamReader entradaFormatada = new InputStreamReader(entrada);
            BufferedReader entradaString = new BufferedReader(entradaFormatada);
            String linha = entradaString.readLine();
            while(linha != null){
                texto.add(linha);
                linha = entradaString.readLine();
            }
        }catch(Exception e){
            System.out.println("Ocurreu um erro a ler o ficheiro.");
            System.out.println("-> " + e);
        }  
        
        for (String x : texto) {
            Integer i = 0;
            if(imo.getImoveis().isEmpty()){
                i = 1;
            }else{
                i = imo.getImoveis().lastKey() + 1;
            }
            String[] tokens = x.split(">");

            if(tokens.length == 2){
                String[] valores = tokens[1].split(",");
                if(tokens[0].equals("Moradia")){
                    if(valores.length == 12){
                        String rua = valores[0];
                        Double pp = 0.0, pa = 0.0, ai = 0.0, atc = 0.0, ate = 0.0;
                        Integer consultas = 0, nq = 0, nwc = 0, np = 0, id = 0;
                        try{
                            pp = Double.parseDouble(valores[1]);
                        }catch(Exception e){
                            
                        }
                        try{
                            pa = Double.parseDouble(valores[2]);
                        }catch(Exception e){
                            
                        }
                        try{
                            consultas = Integer.parseInt(valores[3]);
                        }catch(Exception e){
                            
                        }
                        String tipo = valores[4];
                        try{
                            ai = Double.parseDouble(valores[5]);
                        }catch(Exception e){
                            
                        }
                        try{
                            atc = Double.parseDouble(valores[6]);
                        }catch(Exception e){
                            
                        }
                        try{
                            ate = Double.parseDouble(valores[7]);
                        }catch(Exception e){
                            
                        }
                        try{
                            nq = Integer.parseInt(valores[8]);
                        }catch(Exception e){
                            
                        }
                        try{
                            nwc = Integer.parseInt(valores[9]);
                        }catch(Exception e){
                            
                        }
                        try{
                            np = Integer.parseInt(valores[10]);
                        }catch(Exception e){
                            
                        }
                        try{
                            id = Integer.parseInt(valores[11]);
                        }catch(Exception e){
                            
                        }
                        Moradia m = new Moradia(rua, pp, pa, consultas, id, tipo, ai, atc, ate, nq, nwc, np);
                        imo.getImoveis().put(id, m);
                    }
                }else if (tokens[0].equals("Terreno")) {
                    if(valores.length == 10){
                        String rua = valores[0];
                        Double pp = 0.0, pa = 0.0,ac = 0.0,dc = 0.0;
                        Integer consultas = 0,kWh  = 0, id = 0;
                        Boolean ae =false;

                        try{
                            pp = Double.parseDouble(valores[1]);
                        }catch(Exception e){
                            
                        }
                        try{
                            pa = Double.parseDouble(valores[2]);
                        }catch(Exception e){
                            
                        }
                        try{
                            consultas = Integer.parseInt(valores[3]);
                        }catch(Exception e){
                            
                        }
                        String tp = valores[4];
                        try{
                            ac = Double.parseDouble(valores[5]);
                        }catch(Exception e){
                            
                        }
                        try{
                            dc = Double.parseDouble(valores[6]);
                        }catch(Exception e){
                            
                        }
                        try{
                            kWh = Integer.parseInt(valores[7]);
                        }catch(Exception e){
                            
                        }
                        try{
                            ae = Boolean.parseBoolean(valores[8]);
                        }catch(Exception e){
                            
                        }
                        try{
                            id = Integer.parseInt(valores[9]);
                        }catch(Exception e){
                            
                        }
                        Terreno t = new Terreno(rua, pp, pa, consultas, id, tp, ac, dc, kWh, ae);
                        imo.getImoveis().put(id, t);
                    }
                }else if (tokens[0].equals("LojaHabitavel")) {
                    if(valores.length == 16){
                        String rua = valores[0];
                        Double precoPedido = 0.0, precoAceite = 0.0,area = 0.0,areaTotal = 0.0;
                        Integer consultas = 0,numPortaLoja = 0,numQuartos = 0,numWCS = 0,numPortaCasa = 0,andar = 0,id = 0;
                        try{
                            precoPedido = Double.parseDouble(valores[1]);
                        }catch(Exception e){
                            
                        }
                        try{
                            precoAceite = Double.parseDouble(valores[2]);
                        }catch(Exception e){
                            
                        }
                        try{
                            consultas = Integer.parseInt(valores[3]);
                        }catch(Exception e){
                            
                        }
                        try{
                            area = Double.parseDouble(valores[4]);
                        }catch(Exception e){
                            
                        }
                        boolean possuiWC = false;
                        if(valores[5].equals("true")){
                            possuiWC = true;
                        }                        
                        try{
                            numPortaLoja = Integer.parseInt(valores[6]);
                        }catch(Exception e){
                            
                        }
                        String tipoNegocio = valores[7];
                        String tipo = valores[8];
                        try{
                            areaTotal = Double.parseDouble(valores[9]);
                        }catch(Exception e){
                            
                        }
                        try{
                            numQuartos = Integer.parseInt(valores[10]);
                        }catch(Exception e){
                            
                        }
                        try{
                            numWCS = Integer.parseInt(valores[11]);
                        }catch(Exception e){
                            
                        }
                        try{
                            numPortaCasa = Integer.parseInt(valores[12]);
                        }catch(Exception e){
                            
                        }
                        try{
                            andar = Integer.parseInt(valores[13]);
                        }catch(Exception e){
                            
                        }
                        boolean possuiGaragem = false;
                        if(valores[14].equals("true")){
                            possuiGaragem = true;
                        }
                        try{
                            id = Integer.parseInt(valores[15]);
                        }catch(Exception e){
                            
                        }
                        LojaHabitavel lh = new LojaHabitavel(rua, precoPedido, precoAceite, consultas, id, area, 
                                                            possuiWC,numPortaLoja, tipoNegocio, tipo, areaTotal,
                                                            numQuartos, numWCS, numPortaCasa, andar, possuiGaragem);
                        imo.getImoveis().put(id, lh);
                    }
                }else if (tokens[0].equals("Loja")) {
                    if(valores.length == 9){
                        String rua = valores[0];
                        Double precoPedido = 0.0,precoAceite = 0.0,area = 0.0;
                        Integer consultas = 0,numPortaLoja = 0,id = 0;
                        try{
                            precoPedido = Double.parseDouble(valores[1]);
                        }catch(Exception e){
                            
                        }
                        try{
                            precoAceite = Double.parseDouble(valores[2]);
                        }catch(Exception e){
                            
                        }
                        try{
                            consultas = Integer.parseInt(valores[3]);
                        }catch(Exception e){
                            
                        }
                        try{
                            area = Double.parseDouble(valores[4]);
                        }catch(Exception e){
                            
                        }
                        boolean possuiWC = false;
                        if(valores[5].equals("true")){
                            possuiWC = true;
                        }                        
                        try{
                            numPortaLoja = Integer.parseInt(valores[6]);
                        }catch(Exception e){
                            
                        }
                        String tipoNegocio = valores[7];
                        try{
                            id = Integer.parseInt(valores[8]);
                        }catch(Exception e){
                            
                        }
                        Loja l = new Loja(rua, precoPedido, precoAceite, consultas, id, area, 
                                                            possuiWC,numPortaLoja, tipoNegocio);
                        imo.getImoveis().put(id, l);
                    }
                }else if (tokens[0].equals("Apartamento")) {
                    if(valores.length == 12){
                        String rua = valores[0];
                        Double precoPedido = 0.0,precoAceite = 0.0,areaTotal = 0.0;
                        Integer consultas = 0,numQuartos = 0,numWCS = 0,numPorta = 0,andar = 0,id = 0;
                        try{
                            precoPedido = Double.parseDouble(valores[1]);
                        }catch(Exception e){
                            
                        }
                        try{
                            precoAceite = Double.parseDouble(valores[2]);
                        }catch(Exception e){
                            
                        }
                        try{
                            consultas = Integer.parseInt(valores[3]);
                        }catch(Exception e){
                            
                        }
                        String tipo = valores[4];
                        try{
                            areaTotal = Double.parseDouble(valores[5]);
                        }catch(Exception e){
                            
                        }
                        try{
                            numQuartos = Integer.parseInt(valores[6]);
                        }catch(Exception e){
                            
                        }
                        try{
                            numWCS = Integer.parseInt(valores[7]);
                        }catch(Exception e){
                            
                        }
                        try{
                            numPorta = Integer.parseInt(valores[8]);
                        }catch(Exception e){
                            
                        }
                        try{
                            andar = Integer.parseInt(valores[9]);
                        }catch(Exception e){
                            
                        }
                        boolean possuiGaragem = false;
                        if(valores[10].equals("true")){
                            possuiGaragem = true;
                        }
                        try{
                            id = Integer.parseInt(valores[11]);
                        }catch(Exception e){
                            
                        }
                        Apartamento a = new Apartamento(rua, precoPedido, precoAceite, consultas, id, tipo, areaTotal, 
                                                        numQuartos, numWCS, numPorta, andar, possuiGaragem);
                        imo.getImoveis().put(id, a);
                    }
                }else if (tokens[0].equals("Comprador")) {
                    if(valores.length == 7){
                        String email = valores[0];
                        String nome = valores[1];
                        String password = valores[2];
                        String morada = valores[3];
                        String data = valores[4];
                        String l[] = valores[5].split(";");
                        ArrayList<Integer> lista_imoveis = new ArrayList<Integer>();
                        for(String elem : l){
                            lista_imoveis.add(Integer.parseInt(elem));
                        }
                        TreeSet<Integer> favoritos = new TreeSet<Integer>();
                        String li[] = valores[6].split(";");
                        for(String el : li){
                            favoritos.add(Integer.parseInt(el));
                        }
                        Comprador comprador = new Comprador(email,nome,password,morada,data,lista_imoveis,favoritos);
                        imo.getActores().put(email,comprador);
                    }
                }else if (tokens[0].equals("Vendedor")) {
                    if(valores.length ==7){
                        String email = valores[0];
                        String nome = valores[1];
                        String password = valores[2];
                        String morada = valores[3];
                        String data = valores[4];
                        String l1[] = valores[5].split(";");
                        String l2[] = valores[6].split(";");
                        ArrayList<Integer> imoveis_mercado = new ArrayList<Integer>();
                        ArrayList<Integer> imoveis_vendidos = new ArrayList<Integer>();
                        for(String ele : l1){
                            imoveis_mercado.add(Integer.parseInt(ele));
                        }
                        for(String elem : l2){
                            imoveis_vendidos.add(Integer.parseInt(elem));
                        }
                        Vendedor vendedor = new Vendedor(email,nome,password,morada,data,imoveis_mercado,imoveis_vendidos);
                        imo.getActores().put(email,vendedor);
                    }
                }
            }
        }
        return imo;
    }
    
    public void Menu(){
        Integer tipo = 1;
        int opcao = -1;
        String aviso = "";
        // Limpa o ecra
        System.out.println('\f');
        System.out.println("------------------------------------------------");
        System.out.println("|                   Bem Vindo                  |");
        System.out.println("| 0- Sair                                      |");
        System.out.println("| 1- Guardar                                   |");
        System.out.println("------------------------------------------------");
        if(!erros.equals(""))
            System.out.println(erros);


        if(imo.getLogado().equals("")){
            //System.out.println("logate burro");
            tipo = 1;
        }else{
            if (imo.getActores().get(imo.getLogado()).getClass().toString().equals("class Vendedor")) {
            //System.out.println("vendedor logated");
            tipo = 2;
            }else{
                if (imo.getActores().get(imo.getLogado()).getClass().toString().equals("class Comprador")){
                    //System.out.println("comprador logated");
                    tipo = 3;
                }
            }
        }
        
        /*if(!logado.equals("")){
            System.out.println(actores.get(logado).getClass().toString());
        }*/

        // Sem sessão iniciada
        if(tipo == 1){
            System.out.println("------------------------------------------------");
            System.out.println("|             Sem sessão iniciada              |");
            System.out.println("------------------------------------------------");
            System.out.println("| 2- Registar Utilizador                       |"); //FEITO
            System.out.println("| 3- Iniciar Sessão                            |"); //FEITO
            System.out.println("------------------------------------------------"); 
            System.out.println("| 4- Consultar lista de imóveis de certo tipo  |"); //FEITO
            System.out.println("| 5- Consultar lista de imóveis habitáveis     |"); //FEITO
            System.out.println("| 6- Mapeamento imóveis/vendedor               |"); //FEITO MAS NÃO MOSTRA NADA
            System.out.println("------------------------------------------------");
            opcao = -1;
            while(opcao == -1) {
                opcao = sc.nextInt();
                sc.nextLine();
                switch (opcao) {
                    case 0: Sair();
                        break;
                    case 1: save();
                        break;
                    case 2: System.out.print('\f');
                        Registar();
                        break;
                    case 3: System.out.print('\f');
                        Iniciar();
                        break;
                    case 4: System.out.print('\f');
                        imoveisCertoTipo();
                        break;
                    case 5: System.out.print('\f');
                        imoveisHabitaveis();
                        break;
                    case 6: System.out.print('\f');
                        imo.getMapeamentoImoveis();
                        break;
                    case 44: break;
                    default: System.out.println("Opção inválida, introduza novamente");
                             opcao = -1;
                        break;
                }
                if(opcao == 44){
                    break;
                }
            }
        }

    // Com sessão iniciada
        // Vendedores
        if(tipo == 2){
            System.out.println("------------------------------------------------");
            System.out.println("|                    Vendedor                  |");
            System.out.println("------------------------------------------------");
            System.out.println("| 2- Registar Imovel                           |"); //FEITO
            System.out.println("| 3- Lista de Consulta de vendas               |"); //NÃO FEITO
            System.out.println("| 4- Alterar estado de imóvel                  |"); //FEITO
            System.out.println("| 5- Lista de imóveis mais consultados         |"); //NÃO FEITO
            System.out.println("| 6- Consultar lista de imóveis de certo tipo  |"); //FEITO MAS MUDAR OPCOES
            System.out.println("| 7- Consultar lista de imóveis habitáveis     |"); //FEITO
            System.out.println("| 8- Mapeamento imóveis/vendedor               |"); //FEITO MAS NÃO MOSTRA NADA
            System.out.println("------------------------------------------------");
            System.out.println("| 9- Fechar sessão                             |"); //FEITO
            System.out.println("------------------------------------------------");
            opcao = -1;
            while(opcao == -1) {
                opcao = sc.nextInt();
                sc.nextLine();
                switch (opcao) {
                    case 0: Sair();
                        break;
                    case 1: save();
                        break;
                    case 2: System.out.print('\f');
                        registarImovel();
                        break;
                    /*case 3: System.out.print('\f');
                        try{
                            getConsultas();
                        }catch(Exception e){                            NÃO FEITO!!!!!!!!!!!
                        }
                        break;*/
                    case 4: System.out.print('\f');
                        alteraEstado();
                        break;
                    case 5: System.out.print('\f');
                        listaMaisConsultados();
                        break;
                    case 6: System.out.print('\f');
                        imoveisCertoTipo();
                        break;
                    case 7: System.out.print('\f');
                        imoveisHabitaveis();
                        break;
                    case 8: System.out.print('\f');
                        imo.getMapeamentoImoveis();
                        break;
                    case 9: imo.fechaSessao();
                        break;
                    case 44: break;
                    default: System.out.println("Opção inválida, introduza novamente");
                             opcao = -1;
                        break;
                }
                if(opcao == 44){
                    break;
                }
            }
        }

        // Compradores
        if(tipo == 3){
            System.out.println("------------------------------------------------");
            System.out.println("|                   Comprador                  |");
            System.out.println("------------------------------------------------");
            System.out.println("| 2- Marcar imóvel como favorito               |"); //FEITO
            System.out.println("| 3- Consultar imóveis favoritos               |"); //FEITO MAS NÂO MOSTRA POR PREÇO
            System.out.println("| 4- Consultar lista de imóveis de certo tipo  |"); //FEITO MAS MUDAR OPCOES
            System.out.println("| 5- Consultar lista de imóveis habitáveis     |"); //FEITO
            System.out.println("| 6- Mapeamento imóveis/vendedor               |"); //FEITO MAS NÃO MOSTRA NADA
            System.out.println("------------------------------------------------");
            System.out.println("| 7- Fechar sessão                             |");
            System.out.println("------------------------------------------------");
            opcao = -1;
            while(opcao == -1) {
                opcao = sc.nextInt();
                sc.nextLine();
                switch (opcao) {
                    case 0: Sair();
                        break;
                    case 1: save();
                        break;
                    case 2: System.out.print('\f');
                        marcarFavorito();
                        break;
                    case 3: System.out.print('\f');
                            try{
                                imo.getFavoritos();
                            }catch(Exception e){
                            }
                        break;
                    case 4: System.out.print('\f');
                        imoveisCertoTipo();
                        break;
                    case 5: System.out.print('\f');
                        imoveisHabitaveis();
                        break;
                    case 6: System.out.print('\f');
                        imo.getMapeamentoImoveis();
                        break;
                    case 7: imo.fechaSessao();
                        break;
                    case 44: break;
                    default: System.out.println("Opção inválida, introduza novamente");
                             opcao = -1;
                        break;
                }
                if(opcao == 44){
                    break;
                }
            }
        }
        if(opcao != 44){
            Menu();
        }
    }
    
    // Menu da aplicação
    public void Registar(){
        String email, nome, password, morada, data;
        int op = 0;
        while(true){
            System.out.print('\f');
            System.out.println(erros);
            System.out.println("Pretende ser registado como?");
            System.out.println("1- Comprador");
            System.out.println("2- Vendedor");
            op = sc.nextInt();
            sc.nextLine();
            System.out.print('\f');
            System.out.println("Insira os seus dados.");
            if(op == 1){
                System.out.print("Email: ");
                email = sc.nextLine();
                System.out.print("Nome: ");
                nome = sc.nextLine();
                System.out.print("Password: ");
                password = sc.nextLine();
                System.out.print("Morada: ");
                morada = sc.nextLine();
                System.out.print("Data de nascimento (AA-MM-DD): ");
                data = sc.nextLine();
                try{
                    Comprador ut = new Comprador(email, nome, password, morada, data, new ArrayList<Integer>(), new TreeSet<Integer>());
                    imo.registarUtilizador(ut);
                    erros = "";
                    break;
                }catch(Exception e){
                    erros = "Ocorreu um erro a criar o utilizador!\n";
                }  
            }else if(op == 2){
                System.out.print("Email: ");
                email = sc.nextLine();
                System.out.print("Nome: ");
                nome = sc.nextLine();
                System.out.print("Password: ");
                password = sc.nextLine();
                System.out.print("Morada: ");
                morada = sc.nextLine();
                System.out.print("Data de nascimento (AA-MM-DD): ");
                data = sc.nextLine();   
                try{
                    Vendedor ut = new Vendedor(email, nome, password, morada, data, new ArrayList<Integer>(), new ArrayList<Integer>());
                    imo.registarUtilizador(ut);
                    erros = "";
                    break;
                }catch(Exception e){
                    erros = "Ocorreu um erro a criar o utilizador!\n";
                }
            }
        }        
             
    }

    public void Iniciar(){
        String email, pass;
        System.out.print('\f');
        System.out.println("Iniciar sessão.");
        System.out.print("Email: ");
        email = sc.nextLine();
        System.out.print("Password: ");
        pass = sc.nextLine();
        try{
            imo.iniciaSessao(email, pass);
            erros = "";
        }catch(Exception e){
           erros = "Utilizador ou password não existente!";
        }
    }
    
    public void ConsultarLista(){
        int j = 1;
        for (Imovel k : imo.getImoveis().values()) {
           System.out.println(j+"\t"+k.getClass().toString().split(" ")[1]+"\n"+k);
            j++;
        }
    }

    public void voltarAtras(){
        int op = 0;
        while(op != 1){
            System.out.println("1- Voltar Atrás.");
            op = sc.nextInt();
        }
    }

    

    public void Sair(){
        save(); //Para gravar sem mostrar
        System.exit(0);
    }

// Geral
    public void save(){
        try{
            PrintWriter writer = new PrintWriter("BaseDados.txt", "UTF-8");
            writer.print("");

            Set<Integer> keys = imo.getImoveis().keySet();
            for(Integer key: keys){
                Imovel k = imo.getImoveis().get(key);
                String tipoo = k.getClass().toString().split(" ")[1];
                if(tipoo.equals("Moradia")){
                    if(k != null){    
                        Moradia c = (Moradia)k;
                        writer.println(tipoo+">"+c.formatoGravar()+","+key);
                    }
                }else if(tipoo.equals("Terreno")){
                    if(k != null){    
                        Terreno c = (Terreno)k;
                        writer.println(tipoo+">"+c.formatoGravar()+","+key);
                    }
                }else if(tipoo.equals("Loja")){
                    if(k != null){    
                        Loja c = (Loja)k;
                        writer.println(tipoo+">"+c.formatoGravar()+","+key);
                    }
                }else if(tipoo.equals("LojaHabitavel")){
                    if(k != null){    
                        LojaHabitavel c = (LojaHabitavel)k;
                        writer.println(tipoo+">"+c.formatoGravar()+","+key);
                    }
                }else if(tipoo.equals("Apartamento")){
                    if(k != null){    
                        Apartamento c = (Apartamento)k;
                        writer.println(tipoo+">"+c.formatoGravar()+","+key);
                    }
                }
            }

            for (Actores k : imo.getActores().values()) {
                String tipoo = k.getClass().toString().split(" ")[1];
                writer.println(tipoo+">"+k);
            }
            writer.close();
        }catch(Exception e){
            
        }
    }
    
    private void registarImovel(){
        System.out.print('\f');
        System.out.println("-----------------------------------------");
        System.out.println("-------------Tipo de Imovel--------------");
        System.out.println("| 1-Apartamento                         |");
        System.out.println("| 2-Loja                                |");
        System.out.println("| 3-Terreno                             |");
        System.out.println("| 4-Moradia                             |");
        System.out.println("-----------------------------------------");
        
        int opcao = sc.nextInt();
        sc.nextLine();
        
        System.out.println("Insira rua: ");
        String rua = sc.nextLine();
        
        System.out.println("Insira preço pedido: ");
        double preco_pedido = sc.nextDouble();
        
        System.out.println("Insira preço aceite: ");
        double preco_aceite = sc.nextDouble();
        sc.nextLine();
        
        switch(opcao){ 
            case 1: //Apartamento
                int opt1 = 0;
                String tipo = "Simples";
                while(opt1 == 0){
                    System.out.println("Insira o tipo do Apartamento.");
                    System.out.println("1- Simples");
                    System.out.println("2- Duplex");
                    System.out.println("3- Triplex");
                    opt1 = sc.nextInt();
                    switch (opt1) {
                        case 1: tipo = "Simples";
                            break;
                        case 2: tipo = "Duplex";
                            break;
                        case 3: tipo = "Triplex";
                            break;
                        default: opt1 = 0;
                            break;
                    }
                }
                
                System.out.println("Insira area total: ");
                double area = sc.nextDouble();
                
                System.out.println("Insira numero de quartos: ");
                int quartos = sc.nextInt();
                
                System.out.println("Insira numero de WC's: ");
                int wcs = sc.nextInt();
                
                System.out.println("Insira numero de porta: ");
                int num_porta = sc.nextInt();
                
                System.out.println("Insira andar: ");
                int andar = sc.nextInt();
                
                System.out.println("Tem garagem? 1-Sim; 2-Nao;");
                int garagem = sc.nextInt();
                boolean possui_garagem = false;
                if(garagem==1){possui_garagem = true;}
                try{
                    imo.registaImovel(new Apartamento(rua,preco_pedido,preco_aceite,0,0,tipo,area,quartos,wcs,num_porta,andar,possui_garagem));
                }catch(Exception e){
                    
                }
                break;
            case 2: //Loja 
                System.out.println("Insira area total: ");
                double area2 = sc.nextDouble();
                
                System.out.println("Tem WC? 1-Sim; 2-Nao;");
                int wc = sc.nextInt();
                boolean possui_wc = false;
                if(wc==1){possui_wc = true;}
                
                System.out.println("Insira numero de porta: ");
                int num_porta2 = sc.nextInt();
                sc.nextLine();
                
                System.out.println("Tipo de negocio: ");
                String tipo_negocio = sc.nextLine();
                
                try{
                    imo.registaImovel(new Loja(rua,preco_pedido,preco_aceite,0,0,area2,possui_wc,num_porta2,tipo_negocio));
                }catch(Exception e){
                    
                }
                break;
            case 3: //Terreno
                System.out.println("Insira tipo: ");
                String tipo2 = sc.nextLine();
                
                System.out.println("Insira area de construção: ");
                double area_construcao = sc.nextDouble();
                
                System.out.println("Insira diametro da canalização: ");
                double diametro_canalizacao = sc.nextDouble();
                
                System.out.println("Insira capacidade da rede eletrica: ");
                int kWh_maximo = sc.nextInt();
                
                System.out.println("Tem acesso a esgotos? 1-Sim; 2-Não");
                int esgotos = sc.nextInt();
                boolean acesso_esgotos = false;
                if(esgotos == 1){acesso_esgotos = true;}
                
                try{
                    imo.registaImovel(new Terreno(rua,preco_pedido,preco_aceite,0,0,tipo2,area_construcao,diametro_canalizacao,kWh_maximo,acesso_esgotos));
                }catch(Exception e){
                    
                }
                break;
            case 4: //Moradia
                int opt2 = 0;
                String tipo3 = "Simples";
                while(opt2 == 0){
                    System.out.println("Insira o tipo do Apartamento.");
                    System.out.println("1- Isolada");
                    System.out.println("2- Geminada");
                    System.out.println("3- Banda");
                    System.out.println("4- Gaveto");
                    opt2 = sc.nextInt();
                    switch (opt2) {
                        case 1: tipo3 = "isolada";
                            break;
                        case 2: tipo3 = "geminada";
                            break;
                        case 3: tipo3 = "banda";
                            break;
                        case 4: tipo3 = "gaveto";
                            break;
                        default: opt2 = 0;
                            break;
                    }
                }
                
                System.out.println("Insira area de implantação ");
                double area_implantacao = sc.nextDouble();
                
                System.out.println("Insira area coberta");
                double area_coberta = sc.nextDouble();
                
                System.out.println("Insira area do terreno ");
                double area_terreno = sc.nextDouble();
                
                System.out.println("Insira numero de quartos ");
                int num_quartos = sc.nextInt();
                
                System.out.println("Insira numero de WC's ");
                int num_wcs2 = sc.nextInt();
                
                System.out.println("Insira numero de porta ");
                int num_porta3 = sc.nextInt();
                try{
                    imo.registaImovel(new Moradia(rua,preco_pedido,preco_aceite,0,0,tipo3,area_implantacao,area_coberta,area_terreno,num_quartos,num_wcs2,num_porta3));
                }catch(Exception e){
                    
                }
                break;
            case 5:
                System.out.println("Insira area total:");
                double area3 = sc.nextDouble();
                
                System.out.println("Tem WC? 1-Sim; 2-Nao;");
                int wc2 = sc.nextInt();
                boolean possui_wc2 = false;
                if(wc2==1){possui_wc2 = true;}
                
                System.out.println("Insira numero de porta:");
                int num_porta4 = sc.nextInt();
                
                System.out.println("Tipo de negocio:");
                String tipo_negocio2 = sc.nextLine();
                
                String tipo20 = "LojaHabitavel";
                System.out.println("Insira area total: \n");
                double area20 = sc.nextDouble();
                
                System.out.println("Insira numero de quartos: \n");
                int quartos20 = sc.nextInt();
                
                System.out.println("Insira numero de WC's: \n");
                int wcs20 = sc.nextInt();
                
                System.out.println("Insira numero de porta: \n");
                int num_porta20 = sc.nextInt();
                
                System.out.println("Insira andar: \n");
                int andar20 = sc.nextInt();
                
                System.out.println("Tem garagem? 1-Sim; 2-Nao;\n");
                int garagem20 = sc.nextInt();
                boolean possui_garagem20 = false;
                if(garagem20==1){possui_garagem = true;}
                
                try{
                    imo.registaImovel(new LojaHabitavel(rua,preco_pedido,preco_aceite,0,0,area3,possui_wc2,num_porta4,tipo_negocio2,tipo20,area20,quartos20,wcs20,num_porta20,andar20,possui_garagem20));
                }catch(Exception e){
                    
                }
                break;
            default:
                System.out.println("Imovel inserido invalido!");
                break;
        }
    }
  
    public void alteraEstado(){
        String est = ""; //vender / vendido
        String idI = "-1";
        int op = 0;
        try{
            System.out.print("Qual o id do imóvel que deseja alterar? ");
            idI = sc.nextLine();
            while(true){
                System.out.println("O que pretende fazer com o imóvel?\n1- Colocar à venda.\n2-Marcar como vendido.");
                op = sc.nextInt();
                if(op == 1){
                    est = "vender";
                    break;
                }else if(op == 2){
                    est = "vendido";
                    break;
                }
            }
            sc.nextLine();
            imo.setEstado(idI, est);//String idImovel, String vender/vendido
        }catch(Exception e){
            
        }
    }

    public void listaMaisConsultados(){
        Set<Integer> keys = imo.getImoveis().keySet();
        TreeSet<Integer> cons = new TreeSet<Integer>();
        for(Integer key: keys){
            Imovel act = imo.getImoveis().get(key);
            
            if(act.getClass().toString().equals("class Apartamento")){
                Apartamento c = (Apartamento)act;
                cons.add(c.getConsultas());
            }else if(act.getClass().toString().equals("class Loja")){
                Loja c = (Loja)act;
                cons.add(c.getConsultas());
            }else if(act.getClass().toString().equals("class LojaHabitavel")){
                LojaHabitavel c = (LojaHabitavel)act;
                cons.add(c.getConsultas());
            }else if(act.getClass().toString().equals("class Moradia")){
                Moradia c = (Moradia)act;
                cons.add(c.getConsultas());
            }else if(act.getClass().toString().equals("class Terreno")){
                Terreno c = (Terreno)act;
                cons.add(c.getConsultas());
            }
        }
    }
    public void imoveisCertoTipo(){
        int opcao = 0;
        String tipo = "";
        while(opcao == 0){
            System.out.println("Insira o tipo de imóvel.");
            System.out.println("1- Apartamento");
            System.out.println("2- Loja");
            System.out.println("3- Loja Habitavel");
            System.out.println("4- Moradia");
            System.out.println("5- Terreno");
            opcao = sc.nextInt();
            switch (opcao) {
                case 1: tipo = "Apartamento";
                    break;
                case 2: tipo = "Loja";
                    break;
                case 3: tipo = "LojaHabitavel";
                    break;
                case 4: tipo = "Moradia";
                    break;
                case 5: tipo = "Terreno";
                    break;
                default: opcao = 0;
                    break;
            }
        }
        

        
        System.out.print("Insira o preço máximo do imóvel: ");
        int preco = sc.nextInt();
        System.out.println('\f');
        for(Imovel i : imo.getImovel(tipo, preco)){
            System.out.print(i.getClass().toString().split(" ")[1]+".\tID:"+i.getID()+"\n"+i+"\n");
        }
        voltarAtras();
    }
    
    public void imoveisHabitaveis(){
        System.out.print("Insira o preço máximo: ");
        int preco = sc.nextInt();
        for(Imovel i : imo.getHabitaveis(preco)){
            if(i.getClass().toString().equals("class LojaHabitavel")){
                System.out.print("Loja Habitável.\tID:"+i.getID()+"\n"+i+"\n");
            }else{
                System.out.print(i.getClass()+"\tID:"+i.getID()+"\n"+i+"\n");
            }
        }
        voltarAtras();
    }

    public void marcarFavorito(){
        String idIm = "";
        System.out.print("Insira o id do imóvel para marcar como favorito: ");
        idIm = sc.nextLine();
        try{
            imo.setFavorito(idIm);
        }catch(Exception e){
            
        }
    }
}
