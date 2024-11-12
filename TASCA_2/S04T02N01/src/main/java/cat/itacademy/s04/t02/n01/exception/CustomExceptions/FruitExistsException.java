package cat.itacademy.s04.t02.n01.exception.CustomExceptions;

public class FruitExistsException extends RuntimeException {
    public FruitExistsException(String message){
        super(message);
    }
}
