import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.io.ByteArrayInputStream;
import java.nio.charset.Charset;

public class Main {
    public static void main(String[] args) {
        // todo: Стереть тестовый блок
        // System.setIn(new ByteArrayInputStream("Мама мыла-мыла-мыла раму а а а а а а ы ы ы ы ы ы в в в в п п пп ппп пппппп ам ам ам ам!".getBytes(Charset.forName("UTF-8"))));
        System.setIn(new ByteArrayInputStream("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed sodales consectetur purus at faucibus. Donec mi quam, tempor vel ipsum non, faucibus suscipit massa. Morbi lacinia velit blandit tincidunt efficitur. Vestibulum eget metus imperdiet sapien laoreet faucibus. Nunc eget vehicula mauris, ac auctor lorem. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer vel odio nec mi tempor dignissim.".getBytes(Charset.forName("UTF-8"))));
        // конец тестового блока, стирать до сих
        try(Stream<String> streamIn = (new BufferedReader(new InputStreamReader(System.in)).lines())){
            streamIn
                    .map(String::toLowerCase)
                    .map(line -> line.split("[\\p{Punct}\\s]+"))
                    .flatMap(Arrays::stream)
                    .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                    .entrySet().stream().sorted(new Comparator<Map.Entry<String, Long>>() {
                    @Override
                    public int compare(Map.Entry<String, Long> t0, Map.Entry<String, Long> t1) {
                        if (0 == t0.getValue().compareTo(t1.getValue())) return t0.getKey().compareTo(t1.getKey());
                        else return t1.getValue().compareTo(t0.getValue());
                    }
                    })
                    .limit(10)
                    .forEach(e -> System.out.println(e.getKey()));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
