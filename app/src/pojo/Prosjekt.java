package pojo;

/**
 * Created by fabi on 27.03.14.
 */
public class Prosjekt {
    private Integer id;
    private Integer eier;
    private String navn;
    private int nummer;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEier() {
        return eier;
    }

    public void setEier(Integer eier) {
        this.eier = eier;
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
