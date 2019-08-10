import java.io.*;
import java.nio.charset.StandardCharsets;

// Это программа создана для проверки теоретических вопросов при прохождении курсов
// на степике
public class MainClass {
    public static void main(String[] args){
        //Вопрос:
        /*
        Рассмотрим следующий код:
        Writer writer = new OutputStreamWriter(outputStream, StandardCharsets.US_ASCII);
        Что будет фактически записано в outputStream, если мы попытаемся вывести через writer символ,
        не представимый в указанной ему кодировке ASCII? Например, какой-нибудь иероглиф или символ кириллицы.
         */
        try(Writer writer = new OutputStreamWriter(System.out, StandardCharsets.US_ASCII))
        {
            writer.write("我叫葛納金");
        }catch (IOException ioE){
            System.out.println(ioE.getMessage());
        }
    }

}
