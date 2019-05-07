import java.lang.CharSequence;

public class AsciiCharSequence
    implements CharSequence{
    byte[] _sequence;

    public AsciiCharSequence(byte[] byteArray){
        _sequence = new byte[byteArray.length];
        System.arraycopy(byteArray, 0, _sequence, 0, byteArray.length);
    }

    @Override
    public int length() {
        return _sequence.length;
    }

    @Override
    public char charAt(int index) {
        return (char) _sequence[index];
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        byte[] subBytes = new byte[end - start];
        System.arraycopy(_sequence, start, subBytes, 0, end - start);
        return new AsciiCharSequence(subBytes);
    }

    @Override
    public String toString() {
        return new String(_sequence);
    }
}
