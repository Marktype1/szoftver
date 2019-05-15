package model.DAO;

import javax.persistence.*;

@Entity
@Table(name = "Foglalas")
public class Foglalas {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "datum")
    private String datum;

    @Column(name = "film")
    private String film;

    @Column(name = "vezeteknev")
    private String vezeteknev;

    @Column(name = "keresztnev")
    private String keresztnev;

    @Column(name = "email")
    private String mail;

    @Column(name = "telefonszam")
    private String nr;

    @Column(name = "placeId")
    private int placeId;

    public Foglalas(String vezeteknev, String keresztnev, String mail, String nr, String film, String datum, int id) {
        this.vezeteknev = vezeteknev;
        this.keresztnev = keresztnev;
        this.mail = mail;
        this.nr = nr;
        this.film = film;
        this.datum = datum;
        this.placeId = id;
    }

    public Foglalas() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVezeteknev() {
        return vezeteknev;
    }

    public void setVezeteknev(String vezeteknev) {
        this.vezeteknev = vezeteknev;
    }

    public String getKeresztnev() {
        return keresztnev;
    }

    public void setKeresztnev(String keresztnev) {
        this.keresztnev = keresztnev;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getNr() {
        return nr;
    }

    public void setNr(String nr) {
        this.nr = nr;
    }

    public String getFilm() {
        return film;
    }

    public void setFilm(String film) {
        this.film = film;
    }


    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public int getPlaceId() {
        return placeId;
    }

    public void setPlaceId(int placeId) {
        this.placeId = placeId;
    }
}
