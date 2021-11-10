import java.sql.*;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    private static Connection connexion;
    private static Scanner scanner;

    public static void main(String[] args) throws SQLException {
        scanner = new Scanner(System.in);
        connexion = Connect.seConnecter();
        if (connexion == null) {
            System.exit(1);
        }

//        select();
        prepare();
    }

    private static void select() throws SQLException {
        Statement statement = connexion.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from desert");
        ResultSetMetaData rsmd = resultSet.getMetaData();
        int columnsNumber = rsmd.getColumnCount();
        System.out.println(columnsNumber);
        while (resultSet.next()) {
            for (int i = 1; i <= columnsNumber; i++) {
                if (i > 1) {
                    System.out.print(",  ");
                }
                String columnValue = resultSet.getString(i);
                System.out.print(rsmd.getColumnName(i) + ": " + columnValue);
            }
            System.out.println("");
        }
        statement.close();
    }

    private static void prepare() throws SQLException {
        HashMap<String, String> pays = new HashMap<>();
        pays.put("France", "F");
        pays.put("Germany", "D");
        pays.put("Russia", "R");
        pays.put("United Kingdom", "GB");
        for(String p : pays.keySet()) {
            System.out.println(p);
        }

        System.out.print("-- Choisissez un pays: ");
        String choix = scanner.nextLine();

        String sql = "select name from country where code in (select country2 from borders where ? = country1 UNION select country1 from borders where ? = country2)";
        PreparedStatement statement = connexion.prepareStatement(sql);
        statement.setString(1, pays.get(choix));
        statement.setString(2, pays.get(choix));
        ResultSet resultSet = statement.executeQuery();

        ResultSetMetaData rsmd = resultSet.getMetaData();
        int columnsNumber = rsmd.getColumnCount();
        while (resultSet.next()) {
            for (int i = 1; i <= columnsNumber; i++) {
                if (i > 1) {
                    System.out.print(",  ");
                }
                String columnValue = resultSet.getString(i);
                System.out.print("voisin: " + columnValue);
            }
            System.out.println("");
        }

        statement.close();
    }
}
