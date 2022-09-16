package persistance;

import java.io.*;
import domain.*;

public abstract class ParchisIO {
    public static void salvar( File file, Parchis a) throws parchisException {
        try{
            ObjectOutputStream out = new ObjectOutputStream( new FileOutputStream( file ) );
            out.writeObject(a);
            out.close();
        }
        catch( Exception e){
            throw new parchisException("Error saving file: "+file.getName());
        }
    }

    public static void salvarO1( File file, Parchis a) throws parchisException {
        if ( file.getName().endsWith(".dat")){
            salvar(file,a);
        }
        else{
            throw new parchisException(parchisException.EXTENSION_NOT_DAT);
        }


    }
    public static Parchis abrir( File file ) throws parchisException {
        try{
            ObjectInputStream in = new ObjectInputStream( new FileInputStream(file));
            Parchis a = (Parchis)in.readObject();
            in.close();
            return a;
        }
        catch( Exception e){
            System.out.println(e);
            throw new parchisException("Error opening file "+file.getName());
        }

    }
    public static Parchis abrirO1( File file ) throws parchisException {
        if ( file.getName().endsWith(".dat")){
            return abrir( file );
        }
        else{
            throw new parchisException(parchisException.EXTENSION_NOT_DAT);
        }

    }
}
