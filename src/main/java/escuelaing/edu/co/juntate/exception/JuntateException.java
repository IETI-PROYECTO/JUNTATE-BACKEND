package escuelaing.edu.co.juntate.exception;

public class JuntateException extends Exception{

    public static final String INVALID_REQUEST = "La solicitud es invalida";
    public static final String INCORRECT_DATA = "Los datos ingresados son invalidos"; 

    public static final String ARENA_NOT_FOUND = "La arena solicitada no se ha encontrado";
    public static final String ARENA_ALREADY_EXISTS = "La arena solicitada ya existe";
    public static final String ARENA_DELETE_EXCEPTION= "No se pudo eliminar la arena";

    
    public JuntateException(String message) {
        super(message);
    }

}