import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

    /**DB_SINGLETON**/

    private static Database db_istanza;
    private static Connection connesione;
    private static Statement query;

    private Database(){}

    public static Database getIstanza(){

        if(db_istanza == null){

            db_istanza=new Database();

        }

        return db_istanza;
    }

    public static Connection getConnessione() throws SQLException {

        if(connesione == null || connesione.isClosed()){
           //try{
                String serverURL= "jdbc:postgresql://localhost:5432/DB_Manager";
                String usr="postgres";
                String passw= "emandfp";

                connesione= DriverManager.getConnection(serverURL, usr, passw);

           // }catch(SQLException e){
                //e.printStackTrace();
            //}
        }

        return connesione;
    }

    public static void chiudi_Connesione(Connection una_connesione){

        try{

            una_connesione.close(); //chiudere la connessione

        }catch(SQLException e){

            e.printStackTrace();
        }
    }
}
