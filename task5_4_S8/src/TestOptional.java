import java.util.Optional;

public class TestOptional <T> {
    private final T value;

    public TestOptional(T value) {
        this.value = value;
    }

    public void someMethod(Object obj){
        T value0;
        T value1 = (T) obj;
        Optional<T> value2 = Optional.empty();
        T[] value3;
    }
}
