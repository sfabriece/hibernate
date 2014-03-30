package pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by fabi on 27.03.14.
 */
public class Ansatt {
    private Integer ansattID;
    private String forNavn;
    private String etterNavn;
    private String epost;
    private String kontor;
    private Set<Prosjekt> prosjekt;

    public Ansatt(){
        ansattID = null;
        prosjekt = new HashSet<Prosjekt>();
    }
    public Ansatt(String forNavn, String etterNavn, String epostAdresse, String kontor){
        this();
        this.forNavn = forNavn;
        this.etterNavn = etterNavn;
        this.epost = epostAdresse;
        this.kontor = kontor;
    }
    public Set<Prosjekt> getProsjekt() {
        return prosjekt;
    }

    public void setProsjekt(Set<Prosjekt> prosjekt) {
        this.prosjekt = prosjekt;
    }

    public void addProsjekt(Prosjekt p){
        prosjekt.add(p);
    }

    public Integer getAnsattID() {
        return ansattID;
    }

    public void setAnsattID(Integer ansattID) {
        this.ansattID = ansattID;
    }

    public String getForNavn() {
        return forNavn;
    }

    public void setForNavn(String forNavn) {
        this.forNavn = forNavn;
    }

    public String getEtterNavn() {
        return etterNavn;
    }

    public void setEtterNavn(String etterNavn) {
        this.etterNavn = etterNavn;
    }

    public String getEpost() {
        return epost;
    }

    public void setEpost(String epostAdresse) {
        this.epost = epostAdresse;
    }

    public String getKontor() {
        return kontor;
    }

    public void setKontor(String kontor) {
        this.kontor = kontor;
    }
}
