import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Double  dResult = .0;
        Scanner objScanner;
        // ************ подсуним тестовый данные ***************
        String strTest = "100 10,05 sdfasdf 1e3\n9.95";
        ByteArrayInputStream bArr = new ByteArrayInputStream(strTest.getBytes());
        System.setIn(bArr);
        // *********** конец блока тестовых данных *************
        objScanner = new Scanner(System.in);
        while (objScanner.hasNext()){
            if(objScanner.hasNextDouble())
                dResult = dResult + objScanner.nextDouble();
            else
                objScanner.next();
        }
        objScanner.close();
        System.out.format("%.6f",dResult);
    }
}
