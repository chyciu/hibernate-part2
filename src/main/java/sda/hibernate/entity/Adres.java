package sda.hibernate.entity;

import javax.persistence.*;

@Entity
@Table(schema = "bank", name = "adres")
public class Adres {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;
    @Column
    private String ulica;
    @Column
    private String nrDomu;
    @Column
    private String nrMieszkania;
    @Column
    private String miejscowosc;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idUzytkownika", unique = true)
    //Strona posiadajaca relacje
    private Uzytkownik uzytkownik;

    public Adres() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getNrDomu() {
        return nrDomu;
    }

    public void setNrDomu(String nrDomu) {
        this.nrDomu = nrDomu;
    }

    public String getNrMieszkania() {
        return nrMieszkania;
    }

    public void setNrMieszkania(String nrMieszkania) {
        this.nrMieszkania = nrMieszkania;
    }

    public String getMiejscowosc() {
        return miejscowosc;
    }

    public void setMiejscowosc(String miejscowosc) {
        this.miejscowosc = miejscowosc;
    }

    public Uzytkownik getUzytkownik() {
        return uzytkownik;
    }

    public void setUzytkownik(Uzytkownik uzytkownik) {
        this.uzytkownik = uzytkownik;
    }
}
