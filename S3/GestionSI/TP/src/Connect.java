import java.io.File;
import java.sql.*;

public class Connect {
    public static Connection seConnecter() {

        String url = "jdbc:postgresql://database-etudiants.iut.univ-paris8.fr/wjacques";
        try {
            Connection connexion = DriverManager.getConnection(url, "wjacques", "mdp");
            System.out.println("connexion réussie");
            return connexion;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}
