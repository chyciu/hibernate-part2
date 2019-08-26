/*
 * przyklad2 hibernate
 * przyklad stosowania persist()-zawsze tworzy nowy obiekt i merge()- aktualizuje lub dodaje nowy obiekt obiektu Session*/

package sda.hibernate.przyklad2;

import org.hibernate.Session;
import sda.hibernate.HibernateUtil;
import sda.hibernate.entity.Adres;
import sda.hibernate.entity.Rachunek;
import sda.hibernate.entity.Uzytkownik;

public class przyklad2 {
    public static void main(String[] arg) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Uzytkownik nowyUzytkownik = new Uzytkownik();
        nowyUzytkownik.setImie("Robert");
        nowyUzytkownik.setNazwisko("Z kontem");
        //session.persist(nowyUzytkownik);
        Rachunek rachunek1=new Rachunek();
        rachunek1.setNrRachunku("00000000001");
        rachunek1.setStanKonta(1000L);
        rachunek1.setWlascicielRachunku(nowyUzytkownik);
        Rachunek rachunek2=new Rachunek();
        rachunek2.setNrRachunku("00000000002");
        rachunek2.setStanKonta(5000L);
        rachunek2.setWlascicielRachunku(nowyUzytkownik);
        Rachunek rachunek3=new Rachunek();
        rachunek3.setNrRachunku("00000000003");
        rachunek3.setStanKonta(100L);
        rachunek3.setWlascicielRachunku(nowyUzytkownik);
//        nowyUzytkownik.getKonta().add(rachunek1);
//        nowyUzytkownik.getKonta().add(rachunek2);
//        nowyUzytkownik.getKonta().add(rachunek3);
        session.persist(nowyUzytkownik);
        /*session.persist(rachunek1);
        session.persist(rachunek2);
        session.persist(rachunek3);*/
/*        Adres adres2=new Adres();
        adres2.setMiejscowosc("Gdyni");
        adres2.setNrDomu("11a");
        adres2.setNrMieszkania("2");
        adres2.setUlica("Sopocka");
        adres2.setUzytkownik(nowyUzytkownik);
        session.persist(adres2);*/
        session.flush();
        session.close();
    }
}
