import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class MainClass {
    public static String readAsString(InputStream inputStream, Charset charset) throws IOException {
        int             iReadChar;
        StringBuilder   sbRetString = new StringBuilder();
        try(Reader reader = new InputStreamReader(inputStream, charset)){
            while ((iReadChar = reader.read()) != -1){
                sbRetString.append((char) iReadChar);
            }
        }
        return new String(sbRetString.toString());
    }
    public static void main(String[] args){
        byte[] arr = {48,49,50,51};
        try(ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(arr)) {
            System.out.println(readAsString(byteArrayInputStream, StandardCharsets.US_ASCII));
        }catch (IOException ioE){
            System.out.println(ioE.getMessage());
        }
    }
}
