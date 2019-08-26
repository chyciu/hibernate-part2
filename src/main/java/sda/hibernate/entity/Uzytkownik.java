package sda.hibernate.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(schema = "bank", name = "uzytkownik")
public class Uzytkownik {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;
    @Column
    private String imie;
    @Column
    private String nazwisko;

    @OneToMany(mappedBy = "wlascicielRachunku",cascade = CascadeType.ALL)
    private List<Rachunek> konta;

    @OneToOne(mappedBy = "uzytkownik")
    private Adres adresZameldowania;

    @ManyToMany(mappedBy = "uzytkownicy")
    private List<Bankomat> bankomaty;

    public Adres getAdresZameldowania() {
        return adresZameldowania;
    }

    public void setAdresZameldowania(Adres adresZameldowania) {
        this.adresZameldowania = adresZameldowania;
    }

    public Uzytkownik() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }


    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public List<Rachunek> getKonta() {
        if(konta==null){
            konta = new ArrayList<Rachunek>();
        }
        return konta;
    }

    public void setKonta(List<Rachunek> konta) {
        this.konta = konta;
    }
}
