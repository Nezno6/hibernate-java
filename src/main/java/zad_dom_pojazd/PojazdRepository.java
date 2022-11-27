package zad_dom_pojazd;

import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PojazdRepository {
    public static void persist(Pojazd pojazdData) {

        try (Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(pojazdData);
            transaction.commit();
            System.out.println("Dodano pojazd: " + pojazdData);
        } catch (Exception ioe) {
            System.err.println("Błąd bazy persistant: " + ioe);
        }
    }

    public static void merge(Pojazd pojazd) {
        try (Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(pojazd);
            transaction.commit();
            System.out.println("Zaktualizowano pojazd: " + pojazd);
        } catch (Exception ioe) {
            System.err.println("Pojazd o podanym id nie istnieje: " + ioe);
        }
    }

    public static void view() {
        try (Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()) {
            TypedQuery<Pojazd> zapytanie = session.createQuery("FROM Pojazd", Pojazd.class);
            List<Pojazd> listaWszystkichPojazdow = zapytanie.getResultList();
            for (Pojazd pojazd : listaWszystkichPojazdow) {
                System.out.println("Lista dostępnych pojazdow " + pojazd);
            }
        } catch (Exception ioe) {
            System.err.println("Błąd bazy view: " + ioe);
        }
    }

    public static void search(long id){
        try (Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()){
                Pojazd pojazd = session.get(Pojazd.class, id);
                if (pojazd == null){
                    System.err.println("Nie znaleziono pojazdu");
                }else{
                    System.out.println("Pojazd: " + pojazd);
                }
            } catch (Exception ioe) {
            // jeśli złapiemy błąd, to wywoła się catch
            System.err.println("Błąd bazy search: " + ioe);
        }

    }

    public static void del(long id) {
        try (
                Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Pojazd pojazd = session.get(Pojazd.class, id);

            if (pojazd != null) {
                session.remove(pojazd);
                System.out.println("Usuniety pojazd" + pojazd);
            } else{
                System.out.println("Brak pojazdu o podanym id");
            }

        } catch (Exception ioe) {
            // jeśli złapiemy błąd, to wywoła się catch
            System.err.println("Błąd bazy del" + ioe);
        }
    }
}
