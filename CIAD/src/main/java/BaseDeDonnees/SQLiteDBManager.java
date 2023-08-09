/*
 * nom         : SQLiteDBManager
 * 
 * description : Cette classe nous permet de lire et de modifier notre base de données en SQLite.
 *               Notre base de données stocke toutes les intéractions entre protéines lors d'une 
 *               collision binaiure entre elles.
 * 
 * Date        : 07/08/2023
 * 
 * Copyright   : Qaeze Noel
 */

package BaseDeDonnees;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;

public class SQLiteDBManager {
	
	//Attributs
    private static final String DB_URL = "jdbc:sqlite:mydatabase.db";

    //Methodes
    public static void createDatabase() {
    	// création d'une base de donnnées
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement()) {

            // Créer une table
            String createTableSQL = "CREATE TABLE IF NOT EXISTS Collisions ("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "ProteineA TEXT NOT NULL,"
                    + "ProteineB TEXT NOT NULL,"
                    + "Collision TEXT NOT NULL);";

            stmt.executeUpdate(createTableSQL);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    /*
     * Cette fonction ajoute d'une collision dans la base données
     */
    public static void insertCollision(String ProtA, String ProtB, String Collision) {
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement("INSERT INTO Collisions (ProteineA, ProteineB, Collision) VALUES (?, ?, ?)")) {

            String selectSQL = "SELECT COUNT(*) FROM Collisions WHERE (ProteineA = ? AND ProteineB = ?) OR (ProteineA = ? AND ProteineB = ?);";
            PreparedStatement countStmt = conn.prepareStatement(selectSQL);
            countStmt.setString(1, ProtA);
            countStmt.setString(2, ProtB);
            countStmt.setString(3, ProtB);
            countStmt.setString(4, ProtA);
            ResultSet resultSet = countStmt.executeQuery();

            // Récupérer le résultat de la requête
            if (resultSet.next()) {
                int rowCount = resultSet.getInt(1);
                if (rowCount > 0) {
                    // La collision existe déjà
                    System.out.println("La collision existe déjà !");
                } else {
                    // La collision n'existe pas encore, vous pouvez procéder à l'insertion
                    pstmt.setString(1, ProtA);
                    pstmt.setString(2, ProtB);
                    pstmt.setString(3, Collision);
                    pstmt.executeUpdate();
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    /*
     * Cette fonction récupère la liste de toutes les protéines dans la base de données sans les doublons
     */
    public static ArrayList<String> getProteines(){
    	ArrayList<String> ListeDeProteines = new ArrayList<>();
    	ListeDeProteines.addAll(getColonne("ProteineA"));
    	ListeDeProteines.addAll(getColonne("ProteineB"));
    	
    	HashSet<String> set  =  new HashSet<>(ListeDeProteines);
    	
    	return new ArrayList<>(set);
    	
    }
    
    /*
     * Cette fonction vérifie si une protéine est présente dans la BDD (Base de Données)
     */
    public static boolean SearchProtein(String proteine) {
    	ArrayList<String> Liste = getProteines(); 
    	
    	for(String prot : Liste) {
    		if(prot.equals(proteine)) {
    			return true;
    		}
    	}
    	return false;
    }
    
    public static ArrayList<String> getColonne(String colonne){
    	ArrayList<String> ListeDeProteines = new ArrayList<>();
    	try (Connection conn = DriverManager.getConnection(DB_URL);
                Statement stmt = conn.createStatement()) {

               String select = "SELECT "+colonne+" FROM Collisions;";

               ResultSet resultSet = stmt.executeQuery(select);

               while(resultSet.next()) {
            	   String value = resultSet.getString(colonne);
            	   
        		   ListeDeProteines.add(value);
            	   
               }
               
           } catch (SQLException e) {
               e.printStackTrace();
           }
    	return ListeDeProteines;
    }

    /*
     * Cette fonction récupère la collision entre deux protéines
     */
    public static ArrayList<String> getCollision(String ProtA, String ProtB) {
        ArrayList<String> collisions = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement()) {

            String select = "SELECT Collision FROM Collisions WHERE ProteineA = '" + ProtA + "' AND ProteineB = '" + ProtB + "' OR ProteineA = '" + ProtB + "' AND ProteineB = '" + ProtA + "';";

            ResultSet resultSet = stmt.executeQuery(select);

            if (resultSet.next()) {
                // On note que les collisions sont enregistrées dans la base de données de la forme "ProtA#ProtB#ProtC"
                // Pour cette exemple, il s'agit d'une division
                String[] collisionArray = resultSet.getString(1).split("#");
                for (String collision : collisionArray) {
                    collisions.add(collision);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return collisions;
    }
    
    /*
     * Cette fonction ajoute une protéine dans la base de données
     */
    public static void AjoutProteine(String nom, String Division, String Fusion) {
    	if(!Division.isEmpty()) {
    		String Proteines[] = Division.split("#");
    		String division = "";
    		for(int i=1; i<Proteines.length; i++) {
    			division += "#"+Proteines[i];
    		}
    		insertCollision(nom, Proteines[0], division);
    	}
    	
    	if(!Fusion.isEmpty()) {
    		String Proteines[] = Fusion.split("#");
    		insertCollision(nom, Proteines[0], Proteines[1]);
    	}
    	
    }
	

}
