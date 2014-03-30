package pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by fabi on 27.03.14.
 */
public class Prosjekt {
    private Integer pid;
    private String navn;
    private int nummer;
    private Set<Ansatt> ansatter;

    public Prosjekt(){
        pid = null;
        ansatter = new HashSet<Ansatt>();
    }
    public Prosjekt(String navn, Integer nummer){
        this();
        this.navn = navn;
        this.nummer = nummer;
    }
    public void addAnsatt(Ansatt a){
        ansatter.add(a);
    }
    public Set<Ansatt> getAnsatter() {
        return ansatter;
    }

    public void setAnsatter(Set<Ansatt> ansatter) {
        this.ansatter = ansatter;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer id) {
        this.pid = id;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public int getNummer() {
        return nummer;
    }

    public void setNummer(int nummer) {
        this.nummer = nummer;
    }
}
