package model.DAO;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.exception.JDBCConnectionException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class FoglalasDAO {

    private static Logger logger = LogManager.getLogger(FoglalasDAO.class);

    private static EntityManagerFactory emf;
    private static EntityManager em;

    public FoglalasDAO() {
        emf = Persistence.createEntityManagerFactory("jpa-persistence-unit-1");
        em = emf.createEntityManager();
    }

    public void saveFoglalas(Foglalas foglalas) {
        try {
            em.getTransaction().begin();
            em.persist(foglalas);
            em.getTransaction().commit();
        } catch (NullPointerException e) {
            logger.warn("Connection not found. Exception: " + e);
            emf = Persistence.createEntityManagerFactory("jpa-persistence-unit-1");
            em = emf.createEntityManager();
        } catch (JDBCConnectionException e) {
            logger.warn("Connection not found. Exception: " + e);
        }
    }

    public static void close() {
        em.close();
        emf.close();
    }

    public ArrayList<Integer> readSzamitas(String s, String d) {
        if (s==null){
            s="Glass";
        }
        List<Integer> db=new ArrayList<>();
        List<Foglalas> query = em.createQuery("SELECT f FROM Foglalas f where f.film='"+s+"' and f.datum='"+d+"'", Foglalas.class).getResultList();
        for (int i = 0; i <query.size() ; i++) {
            db.add(query.get(i).getPlaceId());
        }
        return (ArrayList<Integer>) db;
    }


}
