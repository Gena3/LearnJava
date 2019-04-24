public final class ComplexNumber {
    private final double re;
    private final double im;

    public ComplexNumber(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public double getRe() {
        return re;
    }

    public double getIm() {
        return im;
    }

    @Override
    public boolean equals(Object objCompare){
        boolean         boolRetVaule = true;
        ComplexNumber   clCNNumber;
        do {//single loop for break by error or not equal
            if (objCompare == this) break; // If the object is itself then true
            if (!(objCompare instanceof ComplexNumber)) {// if wrong class then false
                boolRetVaule = false;
                break;
            }
            clCNNumber = (ComplexNumber) objCompare;
            boolRetVaule = Double.compare(clCNNumber.getIm(), this.im) == 0 && Double.compare(clCNNumber.getRe(), this.re) == 0;
        }while(false);
        return boolRetVaule;
    }

    @Override
    public int hashCode(){
        int iRetValue = 1;
        final int iPrime = 31;
        iRetValue = iPrime * iRetValue + Double.valueOf(this.re).hashCode();
        iRetValue = iPrime * iRetValue + Double.valueOf(this.im).hashCode();
        return iRetValue;
    }

}
