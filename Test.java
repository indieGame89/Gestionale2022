import java.util.ArrayList;
import java.util.Scanner;

public class Test {

    public static void main(String [] args){

        Scanner input=new Scanner(System.in);
        String nome, cognome;
        int eta;
        boolean flag=true;

        ArrayList<Impiegati> lista_impiegati=new ArrayList<>();

        DB_fake_dipenedenti db=new DB_fake_dipenedenti();

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

    }

}
