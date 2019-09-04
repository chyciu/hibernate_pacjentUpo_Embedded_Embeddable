package rozwiazanie;

import org.hibernate.Session;

public class Zadanie1_rozwiazanie {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.close();
    }
}
