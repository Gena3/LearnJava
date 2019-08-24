import javax.swing.text.html.HTMLDocument;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class Main {

    public static void main(String[] args){
        Collection<?> collection = new ArrayList();
        Object object = null;
        collection.add(null);
        collection.add(null);
        // collection.add(object); // не работает
        PrintCollection(collection);
        System.out.println("remove(object) вернул: " + collection.remove(object));
        System.out.print("После remove(object). ");
        PrintCollection(collection);
        Object[] arrObj = collection.toArray();
        System.out.print("А теперь массив:");
        for (Object elem:arrObj) {
            System.out.print(" " + elem + ";");
        }
        System.out.println();
        System.out.println("contains(object) = " + collection.contains(object) + ", contains(null) = " + collection.contains(null) + ", contains(\"foo\") = " + collection.contains("foo"));
        collection.clear();
        System.out.print("А теперь после clear(). ");
        PrintCollection(collection);
        collection.add(null);
        collection.add(null);
        System.out.print("Вернули назад. ");
        PrintCollection(collection);
        Iterator <?> iterator = collection.iterator();
        System.out.print("Итератором:");
        while(iterator.hasNext()){
            System.out.print(" " + iterator.next() + ";");
        }
        System.out.println();
        // collection.addAll(Arrays.asList(object)); // не работает
    }

    private static void PrintCollection(Collection <? extends Object> collection){
        System.out.print("Collection:");
        for (Object elem:collection) {
            System.out.print(" " + elem + ";");
        }
        System.out.println();
    }
}
