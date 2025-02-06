package escuelaing.edu.co.juntate.service.Exception;

public class JuntateException extends Exception {
    public static final String MISSING_PARAMETERS = "Missing parameters";
    public JuntateException(String message) {
        super(message);
    }
    
}
