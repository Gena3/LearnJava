import java.lang.Math;
import java.math.BigInteger;
import java.io.*;
import java.util.Arrays;

public class App {
    public static boolean booleanExpression(boolean a, boolean b, boolean c, boolean d) {
        return ((a ? 1 : 0) + (b ? 1 : 0) + (c ? 1 : 0) + (d ? 1 : 0)) == 2;
    }
    public static int leapYearCount(int year) {
        int iCountOfYears = 0;
        if(year > 0){
            iCountOfYears = year / 4 - year / 100 + year / 400;
        }
        return iCountOfYears;
    }
    public static boolean doubleExpression(double a, double b, double c) {
        return Math.abs(a + b - c) < 0.0001d;
    }
    /**
     * Flips one bit of the given <code>value</code>.
     *
     * @param value     any number
     * @param bitIndex  index of the bit to flip, 1 <= bitIndex <= 32
     * @return new value with one bit flipped
     */
    public static int flipBit(int value, int bitIndex) {
        if((bitIndex >= 1) || (bitIndex <= 32)){
            value ^= (1 << (bitIndex - 1));
        }
        return value;
    }

    public static char charExpression(int a) {
        return (char)('\\' + a);
    }
    /**
     * Checks if given <code>value</code> is a power of two.
     *
     * @param value any number
     * @return <code>true</code> when <code>value</code> is power of two, <code>false</code> otherwise
     */
    public static boolean isPowerOfTwo(int value) {
        boolean boolIsPow2;
        value = Math.abs(value);
        boolIsPow2 = value > 0;
        for(int i = 16, j = 0xFFFF; i > 0 && boolIsPow2; i /= 2, j = j >> i){
            boolIsPow2 = (value >> i) * (value & j) == 0;
            value = (value >> i) | (value & j);
        }
        return boolIsPow2;
    }
    /**
     * Calculates factorial of given <code>value</code>.
     *
     * @param value positive number，
     * @return factorial of <code>value</code>
     * if value < 0, then return null
     */
    public static BigInteger factorial(int value) {
        BigInteger biReturnValue = null;
        if(value >= 0){
            biReturnValue = BigInteger.valueOf(1);
            for(int i = 2; i < value; i++) biReturnValue = biReturnValue.multiply(BigInteger.valueOf((long)i));
            biReturnValue = biReturnValue.multiply(BigInteger.valueOf((long)value));
        }
        return biReturnValue; // your implementation here
    }

    public static boolean isPalindrome(String text) {
        String  strChangedString = text.replaceAll("[^a-zA-Z0-9]", "");
        int     iLengthOfText = strChangedString.length();
        boolean boolRetValue = (1 >= iLengthOfText);
        StringBuilder       sbReverseHalfString;
        if(!boolRetValue){
            sbReverseHalfString = new StringBuilder(strChangedString.substring(iLengthOfText - iLengthOfText/2));
            sbReverseHalfString.reverse();
            boolRetValue =  sbReverseHalfString.toString().equalsIgnoreCase(strChangedString.substring(0,iLengthOfText/2));
        }
        return boolRetValue;
    }

    /**
     * Merges two given sorted arrays into one
     *
     * @param a1 first sorted array
     * @param a2 second sorted array
     * @return new array containing all elements from a1 and a2, sorted
     */
    public static int[] mergeArrays(int[] a1, int[] a2) {
        int[] resultArray = null;
        int iSizeOfArray, iIndexA1 = 0, iIndexA2 = 0, iIndexRetA = 0;

        do{// single loop for break by error
            iSizeOfArray = a1.length + a2.length;
            // if size of result array > MAX_INT then return null
            if (iSizeOfArray < 0) break;  // return null
            resultArray = new int[iSizeOfArray];
            for(;iIndexA1 < a1.length && iIndexA2 < a2.length; iIndexRetA++){
                resultArray[iIndexRetA] = a1[iIndexA1] <= a2[iIndexA2] ? a1[iIndexA1++] : a2[iIndexA2++];
            }
            for(;iIndexA1 < a1.length; iIndexA1++, iIndexRetA++){
                resultArray[iIndexRetA] = a1[iIndexA1];
            }
            for(;iIndexA2 < a2.length; iIndexA2++, iIndexRetA++){
                resultArray[iIndexRetA] = a2[iIndexA2];
            }
        }while(false);
        return resultArray;
    }

    private static String printTextPerRole(String[] roles, String[] textLines) {
        String          strRole;
        int             iPosition;
        StringBuilder   strbuildReturnString = new StringBuilder();
        for(int i = 0; i < roles.length; i++) {
            strRole = roles[i] + ":";
            strbuildReturnString.append(strRole).append("\n");
            iPosition = strRole.length();
            for (int j = 0; j < textLines.length; j++) {
                if(textLines[j].length() <= iPosition) continue;
                if (textLines[j].substring(0, iPosition).equalsIgnoreCase(strRole)) {
                    strbuildReturnString.append(j + 1).append(")").append(textLines[j].substring(iPosition));
                }
            }
            strbuildReturnString.append("\n");
        }
        iPosition = strbuildReturnString.length();
        if (iPosition > 0) strbuildReturnString.substring(0,iPosition - 1);
        return strbuildReturnString.toString();
    }

    public static void main(String[] strCommandLine){
        // for(int i = 0; i < 258; i ++) System.out.println("i = " + i + " power of 2 = " + isPowerOfTwo(i));
        // String stringTestString = new String("This is a test string!");
        // System.out.println(stringTestString.replaceAll("[^a-zA-Z0-9]", ""));
        // System.out.println(isPalindrome("aBA"));
        // System.out.println(factorial(-10));
        // int i = Integer.MAX_VALUE;
        // System.out.println(i);
        // System.out.println(i + 1);
        // int[] a1 = {1}, a2 = {10};
        // System.out.println(Arrays.toString(mergeArrays(a1,a2)));
        // StringBuilder
        String[] a1 = {"Первый", "Второй", "Третий"}, a2 = {"Первый: Мальчишки украли копеечку", "Второй: Украли Первый:", "Третий: Украли Второй:", "Первый: 你好"};
        System.out.println(printTextPerRole(a1,a2));
    }
}
