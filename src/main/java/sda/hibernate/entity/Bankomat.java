package sda.hibernate.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(schema = "bank", name = "bankomat")
public class Bankomat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;
    @Column
    private String adres;

    @ManyToMany(cascade = CascadeType.ALL)
    //okreslamy wlasciciela relacji, jak tego nie zrobimy, hibernate utworzy nam2 tabele laczace
    @JoinTable(name="Bankomat_Uzytkownik",
            joinColumns=@JoinColumn(name="idBankomat"),
            inverseJoinColumns=@JoinColumn(name="idUzytkownik"))
    private List<Uzytkownik> uzytkownicy;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public List<Uzytkownik> getUzytkownicy() {
        if(uzytkownicy==null){
            uzytkownicy=new ArrayList<Uzytkownik>();
        }
        return uzytkownicy;
    }

    public void setUzytkownicy(List<Uzytkownik> uzytkownicy) {
        this.uzytkownicy = uzytkownicy;
    }

    public Bankomat() {
    }
}
