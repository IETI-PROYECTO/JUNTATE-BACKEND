package escuelaing.edu.co.juntate.exception;

public class EventException extends Exception {
    public static final String MISSING_PARAMETERS = "Missing parameters";
    public static final String EVENT_NOT_FOUND = "Event not found";
    public static final String INVALID_NUMBER_OF_PLAYERS = "Invalid number of players";
    public static final String ID_CANNOT_BE_CHANGED = "The id cannot be changed";
    
    public EventException(String message) {
        super(message);
    }
    
}
