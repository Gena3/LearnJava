import java.util.HashSet;
import java.util.Set;

public class Main {
    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2){
        Set<T> retSet = new HashSet<>();
        for (T elem: set1) {
            if (!(set2.contains(elem))){
                retSet.add(elem);
            }
        }
        for (T elem: set2) {
            if (!(set1.contains(elem))){
                retSet.add(elem);
            }
        }
        return retSet;
    }

    public static <T> Set<T> symmetricDifference1(Set<? extends T> set1, Set<? extends T> set2){
        Set<T> retSet = new HashSet<>();
        Set<T> tempSet = new HashSet<>();
        retSet.addAll(set1);
        retSet.removeAll(set2);
        tempSet.addAll(set2);
        tempSet.removeAll(set1);
        retSet.addAll(tempSet);
        return retSet;
    }

    public static void main(String[] args){

        Set<Integer> num1 = new HashSet<>();
        num1.add(1);
        num1.add(2);
        num1.add(3);
        num1.add(4);

        HashSet<Integer> num2 = new HashSet<>();
        num2.add(3);
        num2.add(4);
        num2.add(5);
        num2.add(6);
        long lStart =  System.nanoTime();
        for(int i = 0; i < 10000; i++){
            Set<Integer> result = symmetricDifference(num1,num2);
        }
        System.out.println("Iterator: " + (System.nanoTime() - lStart));
        lStart =  System.nanoTime();
        for(int i = 0; i < 10000; i++){
            Set<Integer> result = symmetricDifference1(num1,num2);
        }
        System.out.println("No iterator: " + (System.nanoTime() - lStart));
        // на итераторе быстрее

        // System.out.println(result);
    }
}
