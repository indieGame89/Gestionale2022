import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {

    public static void main(String [] args){

        Impiegati impQuery=new Impiegati("aaa","Fenu", 150);
        Scanner input=new Scanner(System.in);
        String nome, cognome;
        int eta;
        boolean flag=true;
        String serverURL= "jdbc:postgresql://localhost:5432/DB_Manager";
        String usr="postgres";
        String passw= "emandfp";

        //String SQL = "INSERT INTO impiegato.impiegati values ('eee','fff',38)";
        String SQL_Param = "INSERT INTO impiegato.impiegati values (?,?,?)";

        ArrayList<Impiegati> lista_impiegati=new ArrayList<>();

        DB_fake_dipenedenti db=new DB_fake_dipenedenti();

        try{

            Connection connessione= DriverManager.getConnection(serverURL, usr, passw);

            /*INSERIMENTO QUERY STATICA*/
            /*Statement query = connessione.createStatement();
            query.executeUpdate(SQL);*/

            /*INSERIMENTO QUERY PARAMETRICA*/
            PreparedStatement query = connessione.prepareStatement(SQL_Param);
            query.setString(1, impQuery.getNome());
            query.setString(2, impQuery.getCognome());
            query.setInt(3, impQuery.getEta());

            query.executeUpdate();
            connessione.close();

        } catch (SQLException e){

            e.printStackTrace();
        }


        /*

        do{
            System.out.println("_-ISERIMENTO-_");
            System.out.print("Nome > ");
            nome=input.next();
            System.out.flush();

            System.out.print("Cognome > ");
            cognome=input.next();
            System.out.flush();

            System.out.print("Eta > ");
            eta=input.nextInt();
            System.out.flush();

            System.out.println("Vuoi inserire un nuovo dip?");
            String risp=input.next();

            lista_impiegati.add(new Impiegati(nome, cognome, eta));

            if(risp.equalsIgnoreCase("n")){
                flag=false;
            }

        }while(flag);

        System.out.println("\n\nStampa lista");
        db.stampa_dipendenti(lista_impiegati);
        db.salvaNelDb(lista_impiegati);
       */
       }

}
