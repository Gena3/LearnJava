import java.io.ByteArrayInputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        byte[] arr = {65, 66, 13, 13, 10, 10, 13, 67, 13, 10};
        int iCurr = -1;
        int iPrev;
        System.setIn(new ByteArrayInputStream(arr));
        while(true){
            iPrev = iCurr;
            iCurr = System.in.read();
            if(iCurr == -1){
                if(iPrev >= 0) System.out.print(iPrev);
                break;
            }
            if ((iCurr == 10 && iPrev == 13) || iPrev == -1) continue;
            System.out.print(iPrev);
        }
        System.out.flush();
    }
}
