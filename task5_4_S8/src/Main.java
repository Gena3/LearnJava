import java.io.*;
import java.lang.IllegalArgumentException;
import java.time.DayOfWeek;

public class Main {

    public static Animal[] deserializeAnimalArray(byte[] data) throws IllegalArgumentException{
        Animal[] animals = null;
        int iCountOfAnimals;
        try(ByteArrayInputStream bais = new ByteArrayInputStream(data); ObjectInputStream ois = new ObjectInputStream(bais)){
            iCountOfAnimals = ois.readInt();
            animals = new Animal[iCountOfAnimals];
            for(int i = 0; i < iCountOfAnimals; i++){
                animals[i] = (Animal) ois.readObject();
            }
        }catch(Exception e){
            throw new java.lang.IllegalArgumentException(e.getMessage());
        }
        return animals;
    }

    public static void main(String[] args) throws IOException {
        int iCountOfAnimals;
        Animal[] animals = {new Animal("Cat"), new Animal("Dog"), new Animal("Rat"), new Animal("Crocodile")};
        Animal[] animalsRet = null;
        try(ByteArrayOutputStream baos = new ByteArrayOutputStream(); ObjectOutputStream oos = new ObjectOutputStream(baos)){
            oos.writeInt(animals.length);
            for(int i = 0; i < animals.length; i++) oos.writeObject(animals[i]);
            oos.flush();
            oos.close();
            animalsRet = deserializeAnimalArray(baos.toByteArray());
            iCountOfAnimals = animalsRet.length;
            for(int i = 0; i < iCountOfAnimals; i++) System.out.println("Animal № " + i + " = " + animals[i].getName());
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        Object obj = new String("Privet");
        TestOptional <? extends Integer> var1;
        TestOptional <Object> var2 = new TestOptional<Object>("String");
        TestOptional <DayOfWeek> var3;
        TestOptional <CharSequence> var4;

        var2.someMethod(obj);
        // TestOptional <42> var5;
        //TestOptional <String::trim> var6;
        // TestOptional <int> var7;
        // TestOptional <> var8;

    }
}
