package somersames.exception;

/**
 * @author szh
 * @create 2019-01-13 14:23
 **/
public class TokenVaildException extends RuntimeException {
    public TokenVaildException() {
        super();
    }

    public TokenVaildException(String message) {
        super(message);
    }
}
