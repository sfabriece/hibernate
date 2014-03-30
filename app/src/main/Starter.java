package main;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.Ansatt;
import pojo.Prosjekt;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by fabi on 27.03.14.
 */
public class Starter {
    public static void main(String[] args) {
        Starter st = new Starter();

        Ansatt a = new Ansatt("Fabriece", "Sumuni", "s@hotmail.com", "KE-E451c");
        //Ansatt b = new Ansatt("Avtor", "Han", "avt@gmail.com", "KE-E451b");
        Prosjekt p1 = new Prosjekt("go home", 1);
        //p1.addAnsatt(a);
        //p1.addAnsatt(b);
        //a.addProsjekt(p1);
        //b.addProsjekt(p1);

        st.addAnsatt(a);
        st.addProsjekt(p1);
        //st.addAnsatt(b);
        List<Ansatt> ansattList = st.getAnsatter();
        List<Prosjekt> prosjekts = st.getProsjekter();



        st.giveProsjekt(ansattList.get(0), prosjekts.get(0));



        //get data
        //st.getAnsatter();
        //st.getProsjekter();
        System.out.println(st.getJobberPaa(1l));

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.flush();
        session.close();
        System.exit(0);
    }

    private static String getJobberPaa(Long ansattnr){
        String resultat = "";
        String tjener = "jdbc:mysql://localhost/test";
        String bruker = "root";
        String passord = "developer";
        String sporring = "select distinct P.navn from ansatt A, jobber_paa J, prosjekt P "
                + "where J.ansattnr = A.ansattnr and "
                + "J.pid = P.prosjektid "
                + "and A.ansattnr = " + ansattnr;
        String prosjektnavn = "";
        Connection kobling = null;

        try {
            kobling = DriverManager.getConnection(tjener, bruker, passord);
            Statement sqlsetning = kobling.createStatement();
            ResultSet relasjon = sqlsetning.executeQuery(sporring);
            while (relasjon.next()) {
                prosjektnavn = relasjon.getString("navn");
                resultat += prosjektnavn + ", ";
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultat;
    }

    private void giveProsjekt(Ansatt a, Prosjekt p) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        trns = session.beginTransaction();

        session.update(a);
        session.update(p);

        a.addProsjekt(p);
        p.addAnsatt(a);

        trns.commit();
    }

    private List<Prosjekt> getProsjekter() {
        Transaction trns = null;
        List<Prosjekt> prosjekter = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            trns = session.beginTransaction();
            prosjekter = session.createQuery("from Prosjekt").list();
            for (Prosjekt p : prosjekter){
                System.out.println(p.getNavn() + " " + p.getNummer());
            }
            trns.commit();
            return prosjekter;
        }catch (RuntimeException e){
            e.printStackTrace();
        }finally {
            session.flush();
            session.close();
        }
        return prosjekter;
    }

    private void addAnsatt(Ansatt ansatt) {
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            transaction = session.beginTransaction();
            session.save(ansatt);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    private void addProsjekt(Prosjekt prosjekt) {
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();

            session.save(prosjekt);

            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    private List<Ansatt> getAnsatter() {
        Transaction trns = null;
        List<Ansatt> users = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            users = session.createQuery("from Ansatt").list();
            for (Ansatt ansatt : users) {
                System.out.println(ansatt.getForNavn() + " " + ansatt.getEpost());
            }
            trns.commit();
            return users;
        } catch (RuntimeException e) {
            e.printStackTrace();
        }finally {
            session.flush();
            session.close();
        }
        return users;
    }
}
