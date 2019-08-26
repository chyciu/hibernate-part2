package sda.hibernate.entity;

import javax.persistence.*;

@Entity
@Table(schema = "bank", name = "rachunek")
public class Rachunek {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;
    @Column
    private String nrRachunku;
    @Column
    private Long stanKonta;

    @ManyToOne
    @JoinColumn(name = "idwlasciela")
    private Uzytkownik wlascicielRachunku;

    public Rachunek() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNrRachunku() {
        return nrRachunku;
    }

    public void setNrRachunku(String nrRachunku) {
        this.nrRachunku = nrRachunku;
    }

    public Long getStanKonta() {
        return stanKonta;
    }

    public void setStanKonta(Long stanKonta) {
        this.stanKonta = stanKonta;
    }

    public Uzytkownik getWlascicielRachunku() {
        return wlascicielRachunku;
    }

    public void setWlascicielRachunku(Uzytkownik wlascicielRachunku) {
        this.wlascicielRachunku = wlascicielRachunku;
    }
}
