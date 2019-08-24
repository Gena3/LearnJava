import java.util.Objects;
class Pair <F, S> {
    private final F firstObj;
    private final S secondObj;

    private Pair(F firstObj, S secondObj) {
        this.firstObj = firstObj;
        this.secondObj = secondObj;
    }

    public F getFirst(){
        return firstObj;
    }

    public S getSecond(){
        return secondObj;
    }

    public static <F, S> Pair <F, S> of(F valueF, S valueS){
        return new  Pair <> (valueF, valueS);
    }

    @Override
    public boolean equals(Object obj){
        boolean boolRetValue = false;
        if (this == obj) {
            boolRetValue = true;
        }else if (obj instanceof Pair){
            Pair<F, S> other = (Pair<F, S>) obj;
            boolRetValue =  Objects.equals(other.getFirst(), firstObj) && Objects.equals(other.getSecond(), secondObj);
        }
        return boolRetValue;
    }

    @Override
    public int hashCode(){
        int iRetValue = 1;
        final int iPrime = 31;
        iRetValue = iPrime * iRetValue + this.firstObj.hashCode();
        iRetValue = iPrime * iRetValue + this.secondObj.hashCode();
        return iRetValue;
    }
}