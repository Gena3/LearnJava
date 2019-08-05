import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.IOException;

public class MainClass {
    public static int checkSumOfStream(InputStream inputStream) throws IOException {
        int     iCheckSum = 0;
        int     iReadedByte;
        while ((iReadedByte = inputStream.read()) > 0){
            iCheckSum = Integer.rotateLeft(iCheckSum, 1) ^ iReadedByte;
        }
        return iCheckSum;
    }

    public static void main(String[] args) throws IOException{
        try(ByteArrayInputStream ba = new ByteArrayInputStream(new byte[] {0x33,0x45,0x01})){
            System.out.println(checkSumOfStream(ba));
        }
        try(ByteArrayInputStream ba = new ByteArrayInputStream(new byte[0])){
            System.out.println(checkSumOfStream(ba));
        }
        // обрабатывать исключения никто не просил. Просто хотел попробовать трай с парметрами.
    }
}
