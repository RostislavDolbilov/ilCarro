package ilcarro.exeptions;

public class ActionDeniedException extends Throwable {
    public ActionDeniedException(String message) {
        super(message);
    }
    public ActionDeniedException(String message, Throwable cause) {
        super(message, cause);
    }
}
