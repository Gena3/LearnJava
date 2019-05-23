package TextAnalyzer;

public class NegativeTextAnalyzer
extends KeywordAnalyzer{
    private final String[] _keywords;

    public NegativeTextAnalyzer(){
        _keywords = new String[3];
        _keywords[0] = ":(";
        _keywords[1] = "=(";
        _keywords[2] = ":|";
    }

    @Override
    public final String[] getKeywords(){
        return _keywords;
    }

    @Override
    public final Label getLabel(){
        return Label.OK;
    }

    @Override
    public final Label processText(String text){
        return Label.OK;
    }
}
