import java.util.LinkedList;
import java.util.Scanner;
import java.io.ByteArrayInputStream;

public class Main {
    public static void main(String[] args) {
        Scanner objScanner;

        // todo: Стереть тестовый блок
        String strTest = "1 2 3 4 5 6 7";
        System.setIn(new ByteArrayInputStream(strTest.getBytes()));
        // конец тестового блока

        objScanner = new Scanner(System.in);

        /* Не прокатило по времени
        StringBuilder sb = new StringBuilder();
        boolean boolWrite = false;
        while (objScanner.hasNextInt()) {
            if (boolWrite) {
                sb.insert(0, String.format("%d ", objScanner.nextInt()));
                boolWrite = false;
            } else {
                boolWrite = true;
                objScanner.next();
            }
        }
        System.out.println(sb.toString().trim());*/

        LinkedList <Integer> linkedListInt = new LinkedList<>();
        while (objScanner.hasNextInt()) {
            objScanner.next();
            if (!(objScanner.hasNextInt())) break;
            linkedListInt.push(objScanner.nextInt());
        }
        objScanner.close();
        if(!(linkedListInt.isEmpty())) {
            while (linkedListInt.size() > 1) System.out.print(linkedListInt.pop() + " ");
            System.out.print(linkedListInt.pop());
        }
    }
}
