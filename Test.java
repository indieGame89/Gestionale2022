import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {


    public static void main(String [] args) throws SQLException {

        Database.getIstanza();
        Database.getConnessione();
        Database.chiudi_Connesione(Database.getConnessione());
    }

}
