public class Main {
    public static void main(String[] args){
        System.out.println("Start");

        Pair<Integer, String> pair = Pair.of(33, "hello");
        Integer i = pair.getFirst(); // 1
        String s = pair.getSecond(); // "hello"

        Pair<Integer, String> pair1 = Pair.of(33, "hello");
        System.out.println("pair == pair1 : " + pair.equals(pair1));
        System.out.println("pair.hashCode() == pair1.hashCode() : " + (pair.hashCode() == pair1.hashCode()));

        Pair<Integer, String> pair2 = Pair.of(22, "hello");
        System.out.println("pair == pair2 : " + pair.equals(pair2));
        System.out.println("pair.hashCode() == pair2.hashCode() : " + (pair.hashCode() == pair2.hashCode()));

        Pair<Integer, String> pair3 = Pair.of(33, "by");
        System.out.println("pair == pair3 : " + pair.equals(pair3));
        System.out.println("pair.hashCode() == pair2.hashCode() : " + (pair.hashCode() == pair3.hashCode()));

        String string = "hello";
        System.out.println("pair == string : " + pair.equals(string));
    }
}
