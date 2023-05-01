public class NotRegisteredException extends RuntimeException {

    public NotRegisteredException(String msg) {
        super("Player " + msg + " Не зарегестрирован");
    }
}
