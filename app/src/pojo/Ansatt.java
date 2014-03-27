package pojo;

/**
 * Created by fabi on 27.03.14.
 */
public class Ansatt {
    private Integer id;
    private String forNavn;
    private String etterNavn;
    private String epostAdresse;
    private String kontor;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getEpostAdresse() {
        return epostAdresse;
    }

    public void setEpostAdresse(String epostAdresse) {
        this.epostAdresse = epostAdresse;
    }

    public String getKontor() {
        return kontor;
    }

    public void setKontor(String kontor) {
        this.kontor = kontor;
    }
}
