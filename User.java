import java.util.GregorianCalendar;
import java.util.ArrayList;
import java.util.Calendar;
import java.io.*;

public class User {
    public String email, nome, password, morada;
    public GregorianCalendar data_nascimento;

    public User(){
        this("","","","","");
    }
    public User(String email, String nome, String password, String morada, String data){
        this.email = email;
        this.nome = nome;
        this.password = password;
        this.morada = morada;
        this.data_nascimento = new GregorianCalendar(
                Integer.parseInt(data.split("-",3)[0]),
                Integer.parseInt(data.split("-",3)[1]),
                Integer.parseInt(data.split("-",3)[2])
                );
    }
    public User(User g){
        email = g.getEmail();
        nome = g.getNome();
        password = g.getPassword();
        morada = g.getMorada();
        data_nascimento = g.getData_nascimento();
    }

    public String getEmail() {
        return email;
    }
    public String getNome() {
        return nome;
    }
    public String getPassword() {
        return password;
    }
    public String getMorada() {
        return morada;
    }
    public GregorianCalendar getData_nascimento() {
        return data_nascimento;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setMorada(String morada) {
        this.morada = morada;
    }
    public void setData_nascimento(String data) {
        this.data_nascimento = new GregorianCalendar(Integer.parseInt(data.split("-",3)[0]),  Integer.parseInt(data.split("-",3)[1]), Integer.parseInt(data.split("-",3)[2]));
    }

    public User clone(){
        return new User(this);
    }

    public boolean equals(User utilizador){
        if(this == utilizador) return true;
        if((utilizador == null) 
            || (this.getClass() != utilizador.getClass())
        )
            return false;
        else{
            User u = (User) utilizador;
            return(this.email.equals(u.getEmail())
                    && this.nome.equals(u.getNome())
                    && this.password.equals(u.getPassword())
                    && this.morada.equals(u.getMorada())
                    && this.data_nascimento.equals(u.getData_nascimento())
            );
        }
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Email: ");
        sb.append(this.getEmail()+"\n");
        sb.append("Nome: ");
        sb.append(this.getNome()+"\n");
        sb.append("Password: ");
        sb.append(this.getPassword()+"\n");
        sb.append("Morada: ");
        sb.append(this.getMorada()+"\n");
        sb.append("Data de nascimento :");
        sb.append(this.getData_nascimento().get(Calendar.DAY_OF_MONTH)+"/"+this.getData_nascimento().get(Calendar.MONTH)+"/"+this.getData_nascimento().get(Calendar.YEAR)+"\n");
        return sb.toString();
    }


}
