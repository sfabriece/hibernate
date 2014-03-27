package main;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.Ansatt;
import pojo.Prosjekt;

import java.util.Iterator;
import java.util.List;

/**
 * Created by fabi on 27.03.14.
 */
public class Starter {
    public static void main(String[] args) {
        Starter st = new Starter();

        st.addAnsatt("Fabriece", "Sumuni", "s@hotmail.com", "KE-E451c");
        st.addAnsatt("Avtor", "Han", "avt@gmail.com", "KE-E451b");

        st.addProsjekt("go home", 1, 2);
        st.addProsjekt("aba", 1, 1);

        //get data
        st.getAnsatt();

    }

    private void addAnsatt(String fornavn, String etternavn, String epost, String kontor) {
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            transaction = session.beginTransaction();
            Ansatt ansatt = new Ansatt();

            ansatt.setForNavn(fornavn);
            ansatt.setEtterNavn(etternavn);
            ansatt.setEpostAdresse(epost);
            ansatt.setKontor(kontor);

            session.save(ansatt);

            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }

    private void addProsjekt(String name, Integer nummer, Integer eier) {
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();

            Prosjekt p = new Prosjekt();
            p.setNavn(name);
            p.setNummer(nummer);
            p.setEier(eier);

            session.save(p);

            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }

    private void getAnsatt() {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            List<Ansatt> users = session.createQuery("from Ansatt as u ").list();
            for (Iterator<Ansatt> iter = users.iterator(); iter.hasNext(); ) {
                Ansatt ansatt = iter.next();
                System.out.println(ansatt.getForNavn() + " " + ansatt.getEpostAdresse());
            }
            trns.commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }
}
