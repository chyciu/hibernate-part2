/*
 * przyklad3 hibernate
 * przyklad stosowania delete() obiektu Session, czyli usuwanie danych*/
package sda.hibernate.przyklad3;

import org.hibernate.Session;
import sda.hibernate.HibernateUtil;
import sda.hibernate.entity.Bankomat;
import sda.hibernate.entity.Uzytkownik;

public class przyklad3 {

    public static void main(String[] arg) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Uzytkownik uzytkownik1 = new Uzytkownik();
        uzytkownik1.setImie("Robert");
        uzytkownik1.setNazwisko("user1");
        Uzytkownik uzytkownik2 = new Uzytkownik();
        uzytkownik2.setImie("ALA");
        uzytkownik2.setNazwisko("user2");
        Bankomat bankomat1 = new Bankomat();
        bankomat1.setAdres("adres bankomatu 1");
        bankomat1.getUzytkownicy().add(uzytkownik1);
        bankomat1.getUzytkownicy().add(uzytkownik2);
        Bankomat bankomat2 = new Bankomat();
        bankomat2.setAdres("adres drugiego bankomatu");
        bankomat2.getUzytkownicy().add(uzytkownik1);
        bankomat2.getUzytkownicy().add(uzytkownik2);
        session.persist(bankomat1);
        session.persist(bankomat2);
        session.flush();
        session.close();
    }
}
