package TextAnalyzer;

public class TooLongTextAnalyzer
        implements TextAnalyzer{

    private final int _maxLength;

    public TooLongTextAnalyzer(int iLength){
        // проверку бы на отрицательное, но по заданию не требуется. Может потом сделаю
        _maxLength = iLength;
    }

    @Override
    public final Label processText(String text){
        Label label2return = Label.OK;// Просто не лююблю, когда точек выхода больше 1
        if(text.length() > _maxLength) label2return = Label.TOO_LONG;
        return label2return;
    }
}