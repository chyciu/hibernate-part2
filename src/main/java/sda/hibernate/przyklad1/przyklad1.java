/*
 * przyklad1 hibernate
 * przyklad relacji 1-1*/

package sda.hibernate.przyklad1;

import org.hibernate.Session;
import sda.hibernate.HibernateUtil;
import sda.hibernate.entity.Adres;
import sda.hibernate.entity.Uzytkownik;

public class przyklad1 {

    public static void main(String[] arg) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Uzytkownik nowyUzytkownik = new Uzytkownik();
        nowyUzytkownik.setImie("Robert");
        nowyUzytkownik.setNazwisko("persist");
        //session.persist(nowyUzytkownik);
        Adres adres = new Adres();
        adres.setMiejscowosc("Sopot");
        adres.setNrDomu("1a");
        adres.setNrMieszkania("2");
        adres.setUlica("Piwna");
        adres.setUzytkownik(nowyUzytkownik);
        session.persist(adres);
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
