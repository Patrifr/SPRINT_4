package cat.itacademy.s04.t02.n02.exception.CustomExceptions;

public class FruitExistsException extends RuntimeException {
    public FruitExistsException(String message){
        super(message);
    }
}
