package model;

import controller.Controller;
import model.DAO.Foglalas;
import model.DAO.FoglalasDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CinemaModel {

    private static Logger logger = LogManager.getLogger(CinemaModel.class);

    private String film;

    private String datum;

    private FoglalasDAO dao;

    public CinemaModel() {
        dao = new FoglalasDAO();
    }

    public void foglalas(String vezeteknev, String keresztnev, String mail, String nr, int id) {
        logger.trace("foglalas-ban");
        if (nrIsInt(nr) && isvalidMail(mail) && isvalidFirstName(keresztnev) && isvalidLastName(vezeteknev) ) {
            Foglalas foglalas = new Foglalas(vezeteknev, keresztnev, mail, nr, film, datum, id);
            dao.saveFoglalas(foglalas);
        }else{
            System.out.println("Számot kell megadni'");
        }

    }

    public void setFilm(String film) {
        this.film = film;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public boolean nrIsInt(String nr){
        if ((nr.startsWith("+"))||(nr.startsWith("0"))) {
            try {
                Double.parseDouble(nr);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        }else{
            return false;
        }

    }

    public boolean isvalidMail(String mail){
        if(mail.contains("@")){
            return true;
        }else{
            return false;
        }
    }

    public boolean isvalidFirstName(String keresztnev){
        if(keresztnev.matches("[a-zA-Z]+")){
            return true;
        }else{
            return false;
        }
    }

    public boolean isvalidLastName(String vezeteknev){
        if(vezeteknev.matches("[a-zA-Z]+")){
            return true;
        }else{
            return false;
        }
    }


}
