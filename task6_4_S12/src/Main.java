import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {
        List<T> listT = stream.collect(Collectors.toList());
        if(0 == listT.size()) {
            minMaxConsumer.accept(null, null);
        }else{
            listT.sort(order);
            minMaxConsumer.accept(listT.get(0),listT.get(listT.size()-1));
        }
    }
    public static void main(String[] args){
        // задача оказалось столь проста, что даже проверка не понадобилась. Быть может потом допишу проверку.
    }
}
