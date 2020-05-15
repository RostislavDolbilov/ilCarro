package ilcarro.exeptions;

/* @author Rostislav Dolbilov */

public class ActionDeniedException extends Throwable {
    public ActionDeniedException(String message) {
        super(message);
    }
    public ActionDeniedException(String message, Throwable cause) {
        super(message, cause);
    }
}
