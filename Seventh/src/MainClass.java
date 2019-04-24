public class MainClass {
    public static void main(String[] args){
        ComplexNumber a = new ComplexNumber(10, 2);
        ComplexNumber b = new ComplexNumber(10, 2);
        System.out.println("Equals is " + a.equals(b) + "; Hash(a):" + a.hashCode() + "; Hash(b):" + b.hashCode());
    }
}
