package domain;

public class parchisException extends Exception{

    public static final String EXTENSION_NOT_DAT ="La extension del archivo no es  .dat";
    public static final String NUMERO_JUGADORES ="El numero de jugadores debe ser de 2 a 4";
    public static final String ERROR_MOVIMIENTO ="Error realizando el movimiento";

    public parchisException(String message){
        super(message);
    }
}