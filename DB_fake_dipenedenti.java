import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.io.File;

public class DB_fake_dipenedenti {

    String percorso = "Fake_DB";


    public DB_fake_dipenedenti(){

    }

    public void salvaNelDb(ArrayList<Impiegati> lista_impiegati){

        try {
            File file = new File(percorso);
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            for(Impiegati imp: lista_impiegati) {
                bw.write(imp.toString()+"\n");
            }
            bw.flush();
            bw.close();
        }
        catch(IOException e) {
            e.printStackTrace();
        }

    }

    public void stampa_dipendenti(ArrayList<Impiegati> lista_impiegati){

        for(Impiegati imp: lista_impiegati){

            System.out.println(imp+"\n");
        }

    }
}
